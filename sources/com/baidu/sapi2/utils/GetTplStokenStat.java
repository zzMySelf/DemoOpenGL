package com.baidu.sapi2.utils;

import android.util.Base64;
import com.alipay.sdk.m.u.i;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import java.net.HttpCookie;
import java.util.List;

public class GetTplStokenStat implements NoProguard {
    private static final String AUTO_STATISTIC = "auto_statistic";
    public static final String KEY_GET_STOKEN = "key_get_stoken";
    public static final String KEY_GET_STOKEN_RESULT_CODE = "get_stoken_result_code";
    public static final String KEY_GET_STOKEN_RESULT_MSG = "get_stoken_result_msg";
    public static final String KEY_GET_STOKEN_TIME_CONSUMING = "get_stoken_time_consuming";

    public static void onEventAutoStat(String time, String code, String msg) {
        HttpHashMapWrap params = new HttpHashMapWrap();
        params.put(AUTO_STATISTIC, Base64.encodeToString(getEventTypeBase64Value(KEY_GET_STOKEN).getBytes(), 0));
        params.put("source", "native");
        params.put("data_source", "client");
        params.put("v", String.valueOf(System.currentTimeMillis()));
        params.put("clientfrom", "mobilesdk_enhanced");
        params.put(KEY_GET_STOKEN_RESULT_CODE, code);
        params.put(KEY_GET_STOKEN_RESULT_MSG, msg);
        params.put(KEY_GET_STOKEN_TIME_CONSUMING, time);
        try {
            sendRequest(params);
        } catch (Exception e2) {
        }
    }

    private static void sendRequest(HttpHashMapWrap params) {
        new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, params, (List<HttpCookie>) null, (String) null, new HttpHandlerWrap(true) {
            /* access modifiers changed from: protected */
            public void onSuccess(int statusCode, String responseBody) {
            }
        });
    }

    private static String getEventTypeBase64Value(String eventType) {
        return "{eventType:" + eventType + i.f2534d;
    }
}
