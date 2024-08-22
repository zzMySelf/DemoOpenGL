package com.dlife.ctaccountapi;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;

public class g {
    public static char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String a(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            byte b = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(a[b >>> 2]);
                stringBuffer.append(a[(b & 3) << 4]);
                str = "==";
                break;
            }
            int i4 = i3 + 1;
            byte b2 = bArr[i3] & 255;
            if (i4 == length) {
                stringBuffer.append(a[b >>> 2]);
                stringBuffer.append(a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
                stringBuffer.append(a[(b2 & Ascii.SI) << 2]);
                str = "=";
                break;
            }
            int i5 = i4 + 1;
            byte b3 = bArr[i4] & 255;
            stringBuffer.append(a[b >>> 2]);
            stringBuffer.append(a[((b & 3) << 4) | ((b2 & 240) >>> 4)]);
            stringBuffer.append(a[((b2 & Ascii.SI) << 2) | ((b3 & ExifInterface.MARKER_SOF0) >>> 6)]);
            stringBuffer.append(a[b3 & 63]);
            i2 = i5;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
