package com.baidu.live.plugin.utils;

import java.security.MessageDigest;
import java.util.Locale;
import kotlin.UByte;

public class Md5Utils {
    public static String toMd5(byte[] bytes, boolean upperCase) {
        byte[] result = bytes;
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(bytes);
            result = algorithm.digest();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return toHexString(result, "", upperCase);
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
}
