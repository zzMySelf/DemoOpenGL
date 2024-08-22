package com.baidu.iknow.android.net.client;

import okhttp3.OkHttpClient;

public class BaseClient {
    private static volatile OkHttpClient okHttpClient = null;

    private BaseClient() {
    }

    public static OkHttpClient newInstance() {
        if (okHttpClient == null) {
            synchronized (BaseClient.class) {
                if (okHttpClient == null) {
                    okHttpClient = new BaseOkhttpClientBuilder().build();
                }
            }
        }
        return okHttpClient;
    }
}
