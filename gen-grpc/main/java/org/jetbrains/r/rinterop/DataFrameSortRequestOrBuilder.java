// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface DataFrameSortRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.DataFrameSortRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.rplugininterop.RRef ref = 1;</code>
   */
  boolean hasRef();
  /**
   * <code>.rplugininterop.RRef ref = 1;</code>
   */
  org.jetbrains.r.rinterop.RRef getRef();
  /**
   * <code>.rplugininterop.RRef ref = 1;</code>
   */
  org.jetbrains.r.rinterop.RRefOrBuilder getRefOrBuilder();

  /**
   * <code>repeated .rplugininterop.DataFrameSortRequest.SortKey keys = 2;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.DataFrameSortRequest.SortKey> 
      getKeysList();
  /**
   * <code>repeated .rplugininterop.DataFrameSortRequest.SortKey keys = 2;</code>
   */
  org.jetbrains.r.rinterop.DataFrameSortRequest.SortKey getKeys(int index);
  /**
   * <code>repeated .rplugininterop.DataFrameSortRequest.SortKey keys = 2;</code>
   */
  int getKeysCount();
  /**
   * <code>repeated .rplugininterop.DataFrameSortRequest.SortKey keys = 2;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.DataFrameSortRequest.SortKeyOrBuilder> 
      getKeysOrBuilderList();
  /**
   * <code>repeated .rplugininterop.DataFrameSortRequest.SortKey keys = 2;</code>
   */
  org.jetbrains.r.rinterop.DataFrameSortRequest.SortKeyOrBuilder getKeysOrBuilder(
      int index);
}
