package com.baidu.wallet.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.armor.SafePay;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class VerifySigUtils implements NoProguard {
    public static final int a = 0;

    public static int a(String str) {
        if ("MD5".equalsIgnoreCase(str)) {
            return 4;
        }
        if ("SHA-1".equalsIgnoreCase(str)) {
            return 5;
        }
        if ("SHA-256".equalsIgnoreCase(str)) {
            return 11;
        }
        if ("SHA-384".equalsIgnoreCase(str)) {
            return 12;
        }
        return "SHA-512".equalsIgnoreCase(str) ? 13 : 0;
    }

    public static byte[] b(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[4096];
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, 0, bArr2, 0, read);
                fileInputStream.close();
                return bArr2;
            }
            fileInputStream.close();
            return new byte[0];
        } catch (IOException unused) {
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static String getSha1(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            while (bigInteger.length() < 40) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean verify(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return verify(str.getBytes(), str2.getBytes(), str3);
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, String str) {
        if (bArr == null || bArr2 == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] digest = MessageDigest.getInstance(str.toUpperCase()).digest(bArr2);
            if (SafePay.getInstance().rsaVerify(0, a(str), digest.length, digest, Base64.decode(bArr, 0)) == 0) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException | NoSuchAlgorithmException unused) {
            return false;
        }
    }

    public static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-1").digest(bArr);
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        return sb.toString();
    }
}
