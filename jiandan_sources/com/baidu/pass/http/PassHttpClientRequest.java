package com.baidu.pass.http;

import android.content.Context;
import com.baidu.pass.a;
import fe.fe.ppp.ad.qw;

public class PassHttpClientRequest implements a, Runnable, Comparable<PassHttpClientRequest> {
    public static final String b = "PassHttpClientRequest";
    public int a;
    public volatile boolean cancelRequest = false;
    public Context context;
    public Method method;
    public PassHttpParamDTO paramDTO;
    public HttpRequestHandler requestHandler;
    public HttpResponseHandler responseHandler;

    public PassHttpClientRequest(Method method2, Context context2, PassHttpParamDTO passHttpParamDTO, int i2, HttpRequestHandler httpRequestHandler, HttpResponseHandler httpResponseHandler) {
        this.a = i2;
        this.method = method2;
        this.context = context2;
        this.paramDTO = passHttpParamDTO;
        this.responseHandler = httpResponseHandler;
        this.requestHandler = httpRequestHandler;
    }

    public void cancel() {
        this.cancelRequest = true;
        this.responseHandler = null;
    }

    public void run() {
        HttpResponseHandler httpResponseHandler = this.responseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.b();
        }
        qw.de(b, "network request already run");
        try {
            new a().a(this.requestHandler).a(this);
        } catch (Exception e) {
            qw.de(b, "PassHttpClientRequestrun " + e.getMessage());
            HttpResponseHandler httpResponseHandler2 = this.responseHandler;
            if (httpResponseHandler2 != null) {
                httpResponseHandler2.b(e, e.getMessage());
            }
        }
        HttpResponseHandler httpResponseHandler3 = this.responseHandler;
        if (httpResponseHandler3 != null) {
            httpResponseHandler3.a();
        }
    }

    public int compareTo(PassHttpClientRequest passHttpClientRequest) {
        ReqPriority reqPriority = this.paramDTO.priority;
        ReqPriority reqPriority2 = passHttpClientRequest.paramDTO.priority;
        return reqPriority == reqPriority2 ? this.a - passHttpClientRequest.a : reqPriority2.ordinal() - reqPriority.ordinal();
    }
}
