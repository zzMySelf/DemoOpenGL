package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.b0.a;
import com.baidu.android.pushservice.b0.d;
import com.baidu.android.pushservice.b0.e;
import com.baidu.android.pushservice.d0.c;
import com.baidu.android.pushservice.e0.h;
import com.baidu.android.pushservice.e0.i;
import com.baidu.android.pushservice.e0.l;
import com.baidu.android.pushservice.httpapi.TokenBindListener;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.s.b;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {

    /* renamed from: f  reason: collision with root package name */
    public static volatile j f8395f = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f8396g = false;

    /* renamed from: h  reason: collision with root package name */
    public static Context f8397h;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f8398a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f8399b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f8400c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TokenBindListener> f8401d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, ClientEventInfo> f8402e;

    public class a extends c {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8403c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TokenBindListener f8404d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8405e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8406f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HashMap f8407g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ClientEventInfo f8408h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, short s, String str2, TokenBindListener tokenBindListener, int i2, String str3, HashMap hashMap, ClientEventInfo clientEventInfo) {
            super(str, s);
            this.f8403c = str2;
            this.f8404d = tokenBindListener;
            this.f8405e = i2;
            this.f8406f = str3;
            this.f8407g = hashMap;
            this.f8408h = clientEventInfo;
        }

        public void a() {
            String a2 = j.this.b(this.f8403c);
            j.this.a(this.f8404d, a2, this.f8403c);
            b a3 = com.baidu.android.pushservice.s.c.a(j.f8397h, j.this.a(this.f8405e), "POST", j.this.a(this.f8403c, this.f8405e, this.f8406f), (HashMap<String, String>) this.f8407g, "application/json");
            if (a3 != null) {
                String a4 = Utility.a(j.f8397h, a3.b());
                int a5 = a3.a();
                try {
                    JSONObject jSONObject = new JSONObject(a4);
                    a5 = jSONObject.getInt("error_code");
                    String string = jSONObject.getJSONObject("response_params").getString("cid");
                    String string2 = jSONObject.getJSONObject("response_params").getString("appid");
                    i.b(j.f8397h, "cid", string);
                    i.e(j.f8397h, string2);
                    if (!TextUtils.isEmpty(a2)) {
                        com.baidu.android.pushservice.e0.j.a(j.f8397h, a2);
                    }
                    if (TextUtils.isEmpty(this.f8408h.getIId()) || d.i(j.f8397h) == 0) {
                        com.baidu.android.pushservice.b0.a.a().a(j.f8397h, this.f8408h, a.C0124a.ERROR_PULL_MODE);
                    } else {
                        e.d(j.f8397h, this.f8408h);
                    }
                } catch (JSONException e2) {
                }
                TokenBindListener tokenBindListener = this.f8404d;
                if (tokenBindListener != null && a5 == 0) {
                    tokenBindListener.onResult(a5, "success");
                }
            }
        }
    }

    public static j a(Context context) {
        if (f8395f == null) {
            synchronized (j.class) {
                if (f8395f == null) {
                    f8395f = new j();
                    f8397h = context;
                }
            }
        }
        return f8395f;
    }

    public final String a(int i2) {
        String str = h.f8390j;
        if (i2 == 1) {
            str = "/v2/bccs/upload";
        }
        return h.f8387g + str;
    }

    public final String a(String str, int i2, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, i.d(f8397h, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
            jSONObject2.put("timestamp", (System.currentTimeMillis() / 1000) + "");
            jSONObject2.put("cid", i.d(f8397h, "cid"));
            jSONObject2.put(HttpConstants.DEVICE_TYPE, "3");
            jSONObject2.put("sdk_int", Build.VERSION.SDK_INT + "");
            jSONObject2.put("push_sdk_version", a.a() + "");
            String h2 = Utility.h(f8397h);
            if (!TextUtils.isEmpty(h2)) {
                jSONObject2.put("app_version", h2);
            }
            if (Utility.I(f8397h)) {
                jSONObject2.put(Config.ROM, Utility.o(f8397h));
            }
            jSONObject2.put("connect_version", (Utility.w(f8397h) ? 3 : 2) + "");
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("push_proxy", str);
            }
            jSONObject2.put("manufacturer", Utility.a(f8397h, false));
            jSONObject2.put("bind_notify_status", h.b(f8397h));
            jSONObject2.put("source", i2);
            jSONObject2.put("iid", str2);
            JSONArray a2 = l.a(jSONObject2.toString(), 3, 2);
            jSONObject.put("info", a2);
            jSONObject.put("info_len", a2.length());
        } catch (Exception | JSONException e2) {
        }
        return jSONObject.toString();
    }

    public void a(int i2, String str, ClientEventInfo clientEventInfo, TokenBindListener tokenBindListener) {
        if (this.f8401d == null || this.f8400c == null || this.f8399b == null || this.f8402e == null) {
            this.f8401d = new HashMap<>();
            this.f8400c = new LinkedHashMap<>();
            this.f8399b = new HashMap<>();
            this.f8402e = new HashMap<>();
        }
        String str2 = "key" + System.currentTimeMillis() + this.f8398a.incrementAndGet();
        this.f8401d.put(str2, tokenBindListener);
        this.f8400c.put(str2, Integer.valueOf(i2));
        this.f8399b.put(str2, str);
        this.f8402e.put(str2, clientEventInfo);
    }

    public final void a(TokenBindListener tokenBindListener, String str, String str2) {
        String str3;
        if (tokenBindListener != null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                str3 = "http_no_proxy";
            } else if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                str3 = "http_no_token";
            } else if (!TextUtils.isEmpty(str)) {
                str3 = "http_has_token";
            } else {
                return;
            }
            tokenBindListener.onResult(0, str3);
        }
    }

    public void a(String str) {
        String str2 = (String) this.f8400c.entrySet().iterator().next().getKey();
        ClientEventInfo remove = this.f8402e.remove(str2);
        String str3 = str;
        a(str3, ((Integer) this.f8400c.remove(str2)).intValue(), this.f8399b.remove(str2), remove, this.f8401d.remove(str2));
    }

    public void a(String str, int i2, String str2, ClientEventInfo clientEventInfo, TokenBindListener tokenBindListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        com.baidu.android.pushservice.d0.e.a().a(new a("requestNewBind", 100, str, tokenBindListener, i2, str2, hashMap, clientEventInfo));
    }

    public final String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).getJSONObject("info").getString("token");
            } catch (JSONException e2) {
            }
        }
        return "";
    }
}
