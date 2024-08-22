package com.baidu.searchbox.noveladapter.http;

import com.baidu.searchbox.noveladapter.http.INovelContainerBuildInter;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class NovelMultipartBody extends RequestBody {
    /* access modifiers changed from: private */
    public long currentLength;
    private final RequestBody proxyRequestBody;
    /* access modifiers changed from: private */
    public long totalLength;
    /* access modifiers changed from: private */
    public final INovelContainerBuildInter.UploadListener uploadListener;

    static /* synthetic */ long access$014(NovelMultipartBody x0, long x1) {
        long j2 = x0.currentLength + x1;
        x0.currentLength = j2;
        return j2;
    }

    public NovelMultipartBody(RequestBody requestBody, INovelContainerBuildInter.UploadListener listener) {
        this.proxyRequestBody = requestBody;
        this.uploadListener = listener;
    }

    public long contentLength() throws IOException {
        RequestBody requestBody = this.proxyRequestBody;
        if (requestBody == null) {
            return 0;
        }
        return requestBody.contentLength();
    }

    public MediaType contentType() {
        RequestBody requestBody = this.proxyRequestBody;
        if (requestBody == null) {
            return null;
        }
        return requestBody.contentType();
    }

    public void writeTo(BufferedSink sink) throws IOException {
        this.totalLength = contentLength();
        BufferedSink buffer = Okio.buffer((Sink) new ForwardingSink(sink) {
            public void write(Buffer source, long byteCount) throws IOException {
                NovelMultipartBody.access$014(NovelMultipartBody.this, byteCount);
                if (!(NovelMultipartBody.this.uploadListener == null || NovelMultipartBody.this.totalLength == 0)) {
                    int progress = (int) ((NovelMultipartBody.this.currentLength * 100) / NovelMultipartBody.this.totalLength);
                    if (progress > 100) {
                        progress = 100;
                    }
                    NovelMultipartBody.this.uploadListener.onProgress(progress);
                }
                super.write(source, byteCount);
            }
        });
        this.proxyRequestBody.writeTo(buffer);
        buffer.flush();
    }
}
