package dxm.sasdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import rg.qw.pf;

public final class SensorsDataUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static final SimpleDateFormat f7562ad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);

    /* renamed from: de  reason: collision with root package name */
    public static final List<String> f7563de = new ArrayList<String>() {
        {
            add("9774d56d682e549c");
            add("0123456789abcdef");
        }
    };
    public static String qw;

    static {
        new HashMap<String, String>() {
            {
                put("46000", "中国移动");
                put("46002", "中国移动");
                put("46007", "中国移动");
                put("46008", "中国移动");
                put("46001", "中国联通");
                put("46006", "中国联通");
                put("46009", "中国联通");
                put("46003", "中国电信");
                put("46005", "中国电信");
                put("46011", "中国电信");
            }
        };
    }

    public static void ad(Context context) {
        try {
            SharedPreferences.Editor edit = fe(context).edit();
            edit.putString("sensorsdata.user.agent", (String) null);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String de(Context context) {
        if (!TextUtils.isEmpty(qw)) {
            return qw;
        }
        try {
            qw = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qw;
    }

    public static SharedPreferences fe(Context context) {
        return context.getSharedPreferences("dxm.sasdk.sa", 0);
    }

    public static String i(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        if (!qw(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "NULL";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                if (activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        return "WIFI";
                    }
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo2 != null) {
                        NetworkInfo.State state2 = networkInfo2.getState();
                        String subtypeName = networkInfo2.getSubtypeName();
                        if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                case 16:
                                    return "2G";
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                case 18:
                                    return "3G";
                                case 13:
                                    return "4G";
                                case 20:
                                    return "5G";
                                default:
                                    if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                        return "3G";
                                    }
                                    return "NULL";
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "NULL";
    }

    public static boolean qw(Context context, String str) {
        try {
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return true;
            }
            pf.ad("SA.SensorsDataUtils", "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"" + str + "\" />");
            return false;
        } catch (Exception e) {
            pf.ad("SA.SensorsDataUtils", e.toString());
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|(3:4|5|(4:7|8|9|(1:11))(4:16|17|18|19))|20|21|(1:23)|24|(1:26)|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A[Catch:{ Exception -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[Catch:{ Exception -> 0x008a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String rg(android.content.Context r11) {
        /*
            java.lang.String r0 = "sensorsdata.user.agent"
            r1 = 0
            android.content.SharedPreferences r2 = fe(r11)     // Catch:{ Exception -> 0x008a }
            java.lang.String r3 = r2.getString(r0, r1)     // Catch:{ Exception -> 0x008a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x008a }
            if (r4 == 0) goto L_0x006d
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x008a }
            r5 = 17
            r6 = 0
            if (r4 < r5) goto L_0x0035
            java.lang.String r4 = "android.webkit.WebSettings"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x002d }
            java.lang.String r5 = "getDefaultUserAgent"
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x002d }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ Exception -> 0x002d }
            if (r4 == 0) goto L_0x006d
            java.lang.String r3 = android.webkit.WebSettings.getDefaultUserAgent(r11)     // Catch:{ Exception -> 0x002d }
            goto L_0x006d
        L_0x002d:
            java.lang.String r11 = "SA.SensorsDataUtils"
            java.lang.String r4 = "WebSettings NoSuchMethod: getDefaultUserAgent"
            rg.qw.pf.ad(r11, r4)     // Catch:{ Exception -> 0x008a }
            goto L_0x006d
        L_0x0035:
            java.lang.String r4 = "android.webkit.WebSettingsClassic"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x006d }
            r5 = 2
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x006d }
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r7[r6] = r8     // Catch:{ Exception -> 0x006d }
            java.lang.String r8 = "android.webkit.WebViewClassic"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x006d }
            r9 = 1
            r7[r9] = r8     // Catch:{ Exception -> 0x006d }
            java.lang.reflect.Constructor r7 = r4.getDeclaredConstructor(r7)     // Catch:{ Exception -> 0x006d }
            r7.setAccessible(r9)     // Catch:{ Exception -> 0x006d }
            java.lang.String r8 = "getUserAgentString"
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x006d }
            java.lang.reflect.Method r4 = r4.getMethod(r8, r10)     // Catch:{ Exception -> 0x006d }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x006d }
            r5[r6] = r11     // Catch:{ Exception -> 0x006d }
            r5[r9] = r1     // Catch:{ Exception -> 0x006d }
            java.lang.Object r11 = r7.newInstance(r5)     // Catch:{ Exception -> 0x006d }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x006d }
            java.lang.Object r11 = r4.invoke(r11, r5)     // Catch:{ Exception -> 0x006d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x006d }
            r3 = r11
        L_0x006d:
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x008a }
            if (r11 == 0) goto L_0x0079
            java.lang.String r11 = "http.agent"
            java.lang.String r3 = java.lang.System.getProperty(r11)     // Catch:{ Exception -> 0x008a }
        L_0x0079:
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x008a }
            if (r11 != 0) goto L_0x0089
            android.content.SharedPreferences$Editor r11 = r2.edit()     // Catch:{ Exception -> 0x008a }
            r11.putString(r0, r3)     // Catch:{ Exception -> 0x008a }
            r11.apply()     // Catch:{ Exception -> 0x008a }
        L_0x0089:
            return r3
        L_0x008a:
            r11 = move-exception
            r11.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dxm.sasdk.util.SensorsDataUtils.rg(android.content.Context):java.lang.String");
    }

    public static boolean th(Context context) {
        if (!qw(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void uk(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof Date) {
                synchronized (f7562ad) {
                    jSONObject2.put(next, f7562ad.format((Date) obj));
                }
            } else {
                jSONObject2.put(next, obj);
            }
        }
    }

    public static boolean yj(String str) {
        if (!TextUtils.isEmpty(str) && !f7563de.contains(str.toLowerCase())) {
            return true;
        }
        return false;
    }
}
