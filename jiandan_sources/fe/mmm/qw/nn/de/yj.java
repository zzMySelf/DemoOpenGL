package fe.mmm.qw.nn.de;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.android.common.others.lang.StringUtil;
import com.tera.scan.network.network.NetworkDetailException;
import com.tera.scan.network.network.interceptor.IFallbackInterceptor;
import com.tera.scan.network.network.interceptor.IRequestInterceptor;
import com.tera.scan.network.network.interceptor.IStatisticsInterceptor;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.nn.de.o.ad;
import fe.mmm.qw.nn.de.o.de;
import fe.mmm.qw.yj.th;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public class yj<T> {

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f8119i = Pattern.compile("^[\\s\\S]*(api/mediainfo|api/streaming|mbox/msg/shareinfo|mbox/msg/streaming|share/streaming|share/list|api/batch/streaming)+[\\s\\S]*");

    /* renamed from: ad  reason: collision with root package name */
    public final IFallbackInterceptor f8120ad;

    /* renamed from: de  reason: collision with root package name */
    public IStatisticsInterceptor f8121de = null;

    /* renamed from: fe  reason: collision with root package name */
    public IRequestInterceptor f8122fe = null;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f8123rg = false;

    /* renamed from: th  reason: collision with root package name */
    public NetworkDetailException f8124th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f8125uk = false;

    /* renamed from: yj  reason: collision with root package name */
    public StringBuffer f8126yj = new StringBuffer();

    public class qw implements HostnameVerifier {
        public final /* synthetic */ HttpsURLConnection qw;

        public qw(yj yjVar, HttpsURLConnection httpsURLConnection) {
            this.qw = httpsURLConnection;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            String requestProperty = this.qw.getRequestProperty("Host");
            if (requestProperty == null) {
                requestProperty = this.qw.getURL().getHost();
            }
            fe.mmm.qw.i.qw.ad("NetworkTask", "校验证书 session : " + sSLSession + " host : " + requestProperty);
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
        }
    }

    public yj(int i2, IFallbackInterceptor iFallbackInterceptor) {
        this.qw = i2;
        this.f8120ad = iFallbackInterceptor;
    }

    public yj ad(IRequestInterceptor iRequestInterceptor) {
        this.f8122fe = iRequestInterceptor;
        return this;
    }

    public yj de(IStatisticsInterceptor iStatisticsInterceptor) {
        this.f8121de = iStatisticsInterceptor;
        return this;
    }

    public final void fe(String str) {
        if (this.f8125uk) {
            this.f8126yj.append(str + "  ");
        }
    }

    public final void ggg(Exception exc, int i2) {
        int i3;
        if (exc instanceof UnknownHostException) {
            i3 = -100006101;
        } else if (exc instanceof ConnectException) {
            i3 = -100006102;
        } else if (exc instanceof SocketException) {
            i3 = -100006103;
        } else if (exc instanceof SSLException) {
            i3 = -100006104;
        } else if (exc instanceof SecurityException) {
            i3 = -100006105;
        } else {
            i3 = exc instanceof NullPointerException ? -100006106 : -100006100;
        }
        this.f8124th = new NetworkDetailException(i3, exc.getMessage(), exc, i2);
    }

    public final void i(HttpURLConnection httpURLConnection) {
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null && headerFields.containsKey("Set-Cookie")) {
            for (String str : (List) headerFields.get("Set-Cookie")) {
                Matcher matcher = de.f8094ad.matcher(str);
                if (matcher.find() && matcher.groupCount() > 0) {
                    String group = matcher.group(1);
                    fe.mmm.qw.i.qw.m973switch("NetworkTask", "获得当前safe box setCookie " + group);
                    if (!TextUtils.isEmpty(group)) {
                        th.ppp().m1013switch("SBOXTKN_KEY", group);
                        th.ppp().qw();
                    }
                }
                Matcher matcher2 = de.qw.matcher(str);
                if (matcher2.find() && matcher2.groupCount() > 0) {
                    String group2 = matcher2.group(1);
                    fe.mmm.qw.i.qw.m973switch("NetworkTask", "获得当前PANPSC setCookie " + group2);
                    if (!TextUtils.isEmpty(group2)) {
                        th.ppp().m1013switch("PANPSC_KEY", group2);
                        th.ppp().qw();
                    }
                }
                Matcher matcher3 = de.f8095de.matcher(str);
                if (matcher3.find() && matcher3.groupCount() > 0) {
                    String group3 = matcher3.group(1);
                    fe.mmm.qw.i.qw.m973switch("NetworkTask", "获得当前card box setCookie " + group3);
                    if (!TextUtils.isEmpty(group3)) {
                        th.ppp().m1013switch("CACATATKN_KEY", group3);
                        th.ppp().qw();
                    }
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m991if(fe.mmm.qw.nn.qw.qw.yj yjVar) {
        IStatisticsInterceptor iStatisticsInterceptor = this.f8121de;
        if (iStatisticsInterceptor != null) {
            iStatisticsInterceptor.ad(yjVar);
        }
    }

    public final void o(String str, String str2) {
        if (this.f8123rg) {
            fe.mmm.qw.nn.ad.qw.qw.qw.v("2576", "network", "101000", str, str2);
        }
    }

    public final void pf(boolean z, boolean z2, String str) {
        IStatisticsInterceptor iStatisticsInterceptor = this.f8121de;
        if (iStatisticsInterceptor == null) {
            return;
        }
        if (z) {
            iStatisticsInterceptor.qw(z2, str);
        } else {
            iStatisticsInterceptor.de(str);
        }
    }

    public final void ppp(HttpURLConnection httpURLConnection, String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
            fe.mmm.qw.i.qw.ad("NetworkTask", "http params " + str);
        }
    }

    public final void qw(String str) {
    }

    public final HttpURLConnection rg(de deVar, String str, boolean z) throws IOException {
        HttpsURLConnection httpsURLConnection;
        URL url = new URL(deVar.i());
        if (!deVar.i().contains("https://") || !z) {
            httpsURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
            httpsURLConnection2.setInstanceFollowRedirects(false);
            httpsURLConnection2.setHostnameVerifier(new qw(this, httpsURLConnection2));
            httpsURLConnection = httpsURLConnection2;
        }
        httpsURLConnection.setRequestProperty("Host", str);
        httpsURLConnection.setRequestMethod(deVar.fe());
        httpsURLConnection.setConnectTimeout(this.qw);
        httpsURLConnection.setReadTimeout(this.qw);
        httpsURLConnection.addRequestProperty("Cookie", deVar.de());
        httpsURLConnection.addRequestProperty("User-Agent", RequestCommonParams.o());
        if (deVar.o()) {
            httpsURLConnection.addRequestProperty("Accept-Encoding", "gzip");
        }
        httpsURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        if (deVar.pf() && !TextUtils.isEmpty(deVar.th())) {
            httpsURLConnection.setDoOutput(true);
        }
        yj(httpsURLConnection, deVar);
        return httpsURLConnection;
    }

    /* renamed from: switch  reason: not valid java name */
    public final String m992switch(Object obj) {
        return obj == null ? StringUtil.NULL_STRING : obj.toString();
    }

    public final void th() {
        this.f8126yj = new StringBuffer();
    }

    public final void uk(String str, String str2) {
        if (this.f8125uk) {
            this.f8126yj.append(str2);
            vvv(str, this.f8126yj.toString());
            th();
        }
    }

    public final void vvv(String str, String str2) {
        if (this.f8125uk) {
            fe.mmm.qw.nn.ad.qw.qw.qw.v("2576", "network", "101000", str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0389, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x038a, code lost:
        r15 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x038c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x038d, code lost:
        r24 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0391, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0392, code lost:
        r24 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x039c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x039d, code lost:
        r24 = r14;
        r15 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x03a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x03a5, code lost:
        r24 = r14;
        r7 = r33;
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x03ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x03ae, code lost:
        r32 = r7;
        r22 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03b7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03b8, code lost:
        r15 = r37;
        r23 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03c0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03c1, code lost:
        r32 = r7;
        r4 = r14;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03d0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03d1, code lost:
        r15 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:?, code lost:
        o(r8, "http request Exception, exception : " + r0);
        fe("请求过程异常 Exception = " + r0);
        r4 = new java.lang.StringBuilder();
        r4.append(r0.getClass().getName());
        r7 = r33;
        r4.append(r7);
        r4.append(r0.getMessage());
        pf(r2, r5, r4.toString());
        r12.ad(r0.getClass().getName() + r7 + r0.getMessage());
        ggg(r0, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0442, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0443, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0444, code lost:
        r7 = r33;
        r15 = r37;
        r23 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x04be, code lost:
        o(r8, r13);
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04c9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x04ca, code lost:
        r32 = r7;
        r4 = r14;
        r10 = r15;
        r7 = r33;
        r24 = r6;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04d9, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0535, code lost:
        o(r8, r13);
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0561, code lost:
        if (r9 != null) goto L_0x0563;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0563, code lost:
        o(r8, r13);
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0569, code lost:
        qw(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x056c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0198, code lost:
        if (r3.endsWith("]") != false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02ba, code lost:
        r24 = r6;
        r32 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0389 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:105:0x02f7] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03b7 A[ExcHandler: SecurityException (e java.lang.SecurityException), Splitter:B:84:0x0280] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03d0 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:82:0x027e] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04be  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x057e A[SYNTHETIC, Splitter:B:181:0x057e] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x065d A[Catch:{ all -> 0x0683 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0682 A[Catch:{ all -> 0x0683 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0686  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x068f  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x06b2  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T when(java.lang.Object... r37) throws java.lang.UnsupportedOperationException, java.security.KeyManagementException, java.security.UnrecoverableKeyException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException, org.json.JSONException, com.tera.scan.network.network.exception.RemoteException {
        /*
            r36 = this;
            r1 = r36
            r0 = r37
            java.lang.String r2 = "http request result is null"
            java.lang.String r3 = "http request parse result : "
            java.lang.String r4 = "http request is not success, connection disconnect"
            java.lang.String r5 = ":"
            r6 = 0
            r7 = r0[r6]
            fe.mmm.qw.nn.de.o.de[] r7 = (fe.mmm.qw.nn.de.o.de[]) r7
            int r8 = r0.length
            r9 = 2
            java.lang.String r10 = ""
            if (r8 <= r9) goto L_0x0020
            r8 = r0[r9]
            if (r8 == 0) goto L_0x0020
            r8 = r0[r9]
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0021
        L_0x0020:
            r8 = r10
        L_0x0021:
            com.tera.scan.network.network.NetworkSpaceType r9 = com.tera.scan.network.network.NetworkSpaceType.DEFAULT
            int r11 = r0.length
            r12 = 3
            if (r11 <= r12) goto L_0x0032
            r11 = r0[r12]
            boolean r11 = r11 instanceof com.tera.scan.network.network.NetworkSpaceType
            if (r11 == 0) goto L_0x0032
            r9 = r0[r12]
            com.tera.scan.network.network.NetworkSpaceType r9 = (com.tera.scan.network.network.NetworkSpaceType) r9
            goto L_0x0040
        L_0x0032:
            fe.mmm.qw.nn.ad.qw.qw r11 = fe.mmm.qw.nn.ad.qw.qw.qw
            java.lang.Boolean r11 = r11.uk()
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0040
            com.tera.scan.network.network.NetworkSpaceType r9 = com.tera.scan.network.network.NetworkSpaceType.ENTERPRISE
        L_0x0040:
            java.lang.String r11 = "NetworkTask"
            r12 = 0
            if (r7 != 0) goto L_0x004b
            java.lang.String r0 = "request == null"
            fe.mmm.qw.i.qw.m973switch(r11, r0)
            return r12
        L_0x004b:
            int r13 = r0.length
            r14 = 1
            if (r13 <= r14) goto L_0x005b
            r13 = r0[r14]
            boolean r13 = r13 instanceof com.tera.scan.network.network.parser.IApiResultParseable
            if (r13 == 0) goto L_0x005b
            r0 = r0[r14]
            com.tera.scan.network.network.parser.IApiResultParseable r0 = (com.tera.scan.network.network.parser.IApiResultParseable) r0
            r13 = r0
            goto L_0x005c
        L_0x005b:
            r13 = r12
        L_0x005c:
            fe.mmm.qw.nn.ad.qw.qw r0 = fe.mmm.qw.nn.ad.qw.qw.qw
            boolean r0 = r0.pf()
            fe.mmm.qw.yj.rg r15 = fe.mmm.qw.yj.rg.ad()
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            java.lang.String r12 = "memory_config_key_network_enable"
            java.lang.Object r6 = r15.qw(r12, r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1.f8125uk = r6
            fe.mmm.qw.nn.qw.qw.yj r12 = new fe.mmm.qw.nn.qw.qw.yj
            r12.<init>()
            long r17 = android.os.SystemClock.elapsedRealtime()
            r15 = 4
            int r6 = r7.length
            int r6 = java.lang.Math.min(r15, r6)
            r19 = 0
            r23 = r19
            r37 = -1
            r14 = 0
            r15 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 0
        L_0x0095:
            if (r14 >= r6) goto L_0x056d
            r27 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r28 = r3
            java.lang.String r3 = "Step1 当前是第"
            r0.append(r3)
            r0.append(r14)
            java.lang.String r3 = "次请求"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1.fe(r0)
            int r0 = r6 + -1
            if (r14 != r0) goto L_0x00ba
            r3 = 1
            goto L_0x00bb
        L_0x00ba:
            r3 = 0
        L_0x00bb:
            r29 = r6
            if (r3 == 0) goto L_0x00c1
            r6 = 0
            goto L_0x00c3
        L_0x00c1:
            r6 = r27
        L_0x00c3:
            if (r3 == 0) goto L_0x00cb
            if (r15 != r0) goto L_0x00cb
            int r0 = r7.length
            r3 = 1
            int r0 = r0 - r3
            goto L_0x00cc
        L_0x00cb:
            r0 = r14
        L_0x00cc:
            if (r14 <= 0) goto L_0x00ee
            r3 = r7[r0]
            fe.mmm.qw.nn.de.o.ad r3 = r3.rg()
            if (r3 != 0) goto L_0x00db
            fe.mmm.qw.nn.de.o.ad r3 = new fe.mmm.qw.nn.de.o.ad
            r3.<init>()
        L_0x00db:
            r27 = r2
            java.lang.String r2 = java.lang.String.valueOf(r14)
            r30 = r13
            java.lang.String r13 = "wp_retry_num"
            r3.ad(r13, r2)
            java.lang.String r2 = "增加参数 wp_retry_num"
            r1.fe(r2)
            goto L_0x00f2
        L_0x00ee:
            r27 = r2
            r30 = r13
        L_0x00f2:
            com.tera.scan.network.network.interceptor.IRequestInterceptor r2 = r1.f8122fe
            if (r2 == 0) goto L_0x00fd
            r0 = r7[r0]
            fe.mmm.qw.nn.de.o.de r0 = r2.qw(r0)
            goto L_0x00ff
        L_0x00fd:
            r0 = r7[r0]
        L_0x00ff:
            if (r0 != 0) goto L_0x0103
            r2 = 0
            return r2
        L_0x0103:
            java.lang.String r26 = r0.yj()
            java.lang.String r2 = r0.i()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0120
            java.util.regex.Pattern r3 = f8119i
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.matches()
            if (r3 == 0) goto L_0x0120
            r3 = 1
            r1.f8123rg = r3
        L_0x0120:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r13 = "origin url: "
            r3.append(r13)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r1.o(r8, r3)
            java.lang.String r3 = r0.fe()
            r12.o(r3)
            java.net.URL r3 = new java.net.URL
            java.lang.String r13 = r0.i()
            r3.<init>(r13)
            java.lang.String r13 = r3.getHost()
            r12.fe(r13)
            java.lang.String r3 = r3.getPath()
            r12.m994if(r3)
            if (r6 == 0) goto L_0x01dd
            if (r0 != 0) goto L_0x0158
            r3 = 0
            return r3
        L_0x0158:
            r3 = 0
            fe.mmm.qw.nn.ad.qw.qw r16 = fe.mmm.qw.nn.ad.qw.qw.qw
            r16.m987if()
            long r23 = android.os.SystemClock.elapsedRealtime()
            java.net.URL r3 = new java.net.URL
            r3.<init>(r2)
            java.lang.String r3 = r3.getHost()
            if (r13 == 0) goto L_0x019b
            boolean r21 = r13.equals(r3)
            if (r21 != 0) goto L_0x019b
            r25 = r13
            r13 = 1
            r12.th(r13)
            r12.i(r3)
            long r31 = android.os.SystemClock.elapsedRealtime()
            r13 = r4
            r33 = r5
            long r4 = r31 - r23
            r12.yj(r4)
            if (r3 == 0) goto L_0x01a0
            java.lang.String r4 = "["
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L_0x01a0
            java.lang.String r4 = "]"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x01a0
            goto L_0x01a1
        L_0x019b:
            r33 = r5
            r25 = r13
            r13 = r4
        L_0x01a0:
            r3 = 0
        L_0x01a1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "更换后的 url 为："
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            fe.mmm.qw.i.qw.ad(r11, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "url after replaceHostToIP : "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r1.o(r8, r4)
            if (r0 == 0) goto L_0x01ce
            r0.vvv(r2)
        L_0x01ce:
            fe.mmm.qw.nn.ad.qw.qw r4 = fe.mmm.qw.nn.ad.qw.qw.qw
            java.lang.String r5 = "http_dns_request_send"
            r4.ppp(r5)
            java.lang.String r4 = "使用HttpDns"
            r1.fe(r4)
            r4 = r25
            goto L_0x01e3
        L_0x01dd:
            r13 = r4
            r33 = r5
            r4 = r21
            r3 = 0
        L_0x01e3:
            fe.mmm.qw.nn.ad.qw.qw r5 = fe.mmm.qw.nn.ad.qw.qw.qw
            r5.ddd(r9, r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r21 = r9
            java.lang.String r9 = "当前请求参数 : "
            r5.append(r9)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r1.fe(r5)
            if (r0 == 0) goto L_0x0230
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "send request -> "
            r5.append(r9)
            java.lang.String r9 = r0.toString()
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            r1.o(r8, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "send request > "
            r5.append(r9)
            java.lang.String r9 = r0.toString()
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            fe.mmm.qw.i.qw.ad(r11, r5)
        L_0x0230:
            r12.when(r14)
            r12.ad(r10)
            com.tera.scan.network.network.interceptor.IFallbackInterceptor r5 = r1.f8120ad
            boolean r5 = r5.qw(r2)
            r12.de(r5)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r31 = r10
            java.lang.String r10 = "isFallbackHttpsDisable : "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            r1.o(r8, r9)
            com.tera.scan.network.network.interceptor.IFallbackInterceptor r9 = r1.f8120ad
            boolean r2 = r9.fe(r2)
            java.lang.String r9 = "Step2 建立链接"
            r1.fe(r9)
            java.net.HttpURLConnection r9 = r1.rg(r0, r4, r6)
            java.lang.String r10 = "build url connection"
            r1.o(r8, r10)
            r12.uk(r2)
            int r10 = r7.length
            r23 = r4
            r4 = 1
            if (r10 <= r4) goto L_0x027e
            com.tera.scan.network.network.interceptor.IFallbackInterceptor r10 = r1.f8120ad
            r4 = r2 ^ 1
            r10.rg(r4)
            java.lang.String r4 = "try to increase counter"
            r1.o(r8, r4)
        L_0x027e:
            java.net.CookieManager r4 = new java.net.CookieManager     // Catch:{ IOException -> 0x04c9, SecurityException -> 0x0443, Exception -> 0x03d0 }
            r4.<init>()     // Catch:{ IOException -> 0x03c0, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            java.net.CookieManager.setDefault(r4)     // Catch:{ IOException -> 0x03c0, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            java.lang.String r4 = "before connect"
            r1.o(r8, r4)     // Catch:{ IOException -> 0x03c0, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            long r24 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x03c0, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r9.connect()     // Catch:{ IOException -> 0x03c0, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            long r34 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x03c0, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r4 = r14
            r10 = r15
            long r14 = r34 - r24
            r12.qw(r14)     // Catch:{ IOException -> 0x03b3, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            java.lang.String r14 = "after connect"
            r1.o(r8, r14)     // Catch:{ IOException -> 0x03b3, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            com.tera.scan.network.network.interceptor.IFallbackInterceptor r14 = r1.f8120ad     // Catch:{ IOException -> 0x03b3, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r14.de(r2, r5)     // Catch:{ IOException -> 0x03b3, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            java.lang.String r14 = "try to reset counter"
            r1.o(r8, r14)     // Catch:{ IOException -> 0x03b3, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            if (r0 == 0) goto L_0x02c0
            boolean r14 = r0.pf()     // Catch:{ IOException -> 0x02b9, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            if (r14 == 0) goto L_0x02c0
            java.lang.String r22 = r0.th()     // Catch:{ IOException -> 0x02b9, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            goto L_0x02c0
        L_0x02b9:
            r0 = move-exception
            r24 = r6
            r32 = r7
            goto L_0x03c7
        L_0x02c0:
            r14 = r22
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r0.<init>()     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            java.lang.String r15 = "sendData, http param : "
            r0.append(r15)     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r0.append(r14)     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r1.o(r8, r0)     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            java.lang.String r0 = "Step3 写入数据"
            r1.fe(r0)     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            long r24 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r1.ppp(r9, r14)     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            long r34 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x03ad, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r22 = r14
            long r14 = r34 - r24
            r12.ggg(r14)     // Catch:{ IOException -> 0x03b3, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x03b3, SecurityException -> 0x03b7, Exception -> 0x03d0 }
            r32 = r7
            int r7 = r9.getResponseCode()     // Catch:{ IOException -> 0x03a4, SecurityException -> 0x039c, Exception -> 0x03d0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0391, SecurityException -> 0x038c, Exception -> 0x0389 }
            r0.<init>()     // Catch:{ IOException -> 0x0391, SecurityException -> 0x038c, Exception -> 0x0389 }
            r24 = r14
            java.lang.String r14 = "http statusCode : "
            r0.append(r14)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.append(r7)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r1.o(r8, r0)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r12.rg(r7)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.<init>()     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.String r14 = "HttpCode = "
            r0.append(r14)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.append(r7)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r1.fe(r0)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0 = 400(0x190, float:5.6E-43)
            java.lang.String r14 = "Http 返回的状态码为："
            if (r7 < r0) goto L_0x0356
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.<init>()     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.append(r14)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.append(r7)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            fe.mmm.qw.i.qw.rg(r11, r0)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r1.qw(r3)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            if (r9 == 0) goto L_0x0347
            r1.o(r8, r13)
            r9.disconnect()
        L_0x0347:
            r1.qw(r3)
            r0 = r7
            r15 = r10
            r2 = r24
            r7 = r33
            r24 = r6
            r33 = r11
            goto L_0x0541
        L_0x0356:
            if (r6 == 0) goto L_0x035f
            java.lang.String r0 = "http_dns_request_success"
            fe.mmm.qw.nn.ad.qw.qw r15 = fe.mmm.qw.nn.ad.qw.qw.qw     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r15.ppp(r0)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
        L_0x035f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.<init>()     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.append(r14)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r0.append(r7)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.String r14 = " 不重试了"
            r0.append(r14)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            fe.mmm.qw.i.qw.ad(r11, r0)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            java.lang.String r0 = "http request success, not retry"
            r1.o(r8, r0)     // Catch:{ IOException -> 0x0385, SecurityException -> 0x0383, Exception -> 0x0389 }
            r15 = r7
            r23 = r24
            r0 = r26
            r6 = 1
            goto L_0x057c
        L_0x0383:
            r0 = move-exception
            goto L_0x038f
        L_0x0385:
            r0 = move-exception
            r14 = r24
            goto L_0x0394
        L_0x0389:
            r0 = move-exception
            r15 = r7
            goto L_0x03d3
        L_0x038c:
            r0 = move-exception
            r24 = r14
        L_0x038f:
            r15 = r7
            goto L_0x03a1
        L_0x0391:
            r0 = move-exception
            r24 = r14
        L_0x0394:
            r24 = r6
            r6 = r0
            r0 = r7
            r7 = r33
            goto L_0x04d7
        L_0x039c:
            r0 = move-exception
            r24 = r14
            r15 = r37
        L_0x03a1:
            r23 = r24
            goto L_0x03bc
        L_0x03a4:
            r0 = move-exception
            r24 = r14
            r7 = r33
            r24 = r6
            goto L_0x04d4
        L_0x03ad:
            r0 = move-exception
            r32 = r7
            r22 = r14
            goto L_0x03c5
        L_0x03b3:
            r0 = move-exception
            r32 = r7
            goto L_0x03c5
        L_0x03b7:
            r0 = move-exception
            r15 = r37
            r23 = r19
        L_0x03bc:
            r7 = r33
            goto L_0x044a
        L_0x03c0:
            r0 = move-exception
            r32 = r7
            r4 = r14
            r10 = r15
        L_0x03c5:
            r24 = r6
        L_0x03c7:
            r14 = r19
            r7 = r33
            goto L_0x04d4
        L_0x03cd:
            r0 = move-exception
            goto L_0x0561
        L_0x03d0:
            r0 = move-exception
            r15 = r37
        L_0x03d3:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r4.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = "http request Exception, exception : "
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            r4.append(r0)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03cd }
            r1.o(r8, r4)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r4.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = "请求过程异常 Exception = "
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            r4.append(r0)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03cd }
            r1.fe(r4)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r4.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.Class r6 = r0.getClass()     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x03cd }
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            r7 = r33
            r4.append(r7)     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x03cd }
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03cd }
            r1.pf(r2, r5, r4)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r2.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.Class r4 = r0.getClass()     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x03cd }
            r2.append(r4)     // Catch:{ all -> 0x03cd }
            r2.append(r7)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x03cd }
            r2.append(r4)     // Catch:{ all -> 0x03cd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03cd }
            r12.ad(r2)     // Catch:{ all -> 0x03cd }
            r1.ggg(r0, r15)     // Catch:{ all -> 0x03cd }
            throw r0     // Catch:{ all -> 0x03cd }
        L_0x0443:
            r0 = move-exception
            r7 = r33
            r15 = r37
            r23 = r19
        L_0x044a:
            java.lang.String r4 = "SecurityException"
            fe.mmm.qw.i.qw.th(r11, r4, r0)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r4.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = "http request SecurityException, exception : "
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            r4.append(r0)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03cd }
            r1.o(r8, r4)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r4.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = "请求过程异常 SecurityException = "
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            r4.append(r0)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03cd }
            r1.fe(r4)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r4.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.Class r6 = r0.getClass()     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x03cd }
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            r4.append(r7)     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x03cd }
            r4.append(r6)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03cd }
            r1.pf(r2, r5, r4)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r2.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.Class r4 = r0.getClass()     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x03cd }
            r2.append(r4)     // Catch:{ all -> 0x03cd }
            r2.append(r7)     // Catch:{ all -> 0x03cd }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x03cd }
            r2.append(r4)     // Catch:{ all -> 0x03cd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03cd }
            r12.ad(r2)     // Catch:{ all -> 0x03cd }
            r1.ggg(r0, r15)     // Catch:{ all -> 0x03cd }
            if (r9 == 0) goto L_0x04c4
            r1.o(r8, r13)
            r9.disconnect()
        L_0x04c4:
            r1.qw(r3)
            goto L_0x0579
        L_0x04c9:
            r0 = move-exception
            r32 = r7
            r4 = r14
            r10 = r15
            r7 = r33
            r24 = r6
            r14 = r19
        L_0x04d4:
            r6 = r0
            r0 = r37
        L_0x04d7:
            if (r2 == 0) goto L_0x04db
            int r10 = r10 + 1
        L_0x04db:
            r37 = r10
            java.lang.String r10 = "IOException"
            fe.mmm.qw.i.qw.th(r11, r10, r6)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r10.<init>()     // Catch:{ all -> 0x03cd }
            r33 = r11
            java.lang.String r11 = "http request IOException, exception : "
            r10.append(r11)     // Catch:{ all -> 0x03cd }
            r10.append(r6)     // Catch:{ all -> 0x03cd }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x03cd }
            r1.o(r8, r10)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r10.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.String r11 = "请求过程异常 IOException = "
            r10.append(r11)     // Catch:{ all -> 0x03cd }
            r10.append(r6)     // Catch:{ all -> 0x03cd }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x03cd }
            r1.fe(r10)     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r10.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.Class r11 = r6.getClass()     // Catch:{ all -> 0x03cd }
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x03cd }
            r10.append(r11)     // Catch:{ all -> 0x03cd }
            r10.append(r7)     // Catch:{ all -> 0x03cd }
            java.lang.String r11 = r6.getMessage()     // Catch:{ all -> 0x03cd }
            r10.append(r11)     // Catch:{ all -> 0x03cd }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x03cd }
            r1.pf(r2, r5, r10)     // Catch:{ all -> 0x03cd }
            r12.ad(r10)     // Catch:{ all -> 0x03cd }
            r1.ggg(r6, r0)     // Catch:{ all -> 0x03cd }
            if (r9 == 0) goto L_0x053b
            r1.o(r8, r13)
            r9.disconnect()
        L_0x053b:
            r1.qw(r3)
            r2 = r14
            r15 = r37
        L_0x0541:
            int r14 = r4 + 1
            r37 = r0
            r5 = r7
            r25 = r9
            r4 = r13
            r9 = r21
            r21 = r23
            r0 = r24
            r6 = r29
            r13 = r30
            r10 = r31
            r7 = r32
            r11 = r33
            r23 = r2
            r2 = r27
            r3 = r28
            goto L_0x0095
        L_0x0561:
            if (r9 == 0) goto L_0x0569
            r1.o(r8, r13)
            r9.disconnect()
        L_0x0569:
            r1.qw(r3)
            throw r0
        L_0x056d:
            r27 = r2
            r28 = r3
            r31 = r10
            r30 = r13
            r15 = r37
            r9 = r25
        L_0x0579:
            r0 = r26
            r6 = 0
        L_0x057c:
            if (r6 == 0) goto L_0x06b2
            r1.i(r9)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            fe.mmm.qw.j.i.de(r9)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            fe.mmm.qw.nn.de.pf.ad r2 = new fe.mmm.qw.nn.de.pf.ad     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            r2.<init>(r9)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            r2.rg(r15)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            r3.<init>()     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            java.lang.String r4 = "http request parser : "
            r3.append(r4)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            r4 = r30
            r3.append(r4)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            r1.o(r8, r3)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            fe.mmm.qw.nn.ad.qw.qw r5 = fe.mmm.qw.nn.ad.qw.qw.qw     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            java.lang.Boolean r0 = r5.de(r0)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            if (r0 == 0) goto L_0x05fe
            if (r4 == 0) goto L_0x05b8
            java.lang.Object r0 = r4.qw(r2)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            r3 = r0
            goto L_0x05b9
        L_0x05b8:
            r3 = 0
        L_0x05b9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            r0.<init>()     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            java.lang.String r4 = "Step4 解析器的解析结果 result : "
            r0.append(r4)     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            java.lang.String r4 = r1.m992switch(r3)     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            r0.append(r4)     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            r1.fe(r0)     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            long r4 = r2.ad()     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            long r4 = r4 - r23
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            long r6 = r6 - r23
            long r6 = r6 - r4
            int r0 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x0606
            int r0 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x0606
            int r0 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x0606
            r12.m995switch(r4)     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            r12.pf(r6)     // Catch:{ Exception -> 0x05f8, all -> 0x05f1 }
            goto L_0x0606
        L_0x05f1:
            r0 = move-exception
            r2 = r27
            r4 = r28
            goto L_0x0684
        L_0x05f8:
            r0 = move-exception
            r2 = r27
            r4 = r28
            goto L_0x0659
        L_0x05fe:
            java.lang.String r0 = "Space_Switching"
            java.lang.String r2 = "切换空间中，不解析"
            fe.mmm.qw.i.qw.ad(r0, r2)     // Catch:{ Exception -> 0x0653, all -> 0x064c }
            r3 = 0
        L_0x0606:
            if (r9 == 0) goto L_0x060b
            r9.disconnect()
        L_0x060b:
            if (r3 != 0) goto L_0x0613
            r2 = r27
            r1.o(r8, r2)
            goto L_0x062b
        L_0x0613:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r4 = r28
            r0.append(r4)
            java.lang.String r2 = r1.m992switch(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.o(r8, r0)
        L_0x062b:
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r4 = r4 - r17
            r12.ppp(r4)
            r1.m991if(r12)
            boolean r0 = r3 instanceof fe.mmm.qw.nn.de.pf.de
            if (r0 == 0) goto L_0x0648
            r0 = r3
            fe.mmm.qw.nn.de.pf.de r0 = (fe.mmm.qw.nn.de.pf.de) r0
            int r0 = r0.errno
            if (r0 == 0) goto L_0x0648
            r2 = r31
            r1.uk(r8, r2)
            goto L_0x064b
        L_0x0648:
            r36.th()
        L_0x064b:
            return r3
        L_0x064c:
            r0 = move-exception
            r2 = r27
            r4 = r28
            r3 = 0
            goto L_0x0684
        L_0x0653:
            r0 = move-exception
            r2 = r27
            r4 = r28
            r3 = 0
        L_0x0659:
            boolean r5 = r0 instanceof java.lang.NullPointerException     // Catch:{ all -> 0x0683 }
            if (r5 == 0) goto L_0x0682
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0683 }
            r5.<init>()     // Catch:{ all -> 0x0683 }
            java.lang.String r6 = "解析Response异常 result : "
            r5.append(r6)     // Catch:{ all -> 0x0683 }
            java.lang.String r6 = r1.m992switch(r3)     // Catch:{ all -> 0x0683 }
            r5.append(r6)     // Catch:{ all -> 0x0683 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0683 }
            r1.fe(r5)     // Catch:{ all -> 0x0683 }
            r1.ggg(r0, r15)     // Catch:{ all -> 0x0683 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0683 }
            java.lang.String r5 = "system inner error"
            com.tera.scan.network.network.NetworkDetailException r6 = r1.f8124th     // Catch:{ all -> 0x0683 }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x0683 }
            throw r0     // Catch:{ all -> 0x0683 }
        L_0x0682:
            throw r0     // Catch:{ all -> 0x0683 }
        L_0x0683:
            r0 = move-exception
        L_0x0684:
            if (r9 == 0) goto L_0x0689
            r9.disconnect()
        L_0x0689:
            if (r3 != 0) goto L_0x068f
            r1.o(r8, r2)
            goto L_0x06a5
        L_0x068f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r3 = r1.m992switch(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.o(r8, r2)
        L_0x06a5:
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 - r17
            r12.ppp(r2)
            r1.m991if(r12)
            throw r0
        L_0x06b2:
            java.lang.String r0 = "http request not success, retry failed"
            r1.o(r8, r0)
            java.lang.String r0 = "请求异常 使用完所有重试次数，向业务层抛出异常 retry failed"
            r1.uk(r8, r0)
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 - r17
            r12.ppp(r2)
            r1.m991if(r12)
            java.io.IOException r0 = new java.io.IOException
            com.tera.scan.network.network.NetworkDetailException r2 = r1.f8124th
            java.lang.String r3 = "retry failed."
            r0.<init>(r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.de.yj.when(java.lang.Object[]):java.lang.Object");
    }

    public void yj(HttpURLConnection httpURLConnection, de deVar) {
        ad rg2 = deVar.rg();
        if (rg2 != null && rg2.th() != null && !rg2.th().isEmpty()) {
            Map<String, String> th2 = rg2.th();
            for (String next : th2.keySet()) {
                httpURLConnection.setRequestProperty(next, th2.get(next));
            }
        }
    }
}
