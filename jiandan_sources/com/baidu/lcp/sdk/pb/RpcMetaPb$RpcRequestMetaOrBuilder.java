package com.baidu.lcp.sdk.pb;

import com.google.protobuf.MessageLiteOrBuilder;

public interface RpcMetaPb$RpcRequestMetaOrBuilder extends MessageLiteOrBuilder {
    long getLogId();

    long getMethodId();

    int getNeedCommon();

    long getServiceId();

    boolean hasLogId();

    boolean hasMethodId();

    boolean hasNeedCommon();

    boolean hasServiceId();
}
