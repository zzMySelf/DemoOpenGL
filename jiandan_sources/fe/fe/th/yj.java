package fe.fe.th;

public class yj extends Thread {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ qw f3155ad;

    public yj(qw qwVar) {
        this.f3155ad = qwVar;
        setName("SDK_ClientUpdater_thread");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0094, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ad, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5.f3155ad.th(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b9, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:25:0x0097, B:31:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            fe.fe.th.qw r0 = r5.f3155ad
            fe.fe.th.th.qw r0 = r0.f3125i
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            fe.fe.th.qw r0 = r5.f3155ad
            boolean r0 = r0.f3124fe
            r1 = 0
            if (r0 != 0) goto L_0x0025
            fe.fe.th.qw r0 = r5.f3155ad
            boolean r0 = r0.f3129uk
            if (r0 == 0) goto L_0x001b
            goto L_0x0025
        L_0x001b:
            fe.fe.th.qw r0 = r5.f3155ad
            fe.fe.th.th.qw r0 = r0.f3125i
            r0.uk(r1)
            goto L_0x002f
        L_0x0025:
            fe.fe.th.qw r0 = r5.f3155ad
            fe.fe.th.th.qw r0 = r0.f3125i
            r2 = 1
            r0.uk(r2)
        L_0x002f:
            fe.fe.th.qw r0 = r5.f3155ad
            boolean unused = r0.f3129uk = r1
            fe.fe.th.qw r0 = r5.f3155ad
            fe.fe.th.th.qw r1 = r0.f3125i
            java.lang.String r2 = "/lcmanage/index.php?r=InterfaceAction&method=upgrade&contype=client&clientv=3.0"
            java.lang.String r1 = r1.yj(r2)
            java.lang.String unused = r0.f3123de = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "更新检查请求的完整参数： "
            r0.append(r1)
            fe.fe.th.qw r1 = r5.f3155ad
            java.lang.String r1 = r1.f3123de
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ClientUpdater"
            fe.fe.aaa.qw.ad(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ SSLHandshakeException -> 0x00a2, Exception -> 0x0096 }
            fe.fe.th.qw r4 = r5.f3155ad     // Catch:{ SSLHandshakeException -> 0x00a2, Exception -> 0x0096 }
            java.lang.String r4 = r4.f3123de     // Catch:{ SSLHandshakeException -> 0x00a2, Exception -> 0x0096 }
            r3.<init>(r4)     // Catch:{ SSLHandshakeException -> 0x00a2, Exception -> 0x0096 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ SSLHandshakeException -> 0x00a2, Exception -> 0x0096 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ SSLHandshakeException -> 0x00a2, Exception -> 0x0096 }
            r4 = 5000(0x1388, float:7.006E-42)
            r3.setConnectTimeout(r4)     // Catch:{ SSLHandshakeException -> 0x0092, Exception -> 0x008f, all -> 0x008c }
            r3.setReadTimeout(r4)     // Catch:{ SSLHandshakeException -> 0x0092, Exception -> 0x008f, all -> 0x008c }
            r3.connect()     // Catch:{ SSLHandshakeException -> 0x0092, Exception -> 0x008f, all -> 0x008c }
            fe.fe.th.qw r4 = r5.f3155ad     // Catch:{ SSLHandshakeException -> 0x0092, Exception -> 0x008f, all -> 0x008c }
            r4.yj(r3, r2, r0)     // Catch:{ SSLHandshakeException -> 0x0092, Exception -> 0x008f, all -> 0x008c }
            if (r3 == 0) goto L_0x00b6
            r3.disconnect()
            goto L_0x00b6
        L_0x008c:
            r0 = move-exception
            r2 = r3
            goto L_0x00b7
        L_0x008f:
            r0 = move-exception
            r2 = r3
            goto L_0x0097
        L_0x0092:
            r2 = r3
            goto L_0x00a2
        L_0x0094:
            r0 = move-exception
            goto L_0x00b7
        L_0x0096:
            r0 = move-exception
        L_0x0097:
            fe.fe.th.qw r1 = r5.f3155ad     // Catch:{ all -> 0x0094 }
            r1.th(r0)     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x00b6
        L_0x009e:
            r2.disconnect()
            goto L_0x00b6
        L_0x00a2:
            java.lang.String r0 = "SSLHandshakeException caught!!!! "
            fe.fe.aaa.qw.ad(r1, r0)     // Catch:{ Exception -> 0x00ad }
            fe.fe.th.qw r0 = r5.f3155ad     // Catch:{ Exception -> 0x00ad }
            r0.m219switch()     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b3
        L_0x00ad:
            r0 = move-exception
            fe.fe.th.qw r1 = r5.f3155ad     // Catch:{ all -> 0x0094 }
            r1.th(r0)     // Catch:{ all -> 0x0094 }
        L_0x00b3:
            if (r2 == 0) goto L_0x00b6
            goto L_0x009e
        L_0x00b6:
            return
        L_0x00b7:
            if (r2 == 0) goto L_0x00bc
            r2.disconnect()
        L_0x00bc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.yj.run():void");
    }
}
