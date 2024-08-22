package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class a implements b {
    public static final int[] g = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    public String c;
    public long d;
    public int e;
    public long f;

    public a(String str, long j, int i2) {
        this.c = str;
        this.d = j;
        this.e = i2;
    }

    public int a() {
        return 0;
    }

    public void a(long j) {
        this.f = j;
    }

    public long b() {
        return this.f;
    }

    public int c() {
        return 0;
    }

    public String d() {
        return this.c;
    }

    public long e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(long j) {
        this.d = j;
        "+++++++++HotpToken movingFactor is " + this.d;
    }

    public void a(int i2) {
        this.e = i2;
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public String a(Context context) {
        byte[] bArr = new byte[8];
        long j = this.d;
        for (int i2 = 7; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        SafePay instance = SafePay.getInstance();
        byte[] b = b(this.c);
        int[] iArr = g;
        int i3 = this.e;
        return instance.getDyKey(b, bArr, iArr[i3], i3);
    }

    public static String b(int i2) {
        MessageDigest messageDigest;
        long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
        byte[] bytes = ("" + timeInMillis).getBytes();
        if (i2 == 128) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        } else {
            messageDigest = MessageDigest.getInstance("SHA1");
        }
        messageDigest.reset();
        messageDigest.update(bytes);
        return a(messageDigest.digest());
    }

    private byte[] a(byte[] bArr, byte[] bArr2) {
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA1");
        } catch (NoSuchAlgorithmException unused) {
            try {
                mac = Mac.getInstance("HMAC-SHA-1");
            } catch (GeneralSecurityException e2) {
                throw new UndeclaredThrowableException(e2);
            }
        }
        mac.init(new SecretKeySpec(bArr, "RAW"));
        return mac.doFinal(bArr2);
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}
