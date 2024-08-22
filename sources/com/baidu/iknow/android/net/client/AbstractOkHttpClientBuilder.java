package com.baidu.iknow.android.net.client;

import com.baidu.iknow.android.net.NetConfig;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public abstract class AbstractOkHttpClientBuilder implements IClientBuilder<OkHttpClient> {
    public static final long TIMEOUT_DEBUG = 20;
    public static final long TIMEOUT_REAL = 15;

    public abstract void setCache(OkHttpClient.Builder builder);

    public abstract void setRequestInterceptor(OkHttpClient.Builder builder);

    public abstract void setSSL(OkHttpClient.Builder builder);

    public OkHttpClient build() {
        OkHttpClient.Builder builder = getOkHttpClientBuilder();
        setRequestInterceptor(builder);
        setCache(builder);
        setTimeOut(builder);
        setSSL(builder);
        return builder.build();
    }

    public OkHttpClient.Builder getOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }

    public void setTimeOut(OkHttpClient.Builder builder) {
        if (NetConfig.getAbstractConfigProvider().isDebug()) {
            builder.connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS);
        } else {
            builder.connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS);
        }
    }
}
