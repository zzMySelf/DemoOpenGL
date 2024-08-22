package com.baidu.wallet.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.wallet.core.NoProguard;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RsaUtils implements NoProguard {
    public static String privateKey;
    public static String publicKey;

    public static String decrypt(RSAPrivateKey rSAPrivateKey, String str) throws Exception {
        if (rSAPrivateKey == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, rSAPrivateKey);
            return new String(instance.doFinal(Base64.decode(str, 2)), "UTF-8");
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException unused2) {
            throw new Exception("解密公钥非法,请检查");
        } catch (IllegalBlockSizeException unused3) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException unused4) {
            throw new Exception("密文数据已损坏");
        }
    }

    public static String encrypt(RSAPublicKey rSAPublicKey, String str) throws Exception {
        if (rSAPublicKey == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, rSAPublicKey);
            return Base64.encodeToString(instance.doFinal(str.getBytes("UTF-8")), 2);
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException unused2) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException unused3) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException unused4) {
            throw new Exception("明文数据已损坏");
        }
    }

    public static void genKeyPair() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            keyPairGenerator = null;
        }
        keyPairGenerator.initialize(1024, new SecureRandom());
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        privateKey = Base64.encodeToString(generateKeyPair.getPrivate().getEncoded(), 2);
        publicKey = Base64.encodeToString(generateKeyPair.getPublic().getEncoded(), 2);
    }

    public static String getPrivateKey() {
        return privateKey;
    }

    public static String getPublicKey() {
        return publicKey;
    }

    public static RSAPrivateKey loadPrivateKeyByStr(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("私钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("私钥数据为空");
        }
    }

    public static RSAPublicKey loadPublicKeyByStr(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }
}
