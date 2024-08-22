package com.baidu.lcp.sdk.pb;

import com.google.protobuf.MessageLiteOrBuilder;

public interface RpcMetaPb$RpcNotifyMetaOrBuilder extends MessageLiteOrBuilder {
    long getLogId();

    long getMethodId();

    long getServiceId();

    boolean hasLogId();

    boolean hasMethodId();

    boolean hasServiceId();
}
