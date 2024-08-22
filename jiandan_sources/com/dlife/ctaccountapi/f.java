package com.dlife.ctaccountapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.dlife.ctaccountapi.m;
import com.dlife.ctaccountapi.r;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static final String a = "f";

    public class a extends r.a {
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ PreCodeListener h;

        public a(Context context, String str, String str2, String str3, String str4, String str5, PreCodeListener preCodeListener) {
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = preCodeListener;
        }

        public void run() {
            String a = f.this.a(this.b, this.c, this.d, this.e, (Network) null, this.f, this.g);
            if (!a()) {
                CtAuth.postResult(this.b, a, this.g, this.h);
            }
        }
    }

    public class b implements m.c {
        public boolean a = false;
        public boolean b = false;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PreCodeListener f3782i;

        public b(String str, Context context, String str2, String str3, String str4, String str5, PreCodeListener preCodeListener) {
            this.c = str;
            this.d = context;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.f3782i = preCodeListener;
        }

        public synchronized void a() {
            this.a = true;
            if (!this.b) {
                e.a(this.c, "{\"result\":80000,\"msg\":\"请求超时\"}", "");
                CtAuth.postResult(this.d, "{\"result\":80000,\"msg\":\"请求超时\"}", this.c, this.f3782i);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0063, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void a(int r4, java.lang.String r5, long r6) {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.a     // Catch:{ all -> 0x0064 }
                if (r0 != 0) goto L_0x0062
                boolean r0 = r3.b     // Catch:{ all -> 0x0064 }
                if (r0 == 0) goto L_0x000a
                goto L_0x0062
            L_0x000a:
                r0 = 1
                r3.b = r0     // Catch:{ all -> 0x0064 }
                java.lang.String r0 = r3.c     // Catch:{ all -> 0x0064 }
                com.dlife.ctaccountapi.b r0 = com.dlife.ctaccountapi.e.a((java.lang.String) r0)     // Catch:{ all -> 0x0064 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
                r1.<init>()     // Catch:{ all -> 0x0064 }
                java.lang.String r2 = "switchToMobile_L  onFail()  expendTime : "
                r1.append(r2)     // Catch:{ all -> 0x0064 }
                r1.append(r6)     // Catch:{ all -> 0x0064 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0064 }
                com.dlife.ctaccountapi.b r0 = r0.a((java.lang.String) r1)     // Catch:{ all -> 0x0064 }
                com.dlife.ctaccountapi.b r0 = r0.a((int) r4)     // Catch:{ all -> 0x0064 }
                com.dlife.ctaccountapi.b r0 = r0.f(r5)     // Catch:{ all -> 0x0064 }
                r0.b((long) r6)     // Catch:{ all -> 0x0064 }
                android.content.Context r0 = r3.d     // Catch:{ all -> 0x0064 }
                java.lang.String r4 = com.dlife.ctaccountapi.q.a(r4, r5)     // Catch:{ all -> 0x0064 }
                java.lang.String r1 = r3.c     // Catch:{ all -> 0x0064 }
                cn.com.chinatelecom.gateway.lib.PreCodeListener r2 = r3.f3782i     // Catch:{ all -> 0x0064 }
                cn.com.chinatelecom.gateway.lib.CtAuth.postResult(r0, r4, r1, r2)     // Catch:{ all -> 0x0064 }
                java.lang.String r4 = com.dlife.ctaccountapi.f.a     // Catch:{ all -> 0x0064 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
                r0.<init>()     // Catch:{ all -> 0x0064 }
                java.lang.String r1 = "Switching network failed (L), errorMsg :"
                r0.append(r1)     // Catch:{ all -> 0x0064 }
                r0.append(r5)     // Catch:{ all -> 0x0064 }
                java.lang.String r5 = " , expendTime ："
                r0.append(r5)     // Catch:{ all -> 0x0064 }
                r0.append(r6)     // Catch:{ all -> 0x0064 }
                java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0064 }
                cn.com.chinatelecom.gateway.lib.CtAuth.info(r4, r5)     // Catch:{ all -> 0x0064 }
                monitor-exit(r3)
                return
            L_0x0062:
                monitor-exit(r3)
                return
            L_0x0064:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.f.b.a(int, java.lang.String, long):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.net.Network r10, long r11) {
            /*
                r9 = this;
                java.lang.String r0 = com.dlife.ctaccountapi.f.a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Switching network successfully (L) , expendTime ："
                r1.append(r2)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                cn.com.chinatelecom.gateway.lib.CtAuth.info(r0, r1)
                boolean r0 = r9.a
                if (r0 != 0) goto L_0x005a
                boolean r0 = r9.b
                if (r0 == 0) goto L_0x0021
                goto L_0x005a
            L_0x0021:
                java.lang.String r0 = r9.c
                com.dlife.ctaccountapi.b r0 = com.dlife.ctaccountapi.e.a((java.lang.String) r0)
                r0.b((long) r11)
                com.dlife.ctaccountapi.f r1 = com.dlife.ctaccountapi.f.this
                android.content.Context r2 = r9.d
                java.lang.String r3 = r9.e
                java.lang.String r4 = r9.f
                java.lang.String r5 = r9.g
                java.lang.String r7 = r9.h
                java.lang.String r8 = r9.c
                r6 = r10
                java.lang.String r10 = r1.a(r2, r3, r4, r5, r6, r7, r8)
                monitor-enter(r9)
                boolean r11 = r9.a     // Catch:{ all -> 0x0057 }
                if (r11 != 0) goto L_0x0055
                boolean r11 = r9.b     // Catch:{ all -> 0x0057 }
                if (r11 == 0) goto L_0x0047
                goto L_0x0055
            L_0x0047:
                r11 = 1
                r9.b = r11     // Catch:{ all -> 0x0057 }
                android.content.Context r11 = r9.d     // Catch:{ all -> 0x0057 }
                java.lang.String r12 = r9.c     // Catch:{ all -> 0x0057 }
                cn.com.chinatelecom.gateway.lib.PreCodeListener r0 = r9.f3782i     // Catch:{ all -> 0x0057 }
                cn.com.chinatelecom.gateway.lib.CtAuth.postResult(r11, r10, r12, r0)     // Catch:{ all -> 0x0057 }
                monitor-exit(r9)     // Catch:{ all -> 0x0057 }
                return
            L_0x0055:
                monitor-exit(r9)     // Catch:{ all -> 0x0057 }
                return
            L_0x0057:
                r10 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0057 }
                throw r10
            L_0x005a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.f.b.a(android.net.Network, long):void");
        }
    }

    public class c extends r.a {
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ PreCodeListener h;

        public c(Context context, String str, String str2, String str3, String str4, String str5, PreCodeListener preCodeListener) {
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = preCodeListener;
        }

        public void run() {
            if (new m().b(this.b, "https://id6.me/auth/preauth.do")) {
                if (!a()) {
                    String a = f.this.a(this.b, this.c, this.d, this.e, (Network) null, this.f, this.g);
                    if (!a()) {
                        CtAuth.postResult(this.b, a, this.g, this.h);
                    }
                }
            } else if (!a()) {
                CtAuth.postResult(this.b, q.a(80800, "WIFI切换超时"), this.g, this.h);
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Future a;
        public final /* synthetic */ int b;
        public final /* synthetic */ r.a c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ PreCodeListener f;

        public d(f fVar, Future future, int i2, r.a aVar, String str, Context context, PreCodeListener preCodeListener) {
            this.a = future;
            this.b = i2;
            this.c = aVar;
            this.d = str;
            this.e = context;
            this.f = preCodeListener;
        }

        public void run() {
            String str;
            Context context;
            try {
                this.a.get((long) this.b, TimeUnit.MILLISECONDS);
                Future future = this.a;
                if (future == null || future.isDone()) {
                    return;
                }
            } catch (Throwable th2) {
                Future future2 = this.a;
                if (future2 != null && !future2.isDone()) {
                    this.a.cancel(true);
                }
                throw th2;
            }
            this.a.cancel(true);
        }
    }

    private String a(Context context, String str, String str2, Network network) {
        JSONObject jSONObject;
        String a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("result");
            String optString = jSONObject.optString("data");
            if ((optInt == 0 || optInt == 30002) && !TextUtils.isEmpty(optString)) {
                a2 = a(optString, str2);
                if (!TextUtils.isEmpty(a2)) {
                    jSONObject.put("data", new JSONObject(a2));
                    if (optInt != 30002) {
                        return jSONObject.toString();
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = ((JSONObject) jSONObject.opt("data")).optJSONArray("urls");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.getString(i2));
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return a(context, (List<String>) arrayList, str2, network);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject.put("data", a2);
        } catch (Throwable th2) {
            CtAuth.warn(a, "decryptResult error", th2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String a(Context context, String str, String str2, String str3, Network network, String str4, String str5) {
        String b2 = b();
        String a2 = o.a(context, str, str2, str3, b2);
        String str6 = a;
        CtAuth.info(str6, "request params : " + a2);
        p a3 = l.a(context, n.f(context), a2, network, str4, str5, true);
        if (a3.b) {
            a3 = l.a(context, a3.c.equals("2") ? "https://card.e.189.cn/auth/preauth.do" : "https://id6.me/auth/preauth.do", a2, network, str4, str5, false);
        }
        CtAuth.info(str6, "request result : " + a3.a);
        String a4 = a(context, a3.a, b2, network);
        a3.a = a4;
        if (TextUtils.isEmpty(a4)) {
            a3.a = "{\"result\":80001,\"msg\":\"请求异常\"}";
            return "{\"result\":80001,\"msg\":\"请求异常\"}";
        }
        e.a(str5, a3.a, a2);
        return a3.a;
    }

    public static String a(Context context, List<String> list, String str, Network network) {
        int i2 = 0;
        while (true) {
            JSONObject jSONObject = null;
            if (i2 >= list.size()) {
                return null;
            }
            try {
                String str2 = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2)) && context != null && Build.VERSION.SDK_INT < 21) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        int b2 = m.b(m.a(str2));
                        Class<?> cls = Class.forName("android.net.ConnectivityManager");
                        Class cls2 = Integer.TYPE;
                        ((Boolean) cls.getMethod("requestRouteToHost", new Class[]{cls2, cls2}).invoke(connectivityManager, new Object[]{5, Integer.valueOf(b2)})).booleanValue();
                    }
                }
                String c2 = c(context, list.get(i2), str, network);
                try {
                    if (!TextUtils.isEmpty(c2)) {
                        jSONObject = new JSONObject(c2);
                    }
                    if (jSONObject != null && jSONObject.getInt("result") == 0) {
                        return c2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i2++;
        }
    }

    public static String a(String str, String str2) {
        return j.b(str, str2);
    }

    private void a(Context context, String str, r.a aVar, int i2, PreCodeListener preCodeListener) {
        r.a().a(new d(this, r.a().b(aVar), i2, aVar, str, context, preCodeListener));
    }

    private String b() {
        try {
            String uuid = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(uuid)) {
                return "";
            }
            String replace = uuid.replace("-", "");
            return replace.length() >= 16 ? replace.substring(0, 16) : replace;
        } catch (Throwable th2) {
            CtAuth.warn(a, "generateAesKey error", th2);
            return "";
        }
    }

    public static String b(Context context, String str, String str2, Network network) {
        JSONObject jSONObject;
        String a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("result");
            String optString = jSONObject.optString("data");
            if (optInt == 0 && !TextUtils.isEmpty(optString)) {
                a2 = a(optString, str2);
                if (!TextUtils.isEmpty(a2)) {
                    jSONObject.put("data", new JSONObject(a2));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject.put("data", a2);
        } catch (Throwable th2) {
            CtAuth.warn(a, "decryptResult error", th2);
            return null;
        }
        return jSONObject.toString();
    }

    public static String c(Context context, String str, String str2, Network network) {
        return b(context, l.a(context, str, network), str2, network);
    }

    public void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        int i2 = CtAuth.mTotalTimeout;
        int i3 = i2 <= 0 ? 10000 : i2;
        String a2 = i.a();
        String b2 = i.b(context);
        e.a(a2).d(str).e(b2).c("preauth").g(n.c(context)).b(context.getPackageName());
        a(context, a2, (r.a) new a(context, str, str2, str3, b2, a2, preCodeListener), i3, preCodeListener);
    }

    public void b(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        int i2 = CtAuth.mTotalTimeout;
        int i3 = i2 <= 0 ? 10000 : i2;
        String a2 = i.a();
        String b2 = i.b(context);
        e.a(a2).d(str).e(b2).c("preauth").g(n.c(context)).b(context.getPackageName());
        if (Build.VERSION.SDK_INT >= 21) {
            m mVar = new m();
            mVar.a(context, (m.c) new b(a2, context, str, str2, str3, b2, preCodeListener));
            mVar.a(i3);
            return;
        }
        Context context2 = context;
        a(context, a2, (r.a) new c(context, str, str2, str3, b2, a2, preCodeListener), i3, preCodeListener);
    }
}
