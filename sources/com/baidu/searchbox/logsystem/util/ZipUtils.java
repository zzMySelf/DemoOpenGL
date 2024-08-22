package com.baidu.searchbox.logsystem.util;

import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public static void zip(File dest, List<ZipSrc> srcs) throws IOException {
        if (dest != null && dest.exists() && srcs != null && srcs.size() != 0) {
            InputStream input = null;
            ZipOutputStream zipOut = null;
            try {
                byte[] buffer = new byte[4096];
                zipOut = new ZipOutputStream(new FileOutputStream(dest));
                zipOut.setComment(dest.getName());
                for (ZipSrc zipSrc : srcs) {
                    File srcFile = zipSrc.mFile;
                    try {
                        if (srcFile.canRead()) {
                            input = new FileInputStream(srcFile);
                            zipOut.putNextEntry(new ZipEntry(zipSrc.mOutName));
                            while (true) {
                                int read = input.read(buffer);
                                int readSize = read;
                                if (read != -1) {
                                    zipOut.write(buffer, 0, readSize);
                                }
                            }
                            Closeables.closeSafely((Closeable) input);
                        }
                        Closeables.closeSafely((Closeable) input);
                    } catch (FileNotFoundException f2) {
                        f2.printStackTrace();
                        Closeables.closeSafely((Closeable) input);
                    }
                }
                zipOut.flush();
            } catch (FileNotFoundException e2) {
                try {
                    if (LLog.sDebug) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Closeables.closeSafely((Closeable) zipOut);
                    throw th2;
                }
            } catch (Throwable th3) {
                Closeables.closeSafely((Closeable) input);
                throw th3;
            }
            Closeables.closeSafely((Closeable) zipOut);
        }
    }

    public static final class ZipSrc {
        public File mFile;
        public String mOutName;

        public ZipSrc(File fileSrc, String outName) {
            this.mFile = fileSrc;
            if (TextUtils.isEmpty(outName)) {
                this.mOutName = this.mFile.getName();
            } else {
                this.mOutName = outName;
            }
        }

        public ZipSrc(File fileSrc) {
            this.mFile = fileSrc;
            this.mOutName = fileSrc.getName();
        }
    }
}
