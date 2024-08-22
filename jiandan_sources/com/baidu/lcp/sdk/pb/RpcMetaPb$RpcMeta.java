package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
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

public final class RpcMetaPb$RpcMeta extends GeneratedMessageLite implements RpcMetaPb$RpcMetaOrBuilder {
    public static final int ACCEPT_COMPRESS_TYPE_FIELD_NUMBER = 9;
    public static final int ATTACHMENT_SIZE_FIELD_NUMBER = 5;
    public static final int AUTHENTICATION_DATA_FIELD_NUMBER = 7;
    public static final int CHUNK_INFO_FIELD_NUMBER = 6;
    public static final int COMPRESS_TYPE_FIELD_NUMBER = 3;
    public static final int CORRELATION_ID_FIELD_NUMBER = 4;
    public static final int NOTIFY_FIELD_NUMBER = 8;
    public static final Parser<RpcMetaPb$RpcMeta> PARSER = new qw();
    public static final int REQUEST_FIELD_NUMBER = 1;
    public static final int RESPONSE_FIELD_NUMBER = 2;
    public static final RpcMetaPb$RpcMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int acceptCompressType;
    public int attachmentSize;
    public ByteString authenticationData;
    public int bitField0;
    public RpcMetaPb$ChunkInfo chunkInfo;
    public int compressType;
    public long correlationId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public RpcMetaPb$RpcNotifyMeta notify;
    public RpcMetaPb$RpcRequestMeta request;
    public RpcMetaPb$RpcResponseMeta response;

    public static final class Builder extends GeneratedMessageLite.Builder<RpcMetaPb$RpcMeta, Builder> implements RpcMetaPb$RpcMetaOrBuilder {
        public int acceptCompressType;
        public int attachmentSize;
        public ByteString authenticationData = ByteString.EMPTY;
        public int bitField0;
        public RpcMetaPb$ChunkInfo chunkInfo = RpcMetaPb$ChunkInfo.getDefaultInstance();
        public int compressType;
        public long correlationId;
        public RpcMetaPb$RpcNotifyMeta notify = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
        public RpcMetaPb$RpcRequestMeta request = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
        public RpcMetaPb$RpcResponseMeta response = RpcMetaPb$RpcResponseMeta.getDefaultInstance();

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearAcceptCompressType() {
            this.bitField0 &= -257;
            this.acceptCompressType = 0;
            return this;
        }

        public Builder clearAttachmentSize() {
            this.bitField0 &= -17;
            this.attachmentSize = 0;
            return this;
        }

        public Builder clearAuthenticationData() {
            this.bitField0 &= -65;
            this.authenticationData = RpcMetaPb$RpcMeta.getDefaultInstance().getAuthenticationData();
            return this;
        }

        public Builder clearChunkInfo() {
            this.chunkInfo = RpcMetaPb$ChunkInfo.getDefaultInstance();
            this.bitField0 &= -33;
            return this;
        }

        public Builder clearCompressType() {
            this.bitField0 &= -5;
            this.compressType = 0;
            return this;
        }

        public Builder clearCorrelationId() {
            this.bitField0 &= -9;
            this.correlationId = 0;
            return this;
        }

        public Builder clearNotify() {
            this.notify = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
            this.bitField0 &= -129;
            return this;
        }

        public Builder clearRequest() {
            this.request = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
            this.bitField0 &= -2;
            return this;
        }

        public Builder clearResponse() {
            this.response = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
            this.bitField0 &= -3;
            return this;
        }

        public int getAcceptCompressType() {
            return this.acceptCompressType;
        }

        public int getAttachmentSize() {
            return this.attachmentSize;
        }

        public ByteString getAuthenticationData() {
            return this.authenticationData;
        }

        public RpcMetaPb$ChunkInfo getChunkInfo() {
            return this.chunkInfo;
        }

        public int getCompressType() {
            return this.compressType;
        }

        public long getCorrelationId() {
            return this.correlationId;
        }

        public RpcMetaPb$RpcNotifyMeta getNotify() {
            return this.notify;
        }

        public RpcMetaPb$RpcRequestMeta getRequest() {
            return this.request;
        }

        public RpcMetaPb$RpcResponseMeta getResponse() {
            return this.response;
        }

        public boolean hasAcceptCompressType() {
            return (this.bitField0 & 256) == 256;
        }

        public boolean hasAttachmentSize() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasAuthenticationData() {
            return (this.bitField0 & 64) == 64;
        }

        public boolean hasChunkInfo() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasCompressType() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasCorrelationId() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasNotify() {
            return (this.bitField0 & 128) == 128;
        }

        public boolean hasRequest() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasResponse() {
            return (this.bitField0 & 2) == 2;
        }

        public final boolean isInitialized() {
            return !hasChunkInfo() || getChunkInfo().isInitialized();
        }

        public Builder mergeChunkInfo(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            if ((this.bitField0 & 32) != 32 || this.chunkInfo == RpcMetaPb$ChunkInfo.getDefaultInstance()) {
                this.chunkInfo = rpcMetaPb$ChunkInfo;
            } else {
                this.chunkInfo = RpcMetaPb$ChunkInfo.newBuilder(this.chunkInfo).mergeFrom(rpcMetaPb$ChunkInfo).buildPartial();
            }
            this.bitField0 |= 32;
            return this;
        }

        public Builder mergeNotify(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            if ((this.bitField0 & 128) != 128 || this.notify == RpcMetaPb$RpcNotifyMeta.getDefaultInstance()) {
                this.notify = rpcMetaPb$RpcNotifyMeta;
            } else {
                this.notify = RpcMetaPb$RpcNotifyMeta.newBuilder(this.notify).mergeFrom(rpcMetaPb$RpcNotifyMeta).buildPartial();
            }
            this.bitField0 |= 128;
            return this;
        }

        public Builder mergeRequest(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            if ((this.bitField0 & 1) != 1 || this.request == RpcMetaPb$RpcRequestMeta.getDefaultInstance()) {
                this.request = rpcMetaPb$RpcRequestMeta;
            } else {
                this.request = RpcMetaPb$RpcRequestMeta.newBuilder(this.request).mergeFrom(rpcMetaPb$RpcRequestMeta).buildPartial();
            }
            this.bitField0 |= 1;
            return this;
        }

        public Builder mergeResponse(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            if ((this.bitField0 & 2) != 2 || this.response == RpcMetaPb$RpcResponseMeta.getDefaultInstance()) {
                this.response = rpcMetaPb$RpcResponseMeta;
            } else {
                this.response = RpcMetaPb$RpcResponseMeta.newBuilder(this.response).mergeFrom(rpcMetaPb$RpcResponseMeta).buildPartial();
            }
            this.bitField0 |= 2;
            return this;
        }

        public Builder setAcceptCompressType(int i2) {
            this.bitField0 |= 256;
            this.acceptCompressType = i2;
            return this;
        }

        public Builder setAttachmentSize(int i2) {
            this.bitField0 |= 16;
            this.attachmentSize = i2;
            return this;
        }

        public Builder setAuthenticationData(ByteString byteString) {
            if (byteString != null) {
                this.bitField0 |= 64;
                this.authenticationData = byteString;
                return this;
            }
            throw null;
        }

        public Builder setChunkInfo(RpcMetaPb$ChunkInfo rpcMetaPb$ChunkInfo) {
            if (rpcMetaPb$ChunkInfo != null) {
                this.chunkInfo = rpcMetaPb$ChunkInfo;
                this.bitField0 |= 32;
                return this;
            }
            throw null;
        }

        public Builder setCompressType(int i2) {
            this.bitField0 |= 4;
            this.compressType = i2;
            return this;
        }

        public Builder setCorrelationId(long j) {
            this.bitField0 |= 8;
            this.correlationId = j;
            return this;
        }

        public Builder setNotify(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            if (rpcMetaPb$RpcNotifyMeta != null) {
                this.notify = rpcMetaPb$RpcNotifyMeta;
                this.bitField0 |= 128;
                return this;
            }
            throw null;
        }

        public Builder setRequest(RpcMetaPb$RpcRequestMeta rpcMetaPb$RpcRequestMeta) {
            if (rpcMetaPb$RpcRequestMeta != null) {
                this.request = rpcMetaPb$RpcRequestMeta;
                this.bitField0 |= 1;
                return this;
            }
            throw null;
        }

        public Builder setResponse(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            if (rpcMetaPb$RpcResponseMeta != null) {
                this.response = rpcMetaPb$RpcResponseMeta;
                this.bitField0 |= 2;
                return this;
            }
            throw null;
        }

        public RpcMetaPb$RpcMeta build() {
            RpcMetaPb$RpcMeta buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public RpcMetaPb$RpcMeta buildPartial() {
            RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = new RpcMetaPb$RpcMeta((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            RpcMetaPb$RpcRequestMeta unused = rpcMetaPb$RpcMeta.request = this.request;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            RpcMetaPb$RpcResponseMeta unused2 = rpcMetaPb$RpcMeta.response = this.response;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            int unused3 = rpcMetaPb$RpcMeta.compressType = this.compressType;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            long unused4 = rpcMetaPb$RpcMeta.correlationId = this.correlationId;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            int unused5 = rpcMetaPb$RpcMeta.attachmentSize = this.attachmentSize;
            if ((i2 & 32) == 32) {
                i3 |= 32;
            }
            RpcMetaPb$ChunkInfo unused6 = rpcMetaPb$RpcMeta.chunkInfo = this.chunkInfo;
            if ((i2 & 64) == 64) {
                i3 |= 64;
            }
            ByteString unused7 = rpcMetaPb$RpcMeta.authenticationData = this.authenticationData;
            if ((i2 & 128) == 128) {
                i3 |= 128;
            }
            RpcMetaPb$RpcNotifyMeta unused8 = rpcMetaPb$RpcMeta.notify = this.notify;
            if ((i2 & 256) == 256) {
                i3 |= 256;
            }
            int unused9 = rpcMetaPb$RpcMeta.acceptCompressType = this.acceptCompressType;
            int unused10 = rpcMetaPb$RpcMeta.bitField0 = i3;
            return rpcMetaPb$RpcMeta;
        }

        public Builder clear() {
            super.clear();
            this.request = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
            this.bitField0 &= -2;
            this.response = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
            int i2 = this.bitField0 & -3;
            this.bitField0 = i2;
            this.compressType = 0;
            int i3 = i2 & -5;
            this.bitField0 = i3;
            this.correlationId = 0;
            int i4 = i3 & -9;
            this.bitField0 = i4;
            this.attachmentSize = 0;
            this.bitField0 = i4 & -17;
            this.chunkInfo = RpcMetaPb$ChunkInfo.getDefaultInstance();
            int i5 = this.bitField0 & -33;
            this.bitField0 = i5;
            this.authenticationData = ByteString.EMPTY;
            this.bitField0 = i5 & -65;
            this.notify = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
            int i6 = this.bitField0 & -129;
            this.bitField0 = i6;
            this.acceptCompressType = 0;
            this.bitField0 = i6 & -257;
            return this;
        }

        public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
            return RpcMetaPb$RpcMeta.getDefaultInstance();
        }

        public Builder mergeFrom(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
            if (rpcMetaPb$RpcMeta == RpcMetaPb$RpcMeta.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$RpcMeta.hasRequest()) {
                mergeRequest(rpcMetaPb$RpcMeta.getRequest());
            }
            if (rpcMetaPb$RpcMeta.hasResponse()) {
                mergeResponse(rpcMetaPb$RpcMeta.getResponse());
            }
            if (rpcMetaPb$RpcMeta.hasCompressType()) {
                setCompressType(rpcMetaPb$RpcMeta.getCompressType());
            }
            if (rpcMetaPb$RpcMeta.hasCorrelationId()) {
                setCorrelationId(rpcMetaPb$RpcMeta.getCorrelationId());
            }
            if (rpcMetaPb$RpcMeta.hasAttachmentSize()) {
                setAttachmentSize(rpcMetaPb$RpcMeta.getAttachmentSize());
            }
            if (rpcMetaPb$RpcMeta.hasChunkInfo()) {
                mergeChunkInfo(rpcMetaPb$RpcMeta.getChunkInfo());
            }
            if (rpcMetaPb$RpcMeta.hasAuthenticationData()) {
                setAuthenticationData(rpcMetaPb$RpcMeta.getAuthenticationData());
            }
            if (rpcMetaPb$RpcMeta.hasNotify()) {
                mergeNotify(rpcMetaPb$RpcMeta.getNotify());
            }
            if (rpcMetaPb$RpcMeta.hasAcceptCompressType()) {
                setAcceptCompressType(rpcMetaPb$RpcMeta.getAcceptCompressType());
            }
            return this;
        }

        public Builder setChunkInfo(RpcMetaPb$ChunkInfo.Builder builder) {
            this.chunkInfo = builder.build();
            this.bitField0 |= 32;
            return this;
        }

        public Builder setNotify(RpcMetaPb$RpcNotifyMeta.Builder builder) {
            this.notify = builder.build();
            this.bitField0 |= 128;
            return this;
        }

        public Builder setRequest(RpcMetaPb$RpcRequestMeta.Builder builder) {
            this.request = builder.build();
            this.bitField0 |= 1;
            return this;
        }

        public Builder setResponse(RpcMetaPb$RpcResponseMeta.Builder builder) {
            this.response = builder.build();
            this.bitField0 |= 2;
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta;
            RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta2 = null;
            try {
                RpcMetaPb$RpcMeta parsePartialFrom = RpcMetaPb$RpcMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                rpcMetaPb$RpcMeta = (RpcMetaPb$RpcMeta) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                rpcMetaPb$RpcMeta2 = rpcMetaPb$RpcMeta;
            }
            if (rpcMetaPb$RpcMeta2 != null) {
                mergeFrom(rpcMetaPb$RpcMeta2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<RpcMetaPb$RpcMeta> {
        /* renamed from: qw */
        public RpcMetaPb$RpcMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$RpcMeta(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta = new RpcMetaPb$RpcMeta(true);
        defaultInstance = rpcMetaPb$RpcMeta;
        rpcMetaPb$RpcMeta.initFields();
    }

    public static RpcMetaPb$RpcMeta getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.request = RpcMetaPb$RpcRequestMeta.getDefaultInstance();
        this.response = RpcMetaPb$RpcResponseMeta.getDefaultInstance();
        this.compressType = 0;
        this.correlationId = 0;
        this.attachmentSize = 0;
        this.chunkInfo = RpcMetaPb$ChunkInfo.getDefaultInstance();
        this.authenticationData = ByteString.EMPTY;
        this.notify = RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
        this.acceptCompressType = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getAcceptCompressType() {
        return this.acceptCompressType;
    }

    public int getAttachmentSize() {
        return this.attachmentSize;
    }

    public ByteString getAuthenticationData() {
        return this.authenticationData;
    }

    public RpcMetaPb$ChunkInfo getChunkInfo() {
        return this.chunkInfo;
    }

    public int getCompressType() {
        return this.compressType;
    }

    public long getCorrelationId() {
        return this.correlationId;
    }

    public RpcMetaPb$RpcNotifyMeta getNotify() {
        return this.notify;
    }

    public Parser<RpcMetaPb$RpcMeta> getParserForType() {
        return PARSER;
    }

    public RpcMetaPb$RpcRequestMeta getRequest() {
        return this.request;
    }

    public RpcMetaPb$RpcResponseMeta getResponse() {
        return this.response;
    }

    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        if ((this.bitField0 & 1) == 1) {
            i3 = 0 + CodedOutputStream.computeMessageSize(1, this.request);
        }
        if ((this.bitField0 & 2) == 2) {
            i3 += CodedOutputStream.computeMessageSize(2, this.response);
        }
        if ((this.bitField0 & 4) == 4) {
            i3 += CodedOutputStream.computeInt32Size(3, this.compressType);
        }
        if ((this.bitField0 & 8) == 8) {
            i3 += CodedOutputStream.computeInt64Size(4, this.correlationId);
        }
        if ((this.bitField0 & 16) == 16) {
            i3 += CodedOutputStream.computeInt32Size(5, this.attachmentSize);
        }
        if ((this.bitField0 & 32) == 32) {
            i3 += CodedOutputStream.computeMessageSize(6, this.chunkInfo);
        }
        if ((this.bitField0 & 64) == 64) {
            i3 += CodedOutputStream.computeBytesSize(7, this.authenticationData);
        }
        if ((this.bitField0 & 128) == 128) {
            i3 += CodedOutputStream.computeMessageSize(8, this.notify);
        }
        if ((this.bitField0 & 256) == 256) {
            i3 += CodedOutputStream.computeInt32Size(9, this.acceptCompressType);
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public boolean hasAcceptCompressType() {
        return (this.bitField0 & 256) == 256;
    }

    public boolean hasAttachmentSize() {
        return (this.bitField0 & 16) == 16;
    }

    public boolean hasAuthenticationData() {
        return (this.bitField0 & 64) == 64;
    }

    public boolean hasChunkInfo() {
        return (this.bitField0 & 32) == 32;
    }

    public boolean hasCompressType() {
        return (this.bitField0 & 4) == 4;
    }

    public boolean hasCorrelationId() {
        return (this.bitField0 & 8) == 8;
    }

    public boolean hasNotify() {
        return (this.bitField0 & 128) == 128;
    }

    public boolean hasRequest() {
        return (this.bitField0 & 1) == 1;
    }

    public boolean hasResponse() {
        return (this.bitField0 & 2) == 2;
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b != -1) {
            return b == 1;
        }
        if (!hasChunkInfo() || getChunkInfo().isInitialized()) {
            this.memoizedIsInitialized = 1;
            return true;
        }
        this.memoizedIsInitialized = 0;
        return false;
    }

    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0 & 1) == 1) {
            codedOutputStream.writeMessage(1, this.request);
        }
        if ((this.bitField0 & 2) == 2) {
            codedOutputStream.writeMessage(2, this.response);
        }
        if ((this.bitField0 & 4) == 4) {
            codedOutputStream.writeInt32(3, this.compressType);
        }
        if ((this.bitField0 & 8) == 8) {
            codedOutputStream.writeInt64(4, this.correlationId);
        }
        if ((this.bitField0 & 16) == 16) {
            codedOutputStream.writeInt32(5, this.attachmentSize);
        }
        if ((this.bitField0 & 32) == 32) {
            codedOutputStream.writeMessage(6, this.chunkInfo);
        }
        if ((this.bitField0 & 64) == 64) {
            codedOutputStream.writeBytes(7, this.authenticationData);
        }
        if ((this.bitField0 & 128) == 128) {
            codedOutputStream.writeMessage(8, this.notify);
        }
        if ((this.bitField0 & 256) == 256) {
            codedOutputStream.writeInt32(9, this.acceptCompressType);
        }
    }

    public static Builder newBuilder(RpcMetaPb$RpcMeta rpcMetaPb$RpcMeta) {
        return newBuilder().mergeFrom(rpcMetaPb$RpcMeta);
    }

    public static RpcMetaPb$RpcMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public RpcMetaPb$RpcMeta getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public RpcMetaPb$RpcMeta(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$RpcMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$RpcMeta(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$RpcMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta$Builder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta$Builder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo$Builder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta$Builder} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RpcMetaPb$RpcMeta(com.google.protobuf.CodedInputStream r7, com.google.protobuf.ExtensionRegistryLite r8) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r6 = this;
            r6.<init>()
            r0 = -1
            r6.memoizedIsInitialized = r0
            r6.memoizedSerializedSize = r0
            r6.initFields()
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x0142
            int r1 = r7.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r2 = 1
            if (r1 == 0) goto L_0x0124
            r3 = 10
            r4 = 0
            if (r1 == r3) goto L_0x00fd
            r3 = 18
            if (r1 == r3) goto L_0x00d5
            r3 = 24
            if (r1 == r3) goto L_0x00c7
            r3 = 32
            if (r1 == r3) goto L_0x00b9
            r5 = 40
            if (r1 == r5) goto L_0x00ab
            r5 = 50
            if (r1 == r5) goto L_0x0084
            r3 = 58
            if (r1 == r3) goto L_0x0077
            r3 = 66
            if (r1 == r3) goto L_0x004f
            r3 = 72
            if (r1 == r3) goto L_0x0042
            boolean r1 = r6.parseUnknownField(r7, r8, r1)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            if (r1 != 0) goto L_0x000c
            goto L_0x0124
        L_0x0042:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | 256(0x100, float:3.59E-43)
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            int r1 = r7.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.acceptCompressType = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x004f:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r2 = 128(0x80, float:1.794E-43)
            r1 = r1 & r2
            if (r1 != r2) goto L_0x005c
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta r1 = r6.notify     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x005c:
            com.google.protobuf.Parser<com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta> r1 = com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta r1 = (com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta) r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.notify = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            if (r4 == 0) goto L_0x0071
            r4.mergeFrom((com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.notify = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x0071:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | r2
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x0077:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | 64
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.google.protobuf.ByteString r1 = r7.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.authenticationData = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x0084:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 & r3
            if (r1 != r3) goto L_0x008f
            com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo r1 = r6.chunkInfo     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x008f:
            com.google.protobuf.Parser<com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo> r1 = com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo r1 = (com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo) r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.chunkInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            if (r4 == 0) goto L_0x00a4
            r4.mergeFrom((com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$ChunkInfo r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.chunkInfo = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x00a4:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | r3
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x00ab:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | 16
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            int r1 = r7.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.attachmentSize = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x00b9:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | 8
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            long r1 = r7.readInt64()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.correlationId = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x00c7:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | 4
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            int r1 = r7.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.compressType = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x00d5:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r2 = 2
            r1 = r1 & r2
            if (r1 != r2) goto L_0x00e1
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta r1 = r6.response     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x00e1:
            com.google.protobuf.Parser<com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta> r1 = com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta r1 = (com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta) r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.response = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            if (r4 == 0) goto L_0x00f6
            r4.mergeFrom((com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.response = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x00f6:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | r2
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x00fd:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0108
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta r1 = r6.request     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x0108:
            com.google.protobuf.Parser<com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta> r1 = com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.google.protobuf.MessageLite r1 = r7.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r8)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta r1 = (com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta) r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.request = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            if (r4 == 0) goto L_0x011d
            r4.mergeFrom((com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta) r1)     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r6.request = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
        L_0x011d:
            int r1 = r6.bitField0     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            r1 = r1 | r2
            r6.bitField0 = r1     // Catch:{ InvalidProtocolBufferException -> 0x0138, IOException -> 0x0129 }
            goto L_0x000c
        L_0x0124:
            r0 = 1
            goto L_0x000c
        L_0x0127:
            r7 = move-exception
            goto L_0x013e
        L_0x0129:
            r7 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0127 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0127 }
            r8.<init>((java.lang.String) r7)     // Catch:{ all -> 0x0127 }
            com.google.protobuf.InvalidProtocolBufferException r7 = r8.setUnfinishedMessage(r6)     // Catch:{ all -> 0x0127 }
            throw r7     // Catch:{ all -> 0x0127 }
        L_0x0138:
            r7 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r7 = r7.setUnfinishedMessage(r6)     // Catch:{ all -> 0x0127 }
            throw r7     // Catch:{ all -> 0x0127 }
        L_0x013e:
            r6.makeExtensionsImmutable()
            throw r7
        L_0x0142:
            r6.makeExtensionsImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
    }
}
