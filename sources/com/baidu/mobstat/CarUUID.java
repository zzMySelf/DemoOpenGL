package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.system.Os;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class CarUUID {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f15505a = Pattern.compile("(\\w{32})");

    public static String optUUID(Context context) {
        String b2 = b(context);
        if (b2 != null) {
            return b2;
        }
        String c2 = c(context);
        if (c2 != null) {
            a(context, c2);
            return c2;
        }
        String a2 = a(context);
        if (a2 == null) {
            return "";
        }
        a(context, a2);
        return a2;
    }

    private static String a(Context context) {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String b(Context context) {
        return a(context.getFileStreamPath("libdueros_uuid.so"));
    }

    private static String c(Context context) {
        String a2;
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        for (ApplicationInfo next : installedApplications) {
            if (!applicationInfo.packageName.equals(next.packageName) && (a2 = a(new File(new File(next.dataDir, "files"), "libdueros_uuid.so"))) != null) {
                return a2;
            }
        }
        return null;
    }

    private static boolean a(Context context, String str) {
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput("libdueros_uuid.so", Build.VERSION.SDK_INT >= 21 ? 0 : 1);
            if (a(fileOutputStream, str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    File fileStreamPath = context.getFileStreamPath("libdueros_uuid.so");
                    if (a(new File(applicationInfo.dataDir), 457) && a(fileStreamPath, 484)) {
                        z = true;
                    }
                    u.a(fileOutputStream);
                    return z;
                }
                u.a(fileOutputStream);
                return true;
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            u.a((Closeable) null);
            throw th2;
        }
        u.a(fileOutputStream);
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x003d
            boolean r1 = r5.exists()
            if (r1 == 0) goto L_0x003d
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            int r2 = r1.read(r5)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            r4 = 0
            r3.<init>(r5, r4, r2)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            java.util.regex.Pattern r5 = f15505a     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            java.util.regex.Matcher r5 = r5.matcher(r3)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            boolean r5 = r5.matches()     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            if (r5 == 0) goto L_0x002a
            r0 = r3
        L_0x002a:
            com.baidu.mobstat.u.a(r1)
            return r0
        L_0x002e:
            r5 = move-exception
            r0 = r1
            goto L_0x0034
        L_0x0031:
            r5 = move-exception
            goto L_0x003a
        L_0x0033:
            r5 = move-exception
        L_0x0034:
            com.baidu.mobstat.u.a(r0)
            throw r5
        L_0x0038:
            r5 = move-exception
            r1 = r0
        L_0x003a:
            com.baidu.mobstat.u.a(r1)
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.CarUUID.a(java.io.File):java.lang.String");
    }

    private static boolean a(FileOutputStream fileOutputStream, String str) {
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private static boolean a(File file, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            Os.chmod(file.getAbsolutePath(), i2);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }
}
