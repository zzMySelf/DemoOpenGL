package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.cpu.booster.stats.StatsConstants;
import com.baidu.searchbox.aisearch.utils.DateUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f7177a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final Set<String> f527a;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f528a = true;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f529a = {DateUtils.INVALID_TIMES, "a-", "u-", "v-", "o-", "g-", "d-"};

    /* renamed from: b  reason: collision with root package name */
    private static String f7178b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f7179c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f7180d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f7181e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final String f7182f = String.valueOf(2);

    static {
        HashSet hashSet = new HashSet();
        f527a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m8615a(int i2) {
        if (i2 > 0) {
            String[] strArr = f529a;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return f529a[0];
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f529a;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    public static synchronized String a(Context context, boolean z) {
        String str;
        synchronized (i.class) {
            if (f7180d == null) {
                String b2 = b(context);
                int i2 = 1;
                switch (1) {
                    case 1:
                        String str2 = "";
                        if (!j.d()) {
                            str2 = z ? c(context) : j(context);
                        }
                        String a2 = a(context);
                        if (!(Build.VERSION.SDK_INT < 26) && b(str2)) {
                            if (!b(a2)) {
                            }
                        }
                        b2 = str2 + b2 + a2;
                        break;
                    case 2:
                        String b3 = aw.a(context).b();
                        if (!TextUtils.isEmpty(b3)) {
                            b2 = b3 + b2;
                            i2 = 2;
                            break;
                        }
                    case 3:
                    case 4:
                        String a3 = aw.a(context).a();
                        if (!TextUtils.isEmpty(a3) && !a3.startsWith("00000000-0000-0000-0000-000000000000")) {
                            i2 = 4;
                            b2 = a3;
                            break;
                        }
                    case 5:
                        if (!TextUtils.isEmpty(b2)) {
                            i2 = 5;
                            break;
                        }
                    case 6:
                        b2 = k(context);
                        i2 = 6;
                        break;
                    default:
                        b2 = "";
                        break;
                }
                b.b("devid rule select:" + i2);
                if (i2 == 3) {
                    f7180d = b2;
                } else {
                    f7180d = a(i2) + bo.b(b2);
                }
            }
            str = f7180d;
        }
        return str;
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown")) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static String a(Context context) {
        return null;
    }

    public static String b(Context context) {
        String str = f7178b;
        if (str != null || !f528a) {
            return str;
        }
        boolean c2 = c(context);
        f528a = c2;
        if (!c2) {
            return null;
        }
        try {
            f7178b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th2) {
            b.a("failure to get androidId: " + th2);
        }
        return f7178b;
    }

    @Deprecated
    private static String j(Context context) {
        return "";
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return null;
    }

    @Deprecated
    public static String f(Context context) {
        return "";
    }

    public static synchronized String g(Context context) {
        synchronized (i.class) {
            String str = f7181e;
            if (str != null) {
                return str;
            }
            String b2 = b(context);
            String b3 = bo.b(b2 + a(context));
            f7181e = b3;
            return b3;
        }
    }

    public static synchronized String h(Context context) {
        String b2;
        synchronized (i.class) {
            b2 = bo.b(b(context) + null);
        }
        return b2;
    }

    public static String i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static int a() {
        Object a2 = bj.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return Integer.class.cast(a2).intValue();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m8614a() {
        return a(b()) + "GB";
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[SYNTHETIC, Splitter:B:25:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e A[SYNTHETIC, Splitter:B:31:0x005e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)
            boolean r0 = r0.exists()
            r2 = 0
            if (r0 == 0) goto L_0x0062
            r0 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x005b, all -> 0x004f }
            r3.<init>(r1)     // Catch:{ Exception -> 0x005b, all -> 0x004f }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x005b, all -> 0x004f }
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x005b, all -> 0x004f }
            java.lang.String r0 = r1.readLine()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            if (r3 != 0) goto L_0x0043
            java.lang.String r3 = "\\s+"
            java.lang.String[] r0 = r0.split(r3)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            if (r0 == 0) goto L_0x0043
            int r3 = r0.length     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r4 = 2
            if (r3 < r4) goto L_0x0043
            r3 = 1
            r4 = r0[r3]     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            boolean r4 = android.text.TextUtils.isDigitsOnly(r4)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            if (r4 == 0) goto L_0x0043
            r0 = r0[r3]     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r2 = r0
        L_0x0043:
            r1.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0047:
            goto L_0x0062
        L_0x0048:
            r0 = move-exception
            goto L_0x0047
        L_0x004a:
            r0 = move-exception
            goto L_0x0053
        L_0x004c:
            r0 = move-exception
            r0 = r1
            goto L_0x005c
        L_0x004f:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0053:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r1 = move-exception
        L_0x005a:
            throw r0
        L_0x005b:
            r1 = move-exception
        L_0x005c:
            if (r0 == 0) goto L_0x0062
            r0.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x0047
        L_0x0062:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.i.b():int");
    }

    private static float a(int i2) {
        float f2 = (((float) (((((i2 + 102400) / 524288) + 1) * 512) * 1024)) / 1024.0f) / 1024.0f;
        double d2 = (double) f2;
        if (d2 > 0.5d) {
            return (float) Math.ceil(d2);
        }
        return f2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m8619b() {
        return a(((((double) a(Environment.getDataDirectory())) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    private static double a(double d2) {
        int i2 = 1;
        while (true) {
            double d3 = (double) i2;
            if (d3 >= d2) {
                return d3;
            }
            i2 <<= 1;
        }
    }

    public static String c() {
        return b() + "KB";
    }

    public static String d() {
        return (a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8617a(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m8620b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8616a() {
        return a() <= 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8618a(Context context, String str) {
        PackageInfo packageInfo = (PackageInfo) bj.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return true;
        }
        if ((packageInfo.applicationInfo.flags & 8388608) != 8388608) {
            return true;
        }
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m8621c(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            if (!(packageInfo == null || packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || !packageInfo.applicationInfo.metaData.containsKey("supportGetAndroidID"))) {
                boolean z = packageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                b.b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z);
                return z;
            }
        } catch (Exception e2) {
            b.a("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e2.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (!(serviceInfo == null || serviceInfo.metaData == null || !serviceInfo.metaData.containsKey("supportGetAndroidID"))) {
                b.b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e3) {
            b.a("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e3.getMessage());
        }
        b.b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    }

    private static String k(Context context) {
        String string = context.getSharedPreferences(StatsConstants.EXT_KEY_DEVICE_INFO, 0).getString("default_id", (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String l = l(context);
        a(context, l);
        return l;
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(StatsConstants.EXT_KEY_DEVICE_INFO, 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", (String) null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            b.a("default_id exist,do not change it.");
        }
    }

    private static String l(Context context) {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.VERSION.INCREMENTAL;
        int a2 = a();
        String packageName = context.getPackageName();
        long currentTimeMillis = System.currentTimeMillis();
        String a3 = bo.a(16);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("_").append(str2).append("_").append(i2).append("_").append(str3).append("_").append(str4).append("_").append(a2).append("_").append(packageName).append("_").append(currentTimeMillis).append("_").append(a3);
        return bl.a(sb.toString());
    }
}
