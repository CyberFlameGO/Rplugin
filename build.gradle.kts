import com.google.protobuf.gradle.*
import org.gradle.api.JavaVersion.VERSION_11
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.intellij.tasks.PatchPluginXmlTask
import org.jetbrains.intellij.tasks.PrepareSandboxTask
import org.jetbrains.intellij.tasks.PublishTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val CI = System.getenv("CI") != null

val channel = prop("publishChannel")
val platformVersion = prop("platformVersion")

val excludedJars = listOf(
    "java-api.jar",
    "java-impl.jar"
)

buildscript {
    repositories {
        maven ("https://cache-redirector.jetbrains.com/repo1.maven.org/maven2" )
        maven ("https://oss.sonatype.org/content/repositories/snapshots/" )
        maven ("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/intellij-plugin-service" )
    }
    dependencies {
//        classpath ("org.jetbrains.intellij.plugins:gradle-intellij-plugin:0.5.0-SNAPSHOT")
    }
}

dependencies {
    testCompile("org.mockito:mockito-all:1.10.19")
    compile("com.google.protobuf:protobuf-java:3.9.1")
    compile("io.grpc:grpc-stub:1.23.0")
    compile("io.grpc:grpc-protobuf:1.23.0")
    runtimeOnly("io.grpc:grpc-netty-shaded:1.23.0")
    protobuf(files("protos/", "grammars/"))
}

protobuf {
    generatedFilesBaseDir = "$projectDir/gen"
    protoc {
        artifact = "com.google.protobuf:protoc:3.9.1"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.23.0"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

plugins {
    idea
    kotlin("jvm") version "1.3.61"
    id("org.jetbrains.intellij") version "0.4.10"
    id("org.jetbrains.grammarkit") version "2019.2.1"
    id("de.undercouch.download") version "3.4.3"
    id("net.saliman.properties") version "1.4.6"
    id("com.google.protobuf") version "0.8.10"
}

idea {
    module {
        // https://github.com/gradle/kotlin-dsl/issues/537/
        excludeDirs = excludeDirs + file("testData") + file("deps")
    }
}

allprojects {
    apply {
        plugin("org.jetbrains.intellij")
        plugin("idea")
        plugin("kotlin")
        plugin("org.jetbrains.grammarkit")
        plugin("org.jetbrains.intellij")
    }

    repositories {
        mavenCentral()
    }

    intellij {
        version = if (runWithIC()) "IC-2019.3.1" else "PC-2019.3.1"
        downloadSources = !CI
        updateSinceUntilBuild = true
        instrumentCode = false
        ideaDependencyCachePath = dependencyCachePath

        tasks.withType<PatchPluginXmlTask> {
            sinceBuild("${ideaMajor()}.${ideaMinor()}")
            untilBuild("${ideaMajor()}.*")
        }
    }



    tasks.withType<PublishTask> {
        username(prop("publishUsername"))
        password(prop("publishPassword"))
        channels(channel)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            languageVersion = "1.3"
            apiVersion = "1.3"
            freeCompilerArgs = listOf("-Xjvm-default=enable")
        }
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = VERSION_11
        targetCompatibility = VERSION_11
    }

    afterEvaluate {
        val mainSourceSet = sourceSets.getByName("main")
        val mainClassPath = mainSourceSet.compileClasspath
        val exclusion = mainClassPath.filter { it.name in excludedJars }
        mainSourceSet.compileClasspath = mainClassPath - exclusion

        tasks.withType<AbstractTestTask> {
            testLogging {
                if (hasProp("showTestStatus") && prop("showTestStatus").toBoolean()) {
                    events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
                    exceptionFormat = TestExceptionFormat.FULL
                }
            }
        }

        // We need to prevent the platform-specific shared JNA library to loading from the system library paths,
        // because otherwise it can lead to compatibility issues.
        // Also note that IDEA does the same thing at startup, and not only for tests.
        tasks.withType<Test>().configureEach {
            systemProperty("jna.nosys", "true")
        }

        // Some plugins (for example, grammar-kit) may use jitpack.io. It is unstable sometimes, so we use a redirector.
        if (repositories.removeIf { it is MavenArtifactRepository && it.url.toString() == "https://jitpack.io" }) {
            repositories.add(repositories.maven("https://cache-redirector.jetbrains.com/jitpack.io"))
        }
    }
}

project(":") {
    version = "${ideaMajor()}.${ideaMinor()}.${prop("buildNumber")}"
    intellij {
        pluginName = "rplugin"
        setPlugins("markdown", "yaml", if (runWithIC()) "PythonCore:193.5233.102" else "python-ce")
    }

    idea {
        module {
            generatedSourceDirs.add(file("gen"))
        }
    }

    sourceSets {
        main {
            java.srcDirs("src", "gen")
            resources.srcDirs("resources")
        }
        test {
            java.srcDirs("test")
            resources.srcDirs( "testData")
        }
    }

    tasks.processResources {
        outputs.upToDateWhen { false }
    }

    tasks.prepareSandbox {
        doCopyRWrapperTask(this, this@project)
    }

    tasks.prepareTestingSandbox {
        doCopyRWrapperTask(this, this@project)
    }

    tasks.runIde {
        doFirst {
            val prepareSandboxTask = tasks.prepareSandbox.get()
            val name = prepareSandboxTask.pluginName
            delete(prepareSandboxTask.destinationDir.toString() + "/" + name + "/" + name.toLowerCase() + ".jar")
        }
        jvmArgs = listOf("-Dsun.java2d.uiScale.enabled=false", "-Xmx1024M")
    }

    tasks.buildPlugin {
        from("r-helpers")
    }

    dependencies {
        compile(project(":visualisation"))
        testCompile(group = "org.tukaani", name =  "xz", version = "1.8")
    }
}


project(":visualisation") {
    sourceSets {
        main {
            java.srcDirs("src")
            resources.srcDirs("resources")
        }
    }
}

tasks {
    val listRepos by registering(DefaultTask::class)

    listRepos {
        doLast {
            project.repositories.forEach {
                println(it.name)
                if (it is MavenArtifactRepository) {
                    println(it.url)
                }
                if (it is IvyArtifactRepository) {
                    println(it.url)
                }
            }
        }
    }
}

fun hasProp(name: String): Boolean = extra.has(name)

fun prop(name: String): String =
    extra.properties[name] as? String
        ?: error("Property `$name` is not defined in gradle.properties")

fun doCopyRWrapperTask(prepareSandboxTask: PrepareSandboxTask, project: Project) {
    prepareSandboxTask.inputs.files(*(File("rwrapper").takeIf { it.exists() && it.isDirectory }?.list { _, name ->
        name.startsWith("rwrapper") || name.startsWith("R-") || name == "R"
    }?.map { "rwrapper/" + it }?.toTypedArray() ?: emptyArray<String>()))
    prepareSandboxTask.doLast {
        project.copy {
            from("rwrapper/R")
            into(prepareSandboxTask.destinationDir.toString() + "/" + prepareSandboxTask.pluginName + "/R")
        }
        project.copy {
            from("rwrapper")
            include("crashpad_handler*")
            into(prepareSandboxTask.destinationDir.toString() + "/" + prepareSandboxTask.pluginName)
        }
        project.copy {
            from("rwrapper")
            include("R-*/*")
            into(prepareSandboxTask.destinationDir.toString() + "/" + prepareSandboxTask.pluginName)
        }
        project.copy {
            from("rwrapper")
            include("rwrapper*")
            into(prepareSandboxTask.destinationDir.toString() + "/" + prepareSandboxTask.pluginName)
        }
    }
}

val Project.dependencyCachePath get(): String {
    val cachePath = file("${rootProject.projectDir}/deps")
    // If cache path doesn't exist, we need to create it manually
    // because otherwise gradle-intellij-plugin will ignore it
    if (!cachePath.exists()) {
        cachePath.mkdirs()
    }
    return cachePath.absolutePath
}

fun Build_gradle.ideaMinor() = prop("ideaMinor")

fun Build_gradle.ideaMajor() = prop("ideaMajor")

fun Build_gradle.runWithIC() = prop("runWithIC") == "true"