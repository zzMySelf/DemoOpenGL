package com.alipay.sdk.app;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

public class AlipayResultActivity extends Activity {
    public static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    public interface a {
        void a(int i2, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a remove = a.remove(str);
        if (remove == null) {
            finish();
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString("memo"), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b9 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
            r12 = this;
            java.lang.String r0 = "|"
            java.lang.String r1 = "result"
            java.lang.String r2 = "session"
            java.lang.String r3 = "biz"
            super.onCreate(r13)
            android.content.Intent r13 = r12.getIntent()     // Catch:{ all -> 0x012c }
            r4 = 0
            java.lang.String r5 = r13.getStringExtra(r2)     // Catch:{ all -> 0x011d }
            android.os.Bundle r6 = r13.getBundleExtra(r1)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = "scene"
            java.lang.String r7 = r13.getStringExtra(r7)     // Catch:{ all -> 0x011d }
            com.alipay.sdk.m.s.a r4 = com.alipay.sdk.m.s.a.C0016a.a((java.lang.String) r5)     // Catch:{ all -> 0x011d }
            if (r4 != 0) goto L_0x0028
            r12.finish()     // Catch:{ all -> 0x011d }
            return
        L_0x0028:
            java.lang.String r8 = "BSPSession"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r9.<init>()     // Catch:{ all -> 0x011d }
            r9.append(r5)     // Catch:{ all -> 0x011d }
            r9.append(r0)     // Catch:{ all -> 0x011d }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x011d }
            r9.append(r10)     // Catch:{ all -> 0x011d }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x011d }
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ all -> 0x011d }
            java.lang.String r8 = "mqpSchemePay"
            boolean r7 = android.text.TextUtils.equals(r8, r7)     // Catch:{ all -> 0x012c }
            if (r7 == 0) goto L_0x004f
            r12.a(r5, r6)     // Catch:{ all -> 0x012c }
            return
        L_0x004f:
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x012c }
            if (r7 != 0) goto L_0x0057
            if (r6 != 0) goto L_0x00b1
        L_0x0057:
            android.net.Uri r7 = r13.getData()     // Catch:{ all -> 0x012c }
            if (r7 == 0) goto L_0x00b1
            android.net.Uri r13 = r13.getData()     // Catch:{ all -> 0x00a5 }
            java.lang.String r13 = r13.getQuery()     // Catch:{ all -> 0x00a5 }
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00a5 }
            r8 = 2
            byte[] r13 = android.util.Base64.decode(r13, r8)     // Catch:{ all -> 0x00a5 }
            java.lang.String r8 = "UTF-8"
            r7.<init>(r13, r8)     // Catch:{ all -> 0x00a5 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x00a5 }
            r13.<init>(r7)     // Catch:{ all -> 0x00a5 }
            org.json.JSONObject r1 = r13.getJSONObject(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = r13.getString(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.String r13 = "BSPUriSession"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r13, (java.lang.String) r5)     // Catch:{ all -> 0x00a5 }
            android.os.Bundle r13 = new android.os.Bundle     // Catch:{ all -> 0x00a5 }
            r13.<init>()     // Catch:{ all -> 0x00a5 }
            java.util.Iterator r2 = r1.keys()     // Catch:{ all -> 0x00a2 }
        L_0x008c:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x00a0
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00a2 }
            java.lang.String r7 = r1.getString(r6)     // Catch:{ all -> 0x00a2 }
            r13.putString(r6, r7)     // Catch:{ all -> 0x00a2 }
            goto L_0x008c
        L_0x00a0:
            r6 = r13
            goto L_0x00b1
        L_0x00a2:
            r1 = move-exception
            r6 = r13
            goto L_0x00a7
        L_0x00a5:
            r13 = move-exception
            r1 = r13
        L_0x00a7:
            java.lang.String r13 = "BSPResEx"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r13, (java.lang.Throwable) r1)     // Catch:{ all -> 0x012c }
            java.lang.String r13 = "ParseSchemeQueryError"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r13, (java.lang.Throwable) r1)     // Catch:{ all -> 0x012c }
        L_0x00b1:
            boolean r13 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x012c }
            java.lang.String r1 = ""
            if (r13 != 0) goto L_0x0114
            if (r6 != 0) goto L_0x00bc
            goto L_0x0114
        L_0x00bc:
            java.lang.String r13 = "PgReturn"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            r2.<init>()     // Catch:{ all -> 0x010a }
            r2.append(r1)     // Catch:{ all -> 0x010a }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x010a }
            r2.append(r7)     // Catch:{ all -> 0x010a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x010a }
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r13, (java.lang.String) r2)     // Catch:{ all -> 0x010a }
            java.lang.String r13 = "PgReturnV"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            r2.<init>()     // Catch:{ all -> 0x010a }
            java.lang.String r7 = "endCode"
            r8 = -1
            int r7 = r6.getInt(r7, r8)     // Catch:{ all -> 0x010a }
            r2.append(r7)     // Catch:{ all -> 0x010a }
            r2.append(r0)     // Catch:{ all -> 0x010a }
            java.lang.String r0 = "memo"
            java.lang.String r7 = "-"
            java.lang.String r0 = r6.getString(r0, r7)     // Catch:{ all -> 0x010a }
            r2.append(r0)     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x010a }
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r13, (java.lang.String) r0)     // Catch:{ all -> 0x010a }
            r13 = 9000(0x2328, float:1.2612E-41)
            java.lang.String r0 = "OK"
            com.alipay.sdk.app.OpenAuthTask.a((java.lang.String) r5, (int) r13, (java.lang.String) r0, (android.os.Bundle) r6)     // Catch:{ all -> 0x010a }
            java.lang.String r13 = r4.d     // Catch:{ all -> 0x012c }
            com.alipay.sdk.m.k.a.b((android.content.Context) r12, (com.alipay.sdk.m.s.a) r4, (java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x012c }
            r12.finish()     // Catch:{ all -> 0x012c }
            goto L_0x012f
        L_0x010a:
            r13 = move-exception
            java.lang.String r0 = r4.d     // Catch:{ all -> 0x012c }
            com.alipay.sdk.m.k.a.b((android.content.Context) r12, (com.alipay.sdk.m.s.a) r4, (java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x012c }
            r12.finish()     // Catch:{ all -> 0x012c }
            throw r13     // Catch:{ all -> 0x012c }
        L_0x0114:
            java.lang.String r13 = r4.d     // Catch:{ all -> 0x012c }
            com.alipay.sdk.m.k.a.b((android.content.Context) r12, (com.alipay.sdk.m.s.a) r4, (java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x012c }
            r12.finish()     // Catch:{ all -> 0x012c }
            goto L_0x012f
        L_0x011d:
            r13 = move-exception
            java.lang.String r0 = "BSPSerError"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r13)     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "ParseBundleSerializableError"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r13)     // Catch:{ all -> 0x012c }
            r12.finish()     // Catch:{ all -> 0x012c }
            return
        L_0x012c:
            r12.finish()
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AlipayResultActivity.onCreate(android.os.Bundle):void");
    }
}
