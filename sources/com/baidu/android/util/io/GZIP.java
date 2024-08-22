package com.baidu.android.util.io;

import com.baidu.nadcore.utils.ZipUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class GZIP {
    private static final boolean DEBUG = false;
    public static final int NUM_1024 = 1024;

    private GZIP() {
    }

    public static byte[] gZip(byte[] data) {
        byte[] b2 = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            b2 = bos.toByteArray();
            bos.close();
            return b2;
        } catch (Exception ex) {
            ex.printStackTrace();
            return b2;
        }
    }

    public static byte[] unGZip(byte[] data) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (true) {
                int read = gzip.read(buf, 0, buf.length);
                int num = read;
                if (read != -1) {
                    baos.write(buf, 0, num);
                } else {
                    byte[] b2 = baos.toByteArray();
                    baos.flush();
                    baos.close();
                    gzip.close();
                    bis.close();
                    return b2;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean isGzipFile(String srcfile) {
        File file = new File(srcfile);
        if (!file.exists()) {
            return false;
        }
        byte[] filetype = new byte[4];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(filetype);
            if (ZipUtils.GZIP_FILE_NAME.equalsIgnoreCase(FileUtils.toHexString(filetype, "", true))) {
                Closeables.closeSafely((Closeable) fis);
                return true;
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
        Closeables.closeSafely((Closeable) fis);
        return false;
    }
}
