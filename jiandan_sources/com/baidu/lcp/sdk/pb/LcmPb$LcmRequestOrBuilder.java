package com.baidu.lcp.sdk.pb;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LcmPb$LcmRequestOrBuilder extends MessageLiteOrBuilder {
    int getAction();

    LcmPb$Common getCommon();

    int getConnType();

    long getLogId();

    int getStartType();

    long getTimestamp();

    String getToken();

    ByteString getTokenBytes();

    boolean hasAction();

    boolean hasCommon();

    boolean hasConnType();

    boolean hasLogId();

    boolean hasStartType();

    boolean hasTimestamp();

    boolean hasToken();
}
