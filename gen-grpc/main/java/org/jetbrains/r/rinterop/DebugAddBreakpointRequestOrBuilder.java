// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface DebugAddBreakpointRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.DebugAddBreakpointRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.rplugininterop.SourcePosition position = 1;</code>
   */
  boolean hasPosition();
  /**
   * <code>.rplugininterop.SourcePosition position = 1;</code>
   */
  org.jetbrains.r.rinterop.SourcePosition getPosition();
  /**
   * <code>.rplugininterop.SourcePosition position = 1;</code>
   */
  org.jetbrains.r.rinterop.SourcePositionOrBuilder getPositionOrBuilder();

  /**
   * <code>bool suspend = 2;</code>
   */
  boolean getSuspend();

  /**
   * <code>string evaluateAndLog = 3;</code>
   */
  java.lang.String getEvaluateAndLog();
  /**
   * <code>string evaluateAndLog = 3;</code>
   */
  com.google.protobuf.ByteString
      getEvaluateAndLogBytes();

  /**
   * <code>string condition = 4;</code>
   */
  java.lang.String getCondition();
  /**
   * <code>string condition = 4;</code>
   */
  com.google.protobuf.ByteString
      getConditionBytes();
}
