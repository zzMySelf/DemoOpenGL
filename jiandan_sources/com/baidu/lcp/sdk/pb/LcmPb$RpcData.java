package com.baidu.lcp.sdk.pb;

import com.baidu.lcp.sdk.pb.LcmPb$LcmNotify;
import com.baidu.lcp.sdk.pb.LcmPb$LcmRequest;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
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

public final class LcmPb$RpcData extends GeneratedMessageLite implements LcmPb$RpcDataOrBuilder {
    public static final int LCM_NOTIFY_FIELD_NUMBER = 3;
    public static final int LCM_REQUEST_FIELD_NUMBER = 1;
    public static final int LCM_RESPONSE_FIELD_NUMBER = 2;
    public static final Parser<LcmPb$RpcData> PARSER = new qw();
    public static final LcmPb$RpcData defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0_;
    public LcmPb$LcmNotify lcmNotify_;
    public LcmPb$LcmRequest lcmRequest_;
    public LcmPb$LcmResponse lcmResponse_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;

    public static final class Builder extends GeneratedMessageLite.Builder<LcmPb$RpcData, Builder> implements LcmPb$RpcDataOrBuilder {
        public int bitField0_;
        public LcmPb$LcmNotify lcmNotify_ = LcmPb$LcmNotify.getDefaultInstance();
        public LcmPb$LcmRequest lcmRequest_ = LcmPb$LcmRequest.getDefaultInstance();
        public LcmPb$LcmResponse lcmResponse_ = LcmPb$LcmResponse.getDefaultInstance();

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearLcmNotify() {
            this.lcmNotify_ = LcmPb$LcmNotify.getDefaultInstance();
            this.bitField0_ &= -5;
            return this;
        }

        public Builder clearLcmRequest() {
            this.lcmRequest_ = LcmPb$LcmRequest.getDefaultInstance();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearLcmResponse() {
            this.lcmResponse_ = LcmPb$LcmResponse.getDefaultInstance();
            this.bitField0_ &= -3;
            return this;
        }

        public LcmPb$LcmNotify getLcmNotify() {
            return this.lcmNotify_;
        }

        public LcmPb$LcmRequest getLcmRequest() {
            return this.lcmRequest_;
        }

        public LcmPb$LcmResponse getLcmResponse() {
            return this.lcmResponse_;
        }

        public boolean hasLcmNotify() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasLcmRequest() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasLcmResponse() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean isInitialized() {
            if (hasLcmRequest() && !getLcmRequest().isInitialized()) {
                return false;
            }
            if (hasLcmResponse() && !getLcmResponse().isInitialized()) {
                return false;
            }
            if (!hasLcmNotify() || getLcmNotify().isInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeLcmNotify(LcmPb$LcmNotify lcmPb$LcmNotify) {
            if ((this.bitField0_ & 4) != 4 || this.lcmNotify_ == LcmPb$LcmNotify.getDefaultInstance()) {
                this.lcmNotify_ = lcmPb$LcmNotify;
            } else {
                this.lcmNotify_ = LcmPb$LcmNotify.newBuilder(this.lcmNotify_).mergeFrom(lcmPb$LcmNotify).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder mergeLcmRequest(LcmPb$LcmRequest lcmPb$LcmRequest) {
            if ((this.bitField0_ & 1) != 1 || this.lcmRequest_ == LcmPb$LcmRequest.getDefaultInstance()) {
                this.lcmRequest_ = lcmPb$LcmRequest;
            } else {
                this.lcmRequest_ = LcmPb$LcmRequest.newBuilder(this.lcmRequest_).mergeFrom(lcmPb$LcmRequest).buildPartial();
            }
            this.bitField0_ |= 1;
            return this;
        }

        public Builder mergeLcmResponse(LcmPb$LcmResponse lcmPb$LcmResponse) {
            if ((this.bitField0_ & 2) != 2 || this.lcmResponse_ == LcmPb$LcmResponse.getDefaultInstance()) {
                this.lcmResponse_ = lcmPb$LcmResponse;
            } else {
                this.lcmResponse_ = LcmPb$LcmResponse.newBuilder(this.lcmResponse_).mergeFrom(lcmPb$LcmResponse).buildPartial();
            }
            this.bitField0_ |= 2;
            return this;
        }

        public Builder setLcmNotify(LcmPb$LcmNotify lcmPb$LcmNotify) {
            if (lcmPb$LcmNotify != null) {
                this.lcmNotify_ = lcmPb$LcmNotify;
                this.bitField0_ |= 4;
                return this;
            }
            throw null;
        }

        public Builder setLcmRequest(LcmPb$LcmRequest lcmPb$LcmRequest) {
            if (lcmPb$LcmRequest != null) {
                this.lcmRequest_ = lcmPb$LcmRequest;
                this.bitField0_ |= 1;
                return this;
            }
            throw null;
        }

        public Builder setLcmResponse(LcmPb$LcmResponse lcmPb$LcmResponse) {
            if (lcmPb$LcmResponse != null) {
                this.lcmResponse_ = lcmPb$LcmResponse;
                this.bitField0_ |= 2;
                return this;
            }
            throw null;
        }

        public LcmPb$RpcData build() {
            LcmPb$RpcData buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public LcmPb$RpcData buildPartial() {
            LcmPb$RpcData lcmPb$RpcData = new LcmPb$RpcData((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0_;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            LcmPb$LcmRequest unused = lcmPb$RpcData.lcmRequest_ = this.lcmRequest_;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            LcmPb$LcmResponse unused2 = lcmPb$RpcData.lcmResponse_ = this.lcmResponse_;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            LcmPb$LcmNotify unused3 = lcmPb$RpcData.lcmNotify_ = this.lcmNotify_;
            int unused4 = lcmPb$RpcData.bitField0_ = i3;
            return lcmPb$RpcData;
        }

        public Builder clear() {
            super.clear();
            this.lcmRequest_ = LcmPb$LcmRequest.getDefaultInstance();
            this.bitField0_ &= -2;
            this.lcmResponse_ = LcmPb$LcmResponse.getDefaultInstance();
            this.bitField0_ &= -3;
            this.lcmNotify_ = LcmPb$LcmNotify.getDefaultInstance();
            this.bitField0_ &= -5;
            return this;
        }

        public LcmPb$RpcData getDefaultInstanceForType() {
            return LcmPb$RpcData.getDefaultInstance();
        }

        public Builder mergeFrom(LcmPb$RpcData lcmPb$RpcData) {
            if (lcmPb$RpcData == LcmPb$RpcData.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$RpcData.hasLcmRequest()) {
                mergeLcmRequest(lcmPb$RpcData.getLcmRequest());
            }
            if (lcmPb$RpcData.hasLcmResponse()) {
                mergeLcmResponse(lcmPb$RpcData.getLcmResponse());
            }
            if (lcmPb$RpcData.hasLcmNotify()) {
                mergeLcmNotify(lcmPb$RpcData.getLcmNotify());
            }
            return this;
        }

        public Builder setLcmNotify(LcmPb$LcmNotify.Builder builder) {
            this.lcmNotify_ = builder.build();
            this.bitField0_ |= 4;
            return this;
        }

        public Builder setLcmRequest(LcmPb$LcmRequest.Builder builder) {
            this.lcmRequest_ = builder.build();
            this.bitField0_ |= 1;
            return this;
        }

        public Builder setLcmResponse(LcmPb$LcmResponse.Builder builder) {
            this.lcmResponse_ = builder.build();
            this.bitField0_ |= 2;
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$RpcData lcmPb$RpcData;
            LcmPb$RpcData lcmPb$RpcData2 = null;
            try {
                LcmPb$RpcData parsePartialFrom = LcmPb$RpcData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                lcmPb$RpcData = (LcmPb$RpcData) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                lcmPb$RpcData2 = lcmPb$RpcData;
            }
            if (lcmPb$RpcData2 != null) {
                mergeFrom(lcmPb$RpcData2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<LcmPb$RpcData> {
        /* renamed from: qw */
        public LcmPb$RpcData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$RpcData(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        LcmPb$RpcData lcmPb$RpcData = new LcmPb$RpcData(true);
        defaultInstance = lcmPb$RpcData;
        lcmPb$RpcData.initFields();
    }

    public static LcmPb$RpcData getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.lcmRequest_ = LcmPb$LcmRequest.getDefaultInstance();
        this.lcmResponse_ = LcmPb$LcmResponse.getDefaultInstance();
        this.lcmNotify_ = LcmPb$LcmNotify.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public LcmPb$LcmNotify getLcmNotify() {
        return this.lcmNotify_;
    }

    public LcmPb$LcmRequest getLcmRequest() {
        return this.lcmRequest_;
    }

    public LcmPb$LcmResponse getLcmResponse() {
        return this.lcmResponse_;
    }

    public Parser<LcmPb$RpcData> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        if ((this.bitField0_ & 1) == 1) {
            i3 = 0 + CodedOutputStream.computeMessageSize(1, this.lcmRequest_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i3 += CodedOutputStream.computeMessageSize(2, this.lcmResponse_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i3 += CodedOutputStream.computeMessageSize(3, this.lcmNotify_);
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public boolean hasLcmNotify() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasLcmRequest() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasLcmResponse() {
        return (this.bitField0_ & 2) == 2;
    }

    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b != -1) {
            return b == 1;
        }
        if (hasLcmRequest() && !getLcmRequest().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasLcmResponse() && !getLcmResponse().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasLcmNotify() || getLcmNotify().isInitialized()) {
            this.memoizedIsInitialized = 1;
            return true;
        } else {
            this.memoizedIsInitialized = 0;
            return false;
        }
    }

    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(1, this.lcmRequest_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.lcmResponse_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.lcmNotify_);
        }
    }

    public static Builder newBuilder(LcmPb$RpcData lcmPb$RpcData) {
        return newBuilder().mergeFrom(lcmPb$RpcData);
    }

    public static LcmPb$RpcData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$RpcData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public LcmPb$RpcData getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public LcmPb$RpcData(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$RpcData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$RpcData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$RpcData parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$RpcData(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$RpcData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$RpcData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.baidu.lcp.sdk.pb.LcmPb$LcmRequest$Builder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.baidu.lcp.sdk.pb.LcmPb$LcmResponse$Builder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.baidu.lcp.sdk.pb.LcmPb$LcmNotify$Builder} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LcmPb$RpcData(com.google.protobuf.CodedInputStream r6, com.google.protobuf.ExtensionRegistryLite r7) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r5 = this;
            r5.<init>()
            r0 = -1
            r5.memoizedIsInitialized = r0
            r5.memoizedSerializedSize = r0
            r5.initFields()
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x00bd
            int r1 = r6.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r2 = 1
            if (r1 == 0) goto L_0x009f
            r3 = 10
            r4 = 0
            if (r1 == r3) goto L_0x0078
            r3 = 18
            if (r1 == r3) goto L_0x0051
            r3 = 26
            if (r1 == r3) goto L_0x002a
            boolean r1 = r5.parseUnknownField(r6, r7, r1)     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            if (r1 != 0) goto L_0x000c
            goto L_0x009f
        L_0x002a:
            int r1 = r5.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r2 = 4
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0036
            com.baidu.lcp.sdk.pb.LcmPb$LcmNotify r1 = r5.lcmNotify_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmNotify$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
        L_0x0036:
            com.google.protobuf.Parser<com.baidu.lcp.sdk.pb.LcmPb$LcmNotify> r1 = com.baidu.lcp.sdk.pb.LcmPb$LcmNotify.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmNotify r1 = (com.baidu.lcp.sdk.pb.LcmPb$LcmNotify) r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r5.lcmNotify_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            if (r4 == 0) goto L_0x004b
            r4.mergeFrom((com.baidu.lcp.sdk.pb.LcmPb$LcmNotify) r1)     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmNotify r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r5.lcmNotify_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
        L_0x004b:
            int r1 = r5.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r1 = r1 | r2
            r5.bitField0_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            goto L_0x000c
        L_0x0051:
            int r1 = r5.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r2 = 2
            r1 = r1 & r2
            if (r1 != r2) goto L_0x005d
            com.baidu.lcp.sdk.pb.LcmPb$LcmResponse r1 = r5.lcmResponse_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmResponse$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
        L_0x005d:
            com.google.protobuf.Parser<com.baidu.lcp.sdk.pb.LcmPb$LcmResponse> r1 = com.baidu.lcp.sdk.pb.LcmPb$LcmResponse.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmResponse r1 = (com.baidu.lcp.sdk.pb.LcmPb$LcmResponse) r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r5.lcmResponse_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            if (r4 == 0) goto L_0x0072
            r4.mergeFrom((com.baidu.lcp.sdk.pb.LcmPb$LcmResponse) r1)     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmResponse r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r5.lcmResponse_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
        L_0x0072:
            int r1 = r5.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r1 = r1 | r2
            r5.bitField0_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            goto L_0x000c
        L_0x0078:
            int r1 = r5.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0083
            com.baidu.lcp.sdk.pb.LcmPb$LcmRequest r1 = r5.lcmRequest_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmRequest$Builder r4 = r1.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
        L_0x0083:
            com.google.protobuf.Parser<com.baidu.lcp.sdk.pb.LcmPb$LcmRequest> r1 = com.baidu.lcp.sdk.pb.LcmPb$LcmRequest.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.google.protobuf.MessageLite r1 = r6.readMessage(r1, (com.google.protobuf.ExtensionRegistryLite) r7)     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmRequest r1 = (com.baidu.lcp.sdk.pb.LcmPb$LcmRequest) r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r5.lcmRequest_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            if (r4 == 0) goto L_0x0098
            r4.mergeFrom((com.baidu.lcp.sdk.pb.LcmPb$LcmRequest) r1)     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            com.baidu.lcp.sdk.pb.LcmPb$LcmRequest r1 = r4.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r5.lcmRequest_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
        L_0x0098:
            int r1 = r5.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            r1 = r1 | r2
            r5.bitField0_ = r1     // Catch:{ InvalidProtocolBufferException -> 0x00b3, IOException -> 0x00a4 }
            goto L_0x000c
        L_0x009f:
            r0 = 1
            goto L_0x000c
        L_0x00a2:
            r6 = move-exception
            goto L_0x00b9
        L_0x00a4:
            r6 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r7 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x00a2 }
            r7.<init>((java.lang.String) r6)     // Catch:{ all -> 0x00a2 }
            com.google.protobuf.InvalidProtocolBufferException r6 = r7.setUnfinishedMessage(r5)     // Catch:{ all -> 0x00a2 }
            throw r6     // Catch:{ all -> 0x00a2 }
        L_0x00b3:
            r6 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r6 = r6.setUnfinishedMessage(r5)     // Catch:{ all -> 0x00a2 }
            throw r6     // Catch:{ all -> 0x00a2 }
        L_0x00b9:
            r5.makeExtensionsImmutable()
            throw r6
        L_0x00bd:
            r5.makeExtensionsImmutable()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lcp.sdk.pb.LcmPb$RpcData.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
    }
}
