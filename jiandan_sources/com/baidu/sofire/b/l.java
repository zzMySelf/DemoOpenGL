package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.c.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.e;
import com.baidu.sofire.l.j;
import com.baidu.sofire.l.k;
import com.baidu.sofire.l.q;
import com.baidu.sofire.l.v;
import com.cmic.sso.sdk.e.i;
import com.dlife.ctaccountapi.t;
import com.dlife.ctaccountapi.w;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;

public class l {
    public static void a(Context context) {
        try {
            a a = a.a(context);
            c a2 = c.a(context);
            Iterator it = ((ArrayList) a.b()).iterator();
            while (it.hasNext()) {
                ApkInfo apkInfo = (ApkInfo) it.next();
                int i2 = apkInfo.duration;
                if (i2 != 0 && apkInfo.startTime + ((long) (i2 * 60 * 1000)) < System.currentTimeMillis()) {
                    a2.b(apkInfo.packageName);
                }
            }
        } catch (Throwable unused) {
            int i3 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0116, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0048 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x007c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0096 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x00b0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x00df */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x00f8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0110 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r6, org.json.JSONObject r7) {
        /*
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Class<com.baidu.sofire.m.a> r0 = com.baidu.sofire.m.a.class
            monitor-enter(r0)     // Catch:{ all -> 0x0116 }
            com.baidu.sofire.m.a r1 = com.baidu.sofire.m.a.c     // Catch:{ all -> 0x0113 }
            if (r1 != 0) goto L_0x0011
            com.baidu.sofire.m.a r1 = new com.baidu.sofire.m.a     // Catch:{ all -> 0x0113 }
            r1.<init>(r6)     // Catch:{ all -> 0x0113 }
            com.baidu.sofire.m.a.c = r1     // Catch:{ all -> 0x0113 }
        L_0x0011:
            com.baidu.sofire.m.a r6 = com.baidu.sofire.m.a.c     // Catch:{ all -> 0x0113 }
            monitor-exit(r0)     // Catch:{ all -> 0x0116 }
            r0 = 0
            r1 = 1
            java.lang.String r2 = "1"
            int r2 = r7.getInt(r2)     // Catch:{ JSONException -> 0x002e }
            if (r2 != r1) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x002e }
            java.lang.String r4 = "lt_sdcf"
            r3.putBoolean(r4, r2)     // Catch:{ JSONException -> 0x002e }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x002e }
            r2.commit()     // Catch:{ JSONException -> 0x002e }
            goto L_0x0030
        L_0x002e:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x0030:
            java.lang.String r2 = "2"
            int r2 = r7.getInt(r2)     // Catch:{ JSONException -> 0x0048 }
            if (r2 != r1) goto L_0x003a
            r2 = 1
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x0048 }
            java.lang.String r4 = "lt_sucf"
            r3.putBoolean(r4, r2)     // Catch:{ JSONException -> 0x0048 }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x0048 }
            r2.commit()     // Catch:{ JSONException -> 0x0048 }
            goto L_0x004a
        L_0x0048:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x004a:
            java.lang.String r2 = "3"
            int r2 = r7.getInt(r2)     // Catch:{ JSONException -> 0x0062 }
            if (r2 != r1) goto L_0x0054
            r2 = 1
            goto L_0x0055
        L_0x0054:
            r2 = 0
        L_0x0055:
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x0062 }
            java.lang.String r4 = "lt_sbff"
            r3.putBoolean(r4, r2)     // Catch:{ JSONException -> 0x0062 }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x0062 }
            r2.commit()     // Catch:{ JSONException -> 0x0062 }
            goto L_0x0064
        L_0x0062:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x0064:
            java.lang.String r2 = "4"
            int r2 = r7.getInt(r2)     // Catch:{ JSONException -> 0x007c }
            if (r2 != r1) goto L_0x006e
            r2 = 1
            goto L_0x006f
        L_0x006e:
            r2 = 0
        L_0x006f:
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x007c }
            java.lang.String r4 = "lt_sppf"
            r3.putBoolean(r4, r2)     // Catch:{ JSONException -> 0x007c }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x007c }
            r2.commit()     // Catch:{ JSONException -> 0x007c }
            goto L_0x007e
        L_0x007c:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x007e:
            java.lang.String r2 = "5"
            int r2 = r7.getInt(r2)     // Catch:{ JSONException -> 0x0096 }
            if (r2 != r1) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x0096 }
            java.lang.String r4 = "lt_sssf"
            r3.putBoolean(r4, r2)     // Catch:{ JSONException -> 0x0096 }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x0096 }
            r2.commit()     // Catch:{ JSONException -> 0x0096 }
            goto L_0x0098
        L_0x0096:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x0098:
            java.lang.String r2 = "5"
            int r2 = r7.getInt(r2)     // Catch:{ JSONException -> 0x00b0 }
            if (r2 != r1) goto L_0x00a2
            r2 = 1
            goto L_0x00a3
        L_0x00a2:
            r2 = 0
        L_0x00a3:
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r4 = "lt_sssf"
            r3.putBoolean(r4, r2)     // Catch:{ JSONException -> 0x00b0 }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x00b0 }
            r2.commit()     // Catch:{ JSONException -> 0x00b0 }
            goto L_0x00b2
        L_0x00b0:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x00b2:
            java.lang.String r2 = "7"
            long r2 = r7.getLong(r2)     // Catch:{ JSONException -> 0x00c5 }
            android.content.SharedPreferences$Editor r4 = r6.b     // Catch:{ JSONException -> 0x00c5 }
            java.lang.String r5 = "lt_sfii"
            r4.putLong(r5, r2)     // Catch:{ JSONException -> 0x00c5 }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x00c5 }
            r2.commit()     // Catch:{ JSONException -> 0x00c5 }
            goto L_0x00c7
        L_0x00c5:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x00c7:
            java.lang.String r2 = "8"
            int r2 = r7.getInt(r2)     // Catch:{ JSONException -> 0x00df }
            if (r2 != r1) goto L_0x00d1
            r2 = 1
            goto L_0x00d2
        L_0x00d1:
            r2 = 0
        L_0x00d2:
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x00df }
            java.lang.String r4 = "lt_sfff"
            r3.putBoolean(r4, r2)     // Catch:{ JSONException -> 0x00df }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x00df }
            r2.commit()     // Catch:{ JSONException -> 0x00df }
            goto L_0x00e1
        L_0x00df:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x00e1:
            java.lang.String r2 = "9"
            org.json.JSONArray r2 = r7.getJSONArray(r2)     // Catch:{ JSONException -> 0x00f8 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x00f8 }
            android.content.SharedPreferences$Editor r3 = r6.b     // Catch:{ JSONException -> 0x00f8 }
            java.lang.String r4 = "lt_sha"
            r3.putString(r4, r2)     // Catch:{ JSONException -> 0x00f8 }
            android.content.SharedPreferences$Editor r2 = r6.b     // Catch:{ JSONException -> 0x00f8 }
            r2.commit()     // Catch:{ JSONException -> 0x00f8 }
            goto L_0x00fa
        L_0x00f8:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
        L_0x00fa:
            java.lang.String r2 = "10"
            int r7 = r7.getInt(r2)     // Catch:{ JSONException -> 0x0110 }
            if (r7 != r1) goto L_0x0103
            r0 = 1
        L_0x0103:
            android.content.SharedPreferences$Editor r7 = r6.b     // Catch:{ JSONException -> 0x0110 }
            java.lang.String r1 = "lt_sbwnp"
            r7.putBoolean(r1, r0)     // Catch:{ JSONException -> 0x0110 }
            android.content.SharedPreferences$Editor r6 = r6.b     // Catch:{ JSONException -> 0x0110 }
            r6.commit()     // Catch:{ JSONException -> 0x0110 }
            goto L_0x0118
        L_0x0110:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0116 }
            goto L_0x0118
        L_0x0113:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0116 }
            throw r6     // Catch:{ all -> 0x0116 }
        L_0x0116:
            int r6 = com.baidu.sofire.a.a.a
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.l.b(android.content.Context, org.json.JSONObject):void");
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            StringBuilder sb = new StringBuilder();
            try {
                str2 = new String(F.getInstance().ad(Base64.decode("+iRPK1zdtoLDzDVXd9rgcPXPi5h5mwMraRpB1WLS8OC15ToLTJ/1sEHlKvZk7nT8", 0), e.a));
            } catch (Throwable unused) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("p/1/r");
            String a = a(context, sb.toString(), str, false, false);
            return !TextUtils.isEmpty(a) && new JSONObject(a).getInt(LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE) == 1;
        } catch (Throwable unused2) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static void a(Context context, ClassLoader classLoader, Intent intent) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            Object newInstance = loadClass.newInstance();
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), new Class[]{Context.class, Intent.class}).invoke(newInstance, new Object[]{context.getApplicationContext(), intent});
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.clearThreadStatsTag();
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|(2:18|19)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        if (r1 != null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
        return new java.security.cert.Certificate[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002d, code lost:
        if (r1 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0033, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.Certificate[] a(java.util.jar.JarFile r3, java.util.jar.JarEntry r4, byte[] r5) {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x001e }
            java.io.InputStream r3 = r3.getInputStream(r4)     // Catch:{ all -> 0x001e }
            r1.<init>(r3)     // Catch:{ all -> 0x001e }
        L_0x000a:
            int r3 = r5.length     // Catch:{ all -> 0x001f }
            int r3 = r1.read(r5, r0, r3)     // Catch:{ all -> 0x001f }
            r2 = -1
            if (r3 == r2) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            java.security.cert.Certificate[] r3 = r4.getCertificates()     // Catch:{ all -> 0x001f }
            r1.close()     // Catch:{ all -> 0x001b }
            goto L_0x001d
        L_0x001b:
            int r4 = com.baidu.sofire.a.a.a
        L_0x001d:
            return r3
        L_0x001e:
            r1 = 0
        L_0x001f:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ all -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            int r3 = com.baidu.sofire.a.a.a
        L_0x0029:
            java.security.cert.Certificate[] r3 = new java.security.cert.Certificate[r0]
            return r3
        L_0x002c:
            r3 = move-exception
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0035
        L_0x0033:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0035:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.l.a(java.util.jar.JarFile, java.util.jar.JarEntry, byte[]):java.security.cert.Certificate[]");
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        return a(context, str, str2, z, z2, false, (Map<String, String>) null);
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, boolean z) {
        PendingIntent pendingIntent;
        long j;
        long j2;
        try {
            com.baidu.sofire.j.a a = com.baidu.sofire.j.a.a(context);
            long j3 = ((long) a.a.getInt("appal_te", 24)) * DateUtils.MILLIS_PER_HOUR;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
            intent.setClass(context, MyService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.SOFIRE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleWork");
            intent.putExtra("from", 6);
            if (c.i(context)) {
                pendingIntent = PendingIntent.getService(context, 1000, intent, 201326592);
            } else {
                pendingIntent = PendingIntent.getService(context, 1000, intent, 134217728);
            }
            if (z) {
                j = a.a.getLong("npuct", 0);
                if (j <= 0) {
                    j2 = System.currentTimeMillis() + j3;
                    a.b.putLong("npuct", j2);
                    a.b.commit();
                }
                alarmManager.cancel(pendingIntent);
                alarmManager.set(1, j, pendingIntent);
            }
            j2 = ((System.currentTimeMillis() + j3) - 600000) + ((long) (Math.random() * 1200000.0d));
            a.b.putLong("npuct", j2);
            a.b.commit();
            j = j2;
            try {
                alarmManager.cancel(pendingIntent);
            } catch (Throwable unused) {
            }
            try {
                alarmManager.set(1, j, pendingIntent);
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.setThreadStatsTag(155648);
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Map<String, String> map) throws Throwable {
        byte[] bArr;
        Context context2 = context;
        String[] p = c.p(context);
        String str3 = p[0];
        String str4 = p[1];
        if (!"com.baidu.input_huawei".equals(context.getPackageName()) || com.baidu.sofire.j.a.a(context).b()) {
            String valueOf = String.valueOf(new Date().getTime() / 1000);
            String a = k.a(str3 + valueOf + str4);
            Random random = v.a;
            char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            char[] cArr = new char[16];
            for (int i2 = 0; i2 < 16; i2++) {
                cArr[i2] = charArray[v.a.nextInt(62)];
            }
            byte[] bytes = new String(cArr).getBytes();
            String str5 = "";
            if (!TextUtils.isEmpty(str2)) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                byte[] bArr2 = new byte[2048];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    gZIPOutputStream.write(bArr2, 0, read);
                }
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                bArr = F.getInstance().ae(byteArray, bytes);
            } else {
                bArr = str5.getBytes();
            }
            byte[] bytes2 = k.a(e.a(context)).getBytes();
            String encodeToString = Base64.encodeToString(F.getInstance().re(bytes, bytes2), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append("100");
            sb.append("/");
            sb.append(str3);
            sb.append("/");
            sb.append(valueOf);
            sb.append("/");
            sb.append(a);
            if (!TextUtils.isEmpty(encodeToString)) {
                sb.append("?skey=");
                sb.append(URLEncoder.encode(encodeToString, com.baidu.apollon.heartbeat.a.h));
            }
            try {
                str5 = a(context2, z3, sb, bArr, map);
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.a.a;
            }
            if (z && TextUtils.isEmpty(str5)) {
                try {
                    com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = a2.a.getLong("pu_cl_fd", 0);
                    if (j == 0) {
                        j = System.currentTimeMillis();
                        a2.b.putLong("pu_cl_fd", System.currentTimeMillis());
                        a2.b.commit();
                    }
                    if (currentTimeMillis - j > 86400000) {
                        HashMap hashMap = new HashMap();
                        if (c.m(context)) {
                            hashMap.put("0", Integer.valueOf(a2.k() + 1));
                            hashMap.put("1", Integer.valueOf(a2.j()));
                        } else {
                            hashMap.put("0", Integer.valueOf(a2.k()));
                            hashMap.put("1", Integer.valueOf(a2.j() + 1));
                        }
                        a2.b.putInt("mo_fa_pu_cl", 0);
                        a2.b.commit();
                        a2.b.putInt("wi_fa_pu_cl", 0);
                        a2.b.commit();
                        a2.b.putLong("pu_cl_fd", System.currentTimeMillis());
                        a2.b.commit();
                        c.a(context2, "1003112", (Map<String, Object>) hashMap, false);
                    } else if (c.m(context)) {
                        a2.c(a2.k() + 1);
                    } else {
                        a2.b(a2.j() + 1);
                    }
                } catch (Throwable unused2) {
                    int i4 = com.baidu.sofire.a.a.a;
                }
                throw new NetworkErrorException("response is empty");
            } else if (!z2) {
                return str5;
            } else {
                JSONObject jSONObject = new JSONObject(str5);
                byte[] rd = F.getInstance().rd(Base64.decode(jSONObject.optString("skey"), 0), bytes2);
                String optString = jSONObject.optString(LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE);
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("data");
                }
                jSONObject.optString("request_id");
                byte[] decode = Base64.decode(optString, 0);
                byte[] ad2 = F.getInstance().ad(decode, rd);
                if (decode == null || decode.length <= 0 || (ad2 != null && ad2.length != 0)) {
                    return new String(ad2);
                }
                com.baidu.sofire.j.a a3 = com.baidu.sofire.j.a.a(context);
                long currentTimeMillis2 = System.currentTimeMillis();
                long j2 = a3.a.getLong("se_ae_fd", 0);
                if (j2 == 0) {
                    j2 = System.currentTimeMillis();
                    a3.b.putLong("se_ae_fd", System.currentTimeMillis());
                    a3.b.commit();
                }
                if (currentTimeMillis2 - j2 > 86400000) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", Integer.valueOf(a3.a.getInt("mo_ae_fa_ct", 0) + 1));
                    a3.b.putInt("mo_ae_fa_ct", 0);
                    a3.b.commit();
                    a3.b.putLong("se_ae_fd", System.currentTimeMillis());
                    a3.b.commit();
                    c.a(context2, "1003119", (Map<String, Object>) hashMap2, false);
                } else {
                    a3.b.putInt("mo_ae_fa_ct", a3.a.getInt("mo_ae_fa_ct", 0) + 1);
                    a3.b.commit();
                }
                throw new NetworkErrorException("aes is fail");
            }
        } else {
            throw new NetworkErrorException("conn is blocked");
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.optJSONObject("3").getJSONObject("c");
            com.baidu.sofire.j.a a = com.baidu.sofire.j.a.a(context);
            int optInt = jSONObject2.optInt(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION);
            if (optInt > 0) {
                a.f.putInt("re_net_ty", optInt);
                a.f.commit();
            }
            int optInt2 = jSONObject2.optInt(i.a);
            if (optInt2 > 0) {
                a.f.putInt("re_net_hr", optInt2);
                a.f.commit();
            }
            int optInt3 = jSONObject2.optInt("i2");
            if (optInt3 > 0) {
                a.f.putInt("re_net_hr_bc", optInt3);
                a.f.commit();
            }
            int optInt4 = jSONObject2.optInt(w.a);
            if (optInt4 > 0) {
                a.f.putInt("re_net_wt", optInt4);
                a.f.commit();
            }
            if (jSONObject2.optInt("s1") > 0) {
                a.f.putInt("re_net_one_lt", jSONObject2.optInt("s1"));
                a.f.commit();
            }
            int optInt5 = jSONObject2.optInt("s2");
            if (optInt5 > 0) {
                a.f.putInt("re_net_dy_lt", optInt5);
                a.f.commit();
            }
            int optInt6 = jSONObject2.optInt(t.a);
            if (optInt6 > 0) {
                a.f.putInt("re_net_over", optInt6);
                a.f.commit();
            }
            int optInt7 = jSONObject2.optInt("l1");
            if (optInt7 > 0) {
                a.f.putInt("up_nu_co", optInt7);
                a.f.commit();
            }
            int optInt8 = jSONObject2.optInt("l2");
            if (optInt8 > 0) {
                a.f.putInt("up_nu_li", optInt8);
                a.f.commit();
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x003d A[SYNTHETIC, Splitter:B:31:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.File r3, java.io.File r4) {
        /*
            boolean r0 = com.baidu.sofire.l.c.a((java.io.File) r3)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x0010
            r4.delete()
        L_0x0010:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0038 }
            r1.<init>(r3)     // Catch:{ all -> 0x0038 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0035 }
            r3.<init>(r4)     // Catch:{ all -> 0x0035 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0036 }
        L_0x001f:
            int r0 = r1.read(r4)     // Catch:{ all -> 0x0036 }
            r2 = -1
            if (r0 == r2) goto L_0x002b
            r2 = 0
            r3.write(r4, r2, r0)     // Catch:{ all -> 0x0036 }
            goto L_0x001f
        L_0x002b:
            r3.flush()     // Catch:{ all -> 0x0036 }
            r1.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0045
        L_0x0032:
            int r4 = com.baidu.sofire.a.a.a
            goto L_0x0045
        L_0x0035:
            r3 = r0
        L_0x0036:
            r0 = r1
            goto L_0x0039
        L_0x0038:
            r3 = r0
        L_0x0039:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0043
        L_0x0041:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0043:
            if (r3 == 0) goto L_0x004b
        L_0x0045:
            r3.close()     // Catch:{ all -> 0x0049 }
            goto L_0x004b
        L_0x0049:
            int r3 = com.baidu.sofire.a.a.a
        L_0x004b:
            return
        L_0x004c:
            r4 = move-exception
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0055
        L_0x0053:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0055:
            if (r3 == 0) goto L_0x005d
            r3.close()     // Catch:{ all -> 0x005b }
            goto L_0x005d
        L_0x005b:
            int r3 = com.baidu.sofire.a.a.a
        L_0x005d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.l.a(java.io.File, java.io.File):void");
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, int i2, boolean z) {
        PendingIntent pendingIntent;
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
            intent.setClass(context, MyService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.SOFIRE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleWork");
            intent.putExtra("from", 2);
            if (c.i(context)) {
                pendingIntent = PendingIntent.getService(context, 1001, intent, 201326592);
            } else {
                pendingIntent = PendingIntent.getService(context, 1001, intent, 134217728);
            }
            long currentTimeMillis = System.currentTimeMillis() + (i2 != 0 ? i2 != 1 ? i2 != 2 ? 600000 : 300000 : 180000 : 30000);
            try {
                alarmManager.cancel(pendingIntent);
            } catch (Throwable unused) {
            }
            if (!z) {
                try {
                    alarmManager.set(1, currentTimeMillis, pendingIntent);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            int i3 = com.baidu.sofire.a.a.a;
        }
    }

    public static String a(Context context, boolean z, StringBuilder sb, byte[] bArr, Map<String, String> map) {
        if (z) {
            try {
                if (q.a(context)) {
                    return new q(context).a(sb.toString(), map);
                }
                return new j(context).a(sb.toString(), map);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
                return "";
            }
        } else if (q.a(context)) {
            return new q(context).b(sb.toString(), bArr, map);
        } else {
            return new j(context).a(sb.toString(), bArr, map);
        }
    }
}
