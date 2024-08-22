package com.baidu.sapi2.httpwrap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpClientRequest;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import fe.fe.ppp.ad.ad;
import java.net.HttpCookie;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpClientWrap {
    public String appSignKey;
    public Context context;
    public String domain;
    public PassHttpClient passHttpClient = PassHttpClient.getInstance();
    public String proxyHost;
    public int proxyPort = 443;
    public boolean supportNetwork;

    public HttpClientWrap() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (confignation != null) {
            this.context = confignation.context;
            this.domain = confignation.environment.getURL();
            this.proxyHost = confignation.environment.getProxyHost();
            this.proxyPort = confignation.environment.getProxyPort();
            this.appSignKey = confignation.appSignKey;
            this.supportNetwork = confignation.supportNetwork;
        }
    }

    private PassHttpParamDTO buildParamDTO(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2) {
        PassHttpParamDTO buildParamDTO = buildParamDTO(str, httpHashMap, hashMap, list, str2, i2);
        buildParamDTO.priority = reqPriority;
        return buildParamDTO;
    }

    /* access modifiers changed from: private */
    public void handleOnfailure(HttpHandlerWrap httpHandlerWrap, Throwable th2, String str) {
        int i2;
        if (th2 == null || !SSLPeerUnverifiedException.class.getSimpleName().equals(th2.getClass().getSimpleName())) {
            i2 = SapiResult.ERROR_CODE_SEND_REQUEST_ERROR;
        } else {
            i2 = -203;
            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"));
        }
        httpHandlerWrap.onFailure(th2, i2, str);
    }

    private boolean preHandle(HttpHandlerWrap httpHandlerWrap) {
        Context context2 = this.context;
        if (context2 == null) {
            httpHandlerWrap.onFailure((Throwable) null, SapiResult.ERROR_CODE_SDK_NOT_INIT, "服务异常，请稍后再试");
            httpHandlerWrap.onFinish();
            return false;
        } else if (!SapiUtils.hasActiveNetwork(context2)) {
            httpHandlerWrap.onFailure((Throwable) null, -201, SapiResult.ERROR_MSG_NETWORK_UNAVAILABLE);
            httpHandlerWrap.onFinish();
            return false;
        } else if (this.supportNetwork) {
            return true;
        } else {
            httpHandlerWrap.onFailure((Throwable) null, -201, SapiResult.ERROR_MSG_NETWORK_UNAVAILABLE);
            httpHandlerWrap.onFinish();
            return false;
        }
    }

    public void get(String str, ReqPriority reqPriority, HttpHandlerWrap httpHandlerWrap) {
        get(str, reqPriority, (List<HttpCookie>) null, httpHandlerWrap);
    }

    public void post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, reqPriority, httpHashMap, (List<HttpCookie>) null, (String) null, httpHandlerWrap);
    }

    public void get(String str, ReqPriority reqPriority, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, reqPriority, (HttpHashMap) null, list, (String) null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        post(str, ReqPriority.IMMEDIATE, httpHashMap, (HashMap<String, String>) null, list, str2, 0, httpHandlerWrap);
    }

    private PassHttpParamDTO buildParamDTO(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        if (str != null && !str.contains("://")) {
            str = this.domain + str;
        }
        passHttpParamDTO.url = str;
        if (httpHashMap != null) {
            httpHashMap.doSign(this.appSignKey);
        }
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.headers = hashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = str2;
        passHttpParamDTO.connectTimeout = i2;
        passHttpParamDTO.asyncCookie = SapiContext.getInstance().getAsyncCookie();
        if (!TextUtils.isEmpty(this.proxyHost)) {
            passHttpParamDTO.proxyHost = this.proxyHost;
            passHttpParamDTO.proxyPort = this.proxyPort;
        }
        return passHttpParamDTO;
    }

    public void get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        get(str, reqPriority, httpHashMap, (HashMap<String, String>) null, list, str2, 0, httpHandlerWrap);
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        return post(str, reqPriority, httpHashMap, (HashMap<String, String>) null, list, str2, 0, httpHandlerWrap);
    }

    public PassHttpClientRequest get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i2, HttpHandlerWrap httpHandlerWrap) {
        return get(str, reqPriority, httpHashMap, (HashMap<String, String>) null, list, str2, i2, httpHandlerWrap);
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        return post(str, reqPriority, httpHashMap, (HashMap<String, String>) null, list, (String) null, 0, httpHandlerWrap);
    }

    public PassHttpClientRequest get(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2, HttpHandlerWrap httpHandlerWrap) {
        final HttpHandlerWrap httpHandlerWrap2 = httpHandlerWrap;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                httpHandlerWrap2.onStart();
            }
        });
        if (!preHandle(httpHandlerWrap2)) {
            return null;
        }
        PassHttpClient passHttpClient2 = this.passHttpClient;
        Context context2 = this.context;
        PassHttpParamDTO buildParamDTO = buildParamDTO(str, reqPriority, httpHashMap, hashMap, list, str2, i2);
        final HttpHandlerWrap httpHandlerWrap3 = httpHandlerWrap;
        final String str3 = str;
        return passHttpClient2.get(context2, buildParamDTO, new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) {
            public void onFailure(Throwable th2, String str) {
                HttpClientWrap.this.handleOnfailure(httpHandlerWrap3, th2, str);
            }

            public void onFinish() {
                httpHandlerWrap3.onFinish();
            }

            public void onStart() {
            }

            public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                try {
                    httpHandlerWrap3.onSuccess(i2, str, hashMap);
                } catch (Throwable th2) {
                    onFailure(th2, str);
                    if (!TextUtils.isEmpty(str3)) {
                        StatService.onEvent("http_client_response_error", Collections.singletonMap("url", ad.fe(str3.getBytes())));
                    }
                }
            }
        });
    }

    public PassHttpClientRequest post(String str, ReqPriority reqPriority, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2, HttpHandlerWrap httpHandlerWrap) {
        final HttpHandlerWrap httpHandlerWrap2 = httpHandlerWrap;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                httpHandlerWrap2.onStart();
            }
        });
        if (!preHandle(httpHandlerWrap2)) {
            return null;
        }
        PassHttpClient passHttpClient2 = this.passHttpClient;
        Context context2 = this.context;
        PassHttpParamDTO buildParamDTO = buildParamDTO(str, reqPriority, httpHashMap, hashMap, list, str2, i2);
        final HttpHandlerWrap httpHandlerWrap3 = httpHandlerWrap;
        final String str3 = str;
        return passHttpClient2.post(context2, buildParamDTO, new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) {
            public void onFailure(Throwable th2, String str) {
                HttpClientWrap.this.handleOnfailure(httpHandlerWrap3, th2, str);
            }

            public void onFinish() {
                httpHandlerWrap3.onFinish();
            }

            public void onStart() {
            }

            public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                try {
                    httpHandlerWrap3.onSuccess(i2, str, hashMap);
                } catch (Throwable th2) {
                    onFailure(th2, str);
                    if (!TextUtils.isEmpty(str3)) {
                        StatService.onEvent("http_client_response_error", Collections.singletonMap("url", ad.fe(str3.getBytes())));
                    }
                }
            }
        });
    }
}
