// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface DataFrameGetDataResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.DataFrameGetDataResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .rplugininterop.DataFrameGetDataResponse.Column columns = 1;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.DataFrameGetDataResponse.Column> 
      getColumnsList();
  /**
   * <code>repeated .rplugininterop.DataFrameGetDataResponse.Column columns = 1;</code>
   */
  org.jetbrains.r.rinterop.DataFrameGetDataResponse.Column getColumns(int index);
  /**
   * <code>repeated .rplugininterop.DataFrameGetDataResponse.Column columns = 1;</code>
   */
  int getColumnsCount();
  /**
   * <code>repeated .rplugininterop.DataFrameGetDataResponse.Column columns = 1;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.DataFrameGetDataResponse.ColumnOrBuilder> 
      getColumnsOrBuilderList();
  /**
   * <code>repeated .rplugininterop.DataFrameGetDataResponse.Column columns = 1;</code>
   */
  org.jetbrains.r.rinterop.DataFrameGetDataResponse.ColumnOrBuilder getColumnsOrBuilder(
      int index);
}
