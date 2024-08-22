package fe.fe.o.rg.de;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import fe.fe.o.th.ggg;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public TreeSet f2646ad = null;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2647de = false;

    /* renamed from: fe  reason: collision with root package name */
    public String f2648fe;

    /* renamed from: i  reason: collision with root package name */
    public long f2649i;

    /* renamed from: if  reason: not valid java name */
    public long f85if = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f2650o;

    /* renamed from: pf  reason: collision with root package name */
    public int f2651pf = -1;
    public List qw = new ArrayList();

    /* renamed from: rg  reason: collision with root package name */
    public int f2652rg;

    /* renamed from: switch  reason: not valid java name */
    public List f86switch;

    /* renamed from: th  reason: collision with root package name */
    public int f2653th;

    /* renamed from: uk  reason: collision with root package name */
    public String f2654uk;
    public String when;

    /* renamed from: yj  reason: collision with root package name */
    public String f2655yj;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (fe.fe.o.th.ggg.th(r3.f86switch) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
        if (fe.fe.o.th.ggg.th(r3.f86switch) == false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List ad(java.lang.String r4, java.lang.Exception r5) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = r5 instanceof java.net.UnknownHostException
            if (r1 == 0) goto L_0x000f
            r5 = 0
        L_0x000a:
            java.lang.String r4 = r3.qw(r4, r5)
            goto L_0x0020
        L_0x000f:
            boolean r1 = r5 instanceof org.apache.http.client.HttpResponseException
            if (r1 != 0) goto L_0x001e
            boolean r1 = r5 instanceof org.apache.http.conn.ConnectTimeoutException
            if (r1 != 0) goto L_0x001e
            boolean r5 = r5 instanceof com.baidu.down.loopj.android.http.exp.RetryStrategyException
            if (r5 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r4 = 0
            goto L_0x0020
        L_0x001e:
            r5 = 1
            goto L_0x000a
        L_0x0020:
            int r5 = r3.f2651pf
            r1 = 4
            java.lang.String r2 = "host"
            if (r5 == r1) goto L_0x007d
            r1 = 5
            if (r5 == r1) goto L_0x005d
            r1 = 6
            if (r5 == r1) goto L_0x0040
            r4 = 7
            if (r5 == r4) goto L_0x0032
            goto L_0x00a2
        L_0x0032:
            java.util.List r4 = r3.f86switch
            boolean r4 = fe.fe.o.th.ggg.th(r4)
            if (r4 != 0) goto L_0x00a2
        L_0x003a:
            java.util.List r4 = r3.f86switch
            r0.addAll(r4)
            goto L_0x00a2
        L_0x0040:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x00a2
            fe.fe.o.qw.yj r5 = new fe.fe.o.qw.yj
            r5.<init>()
            r5.qw = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
        L_0x0052:
            r5.f2595ad = r4
            java.lang.String r1 = r3.f2655yj
            r4.put(r2, r1)
            r0.add(r5)
            goto L_0x00a2
        L_0x005d:
            java.util.List r5 = r3.f86switch
            boolean r5 = fe.fe.o.th.ggg.th(r5)
            if (r5 != 0) goto L_0x006a
            java.util.List r5 = r3.f86switch
            r0.addAll(r5)
        L_0x006a:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x00a2
            fe.fe.o.qw.yj r5 = new fe.fe.o.qw.yj
            r5.<init>()
            r5.qw = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            goto L_0x0052
        L_0x007d:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0099
            fe.fe.o.qw.yj r5 = new fe.fe.o.qw.yj
            r5.<init>()
            r5.qw = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r5.f2595ad = r4
            java.lang.String r1 = r3.f2655yj
            r4.put(r2, r1)
            r0.add(r5)
        L_0x0099:
            java.util.List r4 = r3.f86switch
            boolean r4 = fe.fe.o.th.ggg.th(r4)
            if (r4 != 0) goto L_0x00a2
            goto L_0x003a
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.rg.de.th.ad(java.lang.String, java.lang.Exception):java.util.List");
    }

    public boolean de(Context context) {
        return this.f2650o == 1 && SystemClock.elapsedRealtime() - this.f2649i < ((long) this.f2652rg) * 1000 && !TextUtils.isEmpty(this.f2654uk) && ggg.qw(context).equals(this.f2654uk);
    }

    public boolean fe(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String qw2 = ggg.qw(context);
        List list = this.qw;
        return list == null || list.size() == 0 || elapsedRealtime - this.f2649i >= ((long) this.f2652rg) * 1000 || TextUtils.isEmpty(this.f2654uk) || !qw2.equals(this.f2654uk) || TextUtils.isEmpty(this.f2655yj);
    }

    public String qw(String str, int i2) {
        StringBuilder sb;
        List list = this.qw;
        if (list != null && list.size() - 1 < i2) {
            return null;
        }
        try {
            String replace = str.replace(new URL(str).getHost(), (CharSequence) this.qw.get(i2));
            if (URLUtil.isHttpsUrl(str)) {
                replace = replace.replaceFirst("https://", "http://");
            }
            if (ggg.pf(replace)) {
                sb = new StringBuilder();
                sb.append(replace);
                sb.append("&xcode=");
                sb.append(this.f2648fe);
            } else {
                sb = new StringBuilder();
                sb.append(replace);
                sb.append("?xcode=");
                sb.append(this.f2648fe);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean rg(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.f2652rg;
        return i2 > 0 ? elapsedRealtime - this.f2649i < ((long) Math.min(i2, this.f2653th)) * 1000 : elapsedRealtime - this.f2649i < ((long) this.f2653th) * 1000;
    }
}
