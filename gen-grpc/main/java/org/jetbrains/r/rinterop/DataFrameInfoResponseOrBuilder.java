// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface DataFrameInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.DataFrameInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 nRows = 1;</code>
   * @return The nRows.
   */
  int getNRows();

  /**
   * <code>repeated .rplugininterop.DataFrameInfoResponse.Column columns = 2;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.DataFrameInfoResponse.Column> 
      getColumnsList();
  /**
   * <code>repeated .rplugininterop.DataFrameInfoResponse.Column columns = 2;</code>
   */
  org.jetbrains.r.rinterop.DataFrameInfoResponse.Column getColumns(int index);
  /**
   * <code>repeated .rplugininterop.DataFrameInfoResponse.Column columns = 2;</code>
   */
  int getColumnsCount();
  /**
   * <code>repeated .rplugininterop.DataFrameInfoResponse.Column columns = 2;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.DataFrameInfoResponse.ColumnOrBuilder> 
      getColumnsOrBuilderList();
  /**
   * <code>repeated .rplugininterop.DataFrameInfoResponse.Column columns = 2;</code>
   */
  org.jetbrains.r.rinterop.DataFrameInfoResponse.ColumnOrBuilder getColumnsOrBuilder(
      int index);

  /**
   * <code>bool canRefresh = 3;</code>
   * @return The canRefresh.
   */
  boolean getCanRefresh();
}
