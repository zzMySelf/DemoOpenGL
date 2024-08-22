package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.request.HttpRequestParasBuilder;
import java.util.LinkedHashMap;

public abstract class HttpParaRequest<T extends HttpRequestParasBuilder> extends HttpRequest<T> {
    protected LinkedHashMap<String, String> params;

    public HttpParaRequest(T builder) {
        super(builder);
    }

    /* access modifiers changed from: protected */
    public void initExtraHttpRequest(T builder) {
        if (builder.params != null) {
            this.params = new LinkedHashMap<>(builder.params);
        }
    }
}
