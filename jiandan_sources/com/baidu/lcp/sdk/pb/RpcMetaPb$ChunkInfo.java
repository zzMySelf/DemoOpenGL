package com.baidu.lcp.sdk.pb;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class RpcMetaPb$ChunkInfo extends GeneratedMessageLite implements RpcMetaPb$ChunkInfoOrBuilder {
    public static final int CHUNK_ID_FIELD_NUMBER = 2;
    public static final Parser<RpcMetaPb$ChunkInfo> PARSER = new qw();
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$ChunkInfo defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public long chunkId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long streamId;

    public static final class Builder extends GeneratedMessageLite.Builder<RpcMetaPb$ChunkInfo, Builder> implements RpcMetaPb$ChunkInfoOrBuilder {
        public int bitField0;
        public long chunkId;
        public long streamId;

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearChunkId() {
            this.bitField0 &= -3;
            this.chunkId = 0;
            return this;
        }

        public Builder clearStreamId() {
            this.bitField0 &= -2;
            this.streamId = 0;
            return this;
        }

        public long getChunkId() {
            return this.chunkId;
        }

        public long getStreamId() {
            return this.streamId;
        }

        public boolean hasChunkId() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasStreamId() {
            return (this.bitField0 & 1) == 1;
        }

        public final boolean isInitialized() {
            if (hasStreamId() && hasChunkId()) {
                return true;
            }
            return false;
        }

        public Builder setChunkId(long j) {
            this.bitField0 |= 2;
            this.chunkId = j;
            return this;
        }

        public Builder setStreamId(long j) {
            this.bitField0 |= 1;
            this.streamId = j;
            return this;
        }

        public RpcMetaPb$ChunkInfo build() {
            RpcMetaPb$ChunkInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public RpcMetaPb$ChunkInfo buildPartial() {
            RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = new RpcMetaPb$ChunkInfo((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            long unused = rpcMetaPb$ChunkInfo.streamId = this.streamId;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            long unused2 = rpcMetaPb$ChunkInfo.chunkId = this.chunkId;
            int unused3 = rpcMetaPb$ChunkInfo.bitField0 = i3;
            return rpcMetaPb$ChunkInfo;
        }

        public Builder clear() {
            super.clear();
            this.streamId = 0;
            int i2 = this.bitField0 & -2;
            this.bitField0 = i2;
            this.chunkId = 0;
            this.bitField0 = i2 & -3;
            return this;
        }

        public RpcMetaPb$ChunkInfo getDefaultInstanceForType() {
            return RpcMetaPb$ChunkInfo.getDefaultInstance();
        }

        public Builder mergeFrom(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            if (rpcMetaPb$ChunkInfo == RpcMetaPb$ChunkInfo.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$ChunkInfo.hasStreamId()) {
                setStreamId(rpcMetaPb$ChunkInfo.getStreamId());
            }
            if (rpcMetaPb$ChunkInfo.hasChunkId()) {
                setChunkId(rpcMetaPb$ChunkInfo.getChunkId());
            }
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo;
            RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo2 = null;
            try {
                RpcMetaPb$ChunkInfo parsePartialFrom = RpcMetaPb$ChunkInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                rpcMetaPb$ChunkInfo = (RpcMetaPb$ChunkInfo) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                rpcMetaPb$ChunkInfo2 = rpcMetaPb$ChunkInfo;
            }
            if (rpcMetaPb$ChunkInfo2 != null) {
                mergeFrom(rpcMetaPb$ChunkInfo2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<RpcMetaPb$ChunkInfo> {
        /* renamed from: qw */
        public RpcMetaPb$ChunkInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$ChunkInfo(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo = new RpcMetaPb$ChunkInfo(true);
        defaultInstance = rpcMetaPb$ChunkInfo;
        rpcMetaPb$ChunkInfo.initFields();
    }

    public static RpcMetaPb$ChunkInfo getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.streamId = 0;
        this.chunkId = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static RpcMetaPb$ChunkInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public long getChunkId() {
        return this.chunkId;
    }

    public Parser<RpcMetaPb$ChunkInfo> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        if ((this.bitField0 & 1) == 1) {
            i3 = 0 + CodedOutputStream.computeInt64Size(1, this.streamId);
        }
        if ((this.bitField0 & 2) == 2) {
            i3 += CodedOutputStream.computeInt64Size(2, this.chunkId);
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public long getStreamId() {
        return this.streamId;
    }

    public boolean hasChunkId() {
        return (this.bitField0 & 2) == 2;
    }

    public boolean hasStreamId() {
        return (this.bitField0 & 1) == 1;
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b != -1) {
            return b == 1;
        }
        if (!hasStreamId()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasChunkId()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else {
            this.memoizedIsInitialized = 1;
            return true;
        }
    }

    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0 & 1) == 1) {
            codedOutputStream.writeInt64(1, this.streamId);
        }
        if ((this.bitField0 & 2) == 2) {
            codedOutputStream.writeInt64(2, this.chunkId);
        }
    }

    public static Builder newBuilder(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
        return newBuilder().mergeFrom(rpcMetaPb$ChunkInfo);
    }

    public static RpcMetaPb$ChunkInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public RpcMetaPb$ChunkInfo getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public RpcMetaPb$ChunkInfo(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$ChunkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$ChunkInfo(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$ChunkInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$ChunkInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$ChunkInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 8) {
                        this.bitField0 |= 1;
                        this.streamId = codedInputStream.readInt64();
                    } else if (readTag == 16) {
                        this.bitField0 |= 2;
                        this.chunkId = codedInputStream.readInt64();
                    } else if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                    }
                }
                z = true;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            } catch (Throwable th2) {
                makeExtensionsImmutable();
                throw th2;
            }
        }
        makeExtensionsImmutable();
    }
}
