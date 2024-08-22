package com.baidu.swan.apps.network.interceptor;

import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class SwanAppUserAgentInterceptor implements Interceptor {
    private static final String HEADER_USER_AGENT = "User-Agent";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        return chain.proceed(originalRequest.newBuilder().header("User-Agent", SwanAppNetworkUtils.getRequestUserAgent()).build());
    }
}
