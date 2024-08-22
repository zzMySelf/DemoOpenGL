package fe.fe.ddd.p001switch.when;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.fe.ddd.switch.when.qw  reason: invalid package */
public class qw {
    public boolean A;
    public String B;
    public String C;
    public JSONObject D;
    public int E;
    public String F;
    public long G;
    public String H;
    public long I;
    public String J;
    public String K;
    public long L = -1;
    public long M = -1;
    public long N = -1;
    public long O = -1;
    public long P = -1;
    public int Q = -1;
    public JSONObject R = new JSONObject();
    public int S;
    public boolean T = false;
    public String U;
    public String V;
    public long W = -1;
    public int X = -1;
    public String a;
    public String aaa;

    /* renamed from: ad  reason: collision with root package name */
    public long f1655ad = -1;
    public String b;
    public long c = 0;
    public long d = 0;
    public List<String> ddd;

    /* renamed from: de  reason: collision with root package name */
    public long f1656de = -1;
    public String e;
    public String eee;
    public String f;

    /* renamed from: fe  reason: collision with root package name */
    public long f1657fe = -1;
    public boolean g;
    public long ggg = -1;
    public boolean h = false;

    /* renamed from: i  reason: collision with root package name */
    public long f1658i = -1;

    /* renamed from: if  reason: not valid java name */
    public long f38if = -1;
    public boolean j = false;
    public int k = -1;
    public List<InetAddress> l;
    public boolean m;
    public int mmm = -1;
    public String n;
    public Exception nn;

    /* renamed from: o  reason: collision with root package name */
    public long f1659o = -1;
    public String p;

    /* renamed from: pf  reason: collision with root package name */
    public long f1660pf = -1;
    public long ppp = -1;
    public long q = 0;
    public String qqq;
    public long qw = -1;
    public long r = -1;

    /* renamed from: rg  reason: collision with root package name */
    public long f1661rg = -1;
    public String rrr;
    public int s = -1;

    /* renamed from: switch  reason: not valid java name */
    public long f39switch = -1;
    public int t = 0;

    /* renamed from: th  reason: collision with root package name */
    public long f1662th = -1;
    public String tt;
    public int u = 0;

    /* renamed from: uk  reason: collision with root package name */
    public long f1663uk = -1;
    public JSONObject v;
    public long vvv = -1;
    public String w;
    public long when = -1;
    public boolean x;
    public JSONObject xxx = new JSONObject();
    public int y;

    /* renamed from: yj  reason: collision with root package name */
    public long f1664yj = -1;
    public boolean z;

    public final String ad(Throwable th2) {
        return (th2 == null || th2.getMessage() == null) ? "" : th2.getMessage();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String de(java.lang.Throwable r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0005
            java.lang.String r4 = ""
            return r4
        L_0x0005:
            r0 = 0
            java.io.StringWriter r1 = new java.io.StringWriter     // Catch:{ all -> 0x0021 }
            r1.<init>()     // Catch:{ all -> 0x0021 }
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ all -> 0x0021 }
            r2.<init>(r1)     // Catch:{ all -> 0x0021 }
            r4.printStackTrace(r2)     // Catch:{ all -> 0x001e }
            r2.flush()     // Catch:{ all -> 0x001e }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x001e }
            r2.close()
            return r4
        L_0x001e:
            r4 = move-exception
            r0 = r2
            goto L_0x0022
        L_0x0021:
            r4 = move-exception
        L_0x0022:
            if (r0 == 0) goto L_0x0027
            r0.close()
        L_0x0027:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.p001switch.when.qw.de(java.lang.Throwable):java.lang.String");
    }

    public final JSONArray fe() {
        ArrayList arrayList = new ArrayList();
        List<InetAddress> list = this.l;
        if (list != null) {
            for (InetAddress next : list) {
                if (!TextUtils.isEmpty(next.getHostAddress())) {
                    arrayList.add(next.getHostAddress());
                }
            }
        }
        return new JSONArray(arrayList);
    }

    public final JSONObject qw(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
        }
        return jSONObject2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f5 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0204 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0213 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0222 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x024b A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0281 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0283 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x028f A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x029c A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x029e A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02b4 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02c5 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02c7 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02d1 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02d3 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02db A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02f9 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x030f A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x031c A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0329 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0336 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0343 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0350 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x035d A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0388 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03a1 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03c1 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x03c2 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03ca A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03d5 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03e2 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03ed A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0113 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0120 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012d A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013a A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0147 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0154 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0161 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016e A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0181 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x019c A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ab A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01ba A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01c9 A[Catch:{ JSONException -> 0x03f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e6 A[Catch:{ JSONException -> 0x03f5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject rg() {
        /*
            r12 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "ver"
            r2 = 2
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "type"
            java.lang.String r2 = "common"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = r12.eee     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x0021
            java.lang.String r1 = "url"
            java.lang.String r2 = r12.eee     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0021:
            java.lang.String r1 = r12.rrr     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x0030
            java.lang.String r1 = "originUrl"
            java.lang.String r2 = r12.rrr     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0030:
            java.lang.String r1 = r12.tt     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x003f
            java.lang.String r1 = "protocol"
            java.lang.String r2 = r12.tt     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
        L_0x003f:
            java.lang.String r1 = r12.a     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x004e
            java.lang.String r1 = "netType"
            java.lang.String r2 = r12.a     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
        L_0x004e:
            long r1 = r12.qw     // Catch:{ JSONException -> 0x03f5 }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x005d
            java.lang.String r1 = "startTime"
            long r5 = r12.qw     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x005d:
            long r1 = r12.f1655ad     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x006a
            java.lang.String r1 = "tcpStartTime"
            long r5 = r12.f1655ad     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x006a:
            long r1 = r12.f1656de     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0077
            java.lang.String r1 = "tcpEndTime"
            long r5 = r12.f1656de     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0077:
            long r1 = r12.f1657fe     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0084
            java.lang.String r1 = "sslStartTime"
            long r5 = r12.f1657fe     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0084:
            long r1 = r12.f1661rg     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0091
            java.lang.String r1 = "sslEndTime"
            long r5 = r12.f1661rg     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0091:
            long r1 = r12.f1662th     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x009e
            java.lang.String r1 = "connectedTime"
            long r5 = r12.f1662th     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x009e:
            long r1 = r12.ppp     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00ab
            java.lang.String r1 = "dnsStartTime"
            long r5 = r12.ppp     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x00ab:
            long r1 = r12.ggg     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b8
            java.lang.String r1 = "dnsEndTime"
            long r5 = r12.ggg     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x00b8:
            long r1 = r12.vvv     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00c5
            java.lang.String r1 = "dnsTtme"
            long r5 = r12.vvv     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x00c5:
            org.json.JSONObject r1 = r12.xxx     // Catch:{ JSONException -> 0x03f5 }
            org.json.JSONObject r1 = r12.qw(r1)     // Catch:{ JSONException -> 0x03f5 }
            org.json.JSONObject r2 = r12.xxx     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r5 = "dnsDetail"
            if (r2 == 0) goto L_0x00dd
            org.json.JSONObject r2 = r12.xxx     // Catch:{ JSONException -> 0x03f5 }
            int r2 = r2.length()     // Catch:{ JSONException -> 0x03f5 }
            if (r2 <= 0) goto L_0x00dd
            r0.put(r5, r1)     // Catch:{ JSONException -> 0x03f5 }
            goto L_0x00f5
        L_0x00dd:
            java.util.List<java.net.InetAddress> r2 = r12.l     // Catch:{ JSONException -> 0x03f5 }
            if (r2 == 0) goto L_0x00f5
            java.util.List<java.net.InetAddress> r2 = r12.l     // Catch:{ JSONException -> 0x03f5 }
            boolean r2 = r2.isEmpty()     // Catch:{ JSONException -> 0x03f5 }
            if (r2 != 0) goto L_0x00f5
            java.lang.String r2 = "ipList"
            org.json.JSONArray r6 = r12.fe()     // Catch:{ JSONException -> 0x03f5 }
            r1.put(r2, r6)     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r5, r1)     // Catch:{ JSONException -> 0x03f5 }
        L_0x00f5:
            java.util.List<java.lang.String> r1 = r12.ddd     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x010d
            java.util.List<java.lang.String> r1 = r12.ddd     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = r1.isEmpty()     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x010d
            java.lang.String r1 = "localDnsIpList"
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x03f5 }
            java.util.List<java.lang.String> r5 = r12.ddd     // Catch:{ JSONException -> 0x03f5 }
            r2.<init>(r5)     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
        L_0x010d:
            long r1 = r12.f1660pf     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x011a
            java.lang.String r1 = "sendHeaderStartTime"
            long r5 = r12.f1660pf     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x011a:
            long r1 = r12.f38if     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0127
            java.lang.String r1 = "sendHeaderTime"
            long r5 = r12.f38if     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0127:
            long r1 = r12.f39switch     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0134
            java.lang.String r1 = "receiveHeaderStartTime"
            long r5 = r12.f39switch     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0134:
            long r1 = r12.when     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0141
            java.lang.String r1 = "receiveHeaderTime"
            long r5 = r12.when     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0141:
            long r1 = r12.f1664yj     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x014e
            java.lang.String r1 = "responseTime"
            long r5 = r12.f1664yj     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x014e:
            long r1 = r12.f1663uk     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x015b
            java.lang.String r1 = "finishedTime"
            long r5 = r12.f1663uk     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x015b:
            long r1 = r12.f1658i     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0168
            java.lang.String r1 = "getNetworkInfoTs"
            long r5 = r12.f1658i     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0168:
            long r1 = r12.f1659o     // Catch:{ JSONException -> 0x03f5 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0175
            java.lang.String r1 = "failTime"
            long r5 = r12.f1659o     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0175:
            java.lang.Exception r1 = r12.nn     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = r12.de(r1)     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x0197
            java.lang.String r1 = "errMsg"
            java.lang.Exception r2 = r12.nn     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r2 = r12.de(r2)     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "exceptionMsg"
            java.lang.Exception r2 = r12.nn     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r2 = r12.ad(r2)     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0197:
            int r1 = r12.mmm     // Catch:{ JSONException -> 0x03f5 }
            r2 = -1
            if (r1 == r2) goto L_0x01a3
            java.lang.String r1 = "statusCode"
            int r5 = r12.mmm     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x01a3:
            java.lang.String r1 = r12.qqq     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x01b2
            java.lang.String r1 = "localIP"
            java.lang.String r5 = r12.qqq     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x01b2:
            java.lang.String r1 = r12.aaa     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x01c1
            java.lang.String r1 = "remoteIP"
            java.lang.String r5 = r12.aaa     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x01c1:
            java.lang.String r1 = r12.b     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x01d0
            java.lang.String r1 = "header"
            java.lang.String r5 = r12.b     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x01d0:
            java.lang.String r1 = "responseLength"
            long r5 = r12.c     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "requestBodyLength"
            long r5 = r12.d     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = r12.e     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x01ed
            java.lang.String r1 = "clientIP"
            java.lang.String r5 = r12.e     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x01ed:
            java.lang.String r1 = r12.f     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x01fc
            java.lang.String r1 = "clientIPv6"
            java.lang.String r5 = r12.f     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x01fc:
            java.lang.String r1 = r12.n     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x020b
            java.lang.String r1 = "Content-Type"
            java.lang.String r5 = r12.n     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x020b:
            java.lang.String r1 = r12.p     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x021a
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r5 = r12.p     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x021a:
            long r5 = r12.q     // Catch:{ JSONException -> 0x03f5 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0229
            java.lang.String r1 = "realResponseLength"
            long r5 = r12.q     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0229:
            long r5 = r12.q     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x023c
            long r5 = r12.r     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x023c
            java.lang.String r1 = "readOverTime"
            long r5 = r12.r     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x023c:
            int r1 = r12.s     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == r2) goto L_0x0247
            java.lang.String r1 = "netEngine"
            int r5 = r12.s     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0247:
            org.json.JSONObject r1 = r12.v     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x0256
            java.lang.String r1 = "user_log"
            org.json.JSONObject r5 = r12.v     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0256:
            java.lang.String r1 = "from"
            int r5 = r12.t     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "subFrom"
            int r5 = r12.u     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "socketReuse"
            boolean r5 = r12.g     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r6 = "1"
            java.lang.String r9 = "0"
            if (r5 == 0) goto L_0x0270
            r5 = r6
            goto L_0x0271
        L_0x0270:
            r5 = r9
        L_0x0271:
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "ipStack"
            int r5 = r12.S     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "useFallback"
            boolean r5 = r12.m     // Catch:{ JSONException -> 0x03f5 }
            if (r5 == 0) goto L_0x0283
            r5 = r6
            goto L_0x0284
        L_0x0283:
            r5 = r9
        L_0x0284:
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = r12.w     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x0296
            java.lang.String r1 = "bdTraceId"
            java.lang.String r5 = r12.w     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0296:
            java.lang.String r1 = "isConnected"
            boolean r5 = r12.x     // Catch:{ JSONException -> 0x03f5 }
            if (r5 == 0) goto L_0x029e
            r5 = r6
            goto L_0x029f
        L_0x029e:
            r5 = r9
        L_0x029f:
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "networkQuality"
            int r5 = r12.y     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "networkQualityFrom"
            int r5 = r12.E     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            org.json.JSONObject r1 = r12.D     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x02bf
            java.lang.String r1 = "sdtProbeErrorCode"
            org.json.JSONObject r5 = r12.D     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x02bf:
            java.lang.String r1 = "viaVPN"
            boolean r5 = r12.z     // Catch:{ JSONException -> 0x03f5 }
            if (r5 == 0) goto L_0x02c7
            r5 = r6
            goto L_0x02c8
        L_0x02c7:
            r5 = r9
        L_0x02c8:
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "viaProxy"
            boolean r5 = r12.A     // Catch:{ JSONException -> 0x03f5 }
            if (r5 == 0) goto L_0x02d3
            r5 = r6
            goto L_0x02d4
        L_0x02d3:
            r5 = r9
        L_0x02d4:
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = r12.A     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x02f1
            java.lang.String r1 = r12.B     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x02e6
            java.lang.String r1 = "proxyHost"
            java.lang.String r5 = r12.B     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x02e6:
            java.lang.String r1 = r12.C     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x02f1
            java.lang.String r1 = "proxyAddress"
            java.lang.String r5 = r12.C     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x02f1:
            java.lang.String r1 = r12.F     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x0307
            java.lang.String r1 = "httpDnsAreaInfo"
            java.lang.String r5 = r12.F     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "httpDnsAreaUpdateTime"
            long r10 = r12.G     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r10)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0307:
            java.lang.String r1 = r12.H     // Catch:{ JSONException -> 0x03f5 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x0316
            java.lang.String r1 = "processName"
            java.lang.String r5 = r12.H     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0316:
            long r10 = r12.I     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0323
            java.lang.String r1 = "appLaunchTimestamp"
            long r7 = r12.I     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0323:
            long r7 = r12.L     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0330
            java.lang.String r1 = "callStartTimeStamp"
            long r7 = r12.L     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0330:
            long r7 = r12.M     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x033d
            java.lang.String r1 = "callEndTimeStamp"
            long r7 = r12.M     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x03f5 }
        L_0x033d:
            long r7 = r12.N     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x034a
            java.lang.String r1 = "switchThreadStart"
            long r7 = r12.N     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x03f5 }
        L_0x034a:
            long r7 = r12.O     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0357
            java.lang.String r1 = "switchThreadEnd"
            long r7 = r12.O     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0357:
            long r7 = r12.P     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0364
            java.lang.String r1 = "switchThreadInQueue"
            long r7 = r12.P     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0364:
            java.lang.String r1 = r12.J     // Catch:{ JSONException -> 0x03f5 }
            if (r1 != 0) goto L_0x036c
            java.lang.String r1 = r12.K     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x0384
        L_0x036c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x03f5 }
            r1.<init>()     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r5 = "product"
            java.lang.String r7 = r12.J     // Catch:{ JSONException -> 0x03f5 }
            r1.put(r5, r7)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r5 = "isp"
            java.lang.String r7 = r12.K     // Catch:{ JSONException -> 0x03f5 }
            r1.put(r5, r7)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r5 = "freeCard"
            r0.put(r5, r1)     // Catch:{ JSONException -> 0x03f5 }
        L_0x0384:
            int r1 = r12.k     // Catch:{ JSONException -> 0x03f5 }
            if (r1 <= r2) goto L_0x038f
            java.lang.String r1 = "addressIndex"
            int r5 = r12.k     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x038f:
            java.lang.String r1 = "isMultiConnectEnabled"
            boolean r5 = r12.h     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = "isMultiConnectTriggered"
            boolean r5 = r12.j     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
            int r1 = r12.Q     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == r2) goto L_0x03a8
            java.lang.String r1 = "tcpiRtt"
            int r5 = r12.Q     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x03a8:
            org.json.JSONObject r1 = r12.R     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x03bb
            org.json.JSONObject r1 = r12.R     // Catch:{ JSONException -> 0x03f5 }
            int r1 = r1.length()     // Catch:{ JSONException -> 0x03f5 }
            if (r1 <= 0) goto L_0x03bb
            java.lang.String r1 = "unexpectedResHeader"
            org.json.JSONObject r5 = r12.R     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x03bb:
            java.lang.String r1 = "hasCookieManager"
            boolean r5 = r12.T     // Catch:{ JSONException -> 0x03f5 }
            if (r5 == 0) goto L_0x03c2
            goto L_0x03c3
        L_0x03c2:
            r6 = r9
        L_0x03c3:
            r0.put(r1, r6)     // Catch:{ JSONException -> 0x03f5 }
            java.lang.String r1 = r12.U     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x03d1
            java.lang.String r1 = "bindMobilePolicy"
            java.lang.String r5 = r12.U     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x03d1:
            java.lang.String r1 = r12.V     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == 0) goto L_0x03dc
            java.lang.String r1 = "bindMobileStatus"
            java.lang.String r5 = r12.V     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x03f5 }
        L_0x03dc:
            long r5 = r12.W     // Catch:{ JSONException -> 0x03f5 }
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x03e9
            java.lang.String r1 = "sidCompressDuration"
            long r3 = r12.W     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x03f5 }
        L_0x03e9:
            int r1 = r12.X     // Catch:{ JSONException -> 0x03f5 }
            if (r1 == r2) goto L_0x03f9
            java.lang.String r1 = "sidCompressResult"
            int r2 = r12.X     // Catch:{ JSONException -> 0x03f5 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x03f5 }
            goto L_0x03f9
        L_0x03f5:
            r1 = move-exception
            r1.printStackTrace()
        L_0x03f9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.p001switch.when.qw.rg():org.json.JSONObject");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkStatRecord{, netEngine=");
        sb.append(this.s);
        sb.append("，url=");
        sb.append(this.eee);
        sb.append("，originUrl=");
        sb.append(this.rrr);
        sb.append(", protocol=");
        sb.append(this.tt);
        sb.append(", netType=");
        sb.append(this.a);
        sb.append(", startTs=");
        sb.append(this.qw);
        sb.append(", tcpStartTs=");
        sb.append(this.f1655ad);
        sb.append(", tcpEndTs=");
        sb.append(this.f1656de);
        sb.append(", sslStartTs=");
        sb.append(this.f1655ad);
        sb.append(", sslEndTs=");
        sb.append(this.f1661rg);
        sb.append(", connTs=");
        sb.append(this.f1662th);
        sb.append(", dnsStartTs=");
        sb.append(this.ppp);
        sb.append(", dnsEndTs=");
        sb.append(this.ggg);
        sb.append(", dnsDetail=");
        sb.append(this.xxx.toString());
        sb.append(", responseTs=");
        sb.append(this.f1664yj);
        sb.append(", sendHeaderTs=");
        sb.append(this.f38if);
        sb.append(", receiveHeaderTs=");
        sb.append(this.when);
        sb.append(", finishTs=");
        sb.append(this.f1663uk);
        sb.append(", getNetworkInfoTs=");
        sb.append(this.f1658i);
        sb.append(", failTs=");
        sb.append(this.f1659o);
        sb.append(", responseLength=");
        sb.append(this.c);
        sb.append(", requestBodyLength=");
        sb.append(this.d);
        sb.append(", remoteIP=");
        sb.append(this.aaa);
        sb.append(", localIP=");
        sb.append(this.qqq);
        sb.append(", connectConsume=");
        sb.append(this.f1662th - this.qw);
        sb.append(", responseConsume=");
        sb.append(this.f1664yj - this.f1662th);
        sb.append(", totalConsume=");
        sb.append(this.f1664yj - this.qw);
        sb.append(", headers=");
        sb.append(this.b);
        sb.append(", excetion=");
        sb.append(de(this.nn));
        sb.append(", exceptionMsg=");
        sb.append(ad(this.nn));
        sb.append(", clientIP=");
        sb.append(this.e);
        sb.append(", clientIPv6=");
        sb.append(this.f);
        sb.append(", isConnReused=");
        sb.append(this.g ? "1" : "0");
        sb.append(", contentType=");
        sb.append(this.n);
        sb.append(", contentEncoding=");
        sb.append(this.p);
        sb.append(", realResponseLength=");
        sb.append(this.q);
        sb.append(", readOverTime=");
        sb.append(this.r);
        sb.append(", from=");
        sb.append(this.t);
        sb.append(", subFrom=");
        sb.append(this.u);
        sb.append(", extraUserInfo=");
        JSONObject jSONObject = this.v;
        String str = "";
        sb.append(jSONObject != null ? jSONObject.toString() : str);
        sb.append(", ipStack=");
        sb.append(this.S);
        sb.append(", isVPNConnect=");
        sb.append(this.z);
        sb.append(", isProxyConnect=");
        sb.append(this.A);
        sb.append(", proxyHost=");
        sb.append(this.B);
        sb.append(", proxyAddress=");
        sb.append(this.C);
        sb.append(", networkQuality=");
        sb.append(this.y);
        sb.append(", sdtProbeErrorCode=");
        JSONObject jSONObject2 = this.D;
        sb.append(jSONObject2 != null ? jSONObject2.toString() : str);
        sb.append(", networkQualityFrom=");
        sb.append(this.E);
        sb.append(", httpDnsAreaInfo=");
        sb.append(this.F);
        sb.append(", httpDnsAreaUpdateTime=");
        sb.append(this.G);
        sb.append(", processName=");
        sb.append(this.H);
        sb.append(", appLaunchTimestamp=");
        sb.append(this.I);
        sb.append(", callStartTimeStamp=");
        sb.append(this.L);
        sb.append(", callEndTimeStamp=");
        sb.append(this.M);
        sb.append(", switchThreadStart=");
        sb.append(this.N);
        sb.append(", switchThreadEnd=");
        sb.append(this.O);
        sb.append(", switchThreadInQueue=");
        sb.append(this.P);
        sb.append(", freeCardProduct=");
        sb.append(this.J);
        sb.append(", freeCardIsp=");
        sb.append(this.K);
        sb.append(", addressList=");
        sb.append(fe());
        sb.append(", addressIndex=");
        sb.append(this.k);
        sb.append(", isMultiConnectEnabled=");
        sb.append(this.h);
        sb.append(", isMultiConnectTriggered=");
        sb.append(this.j);
        sb.append(", tcpiRtt=");
        sb.append(this.Q);
        sb.append(", unexpectedResHeader=");
        JSONObject jSONObject3 = this.R;
        if (jSONObject3 != null) {
            str = jSONObject3.toString();
        }
        sb.append(str);
        sb.append(", sidCompressDuration=");
        sb.append(this.W);
        sb.append(", sidCompressResult=");
        sb.append(this.X);
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }
}
