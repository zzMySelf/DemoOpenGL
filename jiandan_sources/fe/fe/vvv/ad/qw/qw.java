package fe.fe.vvv.ad.qw;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import java.util.List;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile int f3162ad;
    public static volatile String qw;

    public static String ad() {
        String str = qw;
        if (str == null) {
            synchronized (qw.class) {
                str = qw;
                if (str == null) {
                    Context qw2 = fe.qw();
                    String fe2 = fe();
                    if (fe2 == null) {
                        fe2 = de(qw2);
                    }
                    if (fe2 == null && Build.VERSION.SDK_INT >= 28) {
                        Application application = (Application) qw2;
                        fe2 = Application.getProcessName();
                    }
                    if (fe2 == null) {
                        fe2 = qw2.getPackageName();
                    }
                    qw = fe2;
                    str = fe2;
                }
            }
        }
        return str;
    }

    public static String de(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A[SYNTHETIC, Splitter:B:22:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC, Splitter:B:28:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String fe() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/self/cmdline"
            r0.<init>(r1)
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0034 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0034 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0034 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0034 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0034 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x002d, all -> 0x002a }
        L_0x0021:
            r2.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0046
        L_0x0025:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0046
        L_0x002a:
            r0 = move-exception
            r1 = r2
            goto L_0x0047
        L_0x002d:
            r0 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0036
        L_0x0032:
            r0 = move-exception
            goto L_0x0047
        L_0x0034:
            r0 = move-exception
            r2 = r1
        L_0x0036:
            java.lang.String r3 = "MultiProcess"
            uk(r3, r0)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0045:
            r1 = r2
        L_0x0046:
            return r1
        L_0x0047:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0051:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.vvv.ad.qw.qw.fe():java.lang.String");
    }

    public static int qw() {
        Context qw2 = fe.qw();
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) qw2.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return -1;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.importance;
            }
        }
        return 0;
    }

    public static int rg() {
        int i2 = f3162ad;
        if (i2 == 0) {
            String ad2 = ad();
            String packageName = fe.qw().getPackageName();
            i2 = (TextUtils.equals(ad2, packageName) || (ad2.startsWith(packageName) && !ad2.contains(":"))) ? i2 | 1 | 2 : i2 | 4;
            f3162ad = i2;
        }
        return i2;
    }

    public static boolean th() {
        return (rg() & 1) != 0;
    }

    public static void uk(String str, Exception exc) {
    }

    public static boolean yj() {
        return (rg() & 2) != 0;
    }
}
