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

public final class LcmPb$LcmResponse extends GeneratedMessageLite implements LcmPb$LcmResponseOrBuilder {
    public static final int ERROR_CODE_FIELD_NUMBER = 2;
    public static final int ERROR_MSG_FIELD_NUMBER = 3;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static final int NEXT_INTERVAL_MS_FIELD_NUMBER = 4;
    public static Parser<LcmPb$LcmResponse> PARSER = new qw();
    public static final LcmPb$LcmResponse defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public int errorCode_;
    public Object errorMsg_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long nextIntervalMs_;

    public static final class Builder extends GeneratedMessageLite.Builder<LcmPb$LcmResponse, Builder> implements LcmPb$LcmResponseOrBuilder {
        public int bitField0_;
        public int errorCode_;
        public Object errorMsg_ = "";
        public long logId_;
        public long nextIntervalMs_;

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearErrorCode() {
            this.bitField0_ &= -3;
            this.errorCode_ = 0;
            return this;
        }

        public Builder clearErrorMsg() {
            this.bitField0_ &= -5;
            this.errorMsg_ = LcmPb$LcmResponse.getDefaultInstance().getErrorMsg();
            return this;
        }

        public Builder clearLogId() {
            this.bitField0_ &= -2;
            this.logId_ = 0;
            return this;
        }

        public Builder clearNextIntervalMs() {
            this.bitField0_ &= -9;
            this.nextIntervalMs_ = 0;
            return this;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public String getErrorMsg() {
            Object obj = this.errorMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errorMsg_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getErrorMsgBytes() {
            Object obj = this.errorMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errorMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getLogId() {
            return this.logId_;
        }

        public long getNextIntervalMs() {
            return this.nextIntervalMs_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasErrorMsg() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasLogId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasNextIntervalMs() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean isInitialized() {
            if (hasLogId() && hasErrorCode() && hasErrorMsg()) {
                return true;
            }
            return false;
        }

        public Builder setErrorCode(int i2) {
            this.bitField0_ |= 2;
            this.errorCode_ = i2;
            return this;
        }

        public Builder setErrorMsg(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.errorMsg_ = str;
                return this;
            }
            throw null;
        }

        public Builder setErrorMsgBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 4;
                this.errorMsg_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setLogId(long j) {
            this.bitField0_ |= 1;
            this.logId_ = j;
            return this;
        }

        public Builder setNextIntervalMs(long j) {
            this.bitField0_ |= 8;
            this.nextIntervalMs_ = j;
            return this;
        }

        public LcmPb$LcmResponse build() {
            LcmPb$LcmResponse buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public LcmPb$LcmResponse buildPartial() {
            LcmPb$LcmResponse lcmPb$LcmResponse = new LcmPb$LcmResponse((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0_;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            long unused = lcmPb$LcmResponse.logId_ = this.logId_;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            int unused2 = lcmPb$LcmResponse.errorCode_ = this.errorCode_;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            Object unused3 = lcmPb$LcmResponse.errorMsg_ = this.errorMsg_;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            long unused4 = lcmPb$LcmResponse.nextIntervalMs_ = this.nextIntervalMs_;
            int unused5 = lcmPb$LcmResponse.bitField0_ = i3;
            return lcmPb$LcmResponse;
        }

        public Builder clear() {
            super.clear();
            this.logId_ = 0;
            int i2 = this.bitField0_ & -2;
            this.bitField0_ = i2;
            this.errorCode_ = 0;
            int i3 = i2 & -3;
            this.bitField0_ = i3;
            this.errorMsg_ = "";
            int i4 = i3 & -5;
            this.bitField0_ = i4;
            this.nextIntervalMs_ = 0;
            this.bitField0_ = i4 & -9;
            return this;
        }

        public LcmPb$LcmResponse getDefaultInstanceForType() {
            return LcmPb$LcmResponse.getDefaultInstance();
        }

        public Builder mergeFrom(LcmPb$LcmResponse lcmPb$LcmResponse) {
            if (lcmPb$LcmResponse == LcmPb$LcmResponse.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$LcmResponse.hasLogId()) {
                setLogId(lcmPb$LcmResponse.getLogId());
            }
            if (lcmPb$LcmResponse.hasErrorCode()) {
                setErrorCode(lcmPb$LcmResponse.getErrorCode());
            }
            if (lcmPb$LcmResponse.hasErrorMsg()) {
                this.bitField0_ |= 4;
                this.errorMsg_ = lcmPb$LcmResponse.errorMsg_;
            }
            if (lcmPb$LcmResponse.hasNextIntervalMs()) {
                setNextIntervalMs(lcmPb$LcmResponse.getNextIntervalMs());
            }
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$LcmResponse lcmPb$LcmResponse;
            LcmPb$LcmResponse lcmPb$LcmResponse2 = null;
            try {
                LcmPb$LcmResponse parsePartialFrom = LcmPb$LcmResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                lcmPb$LcmResponse = (LcmPb$LcmResponse) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                lcmPb$LcmResponse2 = lcmPb$LcmResponse;
            }
            if (lcmPb$LcmResponse2 != null) {
                mergeFrom(lcmPb$LcmResponse2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<LcmPb$LcmResponse> {
        /* renamed from: qw */
        public LcmPb$LcmResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$LcmResponse(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        LcmPb$LcmResponse lcmPb$LcmResponse = new LcmPb$LcmResponse(true);
        defaultInstance = lcmPb$LcmResponse;
        lcmPb$LcmResponse.initFields();
    }

    public static LcmPb$LcmResponse getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.logId_ = 0;
        this.errorCode_ = 0;
        this.errorMsg_ = "";
        this.nextIntervalMs_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static LcmPb$LcmResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$LcmResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public String getErrorMsg() {
        Object obj = this.errorMsg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.errorMsg_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getErrorMsgBytes() {
        Object obj = this.errorMsg_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.errorMsg_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public long getLogId() {
        return this.logId_;
    }

    public long getNextIntervalMs() {
        return this.nextIntervalMs_;
    }

    public Parser<LcmPb$LcmResponse> getParserForType() {
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
            i3 += CodedOutputStream.computeInt32Size(2, this.errorCode_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i3 += CodedOutputStream.computeBytesSize(3, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            i3 += CodedOutputStream.computeInt64Size(4, this.nextIntervalMs_);
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public boolean hasErrorCode() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasErrorMsg() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasLogId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasNextIntervalMs() {
        return (this.bitField0_ & 8) == 8;
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b != -1) {
            return b == 1;
        }
        if (!hasLogId()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasErrorCode()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasErrorMsg()) {
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt64(1, this.logId_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.errorCode_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBytes(3, getErrorMsgBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt64(4, this.nextIntervalMs_);
        }
    }

    public static Builder newBuilder(LcmPb$LcmResponse lcmPb$LcmResponse) {
        return newBuilder().mergeFrom(lcmPb$LcmResponse);
    }

    public static LcmPb$LcmResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public LcmPb$LcmResponse getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public LcmPb$LcmResponse(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$LcmResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$LcmResponse parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$LcmResponse(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$LcmResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$LcmResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    } else if (readTag == 16) {
                        this.bitField0_ |= 2;
                        this.errorCode_ = codedInputStream.readInt32();
                    } else if (readTag == 26) {
                        this.bitField0_ |= 4;
                        this.errorMsg_ = codedInputStream.readBytes();
                    } else if (readTag == 32) {
                        this.bitField0_ |= 8;
                        this.nextIntervalMs_ = codedInputStream.readInt64();
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
