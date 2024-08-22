package com.dxmpay.wallet.utils;

import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtils {
    public static boolean unzip(String str, String str2) {
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (!zipEntry.getName().contains("../")) {
                    if (zipEntry.isDirectory()) {
                        new File(str2 + "/" + zipEntry.getName()).mkdirs();
                    } else {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                        File file = new File(str2 + "/" + zipEntry.getName());
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                    }
                }
            }
            zipFile.close();
            return true;
        } catch (Exception e) {
            LogUtil.e("ZipUtil", "unzip error! zip file:" + str + " unzip to path:" + str2, e);
            return false;
        }
    }
}
