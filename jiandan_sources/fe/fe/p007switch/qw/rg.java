package fe.fe.p007switch.qw;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: fe.fe.switch.qw.rg  reason: invalid package */
public class rg {
    public String a;
    public String aaa;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f3052ad = false;
    public JSONObject b;
    public JSONObject c;
    public String d;
    public String ddd;

    /* renamed from: de  reason: collision with root package name */
    public String f3053de;
    public int e;
    public String eee;
    public String f = "";

    /* renamed from: fe  reason: collision with root package name */
    public String f3054fe;
    public String ggg;

    /* renamed from: i  reason: collision with root package name */
    public String f3055i;

    /* renamed from: if  reason: not valid java name */
    public int f92if;
    public String mmm;
    public String nn;

    /* renamed from: o  reason: collision with root package name */
    public String f3056o;

    /* renamed from: pf  reason: collision with root package name */
    public int f3057pf;
    public String ppp;
    public String qqq;
    public boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public String f3058rg = "0";
    public String rrr;

    /* renamed from: switch  reason: not valid java name */
    public String f93switch = null;

    /* renamed from: th  reason: collision with root package name */
    public String f3059th = null;
    public String tt;

    /* renamed from: uk  reason: collision with root package name */
    public int f3060uk = -1;
    public String vvv;
    public String when;
    public String xxx;

    /* renamed from: yj  reason: collision with root package name */
    public String f3061yj = null;

    public synchronized void ad(Context context, JSONObject jSONObject) {
        qw(context);
        if (jSONObject.length() <= 10) {
            fe(context, jSONObject);
        }
    }

    public void de(String str) {
        this.d = str;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void fe(android.content.Context r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "o"
            java.lang.String r1 = "Android"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "st"
            r1 = 0
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "s"
            java.lang.String r2 = r5.f3053de     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x0017
            java.lang.String r2 = ""
            goto L_0x0019
        L_0x0017:
            java.lang.String r2 = r5.f3053de     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0019:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "sv"
            java.lang.String r2 = r5.f3054fe     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x0025
            java.lang.String r2 = ""
            goto L_0x0027
        L_0x0025:
            java.lang.String r2 = r5.f3054fe     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0027:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "k"
            java.lang.String r2 = r5.f3059th     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x0033
            java.lang.String r2 = ""
            goto L_0x0035
        L_0x0033:
            java.lang.String r2 = r5.f3059th     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0035:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "pt"
            java.lang.String r2 = r5.f3058rg     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x0041
            java.lang.String r2 = "0"
            goto L_0x0043
        L_0x0041:
            java.lang.String r2 = r5.f3058rg     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0043:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "i"
            java.lang.String r2 = ""
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "v"
            java.lang.String r2 = "4.0.0.0"
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "sc"
            r2 = 28
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "a"
            int r2 = r5.f3060uk     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "n"
            java.lang.String r2 = r5.f3055i     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x006b
            java.lang.String r2 = ""
            goto L_0x006d
        L_0x006b:
            java.lang.String r2 = r5.f3055i     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x006d:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "d"
            java.lang.String r2 = ""
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "mc"
            java.lang.String r2 = r5.nn     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x0080
            java.lang.String r2 = ""
            goto L_0x0082
        L_0x0080:
            java.lang.String r2 = r5.nn     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0082:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "bm"
            java.lang.String r2 = r5.aaa     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x008e
            java.lang.String r2 = ""
            goto L_0x0090
        L_0x008e:
            java.lang.String r2 = r5.aaa     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0090:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "dd"
            java.lang.String r2 = r5.f3056o     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x009c
            java.lang.String r2 = ""
            goto L_0x009e
        L_0x009c:
            java.lang.String r2 = r5.f3056o     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x009e:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "ii"
            java.lang.String r2 = r5.f3061yj     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r2 != 0) goto L_0x00aa
            java.lang.String r2 = ""
            goto L_0x00ac
        L_0x00aa:
            java.lang.String r2 = r5.f3061yj     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x00ac:
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "tg"
            r2 = 2
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "w"
            int r3 = r5.f3057pf     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "h"
            int r3 = r5.f92if     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "dn"
            java.lang.String r3 = r5.qqq     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x00cc
            java.lang.String r3 = ""
            goto L_0x00ce
        L_0x00cc:
            java.lang.String r3 = r5.qqq     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x00ce:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "c"
            java.lang.String r3 = r5.f93switch     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x00da
            java.lang.String r3 = ""
            goto L_0x00dc
        L_0x00da:
            java.lang.String r3 = r5.f93switch     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x00dc:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "op"
            java.lang.String r3 = r5.when     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x00e8
            java.lang.String r3 = ""
            goto L_0x00ea
        L_0x00e8:
            java.lang.String r3 = r5.when     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x00ea:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "m"
            java.lang.String r3 = r5.ppp     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x00f6
            java.lang.String r3 = ""
            goto L_0x00f8
        L_0x00f6:
            java.lang.String r3 = r5.ppp     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x00f8:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "ma"
            java.lang.String r3 = r5.ggg     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x0104
            java.lang.String r3 = ""
            goto L_0x0106
        L_0x0104:
            java.lang.String r3 = r5.ggg     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0106:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "cl"
            java.lang.String r3 = r5.vvv     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x0112
            java.lang.String r3 = ""
            goto L_0x0114
        L_0x0112:
            java.lang.String r3 = r5.vvv     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0114:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "gl"
            java.lang.String r3 = r5.xxx     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x0120
            java.lang.String r3 = ""
            goto L_0x0122
        L_0x0120:
            java.lang.String r3 = r5.xxx     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0122:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "l"
            java.lang.String r3 = r5.ddd     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x012e
            java.lang.String r3 = ""
            goto L_0x0130
        L_0x012e:
            java.lang.String r3 = r5.ddd     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0130:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "t"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "pn"
            java.lang.String r3 = fe.fe.p007switch.qw.qqq.d(r2, r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "rom"
            java.lang.String r3 = r5.eee     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x014e
            java.lang.String r3 = ""
            goto L_0x0150
        L_0x014e:
            java.lang.String r3 = r5.eee     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0150:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "bo"
            java.lang.String r3 = r5.rrr     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x015c
            java.lang.String r3 = ""
            goto L_0x015e
        L_0x015c:
            java.lang.String r3 = r5.rrr     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x015e:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "bd"
            java.lang.String r3 = r5.tt     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x016a
            java.lang.String r3 = ""
            goto L_0x016c
        L_0x016a:
            java.lang.String r3 = r5.tt     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x016c:
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "td"
            java.lang.String r3 = fe.fe.p007switch.qw.qqq.i(r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "tv"
            if (r6 == 0) goto L_0x0189
            android.content.pm.ApplicationInfo r3 = r6.getApplicationInfo()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r3 != 0) goto L_0x0183
            goto L_0x0189
        L_0x0183:
            android.content.pm.ApplicationInfo r1 = r6.getApplicationInfo()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            int r1 = r1.targetSdkVersion     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0189:
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "user_property"
            java.lang.String r1 = r5.f     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "od"
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.de(r2, r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "out_od"
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.uk(r2, r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "from"
            java.lang.String r1 = "0"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "gaid"
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.ppp(r2, r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "iid"
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.m211if(r2, r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "ii3"
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.vvv(r2, r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "ssaid"
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.ddd(r2, r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = r5.d     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r0 != 0) goto L_0x020a
            java.lang.String r0 = r5.f     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r0 != 0) goto L_0x01e8
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r1 = r5.f     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            goto L_0x01ed
        L_0x01e8:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r0.<init>()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x01ed:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r1.<init>()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r2 = r5.d     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r1.put(r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r2 = "1"
            r1.put(r2)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r2 = "uid_"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r1 = "user_property"
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r1, r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x020a:
            java.lang.String r0 = "uid_change"
            java.lang.String r1 = ""
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = "at"
            java.lang.String r1 = "0"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = fe.fe.p007switch.qw.qqq.c(r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r1 = "pl"
            r7.put(r1, r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r1 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r0 != 0) goto L_0x022c
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.e(r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x022c:
            java.lang.String r6 = "scl"
            if (r1 != 0) goto L_0x0232
            java.lang.String r1 = ""
        L_0x0232:
            r7.put(r6, r1)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r6 = "sign"
            java.lang.String r0 = r5.a     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r0 != 0) goto L_0x023e
            java.lang.String r0 = ""
            goto L_0x0240
        L_0x023e:
            java.lang.String r0 = r5.a     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0240:
            r7.put(r6, r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            org.json.JSONObject r6 = r5.b     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r6 == 0) goto L_0x0257
            org.json.JSONObject r6 = r5.b     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            int r6 = r6.length()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r6 == 0) goto L_0x0257
            java.lang.String r6 = "ext"
            org.json.JSONObject r0 = r5.b     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r6, r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            goto L_0x025c
        L_0x0257:
            java.lang.String r6 = "ext"
            r7.remove(r6)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x025c:
            org.json.JSONObject r6 = r5.c     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            if (r6 != 0) goto L_0x0267
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r6.<init>()     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r5.c = r6     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
        L_0x0267:
            java.lang.String r6 = "push"
            org.json.JSONObject r0 = r5.c     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r6, r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r6 = "uid"
            java.lang.String r0 = r5.d     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r6, r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r6 = "startType"
            int r0 = r5.e     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            r7.put(r6, r0)     // Catch:{ Exception -> 0x0284, all -> 0x0281 }
            goto L_0x0284
        L_0x0281:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0284:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p007switch.qw.rg.fe(android.content.Context, org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(26:6|7|8|(1:10)(1:11)|12|(1:14)|15|16|(4:18|19|20|21)|22|23|24|25|26|27|(1:29)|30|31|32|33|34|35|36|37|38|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00b5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00bb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00d0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00f7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x011f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0129 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8 A[Catch:{ Exception -> 0x00f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void qw(android.content.Context r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.qw     // Catch:{ all -> 0x014f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            fe.fe.p007switch.qw.ppp.uk(r5, r0)     // Catch:{ all -> 0x014f }
            java.lang.String r0 = "android.permission.INTERNET"
            fe.fe.p007switch.qw.ppp.uk(r5, r0)     // Catch:{ all -> 0x014f }
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            fe.fe.p007switch.qw.ppp.uk(r5, r0)     // Catch:{ all -> 0x014f }
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r5.getSystemService(r0)     // Catch:{ all -> 0x014f }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r1.ggg()     // Catch:{ all -> 0x014f }
            r4.f3053de = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r1.ppp()     // Catch:{ all -> 0x014f }
            r4.f3054fe = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r1.xxx()     // Catch:{ all -> 0x014f }
            r4.ppp = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r1.when()     // Catch:{ all -> 0x014f }
            r4.ggg = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r1.mmm()     // Catch:{ all -> 0x014f }
            r4.a = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            org.json.JSONObject r1 = r1.i(r5)     // Catch:{ all -> 0x014f }
            r4.b = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            org.json.JSONObject r1 = r1.ddd(r5)     // Catch:{ all -> 0x014f }
            r4.c = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r1.yj(r0, r5)     // Catch:{ all -> 0x014f }
            r4.f3056o = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.q r1 = com.baidu.mobstat.dxmpay.q.i()     // Catch:{ all -> 0x014f }
            boolean r1 = r1.mmm(r5)     // Catch:{ all -> 0x014f }
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = "1"
            goto L_0x007d
        L_0x007b:
            java.lang.String r1 = "0"
        L_0x007d:
            r4.f3058rg = r1     // Catch:{ all -> 0x014f }
            boolean r1 = fe.fe.p007switch.qw.qqq.f(r5)     // Catch:{ all -> 0x014f }
            if (r1 == 0) goto L_0x0089
            java.lang.String r1 = "2"
            r4.f3058rg = r1     // Catch:{ all -> 0x014f }
        L_0x0089:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x014f }
            r1.<init>()     // Catch:{ all -> 0x014f }
            java.lang.String r2 = r4.f3058rg     // Catch:{ all -> 0x014f }
            r1.append(r2)     // Catch:{ all -> 0x014f }
            java.lang.String r2 = "-28"
            r1.append(r2)     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x014f }
            r4.f3058rg = r1     // Catch:{ all -> 0x014f }
            boolean r1 = r4.f3052ad     // Catch:{ all -> 0x014f }
            r2 = 2
            if (r1 == 0) goto L_0x00bb
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x00b5 }
            boolean r1 = r1.eee(r5)     // Catch:{ Exception -> 0x00b5 }
            com.baidu.mobstat.dxmpay.CooperService r3 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r1 = r3.m27if(r5, r1)     // Catch:{ Exception -> 0x00b5 }
            r4.nn = r1     // Catch:{ Exception -> 0x00b5 }
        L_0x00b5:
            java.lang.String r1 = fe.fe.p007switch.qw.qqq.b(r2, r5)     // Catch:{ Exception -> 0x00bb }
            r4.aaa = r1     // Catch:{ Exception -> 0x00bb }
        L_0x00bb:
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            r3 = 1
            java.lang.String r1 = r1.th(r5, r3)     // Catch:{ all -> 0x014f }
            r4.f3061yj = r1     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r1 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = r1.vvv(r0)     // Catch:{ Exception -> 0x00d0 }
            r4.when = r0     // Catch:{ Exception -> 0x00d0 }
        L_0x00d0:
            int r0 = fe.fe.p007switch.qw.qqq.pf(r5)     // Catch:{ Exception -> 0x00f7 }
            r4.f3057pf = r0     // Catch:{ Exception -> 0x00f7 }
            int r0 = fe.fe.p007switch.qw.qqq.when(r5)     // Catch:{ Exception -> 0x00f7 }
            r4.f92if = r0     // Catch:{ Exception -> 0x00f7 }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ Exception -> 0x00f7 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x00f7 }
            int r0 = r0.orientation     // Catch:{ Exception -> 0x00f7 }
            if (r0 != r2) goto L_0x00f7
            int r0 = r4.f3057pf     // Catch:{ Exception -> 0x00f7 }
            int r1 = r4.f92if     // Catch:{ Exception -> 0x00f7 }
            r0 = r0 ^ r1
            r4.f3057pf = r0     // Catch:{ Exception -> 0x00f7 }
            int r1 = r4.f92if     // Catch:{ Exception -> 0x00f7 }
            r1 = r1 ^ r0
            r4.f92if = r1     // Catch:{ Exception -> 0x00f7 }
            r0 = r0 ^ r1
            r4.f3057pf = r0     // Catch:{ Exception -> 0x00f7 }
        L_0x00f7:
            com.baidu.mobstat.dxmpay.CooperService r0 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r0 = r0.ad(r5)     // Catch:{ all -> 0x014f }
            r4.f93switch = r0     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r0 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r0 = r0.de(r5)     // Catch:{ all -> 0x014f }
            r4.f3059th = r0     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r0 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x011f }
            int r0 = r0.fe(r5)     // Catch:{ Exception -> 0x011f }
            r4.f3060uk = r0     // Catch:{ Exception -> 0x011f }
            com.baidu.mobstat.dxmpay.CooperService r0 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x011f }
            java.lang.String r0 = r0.rg(r5)     // Catch:{ Exception -> 0x011f }
            r4.f3055i = r0     // Catch:{ Exception -> 0x011f }
        L_0x011f:
            com.baidu.mobstat.dxmpay.CooperService r0 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x0129 }
            java.lang.String r0 = r0.pf(r5)     // Catch:{ Exception -> 0x0129 }
            r4.ddd = r0     // Catch:{ Exception -> 0x0129 }
        L_0x0129:
            java.lang.String r0 = fe.fe.p007switch.qw.qqq.yj()     // Catch:{ all -> 0x014f }
            r4.eee = r0     // Catch:{ all -> 0x014f }
            java.lang.String r0 = android.os.Build.BOARD     // Catch:{ all -> 0x014f }
            r4.rrr = r0     // Catch:{ all -> 0x014f }
            java.lang.String r0 = android.os.Build.BRAND     // Catch:{ all -> 0x014f }
            r4.tt = r0     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.CooperService r0 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ all -> 0x014f }
            java.lang.String r0 = r0.aaa(r5)     // Catch:{ all -> 0x014f }
            r4.d = r0     // Catch:{ all -> 0x014f }
            r4.qw = r3     // Catch:{ all -> 0x014f }
            com.baidu.mobstat.dxmpay.q r0 = com.baidu.mobstat.dxmpay.q.i()     // Catch:{ all -> 0x014f }
            java.lang.String r5 = r0.d(r5)     // Catch:{ all -> 0x014f }
            r4.f = r5     // Catch:{ all -> 0x014f }
            monitor-exit(r4)
            return
        L_0x014f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p007switch.qw.rg.qw(android.content.Context):void");
    }
}
