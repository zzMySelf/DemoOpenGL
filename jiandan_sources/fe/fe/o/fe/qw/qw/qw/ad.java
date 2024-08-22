package fe.fe.o.fe.qw.qw.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.loopj.android.a.a.b;
import com.baidu.down.loopj.android.http.exp.HandlerRetryException;
import com.baidu.down.loopj.android.http.exp.URLDNSException;
import fe.fe.o.de.uk.de;
import fe.fe.o.de.yj;
import fe.fe.o.fe.qw.ad.th;
import fe.fe.o.rg.de.i;
import fe.fe.o.th.Cswitch;
import fe.fe.o.th.ggg;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.RedirectException;

public class ad implements b {

    /* renamed from: ad  reason: collision with root package name */
    public fe.fe.o.fe.qw.ad.ad f2563ad;

    /* renamed from: de  reason: collision with root package name */
    public Map f2564de;

    /* renamed from: fe  reason: collision with root package name */
    public th f2565fe;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2566i = false;

    /* renamed from: o  reason: collision with root package name */
    public yj f2567o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f2568pf = false;
    public HttpURLConnection qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f2569rg;

    /* renamed from: th  reason: collision with root package name */
    public String f2570th;

    /* renamed from: uk  reason: collision with root package name */
    public InputStream f2571uk;

    /* renamed from: yj  reason: collision with root package name */
    public Map f2572yj;

    public ad(fe.fe.o.fe.qw.ad.ad adVar, String str, Map map) {
        this.f2569rg = str;
        this.f2563ad = adVar;
        this.f2564de = map;
        this.f2565fe = adVar.m160if();
    }

    public int a() {
        if (!c()) {
            return this.qw.getResponseCode();
        }
        return 0;
    }

    public String a(String str) {
        return (String) this.f2564de.get(str);
    }

    public String a(boolean z) {
        String str;
        Map headerFields;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3 = new StringBuilder();
        if (!c()) {
            if (!z) {
                sb2.append("Url:");
                sb2.append(this.qw.getURL().toString());
                sb2.append(" ");
                sb2.append(this.qw.getResponseCode());
            } else {
                sb2 = new StringBuilder();
                sb2.append("Uri:");
                sb2.append(this.qw.getURL().toString());
            }
            sb2.append(StringUtils.LF);
            str = sb2.toString();
        } else {
            str = "Uri: null\n";
        }
        sb3.append(str);
        Map map = this.f2564de;
        if (map != null) {
            for (String str2 : map.keySet()) {
                sb3.append(str2 + ":" + ((String) this.f2564de.get(str2)) + StringUtils.LF);
            }
        }
        if (!c()) {
            sb3.append(this.qw.getResponseMessage() + ": \n");
        }
        if (!z && !c() && (headerFields = this.qw.getHeaderFields()) != null) {
            for (String str3 : headerFields.keySet()) {
                if (str3 != null) {
                    sb = new StringBuilder();
                    sb.append(str3.toString());
                    sb.append(":");
                }
                sb.append(((List) headerFields.get(str3)).toString());
                sb.append(StringUtils.LF);
                sb3.append(sb.toString());
            }
        }
        return sb3.toString();
    }

    public void a(String str, String str2) {
        this.f2564de.put(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(fe.fe.o.fe.qw.de.o r5, fe.fe.o.ad.yj r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = r4.f2569rg
            java.lang.String r1 = android.os.Build.VERSION.SDK
            int r1 = java.lang.Integer.parseInt(r1)
            r2 = 21
            if (r1 >= r2) goto L_0x0014
            if (r7 == 0) goto L_0x0014
            java.lang.String r7 = r4.f2569rg
            java.lang.String r0 = fe.fe.o.th.ggg.m177switch(r7)
        L_0x0014:
            java.lang.String r7 = r4.uk(r0)
            boolean r0 = r4.f2568pf
            java.lang.String r1 = "cqid"
            if (r0 == 0) goto L_0x0034
            fe.fe.o.de.yj r0 = r4.f2567o
            r5.eee(r0)
            if (r6 == 0) goto L_0x0047
            fe.fe.o.de.yj r5 = r4.f2567o
            java.lang.String r0 = r5.f2508th
            r6.f2467de = r0
            long r2 = r5.f2509yj
            r6.f2468fe = r2
            java.lang.String r5 = r4.f2569rg
            r6.f2466ad = r5
            goto L_0x0042
        L_0x0034:
            if (r6 == 0) goto L_0x0047
            java.lang.String r5 = r4.f2569rg
            r6.f2466ad = r5
            java.lang.String r5 = ""
            r6.f2467de = r5
            r2 = 0
            r6.f2468fe = r2
        L_0x0042:
            java.lang.String r5 = r6.qw
            r4.a(r1, r5)
        L_0x0047:
            boolean r5 = r4.f2566i
            r6 = 1
            if (r5 == 0) goto L_0x005b
            boolean r5 = android.webkit.URLUtil.isHttpsUrl(r7)
            if (r5 == 0) goto L_0x005b
            fe.fe.o.fe.qw.ad.ad r5 = r4.f2563ad
            java.util.Map r0 = r4.f2564de
            java.net.HttpURLConnection r5 = r5.rg(r7, r0, r6)
            goto L_0x0077
        L_0x005b:
            boolean r5 = r4.f2568pf
            if (r5 == 0) goto L_0x006f
            boolean r5 = android.webkit.URLUtil.isHttpsUrl(r7)
            if (r5 == 0) goto L_0x006f
            fe.fe.o.fe.qw.ad.ad r5 = r4.f2563ad
            java.util.Map r0 = r4.f2564de
            r1 = 0
            java.net.HttpURLConnection r5 = r5.th(r7, r0, r1, r6)
            goto L_0x0077
        L_0x006f:
            fe.fe.o.fe.qw.ad.ad r5 = r4.f2563ad
            java.util.Map r6 = r4.f2564de
            java.net.HttpURLConnection r5 = r5.de(r7, r6)
        L_0x0077:
            r4.qw = r5
            java.net.HttpURLConnection r5 = r4.qw
            r5.connect()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.fe.qw.qw.qw.ad.ad(fe.fe.o.fe.qw.de.o, fe.fe.o.ad.yj, boolean):void");
    }

    public de b() {
        if (c()) {
            return new de("", "", 0);
        }
        de deVar = new de(this.qw.getRequestMethod(), this.f2569rg, this.qw.getResponseCode());
        for (String str : this.f2564de.keySet()) {
            deVar.f2505fe.put(str, this.f2564de.get(str));
        }
        Map headerFields = this.qw.getHeaderFields();
        for (String str2 : headerFields.keySet()) {
            Map map = deVar.f2506rg;
            if (str2 == null) {
                map.put(StringUtil.NULL_STRING, ((List) headerFields.get(str2)).get(0));
            } else {
                map.put(str2, ((List) headerFields.get(str2)).get(0));
            }
        }
        return deVar;
    }

    public void b(boolean z) {
        this.f2566i = z;
    }

    public boolean b(String str) {
        return this.f2564de.containsKey(str);
    }

    public void c(String str) {
        this.f2564de.remove(str);
    }

    public boolean c() {
        return this.qw == null;
    }

    public String d() {
        return this.f2569rg;
    }

    public boolean de(String str) {
        this.f2569rg = str;
        return true;
    }

    public void e() {
    }

    public InputStream f() {
        this.f2571uk = yj(this.qw.getContentEncoding()) ? new GZIPInputStream(this.qw.getInputStream()) : this.qw.getInputStream();
        return this.f2571uk;
    }

    public String fe(String str) {
        return !c() ? this.qw.getHeaderField(str) : "";
    }

    public long g() {
        return (long) this.qw.getContentLength();
    }

    public void h() {
    }

    public void i() {
        Map map = this.f2572yj;
        if (map != null) {
            this.f2564de = map;
            this.f2572yj = null;
            this.f2569rg = this.f2570th;
            this.f2570th = null;
        }
    }

    public void j() {
        this.f2572yj = this.f2564de;
        this.f2570th = this.f2569rg;
    }

    public void k() {
        try {
            if (this.f2571uk != null) {
                this.f2571uk.close();
            }
        } catch (Exception unused) {
        }
    }

    public final boolean o() {
        return i.ad((Context) null).qw().ddd().f2642ad && Cswitch.de(this.f2569rg) && !i.ad((Context) null).qw().nn().pf();
    }

    public void qw(fe.fe.o.qw.yj yjVar) {
        if (this.f2572yj != null) {
            this.f2564de = new HashMap();
            for (String str : this.f2572yj.keySet()) {
                this.f2564de.put(str, this.f2572yj.get(str));
            }
            this.f2569rg = yjVar.qw;
            if (!yjVar.f2595ad.isEmpty()) {
                for (String str2 : yjVar.f2595ad.keySet()) {
                    if (TextUtils.isEmpty((CharSequence) yjVar.f2595ad.get(str2))) {
                        this.f2564de.remove(str2);
                    } else {
                        this.f2564de.put(str2, yjVar.f2595ad.get(str2));
                    }
                }
            }
        }
    }

    public boolean rg(IOException iOException, int i2, int i3) {
        th thVar;
        String str;
        if (!c()) {
            thVar = this.f2565fe;
            str = this.qw.getURL().getHost();
        } else {
            thVar = this.f2565fe;
            str = "";
        }
        return thVar.ad(iOException, i2, str, i3);
    }

    public void th(HashSet hashSet) {
        String headerField = this.qw.getHeaderField("Location");
        if (!TextUtils.isEmpty(headerField)) {
            ggg.fe(this.f2564de, "host");
            if (!hashSet.contains(headerField)) {
                try {
                    URI uri = new URI(headerField);
                    URI uri2 = new URI(this.f2569rg);
                    if (TextUtils.isEmpty(uri.getHost())) {
                        headerField = this.f2569rg.replace(uri2.getPath(), headerField).replace(uri2.getQuery(), "");
                    }
                } catch (Exception e) {
                    try {
                        e.printStackTrace();
                    } catch (IllegalArgumentException unused) {
                        throw new RedirectException("Invalid uri: " + this.qw.getURL());
                    }
                }
                de(headerField);
                hashSet.add(headerField);
                throw new HandlerRetryException("Redirect");
            }
            throw new RedirectException("### Redirect circle : " + hashSet);
        }
        throw new RedirectException("### Redirect null Location : " + this.qw.getURL());
    }

    public final String uk(String str) {
        Exception e;
        String str2;
        if (!o()) {
            this.f2568pf = false;
            return str;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String host = new URI(str).getHost();
            InetAddress[] allByName = InetAddress.getAllByName(host);
            if (allByName == null || allByName.length == 0 || TextUtils.isEmpty(host)) {
                throw new URLDNSException("Dns failed");
            } else if (!host.equalsIgnoreCase(allByName[0].getHostAddress())) {
                str2 = str.replace(host, allByName[0].getHostAddress());
                try {
                    new URL(str2);
                    try {
                        ggg.fe(this.f2564de, "host");
                        this.f2564de.put("host", host);
                        yj yjVar = new yj();
                        this.f2567o = yjVar;
                        yjVar.f2507ad = host;
                        yjVar.f2508th = allByName[0].getHostAddress();
                        this.f2567o.f2509yj = System.currentTimeMillis() - currentTimeMillis;
                        this.f2568pf = true;
                        return str2;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        this.f2568pf = false;
                        return str2;
                    }
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                    this.f2568pf = false;
                    return str;
                }
            } else {
                this.f2568pf = false;
                return str;
            }
        } catch (Exception e4) {
            str2 = str;
            e = e4;
            e.printStackTrace();
            this.f2568pf = false;
            return str2;
        }
    }

    public final boolean yj(String str) {
        return str != null && str.contains("gzip");
    }
}
