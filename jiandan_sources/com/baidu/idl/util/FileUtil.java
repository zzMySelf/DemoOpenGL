package com.baidu.idl.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static final String TAG = "FileUtil";

    public FileUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean createFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists() && file.length() > 3145728) {
            file.delete();
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.createNewFile();
            return true;
        } catch (IOException e) {
            StuLogEx.e(TAG, "创建文件失败", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0028 A[SYNTHETIC, Splitter:B:21:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x002e A[SYNTHETIC, Splitter:B:26:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean loadPropertiesFile(java.io.File r3, java.util.Properties r4) {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x001b }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x001b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001b }
            r4.load(r1)     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r3 = 1
            r1.close()     // Catch:{ IOException -> 0x0012 }
        L_0x0012:
            return r3
        L_0x0013:
            r3 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x0016:
            r3 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x0019:
            r3 = move-exception
            goto L_0x002c
        L_0x001b:
            r3 = move-exception
        L_0x001c:
            java.lang.String r4 = "FileUtil"
            java.lang.String r1 = r3.getMessage()     // Catch:{ all -> 0x0019 }
            com.baidu.idl.util.StuLogEx.e(r4, r1, r3)     // Catch:{ all -> 0x0019 }
            r3 = 0
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return r3
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.util.FileUtil.loadPropertiesFile(java.io.File, java.util.Properties):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0028 A[SYNTHETIC, Splitter:B:21:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x002e A[SYNTHETIC, Splitter:B:26:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean savePropertiesFile(java.io.File r3, java.util.Properties r4) {
        /*
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x001b }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001b }
            r4.store(r1, r0)     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r3 = 1
            r1.close()     // Catch:{ IOException -> 0x0012 }
        L_0x0012:
            return r3
        L_0x0013:
            r3 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x0016:
            r3 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x0019:
            r3 = move-exception
            goto L_0x002c
        L_0x001b:
            r3 = move-exception
        L_0x001c:
            java.lang.String r4 = "FileUtil"
            java.lang.String r1 = r3.getMessage()     // Catch:{ all -> 0x0019 }
            com.baidu.idl.util.StuLogEx.e(r4, r1, r3)     // Catch:{ all -> 0x0019 }
            r3 = 0
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return r3
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.util.FileUtil.savePropertiesFile(java.io.File, java.util.Properties):boolean");
    }
}
