// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface ConvertRd2HTMLRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.ConvertRd2HTMLRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string rdFilePath = 1;</code>
   */
  java.lang.String getRdFilePath();
  /**
   * <code>string rdFilePath = 1;</code>
   */
  com.google.protobuf.ByteString
      getRdFilePathBytes();

  /**
   * <code>.rplugininterop.ConvertRd2HTMLRequest.DBRequest dbRequest = 2;</code>
   */
  boolean hasDbRequest();
  /**
   * <code>.rplugininterop.ConvertRd2HTMLRequest.DBRequest dbRequest = 2;</code>
   */
  org.jetbrains.r.rinterop.ConvertRd2HTMLRequest.DBRequest getDbRequest();
  /**
   * <code>.rplugininterop.ConvertRd2HTMLRequest.DBRequest dbRequest = 2;</code>
   */
  org.jetbrains.r.rinterop.ConvertRd2HTMLRequest.DBRequestOrBuilder getDbRequestOrBuilder();

  /**
   * <code>string outputFilePath = 3;</code>
   */
  java.lang.String getOutputFilePath();
  /**
   * <code>string outputFilePath = 3;</code>
   */
  com.google.protobuf.ByteString
      getOutputFilePathBytes();

  /**
   * <code>string topicPackage = 4;</code>
   */
  java.lang.String getTopicPackage();
  /**
   * <code>string topicPackage = 4;</code>
   */
  com.google.protobuf.ByteString
      getTopicPackageBytes();

  public org.jetbrains.r.rinterop.ConvertRd2HTMLRequest.RdSourceCase getRdSourceCase();
}
