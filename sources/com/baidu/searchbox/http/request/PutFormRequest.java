package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PutFormRequest extends HttpParaRequest<PutFormRequestBuilder> {
    public PutFormRequest(PutFormRequestBuilder builder) {
        super(builder);
    }

    public PutFormRequestBuilder newBuilder() {
        return new PutFormRequestBuilder(this);
    }

    public PutFormRequestBuilder newBuilder(AbstractHttpManager httpManager) {
        return new PutFormRequestBuilder(this, httpManager);
    }

    /* access modifiers changed from: protected */
    public RequestBody buildOkRequestBody() {
        if (this.params == null || this.params.isEmpty()) {
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.put(requestBody).build();
    }

    public static class PutFormRequestBuilder extends HttpRequestParasBuilder<PutFormRequestBuilder> {
        public PutFormRequestBuilder(AbstractHttpManager httpManager) {
            super(httpManager);
        }

        public PutFormRequestBuilder(PutFormRequest putRequest) {
            this(putRequest, (AbstractHttpManager) null);
        }

        public PutFormRequestBuilder(PutFormRequest putRequest, AbstractHttpManager httpManager) {
            super(putRequest, httpManager);
        }

        public PutFormRequest build() {
            return new PutFormRequest(this);
        }
    }
}
