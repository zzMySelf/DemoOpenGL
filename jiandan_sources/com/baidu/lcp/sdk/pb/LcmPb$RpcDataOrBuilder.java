package com.baidu.lcp.sdk.pb;

import com.google.protobuf.MessageLiteOrBuilder;

public interface LcmPb$RpcDataOrBuilder extends MessageLiteOrBuilder {
    LcmPb$LcmNotify getLcmNotify();

    LcmPb$LcmRequest getLcmRequest();

    LcmPb$LcmResponse getLcmResponse();

    boolean hasLcmNotify();

    boolean hasLcmRequest();

    boolean hasLcmResponse();
}
