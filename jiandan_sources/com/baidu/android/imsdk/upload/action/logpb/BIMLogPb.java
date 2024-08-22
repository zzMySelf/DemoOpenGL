package com.baidu.android.imsdk.upload.action.logpb;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;

public final class BIMLogPb {

    public static final class LogRequest extends GeneratedMessageLite implements LogRequestOrBuilder {
        public static final Parser<LogRequest> PARSER = new AbstractParser<LogRequest>() {
            public LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogRequest(codedInputStream, extensionRegistryLite);
            }
        };
        public static final LogRequest defaultInstance;
        public static final long serialVersionUID = 0;
        public AuthInfo authInfo;
        public int bitField0;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public ByteString payload;
        public long requestTimestampMs;
        public Object serviceName;
        public Object sign;
        public long version;

        public static final class AuthInfo extends GeneratedMessageLite implements AuthInfoOrBuilder {
            public static final Parser<AuthInfo> PARSER = new AbstractParser<AuthInfo>() {
                public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new AuthInfo(codedInputStream, extensionRegistryLite);
                }
            };
            public static final AuthInfo defaultInstance;
            public static final long serialVersionUID = 0;
            public int bitField0;
            public byte memoizedIsInitialized;
            public int memoizedSerializedSize;
            public Object token;

            public static final class Builder extends GeneratedMessageLite.Builder<AuthInfo, Builder> implements AuthInfoOrBuilder {
                public int bitField0;
                public Object token = "";

                public Builder() {
                    maybeForceBuilderInitialization();
                }

                public static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder setToken(String str) {
                    if (str != null) {
                        this.bitField0 |= 1;
                        this.token = str;
                        return this;
                    }
                    throw null;
                }

                public AuthInfo build() {
                    AuthInfo buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                public AuthInfo buildPartial() {
                    AuthInfo authInfo = new AuthInfo((GeneratedMessageLite.Builder) this);
                    int i2 = 1;
                    if ((this.bitField0 & 1) != 1) {
                        i2 = 0;
                    }
                    Object unused = authInfo.token = this.token;
                    int unused2 = authInfo.bitField0 = i2;
                    return authInfo;
                }

                public Builder clear() {
                    super.clear();
                    this.token = "";
                    this.bitField0 &= -2;
                    return this;
                }

                public AuthInfo getDefaultInstanceForType() {
                    return AuthInfo.getDefaultInstance();
                }

                public Builder mergeFrom(AuthInfo authInfo) {
                    if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                        this.bitField0 |= 1;
                        this.token = authInfo.token;
                    }
                    return this;
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    AuthInfo authInfo;
                    AuthInfo authInfo2 = null;
                    try {
                        AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        authInfo = (AuthInfo) e.getUnfinishedMessage();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        authInfo2 = authInfo;
                    }
                    if (authInfo2 != null) {
                        mergeFrom(authInfo2);
                    }
                    throw th;
                }
            }

            static {
                AuthInfo authInfo = new AuthInfo(true);
                defaultInstance = authInfo;
                authInfo.initFields();
            }

            public static AuthInfo getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.token = "";
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Parser<AuthInfo> getParserForType() {
                return PARSER;
            }

            public int getSerializedSize() {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                if ((this.bitField0 & 1) == 1) {
                    i3 = 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes());
                }
                this.memoizedSerializedSize = i3;
                return i3;
            }

            public ByteString getTokenBytes() {
                Object obj = this.token;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasToken() {
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
                    codedOutputStream.writeBytes(1, getTokenBytes());
                }
            }

            public static Builder newBuilder(AuthInfo authInfo) {
                return newBuilder().mergeFrom(authInfo);
            }

            public AuthInfo getDefaultInstanceForType() {
                return defaultInstance;
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }

            public AuthInfo(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
            }

            public AuthInfo(boolean z) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
            }

            public AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.bitField0 |= 1;
                                this.token = codedInputStream.readBytes();
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

        public interface AuthInfoOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LogRequest, Builder> implements LogRequestOrBuilder {
            public AuthInfo authInfo = AuthInfo.getDefaultInstance();
            public int bitField0;
            public ByteString payload = ByteString.EMPTY;
            public long requestTimestampMs;
            public Object serviceName = "";
            public Object sign = "";
            public long version;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeAuthInfo(AuthInfo authInfo2) {
                if ((this.bitField0 & 4) != 4 || this.authInfo == AuthInfo.getDefaultInstance()) {
                    this.authInfo = authInfo2;
                } else {
                    this.authInfo = AuthInfo.newBuilder(this.authInfo).mergeFrom(authInfo2).buildPartial();
                }
                this.bitField0 |= 4;
                return this;
            }

            public Builder setAuthInfo(AuthInfo authInfo2) {
                if (authInfo2 != null) {
                    this.authInfo = authInfo2;
                    this.bitField0 |= 4;
                    return this;
                }
                throw null;
            }

            public Builder setPayload(ByteString byteString) {
                if (byteString != null) {
                    this.bitField0 |= 32;
                    this.payload = byteString;
                    return this;
                }
                throw null;
            }

            public Builder setRequestTimestampMs(long j) {
                this.bitField0 |= 8;
                this.requestTimestampMs = j;
                return this;
            }

            public Builder setServiceName(String str) {
                if (str != null) {
                    this.bitField0 |= 2;
                    this.serviceName = str;
                    return this;
                }
                throw null;
            }

            public Builder setSign(String str) {
                if (str != null) {
                    this.bitField0 |= 16;
                    this.sign = str;
                    return this;
                }
                throw null;
            }

            public Builder setVersion(long j) {
                this.bitField0 |= 1;
                this.version = j;
                return this;
            }

            public LogRequest build() {
                LogRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public LogRequest buildPartial() {
                LogRequest logRequest = new LogRequest((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                long unused = logRequest.version = this.version;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = logRequest.serviceName = this.serviceName;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                AuthInfo unused3 = logRequest.authInfo = this.authInfo;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                long unused4 = logRequest.requestTimestampMs = this.requestTimestampMs;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                Object unused5 = logRequest.sign = this.sign;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                ByteString unused6 = logRequest.payload = this.payload;
                int unused7 = logRequest.bitField0 = i3;
                return logRequest;
            }

            public Builder clear() {
                super.clear();
                this.version = 0;
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.serviceName = "";
                this.bitField0 = i2 & -3;
                this.authInfo = AuthInfo.getDefaultInstance();
                int i3 = this.bitField0 & -5;
                this.bitField0 = i3;
                this.requestTimestampMs = 0;
                int i4 = i3 & -9;
                this.bitField0 = i4;
                this.sign = "";
                int i5 = i4 & -17;
                this.bitField0 = i5;
                this.payload = ByteString.EMPTY;
                this.bitField0 = i5 & -33;
                return this;
            }

            public LogRequest getDefaultInstanceForType() {
                return LogRequest.getDefaultInstance();
            }

            public Builder mergeFrom(LogRequest logRequest) {
                if (logRequest == LogRequest.getDefaultInstance()) {
                    return this;
                }
                if (logRequest.hasVersion()) {
                    setVersion(logRequest.getVersion());
                }
                if (logRequest.hasServiceName()) {
                    this.bitField0 |= 2;
                    this.serviceName = logRequest.serviceName;
                }
                if (logRequest.hasAuthInfo()) {
                    mergeAuthInfo(logRequest.getAuthInfo());
                }
                if (logRequest.hasRequestTimestampMs()) {
                    setRequestTimestampMs(logRequest.getRequestTimestampMs());
                }
                if (logRequest.hasSign()) {
                    this.bitField0 |= 16;
                    this.sign = logRequest.sign;
                }
                if (logRequest.hasPayload()) {
                    setPayload(logRequest.getPayload());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogRequest logRequest;
                LogRequest logRequest2 = null;
                try {
                    LogRequest parsePartialFrom = LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    logRequest = (LogRequest) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    logRequest2 = logRequest;
                }
                if (logRequest2 != null) {
                    mergeFrom(logRequest2);
                }
                throw th;
            }
        }

        static {
            LogRequest logRequest = new LogRequest(true);
            defaultInstance = logRequest;
            logRequest.initFields();
        }

        public static LogRequest getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.version = 0;
            this.serviceName = "";
            this.authInfo = AuthInfo.getDefaultInstance();
            this.requestTimestampMs = 0;
            this.sign = "";
            this.payload = ByteString.EMPTY;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public AuthInfo getAuthInfo() {
            return this.authInfo;
        }

        public Parser<LogRequest> getParserForType() {
            return PARSER;
        }

        public ByteString getPayload() {
            return this.payload;
        }

        public long getRequestTimestampMs() {
            return this.requestTimestampMs;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeInt64Size(1, this.version);
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getServiceNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeMessageSize(3, this.authInfo);
            }
            if ((this.bitField0 & 8) == 8) {
                i3 += CodedOutputStream.computeInt64Size(4, this.requestTimestampMs);
            }
            if ((this.bitField0 & 16) == 16) {
                i3 += CodedOutputStream.computeBytesSize(5, getSignBytes());
            }
            if ((this.bitField0 & 32) == 32) {
                i3 += CodedOutputStream.computeBytesSize(6, this.payload);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public ByteString getServiceNameBytes() {
            Object obj = this.serviceName;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.serviceName = copyFromUtf8;
            return copyFromUtf8;
        }

        public ByteString getSignBytes() {
            Object obj = this.sign;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sign = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getVersion() {
            return this.version;
        }

        public boolean hasAuthInfo() {
            return (this.bitField0 & 4) == 4;
        }

        public boolean hasPayload() {
            return (this.bitField0 & 32) == 32;
        }

        public boolean hasRequestTimestampMs() {
            return (this.bitField0 & 8) == 8;
        }

        public boolean hasServiceName() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasSign() {
            return (this.bitField0 & 16) == 16;
        }

        public boolean hasVersion() {
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
                codedOutputStream.writeInt64(1, this.version);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getServiceNameBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeMessage(3, this.authInfo);
            }
            if ((this.bitField0 & 8) == 8) {
                codedOutputStream.writeInt64(4, this.requestTimestampMs);
            }
            if ((this.bitField0 & 16) == 16) {
                codedOutputStream.writeBytes(5, getSignBytes());
            }
            if ((this.bitField0 & 32) == 32) {
                codedOutputStream.writeBytes(6, this.payload);
            }
        }

        public static Builder newBuilder(LogRequest logRequest) {
            return newBuilder().mergeFrom(logRequest);
        }

        public LogRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public LogRequest(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public LogRequest(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.version = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.serviceName = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            AuthInfo.Builder builder = (this.bitField0 & 4) == 4 ? this.authInfo.toBuilder() : null;
                            AuthInfo authInfo2 = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                            this.authInfo = authInfo2;
                            if (builder != null) {
                                builder.mergeFrom(authInfo2);
                                this.authInfo = builder.buildPartial();
                            }
                            this.bitField0 |= 4;
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.requestTimestampMs = codedInputStream.readInt64();
                        } else if (readTag == 42) {
                            this.bitField0 |= 16;
                            this.sign = codedInputStream.readBytes();
                        } else if (readTag == 50) {
                            this.bitField0 |= 32;
                            this.payload = codedInputStream.readBytes();
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

    public interface LogRequestOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class LogResponse extends GeneratedMessageLite implements LogResponseOrBuilder {
        public static final Parser<LogResponse> PARSER = new AbstractParser<LogResponse>() {
            public LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogResponse(codedInputStream, extensionRegistryLite);
            }
        };
        public static final LogResponse defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0;
        public int errorCode;
        public Object errorMsg;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public long pingIntervalMs;

        public static final class Builder extends GeneratedMessageLite.Builder<LogResponse, Builder> implements LogResponseOrBuilder {
            public int bitField0;
            public int errorCode;
            public Object errorMsg = "";
            public long pingIntervalMs;

            public Builder() {
                maybeForceBuilderInitialization();
            }

            public static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder setErrorCode(int i2) {
                this.bitField0 |= 1;
                this.errorCode = i2;
                return this;
            }

            public Builder setPingIntervalMs(long j) {
                this.bitField0 |= 4;
                this.pingIntervalMs = j;
                return this;
            }

            public LogResponse build() {
                LogResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public LogResponse buildPartial() {
                LogResponse logResponse = new LogResponse((GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                int unused = logResponse.errorCode = this.errorCode;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = logResponse.errorMsg = this.errorMsg;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                long unused3 = logResponse.pingIntervalMs = this.pingIntervalMs;
                int unused4 = logResponse.bitField0 = i3;
                return logResponse;
            }

            public Builder clear() {
                super.clear();
                this.errorCode = 0;
                int i2 = this.bitField0 & -2;
                this.bitField0 = i2;
                this.errorMsg = "";
                int i3 = i2 & -3;
                this.bitField0 = i3;
                this.pingIntervalMs = 0;
                this.bitField0 = i3 & -5;
                return this;
            }

            public LogResponse getDefaultInstanceForType() {
                return LogResponse.getDefaultInstance();
            }

            public Builder mergeFrom(LogResponse logResponse) {
                if (logResponse == LogResponse.getDefaultInstance()) {
                    return this;
                }
                if (logResponse.hasErrorCode()) {
                    setErrorCode(logResponse.getErrorCode());
                }
                if (logResponse.hasErrorMsg()) {
                    this.bitField0 |= 2;
                    this.errorMsg = logResponse.errorMsg;
                }
                if (logResponse.hasPingIntervalMs()) {
                    setPingIntervalMs(logResponse.getPingIntervalMs());
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogResponse logResponse;
                LogResponse logResponse2 = null;
                try {
                    LogResponse parsePartialFrom = LogResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    logResponse = (LogResponse) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    logResponse2 = logResponse;
                }
                if (logResponse2 != null) {
                    mergeFrom(logResponse2);
                }
                throw th;
            }
        }

        static {
            LogResponse logResponse = new LogResponse(true);
            defaultInstance = logResponse;
            logResponse.initFields();
        }

        public static LogResponse getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.errorCode = 0;
            this.errorMsg = "";
            this.pingIntervalMs = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            Object obj = this.errorMsg;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.errorMsg = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getErrorMsgBytes() {
            Object obj = this.errorMsg;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errorMsg = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser<LogResponse> getParserForType() {
            return PARSER;
        }

        public long getPingIntervalMs() {
            return this.pingIntervalMs;
        }

        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.bitField0 & 1) == 1) {
                i3 = 0 + CodedOutputStream.computeInt32Size(1, this.errorCode);
            }
            if ((this.bitField0 & 2) == 2) {
                i3 += CodedOutputStream.computeBytesSize(2, getErrorMsgBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                i3 += CodedOutputStream.computeInt64Size(3, this.pingIntervalMs);
            }
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public boolean hasErrorCode() {
            return (this.bitField0 & 1) == 1;
        }

        public boolean hasErrorMsg() {
            return (this.bitField0 & 2) == 2;
        }

        public boolean hasPingIntervalMs() {
            return (this.bitField0 & 4) == 4;
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
                codedOutputStream.writeInt32(1, this.errorCode);
            }
            if ((this.bitField0 & 2) == 2) {
                codedOutputStream.writeBytes(2, getErrorMsgBytes());
            }
            if ((this.bitField0 & 4) == 4) {
                codedOutputStream.writeInt64(3, this.pingIntervalMs);
            }
        }

        public static Builder newBuilder(LogResponse logResponse) {
            return newBuilder().mergeFrom(logResponse);
        }

        public LogResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public LogResponse(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public LogResponse(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
        }

        public LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.errorCode = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.errorMsg = codedInputStream.readBytes();
                        } else if (readTag == 24) {
                            this.bitField0 |= 4;
                            this.pingIntervalMs = codedInputStream.readInt64();
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

    public interface LogResponseOrBuilder extends MessageLiteOrBuilder {
    }
}
