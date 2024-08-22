package com.baidu.sofire.l;

import android.content.Context;
import android.os.Process;
import com.baidu.sofire.a.a;

public class m {
    public static String a = "";

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x00f3 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ab A[Catch:{ all -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ac A[Catch:{ all -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f7 A[SYNTHETIC, Splitter:B:67:0x00f7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7) {
        /*
            java.lang.String r0 = a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x010a
            com.baidu.sofire.l.m r0 = new com.baidu.sofire.l.m
            r0.<init>()
            java.lang.String r1 = r0.b(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0053
            java.lang.String r1 = r0.d(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0051
            java.lang.String r1 = r0.c(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x004e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "1|"
            r1.append(r2)
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.baidu.sofire.l.k.a((java.lang.String) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r5 = 1
            r6 = 1
            goto L_0x0056
        L_0x004e:
            r2 = 1
            r5 = 1
            goto L_0x0055
        L_0x0051:
            r2 = 1
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            r5 = 0
        L_0x0055:
            r6 = 0
        L_0x0056:
            if (r2 != 0) goto L_0x0062
            java.lang.String r2 = r0.b(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0069
        L_0x0062:
            com.baidu.sofire.j.a r2 = com.baidu.sofire.j.a.a((android.content.Context) r7)
            r2.e(r1)
        L_0x0069:
            if (r5 != 0) goto L_0x0075
            java.lang.String r2 = r0.d(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0090
        L_0x0075:
            java.lang.String r2 = "com.q.zi.i"
            boolean r5 = com.baidu.sofire.l.r.d     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0083
            boolean r5 = com.baidu.sofire.l.r.b(r7)     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0083
            r5 = 1
            goto L_0x0084
        L_0x0083:
            r5 = 0
        L_0x0084:
            if (r5 == 0) goto L_0x0090
            android.content.ContentResolver r5 = r7.getContentResolver()     // Catch:{ all -> 0x008e }
            android.provider.Settings.System.putString(r5, r2, r1)     // Catch:{ all -> 0x008e }
            goto L_0x0090
        L_0x008e:
            int r2 = com.baidu.sofire.a.a.a
        L_0x0090:
            java.lang.String r2 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r2 = r0.a(r7, r2)
            if (r2 == 0) goto L_0x0108
            if (r6 != 0) goto L_0x00a4
            java.lang.String r0 = r0.c(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0108
        L_0x00a4:
            r0 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00f3 }
            r5 = 29
            if (r2 < r5) goto L_0x00ac
            goto L_0x0108
        L_0x00ac:
            boolean r2 = com.baidu.sofire.l.r.e     // Catch:{ all -> 0x00f3 }
            if (r2 == 0) goto L_0x00b7
            boolean r7 = com.baidu.sofire.l.r.b(r7)     // Catch:{ all -> 0x00f3 }
            if (r7 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r3 = 0
        L_0x00b8:
            if (r3 != 0) goto L_0x00bb
            goto L_0x0108
        L_0x00bb:
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x00f3 }
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x00f3 }
            java.lang.String r3 = ".zp"
            r7.<init>(r2, r3)     // Catch:{ all -> 0x00f3 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00f3 }
            java.lang.String r3 = ".icosc"
            r2.<init>(r7, r3)     // Catch:{ all -> 0x00f3 }
            boolean r3 = r7.exists()     // Catch:{ all -> 0x00f3 }
            if (r3 == 0) goto L_0x00e0
            boolean r3 = r7.isDirectory()     // Catch:{ all -> 0x00f3 }
            if (r3 != 0) goto L_0x00e3
            r7.delete()     // Catch:{ all -> 0x00f3 }
            r7.mkdirs()     // Catch:{ all -> 0x00f3 }
            goto L_0x00e3
        L_0x00e0:
            r7.mkdirs()     // Catch:{ all -> 0x00f3 }
        L_0x00e3:
            java.io.FileWriter r7 = new java.io.FileWriter     // Catch:{ all -> 0x00f3 }
            r7.<init>(r2, r4)     // Catch:{ all -> 0x00f3 }
            r7.write(r1)     // Catch:{ all -> 0x00f2 }
            r7.flush()     // Catch:{ all -> 0x00f2 }
            r7.close()     // Catch:{ all -> 0x00fb }
            goto L_0x0108
        L_0x00f2:
            r0 = r7
        L_0x00f3:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00fe }
            if (r0 == 0) goto L_0x0108
            r0.close()     // Catch:{ all -> 0x00fb }
            goto L_0x0108
        L_0x00fb:
            int r7 = com.baidu.sofire.a.a.a
            goto L_0x0108
        L_0x00fe:
            r7 = move-exception
            if (r0 == 0) goto L_0x0107
            r0.close()     // Catch:{ all -> 0x0105 }
            goto L_0x0107
        L_0x0105:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0107:
            throw r7
        L_0x0108:
            a = r1
        L_0x010a:
            java.lang.String r7 = a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.m.a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|6|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            com.baidu.sofire.j.a r6 = com.baidu.sofire.j.a.a((android.content.Context) r6)     // Catch:{ all -> 0x0047 }
            android.content.SharedPreferences r1 = r6.c     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = "rpnewuidn"
            java.lang.String r1 = r1.getString(r2, r0)     // Catch:{ all -> 0x0047 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0015
            goto L_0x002c
        L_0x0015:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x002a }
            byte[] r3 = com.baidu.sofire.j.a.k     // Catch:{ all -> 0x002a }
            r4 = 10
            byte[] r1 = android.util.Base64.decode(r1, r4)     // Catch:{ all -> 0x002a }
            r4 = 1
            byte[] r1 = com.baidu.sofire.l.g.a(r3, r1, r4)     // Catch:{ all -> 0x002a }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ all -> 0x002a }
            goto L_0x002d
        L_0x002a:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0047 }
        L_0x002c:
            r2 = r0
        L_0x002d:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0034
            return r2
        L_0x0034:
            android.content.SharedPreferences r1 = r6.c     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = "rpnewuid"
            java.lang.String r1 = r1.getString(r2, r0)     // Catch:{ all -> 0x0047 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x0046
            r6.e(r1)     // Catch:{ all -> 0x0047 }
            return r1
        L_0x0046:
            return r0
        L_0x0047:
            int r6 = com.baidu.sofire.a.a.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.m.b(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[Catch:{ all -> 0x0034 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e A[Catch:{ all -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            if (r4 != 0) goto L_0x0005
            goto L_0x0011
        L_0x0005:
            boolean r1 = com.baidu.sofire.l.r.c     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            boolean r1 = com.baidu.sofire.l.r.b(r4)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            if (r1 != 0) goto L_0x0015
            return r0
        L_0x0015:
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r4 = r3.a(r4, r1)     // Catch:{ all -> 0x0034 }
            if (r4 != 0) goto L_0x001e
            return r0
        L_0x001e:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0034 }
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = ".zp/.icosc"
            r4.<init>(r1, r2)     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r3.a((java.io.File) r4)     // Catch:{ all -> 0x0034 }
            return r4
        L_0x0034:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.m.c(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[Catch:{ all -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String d(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "com.q.zi.i"
            java.lang.String r1 = ""
            if (r4 != 0) goto L_0x0007
            goto L_0x0013
        L_0x0007:
            boolean r2 = com.baidu.sofire.l.r.b     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x0013
            boolean r2 = com.baidu.sofire.l.r.b(r4)     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            if (r2 == 0) goto L_0x0022
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x001f }
            java.lang.String r1 = com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper.getStringFromSettingSystem(r4, r0)     // Catch:{ all -> 0x001f }
            goto L_0x0022
        L_0x001f:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0023 }
            r1 = 0
        L_0x0022:
            return r1
        L_0x0023:
            int r4 = com.baidu.sofire.a.a.a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.m.d(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        if (r1 != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0030, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0032, code lost:
        if (r1 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0038, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.io.File r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0025 }
            r1.<init>(r6)     // Catch:{ all -> 0x0025 }
            r6 = 8192(0x2000, float:1.14794E-41)
            char[] r6 = new char[r6]     // Catch:{ all -> 0x0026 }
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
        L_0x000f:
            int r3 = r1.read(r6)     // Catch:{ all -> 0x0026 }
            if (r3 <= 0) goto L_0x001a
            r4 = 0
            r2.write(r6, r4, r3)     // Catch:{ all -> 0x0026 }
            goto L_0x000f
        L_0x001a:
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0026 }
            r1.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0024:
            return r6
        L_0x0025:
            r1 = r0
        L_0x0026:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x002e:
            int r6 = com.baidu.sofire.a.a.a
        L_0x0030:
            return r0
        L_0x0031:
            r6 = move-exception
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ all -> 0x0038 }
            goto L_0x003a
        L_0x0038:
            int r0 = com.baidu.sofire.a.a.a
        L_0x003a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.m.a(java.io.File):java.lang.String");
    }

    public final boolean a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }
}
