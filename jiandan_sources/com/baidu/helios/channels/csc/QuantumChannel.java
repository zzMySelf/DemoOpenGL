package com.baidu.helios.channels.csc;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.helios.channels.csc.d;
import com.baidu.sapi2.SapiAccount;
import fe.fe.pf.rg.ad.qw;
import fe.fe.pf.rg.qw;
import fe.fe.pf.yj.rg.qw;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.json.JSONObject;

public class QuantumChannel extends fe.fe.pf.rg.qw {

    /* renamed from: o  reason: collision with root package name */
    public static final int f788o = fe.fe.pf.rg.ad.qw.qw(160);

    /* renamed from: pf  reason: collision with root package name */
    public static final int f789pf = fe.fe.pf.rg.ad.qw.qw(8);

    /* renamed from: i  reason: collision with root package name */
    public ad f790i;

    /* renamed from: th  reason: collision with root package name */
    public qw.C0142qw f791th;

    /* renamed from: uk  reason: collision with root package name */
    public rg f792uk;

    /* renamed from: yj  reason: collision with root package name */
    public de f793yj = new de();

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public String f794ad;

        /* renamed from: de  reason: collision with root package name */
        public String f795de;
        public String qw;

        public ad() {
            fe.fe.pf.yj.de.ad adVar = new fe.fe.pf.yj.de.ad();
            try {
                this.qw = new String(adVar.qw(fe.fe.pf.rg.ad.ad.rg()), "UTF-8");
                this.f794ad = new String(adVar.qw(fe.fe.pf.rg.ad.ad.th()), "UTF-8");
                this.f795de = new String(adVar.qw(fe.fe.pf.rg.ad.ad.yj()), "UTF-8");
            } catch (Exception unused) {
                throw new IllegalStateException("");
            }
        }
    }

    public static class b extends Exception {
        public b(String str) {
            super(str);
        }

        public b(String str, Throwable th2) {
            super(str, th2);
        }

        public b(Throwable th2) {
            super(th2);
        }
    }

    public class de {

        /* renamed from: ad  reason: collision with root package name */
        public long f796ad;

        /* renamed from: de  reason: collision with root package name */
        public fe.fe.pf.yj.fe.de.rg f797de = new fe.fe.pf.yj.fe.de.rg();

        /* renamed from: fe  reason: collision with root package name */
        public long f798fe;
        public int qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f799rg;

        /* renamed from: th  reason: collision with root package name */
        public boolean f800th = true;

        public de() {
        }

        public void ad(int i2) {
            if (this.qw != i2) {
                this.qw = i2;
                this.f800th = true;
            }
        }

        public void de(long j) {
            if (this.f796ad != j) {
                this.f796ad = j;
                this.f800th = true;
            }
        }

        public boolean fe(long j, long j2) {
            if (!this.f797de.de(j, j2)) {
                return false;
            }
            this.f800th = true;
            return true;
        }

        public String i() {
            return this.f799rg;
        }

        public void o() {
            String yj2 = QuantumChannel.this.f791th.yj("pub.dat", true);
            if (!TextUtils.isEmpty(yj2)) {
                try {
                    JSONObject jSONObject = new JSONObject(yj2);
                    this.qw = jSONObject.getInt("pub_ver");
                    this.f796ad = jSONObject.getLong("pub_lst_ts");
                    this.f798fe = jSONObject.getLong("pkg_lst_up_ts");
                    this.f797de.ad(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.f799rg = jSONObject.optString("aid");
                    this.f800th = false;
                } catch (Exception unused) {
                    this.f800th = true;
                }
            }
        }

        public boolean pf() {
            if (this.f800th) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_ver", this.qw);
                    jSONObject.put("pub_lst_ts", this.f796ad);
                    jSONObject.put("pkg_lst_up_ts", this.f798fe);
                    jSONObject.put("flags", this.f797de.fe());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.f799rg);
                    QuantumChannel.this.f791th.i("pub.dat", jSONObject.toString(), true);
                    this.f800th = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public int qw() {
            return this.qw;
        }

        public boolean rg(String str) {
            String str2 = this.f799rg;
            if (str2 == str) {
                return false;
            }
            if (str != null && str.equals(str2)) {
                return false;
            }
            this.f800th = true;
            this.f799rg = str;
            return true;
        }

        public long th(long j) {
            return this.f797de.qw(j);
        }

        public boolean uk(long j) {
            if (this.f798fe == j) {
                return false;
            }
            this.f798fe = j;
            this.f800th = true;
            return true;
        }

        public long yj() {
            return this.f798fe;
        }
    }

    public static class fe {

        /* renamed from: ad  reason: collision with root package name */
        public byte[] f802ad;
        public qw.C0132qw qw;

        public static class qw {

            /* renamed from: ad  reason: collision with root package name */
            public byte[] f803ad = new byte[160];

            /* renamed from: de  reason: collision with root package name */
            public int f804de;
            public int qw = 160;

            public fe ad() {
                return new fe(Arrays.copyOf(this.f803ad, this.f804de));
            }

            public final void de(int i2) {
                byte[] bArr = this.f803ad;
                if (i2 - bArr.length > 0) {
                    int length = bArr.length;
                    int i3 = length + (length >> 1);
                    if (i3 - i2 >= 0) {
                        i2 = i3;
                    }
                    this.f803ad = Arrays.copyOf(this.f803ad, i2);
                }
            }

            public qw qw(byte b) {
                de(this.f804de + 1);
                byte[] bArr = this.f803ad;
                int i2 = this.f804de;
                this.f804de = i2 + 1;
                bArr[i2] = b;
                return this;
            }
        }

        public fe(byte[] bArr) {
            this.f802ad = bArr;
            this.qw = fe.fe.pf.rg.ad.qw.ad(bArr);
        }

        public static int ad(byte b) {
            if (b == 0) {
                return 0;
            }
            if (b == 1) {
                return 1;
            }
            if (b == 2) {
                return 2;
            }
            throw new IllegalStateException();
        }

        public static fe fe(byte[] bArr, int i2) {
            return new fe(fe.fe.pf.rg.ad.qw.de(bArr, i2));
        }

        public static byte rg(int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
            throw new g("unexpected value " + i2);
        }

        public int de(int i2) {
            if (i2 >= 0) {
                byte[] bArr = this.f802ad;
                if (i2 < bArr.length) {
                    return ad(bArr[i2]);
                }
            }
            throw new IllegalArgumentException("illegal index " + i2 + " with current length is " + this.f802ad.length);
        }

        public int qw() {
            return this.f802ad.length;
        }

        public byte[] th() {
            return this.qw.qw();
        }
    }

    public static class g extends Exception {
        public g(String str) {
            super(str);
        }

        public g(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public static class rg {

        /* renamed from: ad  reason: collision with root package name */
        public Method f805ad;

        /* renamed from: de  reason: collision with root package name */
        public Method f806de;

        /* renamed from: fe  reason: collision with root package name */
        public Class<?> f807fe;
        public Method qw;

        public rg(Context context) {
            try {
                fe(context);
            } catch (Exception e) {
                throw new IllegalStateException("charset = " + Charset.defaultCharset(), e);
            }
        }

        public Object ad(Context context) {
            try {
                return this.f806de.invoke(context, new Object[0]);
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public void de(Object obj, Object obj2, int i2) {
            try {
                this.qw.invoke(obj, new Object[]{obj2, Integer.valueOf(i2), 1});
            } catch (Exception unused) {
                throw new d.a("");
            }
        }

        public final void fe(Context context) {
            Method fe2 = d.fe(Context.class, d.de(fe.fe.pf.rg.ad.ad.de()), (Class<?>[]) null);
            this.f806de = fe2;
            Object invoke = fe2.invoke(context, new Object[0]);
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "");
            this.f807fe = d.fe(intent.getClass(), d.de(fe.fe.pf.rg.ad.ad.fe()), (Class<?>[]) null).invoke(intent, new Object[0]).getClass();
            String de2 = d.de(fe.fe.pf.rg.ad.ad.qw());
            Class<?> cls = invoke.getClass();
            Class cls2 = Integer.TYPE;
            this.qw = d.fe(cls, de2, new Class[]{this.f807fe, cls2, cls2});
            String de3 = d.de(fe.fe.pf.rg.ad.ad.ad());
            this.f805ad = d.fe(invoke.getClass(), de3, new Class[]{this.f807fe});
        }

        public int qw(Object obj, Object obj2) {
            try {
                return ((Integer) this.f805ad.invoke(obj, new Object[]{obj2})).intValue();
            } catch (Exception unused) {
                throw new d.a("");
            }
        }
    }

    public class th extends qw.de {

        /* renamed from: fe  reason: collision with root package name */
        public String f808fe;

        /* renamed from: rg  reason: collision with root package name */
        public int f809rg;

        /* renamed from: th  reason: collision with root package name */
        public long f810th;

        /* renamed from: yj  reason: collision with root package name */
        public String f811yj;

        public th(QuantumChannel quantumChannel, String str) {
            super(quantumChannel.f791th, str);
        }

        public void de(JSONObject jSONObject) {
            this.f808fe = jSONObject.getString(SapiAccount.ExtraProperty.EXTRA_PKG);
            this.f809rg = jSONObject.getInt("aid_ver");
            this.f810th = jSONObject.getLong("last_fe_ts");
            this.f811yj = jSONObject.getString("id");
            jSONObject.getInt("d_form_ver");
        }

        public void i(String str) {
            if (!str.equals(this.f808fe)) {
                this.f808fe = str;
                qw(true);
            }
        }

        /* renamed from: if  reason: not valid java name */
        public String m18if() {
            return this.f811yj;
        }

        public int o() {
            return this.f809rg;
        }

        public void pf(String str) {
            if (!str.equals(this.f811yj)) {
                this.f811yj = str;
                qw(true);
            }
        }

        public void rg(JSONObject jSONObject) {
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.f808fe);
            jSONObject.put("aid_ver", this.f809rg);
            jSONObject.put("last_fe_ts", this.f810th);
            jSONObject.put("id", this.f811yj);
            jSONObject.put("d_form_ver", 1);
        }

        public String th() {
            return this.f808fe;
        }

        public void uk(long j) {
            if (this.f810th != j) {
                this.f810th = j;
                qw(true);
            }
        }

        public void yj(int i2) {
            if (this.f809rg != i2) {
                this.f809rg = i2;
                qw(true);
            }
        }
    }

    public QuantumChannel() {
        super("csc", 9000000);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x009d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00ab */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:56:0x00ab=Splitter:B:56:0x00ab, B:49:0x009d=Splitter:B:49:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.fe.pf.rg.qw.uk ad(java.lang.String r9, fe.fe.pf.rg.qw.yj r10) {
        /*
            r8 = this;
            r0 = -101(0xffffffffffffff9b, float:NaN)
            r1 = 0
            com.baidu.helios.channels.csc.QuantumChannel$rg r2 = r8.f792uk     // Catch:{ a -> 0x00d2 }
            fe.fe.pf.rg.qw$ad r3 = r8.qw     // Catch:{ a -> 0x00d2 }
            android.content.Context r3 = r3.qw     // Catch:{ a -> 0x00d2 }
            java.lang.Object r2 = r2.ad(r3)     // Catch:{ a -> 0x00d2 }
            if (r2 != 0) goto L_0x0014
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.de(r0, r1)
            return r9
        L_0x0014:
            boolean r3 = r10.qw
            r4 = -102(0xffffffffffffff9a, float:NaN)
            if (r3 == 0) goto L_0x0055
            com.baidu.helios.channels.csc.QuantumChannel$th r3 = new com.baidu.helios.channels.csc.QuantumChannel$th
            r3.<init>(r8, r9)
            r3.fe()
            java.lang.String r5 = r3.th()
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0056
            int r5 = r8.i(r2, r9)     // Catch:{ b -> 0x004f, a -> 0x004a, g -> 0x0045 }
            int r6 = r3.o()     // Catch:{ b -> 0x004f, a -> 0x004a, g -> 0x0045 }
            if (r6 != r5) goto L_0x0056
            java.lang.String r5 = r3.m18if()     // Catch:{ b -> 0x004f, a -> 0x004a, g -> 0x0045 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ b -> 0x004f, a -> 0x004a, g -> 0x0045 }
            if (r6 != 0) goto L_0x0056
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.th(r5)     // Catch:{ b -> 0x004f, a -> 0x004a, g -> 0x0045 }
            return r9
        L_0x0045:
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.ad(r4)
            return r9
        L_0x004a:
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.de(r0, r1)
            return r9
        L_0x004f:
            r9 = move-exception
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.fe(r9)
            return r9
        L_0x0055:
            r3 = r1
        L_0x0056:
            r0 = -2
            boolean r5 = r8.ggg(r2, r9)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            if (r5 != 0) goto L_0x006b
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.de(r0, r1)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            boolean r10 = r10.qw
            if (r10 == 0) goto L_0x006a
            if (r3 == 0) goto L_0x006a
            r3.ad()
        L_0x006a:
            return r9
        L_0x006b:
            byte[] r5 = r8.ppp(r2, r9)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            java.lang.String r5 = fe.fe.pf.i.qw.qw.i(r5)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            int r2 = r8.i(r2, r9)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            boolean r6 = r10.qw     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            if (r6 == 0) goto L_0x008d
            if (r3 == 0) goto L_0x008d
            r3.pf(r5)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            r3.i(r9)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            r3.uk(r6)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            r3.yj(r2)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
        L_0x008d:
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.th(r5)     // Catch:{ b -> 0x00b9, a -> 0x00ab, g -> 0x009d }
            boolean r10 = r10.qw
            if (r10 == 0) goto L_0x009a
            if (r3 == 0) goto L_0x009a
            r3.ad()
        L_0x009a:
            return r9
        L_0x009b:
            r9 = move-exception
            goto L_0x00c8
        L_0x009d:
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.ad(r4)     // Catch:{ all -> 0x009b }
            boolean r10 = r10.qw
            if (r10 == 0) goto L_0x00aa
            if (r3 == 0) goto L_0x00aa
            r3.ad()
        L_0x00aa:
            return r9
        L_0x00ab:
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.de(r0, r1)     // Catch:{ all -> 0x009b }
            boolean r10 = r10.qw
            if (r10 == 0) goto L_0x00b8
            if (r3 == 0) goto L_0x00b8
            r3.ad()
        L_0x00b8:
            return r9
        L_0x00b9:
            r9 = move-exception
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.fe(r9)     // Catch:{ all -> 0x009b }
            boolean r10 = r10.qw
            if (r10 == 0) goto L_0x00c7
            if (r3 == 0) goto L_0x00c7
            r3.ad()
        L_0x00c7:
            return r9
        L_0x00c8:
            boolean r10 = r10.qw
            if (r10 == 0) goto L_0x00d1
            if (r3 == 0) goto L_0x00d1
            r3.ad()
        L_0x00d1:
            throw r9
        L_0x00d2:
            fe.fe.pf.rg.qw$uk r9 = fe.fe.pf.rg.qw.uk.de(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.helios.channels.csc.QuantumChannel.ad(java.lang.String, fe.fe.pf.rg.qw$yj):fe.fe.pf.rg.qw$uk");
    }

    public final boolean ggg(Object obj, String str) {
        return uk(obj, pf(str)) == 1;
    }

    public final int i(Object obj, String str) {
        fe.qw qwVar = new fe.qw();
        for (int i2 = 0; i2 < f789pf; i2++) {
            qwVar.qw(fe.rg(uk(obj, when(str, i2))));
        }
        byte[] th2 = qwVar.ad().th();
        int i3 = 0;
        for (int i4 = 0; i4 < th2.length; i4++) {
            i3 |= (th2[i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    /* renamed from: if  reason: not valid java name */
    public final Object m16if(String str, int i2) {
        try {
            Class<?> cls = this.f792uk.f807fe;
            return d.ad(cls, new Object[]{str, this.f790i.qw + i2});
        } catch (Exception e) {
            e.printStackTrace();
            throw new b("");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
        r1 = -101;
        r2 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0168, code lost:
        return fe.fe.pf.rg.qw.th.ad(-102);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x0176 */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[ExcHandler: a (unused com.baidu.helios.channels.csc.d$a), SYNTHETIC, Splitter:B:34:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.fe.pf.rg.qw.th o(fe.fe.pf.rg.qw.rg r19) {
        /*
            r18 = this;
            r0 = r18
            fe.fe.pf.rg.qw$ad r1 = r0.qw
            android.content.Context r1 = r1.qw
            android.content.pm.PackageManager r2 = r1.getPackageManager()
            java.lang.String r3 = r1.getPackageName()
            java.lang.String r4 = r1.getPackageName()     // Catch:{ NameNotFoundException -> 0x019b }
            r5 = 0
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x019b }
            long r6 = r2.lastUpdateTime
            com.baidu.helios.channels.csc.QuantumChannel$de r4 = r0.f793yj
            long r8 = r4.yj()
            r4 = 1
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0026
            r6 = 1
            goto L_0x0027
        L_0x0026:
            r6 = 0
        L_0x0027:
            com.baidu.helios.channels.csc.QuantumChannel$de r7 = r0.f793yj
            long r8 = r2.lastUpdateTime
            r7.uk(r8)
            r2 = -101(0xffffffffffffff9b, float:NaN)
            r7 = 4
            r9 = 6
            if (r6 != 0) goto L_0x0045
            com.baidu.helios.channels.csc.QuantumChannel$de r6 = r0.f793yj
            long r11 = r6.th(r9)
            int r6 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0045
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r2)
            return r1
        L_0x0045:
            fe.fe.pf.rg.qw$ad r6 = r0.qw
            com.baidu.helios.ids.IdProviderFactory r6 = r6.f2863de
            java.lang.String r11 = "aid"
            com.baidu.helios.ids.BaseIdProvider r6 = r6.qw(r11)
            r11 = -102(0xffffffffffffff9a, float:NaN)
            com.baidu.helios.channels.csc.QuantumChannel$rg r12 = r0.f792uk     // Catch:{ a -> 0x0196 }
            java.lang.Object r1 = r12.ad(r1)     // Catch:{ a -> 0x0196 }
            if (r1 != 0) goto L_0x005e
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r11)
            return r1
        L_0x005e:
            r12 = -103(0xffffffffffffff99, float:NaN)
            com.baidu.helios.channels.csc.QuantumChannel$de r13 = r0.f793yj     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            r14 = 1
            long r16 = r13.th(r14)     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            int r13 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r13 != 0) goto L_0x0095
            com.baidu.helios.channels.csc.QuantumChannel$de r13 = r0.f793yj     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            java.lang.String r13 = r13.i()     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            if (r13 == 0) goto L_0x0095
            java.lang.String r5 = r6.de()     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            boolean r5 = r13.equals(r5)     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            if (r5 == 0) goto L_0x0095
            boolean r5 = r0.ggg(r1, r3)     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            if (r5 == 0) goto L_0x0095
            int r5 = r0.i(r1, r3)     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            com.baidu.helios.channels.csc.QuantumChannel$de r13 = r0.f793yj     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            int r13 = r13.qw()     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            if (r13 != r5) goto L_0x0095
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.fe()     // Catch:{ b -> 0x0188, a -> 0x0183, g -> 0x0176 }
            return r1
        L_0x0095:
            byte[] r5 = r6.fe()
            com.baidu.helios.channels.csc.QuantumChannel$de r13 = r0.f793yj
            java.lang.String r6 = r6.de()
            r13.rg(r6)
            int r6 = r5.length
            r13 = 8
            int r6 = r6 * 8
            com.baidu.helios.channels.csc.QuantumChannel$fe r5 = com.baidu.helios.channels.csc.QuantumChannel.fe.fe(r5, r6)
            int r6 = r5.qw()     // Catch:{ b -> 0x0169, a -> 0x0164 }
            r2 = 0
        L_0x00b0:
            if (r2 >= r6) goto L_0x00c8
            int r7 = r5.de(r2)     // Catch:{ b -> 0x00c2, a -> 0x0164 }
            java.lang.Object r8 = r0.m16if(r3, r2)     // Catch:{ b -> 0x00c2, a -> 0x0164 }
            r0.m17switch(r1, r8, r7)     // Catch:{ b -> 0x00c2, a -> 0x0164 }
            int r2 = r2 + 1
            r7 = 4
            goto L_0x00b0
        L_0x00c2:
            r1 = -101(0xffffffffffffff9b, float:NaN)
            r2 = 4
            goto L_0x016c
        L_0x00c8:
            java.util.Random r2 = new java.util.Random
            r2.<init>()
            r5 = 255(0xff, float:3.57E-43)
            int r2 = r2.nextInt(r5)
            com.baidu.helios.channels.csc.QuantumChannel$de r6 = r0.f793yj
            r6.ad(r2)
            byte[] r6 = new byte[r4]
            r7 = 0
        L_0x00db:
            if (r7 >= r4) goto L_0x00e8
            int r8 = r7 * 8
            int r8 = r2 >> r8
            r8 = r8 & r5
            byte r8 = (byte) r8
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x00db
        L_0x00e8:
            com.baidu.helios.channels.csc.QuantumChannel$fe r5 = com.baidu.helios.channels.csc.QuantumChannel.fe.fe(r6, r13)
            int r6 = r5.qw()     // Catch:{ b -> 0x0156, a -> 0x0151 }
            r7 = 0
        L_0x00f1:
            if (r7 >= r6) goto L_0x0101
            int r8 = r5.de(r7)     // Catch:{ b -> 0x0156, a -> 0x0151 }
            java.lang.Object r13 = r0.when(r3, r7)     // Catch:{ b -> 0x0156, a -> 0x0151 }
            r0.m17switch(r1, r13, r8)     // Catch:{ b -> 0x0156, a -> 0x0151 }
            int r7 = r7 + 1
            goto L_0x00f1
        L_0x0101:
            int r5 = r0.i(r1, r3)     // Catch:{ b -> 0x0143, a -> 0x013e, g -> 0x0139 }
            if (r5 == r2) goto L_0x010c
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r12)     // Catch:{ b -> 0x0143, a -> 0x013e, g -> 0x0139 }
            return r1
        L_0x010c:
            java.lang.Object r2 = r0.pf(r3)     // Catch:{ b -> 0x012b, a -> 0x0126 }
            r0.m17switch(r1, r2, r4)     // Catch:{ b -> 0x012b, a -> 0x0126 }
            com.baidu.helios.channels.csc.QuantumChannel$de r1 = r0.f793yj
            long r2 = java.lang.System.currentTimeMillis()
            r1.de(r2)
            com.baidu.helios.channels.csc.QuantumChannel$de r1 = r0.f793yj
            r1.fe(r14, r14)
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.fe()
            return r1
        L_0x0126:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r11)
            return r1
        L_0x012b:
            com.baidu.helios.channels.csc.QuantumChannel$de r1 = r0.f793yj
            r2 = 4
            r1.fe(r2, r9)
            r1 = -101(0xffffffffffffff9b, float:NaN)
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r1)
            return r1
        L_0x0139:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r12)
            return r1
        L_0x013e:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r11)
            return r1
        L_0x0143:
            r1 = -101(0xffffffffffffff9b, float:NaN)
            r2 = 4
            com.baidu.helios.channels.csc.QuantumChannel$de r4 = r0.f793yj
            r4.fe(r2, r9)
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r1)
            return r1
        L_0x0151:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r11)
            return r1
        L_0x0156:
            r1 = -101(0xffffffffffffff9b, float:NaN)
            r2 = 4
            com.baidu.helios.channels.csc.QuantumChannel$de r4 = r0.f793yj
            r4.fe(r2, r9)
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r1)
            return r1
        L_0x0164:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r11)
            return r1
        L_0x0169:
            r2 = r7
            r1 = -101(0xffffffffffffff9b, float:NaN)
        L_0x016c:
            com.baidu.helios.channels.csc.QuantumChannel$de r4 = r0.f793yj
            r4.fe(r2, r9)
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r1)
            return r1
        L_0x0176:
            java.lang.Object r2 = r0.pf(r3)     // Catch:{ Exception -> 0x017e }
            r3 = 0
            r0.m17switch(r1, r2, r3)     // Catch:{ Exception -> 0x017e }
        L_0x017e:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r12)
            return r1
        L_0x0183:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r11)
            return r1
        L_0x0188:
            com.baidu.helios.channels.csc.QuantumChannel$de r1 = r0.f793yj
            r2 = 4
            r1.fe(r2, r9)
            r1 = -101(0xffffffffffffff9b, float:NaN)
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r1)
            return r1
        L_0x0196:
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r11)
            return r1
        L_0x019b:
            r1 = -100
            fe.fe.pf.rg.qw$th r1 = fe.fe.pf.rg.qw.th.ad(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.helios.channels.csc.QuantumChannel.o(fe.fe.pf.rg.qw$rg):fe.fe.pf.rg.qw$th");
    }

    public final Object pf(String str) {
        try {
            return d.ad(this.f792uk.f807fe, new Object[]{str, this.f790i.f794ad});
        } catch (Exception e) {
            e.printStackTrace();
            throw new b("");
        }
    }

    public final byte[] ppp(Object obj, String str) {
        fe.qw qwVar = new fe.qw();
        for (int i2 = 0; i2 < f788o; i2++) {
            qwVar.qw(fe.rg(uk(obj, m16if(str, i2))));
        }
        return qwVar.ad().th();
    }

    public void rg(qw.fe feVar) {
        this.f791th = this.f2859ad.th("csc");
        this.f792uk = new rg(this.qw.qw);
        this.f790i = new ad();
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m17switch(Object obj, Object obj2, int i2) {
        try {
            this.f792uk.de(obj, obj2, i2);
        } catch (d.a e) {
            throw e;
        } catch (Throwable th2) {
            throw new b(th2);
        }
    }

    public qw.th th(qw.rg rgVar) {
        this.f793yj.o();
        try {
            return o(rgVar);
        } finally {
            this.f793yj.pf();
        }
    }

    public final int uk(Object obj, Object obj2) {
        try {
            return this.f792uk.qw(obj, obj2);
        } catch (d.a e) {
            throw e;
        } catch (Throwable th2) {
            throw new b(th2);
        }
    }

    public final Object when(String str, int i2) {
        try {
            Class<?> cls = this.f792uk.f807fe;
            return d.ad(cls, new Object[]{str, this.f790i.f795de + i2});
        } catch (Exception e) {
            e.printStackTrace();
            throw new b("");
        }
    }
}
