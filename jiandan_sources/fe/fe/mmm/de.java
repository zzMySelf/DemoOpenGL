package fe.fe.mmm;

import android.text.TextUtils;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.idl.authority.BuildConfig;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.ubc.IUBCUploader;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import fe.fe.mmm.u.uk;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public abstract class de implements IUBCUploader {

    /* renamed from: de  reason: collision with root package name */
    public static final boolean f2009de = tt.vvv();

    /* renamed from: fe  reason: collision with root package name */
    public static final String f2010fe = tt.ppp(false);

    /* renamed from: rg  reason: collision with root package name */
    public static final String f2011rg = tt.ppp(true);

    /* renamed from: ad  reason: collision with root package name */
    public String f2012ad = "";
    public h qw = new h();

    public de() {
        rg();
    }

    public boolean ad(File file, long j, boolean z, boolean z2) {
        return i(this.f2012ad, file, j, z, z2);
    }

    public final HashMap<String, String> de() {
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("Content-type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        hashMap.put("nb", "1");
        return hashMap;
    }

    public final String fe(String str, boolean z, boolean z2) {
        String str2;
        boolean isUBCDebug = this.qw.isUBCDebug();
        if (TextUtils.isEmpty(str)) {
            str = f2010fe;
        }
        if (isUBCDebug && this.qw.isUseOfflineUrl()) {
            str = f2011rg;
        }
        if (z2) {
            str2 = tt.uk(str);
        } else {
            str2 = tt.de(str);
        }
        if (isUBCDebug && !TextUtils.isEmpty(str2)) {
            str2 = uk.qw(str2, BuildConfig.BUILD_TYPE, "1");
        }
        if (z) {
            str2 = uk.qw(str2, "reallog", "1");
        }
        if (i.vvv().f()) {
            str2 = uk.qw(str2, "beta", "1");
        }
        return uk.qw(str2, "ubcsdkversion", "2.1.63");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046 A[SYNTHETIC, Splitter:B:19:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(java.lang.String r4, java.io.File r5, long r6, boolean r8, boolean r9) {
        /*
            r3 = this;
            r6 = 0
            if (r5 == 0) goto L_0x0094
            boolean r7 = r5.exists()
            if (r7 != 0) goto L_0x000b
            goto L_0x0094
        L_0x000b:
            java.lang.String r7 = r5.getName()
            com.baidu.ubc.constants.EnumConstants$RunTime r0 = com.baidu.ubc.constants.EnumConstants$RunTime.FILE_UPLOAD_START
            fe.fe.mmm.m.yj(r7, r0)
            java.lang.String r4 = r3.fe(r4, r8, r9)
            java.util.HashMap r7 = r3.de()
            r8 = 0
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            android.util.Base64InputStream r0 = new android.util.Base64InputStream     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            r1.<init>(r5)     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            r2 = 2
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            r9.<init>(r0)     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            fe.fe.mmm.d r4 = r3.pf(r4, r9, r7)     // Catch:{ Exception -> 0x0039 }
            boolean r4 = r3.yj(r5, r4)     // Catch:{ Exception -> 0x0039 }
            fe.fe.mmm.u.qw.ad(r9)
            return r4
        L_0x0039:
            r4 = move-exception
            goto L_0x003f
        L_0x003b:
            r4 = move-exception
            goto L_0x0090
        L_0x003d:
            r4 = move-exception
            r9 = r8
        L_0x003f:
            boolean r7 = f2009de     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "\n"
            if (r7 == 0) goto L_0x0046
            goto L_0x0067
        L_0x0046:
            fe.fe.mmm.c r7 = fe.fe.mmm.c.de()     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r1.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x008e }
            r1.append(r2)     // Catch:{ all -> 0x008e }
            r1.append(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r2 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x008e }
            r1.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008e }
            r7.aaa(r8, r1)     // Catch:{ all -> 0x008e }
        L_0x0067:
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r7.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x008e }
            r7.append(r8)     // Catch:{ all -> 0x008e }
            r7.append(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r4 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x008e }
            r7.append(r4)     // Catch:{ all -> 0x008e }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x008e }
            com.baidu.ubc.constants.EnumConstants$RunTime r7 = com.baidu.ubc.constants.EnumConstants$RunTime.FILE_UPLOAD_FAIL_IO_ERROR     // Catch:{ all -> 0x008e }
            fe.fe.mmm.m.uk(r5, r4, r7)     // Catch:{ all -> 0x008e }
            fe.fe.mmm.u.qw.ad(r9)
            return r6
        L_0x008e:
            r4 = move-exception
            r8 = r9
        L_0x0090:
            fe.fe.mmm.u.qw.ad(r8)
            throw r4
        L_0x0094:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.de.i(java.lang.String, java.io.File, long, boolean, boolean):boolean");
    }

    /* renamed from: if  reason: not valid java name */
    public abstract d m121if(String str, byte[] bArr, Map<String, String> map) throws IOException;

    public boolean o(String str, JSONObject jSONObject, boolean z, boolean z2) {
        byte[] qw2;
        if (!(jSONObject == null || (qw2 = fe.fe.mmm.u.de.qw(jSONObject.toString().getBytes())) == null || qw2.length < 2)) {
            qw2[0] = 117;
            qw2[1] = 123;
            try {
                return th(m121if(fe(str, z, z2), qw2, de()));
            } catch (IOException e) {
                if (!f2009de) {
                    c de2 = c.de();
                    de2.aaa((String) null, e.toString() + StringUtils.LF + Log.getStackTraceString(e));
                }
            }
        }
        return false;
    }

    public abstract d pf(String str, InputStream inputStream, Map<String, String> map) throws IOException;

    public boolean qw(JSONObject jSONObject, boolean z, boolean z2) {
        return o(this.f2012ad, jSONObject, z, z2);
    }

    public abstract void rg();

    public final boolean th(d dVar) {
        return yj((File) null, dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uk(int r6) {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            r3 = 403(0x193, float:5.65E-43)
            if (r6 == r3) goto L_0x0020
            r3 = 408(0x198, float:5.72E-43)
            if (r6 == r3) goto L_0x0020
            r3 = 499(0x1f3, float:6.99E-43)
            if (r6 != r3) goto L_0x0012
            goto L_0x0020
        L_0x0012:
            r3 = 500(0x1f4, float:7.0E-43)
            if (r6 < r3) goto L_0x001e
            r3 = 600(0x258, float:8.41E-43)
            if (r6 >= r3) goto L_0x001e
            r3 = 300000(0x493e0, double:1.482197E-318)
            goto L_0x0023
        L_0x001e:
            r2 = 0
            goto L_0x0024
        L_0x0020:
            r3 = 60000(0xea60, double:2.9644E-319)
        L_0x0023:
            long r0 = r0 + r3
        L_0x0024:
            if (r2 == 0) goto L_0x002d
            fe.fe.mmm.i r6 = fe.fe.mmm.i.vvv()
            r6.B(r0)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.de.uk(int):void");
    }

    public final boolean yj(File file, d dVar) {
        String name = file != null ? file.getName() : null;
        if (dVar == null) {
            m.uk(name, "resp is null", EnumConstants$RunTime.FILE_UPLOAD_FAIL);
            return false;
        } else if (!dVar.rg()) {
            if (f2009de) {
                "postByteRequest, fail: " + dVar.fe();
            } else {
                c.de().aaa(dVar.fe(), (String) null);
            }
            int de2 = dVar.de();
            uk(de2);
            dVar.qw();
            m.uk(name, "code:" + de2 + ";msg:" + dVar.fe(), EnumConstants$RunTime.FILE_UPLOAD_FAIL);
            return false;
        } else {
            try {
                int i2 = new JSONObject(dVar.ad()).getInt(SapiUtils.KEY_QR_LOGIN_ERROR);
                if (i2 != 0) {
                    boolean z = f2009de;
                    if (!f2009de) {
                        c.de().eee(i2);
                    }
                    m.uk(name, "errno:" + i2, EnumConstants$RunTime.FILE_UPLOAD_RES_NUMBEL_ERROR);
                } else {
                    m.yj(name, EnumConstants$RunTime.FILE_UPLOAD_SUCCESS);
                }
            } catch (Exception e) {
                if (f2009de) {
                    "body tostring fail:" + e.getMessage();
                } else {
                    c.de().qqq(e.toString() + StringUtils.LF + Log.getStackTraceString(e));
                }
                m.uk(name, e.toString() + StringUtils.LF + Log.getStackTraceString(e), EnumConstants$RunTime.FILE_UPLOAD_RES_JSON_ERROR);
            }
            dVar.qw();
            return true;
        }
    }
}
