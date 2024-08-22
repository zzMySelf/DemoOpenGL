package com.baidu.sapi2.views.logindialog.utils;

import android.os.Build;
import android.util.Base64;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.ubc.UBCManager;
import com.dlife.ctaccountapi.v;
import java.net.HttpCookie;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static final String a = "auto_statistic";
    public static final String b = "login_dialog";
    public static LinkedHashMap<String, String> c = new LinkedHashMap<>();
    public static final String d = "show_time_consume";
    public static final String e = "show_login_type";
    public static final String f = "clickevent";
    public static final String g = "login_result";
    public static final String h = "login_type";

    /* renamed from: i  reason: collision with root package name */
    public static JSONArray f978i = new JSONArray();
    public static final String j = "0";
    public static final String k = "1";
    public static final String l = "name";
    public static final String m = "time_consume";
    public static final String n = "result_code";

    /* renamed from: o  reason: collision with root package name */
    public static final String f979o = "result_msg";

    /* renamed from: com.baidu.sapi2.views.logindialog.utils.a$a  reason: collision with other inner class name */
    public class C0042a extends HttpHandlerWrap {
        public C0042a(boolean z) {
            super(z);
        }

        public void onSuccess(int i2, String str) {
        }
    }

    public static String a() {
        return "{eventType:login_dialog}";
    }

    public static void a(long j2, QuickLoginType quickLoginType) {
        c.put(d, String.valueOf(j2));
        c.put(e, quickLoginType.getValue());
    }

    public static void b() {
        f978i = new JSONArray();
        c.clear();
    }

    public static void c() {
        try {
            SapiAccountManager instance = SapiAccountManager.getInstance();
            if (instance != null && instance.getConfignation() != null) {
                c.put(f, String.valueOf(f978i));
                HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.put(v.d, String.valueOf(System.currentTimeMillis()));
                httpHashMapWrap.put("pid", "111");
                httpHashMapWrap.put("type", "1023");
                httpHashMapWrap.put(UBCManager.CONTENT_KEY_SOURCE, SapiAccountService.DISPLAY_TYPE_NATIVE);
                httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
                httpHashMapWrap.put("data_source", "client");
                httpHashMapWrap.put("name", "auto_statistic");
                httpHashMapWrap.put("auto_statistic", Base64.encodeToString(a().getBytes(), 2));
                if (c != null) {
                    for (String next : c.keySet()) {
                        httpHashMapWrap.put(next, c.get(next));
                    }
                }
                new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, (List<HttpCookie>) null, (String) null, new C0042a(true));
                b();
            }
        } catch (Exception e2) {
            Log.e(Log.TAG, e2.getMessage());
        }
    }

    public static void a(long j2, String str) {
        c.put(d, String.valueOf(j2));
        c.put(e, str);
    }

    public static void a(String str, QuickLoginType quickLoginType) {
        c.put("login_result", str);
        c.put("login_type", quickLoginType.getValue());
    }

    public static void a(String str, String str2) {
        c.put("login_result", str);
        c.put("login_type", str2);
    }

    public static void a(String str) {
        try {
            if (f978i.length() == 20 && Build.VERSION.SDK_INT >= 19) {
                f978i.remove(0);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            f978i.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, long j2, int i2, String str2) {
        try {
            if (f978i.length() == 20 && Build.VERSION.SDK_INT >= 19) {
                f978i.remove(0);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            jSONObject.put(m, j2);
            jSONObject.put("result_code", i2);
            jSONObject.put("result_msg", str2);
            f978i.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
