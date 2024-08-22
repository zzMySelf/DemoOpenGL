package fe.fe.o.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import fe.fe.o.th.i;
import fe.fe.o.th.o;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.message.BasicNameValuePair;

public final class fe {

    /* renamed from: rg  reason: collision with root package name */
    public static fe f2452rg;

    /* renamed from: ad  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f2453ad;

    /* renamed from: de  reason: collision with root package name */
    public String f2454de;

    /* renamed from: fe  reason: collision with root package name */
    public String f2455fe;
    public Context qw = null;

    public fe(Context context) {
        this.qw = context.getApplicationContext();
        this.f2453ad = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1, new o("StatisticPoster"));
    }

    public static fe ad(Context context) {
        if (f2452rg == null) {
            f2452rg = new fe(context);
        }
        return f2452rg;
    }

    public static String de(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            return Base64.encodeToString(bArr, 0);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rg(fe.fe.o.rg.ad.qw r22, int r23) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            fe.fe.o.fe.qw.de.o r0 = r2.f2601i
            r3 = r0
            fe.fe.o.fe.qw.de.switch r3 = (fe.fe.o.fe.qw.de.Cswitch) r3
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r2.f
            long r4 = r4 - r6
            fe.fe.o.rg.ad.ad r0 = r2.eee
            long r6 = r0.i()
            long r8 = r2.p
            long r6 = r6 - r8
            long r8 = r2.qqq
            r0 = r2
            fe.fe.o.rg.ad.rg r0 = (fe.fe.o.rg.ad.rg) r0
            java.util.TreeSet r0 = r0.s()
            java.lang.String r10 = ""
            if (r0 == 0) goto L_0x014d
            boolean r11 = r0.isEmpty()
            if (r11 != 0) goto L_0x014d
            java.util.Iterator r11 = r0.iterator()
            r12 = r10
        L_0x0031:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x014a
            java.lang.Object r0 = r11.next()
            r13 = r0
            fe.fe.o.rg.de.yj r13 = (fe.fe.o.rg.de.yj) r13
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r14 = r13.f2663o
            r0.append(r14)
            java.lang.String r14 = "@"
            r0.append(r14)
            java.lang.String r15 = r0.toString()
            java.net.URI r0 = new java.net.URI     // Catch:{ URISyntaxException -> 0x0073 }
            r16 = r11
            java.lang.String r11 = r13.f2665th     // Catch:{ URISyntaxException -> 0x0071 }
            r0.<init>(r11)     // Catch:{ URISyntaxException -> 0x0071 }
            java.lang.String r0 = r0.getHost()     // Catch:{ URISyntaxException -> 0x0071 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x0071 }
            r11.<init>()     // Catch:{ URISyntaxException -> 0x0071 }
            r11.append(r15)     // Catch:{ URISyntaxException -> 0x0071 }
            r11.append(r0)     // Catch:{ URISyntaxException -> 0x0071 }
            r11.append(r14)     // Catch:{ URISyntaxException -> 0x0071 }
            java.lang.String r15 = r11.toString()     // Catch:{ URISyntaxException -> 0x0071 }
            goto L_0x0079
        L_0x0071:
            r0 = move-exception
            goto L_0x0076
        L_0x0073:
            r0 = move-exception
            r16 = r11
        L_0x0076:
            r0.printStackTrace()
        L_0x0079:
            int r0 = r13.f2662i
            r11 = 2
            if (r0 == r11) goto L_0x00a1
            r11 = 3
            if (r0 == r11) goto L_0x008c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r15)
            java.lang.String r11 = "2@-1@-1"
            goto L_0x0096
        L_0x008c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r15)
            java.lang.String r11 = "1@-1@-1"
        L_0x0096:
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r17 = r8
            goto L_0x0130
        L_0x00a1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r15)
            java.lang.String r11 = "0@"
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r17 = r8
            long r8 = r13.f2667yj
            r19 = 0
            int r15 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r15 != 0) goto L_0x00cc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r11)
            java.lang.String r0 = r8.toString()
            goto L_0x00e2
        L_0x00cc:
            long r8 = r13.rg()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r8)
            r11.append(r14)
            java.lang.String r0 = r11.toString()
        L_0x00e2:
            java.util.List r8 = r13.f87if
            if (r8 == 0) goto L_0x011f
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x011f
            r8 = 0
        L_0x00ed:
            java.util.List r9 = r13.f87if
            int r9 = r9.size()
            if (r8 >= r9) goto L_0x0106
            java.util.List r9 = r13.f87if
            java.lang.Object r9 = r9.get(r8)
            java.lang.Long r9 = (java.lang.Long) r9
            long r14 = r9.longValue()
            long r19 = r19 + r14
            int r8 = r8 + 1
            goto L_0x00ed
        L_0x0106:
            java.util.List r8 = r13.f87if
            int r8 = r8.size()
            long r8 = (long) r8
            long r8 = r19 / r8
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r8)
            java.lang.String r0 = r11.toString()
            goto L_0x0130
        L_0x011f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r0 = "-1"
            r8.append(r0)
            java.lang.String r0 = r8.toString()
        L_0x0130:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = ","
            r8.append(r0)
            java.lang.String r12 = r8.toString()
            r11 = r16
            r8 = r17
            goto L_0x0031
        L_0x014a:
            r17 = r8
            goto L_0x0150
        L_0x014d:
            r17 = r8
            r12 = r10
        L_0x0150:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r0 = "cstatus"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r9.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r11 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            int r11 = r11.qw     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r11)     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "ccost"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r9.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r11 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            long r13 = r11.f2442ad     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r13)     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dfstat"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r9.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r11 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            int r11 = r11.f2449th     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r11)     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dfcost"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r9.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r11 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            long r13 = r11.f2451yj     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r13)     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dyget"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r9.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r11 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            int r11 = r11.f2450uk     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r11)     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dyuse"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r9.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r11 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            int r11 = r11.f2445i     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r11)     // Catch:{ JSONException -> 0x02b5 }
            r9.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "cinfo"
            r8.put(r0, r12)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "cuseip"
            fe.fe.o.rg.ad.rg r2 = (fe.fe.o.rg.ad.rg) r2     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.r()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "tnum"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r9 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            int r9 = r9.f2443de     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r9)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dcost"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r4)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dnowsize"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r6)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dallsize"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x02b5 }
            r4 = r17
            r2.append(r4)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "network"
            fe.fe.o.ad.ad r2 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.f2444fe     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dtest"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r4 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            long r4 = r4.f2446o     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r4)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dbtype"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r4 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            int r4 = r4.f2447pf     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r4)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = "dlib"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02b5 }
            r2.<init>()     // Catch:{ JSONException -> 0x02b5 }
            android.content.Context r4 = r1.qw     // Catch:{ JSONException -> 0x02b5 }
            int r4 = fe.fe.o.th.ggg.when(r4)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r4)     // Catch:{ JSONException -> 0x02b5 }
            r2.append(r10)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x02b5 }
            r8.put(r0, r2)     // Catch:{ JSONException -> 0x02b5 }
            fe.fe.o.ad.ad r0 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = r0.f2448rg     // Catch:{ JSONException -> 0x02b5 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r2 = "sid"
            if (r0 == 0) goto L_0x02b0
            java.lang.String r0 = "0"
        L_0x02ac:
            r8.put(r2, r0)     // Catch:{ JSONException -> 0x02b5 }
            goto L_0x02b9
        L_0x02b0:
            fe.fe.o.ad.ad r0 = r3.f80switch     // Catch:{ JSONException -> 0x02b5 }
            java.lang.String r0 = r0.f2448rg     // Catch:{ JSONException -> 0x02b5 }
            goto L_0x02ac
        L_0x02b5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02b9:
            java.lang.String r0 = r8.toString()
            r2 = r23
            r1.th(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.ad.fe.rg(fe.fe.o.rg.ad.qw, int):void");
    }

    public void th(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            String de2 = i.qw(this.qw).de(fe.fe.o.th.fe.de(this.qw, "pref_log_host", "http://flow.app.baidu.com/flow/api/flowlog?"));
            this.f2454de = de2 + "&type=" + i2 + "&packagename=" + this.qw.getPackageName();
            this.f2455fe = str;
            this.f2453ad.schedule(new rg(this), 1000, TimeUnit.MILLISECONDS);
        }
    }

    public final List uk(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("data", de(str)));
        return arrayList;
    }
}
