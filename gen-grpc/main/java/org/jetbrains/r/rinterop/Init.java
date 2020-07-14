// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

/**
 * Protobuf type {@code rplugininterop.Init}
 */
public  final class Init extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rplugininterop.Init)
    InitOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Init.newBuilder() to construct.
  private Init(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Init() {
    projectDir_ = "";
    rScriptsPath_ = "";
    workspaceFile_ = "";
    httpUserAgent_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Init();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Init(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            projectDir_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            rScriptsPath_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            workspaceFile_ = s;
            break;
          }
          case 32: {

            loadWorkspace_ = input.readBool();
            break;
          }
          case 40: {

            saveOnExit_ = input.readBool();
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            httpUserAgent_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_Init_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_Init_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.jetbrains.r.rinterop.Init.class, org.jetbrains.r.rinterop.Init.Builder.class);
  }

  public static final int PROJECTDIR_FIELD_NUMBER = 1;
  private volatile java.lang.Object projectDir_;
  /**
   * <code>string projectDir = 1;</code>
   */
  public java.lang.String getProjectDir() {
    java.lang.Object ref = projectDir_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      projectDir_ = s;
      return s;
    }
  }
  /**
   * <code>string projectDir = 1;</code>
   */
  public com.google.protobuf.ByteString
      getProjectDirBytes() {
    java.lang.Object ref = projectDir_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      projectDir_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RSCRIPTSPATH_FIELD_NUMBER = 2;
  private volatile java.lang.Object rScriptsPath_;
  /**
   * <code>string rScriptsPath = 2;</code>
   */
  public java.lang.String getRScriptsPath() {
    java.lang.Object ref = rScriptsPath_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      rScriptsPath_ = s;
      return s;
    }
  }
  /**
   * <code>string rScriptsPath = 2;</code>
   */
  public com.google.protobuf.ByteString
      getRScriptsPathBytes() {
    java.lang.Object ref = rScriptsPath_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      rScriptsPath_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int WORKSPACEFILE_FIELD_NUMBER = 3;
  private volatile java.lang.Object workspaceFile_;
  /**
   * <code>string workspaceFile = 3;</code>
   */
  public java.lang.String getWorkspaceFile() {
    java.lang.Object ref = workspaceFile_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      workspaceFile_ = s;
      return s;
    }
  }
  /**
   * <code>string workspaceFile = 3;</code>
   */
  public com.google.protobuf.ByteString
      getWorkspaceFileBytes() {
    java.lang.Object ref = workspaceFile_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      workspaceFile_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LOADWORKSPACE_FIELD_NUMBER = 4;
  private boolean loadWorkspace_;
  /**
   * <code>bool loadWorkspace = 4;</code>
   */
  public boolean getLoadWorkspace() {
    return loadWorkspace_;
  }

  public static final int SAVEONEXIT_FIELD_NUMBER = 5;
  private boolean saveOnExit_;
  /**
   * <code>bool saveOnExit = 5;</code>
   */
  public boolean getSaveOnExit() {
    return saveOnExit_;
  }

  public static final int HTTPUSERAGENT_FIELD_NUMBER = 6;
  private volatile java.lang.Object httpUserAgent_;
  /**
   * <code>string httpUserAgent = 6;</code>
   */
  public java.lang.String getHttpUserAgent() {
    java.lang.Object ref = httpUserAgent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      httpUserAgent_ = s;
      return s;
    }
  }
  /**
   * <code>string httpUserAgent = 6;</code>
   */
  public com.google.protobuf.ByteString
      getHttpUserAgentBytes() {
    java.lang.Object ref = httpUserAgent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      httpUserAgent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getProjectDirBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, projectDir_);
    }
    if (!getRScriptsPathBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, rScriptsPath_);
    }
    if (!getWorkspaceFileBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, workspaceFile_);
    }
    if (loadWorkspace_ != false) {
      output.writeBool(4, loadWorkspace_);
    }
    if (saveOnExit_ != false) {
      output.writeBool(5, saveOnExit_);
    }
    if (!getHttpUserAgentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, httpUserAgent_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getProjectDirBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, projectDir_);
    }
    if (!getRScriptsPathBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, rScriptsPath_);
    }
    if (!getWorkspaceFileBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, workspaceFile_);
    }
    if (loadWorkspace_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, loadWorkspace_);
    }
    if (saveOnExit_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(5, saveOnExit_);
    }
    if (!getHttpUserAgentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, httpUserAgent_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.jetbrains.r.rinterop.Init)) {
      return super.equals(obj);
    }
    org.jetbrains.r.rinterop.Init other = (org.jetbrains.r.rinterop.Init) obj;

    if (!getProjectDir()
        .equals(other.getProjectDir())) return false;
    if (!getRScriptsPath()
        .equals(other.getRScriptsPath())) return false;
    if (!getWorkspaceFile()
        .equals(other.getWorkspaceFile())) return false;
    if (getLoadWorkspace()
        != other.getLoadWorkspace()) return false;
    if (getSaveOnExit()
        != other.getSaveOnExit()) return false;
    if (!getHttpUserAgent()
        .equals(other.getHttpUserAgent())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PROJECTDIR_FIELD_NUMBER;
    hash = (53 * hash) + getProjectDir().hashCode();
    hash = (37 * hash) + RSCRIPTSPATH_FIELD_NUMBER;
    hash = (53 * hash) + getRScriptsPath().hashCode();
    hash = (37 * hash) + WORKSPACEFILE_FIELD_NUMBER;
    hash = (53 * hash) + getWorkspaceFile().hashCode();
    hash = (37 * hash) + LOADWORKSPACE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getLoadWorkspace());
    hash = (37 * hash) + SAVEONEXIT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getSaveOnExit());
    hash = (37 * hash) + HTTPUSERAGENT_FIELD_NUMBER;
    hash = (53 * hash) + getHttpUserAgent().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.jetbrains.r.rinterop.Init parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.Init parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.jetbrains.r.rinterop.Init parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.jetbrains.r.rinterop.Init parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.jetbrains.r.rinterop.Init prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code rplugininterop.Init}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rplugininterop.Init)
      org.jetbrains.r.rinterop.InitOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_Init_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_Init_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.jetbrains.r.rinterop.Init.class, org.jetbrains.r.rinterop.Init.Builder.class);
    }

    // Construct using org.jetbrains.r.rinterop.Init.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      projectDir_ = "";

      rScriptsPath_ = "";

      workspaceFile_ = "";

      loadWorkspace_ = false;

      saveOnExit_ = false;

      httpUserAgent_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_Init_descriptor;
    }

    @java.lang.Override
    public org.jetbrains.r.rinterop.Init getDefaultInstanceForType() {
      return org.jetbrains.r.rinterop.Init.getDefaultInstance();
    }

    @java.lang.Override
    public org.jetbrains.r.rinterop.Init build() {
      org.jetbrains.r.rinterop.Init result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.jetbrains.r.rinterop.Init buildPartial() {
      org.jetbrains.r.rinterop.Init result = new org.jetbrains.r.rinterop.Init(this);
      result.projectDir_ = projectDir_;
      result.rScriptsPath_ = rScriptsPath_;
      result.workspaceFile_ = workspaceFile_;
      result.loadWorkspace_ = loadWorkspace_;
      result.saveOnExit_ = saveOnExit_;
      result.httpUserAgent_ = httpUserAgent_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.jetbrains.r.rinterop.Init) {
        return mergeFrom((org.jetbrains.r.rinterop.Init)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.jetbrains.r.rinterop.Init other) {
      if (other == org.jetbrains.r.rinterop.Init.getDefaultInstance()) return this;
      if (!other.getProjectDir().isEmpty()) {
        projectDir_ = other.projectDir_;
        onChanged();
      }
      if (!other.getRScriptsPath().isEmpty()) {
        rScriptsPath_ = other.rScriptsPath_;
        onChanged();
      }
      if (!other.getWorkspaceFile().isEmpty()) {
        workspaceFile_ = other.workspaceFile_;
        onChanged();
      }
      if (other.getLoadWorkspace() != false) {
        setLoadWorkspace(other.getLoadWorkspace());
      }
      if (other.getSaveOnExit() != false) {
        setSaveOnExit(other.getSaveOnExit());
      }
      if (!other.getHttpUserAgent().isEmpty()) {
        httpUserAgent_ = other.httpUserAgent_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.jetbrains.r.rinterop.Init parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.jetbrains.r.rinterop.Init) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object projectDir_ = "";
    /**
     * <code>string projectDir = 1;</code>
     */
    public java.lang.String getProjectDir() {
      java.lang.Object ref = projectDir_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        projectDir_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string projectDir = 1;</code>
     */
    public com.google.protobuf.ByteString
        getProjectDirBytes() {
      java.lang.Object ref = projectDir_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        projectDir_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string projectDir = 1;</code>
     */
    public Builder setProjectDir(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      projectDir_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string projectDir = 1;</code>
     */
    public Builder clearProjectDir() {
      
      projectDir_ = getDefaultInstance().getProjectDir();
      onChanged();
      return this;
    }
    /**
     * <code>string projectDir = 1;</code>
     */
    public Builder setProjectDirBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      projectDir_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object rScriptsPath_ = "";
    /**
     * <code>string rScriptsPath = 2;</code>
     */
    public java.lang.String getRScriptsPath() {
      java.lang.Object ref = rScriptsPath_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        rScriptsPath_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string rScriptsPath = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRScriptsPathBytes() {
      java.lang.Object ref = rScriptsPath_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        rScriptsPath_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string rScriptsPath = 2;</code>
     */
    public Builder setRScriptsPath(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      rScriptsPath_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string rScriptsPath = 2;</code>
     */
    public Builder clearRScriptsPath() {
      
      rScriptsPath_ = getDefaultInstance().getRScriptsPath();
      onChanged();
      return this;
    }
    /**
     * <code>string rScriptsPath = 2;</code>
     */
    public Builder setRScriptsPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      rScriptsPath_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object workspaceFile_ = "";
    /**
     * <code>string workspaceFile = 3;</code>
     */
    public java.lang.String getWorkspaceFile() {
      java.lang.Object ref = workspaceFile_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        workspaceFile_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string workspaceFile = 3;</code>
     */
    public com.google.protobuf.ByteString
        getWorkspaceFileBytes() {
      java.lang.Object ref = workspaceFile_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        workspaceFile_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string workspaceFile = 3;</code>
     */
    public Builder setWorkspaceFile(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      workspaceFile_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string workspaceFile = 3;</code>
     */
    public Builder clearWorkspaceFile() {
      
      workspaceFile_ = getDefaultInstance().getWorkspaceFile();
      onChanged();
      return this;
    }
    /**
     * <code>string workspaceFile = 3;</code>
     */
    public Builder setWorkspaceFileBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      workspaceFile_ = value;
      onChanged();
      return this;
    }

    private boolean loadWorkspace_ ;
    /**
     * <code>bool loadWorkspace = 4;</code>
     */
    public boolean getLoadWorkspace() {
      return loadWorkspace_;
    }
    /**
     * <code>bool loadWorkspace = 4;</code>
     */
    public Builder setLoadWorkspace(boolean value) {
      
      loadWorkspace_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool loadWorkspace = 4;</code>
     */
    public Builder clearLoadWorkspace() {
      
      loadWorkspace_ = false;
      onChanged();
      return this;
    }

    private boolean saveOnExit_ ;
    /**
     * <code>bool saveOnExit = 5;</code>
     */
    public boolean getSaveOnExit() {
      return saveOnExit_;
    }
    /**
     * <code>bool saveOnExit = 5;</code>
     */
    public Builder setSaveOnExit(boolean value) {
      
      saveOnExit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool saveOnExit = 5;</code>
     */
    public Builder clearSaveOnExit() {
      
      saveOnExit_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object httpUserAgent_ = "";
    /**
     * <code>string httpUserAgent = 6;</code>
     */
    public java.lang.String getHttpUserAgent() {
      java.lang.Object ref = httpUserAgent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        httpUserAgent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string httpUserAgent = 6;</code>
     */
    public com.google.protobuf.ByteString
        getHttpUserAgentBytes() {
      java.lang.Object ref = httpUserAgent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        httpUserAgent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string httpUserAgent = 6;</code>
     */
    public Builder setHttpUserAgent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      httpUserAgent_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string httpUserAgent = 6;</code>
     */
    public Builder clearHttpUserAgent() {
      
      httpUserAgent_ = getDefaultInstance().getHttpUserAgent();
      onChanged();
      return this;
    }
    /**
     * <code>string httpUserAgent = 6;</code>
     */
    public Builder setHttpUserAgentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      httpUserAgent_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:rplugininterop.Init)
  }

  // @@protoc_insertion_point(class_scope:rplugininterop.Init)
  private static final org.jetbrains.r.rinterop.Init DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.jetbrains.r.rinterop.Init();
  }

  public static org.jetbrains.r.rinterop.Init getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Init>
      PARSER = new com.google.protobuf.AbstractParser<Init>() {
    @java.lang.Override
    public Init parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Init(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Init> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Init> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.jetbrains.r.rinterop.Init getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

