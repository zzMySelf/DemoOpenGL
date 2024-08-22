package com.baidu.swan.bdtls.open.network.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ConnectRequest extends HttpCommonRequest<ConnectRequestBuilder> {
    public ConnectRequest(ConnectRequestBuilder builder) {
        super(builder);
    }

    public ConnectRequestBuilder newBuilder() {
        return new ConnectRequestBuilder(this);
    }

    public ConnectRequestBuilder newBuilder(AbstractHttpManager httpManager) {
        return new ConnectRequestBuilder(this, httpManager);
    }

    /* access modifiers changed from: protected */
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }

    public static class ConnectRequestBuilder extends HttpCommonRequestBuilder<ConnectRequestBuilder> {
        public ConnectRequestBuilder(AbstractHttpManager httpManager) {
            super(httpManager);
        }

        public ConnectRequestBuilder(ConnectRequest connectRequest) {
            this(connectRequest, (AbstractHttpManager) null);
        }

        public ConnectRequestBuilder(ConnectRequest connectRequest, AbstractHttpManager httpManager) {
            super(connectRequest, httpManager);
        }

        public ConnectRequest build() {
            return new ConnectRequest(this);
        }
    }
}
