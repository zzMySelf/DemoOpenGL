package com.baidu.sofire.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.g;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class a {
    public static byte[] k = g.a(24);
    public static a l;
    public SharedPreferences a;
    public SharedPreferences.Editor b;
    public SharedPreferences c;
    public SharedPreferences.Editor d;
    public SharedPreferences e;
    public SharedPreferences.Editor f;
    public Context g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public String f1089i = null;
    public Map<String, SharedPreferences> j = new HashMap();

    public a(Context context) {
        SharedPreferences sharedPreferences = null;
        this.g = context;
        int k2 = c.k(context);
        this.h = k2;
        c cVar = new c(this.g, k2 == 1 ? context.getSharedPreferences("leroadcfg", 0) : null, "leroadcfg", false, this.h);
        this.a = cVar;
        SharedPreferences.Editor edit = cVar.edit();
        this.b = edit;
        this.c = this.a;
        this.d = edit;
        c cVar2 = new c(this.g, this.h == 1 ? context.getSharedPreferences("re_po_rt", 0) : sharedPreferences, "re_po_rt", false, this.h);
        this.e = cVar2;
        this.f = cVar2.edit();
    }

    public static synchronized a a(Context context) {
        synchronized (a.class) {
            if (context == null) {
                a aVar = l;
                return aVar;
            }
            if (l == null) {
                l = new a(context);
            }
            a aVar2 = l;
            return aVar2;
        }
    }

    public SharedPreferences b(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.j) {
                sharedPreferences = this.j.get(str);
                if (sharedPreferences == null) {
                    c cVar = new c(this.g, this.h == 1 ? this.g.getSharedPreferences(str, 0) : null, str, false, this.h, (String) null);
                    this.j.put(str, cVar);
                    sharedPreferences = cVar;
                }
            }
            return sharedPreferences;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }

    public void c(int i2) {
        this.b.putInt("wi_fa_pu_ap", i2);
        this.b.commit();
    }

    public String d() {
        return this.c.getString("xyusec", "");
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d.putString("rpnewuidn", "");
            this.d.commit();
            return;
        }
        try {
            this.d.putString("rpnewuidn", new String(Base64.encode(g.b(k, str.getBytes("UTF-8"), true), 10), "UTF-8"));
            this.d.commit();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public List<Integer> f() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (int i2 = 0; i2 < split.length; i2++) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(split[i2])));
                } catch (NumberFormatException e2) {
                    e2.getMessage();
                    int i3 = com.baidu.sofire.a.a.a;
                }
            }
        }
        return arrayList;
    }

    public SharedPreferences g() {
        return this.c;
    }

    public int h() {
        return this.a.getInt("mo_fa_pu_ap", 0);
    }

    public int i() {
        return this.a.getInt("wi_fa_pu_ap", 0);
    }

    public int j() {
        return this.a.getInt("mo_fa_pu_cl", 0);
    }

    public int k() {
        return this.a.getInt("wi_fa_pu_cl", 0);
    }

    public int l() {
        if ("com.baidu.BaiduMap.meizu".equals(this.g.getPackageName())) {
            return this.e.getInt("re_net_hr", 24);
        }
        return this.e.getInt("re_net_hr", 3);
    }

    public int m() {
        return this.a.getInt("rtqe", 0);
    }

    public boolean n() {
        return this.a.getBoolean("bka", true);
    }

    public void d(int i2) {
        this.b.putInt("rtqe", i2);
        this.b.commit();
    }

    public void c(String str) {
        this.d.putString("xyus", str);
        this.d.commit();
    }

    public void d(String str) {
        this.d.putString("xytk_m", str);
        if (Build.VERSION.SDK_INT >= 9) {
            this.d.apply();
        } else {
            this.d.commit();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0149, code lost:
        r7 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x014c, code lost:
        if (r7 == 0) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x014e, code lost:
        if (r7 == 1) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0150, code lost:
        if (r7 == 2) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0152, code lost:
        if (r7 == 3) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0154, code lost:
        if (r7 == 4) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r0.putBoolean(r5, r14.getBoolean("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x015f, code lost:
        r0.putFloat(r5, r14.getFloat("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0167, code lost:
        r0.putLong(r5, r14.getLong("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016f, code lost:
        r0.putInt(r5, r14.getInt("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0177, code lost:
        r0.putString(r5, r14.getString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x017e, code lost:
        r0.apply();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle a(android.os.Bundle r14) {
        /*
            r13 = this;
            java.lang.String r0 = "getString"
            r1 = 0
            int r2 = r13.h     // Catch:{ all -> 0x0182 }
            r3 = 1
            if (r2 == r3) goto L_0x001f
            android.content.Context r0 = r13.g     // Catch:{ all -> 0x0182 }
            int r0 = com.baidu.sofire.l.c.k(r0)     // Catch:{ all -> 0x0182 }
            if (r0 != r3) goto L_0x001e
            com.baidu.sofire.j.a r0 = new com.baidu.sofire.j.a     // Catch:{ all -> 0x0182 }
            android.content.Context r2 = r13.g     // Catch:{ all -> 0x0182 }
            r0.<init>(r2)     // Catch:{ all -> 0x0182 }
            l = r0     // Catch:{ all -> 0x0182 }
            android.os.Bundle r14 = r0.a((android.os.Bundle) r14)     // Catch:{ all -> 0x0182 }
            return r14
        L_0x001e:
            return r1
        L_0x001f:
            java.lang.String r2 = "operation"
            java.lang.String r2 = r14.getString(r2)     // Catch:{ all -> 0x0182 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0182 }
            if (r4 == 0) goto L_0x002c
            return r1
        L_0x002c:
            java.lang.String r4 = "querySharedHandler"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0182 }
            if (r4 == 0) goto L_0x0041
            android.os.Bundle r14 = new android.os.Bundle     // Catch:{ all -> 0x0182 }
            r14.<init>()     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = "handle_platform"
            java.lang.String r2 = "sofire"
            r14.putString(r0, r2)     // Catch:{ all -> 0x0182 }
            return r14
        L_0x0041:
            java.lang.String r4 = "pref_name"
            java.lang.String r4 = r14.getString(r4)     // Catch:{ all -> 0x0182 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0182 }
            if (r5 == 0) goto L_0x004e
            return r1
        L_0x004e:
            java.lang.String r5 = "key"
            java.lang.String r5 = r14.getString(r5)     // Catch:{ all -> 0x0182 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0182 }
            if (r6 == 0) goto L_0x005b
            return r1
        L_0x005b:
            android.content.SharedPreferences r4 = r13.a((java.lang.String) r4)     // Catch:{ all -> 0x0182 }
            java.lang.String r6 = "get"
            boolean r6 = r2.startsWith(r6)     // Catch:{ all -> 0x0182 }
            r7 = 0
            r8 = -1
            r9 = 4
            r10 = 3
            r11 = 2
            if (r6 == 0) goto L_0x0104
            java.lang.String r6 = "defult_value"
            java.lang.String r14 = r14.getString(r6)     // Catch:{ all -> 0x0182 }
            boolean r6 = r0.equals(r2)     // Catch:{ all -> 0x0182 }
            if (r6 != 0) goto L_0x007f
            boolean r6 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0182 }
            if (r6 == 0) goto L_0x007f
            return r1
        L_0x007f:
            if (r4 != 0) goto L_0x0082
            return r1
        L_0x0082:
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x0182 }
            r6.<init>()     // Catch:{ all -> 0x0182 }
            int r12 = r2.hashCode()     // Catch:{ all -> 0x0182 }
            switch(r12) {
                case -1249359687: goto L_0x00b4;
                case -75354382: goto L_0x00aa;
                case 804029191: goto L_0x00a3;
                case 1101572082: goto L_0x0099;
                case 1953351846: goto L_0x008f;
                default: goto L_0x008e;
            }     // Catch:{ all -> 0x0182 }
        L_0x008e:
            goto L_0x00be
        L_0x008f:
            java.lang.String r0 = "getFloat"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0182 }
            if (r0 == 0) goto L_0x00be
            r7 = 3
            goto L_0x00bf
        L_0x0099:
            java.lang.String r0 = "getBoolean"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0182 }
            if (r0 == 0) goto L_0x00be
            r7 = 4
            goto L_0x00bf
        L_0x00a3:
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0182 }
            if (r0 == 0) goto L_0x00be
            goto L_0x00bf
        L_0x00aa:
            java.lang.String r0 = "getLong"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0182 }
            if (r0 == 0) goto L_0x00be
            r7 = 2
            goto L_0x00bf
        L_0x00b4:
            java.lang.String r0 = "getInt"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0182 }
            if (r0 == 0) goto L_0x00be
            r7 = 1
            goto L_0x00bf
        L_0x00be:
            r7 = -1
        L_0x00bf:
            java.lang.String r0 = "result"
            if (r7 == 0) goto L_0x00fc
            if (r7 == r3) goto L_0x00f0
            if (r7 == r11) goto L_0x00e4
            if (r7 == r10) goto L_0x00d8
            if (r7 == r9) goto L_0x00cc
            goto L_0x0103
        L_0x00cc:
            boolean r14 = java.lang.Boolean.parseBoolean(r14)     // Catch:{ all -> 0x0182 }
            boolean r14 = r4.getBoolean(r5, r14)     // Catch:{ all -> 0x0182 }
            r6.putBoolean(r0, r14)     // Catch:{ all -> 0x0182 }
            goto L_0x0103
        L_0x00d8:
            float r14 = java.lang.Float.parseFloat(r14)     // Catch:{ all -> 0x0182 }
            float r14 = r4.getFloat(r5, r14)     // Catch:{ all -> 0x0182 }
            r6.putFloat(r0, r14)     // Catch:{ all -> 0x0182 }
            goto L_0x0103
        L_0x00e4:
            long r2 = java.lang.Long.parseLong(r14)     // Catch:{ all -> 0x0182 }
            long r2 = r4.getLong(r5, r2)     // Catch:{ all -> 0x0182 }
            r6.putLong(r0, r2)     // Catch:{ all -> 0x0182 }
            goto L_0x0103
        L_0x00f0:
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ all -> 0x0182 }
            int r14 = r4.getInt(r5, r14)     // Catch:{ all -> 0x0182 }
            r6.putInt(r0, r14)     // Catch:{ all -> 0x0182 }
            goto L_0x0103
        L_0x00fc:
            java.lang.String r14 = r4.getString(r5, r14)     // Catch:{ all -> 0x0182 }
            r6.putString(r0, r14)     // Catch:{ all -> 0x0182 }
        L_0x0103:
            return r6
        L_0x0104:
            java.lang.String r0 = "put"
            boolean r0 = r2.startsWith(r0)     // Catch:{ all -> 0x0182 }
            if (r0 == 0) goto L_0x0184
            android.content.SharedPreferences$Editor r0 = r4.edit()     // Catch:{ all -> 0x0182 }
            int r4 = r2.hashCode()     // Catch:{ all -> 0x0182 }
            switch(r4) {
                case -976920992: goto L_0x013f;
                case -462997504: goto L_0x0136;
                case -219689429: goto L_0x012c;
                case 478450201: goto L_0x0122;
                case 1773932685: goto L_0x0118;
                default: goto L_0x0117;
            }     // Catch:{ all -> 0x0182 }
        L_0x0117:
            goto L_0x0149
        L_0x0118:
            java.lang.String r4 = "putFloat"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0182 }
            if (r2 == 0) goto L_0x0149
            r7 = 3
            goto L_0x014a
        L_0x0122:
            java.lang.String r4 = "putBoolean"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0182 }
            if (r2 == 0) goto L_0x0149
            r7 = 4
            goto L_0x014a
        L_0x012c:
            java.lang.String r4 = "putLong"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0182 }
            if (r2 == 0) goto L_0x0149
            r7 = 2
            goto L_0x014a
        L_0x0136:
            java.lang.String r4 = "putString"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0182 }
            if (r2 == 0) goto L_0x0149
            goto L_0x014a
        L_0x013f:
            java.lang.String r4 = "putInt"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0182 }
            if (r2 == 0) goto L_0x0149
            r7 = 1
            goto L_0x014a
        L_0x0149:
            r7 = -1
        L_0x014a:
            java.lang.String r2 = "value"
            if (r7 == 0) goto L_0x0177
            if (r7 == r3) goto L_0x016f
            if (r7 == r11) goto L_0x0167
            if (r7 == r10) goto L_0x015f
            if (r7 == r9) goto L_0x0157
            goto L_0x017e
        L_0x0157:
            boolean r14 = r14.getBoolean(r2)     // Catch:{ all -> 0x0182 }
            r0.putBoolean(r5, r14)     // Catch:{ all -> 0x0182 }
            goto L_0x017e
        L_0x015f:
            float r14 = r14.getFloat(r2)     // Catch:{ all -> 0x0182 }
            r0.putFloat(r5, r14)     // Catch:{ all -> 0x0182 }
            goto L_0x017e
        L_0x0167:
            long r2 = r14.getLong(r2)     // Catch:{ all -> 0x0182 }
            r0.putLong(r5, r2)     // Catch:{ all -> 0x0182 }
            goto L_0x017e
        L_0x016f:
            int r14 = r14.getInt(r2)     // Catch:{ all -> 0x0182 }
            r0.putInt(r5, r14)     // Catch:{ all -> 0x0182 }
            goto L_0x017e
        L_0x0177:
            java.lang.String r14 = r14.getString(r2)     // Catch:{ all -> 0x0182 }
            r0.putString(r5, r14)     // Catch:{ all -> 0x0182 }
        L_0x017e:
            r0.apply()     // Catch:{ all -> 0x0182 }
            goto L_0x0184
        L_0x0182:
            int r14 = com.baidu.sofire.a.a.a
        L_0x0184:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.j.a.a(android.os.Bundle):android.os.Bundle");
    }

    public List<com.baidu.sofire.f.a> c() {
        String string = this.e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.sofire.f.a aVar = new com.baidu.sofire.f.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    aVar.a = jSONObject.optString("0");
                    aVar.c = jSONObject.optString("1");
                    aVar.d = jSONObject.optString("2");
                    aVar.e = jSONObject.optString("3");
                    aVar.b = jSONObject.optString("4");
                    aVar.f = jSONObject.optString(BannerBaseItemInfo.TYPE_LOGIN);
                } catch (Exception unused) {
                    int i2 = com.baidu.sofire.a.a.a;
                    aVar = null;
                }
                if (aVar != null) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public List<Integer> e() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (int i2 = 0; i2 < split.length; i2++) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(split[i2])));
                } catch (NumberFormatException e2) {
                    e2.getMessage();
                    int i3 = com.baidu.sofire.a.a.a;
                }
            }
        }
        return arrayList;
    }

    public void b(int i2) {
        this.b.putInt("mo_fa_pu_ap", i2);
        this.b.commit();
    }

    public void b(long j2) {
        this.f.putLong("re_day_len", j2);
        this.f.commit();
    }

    public boolean b() {
        return this.a.getBoolean("s_c_c", true);
    }

    public final SharedPreferences a(String str) {
        if (str.equals("leroadcfg")) {
            return this.a;
        }
        if (str.equals("leroadcfg")) {
            return this.c;
        }
        if (str.equals("re_po_rt")) {
            return this.e;
        }
        return b(str);
    }

    public void a(int i2) {
        if (i2 > this.a.getInt("opi", 0)) {
            this.b.putInt("opi", i2);
            this.b.commit();
        }
    }

    public String a() {
        return this.c.getString("xyus", "");
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.b.putString("hcpk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                sb.append(iArr[i2]);
                if (i2 != iArr.length - 1) {
                    sb.append("-");
                }
            }
            this.b.putString("hcpk", sb.toString());
        }
        this.b.commit();
    }

    public void a(List<Integer> list) {
        if (list.size() == 0) {
            this.b.putString("glspk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append("-");
                }
            }
            this.b.putString("glspk", sb.toString());
        }
        this.b.commit();
    }

    public void a(long j2) {
        this.f.putLong("re_day_b_t", j2);
        this.f.commit();
    }

    public void a(boolean z) {
        this.b.putBoolean("s_c_c", z);
        if (Build.VERSION.SDK_INT >= 9) {
            this.b.apply();
        } else {
            this.b.commit();
        }
    }
}
