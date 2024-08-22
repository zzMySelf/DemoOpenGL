package com.baidu.sofire.xclient.privacycontrol.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import com.baidu.sofire.xclient.privacycontrol.h.a;
import com.baidu.sofire.xclient.privacycontrol.lib.Constant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    public static String a;
    public static String b;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return c.a();
        }
        int i2 = c.n;
        if (!TextUtils.isEmpty(str)) {
            c cVar = new c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean z = true;
                cVar.a = jSONObject.optInt("s", 1);
                JSONArray optJSONArray = jSONObject.optJSONArray("c_p");
                if (optJSONArray != null) {
                    cVar.b = c.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("b_p");
                if (optJSONArray2 != null) {
                    cVar.c = c.a(optJSONArray2);
                }
                jSONObject.optInt("is_p", 1);
                cVar.e = jSONObject.optInt("o_f", 1) == 1;
                cVar.h = jSONObject.optLong("c_i", c.m);
                cVar.f1097i = jSONObject.optInt("r_s", 0) == 1;
                cVar.f = jSONObject.optInt("r_c", 0) == 1;
                if (jSONObject.optInt("r_m_c", 0) != 1) {
                    z = false;
                }
                cVar.g = z;
                JSONObject optJSONObject = jSONObject.optJSONObject("stack");
                if (optJSONObject != null) {
                    cVar.j = c.a(optJSONObject.optJSONArray("r_p"));
                    cVar.k = c.a(optJSONObject.optJSONArray("m"));
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("b_m");
                if (optJSONArray3 != null) {
                    cVar.l = c.a(optJSONArray3);
                }
                return cVar;
            } catch (Throwable unused) {
            }
        }
        return c.a();
    }

    public static String a(String str, String str2) {
        char c;
        try {
            if (TextUtils.isEmpty(str2)) {
                return "0";
            }
            if (str.startsWith(Constant.LOCAL_CACHE_MAC_NET)) {
                byte[] decode = Base64.decode(str2, 0);
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < decode.length; i2++) {
                    if (i2 != 0) {
                        sb.append(':');
                    }
                    String hexString = Integer.toHexString(decode[i2] & 255);
                    if (hexString.length() == 1) {
                        hexString = 0 + hexString;
                    }
                    sb.append(hexString);
                }
                str2 = sb.toString().toUpperCase();
            }
            char[] charArray = str2.toCharArray();
            if (charArray != null) {
                if (charArray.length != 0) {
                    int length = charArray.length;
                    StringBuilder sb2 = new StringBuilder();
                    for (int i3 = 0; i3 < length; i3++) {
                        if (!(i3 == 0 || i3 == 1 || i3 == length - 1)) {
                            if (i3 != length - 2) {
                                if ((Constant.LOCAL_CACHE_MAC_NET.equals(str) || Constant.LOCAL_CACHE_MAC_WIFI.equals(str)) && charArray[i3] == ':') {
                                    c = charArray[i3];
                                    sb2.append(c);
                                } else {
                                    sb2.append("*");
                                }
                            }
                        }
                        c = charArray[i3];
                        sb2.append(c);
                    }
                    return sb2.toString();
                }
            }
            return "0";
        } catch (Throwable unused) {
        }
    }

    public static void a(c cVar, int i2, String str, long j, long[] jArr, String str2, int i3, String str3) {
        try {
            Context context = PrvControlManager.getInstance().getContext();
            if (context != null) {
                a.a().post(new a(cVar, i3, str, i2, j, jArr, context, str3, str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                    return false;
                }
                return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:6|(4:8|9|10|(2:12|13))(1:16)|17|(8:18|19|20|21|22|(1:24)|25|(2:27|28))|29|31|32|(6:33|34|35|36|(2:37|(2:(2:40|58)(2:41|57)|42)(1:56))|43)|44|45|50|51|(2:53|54)(1:61)) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009c, code lost:
        if (r1 != null) goto L_0x0095;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x009f */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a5 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(int r7) {
        /*
            r0 = 0
            java.lang.String r1 = b     // Catch:{ all -> 0x00ac }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ac }
            if (r1 != 0) goto L_0x000c
            java.lang.String r7 = b     // Catch:{ all -> 0x00ac }
            return r7
        L_0x000c:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00ac }
            r2 = 28
            if (r1 < r2) goto L_0x0026
            java.lang.String r1 = android.app.Application.getProcessName()     // Catch:{ all -> 0x00ac }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0027
            java.lang.String r7 = r1.trim()     // Catch:{ all -> 0x0023 }
            b = r7     // Catch:{ all -> 0x0023 }
            return r7
        L_0x0023:
            r0 = r1
            goto L_0x00ac
        L_0x0026:
            r1 = r0
        L_0x0027:
            java.lang.String r2 = "android.app.ActivityThread"
            r3 = 1
            r4 = 0
            java.lang.Class<android.app.Application> r5 = android.app.Application.class
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x005a }
            java.lang.Class r2 = java.lang.Class.forName(r2, r4, r5)     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "currentProcessName"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ all -> 0x005a }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x005a }
            r2.setAccessible(r3)     // Catch:{ all -> 0x005a }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x005a }
            java.lang.Object r2 = r2.invoke(r0, r5)     // Catch:{ all -> 0x005a }
            boolean r5 = r2 instanceof java.lang.String     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x004d
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x005a }
            r1 = r2
        L_0x004d:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x005a }
            if (r2 != 0) goto L_0x005a
            java.lang.String r2 = r1.trim()     // Catch:{ all -> 0x005a }
            b = r2     // Catch:{ all -> 0x005a }
            return r2
        L_0x005a:
            java.lang.String r2 = "/proc/%d/cmdline"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x0023 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0023 }
            r5[r4] = r7     // Catch:{ all -> 0x0023 }
            java.lang.String r7 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x0023 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x009b }
            r1.<init>(r7)     // Catch:{ all -> 0x009b }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x0099 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0099 }
            java.lang.String r5 = "UTF-8"
            r2.<init>(r1, r5)     // Catch:{ all -> 0x0099 }
            r7.<init>(r2)     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r2.<init>()     // Catch:{ all -> 0x0099 }
        L_0x007e:
            java.lang.String r5 = r7.readLine()     // Catch:{ all -> 0x0099 }
            if (r5 == 0) goto L_0x0091
            if (r3 != 0) goto L_0x008c
            r6 = 10
            r2.append(r6)     // Catch:{ all -> 0x0099 }
            goto L_0x008d
        L_0x008c:
            r3 = 0
        L_0x008d:
            r2.append(r5)     // Catch:{ all -> 0x0099 }
            goto L_0x007e
        L_0x0091:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0099 }
        L_0x0095:
            r1.close()     // Catch:{ all -> 0x009f }
            goto L_0x009f
        L_0x0099:
            goto L_0x009c
        L_0x009b:
            r1 = r0
        L_0x009c:
            if (r1 == 0) goto L_0x009f
            goto L_0x0095
        L_0x009f:
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00ac }
            if (r7 != 0) goto L_0x00ac
            java.lang.String r7 = r0.trim()     // Catch:{ all -> 0x00ac }
            b = r7     // Catch:{ all -> 0x00ac }
            return r7
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.b.b.a(int):java.lang.String");
    }

    public static boolean a(c cVar, long j) {
        return System.currentTimeMillis() - j >= (cVar.h * 60) * 1000;
    }

    public static boolean a(c cVar, String str) {
        ArrayList<String> arrayList;
        if (!TextUtils.isEmpty(str) && cVar != null && (arrayList = cVar.l) != null && !arrayList.isEmpty()) {
            return !arrayList.contains(str);
        }
        return true;
    }
}
