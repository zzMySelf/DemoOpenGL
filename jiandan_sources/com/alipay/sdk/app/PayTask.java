package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.q.f;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.util.H5PayResultModel;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.baidu.pass.permissions.PermissionsHelperActivity;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class PayTask {
    public static final Object h = h.class;

    /* renamed from: i  reason: collision with root package name */
    public static long f655i;
    public Activity a;
    public com.alipay.sdk.m.x.a b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, c> g = new HashMap();

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        public void run() {
            H5PayResultModel h5Pay = PayTask.this.h5Pay(new com.alipay.sdk.m.s.a(PayTask.this.a, this.a, "payInterceptorWithUrl"), this.a, this.b);
            e.d(com.alipay.sdk.m.l.a.A, "inc finished: " + h5Pay.getResultCode());
            this.c.onPayResult(h5Pay);
        }
    }

    public class b implements h.f {
        public b() {
        }

        public void a() {
            PayTask.this.dismissLoading();
        }

        public void b() {
        }
    }

    public class c {
        public String a;
        public String b;
        public String c;
        public String d;

        public c() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.a = str;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.a = activity;
        com.alipay.sdk.m.s.b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.j);
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                com.alipay.sdk.m.s.b.d().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - f655i < ((long) com.alipay.sdk.m.m.a.z().d())) {
                    return false;
                }
                f655i = elapsedRealtime;
                com.alipay.sdk.m.m.a.z().a(com.alipay.sdk.m.s.a.h(), context.getApplicationContext(), false, 4);
                return true;
            } catch (Exception e2) {
                e.a((Throwable) e2);
                return false;
            }
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x01a1=Splitter:B:61:0x01a1, B:69:0x01c5=Splitter:B:69:0x01c5, B:102:0x0306=Splitter:B:102:0x0306, B:107:0x0319=Splitter:B:107:0x0319, B:112:0x032c=Splitter:B:112:0x032c, B:124:0x03ad=Splitter:B:124:0x03ad} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String fetchOrderInfoFromH5PayUrl(java.lang.String r17) {
        /*
            r16 = this;
            r8 = r16
            r0 = r17
            monitor-enter(r16)
            boolean r1 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x03d6
            java.lang.String r9 = r17.trim()     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "https://wappaygw.alipay.com/service/rest.htm"
            boolean r1 = r9.startsWith(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x001f
            java.lang.String r1 = "http://wappaygw.alipay.com/service/rest.htm"
            boolean r1 = r9.startsWith(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 == 0) goto L_0x006b
        L_0x001f:
            java.lang.String r1 = "(http|https)://wappaygw.alipay.com/service/rest.htm\\?"
            java.lang.String r2 = ""
            java.lang.String r1 = r9.replaceFirst(r1, r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x03d2 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x03d2 }
            if (r2 != 0) goto L_0x006b
            java.util.Map r0 = com.alipay.sdk.m.u.n.b((java.lang.String) r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "req_data"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "<request_token>"
            java.lang.String r2 = "</request_token>"
            java.lang.String r0 = com.alipay.sdk.m.u.n.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x03d2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d2 }
            r1.<init>()     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "_input_charset=\"utf-8\"&ordertoken=\""
            r1.append(r2)     // Catch:{ all -> 0x03d2 }
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\""
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            android.app.Activity r0 = r8.a     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = a((android.content.Context) r0)     // Catch:{ all -> 0x03d2 }
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = "\""
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x03d2 }
            monitor-exit(r16)
            return r0
        L_0x006b:
            java.lang.String r1 = "https://mclient.alipay.com/service/rest.htm"
            boolean r1 = r9.startsWith(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x007b
            java.lang.String r1 = "http://mclient.alipay.com/service/rest.htm"
            boolean r1 = r9.startsWith(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 == 0) goto L_0x00c7
        L_0x007b:
            java.lang.String r1 = "(http|https)://mclient.alipay.com/service/rest.htm\\?"
            java.lang.String r2 = ""
            java.lang.String r1 = r9.replaceFirst(r1, r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x03d2 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x03d2 }
            if (r2 != 0) goto L_0x00c7
            java.util.Map r0 = com.alipay.sdk.m.u.n.b((java.lang.String) r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "req_data"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "<request_token>"
            java.lang.String r2 = "</request_token>"
            java.lang.String r0 = com.alipay.sdk.m.u.n.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x03d2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d2 }
            r1.<init>()     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "_input_charset=\"utf-8\"&ordertoken=\""
            r1.append(r2)     // Catch:{ all -> 0x03d2 }
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\""
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            android.app.Activity r0 = r8.a     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = a((android.content.Context) r0)     // Catch:{ all -> 0x03d2 }
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = "\""
            r1.append(r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x03d2 }
            monitor-exit(r16)
            return r0
        L_0x00c7:
            java.lang.String r1 = "https://mclient.alipay.com/home/exterfaceAssign.htm"
            boolean r1 = r9.startsWith(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x00d7
            java.lang.String r1 = "http://mclient.alipay.com/home/exterfaceAssign.htm"
            boolean r1 = r9.startsWith(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 == 0) goto L_0x0125
        L_0x00d7:
            java.lang.String r1 = "alipay.wap.create.direct.pay.by.user"
            boolean r1 = r9.contains(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = "create_forex_trade_wap"
            boolean r1 = r9.contains(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 == 0) goto L_0x0125
        L_0x00e7:
            java.lang.String r1 = "(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?"
            java.lang.String r2 = ""
            java.lang.String r1 = r9.replaceFirst(r1, r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x03d2 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x0125
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x03d2 }
            r1.<init>()     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "url"
            r1.put(r2, r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = "bizcontext"
            android.app.Activity r2 = r8.a     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = a((android.content.Context) r2)     // Catch:{ all -> 0x03d2 }
            r1.put(r0, r2)     // Catch:{ all -> 0x03d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d2 }
            r0.<init>()     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "new_external_info=="
            r0.append(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x03d2 }
            r0.append(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03d2 }
            monitor-exit(r16)
            return r0
        L_0x0125:
            java.lang.String r1 = "^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)     // Catch:{ all -> 0x03d2 }
            java.util.regex.Matcher r1 = r1.matcher(r0)     // Catch:{ all -> 0x03d2 }
            boolean r1 = r1.find()     // Catch:{ all -> 0x03d2 }
            r10 = 0
            if (r1 == 0) goto L_0x0262
            java.lang.String r1 = "?"
            java.lang.String r2 = ""
            java.lang.String r0 = com.alipay.sdk.m.u.n.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x03d2 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x0262
            java.util.Map r0 = com.alipay.sdk.m.u.n.b((java.lang.String) r0)     // Catch:{ all -> 0x03d2 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d2 }
            r11.<init>()     // Catch:{ all -> 0x03d2 }
            r2 = 0
            r3 = 1
            java.lang.String r4 = "trade_no"
            java.lang.String r1 = "trade_no"
            java.lang.String r5 = "alipay_trade_no"
            java.lang.String[] r7 = new java.lang.String[]{r1, r5}     // Catch:{ all -> 0x03d2 }
            r1 = r16
            r5 = r11
            r6 = r0
            boolean r1 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x03d2 }
            if (r1 == 0) goto L_0x0262
            r2 = 1
            r3 = 0
            java.lang.String r4 = "pay_phase_id"
            java.lang.String r1 = "payPhaseId"
            java.lang.String r5 = "pay_phase_id"
            java.lang.String r6 = "out_relation_id"
            java.lang.String[] r7 = new java.lang.String[]{r1, r5, r6}     // Catch:{ all -> 0x03d2 }
            r1 = r16
            r5 = r11
            r6 = r0
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "&biz_sub_type=\"TRADE\""
            r11.append(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "&biz_type=\"trade\""
            r11.append(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "app_name"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x03d2 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x03d2 }
            if (r2 == 0) goto L_0x01a1
            java.lang.String r2 = "cid"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x03d2 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x03d2 }
            if (r2 != 0) goto L_0x01a1
            java.lang.String r1 = "ali1688"
            goto L_0x01c5
        L_0x01a1:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x03d2 }
            if (r2 == 0) goto L_0x01c5
            java.lang.String r2 = "sid"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x03d2 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x03d2 }
            if (r2 == 0) goto L_0x01c3
            java.lang.String r2 = "s_id"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x03d2 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x03d2 }
            if (r2 != 0) goto L_0x01c5
        L_0x01c3:
            java.lang.String r1 = "tb"
        L_0x01c5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d2 }
            r2.<init>()     // Catch:{ all -> 0x03d2 }
            java.lang.String r3 = "&app_name=\""
            r2.append(r3)     // Catch:{ all -> 0x03d2 }
            r2.append(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "\""
            r2.append(r1)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x03d2 }
            r11.append(r1)     // Catch:{ all -> 0x03d2 }
            r2 = 1
            r3 = 1
            java.lang.String r4 = "extern_token"
            java.lang.String r1 = "extern_token"
            java.lang.String r5 = "cid"
            java.lang.String r6 = "sid"
            java.lang.String r7 = "s_id"
            java.lang.String[] r7 = new java.lang.String[]{r1, r5, r6, r7}     // Catch:{ all -> 0x03d2 }
            r1 = r16
            r5 = r11
            r6 = r0
            boolean r1 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x03d2 }
            if (r1 != 0) goto L_0x01fc
            java.lang.String r0 = ""
            monitor-exit(r16)
            return r0
        L_0x01fc:
            r2 = 1
            r3 = 0
            java.lang.String r4 = "appenv"
            java.lang.String r1 = "appenv"
            java.lang.String[] r7 = new java.lang.String[]{r1}     // Catch:{ all -> 0x03d2 }
            r1 = r16
            r5 = r11
            r6 = r0
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = "&pay_channel_id=\"alipay_sdk\""
            r11.append(r1)     // Catch:{ all -> 0x03d2 }
            com.alipay.sdk.app.PayTask$c r1 = new com.alipay.sdk.app.PayTask$c     // Catch:{ all -> 0x03d2 }
            r1.<init>(r8, r10)     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "return_url"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x03d2 }
            r1.b(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "show_url"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x03d2 }
            r1.c(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "pay_order_id"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03d2 }
            r1.a(r0)     // Catch:{ all -> 0x03d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d2 }
            r0.<init>()     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = r11.toString()     // Catch:{ all -> 0x03d2 }
            r0.append(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "&bizcontext=\""
            r0.append(r2)     // Catch:{ all -> 0x03d2 }
            android.app.Activity r2 = r8.a     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = a((android.content.Context) r2)     // Catch:{ all -> 0x03d2 }
            r0.append(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r2 = "\""
            r0.append(r2)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03d2 }
            java.util.Map<java.lang.String, com.alipay.sdk.app.PayTask$c> r2 = r8.g     // Catch:{ all -> 0x03d2 }
            r2.put(r0, r1)     // Catch:{ all -> 0x03d2 }
            monitor-exit(r16)
            return r0
        L_0x0262:
            java.lang.String r0 = "https://mclient.alipay.com/cashier/mobilepay.htm"
            boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x03d2 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x03ad
            java.lang.String r0 = "http://mclient.alipay.com/cashier/mobilepay.htm"
            boolean r0 = r9.startsWith(r0)     // Catch:{ all -> 0x03d2 }
            if (r0 != 0) goto L_0x03ad
            boolean r0 = com.alipay.sdk.app.EnvUtils.isSandBox()     // Catch:{ all -> 0x03d2 }
            if (r0 == 0) goto L_0x0284
            java.lang.String r0 = "mobileclientgw.alipaydev.com/cashier/mobilepay.htm"
            boolean r0 = r9.contains(r0)     // Catch:{ all -> 0x03d2 }
            if (r0 == 0) goto L_0x0284
            goto L_0x03ad
        L_0x0284:
            com.alipay.sdk.m.m.a r0 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x03d2 }
            boolean r0 = r0.g()     // Catch:{ all -> 0x03d2 }
            if (r0 == 0) goto L_0x03d6
            java.lang.String r0 = "^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x03d2 }
            java.util.regex.Matcher r0 = r0.matcher(r9)     // Catch:{ all -> 0x03d2 }
            boolean r0 = r0.find()     // Catch:{ all -> 0x03d2 }
            if (r0 == 0) goto L_0x03d6
            android.net.Uri r0 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x03d2 }
            java.lang.String r3 = "return_url"
            java.lang.String r3 = r0.getQueryParameter(r3)     // Catch:{ all -> 0x03d2 }
            java.lang.String r4 = "show_url"
            java.lang.String r4 = r0.getQueryParameter(r4)     // Catch:{ all -> 0x03d2 }
            java.lang.String r5 = "pay_order_id"
            java.lang.String r5 = r0.getQueryParameter(r5)     // Catch:{ all -> 0x03d2 }
            r6 = 2
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ all -> 0x03d2 }
            java.lang.String r9 = "trade_nos"
            java.lang.String r9 = r0.getQueryParameter(r9)     // Catch:{ all -> 0x03d2 }
            r7[r1] = r9     // Catch:{ all -> 0x03d2 }
            java.lang.String r9 = "alipay_trade_no"
            java.lang.String r9 = r0.getQueryParameter(r9)     // Catch:{ all -> 0x03d2 }
            r7[r2] = r9     // Catch:{ all -> 0x03d2 }
            java.lang.String r7 = a((java.lang.String[]) r7)     // Catch:{ all -> 0x03d2 }
            r9 = 3
            java.lang.String[] r11 = new java.lang.String[r9]     // Catch:{ all -> 0x03d2 }
            java.lang.String r12 = "payPhaseId"
            java.lang.String r12 = r0.getQueryParameter(r12)     // Catch:{ all -> 0x03d2 }
            r11[r1] = r12     // Catch:{ all -> 0x03d2 }
            java.lang.String r12 = "pay_phase_id"
            java.lang.String r12 = r0.getQueryParameter(r12)     // Catch:{ all -> 0x03d2 }
            r11[r2] = r12     // Catch:{ all -> 0x03d2 }
            java.lang.String r12 = "out_relation_id"
            java.lang.String r12 = r0.getQueryParameter(r12)     // Catch:{ all -> 0x03d2 }
            r11[r6] = r12     // Catch:{ all -> 0x03d2 }
            java.lang.String r11 = a((java.lang.String[]) r11)     // Catch:{ all -> 0x03d2 }
            r12 = 4
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ all -> 0x03d2 }
            java.lang.String r14 = "app_name"
            java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x03d2 }
            r13[r1] = r14     // Catch:{ all -> 0x03d2 }
            java.lang.String r14 = "cid"
            java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x03d2 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x03d2 }
            if (r14 != 0) goto L_0x0304
            java.lang.String r14 = "ali1688"
            goto L_0x0306
        L_0x0304:
            java.lang.String r14 = ""
        L_0x0306:
            r13[r2] = r14     // Catch:{ all -> 0x03d2 }
            java.lang.String r14 = "sid"
            java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x03d2 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x03d2 }
            if (r14 != 0) goto L_0x0317
            java.lang.String r14 = "tb"
            goto L_0x0319
        L_0x0317:
            java.lang.String r14 = ""
        L_0x0319:
            r13[r6] = r14     // Catch:{ all -> 0x03d2 }
            java.lang.String r14 = "s_id"
            java.lang.String r14 = r0.getQueryParameter(r14)     // Catch:{ all -> 0x03d2 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x03d2 }
            if (r14 != 0) goto L_0x032a
            java.lang.String r14 = "tb"
            goto L_0x032c
        L_0x032a:
            java.lang.String r14 = ""
        L_0x032c:
            r13[r9] = r14     // Catch:{ all -> 0x03d2 }
            java.lang.String r13 = a((java.lang.String[]) r13)     // Catch:{ all -> 0x03d2 }
            java.lang.String[] r14 = new java.lang.String[r12]     // Catch:{ all -> 0x03d2 }
            java.lang.String r15 = "extern_token"
            java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x03d2 }
            r14[r1] = r15     // Catch:{ all -> 0x03d2 }
            java.lang.String r15 = "cid"
            java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x03d2 }
            r14[r2] = r15     // Catch:{ all -> 0x03d2 }
            java.lang.String r15 = "sid"
            java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x03d2 }
            r14[r6] = r15     // Catch:{ all -> 0x03d2 }
            java.lang.String r15 = "s_id"
            java.lang.String r15 = r0.getQueryParameter(r15)     // Catch:{ all -> 0x03d2 }
            r14[r9] = r15     // Catch:{ all -> 0x03d2 }
            java.lang.String r14 = a((java.lang.String[]) r14)     // Catch:{ all -> 0x03d2 }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ all -> 0x03d2 }
            java.lang.String r10 = "appenv"
            java.lang.String r0 = r0.getQueryParameter(r10)     // Catch:{ all -> 0x03d2 }
            r15[r1] = r0     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = a((java.lang.String[]) r15)     // Catch:{ all -> 0x03d2 }
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x03d2 }
            if (r10 != 0) goto L_0x03d6
            boolean r10 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x03d2 }
            if (r10 != 0) goto L_0x03d6
            boolean r10 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x03d2 }
            if (r10 != 0) goto L_0x03d6
            java.lang.String r10 = "trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\""
            r15 = 6
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ all -> 0x03d2 }
            r15[r1] = r7     // Catch:{ all -> 0x03d2 }
            r15[r2] = r11     // Catch:{ all -> 0x03d2 }
            r15[r6] = r13     // Catch:{ all -> 0x03d2 }
            r15[r9] = r14     // Catch:{ all -> 0x03d2 }
            r15[r12] = r0     // Catch:{ all -> 0x03d2 }
            r0 = 5
            android.app.Activity r1 = r8.a     // Catch:{ all -> 0x03d2 }
            java.lang.String r1 = a((android.content.Context) r1)     // Catch:{ all -> 0x03d2 }
            r15[r0] = r1     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = java.lang.String.format(r10, r15)     // Catch:{ all -> 0x03d2 }
            com.alipay.sdk.app.PayTask$c r1 = new com.alipay.sdk.app.PayTask$c     // Catch:{ all -> 0x03d2 }
            r2 = 0
            r1.<init>(r8, r2)     // Catch:{ all -> 0x03d2 }
            r1.b(r3)     // Catch:{ all -> 0x03d2 }
            r1.c(r4)     // Catch:{ all -> 0x03d2 }
            r1.a(r5)     // Catch:{ all -> 0x03d2 }
            r1.d(r7)     // Catch:{ all -> 0x03d2 }
            java.util.Map<java.lang.String, com.alipay.sdk.app.PayTask$c> r2 = r8.g     // Catch:{ all -> 0x03d2 }
            r2.put(r0, r1)     // Catch:{ all -> 0x03d2 }
            monitor-exit(r16)
            return r0
        L_0x03ad:
            android.app.Activity r0 = r8.a     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = a((android.content.Context) r0)     // Catch:{ all -> 0x03d2 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x03d2 }
            r3.<init>()     // Catch:{ all -> 0x03d2 }
            java.lang.String r4 = "url"
            r3.put(r4, r9)     // Catch:{ all -> 0x03d2 }
            java.lang.String r4 = "bizcontext"
            r3.put(r4, r0)     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = "new_external_info==%s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x03d2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03d2 }
            r2[r1] = r3     // Catch:{ all -> 0x03d2 }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x03d2 }
            monitor-exit(r16)
            return r0
        L_0x03d2:
            r0 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x03da }
        L_0x03d6:
            java.lang.String r0 = ""
            monitor-exit(r16)
            return r0
        L_0x03da:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.fetchOrderInfoFromH5PayUrl(java.lang.String):java.lang.String");
    }

    public synchronized String fetchTradeToken() {
        return i.a(new com.alipay.sdk.m.s.a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.16";
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] split = a(aVar, str, z).split(i.b);
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                int indexOf = str2.indexOf("={");
                if (indexOf >= 0) {
                    String substring = str2.substring(0, indexOf);
                    hashMap.put(substring, a(str2, substring));
                }
            }
            if (hashMap.containsKey("resultStatus")) {
                h5PayResultModel.setResultCode((String) hashMap.get("resultStatus"));
            }
            h5PayResultModel.setReturnUrl(a(str, (Map<String, String>) hashMap));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.n0, "");
            }
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.o0, th2);
            e.a(th2);
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        if (com.alipay.sdk.m.u.b.a()) {
            return com.alipay.sdk.m.j.b.b();
        }
        return a(new com.alipay.sdk.m.s.a(this.a, str, QueryResponse.Options.PAY), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            e.d(com.alipay.sdk.m.l.a.A, "intercepted: " + fetchOrderInfoFromH5PayUrl);
            new Thread(new a(fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String str2;
        com.alipay.sdk.m.s.a aVar;
        if (com.alipay.sdk.m.u.b.a()) {
            aVar = null;
            str2 = com.alipay.sdk.m.j.b.b();
        } else {
            com.alipay.sdk.m.s.a aVar2 = new com.alipay.sdk.m.s.a(this.a, str, "payV2");
            str2 = a(aVar2, str, z);
            aVar = aVar2;
        }
        return l.a(aVar, str2);
    }

    public void showLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0107, code lost:
        if (com.alipay.sdk.m.m.a.z().p() == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x015d, code lost:
        if (com.alipay.sdk.m.m.a.z().p() != false) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x015f, code lost:
        com.alipay.sdk.m.m.a.z().a(r7, r6.a.getApplicationContext(), false, 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x016c, code lost:
        dismissLoading();
        com.alipay.sdk.m.k.a.b(r6.a.getApplicationContext(), r7, r8, r7.d);
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "pay returning: " + r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String a(com.alipay.sdk.m.s.a r7, java.lang.String r8, boolean r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r9 == 0) goto L_0x0006
            r6.showLoading()     // Catch:{ all -> 0x01fc }
        L_0x0006:
            java.lang.String r9 = "payment_inst="
            boolean r9 = r8.contains(r9)     // Catch:{ all -> 0x01fc }
            r0 = 0
            if (r9 == 0) goto L_0x0043
            java.lang.String r9 = "payment_inst="
            int r9 = r8.indexOf(r9)     // Catch:{ all -> 0x01fc }
            int r9 = r9 + 13
            java.lang.String r9 = r8.substring(r9)     // Catch:{ all -> 0x01fc }
            r1 = 38
            int r1 = r9.indexOf(r1)     // Catch:{ all -> 0x01fc }
            if (r1 <= 0) goto L_0x0027
            java.lang.String r9 = r9.substring(r0, r1)     // Catch:{ all -> 0x01fc }
        L_0x0027:
            java.lang.String r1 = "\""
            java.lang.String r2 = ""
            java.lang.String r9 = r9.replaceAll(r1, r2)     // Catch:{ all -> 0x01fc }
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ all -> 0x01fc }
            java.lang.String r9 = r9.toLowerCase(r1)     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = "alipay"
            java.lang.String r2 = ""
            java.lang.String r9 = r9.replaceAll(r1, r2)     // Catch:{ all -> 0x01fc }
            com.alipay.sdk.m.j.a.a(r9)     // Catch:{ all -> 0x01fc }
            goto L_0x0048
        L_0x0043:
            java.lang.String r9 = ""
            com.alipay.sdk.m.j.a.a(r9)     // Catch:{ all -> 0x01fc }
        L_0x0048:
            java.lang.String r9 = "service=alipay.acquire.mr.ord.createandpay"
            boolean r9 = r8.contains(r9)     // Catch:{ all -> 0x01fc }
            if (r9 == 0) goto L_0x0053
            r9 = 1
            com.alipay.sdk.m.l.a.x = r9     // Catch:{ all -> 0x01fc }
        L_0x0053:
            boolean r9 = com.alipay.sdk.m.l.a.x     // Catch:{ all -> 0x01fc }
            if (r9 == 0) goto L_0x0080
            java.lang.String r9 = "https://wappaygw.alipay.com/home/exterfaceAssign.htm?"
            boolean r9 = r8.startsWith(r9)     // Catch:{ all -> 0x01fc }
            if (r9 == 0) goto L_0x006c
            java.lang.String r9 = "https://wappaygw.alipay.com/home/exterfaceAssign.htm?"
            int r9 = r8.indexOf(r9)     // Catch:{ all -> 0x01fc }
            int r9 = r9 + 53
            java.lang.String r8 = r8.substring(r9)     // Catch:{ all -> 0x01fc }
            goto L_0x0080
        L_0x006c:
            java.lang.String r9 = "https://mclient.alipay.com/home/exterfaceAssign.htm?"
            boolean r9 = r8.startsWith(r9)     // Catch:{ all -> 0x01fc }
            if (r9 == 0) goto L_0x0080
            java.lang.String r9 = "https://mclient.alipay.com/home/exterfaceAssign.htm?"
            int r9 = r8.indexOf(r9)     // Catch:{ all -> 0x01fc }
            int r9 = r9 + 52
            java.lang.String r8 = r8.substring(r9)     // Catch:{ all -> 0x01fc }
        L_0x0080:
            java.lang.String r9 = ""
            java.lang.String r1 = "mspl"
            r2 = 3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            r3.<init>()     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "pay prepared: "
            r3.append(r4)     // Catch:{ all -> 0x010a }
            r3.append(r8)     // Catch:{ all -> 0x010a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x010a }
            com.alipay.sdk.m.u.e.d(r1, r3)     // Catch:{ all -> 0x010a }
            java.lang.String r9 = r6.a((java.lang.String) r8, (com.alipay.sdk.m.s.a) r7)     // Catch:{ all -> 0x010a }
            java.lang.String r1 = "mspl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            r3.<init>()     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "pay raw result: "
            r3.append(r4)     // Catch:{ all -> 0x010a }
            r3.append(r9)     // Catch:{ all -> 0x010a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x010a }
            com.alipay.sdk.m.u.e.d(r1, r3)     // Catch:{ all -> 0x010a }
            android.app.Activity r1 = r6.a     // Catch:{ all -> 0x010a }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x010a }
            com.alipay.sdk.m.u.i.a(r7, r1, r9)     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fc }
            r1.<init>()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = ""
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01fc }
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturn"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r1)     // Catch:{ all -> 0x01fc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fc }
            r1.<init>()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "resultStatus"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x01fc }
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "|"
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "memo"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x01fc }
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturnV"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r1)     // Catch:{ all -> 0x01fc }
            com.alipay.sdk.m.m.a r1 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x01fc }
            boolean r1 = r1.p()     // Catch:{ all -> 0x01fc }
            if (r1 != 0) goto L_0x016c
            goto L_0x015f
        L_0x010a:
            r1 = move-exception
            java.lang.String r9 = com.alipay.sdk.m.j.b.a()     // Catch:{ all -> 0x0192 }
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0192 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fc }
            r1.<init>()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = ""
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01fc }
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturn"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r1)     // Catch:{ all -> 0x01fc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fc }
            r1.<init>()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "resultStatus"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x01fc }
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "|"
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "memo"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x01fc }
            r1.append(r3)     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturnV"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r1)     // Catch:{ all -> 0x01fc }
            com.alipay.sdk.m.m.a r1 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x01fc }
            boolean r1 = r1.p()     // Catch:{ all -> 0x01fc }
            if (r1 != 0) goto L_0x016c
        L_0x015f:
            com.alipay.sdk.m.m.a r1 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x01fc }
            android.app.Activity r3 = r6.a     // Catch:{ all -> 0x01fc }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x01fc }
            r1.a(r7, r3, r0, r2)     // Catch:{ all -> 0x01fc }
        L_0x016c:
            r6.dismissLoading()     // Catch:{ all -> 0x01fc }
            android.app.Activity r0 = r6.a     // Catch:{ all -> 0x01fc }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = r7.d     // Catch:{ all -> 0x01fc }
            com.alipay.sdk.m.k.a.b((android.content.Context) r0, (com.alipay.sdk.m.s.a) r7, (java.lang.String) r8, (java.lang.String) r1)     // Catch:{ all -> 0x01fc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fc }
            r7.<init>()     // Catch:{ all -> 0x01fc }
            java.lang.String r8 = "pay returning: "
            r7.append(r8)     // Catch:{ all -> 0x01fc }
            r7.append(r9)     // Catch:{ all -> 0x01fc }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01fc }
            java.lang.String r8 = "mspl"
            com.alipay.sdk.m.u.e.d(r8, r7)     // Catch:{ all -> 0x01fc }
            monitor-exit(r6)
            return r9
        L_0x0192:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fc }
            r3.<init>()     // Catch:{ all -> 0x01fc }
            java.lang.String r4 = ""
            r3.append(r4)     // Catch:{ all -> 0x01fc }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01fc }
            r3.append(r4)     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01fc }
            java.lang.String r4 = "biz"
            java.lang.String r5 = "PgReturn"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r3)     // Catch:{ all -> 0x01fc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fc }
            r3.<init>()     // Catch:{ all -> 0x01fc }
            java.lang.String r4 = "resultStatus"
            java.lang.String r4 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r4)     // Catch:{ all -> 0x01fc }
            r3.append(r4)     // Catch:{ all -> 0x01fc }
            java.lang.String r4 = "|"
            r3.append(r4)     // Catch:{ all -> 0x01fc }
            java.lang.String r4 = "memo"
            java.lang.String r9 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r4)     // Catch:{ all -> 0x01fc }
            r3.append(r9)     // Catch:{ all -> 0x01fc }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x01fc }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturnV"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r9)     // Catch:{ all -> 0x01fc }
            com.alipay.sdk.m.m.a r9 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x01fc }
            boolean r9 = r9.p()     // Catch:{ all -> 0x01fc }
            if (r9 != 0) goto L_0x01ed
            com.alipay.sdk.m.m.a r9 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x01fc }
            android.app.Activity r3 = r6.a     // Catch:{ all -> 0x01fc }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x01fc }
            r9.a(r7, r3, r0, r2)     // Catch:{ all -> 0x01fc }
        L_0x01ed:
            r6.dismissLoading()     // Catch:{ all -> 0x01fc }
            android.app.Activity r9 = r6.a     // Catch:{ all -> 0x01fc }
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x01fc }
            java.lang.String r0 = r7.d     // Catch:{ all -> 0x01fc }
            com.alipay.sdk.m.k.a.b((android.content.Context) r9, (com.alipay.sdk.m.s.a) r7, (java.lang.String) r8, (java.lang.String) r0)     // Catch:{ all -> 0x01fc }
            throw r1     // Catch:{ all -> 0x01fc }
        L_0x01fc:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.m.s.a, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051 A[Catch:{ all -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r6) {
        /*
            java.lang.String r0 = "sc"
            java.lang.String r1 = ""
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch:{ Exception -> 0x0018 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x0018 }
            r3 = 0
            android.content.pm.PackageInfo r6 = r2.getPackageInfo(r6, r3)     // Catch:{ Exception -> 0x0018 }
            java.lang.String r2 = r6.versionName     // Catch:{ Exception -> 0x0018 }
            java.lang.String r6 = r6.packageName     // Catch:{ Exception -> 0x0016 }
            goto L_0x001e
        L_0x0016:
            r6 = move-exception
            goto L_0x001a
        L_0x0018:
            r6 = move-exception
            r2 = r1
        L_0x001a:
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r6)
            r6 = r1
        L_0x001e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x005b }
            r3.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "appkey"
            java.lang.String r5 = "2014052600006128"
            r3.put(r4, r5)     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "ty"
            java.lang.String r5 = "and_lite"
            r3.put(r4, r5)     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "sv"
            java.lang.String r5 = "h.a.3.8.16"
            r3.put(r4, r5)     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "an"
            r3.put(r4, r6)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = "av"
            r3.put(r6, r2)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = "sdk_start_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005b }
            r3.put(r6, r4)     // Catch:{ all -> 0x005b }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x005b }
            if (r6 != 0) goto L_0x0056
            java.lang.String r6 = "h5tonative"
            r3.put(r0, r6)     // Catch:{ all -> 0x005b }
        L_0x0056:
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x005b }
            return r6
        L_0x005b:
            r6 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(android.content.Context):java.lang.String");
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            if (z2) {
                return false;
            }
            return true;
        } else if (z) {
            sb.append(com.alipay.sdk.m.s.a.n);
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        } else {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = Result.RESULT_SUCCESS.equals(map.get("resultStatus"));
        String str2 = map.get("result");
        c remove = this.g.remove(str);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a2 = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a((String) com.alipay.sdk.m.l.a.u, "\"", str2), URLDecoder.decode(n.a((String) com.alipay.sdk.m.l.a.v, (String) com.alipay.sdk.m.s.a.n, str2), com.baidu.apollon.heartbeat.a.h), URLDecoder.decode(n.a("&callBackUrl=", (String) com.alipay.sdk.m.s.a.n, str2), com.baidu.apollon.heartbeat.a.h), n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (remove != null) {
            String b2 = equals ? remove.b() : remove.c();
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
        }
        return remove != null ? com.alipay.sdk.m.m.a.z().o() : "";
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    private h.f a() {
        return new b();
    }

    private String a(String str, com.alipay.sdk.m.s.a aVar) {
        String a2 = aVar.a(str);
        if (a2.contains("paymethod=\"expressGateway\"")) {
            return a(aVar, a2);
        }
        List<a.b> j = com.alipay.sdk.m.m.a.z().j();
        if (!com.alipay.sdk.m.m.a.z().g || j == null) {
            j = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, j, true)) {
            h hVar = new h(this.a, aVar, a());
            e.d(com.alipay.sdk.m.l.a.A, "pay inner started: " + a2);
            String a3 = hVar.a(a2, false);
            if (!TextUtils.isEmpty(a3)) {
                if (a3.contains("resultStatus={" + com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT.b() + "}")) {
                    n.a("alipaySdk", com.alipay.sdk.m.l.b.q, (Context) this.a, aVar);
                    a3 = hVar.a(a2, true);
                }
            }
            e.d(com.alipay.sdk.m.l.a.A, "pay inner raw result: " + a3);
            hVar.a();
            boolean t = com.alipay.sdk.m.m.a.z().t();
            if (TextUtils.equals(a3, h.f684i) || TextUtils.equals(a3, h.j) || (t && aVar.e())) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
                return a(aVar, a2);
            } else if (TextUtils.isEmpty(a3)) {
                return com.alipay.sdk.m.j.b.a();
            } else {
                if (!a3.contains(PayResultActivity.b)) {
                    return a3;
                }
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.k0);
                return a(aVar, a2, j, a3, this.a);
            }
        } else {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
            return a(aVar, a2);
        }
    }

    public static String a(com.alipay.sdk.m.s.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        n.c a2 = n.a(aVar, (Context) activity, list);
        if (a2 == null || a2.a(aVar) || a2.a() || !TextUtils.equals(a2.a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        e.b(com.alipay.sdk.m.l.a.A, "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        PayResultActivity.c.put(valueOf, new Object());
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra(PayResultActivity.f, str);
        intent.putExtra(PayResultActivity.g, activity.getPackageName());
        intent.putExtra(PayResultActivity.e, valueOf);
        a.C0016a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (PayResultActivity.c.get(valueOf)) {
            try {
                e.b(com.alipay.sdk.m.l.a.A, "PayTask wait");
                PayResultActivity.c.get(valueOf).wait();
            } catch (InterruptedException unused) {
                e.b(com.alipay.sdk.m.l.a.A, "PayTask interrupted");
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String str3 = PayResultActivity.b.b;
        e.b(com.alipay.sdk.m.l.a.A, "PayTask ret: " + str3);
        return str3;
    }

    /* JADX INFO: finally extract failed */
    private String a(com.alipay.sdk.m.s.a aVar, String str) {
        showLoading();
        com.alipay.sdk.m.j.c cVar = null;
        try {
            JSONObject c2 = new f().a(aVar, this.a.getApplicationContext(), str).c();
            String optString = c2.optString("end_code", (String) null);
            List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(c2.optJSONObject(com.alipay.sdk.m.l.c.c).optJSONObject(com.alipay.sdk.m.l.c.d));
            int i2 = 0;
            for (int i3 = 0; i3 < a2.size(); i3++) {
                if (a2.get(i3).a() == com.alipay.sdk.m.r.a.Update) {
                    com.alipay.sdk.m.r.b.a(a2.get(i3));
                }
            }
            a(aVar, c2);
            dismissLoading();
            com.alipay.sdk.m.k.a.a((Context) this.a, aVar, str, aVar.d);
            while (i2 < a2.size()) {
                com.alipay.sdk.m.r.b bVar = a2.get(i2);
                if (bVar.a() == com.alipay.sdk.m.r.a.WapPay) {
                    String a3 = a(aVar, bVar);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a((Context) this.a, aVar, str, aVar.d);
                    return a3;
                } else if (bVar.a() == com.alipay.sdk.m.r.a.OpenWeb) {
                    String a4 = a(aVar, bVar, optString);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a((Context) this.a, aVar, str, aVar.d);
                    return a4;
                } else {
                    i2++;
                }
            }
            dismissLoading();
            com.alipay.sdk.m.k.a.a((Context) this.a, aVar, str, aVar.d);
        } catch (IOException e2) {
            com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.k, (Throwable) e2);
            dismissLoading();
            com.alipay.sdk.m.k.a.a((Context) this.a, aVar, str, aVar.d);
            cVar = b2;
        } catch (Throwable th2) {
            dismissLoading();
            com.alipay.sdk.m.k.a.a((Context) this.a, aVar, str, aVar.d);
            throw th2;
        }
        if (cVar == null) {
            cVar = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
        }
        return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
    }

    private void a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(com.alipay.sdk.m.t.a.j);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).a(optString, optString2);
            }
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.P, th2);
        }
    }

    private String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar, String str) {
        boolean c2;
        String d2;
        String[] c3 = bVar.c();
        Intent intent = new Intent(this.a, H5PayActivity.class);
        try {
            JSONObject h2 = n.h(new String(com.alipay.sdk.m.n.a.a(c3[2])));
            intent.putExtra("url", c3[0]);
            intent.putExtra("title", c3[1]);
            intent.putExtra("version", com.alipay.sdk.m.x.c.d);
            intent.putExtra(com.alipay.sdk.m.p.e.s, h2.optString(com.alipay.sdk.m.p.e.s, "POST"));
            com.alipay.sdk.m.j.b.a(false);
            com.alipay.sdk.m.j.b.a((String) null);
            a.C0016a.a(aVar, intent);
            this.a.startActivity(intent);
            synchronized (h) {
                try {
                    h.wait();
                    c2 = com.alipay.sdk.m.j.b.c();
                    d2 = com.alipay.sdk.m.j.b.d();
                    com.alipay.sdk.m.j.b.a(false);
                    com.alipay.sdk.m.j.b.a((String) null);
                } catch (InterruptedException e2) {
                    e.a((Throwable) e2);
                    return com.alipay.sdk.m.j.b.a();
                }
            }
            String str2 = "";
            if (c2) {
                try {
                    List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(n.h(new String(com.alipay.sdk.m.n.a.a(d2))));
                    int i2 = 0;
                    while (true) {
                        if (i2 >= a2.size()) {
                            break;
                        }
                        com.alipay.sdk.m.r.b bVar2 = a2.get(i2);
                        if (bVar2.a() == com.alipay.sdk.m.r.a.SetResult) {
                            String[] c4 = bVar2.c();
                            str2 = com.alipay.sdk.m.j.b.a(Integer.valueOf(c4[1]).intValue(), c4[0], n.e(aVar, c4[2]));
                            break;
                        }
                        i2++;
                    }
                } catch (Throwable th2) {
                    e.a(th2);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th2, d2);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            try {
                return com.alipay.sdk.m.j.b.a(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th3) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th3, "endCode: " + str);
                return com.alipay.sdk.m.j.b.a(PermissionsHelperActivity.e, "", "");
            }
        } catch (Throwable th4) {
            e.a(th4);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th4, Arrays.toString(c3));
            return com.alipay.sdk.m.j.b.a();
        }
    }

    private String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.a, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString("cookie", c2[1]);
        }
        intent.putExtras(bundle);
        a.C0016a.a(aVar, intent);
        this.a.startActivity(intent);
        synchronized (h) {
            try {
                h.wait();
            } catch (InterruptedException e2) {
                e.a((Throwable) e2);
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String d2 = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(d2) ? com.alipay.sdk.m.j.b.a() : d2;
    }
}
