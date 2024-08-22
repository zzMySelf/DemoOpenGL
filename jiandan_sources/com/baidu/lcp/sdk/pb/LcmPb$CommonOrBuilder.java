package com.baidu.lcp.sdk.pb;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LcmPb$CommonOrBuilder extends MessageLiteOrBuilder {
    String getAppId();

    ByteString getAppIdBytes();

    String getAppVersion();

    ByteString getAppVersionBytes();

    String getCuid();

    ByteString getCuidBytes();

    String getDeviceType();

    ByteString getDeviceTypeBytes();

    String getManufacture();

    ByteString getManufactureBytes();

    String getModelType();

    ByteString getModelTypeBytes();

    String getNetwork();

    ByteString getNetworkBytes();

    String getOsVersion();

    ByteString getOsVersionBytes();

    String getRomVersion();

    ByteString getRomVersionBytes();

    String getSdkVersion();

    ByteString getSdkVersionBytes();

    boolean hasAppId();

    boolean hasAppVersion();

    boolean hasCuid();

    boolean hasDeviceType();

    boolean hasManufacture();

    boolean hasModelType();

    boolean hasNetwork();

    boolean hasOsVersion();

    boolean hasRomVersion();

    boolean hasSdkVersion();
}
