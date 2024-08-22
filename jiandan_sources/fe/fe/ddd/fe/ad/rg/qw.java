package fe.fe.ddd.fe.ad.rg;

import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static int f1406ad = -1;
    public static final boolean qw = AppConfig.rg();

    /* renamed from: fe.fe.ddd.fe.ad.rg.qw$qw  reason: collision with other inner class name */
    public static class C0077qw implements FileFilter {
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static float ad() {
        float f;
        int de2 = de();
        if (de2 > 0) {
            f = 0.0f;
            for (int i2 = 0; i2 < de2; i2++) {
                float fe2 = fe(qw(i2));
                if (fe2 > 0.0f && fe2 > f) {
                    f = fe2;
                }
            }
        } else {
            f = 0.0f;
        }
        if (f > 0.0f) {
            return f;
        }
        return -1.0f;
    }

    public static int de() {
        int i2;
        C0077qw qwVar = new C0077qw();
        if (f1406ad <= 0) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(qwVar);
                if (listFiles == null) {
                    i2 = -1;
                } else {
                    i2 = listFiles.length;
                }
                f1406ad = i2;
            } catch (Exception unused) {
                boolean z = qw;
                f1406ad = -1;
            }
        }
        return f1406ad;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:5|6|7|8|9|10|11|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0025 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003f A[SYNTHETIC, Splitter:B:29:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0046 A[SYNTHETIC, Splitter:B:33:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0050 A[SYNTHETIC, Splitter:B:40:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0057 A[SYNTHETIC, Splitter:B:44:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float fe(java.lang.String r5) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            java.lang.String r0 = r5.readLine()     // Catch:{ Exception -> 0x0031, all -> 0x0029 }
            long r2 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0031, all -> 0x0029 }
            float r0 = (float) r2
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r0 = r0 / r2
            float r0 = r0 / r2
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            r5.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            return r0
        L_0x0029:
            r0 = move-exception
            goto L_0x004e
        L_0x002b:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x004e
        L_0x0030:
            r5 = r0
        L_0x0031:
            r0 = r1
            goto L_0x0039
        L_0x0033:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            goto L_0x004e
        L_0x0038:
            r5 = r0
        L_0x0039:
            boolean r1 = qw     // Catch:{ all -> 0x004a }
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0044
        L_0x0043:
        L_0x0044:
            if (r5 == 0) goto L_0x0049
            r5.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            return r1
        L_0x004a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x004e:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0055
        L_0x0054:
        L_0x0055:
            if (r5 == 0) goto L_0x005a
            r5.close()     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.fe.ad.rg.qw.fe(java.lang.String):float");
    }

    public static String qw(int i2) {
        return "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq";
    }
}
