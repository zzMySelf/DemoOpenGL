package fe.fe.o.th;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.File;

public final class ad {
    public static int ad(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_shared_f", 0);
        int i2 = sharedPreferences.getInt("cpu_cores", 0);
        if (i2 != 0) {
            return i2;
        }
        int qw = qw();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("cpu_cores", qw);
        edit.commit();
        return qw;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r0 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r0 != null) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037 A[SYNTHETIC, Splitter:B:15:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long de() {
        /*
            r0 = 0
            java.lang.String r1 = "/system/bin/cat"
            java.lang.String r2 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            java.lang.ProcessBuilder r2 = new java.lang.ProcessBuilder     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            java.lang.Process r1 = r2.start()     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0042, NumberFormatException -> 0x003b, all -> 0x0032 }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x0030, NumberFormatException -> 0x002e, all -> 0x002c }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x0030, NumberFormatException -> 0x002e, all -> 0x002c }
            r2.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x0048
        L_0x002c:
            r0 = move-exception
            goto L_0x0035
        L_0x002e:
            r0 = r2
            goto L_0x003c
        L_0x0030:
            r0 = r2
            goto L_0x0043
        L_0x0032:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0035:
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            throw r0
        L_0x003b:
        L_0x003c:
            if (r0 == 0) goto L_0x0046
        L_0x003e:
            r0.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0046
        L_0x0042:
        L_0x0043:
            if (r0 == 0) goto L_0x0046
            goto L_0x003e
        L_0x0046:
            r0 = 0
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.th.ad.de():long");
    }

    public static long fe(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_shared_f", 0);
        long j = sharedPreferences.getLong("cpu_freq", -1);
        if (j != -1) {
            return j;
        }
        long de2 = de();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("cpu_freq", de2);
        edit.commit();
        return de2;
    }

    public static int qw() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new de()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static String rg() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        return str.replace("_", "-") + "_" + str2.replace("_", "-") + "_" + i2 + "_" + str3.replace("_", "-");
    }
}
