package com.baidu.android.util.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class GZIP {
    public static final boolean DEBUG = false;
    public static final int NUM_1024 = 1024;

    public static byte[] gZip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            e.printStackTrace();
            return bArr2;
        }
    }

    public static boolean isGzipFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        byte[] bArr = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.read(bArr);
                if ("1F8B0800".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                    Closeables.closeSafely((Closeable) fileInputStream2);
                    return true;
                }
                Closeables.closeSafely((Closeable) fileInputStream2);
                return false;
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                Closeables.closeSafely((Closeable) fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            Closeables.closeSafely((Closeable) fileInputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            Closeables.closeSafely((Closeable) fileInputStream);
            throw th;
        }
    }

    public static byte[] unGZip(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr2 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr2, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
