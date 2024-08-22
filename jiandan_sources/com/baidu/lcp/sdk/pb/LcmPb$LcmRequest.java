package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.pb.LcmPb$Common;
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

public final class LcmPb$LcmRequest extends GeneratedMessageLite implements LcmPb$LcmRequestOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 5;
    public static final int COMMON_FIELD_NUMBER = 3;
    public static final int CONN_TYPE_FIELD_NUMBER = 7;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static Parser<LcmPb$LcmRequest> PARSER = new qw();
    public static final int START_TYPE_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    public static final int TOKEN_FIELD_NUMBER = 2;
    public static final LcmPb$LcmRequest defaultInstance;
    public static final long serialVersionUID = 0;
    public int action_;
    public int bitField0_;
    public LcmPb$Common common_;
    public int connType_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int startType_;
    public long timestamp_;
    public Object token_;

    public static final class Builder extends GeneratedMessageLite.Builder<LcmPb$LcmRequest, Builder> implements LcmPb$LcmRequestOrBuilder {
        public int action_;
        public int bitField0_;
        public LcmPb$Common common_ = LcmPb$Common.getDefaultInstance();
        public int connType_;
        public long logId_;
        public int startType_;
        public long timestamp_;
        public Object token_ = "";

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearAction() {
            this.bitField0_ &= -17;
            this.action_ = 0;
            return this;
        }

        public Builder clearCommon() {
            this.common_ = LcmPb$Common.getDefaultInstance();
            this.bitField0_ &= -5;
            return this;
        }

        public Builder clearConnType() {
            this.bitField0_ &= -65;
            this.connType_ = 0;
            return this;
        }

        public Builder clearLogId() {
            this.bitField0_ &= -2;
            this.logId_ = 0;
            return this;
        }

        public Builder clearStartType() {
            this.bitField0_ &= -33;
            this.startType_ = 0;
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -9;
            this.timestamp_ = 0;
            return this;
        }

        public Builder clearToken() {
            this.bitField0_ &= -3;
            this.token_ = LcmPb$LcmRequest.getDefaultInstance().getToken();
            return this;
        }

        public int getAction() {
            return this.action_;
        }

        public LcmPb$Common getCommon() {
            return this.common_;
        }

        public int getConnType() {
            return this.connType_;
        }

        public long getLogId() {
            return this.logId_;
        }

        public int getStartType() {
            return this.startType_;
        }

        public long getTimestamp() {
            return this.timestamp_;
        }

        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getTokenBytes() {
            Object obj = this.token_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.token_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasAction() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasCommon() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasConnType() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasLogId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasStartType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTimestamp() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasToken() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean isInitialized() {
            return hasLogId();
        }

        public Builder mergeCommon(LcmPb$Common lcmPb$Common) {
            if ((this.bitField0_ & 4) != 4 || this.common_ == LcmPb$Common.getDefaultInstance()) {
                this.common_ = lcmPb$Common;
            } else {
                this.common_ = LcmPb$Common.newBuilder(this.common_).mergeFrom(lcmPb$Common).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder setAction(int i2) {
            this.bitField0_ |= 16;
            this.action_ = i2;
            return this;
        }

        public Builder setCommon(LcmPb$Common lcmPb$Common) {
            if (lcmPb$Common != null) {
                this.common_ = lcmPb$Common;
                this.bitField0_ |= 4;
                return this;
            }
            throw null;
        }

        public Builder setConnType(int i2) {
            this.bitField0_ |= 64;
            this.connType_ = i2;
            return this;
        }

        public Builder setLogId(long j) {
            this.bitField0_ |= 1;
            this.logId_ = j;
            return this;
        }

        public Builder setStartType(int i2) {
            this.bitField0_ |= 32;
            this.startType_ = i2;
            return this;
        }

        public Builder setTimestamp(long j) {
            this.bitField0_ |= 8;
            this.timestamp_ = j;
            return this;
        }

        public Builder setToken(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.token_ = str;
                return this;
            }
            throw null;
        }

        public Builder setTokenBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.token_ = byteString;
                return this;
            }
            throw null;
        }

        public LcmPb$LcmRequest build() {
            LcmPb$LcmRequest buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public LcmPb$LcmRequest buildPartial() {
            LcmPb$LcmRequest lcmPb$LcmRequest = new LcmPb$LcmRequest((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0_;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            long unused = lcmPb$LcmRequest.logId_ = this.logId_;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            Object unused2 = lcmPb$LcmRequest.token_ = this.token_;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            LcmPb$Common unused3 = lcmPb$LcmRequest.common_ = this.common_;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            long unused4 = lcmPb$LcmRequest.timestamp_ = this.timestamp_;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            int unused5 = lcmPb$LcmRequest.action_ = this.action_;
            if ((i2 & 32) == 32) {
                i3 |= 32;
            }
            int unused6 = lcmPb$LcmRequest.startType_ = this.startType_;
            if ((i2 & 64) == 64) {
                i3 |= 64;
            }
            int unused7 = lcmPb$LcmRequest.connType_ = this.connType_;
            int unused8 = lcmPb$LcmRequest.bitField0_ = i3;
            return lcmPb$LcmRequest;
        }

        public Builder clear() {
            super.clear();
            this.logId_ = 0;
            int i2 = this.bitField0_ & -2;
            this.bitField0_ = i2;
            this.token_ = "";
            this.bitField0_ = i2 & -3;
            this.common_ = LcmPb$Common.getDefaultInstance();
            int i3 = this.bitField0_ & -5;
            this.bitField0_ = i3;
            this.timestamp_ = 0;
            int i4 = i3 & -9;
            this.bitField0_ = i4;
            this.action_ = 0;
            int i5 = i4 & -17;
            this.bitField0_ = i5;
            this.startType_ = 0;
            int i6 = i5 & -33;
            this.bitField0_ = i6;
            this.connType_ = 0;
            this.bitField0_ = i6 & -65;
            return this;
        }

        public LcmPb$LcmRequest getDefaultInstanceForType() {
            return LcmPb$LcmRequest.getDefaultInstance();
        }

        public Builder mergeFrom(LcmPb$LcmRequest lcmPb$LcmRequest) {
            if (lcmPb$LcmRequest == LcmPb$LcmRequest.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$LcmRequest.hasLogId()) {
                setLogId(lcmPb$LcmRequest.getLogId());
            }
            if (lcmPb$LcmRequest.hasToken()) {
                this.bitField0_ |= 2;
                this.token_ = lcmPb$LcmRequest.token_;
            }
            if (lcmPb$LcmRequest.hasCommon()) {
                mergeCommon(lcmPb$LcmRequest.getCommon());
            }
            if (lcmPb$LcmRequest.hasTimestamp()) {
                setTimestamp(lcmPb$LcmRequest.getTimestamp());
            }
            if (lcmPb$LcmRequest.hasAction()) {
                setAction(lcmPb$LcmRequest.getAction());
            }
            if (lcmPb$LcmRequest.hasStartType()) {
                setStartType(lcmPb$LcmRequest.getStartType());
            }
            if (lcmPb$LcmRequest.hasConnType()) {
                setConnType(lcmPb$LcmRequest.getConnType());
            }
            return this;
        }

        public Builder setCommon(LcmPb$Common.Builder builder) {
            this.common_ = builder.build();
            this.bitField0_ |= 4;
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$LcmRequest lcmPb$LcmRequest;
            LcmPb$LcmRequest lcmPb$LcmRequest2 = null;
            try {
                LcmPb$LcmRequest parsePartialFrom = LcmPb$LcmRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                lcmPb$LcmRequest = (LcmPb$LcmRequest) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                lcmPb$LcmRequest2 = lcmPb$LcmRequest;
            }
            if (lcmPb$LcmRequest2 != null) {
                mergeFrom(lcmPb$LcmRequest2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<LcmPb$LcmRequest> {
        /* renamed from: qw */
        public LcmPb$LcmRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$LcmRequest(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        LcmPb$LcmRequest lcmPb$LcmRequest = new LcmPb$LcmRequest(true);
        defaultInstance = lcmPb$LcmRequest;
        lcmPb$LcmRequest.initFields();
    }

    public static LcmPb$LcmRequest getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.logId_ = 0;
        this.token_ = "";
        this.common_ = LcmPb$Common.getDefaultInstance();
        this.timestamp_ = 0;
        this.action_ = 0;
        this.startType_ = 0;
        this.connType_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static LcmPb$LcmRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$LcmRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getAction() {
        return this.action_;
    }

    public LcmPb$Common getCommon() {
        return this.common_;
    }

    public int getConnType() {
        return this.connType_;
    }

    public long getLogId() {
        return this.logId_;
    }

    public Parser<LcmPb$LcmRequest> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        if ((this.bitField0_ & 1) == 1) {
            i3 = 0 + CodedOutputStream.computeInt64Size(1, this.logId_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i3 += CodedOutputStream.computeBytesSize(2, getTokenBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            i3 += CodedOutputStream.computeMessageSize(3, this.common_);
        }
        if ((this.bitField0_ & 8) == 8) {
            i3 += CodedOutputStream.computeInt64Size(4, this.timestamp_);
        }
        if ((this.bitField0_ & 16) == 16) {
            i3 += CodedOutputStream.computeInt32Size(5, this.action_);
        }
        if ((this.bitField0_ & 32) == 32) {
            i3 += CodedOutputStream.computeInt32Size(6, this.startType_);
        }
        if ((this.bitField0_ & 64) == 64) {
            i3 += CodedOutputStream.computeInt32Size(7, this.connType_);
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public int getStartType() {
        return this.startType_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public String getToken() {
        Object obj = this.token_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.token_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getTokenBytes() {
        Object obj = this.token_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.token_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public boolean hasAction() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasCommon() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasConnType() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasLogId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasStartType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasToken() {
        return (this.bitField0_ & 2) == 2;
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b != -1) {
            return b == 1;
        }
        if (!hasLogId()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt64(1, this.logId_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, getTokenBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.common_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt64(4, this.timestamp_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.action_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(6, this.startType_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(7, this.connType_);
        }
    }

    public static Builder newBuilder(LcmPb$LcmRequest lcmPb$LcmRequest) {
        return newBuilder().mergeFrom(lcmPb$LcmRequest);
    }

    public static LcmPb$LcmRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public LcmPb$LcmRequest getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public LcmPb$LcmRequest(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$LcmRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$LcmRequest parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$LcmRequest(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$LcmRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$LcmRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 8) {
                        this.bitField0_ |= 1;
                        this.logId_ = codedInputStream.readInt64();
                    } else if (readTag == 18) {
                        this.bitField0_ |= 2;
                        this.token_ = codedInputStream.readBytes();
                    } else if (readTag == 26) {
                        LcmPb$Common.Builder builder = (this.bitField0_ & 4) == 4 ? this.common_.toBuilder() : null;
                        LcmPb$Common lcmPb$Common = (LcmPb$Common) codedInputStream.readMessage(LcmPb$Common.PARSER, extensionRegistryLite);
                        this.common_ = lcmPb$Common;
                        if (builder != null) {
                            builder.mergeFrom(lcmPb$Common);
                            this.common_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 4;
                    } else if (readTag == 32) {
                        this.bitField0_ |= 8;
                        this.timestamp_ = codedInputStream.readInt64();
                    } else if (readTag == 40) {
                        this.bitField0_ |= 16;
                        this.action_ = codedInputStream.readInt32();
                    } else if (readTag == 48) {
                        this.bitField0_ |= 32;
                        this.startType_ = codedInputStream.readInt32();
                    } else if (readTag == 56) {
                        this.bitField0_ |= 64;
                        this.connType_ = codedInputStream.readInt32();
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
