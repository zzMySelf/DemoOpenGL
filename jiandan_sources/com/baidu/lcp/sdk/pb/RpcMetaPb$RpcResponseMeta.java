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

public final class RpcMetaPb$RpcResponseMeta extends GeneratedMessageLite implements RpcMetaPb$RpcResponseMetaOrBuilder {
    public static final int ERROR_CODE_FIELD_NUMBER = 4;
    public static final int ERROR_TEXT_FIELD_NUMBER = 5;
    public static final int LOG_ID_FIELD_NUMBER = 3;
    public static final int METHOD_ID_FIELD_NUMBER = 2;
    public static final Parser<RpcMetaPb$RpcResponseMeta> PARSER = new qw();
    public static final int SERVICE_ID_FIELD_NUMBER = 1;
    public static final RpcMetaPb$RpcResponseMeta defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public int errorCode;
    public Object errorText;
    public long logId;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long methodId;
    public long serviceId;

    public static final class Builder extends GeneratedMessageLite.Builder<RpcMetaPb$RpcResponseMeta, Builder> implements RpcMetaPb$RpcResponseMetaOrBuilder {
        public int bitField0;
        public int errorCode;
        public Object errorText = "";
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

        public Builder clearErrorCode() {
            this.bitField0 &= -9;
            this.errorCode = 0;
            return this;
        }

        public Builder clearErrorText() {
            this.bitField0 &= -17;
            this.errorText = RpcMetaPb$RpcResponseMeta.getDefaultInstance().getErrorText();
            return this;
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

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorText() {
            Object obj = this.errorText;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errorText = stringUtf8;
            return stringUtf8;
        }

        public ByteString getErrorTextBytes() {
            Object obj = this.errorText;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errorText = copyFromUtf8;
            return copyFromUtf8;
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

        public boolean hasErrorCode() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasErrorText() {
            return (this.bitField0 & 16) == 16;
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

        public Builder setErrorCode(int i2) {
            this.bitField0 |= 8;
            this.errorCode = i2;
            return this;
        }

        public Builder setErrorText(String str) {
            if (str != null) {
                this.bitField0 |= 16;
                this.errorText = str;
                return this;
            }
            throw null;
        }

        public Builder setErrorTextBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0 |= 16;
                this.errorText = byteString;
                return this;
            }
            throw null;
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

        public RpcMetaPb$RpcResponseMeta build() {
            RpcMetaPb$RpcResponseMeta buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public RpcMetaPb$RpcResponseMeta buildPartial() {
            RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = new RpcMetaPb$RpcResponseMeta((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            long unused = rpcMetaPb$RpcResponseMeta.serviceId = this.serviceId;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            long unused2 = rpcMetaPb$RpcResponseMeta.methodId = this.methodId;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            long unused3 = rpcMetaPb$RpcResponseMeta.logId = this.logId;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            int unused4 = rpcMetaPb$RpcResponseMeta.errorCode = this.errorCode;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            Object unused5 = rpcMetaPb$RpcResponseMeta.errorText = this.errorText;
            int unused6 = rpcMetaPb$RpcResponseMeta.bitField0 = i3;
            return rpcMetaPb$RpcResponseMeta;
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
            int i4 = i3 & -5;
            this.bitField0 = i4;
            this.errorCode = 0;
            int i5 = i4 & -9;
            this.bitField0 = i5;
            this.errorText = "";
            this.bitField0 = i5 & -17;
            return this;
        }

        public RpcMetaPb$RpcResponseMeta getDefaultInstanceForType() {
            return RpcMetaPb$RpcResponseMeta.getDefaultInstance();
        }

        public Builder mergeFrom(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
            if (rpcMetaPb$RpcResponseMeta == RpcMetaPb$RpcResponseMeta.getDefaultInstance()) {
                return this;
            }
            if (rpcMetaPb$RpcResponseMeta.hasServiceId()) {
                setServiceId(rpcMetaPb$RpcResponseMeta.getServiceId());
            }
            if (rpcMetaPb$RpcResponseMeta.hasMethodId()) {
                setMethodId(rpcMetaPb$RpcResponseMeta.getMethodId());
            }
            if (rpcMetaPb$RpcResponseMeta.hasLogId()) {
                setLogId(rpcMetaPb$RpcResponseMeta.getLogId());
            }
            if (rpcMetaPb$RpcResponseMeta.hasErrorCode()) {
                setErrorCode(rpcMetaPb$RpcResponseMeta.getErrorCode());
            }
            if (rpcMetaPb$RpcResponseMeta.hasErrorText()) {
                this.bitField0 |= 16;
                this.errorText = rpcMetaPb$RpcResponseMeta.errorText;
            }
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta;
            RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta2 = null;
            try {
                RpcMetaPb$RpcResponseMeta parsePartialFrom = RpcMetaPb$RpcResponseMeta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                rpcMetaPb$RpcResponseMeta = (RpcMetaPb$RpcResponseMeta) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                rpcMetaPb$RpcResponseMeta2 = rpcMetaPb$RpcResponseMeta;
            }
            if (rpcMetaPb$RpcResponseMeta2 != null) {
                mergeFrom(rpcMetaPb$RpcResponseMeta2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<RpcMetaPb$RpcResponseMeta> {
        /* renamed from: qw */
        public RpcMetaPb$RpcResponseMeta parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RpcMetaPb$RpcResponseMeta(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta = new RpcMetaPb$RpcResponseMeta(true);
        defaultInstance = rpcMetaPb$RpcResponseMeta;
        rpcMetaPb$RpcResponseMeta.initFields();
    }

    public static RpcMetaPb$RpcResponseMeta getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.serviceId = 0;
        this.methodId = 0;
        this.logId = 0;
        this.errorCode = 0;
        this.errorText = "";
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static RpcMetaPb$RpcResponseMeta parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorText() {
        Object obj = this.errorText;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.errorText = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getErrorTextBytes() {
        Object obj = this.errorText;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.errorText = copyFromUtf8;
        return copyFromUtf8;
    }

    public long getLogId() {
        return this.logId;
    }

    public long getMethodId() {
        return this.methodId;
    }

    public Parser<RpcMetaPb$RpcResponseMeta> getParserForType() {
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
        if ((this.bitField0 & 8) == 8) {
            i3 += CodedOutputStream.computeInt32Size(4, this.errorCode);
        }
        if ((this.bitField0 & 16) == 16) {
            i3 += CodedOutputStream.computeBytesSize(5, getErrorTextBytes());
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public long getServiceId() {
        return this.serviceId;
    }

    public boolean hasErrorCode() {
        return (this.bitField0 & 8) == 8;
    }

    public boolean hasErrorText() {
        return (this.bitField0 & 16) == 16;
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
        if ((this.bitField0 & 8) == 8) {
            codedOutputStream.writeInt32(4, this.errorCode);
        }
        if ((this.bitField0 & 16) == 16) {
            codedOutputStream.writeBytes(5, getErrorTextBytes());
        }
    }

    public static Builder newBuilder(RpcMetaPb$RpcResponseMeta rpcMetaPb$RpcResponseMeta) {
        return newBuilder().mergeFrom(rpcMetaPb$RpcResponseMeta);
    }

    public static RpcMetaPb$RpcResponseMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public RpcMetaPb$RpcResponseMeta getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public RpcMetaPb$RpcResponseMeta(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public RpcMetaPb$RpcResponseMeta(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static RpcMetaPb$RpcResponseMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public RpcMetaPb$RpcResponseMeta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    } else if (readTag == 32) {
                        this.bitField0 |= 8;
                        this.errorCode = codedInputStream.readInt32();
                    } else if (readTag == 42) {
                        this.bitField0 |= 16;
                        this.errorText = codedInputStream.readBytes();
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
