package com.baidu.lcp.sdk.pb;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RpcMetaPb$RpcResponseMetaOrBuilder extends MessageLiteOrBuilder {
    int getErrorCode();

    String getErrorText();

    ByteString getErrorTextBytes();

    long getLogId();

    long getMethodId();

    long getServiceId();

    boolean hasErrorCode();

    boolean hasErrorText();

    boolean hasLogId();

    boolean hasMethodId();

    boolean hasServiceId();
}
