package com.baidu.sapi2.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class FileUtil {
    public static final int BUFFER_SIZE = 2048;

    public static int copy(InputStream inputStream, OutputStream outputStream) throws Exception, IOException {
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 2048);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
        int i2 = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i2 += read;
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    Log.e(Log.TAG, (Throwable) e);
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                    Log.e(Log.TAG, (Throwable) e2);
                }
            }
        }
        bufferedOutputStream.flush();
        return i2;
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            Log.i(Log.TAG, e);
            return false;
        }
    }

    public static boolean isFileExist(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0020 A[SYNTHETIC, Splitter:B:15:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0027 A[SYNTHETIC, Splitter:B:21:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String read(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            int r2 = r1.available()     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.read(r2)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.close()     // Catch:{ Exception -> 0x0017 }
        L_0x0017:
            return r0
        L_0x0018:
            r2 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001b:
            r0 = r1
            goto L_0x0025
        L_0x001d:
            r2 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            throw r2
        L_0x0024:
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.FileUtil.read(java.lang.String):java.lang.String");
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.FileUtil.write(java.io.File, byte[], boolean):boolean");
    }
}
