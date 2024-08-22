package com.baidu.android.common.net;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class ProxyHttpClient extends DefaultHttpClient {
    public static final boolean DEBUG = false;
    public static final int HTTP_TIMEOUT_MS = 30000;
    public static final String TAG = ProxyHttpClient.class.getSimpleName();
    public RuntimeException mLeakedException;
    public String mPort;
    public String mProxy;
    public boolean mUseWap;

    public ProxyHttpClient(Context context) {
        this(context, (String) null, (ConnectManager) null);
    }

    public void close() {
        if (this.mLeakedException != null) {
            getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    public HttpParams createHttpParams() {
        HttpParams httpParams;
        try {
            httpParams = ProxyHttpClient.super.createHttpParams();
        } catch (ArrayIndexOutOfBoundsException unused) {
            httpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(httpParams, "ISO-8859-1");
            HttpProtocolParams.setUserAgent(httpParams, "Apache-HttpClient/UNAVAILABLE (java 1.4)");
        }
        HttpProtocolParams.setUseExpectContinue(httpParams, false);
        return httpParams;
    }

    public HttpResponse executeSafely(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        try {
            return execute(httpUriRequest);
        } catch (NullPointerException e) {
            throw new ClientProtocolException(e);
        }
    }

    public void finalize() throws Throwable {
        ProxyHttpClient.super.finalize();
        RuntimeException runtimeException = this.mLeakedException;
    }

    public boolean isWap() {
        return this.mUseWap;
    }

    public ProxyHttpClient(Context context, String str) {
        this(context, str, (ConnectManager) null);
    }

    public ProxyHttpClient(Context context, ConnectManager connectManager) {
        this(context, (String) null, connectManager);
    }

    public ProxyHttpClient(Context context, String str, ConnectManager connectManager) {
        this.mLeakedException = new IllegalStateException("ProxyHttpClient created and never closed");
        connectManager = connectManager == null ? new ConnectManager(context) : connectManager;
        this.mUseWap = connectManager.isWapNetwork();
        this.mProxy = connectManager.getProxy();
        this.mPort = connectManager.getProxyPort();
        String str2 = this.mProxy;
        if (str2 != null && str2.length() > 0) {
            getParams().setParameter("http.route.default-proxy", new HttpHost(this.mProxy, Integer.valueOf(this.mPort).intValue()));
        }
        HttpConnectionParams.setConnectionTimeout(getParams(), 30000);
        HttpConnectionParams.setSoTimeout(getParams(), 30000);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (!TextUtils.isEmpty(str)) {
            HttpProtocolParams.setUserAgent(getParams(), str);
        }
    }
}
