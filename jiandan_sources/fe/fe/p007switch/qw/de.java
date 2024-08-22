package fe.fe.p007switch.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.mobstat.dxmpay.CooperService;
import com.baidu.mobstat.dxmpay.StatService;
import com.baidu.mobstat.dxmpay.h;
import com.baidu.mobstat.dxmpay.q;
import com.dlife.ctaccountapi.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.fe.switch.qw.de  reason: invalid package */
public class de {

    /* renamed from: i  reason: collision with root package name */
    public static de f3022i = new de();

    /* renamed from: uk  reason: collision with root package name */
    public static JSONObject f3023uk = new JSONObject();

    /* renamed from: ad  reason: collision with root package name */
    public JSONArray f3024ad = new JSONArray();

    /* renamed from: de  reason: collision with root package name */
    public JSONArray f3025de = new JSONArray();

    /* renamed from: fe  reason: collision with root package name */
    public boolean f3026fe = false;
    public JSONArray qw = new JSONArray();

    /* renamed from: rg  reason: collision with root package name */
    public volatile int f3027rg = 0;

    /* renamed from: th  reason: collision with root package name */
    public StatService.WearListener f3028th;

    /* renamed from: yj  reason: collision with root package name */
    public JSONObject f3029yj;

    public static de ppp() {
        return f3022i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void aaa(org.json.JSONObject r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r4.toString()
            boolean r0 = r3.i(r0)
            if (r0 == 0) goto L_0x0017
            com.baidu.mobstat.dxmpay.h r4 = com.baidu.mobstat.dxmpay.h.o()
            java.lang.String r0 = "[WARNING] data to put exceed limit, ignored"
            r4.th(r0)
            return
        L_0x0017:
            org.json.JSONArray r0 = r3.qw
            monitor-enter(r0)
            org.json.JSONArray r1 = r3.qw     // Catch:{ all -> 0x0027 }
            int r1 = r1.length()     // Catch:{ all -> 0x0027 }
            org.json.JSONArray r2 = r3.qw     // Catch:{ JSONException -> 0x0025 }
            r2.put(r1, r4)     // Catch:{ JSONException -> 0x0025 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p007switch.qw.de.aaa(org.json.JSONObject):void");
    }

    public final void ad(Context context, String str, boolean z, boolean z2) {
        StatService.WearListener wearListener = this.f3028th;
        if (wearListener == null || !wearListener.qw(str)) {
            yj.mmm().qqq(context, str, false);
            h o2 = h.o();
            o2.de("Save log: " + str);
            return;
        }
        h o3 = h.o();
        o3.de("Log has been passed to app level, log: " + str);
    }

    public void ddd(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i(jSONObject.toString())) {
                h.o().th("[WARNING] data to put exceed limit, ignored");
                return;
            }
            synchronized (this.f3024ad) {
                fe.qw(this.f3024ad, jSONObject);
            }
        }
    }

    public final void de(Context context, JSONObject jSONObject) {
    }

    public final void fe(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public void ggg(Context context) {
        if (context != null) {
            String str = qqq.c(context) + Config.f885rg;
            if (ppp.th(context, str)) {
                String qw2 = ppp.qw(context, str);
                if (!TextUtils.isEmpty(qw2)) {
                    ppp.de(context, str, new JSONObject().toString(), false);
                    mmm(qw2);
                    pf(context);
                }
            }
        }
    }

    public final boolean i(String str) {
        return (str.getBytes().length + ad.m207if().o()) + this.f3027rg > 184320;
    }

    /* renamed from: if  reason: not valid java name */
    public JSONObject m209if() {
        return this.f3029yj;
    }

    public void mmm(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                aaa(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    public void nn(i iVar) {
        aaa(iVar.qw());
    }

    public void o(Context context) {
        yj(false);
        synchronized (f3023uk) {
            f3023uk = new JSONObject();
        }
        when(context);
        qw(context);
    }

    public void pf(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.qw) {
                jSONObject.put("pr", new JSONArray(this.qw.toString()));
            }
            synchronized (this.f3024ad) {
                jSONObject.put("ev", new JSONArray(this.f3024ad.toString()));
            }
            synchronized (f3023uk) {
                jSONObject.put("he", new JSONObject(f3023uk.toString()));
            }
        } catch (Exception unused) {
        }
        String jSONObject2 = jSONObject.toString();
        if (uk()) {
            h.o().de("[WARNING] stat cache exceed 184320 Bytes, ignored");
            return;
        }
        int length = jSONObject2.getBytes().length;
        if (length >= 184320) {
            yj(true);
            return;
        }
        this.f3027rg = length;
        String c = qqq.c(context);
        ppp.de(context, c + Config.f887yj, jSONObject2, false);
        synchronized (this.f3025de) {
            ppp.de(context, Config.f886th, this.f3025de.toString(), false);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void qqq(android.content.Context r9, boolean r10, boolean r11, long r12, boolean r14, org.json.JSONObject r15) {
        /*
            r8 = this;
            com.baidu.mobstat.dxmpay.CooperService r0 = com.baidu.mobstat.dxmpay.CooperService.qqq()
            fe.fe.switch.qw.rg r0 = r0.uk()
            if (r0 == 0) goto L_0x0036
            org.json.JSONObject r1 = f3023uk
            monitor-enter(r1)
            java.lang.String r2 = r0.f3059th     // Catch:{ all -> 0x0033 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x001b
            org.json.JSONObject r2 = f3023uk     // Catch:{ all -> 0x0033 }
            r0.ad(r9, r2)     // Catch:{ all -> 0x0033 }
            goto L_0x0020
        L_0x001b:
            org.json.JSONObject r2 = f3023uk     // Catch:{ all -> 0x0033 }
            r0.fe(r9, r2)     // Catch:{ all -> 0x0033 }
        L_0x0020:
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = r0.f3059th
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0036
            com.baidu.mobstat.dxmpay.h r9 = com.baidu.mobstat.dxmpay.h.o()
            java.lang.String r10 = "[WARNING] 无法找到有效APP Key, 请参考文档配置"
            r9.uk(r10)
            return
        L_0x0033:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            throw r9
        L_0x0036:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = f3023uk
            monitor-enter(r1)
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0117 }
            org.json.JSONObject r4 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = "at"
            java.lang.String r4 = r4.optString(r5)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r5 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = "uid"
            java.lang.String r5 = r5.optString(r6)     // Catch:{ Exception -> 0x0115 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0115 }
            if (r6 != 0) goto L_0x0086
            java.lang.String r6 = "0"
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x0115 }
            if (r4 == 0) goto L_0x0086
            com.baidu.mobstat.dxmpay.CooperService r4 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r4 = r4.o(r9)     // Catch:{ Exception -> 0x0115 }
            boolean r4 = r5.equals(r4)     // Catch:{ Exception -> 0x0115 }
            if (r4 != 0) goto L_0x0076
            org.json.JSONObject r4 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = "uid_change"
            r4.put(r6, r5)     // Catch:{ Exception -> 0x0115 }
            goto L_0x007f
        L_0x0076:
            org.json.JSONObject r4 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = "uid_change"
            java.lang.String r7 = ""
            r4.put(r6, r7)     // Catch:{ Exception -> 0x0115 }
        L_0x007f:
            com.baidu.mobstat.dxmpay.CooperService r4 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x0115 }
            r4.tt(r9, r5)     // Catch:{ Exception -> 0x0115 }
        L_0x0086:
            org.json.JSONObject r4 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = "t"
            r4.put(r5, r2)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r2 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = "sq"
            if (r10 == 0) goto L_0x0095
            r4 = 0
            goto L_0x0096
        L_0x0095:
            r4 = 1
        L_0x0096:
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r2 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r3 = "ss"
            r2.put(r3, r12)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONArray r12 = r8.f3025de     // Catch:{ Exception -> 0x0115 }
            monitor-enter(r12)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r13 = f3023uk     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = "wl2"
            org.json.JSONArray r3 = r8.f3025de     // Catch:{ all -> 0x0112 }
            r13.put(r2, r3)     // Catch:{ all -> 0x0112 }
            monitor-exit(r12)     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r12 = f3023uk     // Catch:{ Exception -> 0x0115 }
            java.lang.String r13 = "sign"
            com.baidu.mobstat.dxmpay.CooperService r2 = com.baidu.mobstat.dxmpay.CooperService.qqq()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r2.mmm()     // Catch:{ Exception -> 0x0115 }
            r12.put(r13, r2)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r12 = f3023uk     // Catch:{ Exception -> 0x0115 }
            r8.fe(r9, r12, r15)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r12 = "he"
            org.json.JSONObject r13 = f3023uk     // Catch:{ Exception -> 0x0115 }
            r0.put(r12, r13)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONArray r12 = r8.qw     // Catch:{ all -> 0x0117 }
            monitor-enter(r12)     // Catch:{ all -> 0x0117 }
            java.lang.String r13 = "pr"
            org.json.JSONArray r15 = r8.qw     // Catch:{ JSONException -> 0x010d }
            r0.put(r13, r15)     // Catch:{ JSONException -> 0x010d }
            org.json.JSONArray r13 = r8.f3024ad     // Catch:{ all -> 0x010b }
            monitor-enter(r13)     // Catch:{ all -> 0x010b }
            java.lang.String r15 = "ev"
            org.json.JSONArray r2 = r8.f3024ad     // Catch:{ JSONException -> 0x0105 }
            r0.put(r15, r2)     // Catch:{ JSONException -> 0x0105 }
            java.lang.String r15 = "ex"
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ff }
            r2.<init>()     // Catch:{ JSONException -> 0x00ff }
            r0.put(r15, r2)     // Catch:{ JSONException -> 0x00ff }
            r8.rg(r9, r0, r11)     // Catch:{ all -> 0x0103 }
            r8.th(r0)     // Catch:{ all -> 0x0103 }
            r8.de(r9, r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0103 }
            r8.ad(r9, r11, r10, r14)     // Catch:{ all -> 0x0103 }
            r8.f3029yj = r0     // Catch:{ all -> 0x0103 }
            r8.o(r9)     // Catch:{ all -> 0x0103 }
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x00ff:
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0103:
            r9 = move-exception
            goto L_0x0109
        L_0x0105:
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0109:
            monitor-exit(r13)     // Catch:{ all -> 0x0103 }
            throw r9     // Catch:{ all -> 0x010b }
        L_0x010b:
            r9 = move-exception
            goto L_0x0110
        L_0x010d:
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0110:
            monitor-exit(r12)     // Catch:{ all -> 0x010b }
            throw r9     // Catch:{ all -> 0x0117 }
        L_0x0112:
            r9 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0112 }
            throw r9     // Catch:{ Exception -> 0x0115 }
        L_0x0115:
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x0117:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p007switch.qw.de.qqq(android.content.Context, boolean, boolean, long, boolean, org.json.JSONObject):void");
    }

    public final void qw(Context context) {
        synchronized (this.f3024ad) {
            this.f3024ad = new JSONArray();
        }
        synchronized (this.qw) {
            this.qw = new JSONArray();
        }
        synchronized (this.f3025de) {
            this.f3025de = new JSONArray();
        }
        pf(context);
    }

    public final void rg(Context context, JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m210switch(Context context) {
        ppp().xxx(context);
        ppp().vvv(context);
        ppp().ggg(context);
        ppp().when(context);
    }

    public final void th(JSONObject jSONObject) {
    }

    public final boolean uk() {
        return this.f3026fe;
    }

    public void vvv(Context context) {
        if (context != null) {
            String str = qqq.c(context) + Config.f887yj;
            if (ppp.th(context, str)) {
                String qw2 = ppp.qw(context, str);
                if (!TextUtils.isEmpty(qw2)) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(qw2);
                    } catch (Exception unused) {
                    }
                    if (jSONObject != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            JSONArray jSONArray = jSONObject.getJSONArray("pr");
                            if (jSONArray != null) {
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                    if (currentTimeMillis - jSONObject2.getLong("s") <= com.baidu.apollon.statistics.Config.e) {
                                        aaa(jSONObject2);
                                    }
                                }
                            }
                        } catch (Exception unused2) {
                        }
                        try {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("ev");
                            if (jSONArray2 != null) {
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                                    if (currentTimeMillis - jSONObject3.getLong(t.a) <= com.baidu.apollon.statistics.Config.e) {
                                        ddd(context, jSONObject3);
                                    }
                                }
                            }
                        } catch (Exception unused3) {
                        }
                        try {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("he");
                            if (jSONObject4 != null) {
                                synchronized (f3023uk) {
                                    f3023uk = jSONObject4;
                                    q.i().rrr(context, "");
                                }
                            }
                        } catch (Exception unused4) {
                        }
                    }
                }
            }
        }
    }

    public void when(Context context) {
        synchronized (f3023uk) {
            CooperService.qqq().uk().ad(context, f3023uk);
        }
    }

    public void xxx(Context context) {
        if (context == null) {
        }
    }

    public final void yj(boolean z) {
        this.f3026fe = z;
    }
}
