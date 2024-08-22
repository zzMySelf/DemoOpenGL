package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.baidu.sapi2.activity.BaseActivity;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;
    public static final Map<String, Callback> e = new ConcurrentHashMap();
    public static long f = -1;
    public static final int g = 122;
    public volatile boolean a = false;
    public final Activity b;
    public Callback c;
    public final Handler d = new Handler(Looper.getMainLooper());

    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");
        
        public String appId;

        /* access modifiers changed from: public */
        BizType(String str) {
            this.appId = str;
        }
    }

    public interface Callback {
        void onResult(int i2, String str, Bundle bundle);
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.alipay.sdk.app.OpenAuthTask$BizType[] r0 = com.alipay.sdk.app.OpenAuthTask.BizType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.alipay.sdk.app.OpenAuthTask$BizType r1 = com.alipay.sdk.app.OpenAuthTask.BizType.Deduct     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alipay.sdk.app.OpenAuthTask$BizType r1 = com.alipay.sdk.app.OpenAuthTask.BizType.AccountAuth     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alipay.sdk.app.OpenAuthTask$BizType r1 = com.alipay.sdk.app.OpenAuthTask.BizType.Invoice     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.OpenAuthTask.a.<clinit>():void");
        }
    }

    public final class b implements Runnable {
        public final int a;
        public final String b;
        public final Bundle c;

        public /* synthetic */ b(OpenAuthTask openAuthTask, int i2, String str, Bundle bundle, a aVar) {
            this(i2, str, bundle);
        }

        public void run() {
            if (OpenAuthTask.this.c != null) {
                OpenAuthTask.this.c.onResult(this.a, this.b, this.c);
            }
        }

        public b(int i2, String str, Bundle bundle) {
            this.a = i2;
            this.b = str;
            this.c = bundle;
        }
    }

    public OpenAuthTask(Activity activity) {
        this.b = activity;
        com.alipay.sdk.m.s.b.d().a(activity);
    }

    public void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        Activity activity = this.b;
        String valueOf = String.valueOf(map);
        com.alipay.sdk.m.s.a aVar = new com.alipay.sdk.m.s.a(activity, valueOf, "oa-" + bizType);
        this.c = callback;
        if (a(aVar, str, bizType, map, z)) {
            com.alipay.sdk.m.k.a.b((Context) this.b, aVar, "", aVar.d);
        }
    }

    private boolean a(com.alipay.sdk.m.s.a aVar, String str, BizType bizType, Map<String, String> map, boolean z) {
        PackageInfo packageInfo;
        com.alipay.sdk.m.s.a aVar2 = aVar;
        BizType bizType2 = bizType;
        if (this.a) {
            this.d.post(new b(this, 4000, "该 OpenAuthTask 已在执行", (Bundle) null, (a) null));
            return true;
        }
        this.a = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f <= 3000) {
            this.d.post(new b(this, 5000, "3s 内重复支付", (Bundle) null, (a) null));
            return true;
        }
        f = elapsedRealtime;
        com.alipay.sdk.m.j.a.a("");
        String a2 = n.a(32);
        HashMap hashMap = new HashMap(map);
        hashMap.put("mqpPkgName", this.b.getPackageName());
        hashMap.put("mqpScene", "sdk");
        List<a.b> j = com.alipay.sdk.m.m.a.z().j();
        if (!com.alipay.sdk.m.m.a.z().g || j == null) {
            j = com.alipay.sdk.m.j.a.d;
        }
        n.c a3 = n.a(aVar2, (Context) this.b, j);
        if (a3 != null && !a3.a(aVar2) && !a3.a() && (packageInfo = a3.a) != null && packageInfo.versionCode >= 122) {
            try {
                HashMap<String, String> a4 = com.alipay.sdk.m.s.a.a(aVar);
                a4.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
                hashMap.put("mqpLoc", new JSONObject(a4).toString());
            } catch (Throwable unused) {
                this.d.post(new b(this, 4000, "业务参数错误", (Bundle) null, (a) null));
                return true;
            }
            String a5 = a(bizType2, hashMap);
            e.put(a2, this.c);
            String str2 = null;
            try {
                str2 = a(elapsedRealtime, a2, bizType, a5);
            } catch (JSONException e2) {
                com.alipay.sdk.m.k.a.a(aVar2, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.q0, (Throwable) e2);
            }
            String str3 = str2;
            if (TextUtils.isEmpty(str3)) {
                this.d.post(new b(this, 4000, "参数错误", (Bundle) null, (a) null));
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "20001129").appendQueryParameter("payload", str3).build());
            intent.addFlags(268435456);
            intent.setPackage(a3.a.packageName);
            try {
                com.alipay.sdk.m.k.a.a(aVar2, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Y, "" + elapsedRealtime);
                a.C0016a.a(aVar2, a2);
                this.b.startActivity(intent);
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(aVar2, com.alipay.sdk.m.k.b.l, "StartWalletEx", th2);
            }
            return false;
        } else if (z) {
            hashMap.put("mqpScheme", String.valueOf(str));
            hashMap.put("mqpNotifyName", a2);
            hashMap.put("mqpScene", "landing");
            String a6 = a(bizType2, hashMap);
            Intent intent2 = new Intent(this.b, H5OpenAuthActivity.class);
            intent2.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", new Object[]{Uri.encode(a6)}));
            a.C0016a.a(aVar2, intent2);
            this.b.startActivity(intent2);
            return false;
        } else {
            this.d.post(new b(this, 4001, "支付宝未安装或签名错误", (Bundle) null, (a) null));
            return true;
        }
    }

    private String a(BizType bizType, Map<String, String> map) {
        if (bizType != null) {
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bizType.appId);
            if (a.a[bizType.ordinal()] == 1) {
                appendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
            }
            for (Map.Entry next : map.entrySet()) {
                appendQueryParameter.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
            return appendQueryParameter.build().toString();
        }
        throw new RuntimeException("missing bizType");
    }

    private String a(long j, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", String.valueOf(j));
        jSONObject.put("session", str);
        jSONObject.put("package", this.b.getPackageName());
        if (bizType != null) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bizType.appId);
        }
        jSONObject.put("sdkVersion", "h.a.3.8.16");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    public static void a(String str, int i2, String str2, Bundle bundle) {
        Callback remove = e.remove(str);
        if (remove != null) {
            try {
                remove.onResult(i2, str2, bundle);
            } catch (Throwable th2) {
                e.a(th2);
            }
        }
    }
}
