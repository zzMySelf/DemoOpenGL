package com.baidu.nadcore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.UByte;

public class HashUtils {
    public static final boolean DEBUG = false;

    public static String toMd5(String value, boolean upperCase) {
        if (value == null) {
            value = "";
        }
        try {
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(value.getBytes());
            return toHexString(mDigest.digest(), "", upperCase);
        } catch (Exception e2) {
            return String.valueOf(value.hashCode());
        }
    }

    public static String toMd5(byte[] bytes, boolean upperCase) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(bytes);
            return toHexString(algorithm.digest(), "", upperCase);
        } catch (Exception e2) {
            return null;
        }
    }

    public static String toHexString(byte[] bytes, String separator, boolean upperCase) {
        StringBuilder hexString = new StringBuilder();
        for (byte b2 : bytes) {
            String str = Integer.toHexString(b2 & UByte.MAX_VALUE);
            if (upperCase) {
                str = str.toUpperCase(Locale.getDefault());
            }
            if (str.length() == 1) {
                hexString.append("0");
            }
            hexString.append(str).append(separator);
        }
        return hexString.toString();
    }

    public static String md5(File file) {
        if (file == null || !file.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest md5Algorithm = MessageDigest.getInstance("MD5");
            md5Algorithm.reset();
            byte[] buffer = new byte[102400];
            FileInputStream fileInputStream2 = new FileInputStream(file);
            while (true) {
                int len = fileInputStream2.read(buffer, 0, buffer.length);
                if (len >= 0) {
                    md5Algorithm.update(buffer, 0, len);
                    if (len <= 0) {
                        break;
                    }
                } else {
                    break;
                }
            }
            String hexString = toHexString(md5Algorithm.digest(), "", false);
            try {
                fileInputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return hexString;
        } catch (Exception e3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return "";
        } catch (Throwable th2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th2;
        }
    }
}
