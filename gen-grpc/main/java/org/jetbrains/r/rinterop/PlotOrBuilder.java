// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

public interface PlotOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rplugininterop.Plot)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .rplugininterop.Font font = 1;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.Font> 
      getFontList();
  /**
   * <code>repeated .rplugininterop.Font font = 1;</code>
   */
  org.jetbrains.r.rinterop.Font getFont(int index);
  /**
   * <code>repeated .rplugininterop.Font font = 1;</code>
   */
  int getFontCount();
  /**
   * <code>repeated .rplugininterop.Font font = 1;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.FontOrBuilder> 
      getFontOrBuilderList();
  /**
   * <code>repeated .rplugininterop.Font font = 1;</code>
   */
  org.jetbrains.r.rinterop.FontOrBuilder getFontOrBuilder(
      int index);

  /**
   * <code>repeated int32 color = 2;</code>
   */
  java.util.List<java.lang.Integer> getColorList();
  /**
   * <code>repeated int32 color = 2;</code>
   */
  int getColorCount();
  /**
   * <code>repeated int32 color = 2;</code>
   */
  int getColor(int index);

  /**
   * <code>repeated .rplugininterop.Stroke stroke = 3;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.Stroke> 
      getStrokeList();
  /**
   * <code>repeated .rplugininterop.Stroke stroke = 3;</code>
   */
  org.jetbrains.r.rinterop.Stroke getStroke(int index);
  /**
   * <code>repeated .rplugininterop.Stroke stroke = 3;</code>
   */
  int getStrokeCount();
  /**
   * <code>repeated .rplugininterop.Stroke stroke = 3;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.StrokeOrBuilder> 
      getStrokeOrBuilderList();
  /**
   * <code>repeated .rplugininterop.Stroke stroke = 3;</code>
   */
  org.jetbrains.r.rinterop.StrokeOrBuilder getStrokeOrBuilder(
      int index);

  /**
   * <code>repeated .rplugininterop.Viewport viewport = 4;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.Viewport> 
      getViewportList();
  /**
   * <code>repeated .rplugininterop.Viewport viewport = 4;</code>
   */
  org.jetbrains.r.rinterop.Viewport getViewport(int index);
  /**
   * <code>repeated .rplugininterop.Viewport viewport = 4;</code>
   */
  int getViewportCount();
  /**
   * <code>repeated .rplugininterop.Viewport viewport = 4;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.ViewportOrBuilder> 
      getViewportOrBuilderList();
  /**
   * <code>repeated .rplugininterop.Viewport viewport = 4;</code>
   */
  org.jetbrains.r.rinterop.ViewportOrBuilder getViewportOrBuilder(
      int index);

  /**
   * <code>repeated .rplugininterop.Layer layer = 5;</code>
   */
  java.util.List<org.jetbrains.r.rinterop.Layer> 
      getLayerList();
  /**
   * <code>repeated .rplugininterop.Layer layer = 5;</code>
   */
  org.jetbrains.r.rinterop.Layer getLayer(int index);
  /**
   * <code>repeated .rplugininterop.Layer layer = 5;</code>
   */
  int getLayerCount();
  /**
   * <code>repeated .rplugininterop.Layer layer = 5;</code>
   */
  java.util.List<? extends org.jetbrains.r.rinterop.LayerOrBuilder> 
      getLayerOrBuilderList();
  /**
   * <code>repeated .rplugininterop.Layer layer = 5;</code>
   */
  org.jetbrains.r.rinterop.LayerOrBuilder getLayerOrBuilder(
      int index);

  /**
   * <code>int32 error = 6;</code>
   */
  int getError();
}