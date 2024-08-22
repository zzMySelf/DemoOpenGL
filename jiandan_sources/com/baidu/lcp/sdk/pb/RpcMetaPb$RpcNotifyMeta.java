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

public final class RpcMetaPb$RpcNotifyMeta extends GeneratedMessageLite implements RpcMetaPb$RpcNotifyMetaOrBuilder {
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static final Parser<RpcMetaPb$RpcNotifyMeta> PARSER = new qw();
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcNotifyMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public long logId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId;
    public long serviceId;

    public static final class Builder extends GeneratedMessageLite.Builder<RpcMetaPb$RpcNotifyMeta, Builder> implements RpcMetaPb$RpcNotifyMetaOrBuilder {
        public int bitField0;
        public long logId;
        public long methodId;
        public long serviceId;

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearLogId() {
            this.bitField0 &= -5;
            this.logId = 0;
            return this;
        }

        public Builder clearMethodId() {
            this.bitField0 &= -3;
            this.methodId = 0;
            return this;
        }

        public Builder clearServiceId() {
            this.bitField0 &= -2;
            this.serviceId = 0;
            return this;
        }

        public long getLogId() {
            return this.logId;
        }

        public long getMethodId() {
            return this.methodId;
        }

        public long getServiceId() {
            return this.serviceId;
        }

        public boolean hasLogId() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasMethodId() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasServiceId() {
            return (this.bitField0 & 1) == 1;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder setLogId(long j) {
            this.bitField0 |= 4;
            this.logId = j;
            return this;
        }

        public Builder setMethodId(long j) {
            this.bitField0 |= 2;
            this.methodId = j;
            return this;
        }

        public Builder setServiceId(long j) {
            this.bitField0 |= 1;
            this.serviceId = j;
            return this;
        }

        public RpcMetaPb$RpcNotifyMeta build() {
            RpcMetaPb$RpcNotifyMeta buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public RpcMetaPb$RpcNotifyMeta buildPartial() {
            RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = new RpcMetaPb$RpcNotifyMeta((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            long unused = rpcMetaPb$RpcNotifyMeta.serviceId = this.serviceId;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            long unused2 = rpcMetaPb$RpcNotifyMeta.methodId = this.methodId;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            long unused3 = rpcMetaPb$RpcNotifyMeta.logId = this.logId;
            int unused4 = rpcMetaPb$RpcNotifyMeta.bitField0 = i3;
            return rpcMetaPb$RpcNotifyMeta;
        }

        public Builder clear() {
            super.clear();
            this.serviceId = 0;
            int i2 = this.bitField0 & -2;
            this.bitField0 = i2;
            this.methodId = 0;
            int i3 = i2 & -3;
            this.bitField0 = i3;
            this.logId = 0;
            this.bitField0 = i3 & -5;
            return this;
        }

        public RpcMetaPb$RpcNotifyMeta getDefaultInstanceForType() {
            return RpcMetaPb$RpcNotifyMeta.getDefaultInstance();
        }

        public Builder mergeFrom(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
            if (rpcMetaPb$RpcNotifyMeta == RpcMetaPb$RpcNotifyMeta.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$RpcNotifyMeta.hasServiceId()) {
                setServiceId(rpcMetaPb$RpcNotifyMeta.getServiceId());
            }
            if (rpcMetaPb$RpcNotifyMeta.hasMethodId()) {
                setMethodId(rpcMetaPb$RpcNotifyMeta.getMethodId());
            }
            if (rpcMetaPb$RpcNotifyMeta.hasLogId()) {
                setLogId(rpcMetaPb$RpcNotifyMeta.getLogId());
            }
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta;
            RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta2 = null;
            try {
                RpcMetaPb$RpcNotifyMeta parsePartialFrom = RpcMetaPb$RpcNotifyMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                rpcMetaPb$RpcNotifyMeta = (RpcMetaPb$RpcNotifyMeta) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                rpcMetaPb$RpcNotifyMeta2 = rpcMetaPb$RpcNotifyMeta;
            }
            if (rpcMetaPb$RpcNotifyMeta2 != null) {
                mergeFrom(rpcMetaPb$RpcNotifyMeta2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<RpcMetaPb$RpcNotifyMeta> {
        /* renamed from: qw */
        public RpcMetaPb$RpcNotifyMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$RpcNotifyMeta(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta = new RpcMetaPb$RpcNotifyMeta(true);
        defaultInstance = rpcMetaPb$RpcNotifyMeta;
        rpcMetaPb$RpcNotifyMeta.initFields();
    }

    public static RpcMetaPb$RpcNotifyMeta getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.serviceId = 0;
        this.methodId = 0;
        this.logId = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static RpcMetaPb$RpcNotifyMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public long getLogId() {
        return this.logId;
    }

    public long getMethodId() {
        return this.methodId;
    }

    public Parser<RpcMetaPb$RpcNotifyMeta> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        if ((this.bitField0 & 1) == 1) {
            i3 = 0 + CodedOutputStream.computeInt64Size(1, this.serviceId);
        }
        if ((this.bitField0 & 2) == 2) {
            i3 += CodedOutputStream.computeInt64Size(2, this.methodId);
        }
        if ((this.bitField0 & 4) == 4) {
            i3 += CodedOutputStream.computeInt64Size(3, this.logId);
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public long getServiceId() {
        return this.serviceId;
    }

    public boolean hasLogId() {
        return (this.bitField0 & 4) == 4;
    }

    public boolean hasMethodId() {
        return (this.bitField0 & 2) == 2;
    }

    public boolean hasServiceId() {
        return (this.bitField0 & 1) == 1;
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b != -1) {
            return b == 1;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0 & 1) == 1) {
            codedOutputStream.writeInt64(1, this.serviceId);
        }
        if ((this.bitField0 & 2) == 2) {
            codedOutputStream.writeInt64(2, this.methodId);
        }
        if ((this.bitField0 & 4) == 4) {
            codedOutputStream.writeInt64(3, this.logId);
        }
    }

    public static Builder newBuilder(RpcMetaPb$RpcNotifyMeta rpcMetaPb$RpcNotifyMeta) {
        return newBuilder().mergeFrom(rpcMetaPb$RpcNotifyMeta);
    }

    public static RpcMetaPb$RpcNotifyMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public RpcMetaPb$RpcNotifyMeta getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public RpcMetaPb$RpcNotifyMeta(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$RpcNotifyMeta(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$RpcNotifyMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$RpcNotifyMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        this.serviceId = codedInputStream.readInt64();
                    } else if (readTag == 16) {
                        this.bitField0 |= 2;
                        this.methodId = codedInputStream.readInt64();
                    } else if (readTag == 24) {
                        this.bitField0 |= 4;
                        this.logId = codedInputStream.readInt64();
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
