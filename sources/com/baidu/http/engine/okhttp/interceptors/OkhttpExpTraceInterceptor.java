package com.baidu.http.engine.okhttp.interceptors;

import java.io.IOException;
import java.net.URISyntaxException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class OkhttpExpTraceInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        try {
            return chain.proceed(chain.request());
        } catch (RuntimeException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof URISyntaxException)) {
                throw e2;
            }
            throw new IOException(e2);
        }
    }
}
