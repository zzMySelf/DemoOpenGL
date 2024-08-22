package fe.fe.th.ad;

public class ad extends Thread {

    /* renamed from: ad  reason: collision with root package name */
    public final CharSequence f3080ad;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f3081th = null;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ qw f3082yj;

    public ad(qw qwVar, CharSequence charSequence, byte[] bArr) {
        this.f3082yj = qwVar;
        this.f3080ad = charSequence;
        this.f3081th = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00de, all -> 0x00d9 }
            java.lang.CharSequence r2 = r10.f3080ad     // Catch:{ Exception -> 0x00de, all -> 0x00d9 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00de, all -> 0x00d9 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00de, all -> 0x00d9 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00de, all -> 0x00d9 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00de, all -> 0x00d9 }
            r0 = 5000(0x1388, float:7.006E-42)
            r1.setConnectTimeout(r0)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = "POST"
            r1.setRequestMethod(r0)     // Catch:{ Exception -> 0x00d7 }
            r0 = 1
            r1.setDoInput(r0)     // Catch:{ Exception -> 0x00d7 }
            r1.setDoOutput(r0)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r1.setRequestProperty(r0, r2)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = "Content-Length"
            byte[] r2 = r10.f3081th     // Catch:{ Exception -> 0x00d7 }
            int r2 = r2.length     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00d7 }
            r1.setRequestProperty(r0, r2)     // Catch:{ Exception -> 0x00d7 }
            java.io.OutputStream r0 = r1.getOutputStream()     // Catch:{ Exception -> 0x00d7 }
            byte[] r2 = r10.f3081th     // Catch:{ Exception -> 0x00d7 }
            byte[] r3 = r10.f3081th     // Catch:{ Exception -> 0x00d7 }
            int r3 = r3.length     // Catch:{ Exception -> 0x00d7 }
            r4 = 0
            r0.write(r2, r4, r3)     // Catch:{ Exception -> 0x00d7 }
            r0.close()     // Catch:{ Exception -> 0x00d7 }
            int r0 = r1.getResponseCode()     // Catch:{ Exception -> 0x00d7 }
            r2 = 200(0xc8, float:2.8E-43)
            java.lang.String r3 = "LogRequest"
            if (r0 != r2) goto L_0x00b5
            java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x00d7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
            r2.<init>()     // Catch:{ Exception -> 0x00d7 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x00d7 }
        L_0x005d:
            int r6 = r0.read(r5)     // Catch:{ Exception -> 0x00d7 }
            r7 = -1
            if (r6 == r7) goto L_0x006f
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r8 = "utf-8"
            r7.<init>(r5, r4, r6, r8)     // Catch:{ Exception -> 0x00d7 }
            r2.append(r7)     // Catch:{ Exception -> 0x00d7 }
            goto L_0x005d
        L_0x006f:
            r0.close()     // Catch:{ Exception -> 0x00d7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
            r0.<init>()     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r4 = "**********strResult:"
            r0.append(r4)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x00d7 }
            r0.append(r4)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d7 }
            fe.fe.aaa.qw.ad(r3, r0)     // Catch:{ Exception -> 0x00d7 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00d7 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = "retcode"
            java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x00d7 }
            if (r0 == 0) goto L_0x00ab
            fe.fe.th.ad.qw r0 = r10.f3082yj     // Catch:{ Exception -> 0x00d7 }
            fe.fe.th.i.i r0 = r0.f3090ad     // Catch:{ Exception -> 0x00d7 }
            r0.vvv()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00d4
        L_0x00ab:
            fe.fe.th.ad.qw r0 = r10.f3082yj     // Catch:{ Exception -> 0x00d7 }
            fe.fe.th.i.i r0 = r0.f3090ad     // Catch:{ Exception -> 0x00d7 }
        L_0x00b1:
            r0.aaa()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00d4
        L_0x00b5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
            r0.<init>()     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = "request failed  "
            r0.append(r2)     // Catch:{ Exception -> 0x00d7 }
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00d7 }
            r0.append(r2)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d7 }
            fe.fe.aaa.qw.ad(r3, r0)     // Catch:{ Exception -> 0x00d7 }
            fe.fe.th.ad.qw r0 = r10.f3082yj     // Catch:{ Exception -> 0x00d7 }
            fe.fe.th.i.i r0 = r0.f3090ad     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00b1
        L_0x00d4:
            if (r1 == 0) goto L_0x00ea
            goto L_0x00e7
        L_0x00d7:
            r0 = move-exception
            goto L_0x00e2
        L_0x00d9:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x00ec
        L_0x00de:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L_0x00e2:
            r0.printStackTrace()     // Catch:{ all -> 0x00eb }
            if (r1 == 0) goto L_0x00ea
        L_0x00e7:
            r1.disconnect()
        L_0x00ea:
            return
        L_0x00eb:
            r0 = move-exception
        L_0x00ec:
            if (r1 == 0) goto L_0x00f1
            r1.disconnect()
        L_0x00f1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.ad.ad.run():void");
    }
}
