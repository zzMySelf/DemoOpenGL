package com.alipay.sdk.m.w;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.w.a;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class b {

    public static class a implements a.C0018a<Object, Boolean> {
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* renamed from: com.alipay.sdk.m.w.b$b  reason: collision with other inner class name */
    public static class C0019b implements Callable<String> {
        public final /* synthetic */ Context a;

        public C0019b(Context context) {
            this.a = context;
        }

        public String call() {
            return com.alipay.sdk.m.b.c.a(this.a);
        }
    }

    public static class c implements a.C0018a<Object, Boolean> {
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    public static class d implements Callable<NetworkInfo> {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        public NetworkInfo call() {
            return ((ConnectivityManager) this.a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    public static class e implements a.C0018a<Object, Boolean> {
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public static class f implements Callable<String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ com.alipay.sdk.m.s.a b;

        public f(Context context, com.alipay.sdk.m.s.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        public String call() {
            try {
                return com.alipay.sdk.m.n0.a.c(this.a);
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.b(this.b, com.alipay.sdk.m.k.b.f661o, com.alipay.sdk.m.k.b.u, th2.getClass().getName());
                return "";
            }
        }
    }

    public static class g implements a.C0018a<Object, Boolean> {
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public static class h implements Callable<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ com.alipay.sdk.m.s.a d;

        public class a implements APSecuritySdk.InitResultListener {
            public final /* synthetic */ String[] a;
            public final /* synthetic */ ConditionVariable b;

            public a(String[] strArr, ConditionVariable conditionVariable) {
                this.a = strArr;
                this.b = conditionVariable;
            }

            public void onResult(APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.a[0] = tokenResult.apdidToken;
                }
                this.b.open();
            }
        }

        public h(String str, String str2, Context context, com.alipay.sdk.m.s.a aVar) {
            this.a = str;
            this.b = str2;
            this.c = context;
            this.d = aVar;
        }

        public String call() {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", this.a);
            hashMap.put(com.alipay.sdk.m.l.b.g, this.b);
            String[] strArr = {""};
            try {
                APSecuritySdk instance = APSecuritySdk.getInstance(this.c);
                ConditionVariable conditionVariable = new ConditionVariable();
                instance.initToken(0, hashMap, new a(strArr, conditionVariable));
                conditionVariable.block(3000);
            } catch (Throwable th2) {
                com.alipay.sdk.m.u.e.a(th2);
                com.alipay.sdk.m.k.a.b(this.d, com.alipay.sdk.m.k.b.f661o, com.alipay.sdk.m.k.b.r, th2.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                com.alipay.sdk.m.k.a.b(this.d, com.alipay.sdk.m.k.b.f661o, com.alipay.sdk.m.k.b.s, "missing token");
            }
            return strArr[0];
        }
    }

    public static NetworkInfo a(com.alipay.sdk.m.s.a aVar, Context context) {
        return (NetworkInfo) a.a(2, 10, TimeUnit.SECONDS, new c(), new d(a.a(context)), false, 10, TimeUnit.SECONDS, aVar, false);
    }

    public static String b(com.alipay.sdk.m.s.a aVar, Context context) {
        if (!com.alipay.sdk.m.m.a.z().u()) {
            return "";
        }
        return (String) a.a(1, 1, TimeUnit.DAYS, new a(), new C0019b(a.a(context)), true, 200, TimeUnit.MILLISECONDS, aVar, true);
    }

    public static String c(com.alipay.sdk.m.s.a aVar, Context context) {
        return (String) a.a(3, 1, TimeUnit.DAYS, new e(), new f(a.a(context), aVar), true, 3, TimeUnit.SECONDS, aVar, false);
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2) {
        return (String) a.a(4, 10, TimeUnit.SECONDS, new g(), new h(str, str2, a.a(context), aVar), true, 3, TimeUnit.SECONDS, aVar, true);
    }
}
