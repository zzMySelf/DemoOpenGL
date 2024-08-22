package com.baidu.lcp.sdk.pb;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LcmPb$LcmResponseOrBuilder extends MessageLiteOrBuilder {
    int getErrorCode();

    String getErrorMsg();

    ByteString getErrorMsgBytes();

    long getLogId();

    long getNextIntervalMs();

    boolean hasErrorCode();

    boolean hasErrorMsg();

    boolean hasLogId();

    boolean hasNextIntervalMs();
}
