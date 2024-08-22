package fe.fe.th;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import fe.fe.th.ad.de;
import fe.fe.th.i.uk;
import fe.fe.th.uk.o;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import org.json.JSONException;
import org.json.JSONObject;

public final class qw {

    /* renamed from: if  reason: not valid java name */
    public static Runnable f96if;

    /* renamed from: pf  reason: collision with root package name */
    public static qw f3121pf;

    /* renamed from: switch  reason: not valid java name */
    public static long f97switch;

    /* renamed from: ad  reason: collision with root package name */
    public Handler f3122ad;

    /* renamed from: de  reason: collision with root package name */
    public String f3123de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f3124fe = false;

    /* renamed from: i  reason: collision with root package name */
    public fe.fe.th.th.qw f3125i;

    /* renamed from: o  reason: collision with root package name */
    public de f3126o;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public IClientUpdaterCallback f3127rg;

    /* renamed from: th  reason: collision with root package name */
    public IClientUpdaterCallback f3128th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f3129uk = false;

    /* renamed from: yj  reason: collision with root package name */
    public double f3130yj;

    public qw(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.qw = applicationContext;
        this.f3126o = de.ad(applicationContext);
        if (this.f3122ad == null) {
            this.f3122ad = new Handler(this.qw.getMainLooper());
        }
        if (f96if == null) {
            f96if = new de(this);
        }
        new rg(this);
        new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        this.f3125i = fe.fe.th.th.qw.qw(context);
    }

    public static synchronized qw ddd(Context context) {
        qw qwVar;
        synchronized (qw.class) {
            if (f3121pf == null) {
                f3121pf = new qw(context);
            }
            qwVar = f3121pf;
        }
        return qwVar;
    }

    public void a(ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        try {
            fe.fe.th.uk.qw.ad(this.qw).fe(clientUpdateInfo, str, z);
        } catch (Exception e) {
            fe.fe.aaa.qw.ad("ClientUpdater", e.getMessage());
        }
    }

    public void aaa(String str) {
        this.f3125i.ddd(str);
    }

    public final void ad() {
        if (this.f3122ad != null) {
            if (o.pf(this.qw)) {
                fe.fe.aaa.qw.qw("ClientUpdater", "应用位于前台，不发起自动检查更新请求;");
            } else if (o.th(this.qw)) {
                this.f3122ad.removeCallbacks(f96if);
                fe.fe.aaa.qw.qw("ClientUpdater", "延迟20秒，因为有时CONNECTIVITY_CHANGE Action会很频繁");
                this.f3122ad.postDelayed(f96if, 20000);
            }
        }
    }

    public void b(JSONObject jSONObject) {
        IClientUpdaterCallback iClientUpdaterCallback;
        try {
            if (this.f3124fe) {
                iClientUpdaterCallback = this.f3127rg;
            } else if (this.f3128th != null) {
                iClientUpdaterCallback = this.f3128th;
            } else {
                return;
            }
            iClientUpdaterCallback.de(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eee(String str) {
        this.f3125i.vvv(str);
    }

    public void i(String str, String str2) {
        this.f3125i.de(str, str2);
    }

    public void mmm(String str) {
        o.rg(str);
    }

    public void nn(boolean z) {
        uk.xxx(this.qw).b(z);
    }

    public final void o() {
        this.f3124fe = true;
        long currentTimeMillis = System.currentTimeMillis();
        fe.fe.aaa.qw.qw("ClientUpdater", "接收到网络状态的变化，检测上次更新时间");
        fe.fe.aaa.qw.qw("ClientUpdater", "设置的检查更新的间隔时间： " + ((long) (this.f3130yj * 3600000.0d)) + "ms");
        StringBuilder sb = new StringBuilder();
        sb.append("当前时间：");
        sb.append(currentTimeMillis);
        fe.fe.aaa.qw.qw("ClientUpdater", sb.toString());
        fe.fe.aaa.qw.qw("ClientUpdater", "上次检查更新时间： " + o.i(this.qw));
        if (currentTimeMillis - o.i(this.qw) > ((long) (this.f3130yj * 3600000.0d))) {
            fe.fe.aaa.qw.qw("ClientUpdater", "大于设置的时间间隔，当前存在网络连接时进行更新检查 ");
            if (!o.th(this.qw)) {
                StringBuilder sb2 = new StringBuilder("当前网络不可用!");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msgId", "2");
                    jSONObject.put("messageDetail", sb2.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.f3127rg.de(jSONObject);
                fe.fe.aaa.qw.qw("ClientUpdater", "当前网络不可用! ");
                return;
            }
            new yj(this).start();
            return;
        }
        fe.fe.aaa.qw.qw("ClientUpdater", "离上一次更新检查的时间小于设置的时间间隔，不检查更新 ");
    }

    public void qqq(String str) {
        this.f3125i.ppp(str);
    }

    public void rrr(boolean z) {
        fe.fe.th.th.qw.qw(this.qw).fe(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a0, code lost:
        if (r4 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a2, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c7, code lost:
        if (r4 == null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cc, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ce, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d0, code lost:
        r0 = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
        r0.load((java.io.InputStream) null, (char[]) null);
        r0.setCertificateEntry("ca1", r6);
        r0.setCertificateEntry("ca2", r7);
        r0.setCertificateEntry("ca3", r1);
        r1 = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
        r1.init(r0);
        r0 = javax.net.ssl.SSLContext.getInstance("TLS");
        r0.init((javax.net.ssl.KeyManager[]) null, r1.getTrustManagers(), (java.security.SecureRandom) null);
        r1 = new java.lang.StringBuilder();
        r2 = (javax.net.ssl.HttpsURLConnection) new java.net.URL(r10.f3123de).openConnection();
        r2.setSSLSocketFactory(r0.getSocketFactory());
        r2.setConnectTimeout(5000);
        r2.setReadTimeout(5000);
        r2.connect();
        yj(r2, (java.io.InputStream) null, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c4  */
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m219switch() {
        /*
            r10 = this;
            java.lang.String r0 = "ClientUpdater"
            java.lang.String r1 = "X.509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r1)
            android.content.Context r2 = r10.qw
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.AssetManager r2 = r2.getAssets()
            java.lang.String r3 = "LCUpdate/ca-globalsign-nv-sa.pem"
            java.io.InputStream r2 = r2.open(r3)
            android.content.Context r3 = r10.qw
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.AssetManager r3 = r3.getAssets()
            java.lang.String r4 = "LCUpdate/ca-verisign-class-3-public-primary-certification-authority-en.pem"
            java.io.InputStream r3 = r3.open(r4)
            android.content.Context r4 = r10.qw
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.AssetManager r4 = r4.getAssets()
            java.lang.String r5 = "LCUpdate/ca-verisign-class-3-public-primary-certification-authority-g5-en.pem"
            java.io.InputStream r4 = r4.open(r5)
            r5 = 0
            java.security.cert.Certificate r6 = r1.generateCertificate(r2)     // Catch:{ Exception -> 0x00b2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab }
            r7.<init>()     // Catch:{ Exception -> 0x00ab }
            java.lang.String r8 = "ca1="
            r7.append(r8)     // Catch:{ Exception -> 0x00ab }
            r8 = r6
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ Exception -> 0x00ab }
            java.security.Principal r8 = r8.getSubjectDN()     // Catch:{ Exception -> 0x00ab }
            r7.append(r8)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00ab }
            fe.fe.aaa.qw.qw(r0, r7)     // Catch:{ Exception -> 0x00ab }
            java.security.cert.Certificate r7 = r1.generateCertificate(r3)     // Catch:{ Exception -> 0x00ab }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8 }
            r8.<init>()     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r9 = "ca2="
            r8.append(r9)     // Catch:{ Exception -> 0x00a8 }
            r9 = r7
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ Exception -> 0x00a8 }
            java.security.Principal r9 = r9.getSubjectDN()     // Catch:{ Exception -> 0x00a8 }
            r8.append(r9)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00a8 }
            fe.fe.aaa.qw.qw(r0, r8)     // Catch:{ Exception -> 0x00a8 }
            java.security.cert.Certificate r1 = r1.generateCertificate(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6 }
            r8.<init>()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r9 = "ca3="
            r8.append(r9)     // Catch:{ Exception -> 0x00a6 }
            r9 = r1
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ Exception -> 0x00a6 }
            java.security.Principal r9 = r9.getSubjectDN()     // Catch:{ Exception -> 0x00a6 }
            r8.append(r9)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00a6 }
            fe.fe.aaa.qw.qw(r0, r8)     // Catch:{ Exception -> 0x00a6 }
            if (r2 == 0) goto L_0x009b
            r2.close()
        L_0x009b:
            if (r3 == 0) goto L_0x00a0
            r3.close()
        L_0x00a0:
            if (r4 == 0) goto L_0x00ca
        L_0x00a2:
            r4.close()
            goto L_0x00ca
        L_0x00a6:
            r8 = move-exception
            goto L_0x00b6
        L_0x00a8:
            r8 = move-exception
            r1 = r5
            goto L_0x00b6
        L_0x00ab:
            r8 = move-exception
            r1 = r5
            r7 = r1
            goto L_0x00b6
        L_0x00af:
            r0 = move-exception
            goto L_0x012a
        L_0x00b2:
            r8 = move-exception
            r1 = r5
            r6 = r1
            r7 = r6
        L_0x00b6:
            java.lang.String r8 = android.util.Log.getStackTraceString(r8)     // Catch:{ all -> 0x00af }
            fe.fe.aaa.qw.ad(r0, r8)     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x00c2
            r2.close()
        L_0x00c2:
            if (r3 == 0) goto L_0x00c7
            r3.close()
        L_0x00c7:
            if (r4 == 0) goto L_0x00ca
            goto L_0x00a2
        L_0x00ca:
            if (r6 == 0) goto L_0x0129
            if (r7 == 0) goto L_0x0129
            if (r1 == 0) goto L_0x0129
            java.lang.String r0 = java.security.KeyStore.getDefaultType()
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)
            r0.load(r5, r5)
            java.lang.String r2 = "ca1"
            r0.setCertificateEntry(r2, r6)
            java.lang.String r2 = "ca2"
            r0.setCertificateEntry(r2, r7)
            java.lang.String r2 = "ca3"
            r0.setCertificateEntry(r2, r1)
            java.lang.String r1 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()
            javax.net.ssl.TrustManagerFactory r1 = javax.net.ssl.TrustManagerFactory.getInstance(r1)
            r1.init(r0)
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)
            javax.net.ssl.TrustManager[] r1 = r1.getTrustManagers()
            r0.init(r5, r1, r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.net.URL r2 = new java.net.URL
            java.lang.String r3 = r10.f3123de
            r2.<init>(r3)
            java.net.URLConnection r2 = r2.openConnection()
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()
            r2.setSSLSocketFactory(r0)
            r0 = 5000(0x1388, float:7.006E-42)
            r2.setConnectTimeout(r0)
            r2.setReadTimeout(r0)
            r2.connect()
            r10.yj(r2, r5, r1)
        L_0x0129:
            return
        L_0x012a:
            if (r2 == 0) goto L_0x012f
            r2.close()
        L_0x012f:
            if (r3 == 0) goto L_0x0134
            r3.close()
        L_0x0134:
            if (r4 == 0) goto L_0x0139
            r4.close()
        L_0x0139:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.qw.m219switch():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r4 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void th(java.lang.Exception r4) {
        /*
            r3 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "msgId"
            java.lang.String r2 = "4"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0016 }
            java.lang.String r1 = "messageDetail"
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x0016 }
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r4 = move-exception
            r4.printStackTrace()
        L_0x001a:
            boolean r4 = r3.f3124fe
            if (r4 == 0) goto L_0x0024
            com.baidu.clientupdate.IClientUpdaterCallback r4 = r3.f3127rg
        L_0x0020:
            r4.qw(r0)
            goto L_0x0029
        L_0x0024:
            com.baidu.clientupdate.IClientUpdaterCallback r4 = r3.f3128th
            if (r4 == 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            android.content.Context r4 = r3.qw
            fe.fe.th.uk.qw r4 = fe.fe.th.uk.qw.ad(r4)
            r4.yj()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.qw.th(java.lang.Exception):void");
    }

    public void tt(boolean z) {
        uk.xxx(this.qw).c(z);
    }

    public void when(IClientUpdaterCallback iClientUpdaterCallback) {
        f97switch = System.currentTimeMillis();
        if (iClientUpdaterCallback != null) {
            try {
                this.f3128th = iClientUpdaterCallback;
                if (!o.uk(this.qw)) {
                    StringBuilder sb = new StringBuilder("请加入权限：ACCESS_NETWORK_STATE、INTERNET");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("msgId", "1");
                    jSONObject.put("messageDetail", sb.toString());
                    if (this.f3128th != null) {
                        this.f3128th.de(jSONObject);
                    }
                } else if (!o.th(this.qw)) {
                    StringBuilder sb2 = new StringBuilder("当前网络不可用!");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("msgId", "2");
                    jSONObject2.put("messageDetail", sb2.toString());
                    if (this.f3128th != null) {
                        this.f3128th.de(jSONObject2);
                    }
                } else {
                    de deVar = this.f3126o;
                    String i2 = this.f3125i.i();
                    String rg2 = this.f3125i.rg();
                    deVar.th(i2, "0", rg2, "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "");
                    this.f3124fe = false;
                    new yj(this).start();
                }
            } catch (Exception e) {
                de deVar2 = this.f3126o;
                String i3 = this.f3125i.i();
                String rg3 = this.f3125i.rg();
                deVar2.th(i3, "0", rg3, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", e.toString());
            }
        } else {
            de deVar3 = this.f3126o;
            String i4 = this.f3125i.i();
            String rg4 = this.f3125i.rg();
            deVar3.th(i4, "0", rg4, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "clientUpdaterCallback=null");
            fe.fe.aaa.qw.ad("ClientUpdater", " clientUpdaterCallback为null或者JSONObject为null");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01ab, code lost:
        if (r0 != null) goto L_0x01a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void yj(java.net.HttpURLConnection r19, java.io.InputStream r20, java.lang.StringBuilder r21) {
        /*
            r18 = this;
            r1 = r18
            android.content.Context r0 = r1.qw
            fe.fe.th.uk.o.m223switch(r0)
            int r0 = r19.getResponseCode()
            java.lang.String r2 = "ClientUpdater"
            java.lang.String r3 = ""
            r4 = 1000(0x3e8, double:4.94E-321)
            r6 = 200(0xc8, float:2.8E-43)
            if (r0 != r6) goto L_0x0139
            fe.fe.th.ad.de r7 = r1.f3126o
            fe.fe.th.th.qw r0 = r1.f3125i
            java.lang.String r8 = r0.i()
            fe.fe.th.th.qw r0 = r1.f3125i
            java.lang.String r10 = r0.rg()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = r11 / r4
            r0.append(r11)
            r0.append(r3)
            java.lang.String r13 = r0.toString()
            java.lang.String r9 = "0"
            java.lang.String r11 = "a3"
            java.lang.String r12 = "0"
            java.lang.String r14 = ""
            java.lang.String r15 = "sendUpdateRequest"
            java.lang.String r16 = ""
            r7.th(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.io.InputStream r0 = r19.getInputStream()
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]
        L_0x004e:
            int r7 = r0.read(r6)
            r8 = -1
            if (r7 == r8) goto L_0x0063
            java.lang.String r8 = new java.lang.String
            r9 = 0
            java.lang.String r10 = "utf-8"
            r8.<init>(r6, r9, r7, r10)
            r7 = r21
            r7.append(r8)
            goto L_0x004e
        L_0x0063:
            r7 = r21
            r0.close()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "更新请求后的返回结果: "
            r0.append(r6)
            java.lang.String r6 = r21.toString()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            fe.fe.aaa.qw.qw(r2, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r2 = r21.toString()
            r0.<init>(r2)
            java.lang.String r2 = "status"
            java.lang.String r2 = r0.optString(r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x00d2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            int r6 = r6.intValue()
            r7 = 1
            if (r6 != r7) goto L_0x00d2
            fe.fe.th.ad.de r8 = r1.f3126o
            fe.fe.th.th.qw r2 = r1.f3125i
            java.lang.String r9 = r2.i()
            fe.fe.th.th.qw r2 = r1.f3125i
            java.lang.String r11 = r2.rg()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 / r4
            r2.append(r6)
            r2.append(r3)
            java.lang.String r14 = r2.toString()
            java.lang.String r10 = "0"
            java.lang.String r12 = "a4"
            java.lang.String r13 = "0"
            java.lang.String r15 = ""
            java.lang.String r16 = "haveUpdate"
            java.lang.String r17 = ""
            r8.th(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0113
        L_0x00d2:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0113
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r2 = r2.intValue()
            if (r2 != 0) goto L_0x0113
            fe.fe.th.ad.de r6 = r1.f3126o
            fe.fe.th.th.qw r2 = r1.f3125i
            java.lang.String r7 = r2.i()
            fe.fe.th.th.qw r2 = r1.f3125i
            java.lang.String r9 = r2.rg()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            long r10 = java.lang.System.currentTimeMillis()
            long r10 = r10 / r4
            r2.append(r10)
            r2.append(r3)
            java.lang.String r12 = r2.toString()
            java.lang.String r8 = "0"
            java.lang.String r10 = "a4"
            java.lang.String r11 = "0"
            java.lang.String r13 = ""
            java.lang.String r14 = "notUpdate"
            java.lang.String r15 = ""
            r6.th(r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x0113:
            boolean r2 = r1.f3124fe
            if (r2 == 0) goto L_0x0129
            com.baidu.clientupdate.IClientUpdaterCallback r2 = r1.f3127rg
            r2.ad(r0)
            android.content.Context r2 = r1.qw
            fe.fe.th.uk.qw r2 = fe.fe.th.uk.qw.ad(r2)
            com.baidu.clientupdate.IClientUpdaterCallback r3 = r1.f3127rg
        L_0x0124:
            r2.rg(r0, r3)
            goto L_0x01b7
        L_0x0129:
            com.baidu.clientupdate.IClientUpdaterCallback r2 = r1.f3128th
            if (r2 == 0) goto L_0x01b7
            r2.ad(r0)
            android.content.Context r2 = r1.qw
            fe.fe.th.uk.qw r2 = fe.fe.th.uk.qw.ad(r2)
            com.baidu.clientupdate.IClientUpdaterCallback r3 = r1.f3128th
            goto L_0x0124
        L_0x0139:
            java.lang.String r0 = r19.getResponseMessage()
            fe.fe.th.ad.de r6 = r1.f3126o
            fe.fe.th.th.qw r7 = r1.f3125i
            java.lang.String r7 = r7.i()
            fe.fe.th.th.qw r8 = r1.f3125i
            java.lang.String r8 = r8.rg()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            long r10 = java.lang.System.currentTimeMillis()
            long r10 = r10 / r4
            r9.append(r10)
            r9.append(r3)
            java.lang.String r10 = r9.toString()
            java.lang.String r3 = "0"
            java.lang.String r9 = "a3"
            java.lang.String r11 = "1"
            java.lang.String r12 = ""
            java.lang.String r13 = "sendUpdateRequest"
            r4 = r6
            r5 = r7
            r6 = r3
            r7 = r8
            r8 = r9
            r9 = r11
            r11 = r12
            r12 = r13
            r13 = r0
            r4.th(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "更新请求失败：  "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            fe.fe.aaa.qw.qw(r2, r3)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "msgId"
            java.lang.String r4 = "3"
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x019b }
            java.lang.String r3 = "messageDetail"
            r2.put(r3, r0)     // Catch:{ JSONException -> 0x019b }
            goto L_0x019f
        L_0x019b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x019f:
            boolean r0 = r1.f3124fe
            if (r0 == 0) goto L_0x01a9
            com.baidu.clientupdate.IClientUpdaterCallback r0 = r1.f3127rg
        L_0x01a5:
            r0.de(r2)
            goto L_0x01ae
        L_0x01a9:
            com.baidu.clientupdate.IClientUpdaterCallback r0 = r1.f3128th
            if (r0 == 0) goto L_0x01ae
            goto L_0x01a5
        L_0x01ae:
            android.content.Context r0 = r1.qw
            fe.fe.th.uk.qw r0 = fe.fe.th.uk.qw.ad(r0)
            r0.yj()
        L_0x01b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.qw.yj(java.net.HttpURLConnection, java.io.InputStream, java.lang.StringBuilder):void");
    }
}
