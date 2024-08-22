package com.unionpay.utils;

import androidx.core.view.InputDeviceCompat;
import kotlin.UByte;

public final class a {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            byte b3 = b2 & UByte.MAX_VALUE;
            sb.append("0123456789abcdef".charAt(b3 >> 4));
            sb.append("0123456789abcdef".charAt(b3 & 15));
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
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
