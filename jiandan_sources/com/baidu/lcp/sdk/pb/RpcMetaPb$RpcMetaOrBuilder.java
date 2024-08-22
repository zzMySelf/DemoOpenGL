package com.baidu.lcp.sdk.pb;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface RpcMetaPb$RpcMetaOrBuilder extends MessageLiteOrBuilder {
    int getAcceptCompressType();

    int getAttachmentSize();

    ByteString getAuthenticationData();

    RpcMetaPb$ChunkInfo getChunkInfo();

    int getCompressType();

    long getCorrelationId();

    RpcMetaPb$RpcNotifyMeta getNotify();

    RpcMetaPb$RpcRequestMeta getRequest();

    RpcMetaPb$RpcResponseMeta getResponse();

    boolean hasAcceptCompressType();

    boolean hasAttachmentSize();

    boolean hasAuthenticationData();

    boolean hasChunkInfo();

    boolean hasCompressType();

    boolean hasCorrelationId();

    boolean hasNotify();

    boolean hasRequest();

    boolean hasResponse();
}
