package com.baidubce.http;

import com.baidubce.callback.BceProgressCallback;
import com.baidubce.model.AbstractBceRequest;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class BceServiceResponseBody<T extends AbstractBceRequest> extends ResponseBody {
    public BceProgressCallback<T> bceProgressCallback;
    public BufferedSource bceRespBufferedSource;
    public final ResponseBody bceResponseBody;
    public T request;

    public BceServiceResponseBody(ResponseBody responseBody, T t, BceProgressCallback<T> bceProgressCallback2) {
        this.bceResponseBody = responseBody;
        this.request = t;
        this.bceProgressCallback = bceProgressCallback2;
    }

    public long contentLength() {
        return this.bceResponseBody.contentLength();
    }

    public MediaType contentType() {
        return this.bceResponseBody.contentType();
    }

    public BufferedSource source() {
        if (this.bceRespBufferedSource == null) {
            this.bceRespBufferedSource = Okio.buffer(source(this.bceResponseBody.source()));
        }
        return this.bceRespBufferedSource;
    }

    private Source source(BufferedSource bufferedSource) {
        return new ForwardingSource(bufferedSource) {
            public long totalBytesRead = 0;

            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                this.totalBytesRead += read != -1 ? read : 0;
                if (BceServiceResponseBody.this.bceProgressCallback != null && this.totalBytesRead > 0) {
                    BceServiceResponseBody.this.bceProgressCallback.onProgress(BceServiceResponseBody.this.request, this.totalBytesRead, BceServiceResponseBody.this.bceResponseBody.contentLength());
                }
                return read;
            }
        };
    }
}
