package com.alipay.sdk.m.c0;

import com.alipay.sdk.m.g0.a;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.File;
import org.json.JSONObject;

public final class b {
    public File a = null;
    public a b = null;

    public b(String str, a aVar) {
        this.a = new File(str);
        this.b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put(SapiUtils.KEY_QR_LOGIN_ERROR, str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.io.File r0 = r7.a     // Catch:{ all -> 0x00bc }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            boolean r0 = r0.exists()     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x00ba
            java.io.File r0 = r7.a     // Catch:{ all -> 0x00bc }
            boolean r0 = r0.isDirectory()     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x00ba
            java.io.File r0 = r7.a     // Catch:{ all -> 0x00bc }
            java.lang.String[] r0 = r0.list()     // Catch:{ all -> 0x00bc }
            int r0 = r0.length     // Catch:{ all -> 0x00bc }
            if (r0 != 0) goto L_0x0020
            goto L_0x00ba
        L_0x0020:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00bc }
            r0.<init>()     // Catch:{ all -> 0x00bc }
            java.io.File r1 = r7.a     // Catch:{ all -> 0x00bc }
            java.lang.String[] r1 = r1.list()     // Catch:{ all -> 0x00bc }
            int r2 = r1.length     // Catch:{ all -> 0x00bc }
            r3 = 0
            r4 = 0
        L_0x002e:
            if (r4 >= r2) goto L_0x0038
            r5 = r1[r4]     // Catch:{ all -> 0x00bc }
            r0.add(r5)     // Catch:{ all -> 0x00bc }
            int r4 = r4 + 1
            goto L_0x002e
        L_0x0038:
            java.util.Collections.sort(r0)     // Catch:{ all -> 0x00bc }
            int r1 = r0.size()     // Catch:{ all -> 0x00bc }
            int r1 = r1 + -1
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00bc }
            int r2 = r0.size()     // Catch:{ all -> 0x00bc }
            java.util.Calendar r4 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x00bc }
            java.util.Date r4 = r4.getTime()     // Catch:{ all -> 0x00bc }
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = "yyyyMMdd"
            r5.<init>(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r5.format(r4)     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r5.<init>()     // Catch:{ all -> 0x00bc }
            r5.append(r4)     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = ".log"
            r5.append(r4)     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00bc }
            boolean r4 = r1.equals(r4)     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x008b
            int r1 = r0.size()     // Catch:{ all -> 0x00bc }
            r4 = 2
            if (r1 >= r4) goto L_0x007e
            monitor-exit(r7)
            return
        L_0x007e:
            int r1 = r0.size()     // Catch:{ all -> 0x00bc }
            int r1 = r1 - r4
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00bc }
            int r2 = r2 + -1
        L_0x008b:
            java.io.File r4 = r7.a     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = com.alipay.sdk.m.z.b.a(r4, r1)     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ all -> 0x00bc }
            com.alipay.sdk.m.g0.a r4 = r7.b     // Catch:{ all -> 0x00bc }
            boolean r1 = r4.logCollect(r1)     // Catch:{ all -> 0x00bc }
            if (r1 != 0) goto L_0x00a3
            int r2 = r2 + -1
        L_0x00a3:
            if (r3 >= r2) goto L_0x00b8
            java.lang.Object r1 = r0.get(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00bc }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00bc }
            java.io.File r5 = r7.a     // Catch:{ all -> 0x00bc }
            r4.<init>(r5, r1)     // Catch:{ all -> 0x00bc }
            r4.delete()     // Catch:{ all -> 0x00bc }
            int r3 = r3 + 1
            goto L_0x00a3
        L_0x00b8:
            monitor-exit(r7)
            return
        L_0x00ba:
            monitor-exit(r7)
            return
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.c0.b.b():void");
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
