// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface InitOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.Init)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string projectDir = 1;</code>
   */
  java.lang.String getProjectDir();
  /**
   * <code>string projectDir = 1;</code>
   */
  com.google.protobuf.ByteString
      getProjectDirBytes();

  /**
   * <code>string rScriptsPath = 2;</code>
   */
  java.lang.String getRScriptsPath();
  /**
   * <code>string rScriptsPath = 2;</code>
   */
  com.google.protobuf.ByteString
      getRScriptsPathBytes();

  /**
   * <code>string workspaceFile = 3;</code>
   */
  java.lang.String getWorkspaceFile();
  /**
   * <code>string workspaceFile = 3;</code>
   */
  com.google.protobuf.ByteString
      getWorkspaceFileBytes();

  /**
   * <code>bool loadWorkspace = 4;</code>
   */
  boolean getLoadWorkspace();

  /**
   * <code>bool saveOnExit = 5;</code>
   */
  boolean getSaveOnExit();
}
