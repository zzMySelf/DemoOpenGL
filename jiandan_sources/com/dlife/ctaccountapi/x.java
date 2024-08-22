package com.dlife.ctaccountapi;

import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;

public class x {
    public static final String a = "x";
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            char[] cArr = b;
            sb.append(cArr[(bArr[i2] >> 4) & 15]);
            sb.append(cArr[bArr[i2] & Ascii.SI]);
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            int digit = Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4);
            if (digit > 127) {
                digit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i2] = (byte) digit;
        }
        return bArr;
    }
}
