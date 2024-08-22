package org.apache.commons.codec.digest4util;

import com.google.common.base.Ascii;
import java.util.Random;

public class B64 {
    public static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void b64from24bit(byte b, byte b2, byte b3, int i2, StringBuilder sb) {
        int i3 = ((b << Ascii.DLE) & 16777215) | ((b2 << 8) & 65535) | (b3 & 255);
        while (true) {
            int i4 = i2 - 1;
            if (i2 > 0) {
                sb.append(B64T.charAt(i3 & 63));
                i3 >>= 6;
                i2 = i4;
            } else {
                return;
            }
        }
    }

    public static String getRandomSalt(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 1; i3 <= i2; i3++) {
            sb.append(B64T.charAt(new Random().nextInt(64)));
        }
        return sb.toString();
    }
}
