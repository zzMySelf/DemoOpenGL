package com.baidu.pass.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import fe.fe.ppp.ad.qw;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PassHttpClient implements com.baidu.pass.a {
    public static final int a;
    public static final int b;
    public static final AtomicInteger c = new AtomicInteger();
    public static final ThreadFactory d = new a();
    public static final ThreadPoolExecutor e;
    public static final PassHttpClient f = new PassHttpClient();

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_net_thread#" + this.a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = availableProcessors > 64 ? availableProcessors / 2 : 32;
        int i2 = b;
        e = new ThreadPoolExecutor(i2, i2, 60, TimeUnit.SECONDS, new PriorityBlockingQueue(), d);
        if (Build.VERSION.SDK_INT >= 9) {
            e.allowCoreThreadTimeOut(true);
        }
    }

    private void a(Context context, PassHttpParamDTO passHttpParamDTO) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        } else if (passHttpParamDTO == null || TextUtils.isEmpty(passHttpParamDTO.url)) {
            throw new IllegalArgumentException("paramDTO can't be null or paramDTO.url can't be empty");
        }
    }

    public static PassHttpClient getInstance() {
        return f;
    }

    public PassHttpClientRequest get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            return a(Method.GET, context, passHttpParamDTO, httpResponseHandler);
        } catch (Exception e2) {
            qw.de("PASSPORT", "get ex=" + e2.getMessage());
            if (httpResponseHandler == null) {
                return null;
            }
            httpResponseHandler.a(e2, e2.getMessage());
            return null;
        }
    }

    public PassHttpClientRequest post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        return a(Method.POST, context, passHttpParamDTO, (HttpRequestHandler) null, httpResponseHandler);
    }

    public PassHttpClientRequest post(Context context, PassHttpParamDTO passHttpParamDTO, HttpRequestHandler httpRequestHandler, HttpResponseHandler httpResponseHandler) {
        try {
            a(context, passHttpParamDTO);
            return a(Method.POST, context, passHttpParamDTO, httpRequestHandler, httpResponseHandler);
        } catch (Exception e2) {
            if (httpResponseHandler == null) {
                return null;
            }
            httpResponseHandler.a(e2, e2.getMessage());
            return null;
        }
    }

    private PassHttpClientRequest a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        return a(method, context, passHttpParamDTO, (HttpRequestHandler) null, httpResponseHandler);
    }

    private PassHttpClientRequest a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpRequestHandler httpRequestHandler, HttpResponseHandler httpResponseHandler) {
        PassHttpClientRequest passHttpClientRequest = new PassHttpClientRequest(method, context, passHttpParamDTO, c.incrementAndGet(), httpRequestHandler, httpResponseHandler);
        e.execute(passHttpClientRequest);
        return passHttpClientRequest;
    }
}
