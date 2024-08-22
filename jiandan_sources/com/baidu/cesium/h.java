package com.baidu.cesium;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.cesium.b.b;
import com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper;
import fe.fe.fe.ad.qw;
import fe.fe.fe.i.de;
import fe.fe.fe.o;
import fe.fe.fe.pf;
import fe.fe.fe.rg;
import fe.fe.fe.th;
import fe.fe.fe.yj.qw;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class h {

    /* renamed from: uk  reason: collision with root package name */
    public static String f729uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public static boolean f730yj = false;

    /* renamed from: ad  reason: collision with root package name */
    public qw.C0104qw f731ad;

    /* renamed from: de  reason: collision with root package name */
    public volatile FileLock f732de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile RandomAccessFile f733fe;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public b f734rg;

    /* renamed from: th  reason: collision with root package name */
    public th f735th;

    public static class a {

        /* renamed from: if  reason: not valid java name */
        public static final String[] f6if = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};

        /* renamed from: ad  reason: collision with root package name */
        public String f736ad;

        /* renamed from: de  reason: collision with root package name */
        public String f737de;

        /* renamed from: fe  reason: collision with root package name */
        public long f738fe;

        /* renamed from: i  reason: collision with root package name */
        public String f739i;

        /* renamed from: o  reason: collision with root package name */
        public int f740o = 1;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f741pf = false;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f742rg;

        /* renamed from: th  reason: collision with root package name */
        public boolean f743th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f744uk = true;

        /* renamed from: yj  reason: collision with root package name */
        public String f745yj;

        /* renamed from: com.baidu.cesium.h$a$a  reason: collision with other inner class name */
        public interface C0031a {
        }

        public String a() {
            String str = this.f736ad;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.qw);
            sb.append("|");
            sb.append(str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                sb.append(this.f737de);
            }
            if (!TextUtils.isEmpty(this.f742rg)) {
                sb.append(this.f742rg);
            }
            return sb.toString().trim();
        }

        public String aaa() {
            return this.f739i;
        }

        public String ddd() {
            return this.f745yj;
        }

        public boolean eee() {
            return this.f741pf;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f740o == aVar.f740o && this.qw.equals(aVar.qw) && this.f736ad.equals(aVar.f736ad) && this.f737de.equals(aVar.f737de) && this.f743th == aVar.f743th && this.f745yj.equals(aVar.f745yj)) {
                String str = this.f742rg;
                String str2 = aVar.f742rg;
                if (str != str2) {
                    return str != null && str.equals(str2);
                }
                return true;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.qw, this.f736ad, this.f737de, Boolean.valueOf(this.f743th), this.f745yj, this.f742rg, Integer.valueOf(this.f740o)});
        }

        /* renamed from: if  reason: not valid java name */
        public String m11if() {
            return this.f742rg;
        }

        public synchronized boolean mmm() {
            return this.f744uk;
        }

        public String ppp() {
            return this.f736ad;
        }

        public void qqq() {
            String str = h.m8if();
            if (!TextUtils.isEmpty(str)) {
                this.f743th = true;
                this.f745yj = str;
            }
        }

        public void rg(String str) {
            this.f739i = str;
        }

        public o rrr() {
            o oVar = new o();
            oVar.qw = this.qw;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f736ad);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(this.f736ad)) {
                sb.append(this.f737de);
            }
            if (!TextUtils.isEmpty(this.f742rg)) {
                sb.append(this.f742rg);
            }
            oVar.f1878ad = sb.toString().trim();
            return oVar;
        }

        public synchronized void th(boolean z) {
            this.f744uk = z;
        }

        public String tt() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.qw);
                jSONObject.put("v270fk", this.f736ad);
                jSONObject.put("cck", this.f737de);
                jSONObject.put("vsk", this.f740o);
                jSONObject.put("ctk", this.f738fe);
                jSONObject.put("csk", this.f743th);
                if (!TextUtils.isEmpty(this.f745yj)) {
                    jSONObject.put("pmk", this.f745yj);
                }
                if (!TextUtils.isEmpty(this.f739i)) {
                    jSONObject.put("ock", this.f739i);
                }
                jSONObject.put("hrk", this.f744uk);
                jSONObject.put("ek", this.f742rg);
                jSONObject.put("ifu", this.f741pf);
                return jSONObject.toString();
            } catch (JSONException e) {
                de.de(e);
                return null;
            }
        }

        public String uk() {
            return this.qw;
        }

        public boolean xxx() {
            return this.f743th;
        }
    }

    public h(Context context, qw qwVar, th thVar) {
        if (context != null) {
            this.qw = context;
            qw.C0104qw ad2 = qwVar.rg().ad("bohrium");
            this.f731ad = ad2;
            ad2.fe();
            this.f735th = thVar;
            uk(qwVar);
            return;
        }
        throw new NullPointerException("context should not be null!!!");
    }

    public static a de(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("dik", "");
            String optString2 = jSONObject.optString("cck", "");
            long optLong = jSONObject.optLong("ctk", 0);
            int optInt = jSONObject.optInt("vsk", 1);
            boolean optBoolean = jSONObject.optBoolean("csk", false);
            String optString3 = jSONObject.optString("pmk", "");
            boolean optBoolean2 = jSONObject.optBoolean("hrk", true);
            String optString4 = jSONObject.optString("ock", (String) null);
            String optString5 = jSONObject.optString("ek", "");
            String optString6 = jSONObject.optString("v270fk", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            jSONObject.optBoolean("ifu", false);
            if (!TextUtils.isEmpty(optString)) {
                a aVar = new a();
                String unused = aVar.qw = optString;
                String unused2 = aVar.f737de = optString2;
                long unused3 = aVar.f738fe = optLong;
                int unused4 = aVar.f740o = optInt;
                String unused5 = aVar.f742rg = optString5;
                String unused6 = aVar.f736ad = optString6;
                boolean unused7 = aVar.f743th = optBoolean;
                String unused8 = aVar.f745yj = optString3;
                boolean unused9 = aVar.f744uk = optBoolean2;
                String unused10 = aVar.f739i = optString4;
                boolean unused11 = aVar.f741pf = false;
                return aVar;
            }
        } catch (Exception e) {
            de.de(e);
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    public static String m8if() {
        String str = f729uk;
        if (str != null) {
            return str;
        }
        if (TextUtils.isEmpty(Build.MODEL)) {
            return "";
        }
        String substring = th.de.ad(Build.MODEL.getBytes(), false).substring(3, 15);
        f729uk = substring;
        return substring;
    }

    public static String ppp(String str) {
        try {
            return new fe.fe.fe.i.qw("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).ad(new fe.fe.fe.qw.qw().qw(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static a rg(String str, String str2, String str3, boolean z, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String ppp = ppp(str);
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = new a();
                String unused = aVar.qw = str;
                String unused2 = aVar.f737de = ppp;
                long unused3 = aVar.f738fe = currentTimeMillis;
                int unused4 = aVar.f740o = 1;
                String unused5 = aVar.f742rg = str3;
                String unused6 = aVar.f736ad = str2;
                boolean unused7 = aVar.f743th = z;
                String unused8 = aVar.f745yj = str4;
                return aVar;
            } catch (Exception e) {
                de.de(e);
            }
        }
        return null;
    }

    public a ad(o oVar) {
        String str;
        if (oVar != null) {
            a aVar = new a();
            long unused = aVar.f738fe = System.currentTimeMillis();
            int unused2 = aVar.f740o = 1;
            try {
                boolean z = false;
                String unused3 = aVar.f736ad = oVar.f1878ad.substring(0, 1);
                String unused4 = aVar.qw = oVar.qw;
                String unused5 = aVar.f737de = ppp(oVar.qw);
                String[] strArr = a.f6if;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f736ad)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = oVar.f1878ad) != null && str.length() >= 2) {
                    String unused6 = aVar.f742rg = oVar.f1878ad.substring(1);
                }
                return aVar;
            } catch (Exception unused7) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
    }

    public a fe(String str, String str2) {
        fe.fe.fe.ad.qw qw2 = this.f734rg.qw(str2);
        qw.yj yjVar = new qw.yj();
        yjVar.qw = true;
        qw.uk ad2 = qw2.ad(str, yjVar);
        if (ad2 == null || !ad2.de()) {
            return null;
        }
        return ad2.qw;
    }

    public synchronized void ggg() {
        if (this.f732de != null) {
            try {
                this.f732de.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f732de = null;
        }
        de.ad(this.f733fe);
        this.f733fe = null;
    }

    public void i(a aVar) {
        qw.rg rgVar = new qw.rg();
        for (fe.fe.fe.ad.qw qw2 : this.f734rg.ad()) {
            qw2.qw(rgVar, aVar);
        }
    }

    public boolean o(a aVar, boolean z, boolean z2) {
        a de2;
        if (aVar == null || TextUtils.isEmpty(aVar.qw)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.f731ad.th(), "libbh.so").exists() && (de2 = de(yj(true))) != null) {
                    String a2 = de2.a();
                    boolean z3 = !TextUtils.isEmpty(a2) && a2.equals(aVar.a());
                    boolean z4 = de2.xxx() && !TextUtils.isEmpty(de2.ddd()) && TextUtils.equals(de2.ddd(), m8if());
                    if (z3 && z4) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return this.f731ad.rg("libbh.so", aVar.tt(), z);
    }

    public a pf(String str) {
        String str2;
        String th2 = th(this.qw);
        boolean z = false;
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (f730yj) {
                "uuid: " + uuid;
            }
            str2 = str + th2 + uuid;
        } else {
            if (!pf.ad.ad(th2)) {
                th2 = UUID.randomUUID().toString();
                z = true;
            }
            str2 = "com.baidu" + th2;
        }
        String ad2 = th.de.ad(str2.getBytes(), true);
        if (z) {
            ad2 = "FUUID" + ad2.substring(5);
        }
        String str3 = m8if();
        a aVar = new a();
        long unused = aVar.f738fe = System.currentTimeMillis();
        int unused2 = aVar.f740o = 1;
        String unused3 = aVar.qw = ad2;
        String unused4 = aVar.f736ad = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        String unused5 = aVar.f737de = ppp(ad2);
        boolean unused6 = aVar.f743th = true;
        String unused7 = aVar.f745yj = str3;
        String unused8 = aVar.f742rg = null;
        boolean unused9 = aVar.f741pf = z;
        return aVar;
    }

    public a qw() {
        if (!new File(this.f731ad.th(), "libbh.so").exists()) {
            return null;
        }
        return de(yj(true));
    }

    /* renamed from: switch  reason: not valid java name */
    public a m9switch(String str) {
        a aVar;
        qw.yj yjVar = new qw.yj();
        yjVar.qw = true;
        List<fe.fe.fe.ad.qw> ad2 = this.f734rg.ad();
        Collections.sort(ad2, fe.fe.fe.ad.qw.f1824rg);
        List<rg> uk2 = this.f735th.uk(this.qw);
        if (uk2 == null) {
            return null;
        }
        for (rg next : uk2) {
            if (!next.f1896fe && next.f1895de) {
                for (fe.fe.fe.ad.qw ad3 : ad2) {
                    qw.uk ad4 = ad3.ad(next.qw.packageName, yjVar);
                    if (ad4 != null && ad4.de() && (aVar = ad4.qw) != null && pf.ad.qw(aVar.uk()) && !TextUtils.equals(aVar.uk(), str)) {
                        if (!(aVar.xxx() && !TextUtils.equals(m8if(), aVar.ddd()))) {
                            return ad4.qw;
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final String th(Context context) {
        String stringFromSettingSecure = DeviceIdHelper.getStringFromSettingSecure(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(stringFromSettingSecure) ? "" : stringFromSettingSecure;
    }

    public final void uk(fe.fe.fe.yj.qw qwVar) {
        b bVar = new b(new fe.fe.fe.de());
        qw.ad adVar = new qw.ad();
        adVar.qw = this.qw;
        adVar.f1828ad = qwVar;
        qw.fe feVar = new qw.fe();
        for (fe.fe.fe.ad.qw next : bVar.ad()) {
            next.fe(adVar);
            next.rg(feVar);
        }
        this.f734rg = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0047 A[Catch:{ IOException -> 0x0013 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean when() {
        /*
            r6 = this;
            monitor-enter(r6)
            fe.fe.fe.yj.qw$qw r0 = r6.f731ad     // Catch:{ all -> 0x004c }
            java.lang.String r1 = ".lock"
            java.io.File r0 = r0.yj(r1)     // Catch:{ all -> 0x004c }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0017
            r0.createNewFile()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x004c }
        L_0x0017:
            r1 = 0
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x003f }
            java.lang.String r4 = "rw"
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x003f }
            r0 = 0
        L_0x0021:
            r1 = 100
            if (r0 >= r1) goto L_0x004a
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch:{ OverlappingFileLockException -> 0x0037 }
            java.nio.channels.FileLock r1 = r1.lock()     // Catch:{ OverlappingFileLockException -> 0x0037 }
            r6.f732de = r1     // Catch:{ OverlappingFileLockException -> 0x0037 }
            r6.f733fe = r3     // Catch:{ OverlappingFileLockException -> 0x0037 }
            monitor-exit(r6)
            r0 = 1
            return r0
        L_0x0034:
            r0 = move-exception
            r1 = r3
            goto L_0x0040
        L_0x0037:
            r4 = 100
            java.lang.Thread.sleep(r4)     // Catch:{ Exception -> 0x0034 }
            int r0 = r0 + 1
            goto L_0x0021
        L_0x003f:
            r0 = move-exception
        L_0x0040:
            fe.fe.fe.i.de.de(r0)     // Catch:{ all -> 0x004c }
            java.nio.channels.FileLock r0 = r6.f732de     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x004a
            fe.fe.fe.i.de.ad(r1)     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r6)
            return r2
        L_0x004c:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.cesium.h.when():boolean");
    }

    public final String yj(boolean z) {
        return this.f731ad.de("libbh.so", z);
    }
}
