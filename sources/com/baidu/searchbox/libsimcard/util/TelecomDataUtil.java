package com.baidu.searchbox.libsimcard.util;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import kotlin.UByte;

public class TelecomDataUtil {
    public static String encrypt(String plain, String charset, String hexKey) {
        if (plain == null || charset == null || hexKey == null) {
            return null;
        }
        try {
            return ByteFormat.toHex(encrypt(plain.getBytes(charset), ByteFormat.hexToBytes(hexKey)));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String cipherHex, String charset, String hexKey) {
        byte[] b2;
        if (TextUtils.isEmpty(cipherHex) || TextUtils.isEmpty(charset) || TextUtils.isEmpty(hexKey) || (b2 = decrypt(ByteFormat.hexToBytes(cipherHex), ByteFormat.hexToBytes(hexKey))) == null) {
            return null;
        }
        try {
            return new String(b2, charset);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(byte[] plainData, byte[] key) {
        if (plainData == null || plainData.length == 0 || key == null) {
            return null;
        }
        return toByteArray(encrypt(toIntArray(plainData, true), toIntArray(key, false)), false);
    }

    public static byte[] decrypt(byte[] cipherData, byte[] key) {
        if (cipherData == null || cipherData.length == 0 || key == null) {
            return null;
        }
        return toByteArray(decrypt(toIntArray(cipherData, false), toIntArray(key, false)), true);
    }

    private static int[] encrypt(int[] v, int[] k) {
        int n = v.length - 1;
        if (n < 1) {
            return v;
        }
        if (k.length < 4) {
            int[] key = new int[4];
            System.arraycopy(k, 0, key, 0, k.length);
            k = key;
        }
        int z = v[n];
        int i2 = v[0];
        int sum = 0;
        int e2 = (52 / (n + 1)) + 6;
        while (true) {
            int q = e2 - 1;
            if (e2 <= 0) {
                return v;
            }
            sum -= 1640531527;
            int e3 = (sum >>> 2) & 3;
            int p = 0;
            while (p < n) {
                int y = v[p + 1];
                int i3 = v[p] + ((((z >>> 5) ^ (y << 2)) + ((y >>> 3) ^ (z << 4))) ^ ((sum ^ y) + (k[(p & 3) ^ e3] ^ z)));
                v[p] = i3;
                z = i3;
                p++;
            }
            int y2 = v[0];
            int i4 = v[n] + ((((z >>> 5) ^ (y2 << 2)) + ((y2 >>> 3) ^ (z << 4))) ^ ((sum ^ y2) + (k[(p & 3) ^ e3] ^ z)));
            v[n] = i4;
            z = i4;
            e2 = q;
        }
    }

    private static int[] decrypt(int[] v, int[] k) {
        int n = v.length - 1;
        if (n < 1) {
            return v;
        }
        if (k.length < 4) {
            int[] key = new int[4];
            System.arraycopy(k, 0, key, 0, k.length);
            k = key;
        }
        int y = v[0];
        for (int sum = ((52 / (n + 1)) + 6) * -1640531527; sum != 0; sum -= -1640531527) {
            int e2 = (sum >>> 2) & 3;
            int p = n;
            while (p > 0) {
                int z = v[p - 1];
                int i2 = v[p] - ((((z >>> 5) ^ (y << 2)) + ((y >>> 3) ^ (z << 4))) ^ ((sum ^ y) + (k[(p & 3) ^ e2] ^ z)));
                v[p] = i2;
                y = i2;
                p--;
            }
            int z2 = v[n];
            int i3 = v[0] - ((((z2 >>> 5) ^ (y << 2)) + ((y >>> 3) ^ (z2 << 4))) ^ ((sum ^ y) + (k[(p & 3) ^ e2] ^ z2)));
            v[0] = i3;
            y = i3;
        }
        return v;
    }

    private static int[] toIntArray(byte[] data, boolean includeLength) {
        int[] result;
        int n = (data.length & 3) == 0 ? data.length >>> 2 : (data.length >>> 2) + 1;
        if (includeLength) {
            result = new int[(n + 1)];
            result[n] = data.length;
        } else {
            result = new int[n];
        }
        int n2 = data.length;
        for (int i2 = 0; i2 < n2; i2++) {
            int i3 = i2 >>> 2;
            result[i3] = result[i3] | ((data[i2] & UByte.MAX_VALUE) << ((i2 & 3) << 3));
        }
        return result;
    }

    private static byte[] toByteArray(int[] data, boolean includeLength) {
        int n = data.length << 2;
        if (includeLength) {
            int m = data[data.length - 1];
            if (m > n || m <= 0) {
                return null;
            }
            n = m;
        }
        byte[] result = new byte[n];
        for (int i2 = 0; i2 < n; i2++) {
            result[i2] = (byte) ((data[i2 >>> 2] >>> ((i2 & 3) << 3)) & 255);
        }
        return result;
    }
}
