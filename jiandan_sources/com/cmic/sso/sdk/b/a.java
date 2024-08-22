package com.cmic.sso.sdk.b;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.m;

public class a {
    public static a a;
    public static long b;
    public C0178a c = null;

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public C0178a b() {
        C0178a aVar = this.c;
        return aVar == null ? new C0178a() : aVar;
    }

    /* renamed from: com.cmic.sso.sdk.b.a$a  reason: collision with other inner class name */
    public static class C0178a {
        public int a = -1;
        public int b = -1;

        public int a() {
            return this.b;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007f, code lost:
        if (r11 != null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        if (r11 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        com.cmic.sso.sdk.e.c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0091, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "sim_id"
            java.lang.String r1 = "_id"
            java.lang.String r2 = "UMCTelephonyManagement"
            java.lang.String r3 = "readSimInfoDbStart"
            com.cmic.sso.sdk.e.c.b(r2, r3)
            java.lang.String r3 = "content://telephony/siminfo"
            android.net.Uri r5 = android.net.Uri.parse(r3)
            android.content.ContentResolver r4 = r11.getContentResolver()
            r11 = 0
            java.lang.String[] r6 = new java.lang.String[]{r1, r0}     // Catch:{ Exception -> 0x0082 }
            java.lang.String r7 = "sim_id>=?"
            java.lang.String r3 = "0"
            java.lang.String[] r8 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x0082 }
            r9 = 0
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0082 }
            if (r11 == 0) goto L_0x007f
        L_0x0029:
            boolean r3 = r11.moveToNext()     // Catch:{ Exception -> 0x0082 }
            if (r3 == 0) goto L_0x007f
            int r3 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x0082 }
            int r3 = r11.getInt(r3)     // Catch:{ Exception -> 0x0082 }
            int r4 = r11.getColumnIndex(r1)     // Catch:{ Exception -> 0x0082 }
            int r4 = r11.getInt(r4)     // Catch:{ Exception -> 0x0082 }
            com.cmic.sso.sdk.b.a$a r5 = r10.c     // Catch:{ Exception -> 0x0082 }
            int r5 = r5.a     // Catch:{ Exception -> 0x0082 }
            r6 = -1
            if (r5 != r6) goto L_0x0071
            com.cmic.sso.sdk.b.a$a r5 = r10.c     // Catch:{ Exception -> 0x0082 }
            int r5 = r5.b     // Catch:{ Exception -> 0x0082 }
            if (r5 == r6) goto L_0x0071
            com.cmic.sso.sdk.b.a$a r5 = r10.c     // Catch:{ Exception -> 0x0082 }
            int r5 = r5.b     // Catch:{ Exception -> 0x0082 }
            if (r5 != r4) goto L_0x0071
            com.cmic.sso.sdk.b.a$a r5 = r10.c     // Catch:{ Exception -> 0x0082 }
            int unused = r5.a = r3     // Catch:{ Exception -> 0x0082 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0082 }
            r5.<init>()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r6 = "通过读取sim db获取数据流量卡的卡槽值："
            r5.append(r6)     // Catch:{ Exception -> 0x0082 }
            r5.append(r3)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0082 }
            com.cmic.sso.sdk.e.c.b(r2, r5)     // Catch:{ Exception -> 0x0082 }
        L_0x0071:
            com.cmic.sso.sdk.b.a$a r5 = r10.c     // Catch:{ Exception -> 0x0082 }
            int r5 = r5.a     // Catch:{ Exception -> 0x0082 }
            if (r5 != r3) goto L_0x0029
            com.cmic.sso.sdk.b.a$a r3 = r10.c     // Catch:{ Exception -> 0x0082 }
            int unused = r3.b = r4     // Catch:{ Exception -> 0x0082 }
            goto L_0x0029
        L_0x007f:
            if (r11 == 0) goto L_0x008c
            goto L_0x0089
        L_0x0082:
            java.lang.String r0 = "readSimInfoDb error"
            com.cmic.sso.sdk.e.c.a(r2, r0)     // Catch:{ all -> 0x0092 }
            if (r11 == 0) goto L_0x008c
        L_0x0089:
            r11.close()
        L_0x008c:
            java.lang.String r11 = "readSimInfoDbEnd"
            com.cmic.sso.sdk.e.c.b(r2, r11)
            return
        L_0x0092:
            r0 = move-exception
            if (r11 == 0) goto L_0x0098
            r11.close()
        L_0x0098:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.b.a.b(android.content.Context):void");
    }

    public void a(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - b;
        if (currentTimeMillis >= CoroutineLiveDataKt.DEFAULT_TIMEOUT || currentTimeMillis <= 0) {
            this.c = new C0178a();
            if (z) {
                a(context);
                if (m.e() && m.d()) {
                    c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.c.b == 0 || this.c.b == 1) {
                        if (this.c.a == -1) {
                            C0178a aVar = this.c;
                            int unused = aVar.a = aVar.b;
                        }
                        int unused2 = this.c.b = -1;
                    }
                    if (!(this.c.a == -1 && this.c.b == -1) && Build.VERSION.SDK_INT >= 21) {
                        b(context);
                    }
                }
                b = System.currentTimeMillis();
            }
        }
    }

    private void a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22) {
            SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
            if (from != null) {
                try {
                    if (this.c.a == -1 && i2 >= 24) {
                        int unused = this.c.b = SubscriptionManager.getDefaultDataSubscriptionId();
                        c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                        return;
                    }
                } catch (Exception unused2) {
                    c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
                }
                try {
                    Object invoke = from.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(from, new Object[0]);
                    if ((invoke instanceof Integer) || (invoke instanceof Long)) {
                        int unused3 = this.c.b = ((Integer) invoke).intValue();
                        c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.c.b);
                        return;
                    }
                } catch (Exception unused4) {
                    c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
                }
                try {
                    Object invoke2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(from, new Object[0]);
                    if ((invoke2 instanceof Integer) || (invoke2 instanceof Long)) {
                        int unused5 = this.c.b = ((Integer) invoke2).intValue();
                        c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.c.b);
                    }
                } catch (Exception unused6) {
                    c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
                }
            }
        } else {
            int unused7 = this.c.a = -1;
        }
    }
}
