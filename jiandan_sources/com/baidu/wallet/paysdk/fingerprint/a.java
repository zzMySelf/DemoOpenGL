package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.security.keystore.KeyGenParameterSpec;
import com.baidu.android.common.security.AESUtil;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

@TargetApi(23)
public class a {
    public static String b = "wallet_fp_ks_alias";
    public static a c = null;
    public static final String d = "a";
    public KeyStore a;
    public Context e;

    public a(Context context) throws KeyStoreException {
        try {
            this.e = context.getApplicationContext();
            this.a = KeyStore.getInstance("AndroidKeyStore");
        } catch (KeyStoreException e2) {
            StatisticManager.onEvent("fprd_keystroed_exception_happends");
            LogUtil.e(d, e2.getMessage(), e2);
            throw new KeyStoreException("getInstance keystore occured Exception!");
        }
    }

    public static a a(Context context) throws KeyStoreException {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public boolean a() {
        return true;
    }

    public void a(String str) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(AESUtil.ALGORITHM_NAME, "AndroidKeyStore");
            this.a.load((KeyStore.LoadStoreParameter) null);
            instance.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{"CBC"}).setUserAuthenticationRequired(true).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setRandomizedEncryptionRequired(false).build());
            instance.generateKey();
        } catch (IOException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e2) {
            throw new RuntimeException(e2);
        }
    }

    public FingerprintManager.CryptoObject a(int i2, byte[] bArr) throws InvalidKeyException {
        try {
            this.a.load((KeyStore.LoadStoreParameter) null);
            SecretKey secretKey = (SecretKey) this.a.getKey(WalletFingerprint.getKeyStoreNewAlise(this.e), (char[]) null);
            if (secretKey == null) {
                return null;
            }
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            if (i2 == 1) {
                instance.init(i2, secretKey, instance.getParameters());
            } else {
                instance.init(i2, secretKey, new IvParameterSpec(bArr));
            }
            return new FingerprintManager.CryptoObject(instance);
        } catch (IOException | NoSuchAlgorithmException | CertificateException e2) {
            LogUtil.e(d, e2.getMessage(), e2);
            return null;
        } catch (KeyStoreException | UnrecoverableKeyException e3) {
            LogUtil.e(d, e3.getMessage(), e3);
            return null;
        } catch (NoSuchPaddingException e4) {
            LogUtil.e(d, e4.getMessage(), e4);
            return null;
        } catch (InvalidAlgorithmParameterException e5) {
            LogUtil.e(d, e5.getMessage(), e5);
            return null;
        } catch (InvalidKeyException e6) {
            throw e6;
        }
    }
}
