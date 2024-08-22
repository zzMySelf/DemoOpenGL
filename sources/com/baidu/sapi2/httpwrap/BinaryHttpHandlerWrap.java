package com.baidu.sapi2.httpwrap;

import android.os.Looper;

public class BinaryHttpHandlerWrap extends HttpHandlerWrap {
    public String[] allowedContentTypes;

    public BinaryHttpHandlerWrap(Looper looper) {
        super(looper);
    }

    public BinaryHttpHandlerWrap(Looper looper, String[] allowedContentTypes2) {
        this.allowedContentTypes = allowedContentTypes2;
    }

    public BinaryHttpHandlerWrap(boolean executCallbackInChildThread, String[] allowedContentTypes2) {
        this.executCallbackInChildThread = executCallbackInChildThread;
        this.allowedContentTypes = allowedContentTypes2;
    }

    /* access modifiers changed from: protected */
    public void onSuccess(int statusCode, byte[] binaryData) {
    }
}
