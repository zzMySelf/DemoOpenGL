package fe.fe.th.i;

public class de extends Thread {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f3093ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f3094th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ uk f3095yj;

    public de(uk ukVar, String str, String str2) {
        this.f3095yj = ukVar;
        this.f3093ad = str;
        this.f3094th = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "DownloadManager"
            super.run()
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00fa }
            java.lang.String r3 = r9.f3093ad     // Catch:{ Exception -> 0x00fa }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00fa }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00fa }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00fa }
            r1 = 5000(0x1388, float:7.006E-42)
            r2.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r2.setReadTimeout(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r2.connect()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            int r1 = r2.getResponseCode()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 != r3) goto L_0x00ec
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r3.<init>()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
        L_0x0033:
            int r5 = r1.read(r4)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r6 = -1
            if (r5 == r6) goto L_0x0046
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r7 = 0
            java.lang.String r8 = "utf-8"
            r6.<init>(r4, r7, r5, r8)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r3.append(r6)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            goto L_0x0033
        L_0x0046:
            r1.close()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r1.<init>()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r4 = "获取公钥的返回结果: "
            r1.append(r4)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r4 = r3.toString()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r1.append(r4)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.aaa.qw.qw(r0, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            if (r1 == 0) goto L_0x00e7
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r4 = ""
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.security.interfaces.RSAPublicKey r1 = fe.fe.th.fe.ad.qw(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.th.i.uk r3 = r9.f3095yj     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            android.content.Context r3 = r3.f3109ad     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.th.uk.qw r3 = fe.fe.th.uk.qw.ad(r3)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            com.baidu.clientupdate.appinfo.ClientUpdateInfo r3 = r3.qw()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r3 = r3.mSign     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            byte[] r3 = fe.fe.th.fe.qw.de(r3)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            byte[] r1 = fe.fe.th.fe.ad.ad(r1, r3)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r1.<init>()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r4 = "公钥解密："
            r1.append(r4)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r1.append(r3)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.aaa.qw.ad(r0, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r1.<init>()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r4 = "apk的md5值："
            r1.append(r4)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r4 = r9.f3094th     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            r1.append(r4)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.aaa.qw.ad(r0, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r1 = r9.f3094th     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            boolean r1 = r3.equals(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            if (r1 == 0) goto L_0x00df
            java.lang.String r1 = "第二次RSA验证通过"
            fe.fe.aaa.qw.ad(r0, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.th.i.uk r0 = r9.f3095yj     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            android.content.Context r0 = r0.f3109ad     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.th.i.uk r1 = r9.f3095yj     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.io.File r1 = r1.f94if     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            fe.fe.th.uk.o.fe(r0, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            goto L_0x00ec
        L_0x00df:
            fe.fe.th.i.uk r0 = r9.f3095yj     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r1 = "RSAstr!=apkMd5"
        L_0x00e3:
            r0.a(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            goto L_0x00ec
        L_0x00e7:
            fe.fe.th.i.uk r0 = r9.f3095yj     // Catch:{ Exception -> 0x00f5, all -> 0x00f2 }
            java.lang.String r1 = "sign==null||result==null"
            goto L_0x00e3
        L_0x00ec:
            if (r2 == 0) goto L_0x010c
            r2.disconnect()
            goto L_0x010c
        L_0x00f2:
            r0 = move-exception
            r1 = r2
            goto L_0x010d
        L_0x00f5:
            r0 = move-exception
            r1 = r2
            goto L_0x00fb
        L_0x00f8:
            r0 = move-exception
            goto L_0x010d
        L_0x00fa:
            r0 = move-exception
        L_0x00fb:
            r0.printStackTrace()     // Catch:{ all -> 0x00f8 }
            fe.fe.th.i.uk r2 = r9.f3095yj     // Catch:{ all -> 0x00f8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f8 }
            r2.a(r0)     // Catch:{ all -> 0x00f8 }
            if (r1 == 0) goto L_0x010c
            r1.disconnect()
        L_0x010c:
            return
        L_0x010d:
            if (r1 == 0) goto L_0x0112
            r1.disconnect()
        L_0x0112:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.i.de.run():void");
    }
}
