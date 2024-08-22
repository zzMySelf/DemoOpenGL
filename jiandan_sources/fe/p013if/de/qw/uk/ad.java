package fe.p013if.de.qw.uk;

import android.app.ActivityManager;
import androidx.appcompat.widget.ActivityChooserModel;
import fe.p013if.de.qw.de;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: fe.if.de.qw.uk.ad  reason: invalid package */
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static long f4612ad;
    public static int qw;

    /* renamed from: fe.if.de.qw.uk.ad$qw */
    public class qw implements FileFilter {
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static int ad() {
        if (qw == 0) {
            try {
                qw = new File("/sys/devices/system/cpu/").listFiles(new qw()).length;
            } catch (Exception unused) {
                qw = 1;
            }
        }
        return qw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC, Splitter:B:18:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[SYNTHETIC, Splitter:B:24:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long de() {
        /*
            long r0 = f4612ad
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x004b
            java.lang.String r0 = "/proc/meminfo"
            r1 = -1
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r3)     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            java.lang.String r3 = r0.readLine()     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            if (r3 == 0) goto L_0x0031
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            r5 = 1
            r3 = r3[r5]     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            int r1 = r3.intValue()     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            long r1 = (long) r1     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
        L_0x0031:
            r0.close()     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            r4.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0049
        L_0x0038:
            r0 = move-exception
            r3 = r4
            goto L_0x003e
        L_0x003b:
            r3 = r4
            goto L_0x0044
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            throw r0
        L_0x0044:
            if (r3 == 0) goto L_0x0049
            r3.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            f4612ad = r1
        L_0x004b:
            long r0 = f4612ad
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.p013if.de.qw.uk.ad.de():long");
    }

    public static long qw() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) de.fe().th().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }
}
