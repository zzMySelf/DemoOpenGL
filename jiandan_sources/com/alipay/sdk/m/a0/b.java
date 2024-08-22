package com.alipay.sdk.m.a0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.z.a;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.common.net.MediaType;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static b b = new b();
    public f a;

    public static b a(f fVar) {
        b bVar = b;
        bVar.a = fVar;
        return bVar;
    }

    public static boolean a(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static String b() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String c() {
        long j;
        try {
            StatFs statFs = new StatFs("/sdcard");
            j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
        if (r2 != null) goto L_0x0063;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[SYNTHETIC, Splitter:B:29:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c A[SYNTHETIC, Splitter:B:33:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d() {
        /*
            java.lang.String r0 = "0000000000000000"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0051 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch:{ all -> 0x0051 }
            r2.<init>(r3)     // Catch:{ all -> 0x0051 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x004f }
            r3.<init>(r2)     // Catch:{ all -> 0x004f }
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch:{ all -> 0x004d }
            r4.<init>(r3)     // Catch:{ all -> 0x004d }
            r1 = 1
            r5 = 1
        L_0x001b:
            r6 = 100
            if (r5 >= r6) goto L_0x0046
            java.lang.String r6 = r4.readLine()     // Catch:{ all -> 0x0044 }
            if (r6 == 0) goto L_0x0046
            java.lang.String r7 = "Serial"
            int r7 = r6.indexOf(r7)     // Catch:{ all -> 0x0044 }
            if (r7 < 0) goto L_0x0041
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch:{ all -> 0x0044 }
            int r5 = r5 + r1
            int r1 = r6.length()     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = r6.substring(r5, r1)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r1.trim()     // Catch:{ all -> 0x0044 }
            goto L_0x0046
        L_0x0041:
            int r5 = r5 + 1
            goto L_0x001b
        L_0x0044:
            r1 = r4
            goto L_0x0053
        L_0x0046:
            r4.close()     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r3.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0063
        L_0x004d:
            goto L_0x0053
        L_0x004f:
            r3 = r1
            goto L_0x0053
        L_0x0051:
            r2 = r1
            r3 = r2
        L_0x0053:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ all -> 0x0059 }
            goto L_0x005a
        L_0x0059:
        L_0x005a:
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0061
        L_0x0060:
        L_0x0061:
            if (r2 == 0) goto L_0x0068
        L_0x0063:
            r2.close()     // Catch:{ all -> 0x0067 }
            goto L_0x0068
        L_0x0067:
        L_0x0068:
            if (r0 != 0) goto L_0x006c
            java.lang.String r0 = ""
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.d():java.lang.String");
    }

    public static String e() {
        String t = t();
        return !a.a(t) ? t : u();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0031 A[SYNTHETIC, Splitter:B:26:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch:{ all -> 0x002e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x002b }
            r2.<init>(r1)     // Catch:{ all -> 0x002b }
            java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = ":\\s+"
            r4 = 2
            java.lang.String[] r0 = r0.split(r3, r4)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0027
            int r3 = r0.length     // Catch:{ all -> 0x002c }
            r4 = 1
            if (r3 <= r4) goto L_0x0027
            r0 = r0[r4]     // Catch:{ all -> 0x002c }
            r1.close()     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r2.close()     // Catch:{ all -> 0x0026 }
        L_0x0026:
            return r0
        L_0x0027:
            r1.close()     // Catch:{ all -> 0x0038 }
            goto L_0x0038
        L_0x002b:
            r2 = r0
        L_0x002c:
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r0
        L_0x002f:
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0036
        L_0x0035:
        L_0x0036:
            if (r2 == 0) goto L_0x003b
        L_0x0038:
            r2.close()     // Catch:{ all -> 0x003b }
        L_0x003b:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.f():java.lang.String");
    }

    public static String f(Context context) {
        int i2 = 0;
        try {
            i2 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i2 == 1 ? "1" : "0";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        if (r0 == null) goto L_0x0039;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[SYNTHETIC, Splitter:B:19:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g() {
        /*
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            r2 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x002c }
            r4.<init>(r0)     // Catch:{ all -> 0x002c }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0029 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r5)     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0025
            java.lang.String r5 = "\\s+"
            java.lang.String[] r1 = r1.split(r5)     // Catch:{ all -> 0x002a }
            r5 = 1
            r1 = r1[r5]     // Catch:{ all -> 0x002a }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x002a }
            long r2 = (long) r1
        L_0x0025:
            r4.close()     // Catch:{ all -> 0x0036 }
            goto L_0x0036
        L_0x0029:
            r0 = r1
        L_0x002a:
            r1 = r4
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0034
        L_0x0033:
        L_0x0034:
            if (r0 == 0) goto L_0x0039
        L_0x0036:
            r0.close()     // Catch:{ all -> 0x0039 }
        L_0x0039:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.g():java.lang.String");
    }

    public static String g(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaType.AUDIO_TYPE);
            int i2 = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i2));
            jSONObject.put(NotificationCompat.CATEGORY_CALL, String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static String h() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String h(android.content.Context r3) {
        /*
            if (r3 == 0) goto L_0x004d
            java.lang.String r0 = "sensor"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch:{ all -> 0x004d }
            android.hardware.SensorManager r3 = (android.hardware.SensorManager) r3     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x004d
            r0 = -1
            java.util.List r3 = r3.getSensorList(r0)     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x004d
            int r0 = r3.size()     // Catch:{ all -> 0x004d }
            if (r0 <= 0) goto L_0x004d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r0.<init>()     // Catch:{ all -> 0x004d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x004d }
        L_0x0022:
            boolean r1 = r3.hasNext()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r3.next()     // Catch:{ all -> 0x004d }
            android.hardware.Sensor r1 = (android.hardware.Sensor) r1     // Catch:{ all -> 0x004d }
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x004d }
            r0.append(r2)     // Catch:{ all -> 0x004d }
            int r2 = r1.getVersion()     // Catch:{ all -> 0x004d }
            r0.append(r2)     // Catch:{ all -> 0x004d }
            java.lang.String r1 = r1.getVendor()     // Catch:{ all -> 0x004d }
            r0.append(r1)     // Catch:{ all -> 0x004d }
            goto L_0x0022
        L_0x0044:
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x004d }
            java.lang.String r3 = com.alipay.sdk.m.z.a.e(r3)     // Catch:{ all -> 0x004d }
            goto L_0x004e
        L_0x004d:
            r3 = 0
        L_0x004e:
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = ""
        L_0x0052:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.h(android.content.Context):java.lang.String");
    }

    public static String i() {
        long j;
        try {
            StatFs statFs = new StatFs("/sdcard");
            j = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String i(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0)) {
                    for (Sensor next : sensorList) {
                        if (next != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", next.getName());
                            jSONObject.put("version", next.getVersion());
                            jSONObject.put("vendor", next.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public static String j() {
        String str;
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            str = (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2.newInstance(), new Object[]{"gsm.version.baseband", "no message"});
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String k(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String l() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String l(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String m() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String m(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String n() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String n(android.content.Context r3) {
        /*
            java.lang.String r0 = ""
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0021 }
            r2 = 29
            if (r1 < r2) goto L_0x000f
            goto L_0x0021
        L_0x000f:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0021 }
            r2 = 26
            if (r1 < r2) goto L_0x001e
            r1 = 28
            if (r3 < r1) goto L_0x001e
            java.lang.String r3 = android.os.Build.getSerial()     // Catch:{ all -> 0x0021 }
            goto L_0x0022
        L_0x001e:
            java.lang.String r3 = android.os.Build.SERIAL     // Catch:{ all -> 0x0021 }
            goto L_0x0022
        L_0x0021:
            r3 = r0
        L_0x0022:
            if (r3 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r0 = r3
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.n(android.content.Context):java.lang.String");
    }

    public static String o() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append(ChipTextInputComboView.TextFormatter.DEFAULT_TEXT + ":");
            for (int i2 = 0; i2 < 7; i2++) {
                sb.append(new File(strArr[i2]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|15|16|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0032 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o(android.content.Context r7) {
        /*
            java.lang.String r0 = "keyguard"
            java.lang.Object r7 = r7.getSystemService(r0)     // Catch:{ all -> 0x0048 }
            android.app.KeyguardManager r7 = (android.app.KeyguardManager) r7     // Catch:{ all -> 0x0048 }
            boolean r7 = r7.isKeyguardSecure()     // Catch:{ all -> 0x0048 }
            r0 = 0
            if (r7 != 0) goto L_0x0013
            java.lang.String r7 = "0:0"
            return r7
        L_0x0013:
            java.lang.String r7 = "/data/system/password.key"
            java.lang.String r2 = "/data/system/gesture.key"
            java.lang.String r3 = "/data/system/gatekeeper.password.key"
            java.lang.String r4 = "/data/system/gatekeeper.gesture.key"
            java.lang.String r5 = "/data/system/gatekeeper.pattern.key"
            java.lang.String[] r7 = new java.lang.String[]{r7, r2, r3, r4, r5}     // Catch:{ all -> 0x0048 }
            r2 = 0
        L_0x0022:
            r3 = 5
            if (r2 >= r3) goto L_0x0039
            r3 = r7[r2]     // Catch:{ all -> 0x0048 }
            r4 = -1
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0032 }
            r6.<init>(r3)     // Catch:{ all -> 0x0032 }
            long r4 = r6.lastModified()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            long r0 = java.lang.Math.max(r4, r0)     // Catch:{ all -> 0x0048 }
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0039:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "1:"
            r7.<init>(r2)     // Catch:{ all -> 0x0048 }
            r7.append(r0)     // Catch:{ all -> 0x0048 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0048 }
            return r7
        L_0x0048:
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.o(android.content.Context):java.lang.String");
    }

    public static String p() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb = new StringBuilder();
        sb.append(ChipTextInputComboView.TextFormatter.DEFAULT_TEXT);
        sb.append(":");
        for (int i2 = 0; i2 <= 0; i2++) {
            try {
                Class.forName(strArr[0]);
                sb.append("1");
            } catch (Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String p(android.content.Context r3) {
        /*
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r1)     // Catch:{ all -> 0x003f }
            r1 = 0
            android.content.Intent r3 = r3.registerReceiver(r1, r0)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = "level"
            r1 = -1
            int r0 = r3.getIntExtra(r0, r1)     // Catch:{ all -> 0x003f }
            java.lang.String r2 = "status"
            int r3 = r3.getIntExtra(r2, r1)     // Catch:{ all -> 0x003f }
            r1 = 2
            if (r3 == r1) goto L_0x0022
            r1 = 5
            if (r3 != r1) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = 1
        L_0x0023:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r1.<init>()     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x002d
            java.lang.String r3 = "1"
            goto L_0x002f
        L_0x002d:
            java.lang.String r3 = "0"
        L_0x002f:
            r1.append(r3)     // Catch:{ all -> 0x003f }
            java.lang.String r3 = ":"
            r1.append(r3)     // Catch:{ all -> 0x003f }
            r1.append(r0)     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x003f }
            return r3
        L_0x003f:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.p(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080 A[SYNTHETIC, Splitter:B:20:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String q() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.lang.String r2 = "/system/build.prop"
            java.lang.String r3 = "ro.product.name=sdk"
            r1.put(r2, r3)
            java.lang.String r2 = "/proc/tty/drivers"
            java.lang.String r3 = "goldfish"
            r1.put(r2, r3)
            java.lang.String r2 = "/proc/cpuinfo"
            r1.put(r2, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "00"
            r2.append(r3)
            java.lang.String r3 = ":"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.util.Set r2 = r1.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x003b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0086
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            r5 = 48
            java.io.LineNumberReader r6 = new java.io.LineNumberReader     // Catch:{ all -> 0x007a }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x007a }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x007a }
            r8.<init>(r3)     // Catch:{ all -> 0x007a }
            r7.<init>(r8)     // Catch:{ all -> 0x007a }
            r6.<init>(r7)     // Catch:{ all -> 0x007a }
        L_0x0059:
            java.lang.String r4 = r6.readLine()     // Catch:{ all -> 0x0078 }
            if (r4 == 0) goto L_0x0071
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x0078 }
            java.lang.Object r7 = r1.get(r3)     // Catch:{ all -> 0x0078 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0078 }
            boolean r4 = r4.contains(r7)     // Catch:{ all -> 0x0078 }
            if (r4 == 0) goto L_0x0059
            r5 = 49
        L_0x0071:
            r0.append(r5)
            r6.close()     // Catch:{ all -> 0x0084 }
            goto L_0x003b
        L_0x0078:
            r4 = r6
            goto L_0x007b
        L_0x007a:
        L_0x007b:
            r0.append(r5)
            if (r4 == 0) goto L_0x003b
            r4.close()     // Catch:{ all -> 0x0084 }
            goto L_0x003b
        L_0x0084:
            goto L_0x003b
        L_0x0086:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.q():java.lang.String");
    }

    public static String q(Context context) {
        if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String r() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChipTextInputComboView.TextFormatter.DEFAULT_TEXT + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                String str2 = null;
                String str3 = (String) Build.class.getField(str).get((Object) null);
                String str4 = (String) linkedHashMap.get(str);
                if (str3 != null) {
                    str2 = str3.toLowerCase();
                }
                if (str2 != null && str2.contains(str4)) {
                    c = '1';
                }
            } catch (Throwable unused) {
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String s() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChipTextInputComboView.TextFormatter.DEFAULT_TEXT + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put(RomUtils.PROP_RO_BUILD_FINGERPRINT, "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            String str2 = (String) linkedHashMap.get(str);
            String b2 = a.b(str, "");
            if (b2 != null && b2.contains(str2)) {
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f A[SYNTHETIC, Splitter:B:23:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String t() {
        /*
            java.lang.String r0 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x002c }
            r2.<init>(r0)     // Catch:{ all -> 0x002c }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x002a }
            r3 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r2, r3)     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x0028 }
            boolean r3 = com.alipay.sdk.m.z.a.a((java.lang.String) r1)     // Catch:{ all -> 0x0028 }
            if (r3 != 0) goto L_0x0024
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0028 }
            r0.close()     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r2.close()     // Catch:{ all -> 0x0023 }
        L_0x0023:
            return r1
        L_0x0024:
            r0.close()     // Catch:{ all -> 0x0036 }
            goto L_0x0036
        L_0x0028:
            r1 = r0
            goto L_0x002d
        L_0x002a:
            goto L_0x002d
        L_0x002c:
            r2 = r1
        L_0x002d:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0034
        L_0x0033:
        L_0x0034:
            if (r2 == 0) goto L_0x0039
        L_0x0036:
            r2.close()     // Catch:{ all -> 0x0039 }
        L_0x0039:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.t():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0049, code lost:
        if (r0 == null) goto L_0x004e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044 A[SYNTHETIC, Splitter:B:26:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String u() {
        /*
            java.lang.String r0 = "/proc/cpuinfo"
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0041 }
            r3.<init>(r0)     // Catch:{ all -> 0x0041 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x003e }
            r4 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3, r4)     // Catch:{ all -> 0x003e }
        L_0x0011:
            java.lang.String r2 = r0.readLine()     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003a
            boolean r4 = com.alipay.sdk.m.z.a.a((java.lang.String) r2)     // Catch:{ all -> 0x003f }
            if (r4 != 0) goto L_0x0011
            java.lang.String r4 = ":"
            java.lang.String[] r2 = r2.split(r4)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x0011
            int r4 = r2.length     // Catch:{ all -> 0x003f }
            r5 = 1
            if (r4 <= r5) goto L_0x0011
            r4 = 0
            r4 = r2[r4]     // Catch:{ all -> 0x003f }
            java.lang.String r6 = "BogoMIPS"
            boolean r4 = r4.contains(r6)     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0011
            r2 = r2[r5]     // Catch:{ all -> 0x003f }
            java.lang.String r1 = r2.trim()     // Catch:{ all -> 0x003f }
        L_0x003a:
            r3.close()     // Catch:{ all -> 0x004b }
            goto L_0x004b
        L_0x003e:
            r0 = r2
        L_0x003f:
            r2 = r3
            goto L_0x0042
        L_0x0041:
            r0 = r2
        L_0x0042:
            if (r2 == 0) goto L_0x0049
            r2.close()     // Catch:{ all -> 0x0048 }
            goto L_0x0049
        L_0x0048:
        L_0x0049:
            if (r0 == 0) goto L_0x004e
        L_0x004b:
            r0.close()     // Catch:{ all -> 0x004e }
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.u():java.lang.String");
    }

    private String v() {
        String a2 = d.a("ip");
        if (a2 != null) {
            return a2;
        }
        String str = "";
        if (this.a.isBackgroundRunning()) {
            return str;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && a2 == null) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        a2 = nextElement.getHostAddress().toString();
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (a2 != null) {
            str = a2;
        }
        d.a("ip", str);
        return str;
    }

    public final String a() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    public final synchronized String a(Context context) {
        String subscriberId = this.a.getSubscriberId();
        if (subscriberId != null) {
            return subscriberId;
        }
        String a2 = d.a("imsi");
        if (a2 != null) {
            return a2;
        }
        if (this.a.isBackgroundRunning()) {
            return "";
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (a2 == null) {
            a2 = "";
        }
        d.a("imsi", a2);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        if (com.baidu.android.common.others.lang.StringUtil.NULL_STRING.equals(r0) != false) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String b(android.content.Context r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "NetworkOperatorName"
            java.lang.String r0 = com.alipay.sdk.m.a0.d.a(r0)     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r2)
            return r0
        L_0x000b:
            if (r3 == 0) goto L_0x001d
            java.lang.String r1 = "phone"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch:{ all -> 0x001c }
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ all -> 0x001c }
            if (r3 == 0) goto L_0x001d
            java.lang.String r0 = r3.getNetworkOperatorName()     // Catch:{ all -> 0x001c }
            goto L_0x001d
        L_0x001c:
        L_0x001d:
            if (r0 == 0) goto L_0x0027
            java.lang.String r3 = "null"
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0029
        L_0x0027:
            java.lang.String r0 = ""
        L_0x0029:
            java.lang.String r3 = "NetworkOperatorName"
            com.alipay.sdk.m.a0.d.a(r3, r0)     // Catch:{ all -> 0x0030 }
            monitor-exit(r2)
            return r0
        L_0x0030:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.a0.b.b(android.content.Context):java.lang.String");
    }

    public final synchronized String c(Context context) {
        String a2 = d.a("SimSerial");
        if (a2 != null) {
            return a2;
        }
        if (this.a.isBackgroundRunning()) {
            return "";
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        d.a("SimSerial", a2);
        return a2;
    }

    public final synchronized String d(Context context) {
        String androidId = this.a.getAndroidId();
        if (androidId != null) {
            return androidId;
        }
        String a2 = d.a("ANDROIDID");
        if (a2 != null) {
            return a2;
        }
        if (this.a.isBackgroundRunning()) {
            return "";
        }
        try {
            a2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
        }
        if (a2 == null) {
            a2 = "";
        }
        d.a("ANDROIDID", a2);
        return a2;
    }

    public final String e(Context context) {
        try {
            String q = q(context);
            String v = v();
            if (a.b(q) && a.b(v)) {
                return q + ":" + v();
            }
        } catch (Throwable unused) {
        }
        return "";
    }
}
