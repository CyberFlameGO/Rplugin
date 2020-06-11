// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.jetbrains.r.rinterop;

/**
 * Protobuf type {@code rplugininterop.GraphicsRescaleStoredRequest}
 */
public  final class GraphicsRescaleStoredRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rplugininterop.GraphicsRescaleStoredRequest)
    GraphicsRescaleStoredRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GraphicsRescaleStoredRequest.newBuilder() to construct.
  private GraphicsRescaleStoredRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GraphicsRescaleStoredRequest() {
    parentDirectory_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GraphicsRescaleStoredRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GraphicsRescaleStoredRequest(
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

            parentDirectory_ = s;
            break;
          }
          case 16: {

            snapshotNumber_ = input.readInt32();
            break;
          }
          case 24: {

            snapshotVersion_ = input.readInt32();
            break;
          }
          case 34: {
            org.jetbrains.r.rinterop.ScreenParameters.Builder subBuilder = null;
            if (newParameters_ != null) {
              subBuilder = newParameters_.toBuilder();
            }
            newParameters_ = input.readMessage(org.jetbrains.r.rinterop.ScreenParameters.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(newParameters_);
              newParameters_ = subBuilder.buildPartial();
            }

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
    return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_GraphicsRescaleStoredRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_GraphicsRescaleStoredRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest.class, org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest.Builder.class);
  }

  public static final int PARENTDIRECTORY_FIELD_NUMBER = 1;
  private volatile java.lang.Object parentDirectory_;
  /**
   * <code>string parentDirectory = 1;</code>
   */
  public java.lang.String getParentDirectory() {
    java.lang.Object ref = parentDirectory_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      parentDirectory_ = s;
      return s;
    }
  }
  /**
   * <code>string parentDirectory = 1;</code>
   */
  public com.google.protobuf.ByteString
      getParentDirectoryBytes() {
    java.lang.Object ref = parentDirectory_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      parentDirectory_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SNAPSHOTNUMBER_FIELD_NUMBER = 2;
  private int snapshotNumber_;
  /**
   * <code>int32 snapshotNumber = 2;</code>
   */
  public int getSnapshotNumber() {
    return snapshotNumber_;
  }

  public static final int SNAPSHOTVERSION_FIELD_NUMBER = 3;
  private int snapshotVersion_;
  /**
   * <code>int32 snapshotVersion = 3;</code>
   */
  public int getSnapshotVersion() {
    return snapshotVersion_;
  }

  public static final int NEWPARAMETERS_FIELD_NUMBER = 4;
  private org.jetbrains.r.rinterop.ScreenParameters newParameters_;
  /**
   * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
   */
  public boolean hasNewParameters() {
    return newParameters_ != null;
  }
  /**
   * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
   */
  public org.jetbrains.r.rinterop.ScreenParameters getNewParameters() {
    return newParameters_ == null ? org.jetbrains.r.rinterop.ScreenParameters.getDefaultInstance() : newParameters_;
  }
  /**
   * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
   */
  public org.jetbrains.r.rinterop.ScreenParametersOrBuilder getNewParametersOrBuilder() {
    return getNewParameters();
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
    if (!getParentDirectoryBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, parentDirectory_);
    }
    if (snapshotNumber_ != 0) {
      output.writeInt32(2, snapshotNumber_);
    }
    if (snapshotVersion_ != 0) {
      output.writeInt32(3, snapshotVersion_);
    }
    if (newParameters_ != null) {
      output.writeMessage(4, getNewParameters());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getParentDirectoryBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, parentDirectory_);
    }
    if (snapshotNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, snapshotNumber_);
    }
    if (snapshotVersion_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, snapshotVersion_);
    }
    if (newParameters_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getNewParameters());
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
    if (!(obj instanceof org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest)) {
      return super.equals(obj);
    }
    org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest other = (org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest) obj;

    if (!getParentDirectory()
        .equals(other.getParentDirectory())) return false;
    if (getSnapshotNumber()
        != other.getSnapshotNumber()) return false;
    if (getSnapshotVersion()
        != other.getSnapshotVersion()) return false;
    if (hasNewParameters() != other.hasNewParameters()) return false;
    if (hasNewParameters()) {
      if (!getNewParameters()
          .equals(other.getNewParameters())) return false;
    }
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
    hash = (37 * hash) + PARENTDIRECTORY_FIELD_NUMBER;
    hash = (53 * hash) + getParentDirectory().hashCode();
    hash = (37 * hash) + SNAPSHOTNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getSnapshotNumber();
    hash = (37 * hash) + SNAPSHOTVERSION_FIELD_NUMBER;
    hash = (53 * hash) + getSnapshotVersion();
    if (hasNewParameters()) {
      hash = (37 * hash) + NEWPARAMETERS_FIELD_NUMBER;
      hash = (53 * hash) + getNewParameters().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parseFrom(
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
  public static Builder newBuilder(org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest prototype) {
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
   * Protobuf type {@code rplugininterop.GraphicsRescaleStoredRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rplugininterop.GraphicsRescaleStoredRequest)
      org.jetbrains.r.rinterop.GraphicsRescaleStoredRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_GraphicsRescaleStoredRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_GraphicsRescaleStoredRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest.class, org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest.Builder.class);
    }

    // Construct using org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest.newBuilder()
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
      parentDirectory_ = "";

      snapshotNumber_ = 0;

      snapshotVersion_ = 0;

      if (newParametersBuilder_ == null) {
        newParameters_ = null;
      } else {
        newParameters_ = null;
        newParametersBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.jetbrains.r.rinterop.Service.internal_static_rplugininterop_GraphicsRescaleStoredRequest_descriptor;
    }

    @java.lang.Override
    public org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest getDefaultInstanceForType() {
      return org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest build() {
      org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest buildPartial() {
      org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest result = new org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest(this);
      result.parentDirectory_ = parentDirectory_;
      result.snapshotNumber_ = snapshotNumber_;
      result.snapshotVersion_ = snapshotVersion_;
      if (newParametersBuilder_ == null) {
        result.newParameters_ = newParameters_;
      } else {
        result.newParameters_ = newParametersBuilder_.build();
      }
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
      if (other instanceof org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest) {
        return mergeFrom((org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest other) {
      if (other == org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest.getDefaultInstance()) return this;
      if (!other.getParentDirectory().isEmpty()) {
        parentDirectory_ = other.parentDirectory_;
        onChanged();
      }
      if (other.getSnapshotNumber() != 0) {
        setSnapshotNumber(other.getSnapshotNumber());
      }
      if (other.getSnapshotVersion() != 0) {
        setSnapshotVersion(other.getSnapshotVersion());
      }
      if (other.hasNewParameters()) {
        mergeNewParameters(other.getNewParameters());
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
      org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object parentDirectory_ = "";
    /**
     * <code>string parentDirectory = 1;</code>
     */
    public java.lang.String getParentDirectory() {
      java.lang.Object ref = parentDirectory_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        parentDirectory_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string parentDirectory = 1;</code>
     */
    public com.google.protobuf.ByteString
        getParentDirectoryBytes() {
      java.lang.Object ref = parentDirectory_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        parentDirectory_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string parentDirectory = 1;</code>
     */
    public Builder setParentDirectory(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      parentDirectory_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string parentDirectory = 1;</code>
     */
    public Builder clearParentDirectory() {
      
      parentDirectory_ = getDefaultInstance().getParentDirectory();
      onChanged();
      return this;
    }
    /**
     * <code>string parentDirectory = 1;</code>
     */
    public Builder setParentDirectoryBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      parentDirectory_ = value;
      onChanged();
      return this;
    }

    private int snapshotNumber_ ;
    /**
     * <code>int32 snapshotNumber = 2;</code>
     */
    public int getSnapshotNumber() {
      return snapshotNumber_;
    }
    /**
     * <code>int32 snapshotNumber = 2;</code>
     */
    public Builder setSnapshotNumber(int value) {
      
      snapshotNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 snapshotNumber = 2;</code>
     */
    public Builder clearSnapshotNumber() {
      
      snapshotNumber_ = 0;
      onChanged();
      return this;
    }

    private int snapshotVersion_ ;
    /**
     * <code>int32 snapshotVersion = 3;</code>
     */
    public int getSnapshotVersion() {
      return snapshotVersion_;
    }
    /**
     * <code>int32 snapshotVersion = 3;</code>
     */
    public Builder setSnapshotVersion(int value) {
      
      snapshotVersion_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 snapshotVersion = 3;</code>
     */
    public Builder clearSnapshotVersion() {
      
      snapshotVersion_ = 0;
      onChanged();
      return this;
    }

    private org.jetbrains.r.rinterop.ScreenParameters newParameters_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.jetbrains.r.rinterop.ScreenParameters, org.jetbrains.r.rinterop.ScreenParameters.Builder, org.jetbrains.r.rinterop.ScreenParametersOrBuilder> newParametersBuilder_;
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public boolean hasNewParameters() {
      return newParametersBuilder_ != null || newParameters_ != null;
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public org.jetbrains.r.rinterop.ScreenParameters getNewParameters() {
      if (newParametersBuilder_ == null) {
        return newParameters_ == null ? org.jetbrains.r.rinterop.ScreenParameters.getDefaultInstance() : newParameters_;
      } else {
        return newParametersBuilder_.getMessage();
      }
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public Builder setNewParameters(org.jetbrains.r.rinterop.ScreenParameters value) {
      if (newParametersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        newParameters_ = value;
        onChanged();
      } else {
        newParametersBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public Builder setNewParameters(
        org.jetbrains.r.rinterop.ScreenParameters.Builder builderForValue) {
      if (newParametersBuilder_ == null) {
        newParameters_ = builderForValue.build();
        onChanged();
      } else {
        newParametersBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public Builder mergeNewParameters(org.jetbrains.r.rinterop.ScreenParameters value) {
      if (newParametersBuilder_ == null) {
        if (newParameters_ != null) {
          newParameters_ =
            org.jetbrains.r.rinterop.ScreenParameters.newBuilder(newParameters_).mergeFrom(value).buildPartial();
        } else {
          newParameters_ = value;
        }
        onChanged();
      } else {
        newParametersBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public Builder clearNewParameters() {
      if (newParametersBuilder_ == null) {
        newParameters_ = null;
        onChanged();
      } else {
        newParameters_ = null;
        newParametersBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public org.jetbrains.r.rinterop.ScreenParameters.Builder getNewParametersBuilder() {
      
      onChanged();
      return getNewParametersFieldBuilder().getBuilder();
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    public org.jetbrains.r.rinterop.ScreenParametersOrBuilder getNewParametersOrBuilder() {
      if (newParametersBuilder_ != null) {
        return newParametersBuilder_.getMessageOrBuilder();
      } else {
        return newParameters_ == null ?
            org.jetbrains.r.rinterop.ScreenParameters.getDefaultInstance() : newParameters_;
      }
    }
    /**
     * <code>.rplugininterop.ScreenParameters newParameters = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.jetbrains.r.rinterop.ScreenParameters, org.jetbrains.r.rinterop.ScreenParameters.Builder, org.jetbrains.r.rinterop.ScreenParametersOrBuilder> 
        getNewParametersFieldBuilder() {
      if (newParametersBuilder_ == null) {
        newParametersBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.jetbrains.r.rinterop.ScreenParameters, org.jetbrains.r.rinterop.ScreenParameters.Builder, org.jetbrains.r.rinterop.ScreenParametersOrBuilder>(
                getNewParameters(),
                getParentForChildren(),
                isClean());
        newParameters_ = null;
      }
      return newParametersBuilder_;
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


    // @@protoc_insertion_point(builder_scope:rplugininterop.GraphicsRescaleStoredRequest)
  }

  // @@protoc_insertion_point(class_scope:rplugininterop.GraphicsRescaleStoredRequest)
  private static final org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest();
  }

  public static org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GraphicsRescaleStoredRequest>
      PARSER = new com.google.protobuf.AbstractParser<GraphicsRescaleStoredRequest>() {
    @java.lang.Override
    public GraphicsRescaleStoredRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GraphicsRescaleStoredRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GraphicsRescaleStoredRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GraphicsRescaleStoredRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.jetbrains.r.rinterop.GraphicsRescaleStoredRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

