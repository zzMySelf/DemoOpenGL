package fe.fe.th.ad;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.appcompat.widget.SearchView;
import com.baidu.clientupdate.a.a;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.util.Base64Encoder;
import fe.fe.aaa.ad;
import fe.fe.aaa.qw;
import fe.fe.th.i.i;
import fe.fe.th.uk.o;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class de {

    /* renamed from: rg  reason: collision with root package name */
    public static de f3083rg;

    /* renamed from: ad  reason: collision with root package name */
    public List f3084ad = new ArrayList();

    /* renamed from: de  reason: collision with root package name */
    public i f3085de;

    /* renamed from: fe  reason: collision with root package name */
    public qw f3086fe;
    public List qw = new ArrayList();

    public de(Context context) {
        Context context2 = context;
        this.f3085de = i.yj(context);
        this.f3086fe = qw.qw(context);
        try {
            if (this.f3085de.rrr()) {
                String de2 = ad.ad(context).de("lcsdk_xml", "apkMD5", "");
                String ad2 = o.ad(context2, context.getPackageName());
                String de3 = ad.ad(context).de("lcsdk_xml", "sessionId", "-1");
                String de4 = ad.ad(context).de("lcsdk_xml", "sessionInfo", "");
                if (ad2.equals(de2)) {
                    th(de3, "0", de4, "a10", "0", (System.currentTimeMillis() / 1000) + "", "", "InstallSuccess", "");
                    qw.ad("LogUtils", "向db添加a10");
                } else {
                    th(de3, "0", de4, "a10", "1", (System.currentTimeMillis() / 1000) + "", "", "InstallFail", "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context2.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && this.f3085de.eee()) {
                qw.ad("LogUtils", "符合wifi下、有a6动作的上报时机");
                i();
                if (this.qw != null && this.qw.size() != 0) {
                    String de5 = de(this.qw);
                    if (!TextUtils.isEmpty(de5)) {
                        byte[] yj2 = yj(de5.getBytes());
                        qw.ad("LogUtils", "gZip后上传大小：" + (yj2.length / 1024));
                        long qw2 = ad.ad(context).qw("lcsdk_xml", "time", System.currentTimeMillis());
                        if (yj2.length / 1024 <= 20) {
                            if ((qw2 - System.currentTimeMillis()) / 86400000 <= 7) {
                                new fe(this, yj2).start();
                                return;
                            }
                        }
                        qw.ad("LogUtils", "日志超过20k或者日志超过7天 ，将日志舍弃");
                        this.f3085de.pf();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized de ad(Context context) {
        de deVar;
        synchronized (de.class) {
            if (f3083rg == null) {
                f3083rg = new de(context);
            }
            deVar = f3083rg;
        }
        return deVar;
    }

    public final String de(List list) {
        try {
            JSONObject jSONObject = new JSONObject(((a) list.get(list.size() - 1)).a());
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject2.put(SearchView.IME_OPTION_NO_MICROPHONE, aVar.b());
                jSONObject2.put("tm", aVar.c());
                jSONObject3.put("sc", aVar.d());
                jSONObject3.put("tm", aVar.e());
                jSONObject3.put("mg", aVar.f());
                jSONObject3.put("ex", aVar.g());
                jSONObject2.put("in", jSONObject3);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("acs", jSONArray);
            byte[] de2 = Base64Encoder.de(URLEncoder.encode(jSONObject.toString()).getBytes());
            qw.ad("LogUtils", jSONObject.toString());
            qw.ad("LogUtils", new String(de2));
            return new String(de2);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void fe() {
        qw.ad("LogUtils", "把db数据的flag变为1");
        this.f3085de.mmm();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r1 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r1 != null) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List i() {
        /*
            r5 = this;
            java.lang.String r0 = "LogUtils"
            java.lang.String r1 = "queryAllLog"
            fe.fe.aaa.qw.ad(r0, r1)
            java.util.List r1 = r5.f3084ad
            r2 = 0
            if (r1 == 0) goto L_0x0012
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0057
        L_0x0012:
            fe.fe.th.i.i r1 = r5.f3085de     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            android.database.Cursor r1 = r1.qqq()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            if (r1 == 0) goto L_0x0043
            r1.moveToFirst()     // Catch:{ Exception -> 0x0041 }
        L_0x001d:
            boolean r3 = r1.isAfterLast()     // Catch:{ Exception -> 0x0041 }
            if (r3 != 0) goto L_0x0030
            com.baidu.clientupdate.a.a r3 = r5.qw(r1)     // Catch:{ Exception -> 0x0041 }
            java.util.List r4 = r5.f3084ad     // Catch:{ Exception -> 0x0041 }
            r4.add(r3)     // Catch:{ Exception -> 0x0041 }
            r1.moveToNext()     // Catch:{ Exception -> 0x0041 }
            goto L_0x001d
        L_0x0030:
            java.util.List r3 = r5.qw     // Catch:{ Exception -> 0x0041 }
            java.util.List r4 = r5.f3084ad     // Catch:{ Exception -> 0x0041 }
            r3.addAll(r4)     // Catch:{ Exception -> 0x0041 }
            r5.f3084ad = r2     // Catch:{ Exception -> 0x0041 }
            java.util.List r0 = r5.qw     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x0040
            r1.close()
        L_0x0040:
            return r0
        L_0x0041:
            r3 = move-exception
            goto L_0x004d
        L_0x0043:
            if (r1 == 0) goto L_0x0057
        L_0x0045:
            r1.close()
            goto L_0x0057
        L_0x0049:
            r0 = move-exception
            goto L_0x005a
        L_0x004b:
            r3 = move-exception
            r1 = r2
        L_0x004d:
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)     // Catch:{ all -> 0x0058 }
            fe.fe.aaa.qw.ad(r0, r3)     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0057
            goto L_0x0045
        L_0x0057:
            return r2
        L_0x0058:
            r0 = move-exception
            r2 = r1
        L_0x005a:
            if (r2 == 0) goto L_0x005f
            r2.close()
        L_0x005f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.ad.de.i():java.util.List");
    }

    public final a qw(Cursor cursor) {
        a aVar = new a();
        try {
            aVar.b = cursor.getString(cursor.getColumnIndex("ug"));
            aVar.c = cursor.getString(cursor.getColumnIndex(SearchView.IME_OPTION_NO_MICROPHONE));
            aVar.a = cursor.getString(cursor.getColumnIndex("sessioninfo"));
            aVar.d = cursor.getString(cursor.getColumnIndex(OpenBdussResult.PARAMS_FLAG));
            aVar.e = new JSONArray(cursor.getString(cursor.getColumnIndex("stm")));
            aVar.f = new JSONArray(cursor.getString(cursor.getColumnIndex("sc")));
            aVar.g = new JSONArray(cursor.getString(cursor.getColumnIndex("etm")));
            aVar.h = new JSONArray(cursor.getString(cursor.getColumnIndex("mg")));
            aVar.f746i = new JSONArray(cursor.getString(cursor.getColumnIndex("ex")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            r18 = this;
            r1 = r18
            r0 = r22
            r2 = r23
            r3 = r24
            r4 = r26
            r5 = r27
            java.lang.String r12 = "LogUtils"
            r6 = 0
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x011a }
            java.lang.String r7 = "打log"
            fe.fe.aaa.qw.ad(r12, r7)     // Catch:{ Exception -> 0x011a }
            boolean r7 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x011a }
            if (r7 == 0) goto L_0x0021
            java.lang.String r7 = "{"
            goto L_0x0023
        L_0x0021:
            r7 = r21
        L_0x0023:
            fe.fe.th.i.i r8 = r1.f3085de     // Catch:{ Exception -> 0x011a }
            android.database.Cursor r15 = r8.th(r0)     // Catch:{ Exception -> 0x011a }
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r15 == 0) goto L_0x0080
            boolean r6 = r15.moveToNext()     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            if (r6 == 0) goto L_0x0080
            com.baidu.clientupdate.a.a r6 = r1.qw(r15)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            java.lang.String r10 = r6.c     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            boolean r0 = r10.equals(r0)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            if (r0 == 0) goto L_0x0074
            java.lang.String r0 = r6.d     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            r10 = r20
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            if (r0 == 0) goto L_0x0074
            java.lang.String r0 = "update"
            fe.fe.aaa.qw.ad(r12, r0)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            r6.a(r7)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            org.json.JSONArray r0 = r6.f     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            r0.put(r2)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            org.json.JSONArray r0 = r6.e     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            r0.put(r3)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            org.json.JSONArray r0 = r6.g     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            long r2 = r2 / r8
            r0.put(r2)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            org.json.JSONArray r0 = r6.h     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            r0.put(r4)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            org.json.JSONArray r0 = r6.f746i     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            r0.put(r5)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            fe.fe.th.i.i r0 = r1.f3085de     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
            r0.ppp(r6)     // Catch:{ Exception -> 0x007c, all -> 0x0078 }
        L_0x0074:
            r21 = r15
            goto L_0x00e9
        L_0x0078:
            r0 = move-exception
            r6 = r15
            goto L_0x0128
        L_0x007c:
            r0 = move-exception
            r6 = r15
            goto L_0x011b
        L_0x0080:
            r10 = r20
            java.lang.String r6 = "insert"
            fe.fe.aaa.qw.ad(r12, r6)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r11.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r11.put(r3)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r6.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r6.put(r2)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r3.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r2.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            long r8 = r16 / r8
            r2.append(r8)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            java.lang.String r8 = ""
            r2.append(r8)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r3.put(r2)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r9.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r9.put(r4)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r8.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r8.put(r5)     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            com.baidu.clientupdate.a.a r5 = new com.baidu.clientupdate.a.a     // Catch:{ Exception -> 0x0112, all -> 0x010c }
            r2 = r5
            r16 = r3
            r3 = r19
            r4 = r20
            r10 = r5
            r5 = r7
            r17 = r6
            r6 = r22
            r7 = r11
            r0 = r8
            r8 = r17
            r11 = r9
            r9 = r16
            r21 = r15
            r15 = r10
            r10 = r11
            r11 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            fe.fe.th.i.i r0 = r1.f3085de     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            r0.de(r15)     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
        L_0x00e9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            r0.<init>()     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            java.lang.String r2 = "log time:"
            r0.append(r2)     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            long r2 = r2 - r13
            r0.append(r2)     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            fe.fe.aaa.qw.ad(r12, r0)     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            if (r21 == 0) goto L_0x0127
            r21.close()
            goto L_0x0127
        L_0x0108:
            r0 = move-exception
            goto L_0x010f
        L_0x010a:
            r0 = move-exception
            goto L_0x0115
        L_0x010c:
            r0 = move-exception
            r21 = r15
        L_0x010f:
            r6 = r21
            goto L_0x0128
        L_0x0112:
            r0 = move-exception
            r21 = r15
        L_0x0115:
            r6 = r21
            goto L_0x011b
        L_0x0118:
            r0 = move-exception
            goto L_0x0128
        L_0x011a:
            r0 = move-exception
        L_0x011b:
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x0118 }
            fe.fe.aaa.qw.ad(r12, r0)     // Catch:{ all -> 0x0118 }
            if (r6 == 0) goto L_0x0127
            r6.close()
        L_0x0127:
            return
        L_0x0128:
            if (r6 == 0) goto L_0x012d
            r6.close()
        L_0x012d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.ad.de.th(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public byte[] yj(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            e.printStackTrace();
            return bArr2;
        }
    }
}
