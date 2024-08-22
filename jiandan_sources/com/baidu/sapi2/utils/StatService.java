package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.p.e;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.ubc.UBCManager;
import com.dlife.ctaccountapi.v;
import fe.fe.ddd.vvv.qw.qw.qw;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public final class StatService implements NoProguard {
    public static final String AUTO_STATISTIC = "auto_statistic";
    public static final String STAT_ENENT_QR_LOGIN_ENTER = "qrlogin_enter";
    public static final String TAG = "StatService";
    public static final Map<String, String> commonParams;
    public static List<String> delayRequestName;

    static {
        HashMap hashMap = new HashMap();
        commonParams = hashMap;
        hashMap.put("pid", "111");
        commonParams.put("type", "1023");
        commonParams.put(e.p, SapiDeviceInfo.OS_TYPE);
        ArrayList arrayList = new ArrayList();
        delayRequestName = arrayList;
        arrayList.add("share_read");
        delayRequestName.add("share_silent_account");
        delayRequestName.add("share_silent_account_success");
        delayRequestName.add("load_login");
        delayRequestName.add("share_account_open");
        delayRequestName.add("pass_sdk_init");
    }

    public static String getEventTypeBase64Value(String str) {
        return "{eventType:" + str + "}";
    }

    public static boolean isSearchBox() {
        try {
            Class.forName("fe.fe.ddd.vvv.qw.qw.qw");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                final HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.putAll(commonParams);
                httpHashMapWrap.put("name", str);
                httpHashMapWrap.put(v.d, String.valueOf(System.currentTimeMillis()));
                httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
                if (map != null) {
                    for (Map.Entry next : map.entrySet()) {
                        if (!TextUtils.isEmpty((CharSequence) next.getKey()) && !TextUtils.isEmpty((CharSequence) next.getValue())) {
                            httpHashMapWrap.put((String) next.getKey(), (String) next.getValue());
                        }
                    }
                }
                if (!delayRequestName.contains(str) || !isSearchBox()) {
                    sendRequest(httpHashMapWrap);
                    return;
                }
                qw.qw(new Runnable() {
                    public void run() {
                        StatService.sendRequest(HttpHashMapWrap.this);
                    }
                }, "pass_sdk_".concat(str), 60000, false);
            } catch (Throwable th2) {
                Log.e(th2);
            }
        }
    }

    public static void onEventAutoStat(String str) {
        onEventAutoStat(str, (Map<String, String>) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:7|5)|17|8|(1:10)|11|12|13|14|15|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x011a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onEventAutoStatExt(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, java.util.Map<java.lang.String, java.lang.String> r8, android.content.Context r9) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "eventType"
            r0.put(r1, r6)
            java.lang.String r1 = "device"
            java.lang.String r2 = "android"
            r0.put(r1, r2)
            java.lang.String r1 = com.baidu.sapi2.utils.SapiUtils.getOSVersion()
            java.lang.String r2 = "os_ver"
            r0.put(r2, r1)
            java.lang.String r1 = com.baidu.sapi2.utils.SapiUtils.getOSModel()
            java.lang.String r2 = "model"
            r0.put(r2, r1)
            java.lang.String r1 = com.baidu.sapi2.utils.SapiUtils.getNetworkClass(r9)
            java.lang.String r2 = "net_type"
            r0.put(r2, r1)
            java.lang.String r1 = com.baidu.sapi2.utils.SapiUtils.getVersionName(r9)
            java.lang.String r2 = "app_version"
            r0.put(r2, r1)
            java.lang.String r1 = com.baidu.sapi2.utils.SapiUtils.getSDKVersion()
            java.lang.String r2 = "sdk_version"
            r0.put(r2, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "timestamp"
            r0.put(r2, r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r2 = "auto_page"
            r0.put(r2, r1)
            r0.putAll(r8)     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "{"
            r8.append(r1)
            java.util.Set r1 = r0.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x006d:
            boolean r3 = r1.hasNext()
            java.lang.String r4 = ","
            if (r3 == 0) goto L_0x0090
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            r8.append(r3)
            java.lang.String r5 = ":"
            r8.append(r5)
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r8.append(r3)
            r8.append(r4)
            goto L_0x006d
        L_0x0090:
            int r0 = r8.lastIndexOf(r4)
            r1 = 0
            if (r0 <= 0) goto L_0x00a1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r8 = r8.substring(r1, r0)
            r3.<init>(r8)
            r8 = r3
        L_0x00a1:
            java.lang.String r0 = "}"
            r8.append(r0)
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onEventAutoStatExt content="
            r3.append(r4)
            java.lang.String r4 = r8.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0[r1] = r3
            java.lang.String r3 = "StatService"
            com.baidu.sapi2.utils.Log.d(r3, r0)
            com.baidu.sapi2.httpwrap.HttpHashMapWrap r0 = new com.baidu.sapi2.httpwrap.HttpHashMapWrap
            r0.<init>()
            java.lang.String r8 = r8.toString()
            byte[] r8 = r8.getBytes()
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r1)
            java.lang.String r1 = "auto_statistic"
            r0.put(r1, r8)
            java.util.Map<java.lang.String, java.lang.String> r8 = commonParams
            r0.putAll(r8)
            java.lang.String r8 = "source"
            java.lang.String r3 = "native"
            r0.put(r8, r3)
            java.lang.String r8 = "data_source"
            java.lang.String r3 = "client"
            r0.put(r8, r3)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = java.lang.String.valueOf(r3)
            java.lang.String r3 = "v"
            r0.put(r3, r8)
            java.lang.String r8 = "clientfrom"
            java.lang.String r3 = "mobilesdk_enhanced"
            r0.put(r8, r3)
            java.lang.String r8 = "auto_en"
            r0.put(r8, r6)
            java.lang.String r6 = "name"
            r0.put(r6, r1)
            java.lang.Class r6 = r9.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r0.put(r2, r6)
            r0.putAll(r7)     // Catch:{ Exception -> 0x011a }
        L_0x011a:
            sendRequest(r0)     // Catch:{ Exception -> 0x011d }
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.StatService.onEventAutoStatExt(java.lang.String, java.util.Map, java.util.Map, android.content.Context):void");
    }

    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap) {
        onEventAutoStatistic(linkedHashMap, (Map<String, String>) null);
    }

    public static void sendRequest(HttpHashMapWrap httpHashMapWrap) {
        new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, (List<HttpCookie>) null, (String) null, new HttpHandlerWrap(true) {
            public void onSuccess(int i2, String str) {
            }
        });
    }

    public static void onEventAutoStat(String str, Map<String, String> map) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String encodeToString = Base64.encodeToString(getEventTypeBase64Value(str).getBytes(), 0);
        if (!TextUtils.isEmpty(encodeToString) && encodeToString.endsWith(StringUtils.LF)) {
            encodeToString = encodeToString.replace(StringUtils.LF, "");
        }
        httpHashMapWrap.put("auto_statistic", encodeToString);
        httpHashMapWrap.putAll(commonParams);
        httpHashMapWrap.put(UBCManager.CONTENT_KEY_SOURCE, SapiAccountService.DISPLAY_TYPE_NATIVE);
        httpHashMapWrap.put("data_source", "client");
        httpHashMapWrap.put(v.d, String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        if (map != null) {
            for (String next : map.keySet()) {
                httpHashMapWrap.put(next, map.get(next));
            }
        }
        try {
            sendRequest(httpHashMapWrap);
        } catch (Exception unused) {
        }
    }

    @TargetApi(8)
    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.ARRAY_START);
        for (String next : linkedHashMap.keySet()) {
            sb.append(next);
            sb.append(":");
            sb.append(linkedHashMap.get(next));
            sb.append(",");
        }
        int lastIndexOf = sb.lastIndexOf(",");
        if (lastIndexOf > 0) {
            sb = new StringBuilder(sb.substring(0, lastIndexOf));
        }
        sb.append("}");
        Log.d(TAG, "onEventAutoStatistic content=" + sb.toString());
        map.put("auto_statistic", Base64.encodeToString(sb.toString().getBytes(), 0));
        map.put(UBCManager.CONTENT_KEY_SOURCE, SapiAccountService.DISPLAY_TYPE_NATIVE);
        map.put("data_source", "client");
        onEvent("auto_statistic", map);
    }
}
