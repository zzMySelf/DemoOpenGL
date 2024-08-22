package com.dxmpay.wallet.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static final String TAG = "FileUtils";

    public static boolean checkAndCreadFile(File file) throws IOException {
        if (file.exists()) {
            return true;
        }
        file.getParentFile().mkdirs();
        return file.createNewFile();
    }

    public static void deleteDir(File file, boolean z) {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static boolean deleteFile(String str) {
        if (isNullOrEmptyWithoutTrim(str)) {
            return false;
        }
        if (!isFileExist(str)) {
            return true;
        }
        return deleteFile(new File(str));
    }

    public static void ensureParent(File file) {
        File parentFile;
        if (file != null && (parentFile = file.getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean existsFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean isFileExist(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean isNullOrEmptyWithoutTrim(String str) {
        return str == null || "".equals(str);
    }

    public static boolean write(File file, byte[] bArr) throws IOException {
        return write(file, bArr, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean write(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r3.exists()     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x0012
            java.io.File r2 = r3.getParentFile()     // Catch:{ all -> 0x0028 }
            r2.mkdirs()     // Catch:{ all -> 0x0028 }
            r3.createNewFile()     // Catch:{ all -> 0x0028 }
        L_0x0012:
            boolean r2 = r3.canWrite()     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x0019
            return r0
        L_0x0019:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0028 }
            r2.<init>(r3, r5)     // Catch:{ all -> 0x0028 }
            r2.write(r4)     // Catch:{ all -> 0x0026 }
            r2.close()
            r3 = 1
            return r3
        L_0x0026:
            r1 = r2
            goto L_0x0029
        L_0x0028:
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.utils.FileUtils.write(java.io.File, byte[], boolean):boolean");
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }
}
