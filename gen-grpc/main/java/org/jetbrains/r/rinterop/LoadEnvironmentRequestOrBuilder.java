// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface LoadEnvironmentRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.LoadEnvironmentRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string file = 1;</code>
   */
  java.lang.String getFile();
  /**
   * <code>string file = 1;</code>
   */
  com.google.protobuf.ByteString
      getFileBytes();

  /**
   * <pre>
   * empty variable name means load into global env
   * </pre>
   *
   * <code>string variable = 2;</code>
   */
  java.lang.String getVariable();
  /**
   * <pre>
   * empty variable name means load into global env
   * </pre>
   *
   * <code>string variable = 2;</code>
   */
  com.google.protobuf.ByteString
      getVariableBytes();
}
