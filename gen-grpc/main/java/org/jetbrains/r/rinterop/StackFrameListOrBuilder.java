// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface StackFrameListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.StackFrameList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .rplugininterop.StackFrame frames = 1;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.StackFrame> 
      getFramesList();
  /**
   * <code>repeated .rplugininterop.StackFrame frames = 1;</code>
   */
  org.jetbrains.r.rinterop.StackFrame getFrames(int index);
  /**
   * <code>repeated .rplugininterop.StackFrame frames = 1;</code>
   */
  int getFramesCount();
  /**
   * <code>repeated .rplugininterop.StackFrame frames = 1;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.StackFrameOrBuilder> 
      getFramesOrBuilderList();
  /**
   * <code>repeated .rplugininterop.StackFrame frames = 1;</code>
   */
  org.jetbrains.r.rinterop.StackFrameOrBuilder getFramesOrBuilder(
      int index);
}