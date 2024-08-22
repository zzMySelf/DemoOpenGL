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

public final class LcmPb$LcmNotify extends GeneratedMessageLite implements LcmPb$LcmNotifyOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 2;
    public static final int LOG_ID_FIELD_NUMBER = 1;
    public static final Parser<LcmPb$LcmNotify> PARSER = new qw();
    public static final LcmPb$LcmNotify defaultInstance;
    public static final long serialVersionUID = 0;
    public int action_;
    public int bitField0_;
    public long logId_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;

    public static final class Builder extends GeneratedMessageLite.Builder<LcmPb$LcmNotify, Builder> implements LcmPb$LcmNotifyOrBuilder {
        public int action_;
        public int bitField0_;
        public long logId_;

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearAction() {
            this.bitField0_ &= -3;
            this.action_ = 0;
            return this;
        }

        public Builder clearLogId() {
            this.bitField0_ &= -2;
            this.logId_ = 0;
            return this;
        }

        public int getAction() {
            return this.action_;
        }

        public long getLogId() {
            return this.logId_;
        }

        public boolean hasAction() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasLogId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean isInitialized() {
            return hasLogId();
        }

        public Builder setAction(int i2) {
            this.bitField0_ |= 2;
            this.action_ = i2;
            return this;
        }

        public Builder setLogId(long j) {
            this.bitField0_ |= 1;
            this.logId_ = j;
            return this;
        }

        public LcmPb$LcmNotify build() {
            LcmPb$LcmNotify buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public LcmPb$LcmNotify buildPartial() {
            LcmPb$LcmNotify lcmPb$LcmNotify = new LcmPb$LcmNotify((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0_;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            long unused = lcmPb$LcmNotify.logId_ = this.logId_;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            int unused2 = lcmPb$LcmNotify.action_ = this.action_;
            int unused3 = lcmPb$LcmNotify.bitField0_ = i3;
            return lcmPb$LcmNotify;
        }

        public Builder clear() {
            super.clear();
            this.logId_ = 0;
            int i2 = this.bitField0_ & -2;
            this.bitField0_ = i2;
            this.action_ = 0;
            this.bitField0_ = i2 & -3;
            return this;
        }

        public LcmPb$LcmNotify getDefaultInstanceForType() {
            return LcmPb$LcmNotify.getDefaultInstance();
        }

        public Builder mergeFrom(LcmPb$LcmNotify lcmPb$LcmNotify) {
            if (lcmPb$LcmNotify == LcmPb$LcmNotify.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$LcmNotify.hasLogId()) {
                setLogId(lcmPb$LcmNotify.getLogId());
            }
            if (lcmPb$LcmNotify.hasAction()) {
                setAction(lcmPb$LcmNotify.getAction());
            }
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$LcmNotify lcmPb$LcmNotify;
            LcmPb$LcmNotify lcmPb$LcmNotify2 = null;
            try {
                LcmPb$LcmNotify parsePartialFrom = LcmPb$LcmNotify.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                lcmPb$LcmNotify = (LcmPb$LcmNotify) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                lcmPb$LcmNotify2 = lcmPb$LcmNotify;
            }
            if (lcmPb$LcmNotify2 != null) {
                mergeFrom(lcmPb$LcmNotify2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<LcmPb$LcmNotify> {
        /* renamed from: qw */
        public LcmPb$LcmNotify parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$LcmNotify(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        LcmPb$LcmNotify lcmPb$LcmNotify = new LcmPb$LcmNotify(true);
        defaultInstance = lcmPb$LcmNotify;
        lcmPb$LcmNotify.initFields();
    }

    public static LcmPb$LcmNotify getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.logId_ = 0;
        this.action_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static LcmPb$LcmNotify parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$LcmNotify parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getAction() {
        return this.action_;
    }

    public long getLogId() {
        return this.logId_;
    }

    public Parser<LcmPb$LcmNotify> getParserForType() {
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
            i3 += CodedOutputStream.computeInt32Size(2, this.action_);
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public boolean hasAction() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasLogId() {
        return (this.bitField0_ & 1) == 1;
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
            codedOutputStream.writeInt32(2, this.action_);
        }
    }

    public static Builder newBuilder(LcmPb$LcmNotify lcmPb$LcmNotify) {
        return newBuilder().mergeFrom(lcmPb$LcmNotify);
    }

    public static LcmPb$LcmNotify parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmNotify parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public LcmPb$LcmNotify getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public LcmPb$LcmNotify(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$LcmNotify parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$LcmNotify parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$LcmNotify(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$LcmNotify parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$LcmNotify parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$LcmNotify parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$LcmNotify(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        this.action_ = codedInputStream.readInt32();
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
