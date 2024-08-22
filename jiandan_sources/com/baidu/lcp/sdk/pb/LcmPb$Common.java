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

public final class LcmPb$Common extends GeneratedMessageLite implements LcmPb$CommonOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 6;
    public static final int APP_VERSION_FIELD_NUMBER = 7;
    public static final int CUID_FIELD_NUMBER = 1;
    public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
    public static final int MANUFACTURE_FIELD_NUMBER = 4;
    public static final int MODEL_TYPE_FIELD_NUMBER = 5;
    public static final int NETWORK_FIELD_NUMBER = 9;
    public static final int OS_VERSION_FIELD_NUMBER = 3;
    public static Parser<LcmPb$Common> PARSER = new qw();
    public static final int ROM_VERSION_FIELD_NUMBER = 10;
    public static final int SDK_VERSION_FIELD_NUMBER = 8;
    public static final LcmPb$Common defaultInstance;
    public static final long serialVersionUID = 0;
    public Object appId_;
    public Object appVersion_;
    public int bitField0_;
    public Object cuid_;
    public Object deviceType_;
    public Object manufacture_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public Object modelType_;
    public Object network_;
    public Object osVersion_;
    public Object romVersion_;
    public Object sdkVersion_;

    public static final class Builder extends GeneratedMessageLite.Builder<LcmPb$Common, Builder> implements LcmPb$CommonOrBuilder {
        public Object appId_ = "";
        public Object appVersion_ = "";
        public int bitField0_;
        public Object cuid_ = "";
        public Object deviceType_ = "";
        public Object manufacture_ = "";
        public Object modelType_ = "";
        public Object network_ = "";
        public Object osVersion_ = "";
        public Object romVersion_ = "";
        public Object sdkVersion_ = "";

        public Builder() {
            maybeForceBuilderInitialization();
        }

        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public Builder clearAppId() {
            this.bitField0_ &= -33;
            this.appId_ = LcmPb$Common.getDefaultInstance().getAppId();
            return this;
        }

        public Builder clearAppVersion() {
            this.bitField0_ &= -65;
            this.appVersion_ = LcmPb$Common.getDefaultInstance().getAppVersion();
            return this;
        }

        public Builder clearCuid() {
            this.bitField0_ &= -2;
            this.cuid_ = LcmPb$Common.getDefaultInstance().getCuid();
            return this;
        }

        public Builder clearDeviceType() {
            this.bitField0_ &= -3;
            this.deviceType_ = LcmPb$Common.getDefaultInstance().getDeviceType();
            return this;
        }

        public Builder clearManufacture() {
            this.bitField0_ &= -9;
            this.manufacture_ = LcmPb$Common.getDefaultInstance().getManufacture();
            return this;
        }

        public Builder clearModelType() {
            this.bitField0_ &= -17;
            this.modelType_ = LcmPb$Common.getDefaultInstance().getModelType();
            return this;
        }

        public Builder clearNetwork() {
            this.bitField0_ &= -257;
            this.network_ = LcmPb$Common.getDefaultInstance().getNetwork();
            return this;
        }

        public Builder clearOsVersion() {
            this.bitField0_ &= -5;
            this.osVersion_ = LcmPb$Common.getDefaultInstance().getOsVersion();
            return this;
        }

        public Builder clearRomVersion() {
            this.bitField0_ &= -513;
            this.romVersion_ = LcmPb$Common.getDefaultInstance().getRomVersion();
            return this;
        }

        public Builder clearSdkVersion() {
            this.bitField0_ &= -129;
            this.sdkVersion_ = LcmPb$Common.getDefaultInstance().getSdkVersion();
            return this;
        }

        public String getAppId() {
            Object obj = this.appId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getAppIdBytes() {
            Object obj = this.appId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.appId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getAppVersion() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appVersion_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.appVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getCuid() {
            Object obj = this.cuid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.cuid_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCuidBytes() {
            Object obj = this.cuid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cuid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getDeviceType() {
            Object obj = this.deviceType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceType_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceTypeBytes() {
            Object obj = this.deviceType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceType_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getManufacture() {
            Object obj = this.manufacture_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.manufacture_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getManufactureBytes() {
            Object obj = this.manufacture_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.manufacture_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getModelType() {
            Object obj = this.modelType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.modelType_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getModelTypeBytes() {
            Object obj = this.modelType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.modelType_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getNetwork() {
            Object obj = this.network_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.network_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getNetworkBytes() {
            Object obj = this.network_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.network_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getOsVersion() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.osVersion_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.osVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getRomVersion() {
            Object obj = this.romVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.romVersion_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getRomVersionBytes() {
            Object obj = this.romVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.romVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getSdkVersion() {
            Object obj = this.sdkVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sdkVersion_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSdkVersionBytes() {
            Object obj = this.sdkVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sdkVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean hasAppId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasAppVersion() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasCuid() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasDeviceType() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasManufacture() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasModelType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasNetwork() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasOsVersion() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasRomVersion() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasSdkVersion() {
            return (this.bitField0_ & 128) == 128;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder setAppId(String str) {
            if (str != null) {
                this.bitField0_ |= 32;
                this.appId_ = str;
                return this;
            }
            throw null;
        }

        public Builder setAppIdBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 32;
                this.appId_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setAppVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 64;
                this.appVersion_ = str;
                return this;
            }
            throw null;
        }

        public Builder setAppVersionBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 64;
                this.appVersion_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setCuid(String str) {
            if (str != null) {
                this.bitField0_ |= 1;
                this.cuid_ = str;
                return this;
            }
            throw null;
        }

        public Builder setCuidBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 1;
                this.cuid_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setDeviceType(String str) {
            if (str != null) {
                this.bitField0_ |= 2;
                this.deviceType_ = str;
                return this;
            }
            throw null;
        }

        public Builder setDeviceTypeBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 2;
                this.deviceType_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setManufacture(String str) {
            if (str != null) {
                this.bitField0_ |= 8;
                this.manufacture_ = str;
                return this;
            }
            throw null;
        }

        public Builder setManufactureBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 8;
                this.manufacture_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setModelType(String str) {
            if (str != null) {
                this.bitField0_ |= 16;
                this.modelType_ = str;
                return this;
            }
            throw null;
        }

        public Builder setModelTypeBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 16;
                this.modelType_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setNetwork(String str) {
            if (str != null) {
                this.bitField0_ |= 256;
                this.network_ = str;
                return this;
            }
            throw null;
        }

        public Builder setNetworkBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 256;
                this.network_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setOsVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 4;
                this.osVersion_ = str;
                return this;
            }
            throw null;
        }

        public Builder setOsVersionBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 4;
                this.osVersion_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setRomVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 512;
                this.romVersion_ = str;
                return this;
            }
            throw null;
        }

        public Builder setRomVersionBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 512;
                this.romVersion_ = byteString;
                return this;
            }
            throw null;
        }

        public Builder setSdkVersion(String str) {
            if (str != null) {
                this.bitField0_ |= 128;
                this.sdkVersion_ = str;
                return this;
            }
            throw null;
        }

        public Builder setSdkVersionBytes(ByteString byteString) {
            if (byteString != null) {
                this.bitField0_ |= 128;
                this.sdkVersion_ = byteString;
                return this;
            }
            throw null;
        }

        public LcmPb$Common build() {
            LcmPb$Common buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public LcmPb$Common buildPartial() {
            LcmPb$Common lcmPb$Common = new LcmPb$Common((GeneratedMessageLite.Builder) this);
            int i2 = this.bitField0_;
            int i3 = 1;
            if ((i2 & 1) != 1) {
                i3 = 0;
            }
            Object unused = lcmPb$Common.cuid_ = this.cuid_;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            Object unused2 = lcmPb$Common.deviceType_ = this.deviceType_;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            Object unused3 = lcmPb$Common.osVersion_ = this.osVersion_;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            Object unused4 = lcmPb$Common.manufacture_ = this.manufacture_;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            Object unused5 = lcmPb$Common.modelType_ = this.modelType_;
            if ((i2 & 32) == 32) {
                i3 |= 32;
            }
            Object unused6 = lcmPb$Common.appId_ = this.appId_;
            if ((i2 & 64) == 64) {
                i3 |= 64;
            }
            Object unused7 = lcmPb$Common.appVersion_ = this.appVersion_;
            if ((i2 & 128) == 128) {
                i3 |= 128;
            }
            Object unused8 = lcmPb$Common.sdkVersion_ = this.sdkVersion_;
            if ((i2 & 256) == 256) {
                i3 |= 256;
            }
            Object unused9 = lcmPb$Common.network_ = this.network_;
            if ((i2 & 512) == 512) {
                i3 |= 512;
            }
            Object unused10 = lcmPb$Common.romVersion_ = this.romVersion_;
            int unused11 = lcmPb$Common.bitField0_ = i3;
            return lcmPb$Common;
        }

        public Builder clear() {
            super.clear();
            this.cuid_ = "";
            int i2 = this.bitField0_ & -2;
            this.bitField0_ = i2;
            this.deviceType_ = "";
            int i3 = i2 & -3;
            this.bitField0_ = i3;
            this.osVersion_ = "";
            int i4 = i3 & -5;
            this.bitField0_ = i4;
            this.manufacture_ = "";
            int i5 = i4 & -9;
            this.bitField0_ = i5;
            this.modelType_ = "";
            int i6 = i5 & -17;
            this.bitField0_ = i6;
            this.appId_ = "";
            int i7 = i6 & -33;
            this.bitField0_ = i7;
            this.appVersion_ = "";
            int i8 = i7 & -65;
            this.bitField0_ = i8;
            this.sdkVersion_ = "";
            int i9 = i8 & -129;
            this.bitField0_ = i9;
            this.network_ = "";
            int i10 = i9 & -257;
            this.bitField0_ = i10;
            this.romVersion_ = "";
            this.bitField0_ = i10 & -513;
            return this;
        }

        public LcmPb$Common getDefaultInstanceForType() {
            return LcmPb$Common.getDefaultInstance();
        }

        public Builder mergeFrom(LcmPb$Common lcmPb$Common) {
            if (lcmPb$Common == LcmPb$Common.getDefaultInstance()) {
                return this;
            }
            if (lcmPb$Common.hasCuid()) {
                this.bitField0_ |= 1;
                this.cuid_ = lcmPb$Common.cuid_;
            }
            if (lcmPb$Common.hasDeviceType()) {
                this.bitField0_ |= 2;
                this.deviceType_ = lcmPb$Common.deviceType_;
            }
            if (lcmPb$Common.hasOsVersion()) {
                this.bitField0_ |= 4;
                this.osVersion_ = lcmPb$Common.osVersion_;
            }
            if (lcmPb$Common.hasManufacture()) {
                this.bitField0_ |= 8;
                this.manufacture_ = lcmPb$Common.manufacture_;
            }
            if (lcmPb$Common.hasModelType()) {
                this.bitField0_ |= 16;
                this.modelType_ = lcmPb$Common.modelType_;
            }
            if (lcmPb$Common.hasAppId()) {
                this.bitField0_ |= 32;
                this.appId_ = lcmPb$Common.appId_;
            }
            if (lcmPb$Common.hasAppVersion()) {
                this.bitField0_ |= 64;
                this.appVersion_ = lcmPb$Common.appVersion_;
            }
            if (lcmPb$Common.hasSdkVersion()) {
                this.bitField0_ |= 128;
                this.sdkVersion_ = lcmPb$Common.sdkVersion_;
            }
            if (lcmPb$Common.hasNetwork()) {
                this.bitField0_ |= 256;
                this.network_ = lcmPb$Common.network_;
            }
            if (lcmPb$Common.hasRomVersion()) {
                this.bitField0_ |= 512;
                this.romVersion_ = lcmPb$Common.romVersion_;
            }
            return this;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            LcmPb$Common lcmPb$Common;
            LcmPb$Common lcmPb$Common2 = null;
            try {
                LcmPb$Common parsePartialFrom = LcmPb$Common.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                lcmPb$Common = (LcmPb$Common) e.getUnfinishedMessage();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                lcmPb$Common2 = lcmPb$Common;
            }
            if (lcmPb$Common2 != null) {
                mergeFrom(lcmPb$Common2);
            }
            throw th;
        }
    }

    public class qw extends AbstractParser<LcmPb$Common> {
        /* renamed from: qw */
        public LcmPb$Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LcmPb$Common(codedInputStream, extensionRegistryLite);
        }
    }

    static {
        LcmPb$Common lcmPb$Common = new LcmPb$Common(true);
        defaultInstance = lcmPb$Common;
        lcmPb$Common.initFields();
    }

    public static LcmPb$Common getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.cuid_ = "";
        this.deviceType_ = "";
        this.osVersion_ = "";
        this.manufacture_ = "";
        this.modelType_ = "";
        this.appId_ = "";
        this.appVersion_ = "";
        this.sdkVersion_ = "";
        this.network_ = "";
        this.romVersion_ = "";
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static LcmPb$Common parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static LcmPb$Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public String getAppId() {
        Object obj = this.appId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.appId_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getAppIdBytes() {
        Object obj = this.appId_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.appId_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getAppVersion() {
        Object obj = this.appVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.appVersion_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getAppVersionBytes() {
        Object obj = this.appVersion_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.appVersion_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getCuid() {
        Object obj = this.cuid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.cuid_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getCuidBytes() {
        Object obj = this.cuid_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.cuid_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getDeviceType() {
        Object obj = this.deviceType_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.deviceType_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getDeviceTypeBytes() {
        Object obj = this.deviceType_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.deviceType_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getManufacture() {
        Object obj = this.manufacture_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.manufacture_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getManufactureBytes() {
        Object obj = this.manufacture_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.manufacture_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getModelType() {
        Object obj = this.modelType_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.modelType_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getModelTypeBytes() {
        Object obj = this.modelType_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.modelType_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getNetwork() {
        Object obj = this.network_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.network_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getNetworkBytes() {
        Object obj = this.network_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.network_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getOsVersion() {
        Object obj = this.osVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.osVersion_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getOsVersionBytes() {
        Object obj = this.osVersion_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.osVersion_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public Parser<LcmPb$Common> getParserForType() {
        return PARSER;
    }

    public String getRomVersion() {
        Object obj = this.romVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.romVersion_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getRomVersionBytes() {
        Object obj = this.romVersion_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.romVersion_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public String getSdkVersion() {
        Object obj = this.sdkVersion_;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.sdkVersion_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getSdkVersionBytes() {
        Object obj = this.sdkVersion_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.sdkVersion_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public int getSerializedSize() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        if ((this.bitField0_ & 1) == 1) {
            i3 = 0 + CodedOutputStream.computeBytesSize(1, getCuidBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            i3 += CodedOutputStream.computeBytesSize(2, getDeviceTypeBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            i3 += CodedOutputStream.computeBytesSize(3, getOsVersionBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            i3 += CodedOutputStream.computeBytesSize(4, getManufactureBytes());
        }
        if ((this.bitField0_ & 16) == 16) {
            i3 += CodedOutputStream.computeBytesSize(5, getModelTypeBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            i3 += CodedOutputStream.computeBytesSize(6, getAppIdBytes());
        }
        if ((this.bitField0_ & 64) == 64) {
            i3 += CodedOutputStream.computeBytesSize(7, getAppVersionBytes());
        }
        if ((this.bitField0_ & 128) == 128) {
            i3 += CodedOutputStream.computeBytesSize(8, getSdkVersionBytes());
        }
        if ((this.bitField0_ & 256) == 256) {
            i3 += CodedOutputStream.computeBytesSize(9, getNetworkBytes());
        }
        if ((this.bitField0_ & 512) == 512) {
            i3 += CodedOutputStream.computeBytesSize(10, getRomVersionBytes());
        }
        this.memoizedSerializedSize = i3;
        return i3;
    }

    public boolean hasAppId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasAppVersion() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasCuid() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasDeviceType() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasManufacture() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasModelType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasNetwork() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasOsVersion() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasRomVersion() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasSdkVersion() {
        return (this.bitField0_ & 128) == 128;
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, getCuidBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, getDeviceTypeBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBytes(3, getOsVersionBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBytes(4, getManufactureBytes());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBytes(5, getModelTypeBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBytes(6, getAppIdBytes());
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeBytes(7, getAppVersionBytes());
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeBytes(8, getSdkVersionBytes());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeBytes(9, getNetworkBytes());
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeBytes(10, getRomVersionBytes());
        }
    }

    public static Builder newBuilder(LcmPb$Common lcmPb$Common) {
        return newBuilder().mergeFrom(lcmPb$Common);
    }

    public static LcmPb$Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public LcmPb$Common getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public LcmPb$Common(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LcmPb$Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LcmPb$Common parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public LcmPb$Common(boolean z) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }

    public static LcmPb$Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static LcmPb$Common parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static LcmPb$Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public LcmPb$Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                switch (readTag) {
                    case 0:
                        z = true;
                        break;
                    case 10:
                        this.bitField0_ |= 1;
                        this.cuid_ = codedInputStream.readBytes();
                        break;
                    case 18:
                        this.bitField0_ |= 2;
                        this.deviceType_ = codedInputStream.readBytes();
                        break;
                    case 26:
                        this.bitField0_ |= 4;
                        this.osVersion_ = codedInputStream.readBytes();
                        break;
                    case 34:
                        this.bitField0_ |= 8;
                        this.manufacture_ = codedInputStream.readBytes();
                        break;
                    case 42:
                        this.bitField0_ |= 16;
                        this.modelType_ = codedInputStream.readBytes();
                        break;
                    case 50:
                        this.bitField0_ |= 32;
                        this.appId_ = codedInputStream.readBytes();
                        break;
                    case 58:
                        this.bitField0_ |= 64;
                        this.appVersion_ = codedInputStream.readBytes();
                        break;
                    case 66:
                        this.bitField0_ |= 128;
                        this.sdkVersion_ = codedInputStream.readBytes();
                        break;
                    case 74:
                        this.bitField0_ |= 256;
                        this.network_ = codedInputStream.readBytes();
                        break;
                    case 82:
                        this.bitField0_ |= 512;
                        this.romVersion_ = codedInputStream.readBytes();
                        break;
                    default:
                        if (parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            break;
                        }
                        z = true;
                        break;
                }
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
