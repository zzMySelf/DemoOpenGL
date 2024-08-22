package com.baidu.crashpad;

public class ZwDebugExtra {
    public static boolean qw;

    public static void clearCrashKey(String str) {
        ZwCrashpad.clearCrashKey(str);
    }

    public static void crashIntentionally(int i2) {
        if (qw) {
            ZwCrashpad.crashIntentionally(i2);
        }
    }

    public static boolean debugModel() {
        return qw;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r1) {
        /*
            java.lang.Class<com.baidu.crashpad.ZwDebugExtra> r0 = com.baidu.crashpad.ZwDebugExtra.class
            monitor-enter(r0)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            if (r1 == 0) goto L_0x0018
            int r1 = r1.flags     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            r1 = r1 & 2
            if (r1 == 0) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            qw = r1     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0018:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZwDebugExtra.init(android.content.Context):void");
    }

    public static void setCrashKeyValue(String str, String str2) {
        ZwCrashpad.setCrashKeyValue(str, str2);
    }
}
