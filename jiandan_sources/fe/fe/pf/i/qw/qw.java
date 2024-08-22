package fe.fe.pf.i.qw;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.helios.trusts.zone.TrustSubject;
import fe.fe.pf.yj.fe.de.rg;
import fe.fe.pf.yj.rg.qw;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class qw extends BaseIdProvider {

    /* renamed from: fe  reason: collision with root package name */
    public qw.C0142qw f2796fe;

    /* renamed from: rg  reason: collision with root package name */
    public ad f2797rg = new ad();

    public class ad {

        /* renamed from: ad  reason: collision with root package name */
        public String f2798ad;

        /* renamed from: de  reason: collision with root package name */
        public String f2799de;

        /* renamed from: fe  reason: collision with root package name */
        public long f2800fe;
        public byte[] qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f2802rg = true;

        /* renamed from: th  reason: collision with root package name */
        public String f2803th;

        /* renamed from: uk  reason: collision with root package name */
        public long f2804uk;

        /* renamed from: yj  reason: collision with root package name */
        public rg f2805yj = new rg();

        public ad() {
        }

        public long ad(long j) {
            return this.f2805yj.qw(j);
        }

        public String de() {
            return this.f2799de;
        }

        public long fe() {
            return this.f2804uk;
        }

        public void i(long j, long j2) {
            if (this.f2805yj.de(j, j2)) {
                this.f2802rg = true;
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m192if(long j) {
            if (this.f2804uk != j) {
                this.f2804uk = j;
                this.f2802rg = true;
            }
        }

        public void o(String str) {
            String str2 = this.f2799de;
            if (str2 != str) {
                if (str == null || !str.equals(str2)) {
                    this.f2799de = str;
                    this.f2802rg = true;
                }
            }
        }

        public void pf(long j) {
            if (j != this.f2800fe) {
                this.f2800fe = j;
                this.f2802rg = true;
            }
        }

        public String qw() {
            return this.f2798ad;
        }

        public byte[] rg() {
            return this.qw;
        }

        /* renamed from: switch  reason: not valid java name */
        public void m193switch(String str) {
            String str2 = this.f2803th;
            if (str != str2) {
                if (str == null || !str.equals(str2)) {
                    this.f2803th = str;
                    this.f2802rg = true;
                }
            }
        }

        public boolean th() {
            if (this.f2802rg) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("and_id", this.f2798ad);
                    jSONObject.put("form_id", this.f2799de);
                    jSONObject.put("gen_ts", this.f2800fe);
                    jSONObject.put("flags", this.f2805yj.fe());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.f2803th)) {
                        jSONObject.put("ran_id", this.f2803th);
                    }
                    if (this.qw != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.qw, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.f2804uk);
                    qw.this.f2796fe.i("aid.dat", jSONObject.toString(), true);
                    this.f2802rg = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void uk(String str) {
            String str2 = this.f2798ad;
            if (str != str2) {
                if (str == null || !str.equals(str2)) {
                    this.f2798ad = str;
                    this.f2802rg = true;
                }
            }
        }

        public void when(byte[] bArr) {
            if (!Arrays.equals(bArr, this.qw)) {
                this.qw = bArr;
                this.f2802rg = true;
            }
        }

        public boolean yj() {
            String yj2 = qw.this.f2796fe.yj("aid.dat", true);
            if (!TextUtils.isEmpty(yj2)) {
                try {
                    JSONObject jSONObject = new JSONObject(yj2);
                    this.qw = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.f2800fe = jSONObject.getLong("gen_ts");
                    this.f2799de = jSONObject.getString("form_id");
                    this.f2798ad = jSONObject.getString("and_id");
                    this.f2803th = jSONObject.optString("ran_id", (String) null);
                    this.f2805yj.ad(jSONObject.getLong("flags"));
                    this.f2804uk = jSONObject.getLong("lst_conf_ver");
                    jSONObject.getInt("c_form_ver");
                    this.f2802rg = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* renamed from: fe.fe.pf.i.qw.qw$qw  reason: collision with other inner class name */
    public static class C0129qw {

        /* renamed from: ad  reason: collision with root package name */
        public HashSet<String> f2806ad = new HashSet<>();
        public HashSet<String> qw = new HashSet<>();

        public static C0129qw de(TrustSubject trustSubject) {
            try {
                String i2 = trustSubject.i("config-aid");
                if (TextUtils.isEmpty(i2)) {
                    return null;
                }
                try {
                    C0129qw qwVar = new C0129qw();
                    JSONObject jSONObject = new JSONObject(i2);
                    JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            qwVar.qw.add(optJSONArray.getString(i3));
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i4 = 0; i4 < length2; i4++) {
                            qwVar.f2806ad.add(optJSONArray2.getString(i4));
                        }
                    }
                    return qwVar;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (TrustSubject.ConfigNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public boolean ad(String str) {
            return this.f2806ad.contains(str);
        }

        public boolean qw(String str) {
            return this.qw.contains(str);
        }
    }

    public qw() {
        super("aid");
    }

    public static String i(byte[] bArr) {
        return BaseIdProvider.ad("A00", new fe.fe.pf.yj.fe.de.ad("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).ad(bArr));
    }

    public String de() {
        return this.f2797rg.de();
    }

    public byte[] fe() {
        return this.f2797rg.rg();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0097, code lost:
        if (r13.ad(r6) != false) goto L_0x0083;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(com.baidu.helios.ids.BaseIdProvider.de r13) {
        /*
            r12 = this;
            fe.fe.pf.yj.rg.qw$qw r13 = r12.qw
            java.lang.String r0 = "aid"
            fe.fe.pf.yj.rg.qw$qw r13 = r13.th(r0)
            r12.f2796fe = r13
            fe.fe.pf.i.qw.qw$ad r13 = r12.f2797rg
            r13.yj()
            com.baidu.helios.ids.BaseIdProvider$ad r13 = r12.f813ad
            com.baidu.helios.trusts.zone.TrustSubjectManager$th r13 = r13.f816de
            com.baidu.helios.trusts.zone.TrustSubject r13 = r13.f859ad
            r0 = 0
            r2 = 0
            r3 = 1
            if (r13 == 0) goto L_0x002b
            long r4 = r13.pf()
            fe.fe.pf.i.qw.qw$ad r6 = r12.f2797rg
            long r6 = r6.fe()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x002c
            r6 = 1
            goto L_0x002d
        L_0x002b:
            r4 = r0
        L_0x002c:
            r6 = 0
        L_0x002d:
            fe.fe.pf.i.qw.qw$ad r7 = r12.f2797rg
            java.lang.String r7 = r7.de()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0050
            fe.fe.pf.i.qw.qw$ad r7 = r12.f2797rg
            byte[] r7 = r7.rg()
            if (r7 == 0) goto L_0x0050
            fe.fe.pf.i.qw.qw$ad r7 = r12.f2797rg
            java.lang.String r7 = r7.qw()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = 1
        L_0x0051:
            if (r7 != 0) goto L_0x0056
            if (r6 != 0) goto L_0x0056
            return
        L_0x0056:
            r6 = 0
            if (r13 == 0) goto L_0x005e
            fe.fe.pf.i.qw.qw$qw r13 = fe.fe.pf.i.qw.qw.C0129qw.de(r13)
            goto L_0x005f
        L_0x005e:
            r13 = r6
        L_0x005f:
            com.baidu.helios.ids.BaseIdProvider$ad r8 = r12.f813ad
            android.content.Context r8 = r8.qw
            android.content.ContentResolver r8 = r8.getContentResolver()
            java.lang.String r9 = "android_id"
            java.lang.String r6 = com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper.getStringFromSettingSecure(r8, r9)     // Catch:{ all -> 0x006e }
            goto L_0x006f
        L_0x006e:
        L_0x006f:
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L_0x0077
            java.lang.String r6 = "000000000"
        L_0x0077:
            r8 = 1
            if (r7 == 0) goto L_0x0087
            if (r13 == 0) goto L_0x0085
            boolean r13 = r13.qw(r6)
            if (r13 == 0) goto L_0x0085
        L_0x0083:
            r2 = 1
            goto L_0x009b
        L_0x0085:
            r2 = 1
            goto L_0x009a
        L_0x0087:
            if (r13 == 0) goto L_0x009a
            fe.fe.pf.i.qw.qw$ad r7 = r12.f2797rg
            long r10 = r7.ad(r8)
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x009a
            boolean r13 = r13.ad(r6)
            if (r13 == 0) goto L_0x009a
            goto L_0x0083
        L_0x009a:
            r3 = 0
        L_0x009b:
            if (r2 == 0) goto L_0x00f3
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "com.helios"
            r13.append(r0)
            r13.append(r6)
            java.lang.String r13 = r13.toString()
            if (r3 == 0) goto L_0x00d1
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            fe.fe.pf.i.qw.qw$ad r1 = r12.f2797rg
            r1.m193switch(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            r1.append(r0)
            java.lang.String r13 = r1.toString()
            fe.fe.pf.i.qw.qw$ad r0 = r12.f2797rg
            r0.i(r8, r8)
        L_0x00d1:
            java.lang.String r0 = "utf-8"
            byte[] r13 = fe.fe.pf.yj.fe.de.th.qw(r13, r0)
            java.lang.String r0 = i(r13)
            fe.fe.pf.i.qw.qw$ad r1 = r12.f2797rg
            r1.when(r13)
            fe.fe.pf.i.qw.qw$ad r13 = r12.f2797rg
            long r1 = java.lang.System.currentTimeMillis()
            r13.pf(r1)
            fe.fe.pf.i.qw.qw$ad r13 = r12.f2797rg
            r13.uk(r6)
            fe.fe.pf.i.qw.qw$ad r13 = r12.f2797rg
            r13.o(r0)
        L_0x00f3:
            fe.fe.pf.i.qw.qw$ad r13 = r12.f2797rg
            r13.m192if(r4)
            fe.fe.pf.i.qw.qw$ad r13 = r12.f2797rg
            r13.th()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.i.qw.qw.th(com.baidu.helios.ids.BaseIdProvider$de):void");
    }
}
