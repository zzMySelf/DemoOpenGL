package com.baidu.wallet.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.AESUtil;
import com.baidu.wallet.core.NoProguard;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtils implements NoProguard {
    public static final String IV_STRING = "A-16-Byte-String";
    public static String aesKey = null;
    public static final String charset = "UTF-8";

    public static byte[] aesDecryptBytes(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return cipherOperation(bArr, bArr2, 2);
    }

    public static String aesDecryptString(String str, String str2) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return new String(aesDecryptBytes(Base64.decode(str, 2), str2.getBytes("UTF-8")), "UTF-8");
    }

    public static byte[] aesEncryptBytes(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return cipherOperation(bArr, bArr2, 1);
    }

    public static String aesEncryptString(String str, String str2) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return Base64.encodeToString(aesEncryptBytes(str.getBytes("UTF-8"), str2.getBytes("UTF-8")), 2);
    }

    public static byte[] cipherOperation(byte[] bArr, byte[] bArr2, int i2) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESUtil.ALGORITHM_NAME);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV_STRING.getBytes("UTF-8"));
        Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
        instance.init(i2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public static String getAesKey() {
        if (TextUtils.isEmpty(aesKey)) {
            aesKey = getRandomString(32);
        }
        return aesKey;
    }

    public static String getRandomString(int i2) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append("zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }
}
