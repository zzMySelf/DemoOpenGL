package com.baidu.netdisk.kernel.encode;

import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESUtil {
    private static final String CIPHER_KEY = "DES";
    private static final String TAG = "DESUtil";

    public static String getDESKey() {
        byte[] result = MD5Util.createMD5(String.valueOf(System.currentTimeMillis()).getBytes());
        if (result == null || result.length == 0) {
            return "";
        }
        return Base64Util.encode(result);
    }

    public static byte[] encrypt(byte[] rawKeyData, byte[] data) {
        return handle(rawKeyData, data, 1);
    }

    public static byte[] decrypt(byte[] rawKeyData, byte[] data) {
        return handle(rawKeyData, data, 2);
    }

    private static byte[] handle(byte[] keyData, byte[] data, int mode) {
        if (keyData == null || data == null || keyData.length == 0 || data.length == 0) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_KEY);
            if (cipher == null) {
                return null;
            }
            cipher.init(mode, SecretKeyFactory.getInstance(CIPHER_KEY).generateSecret(new DESKeySpec(keyData)), new SecureRandom());
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e2) {
            NetDiskLog.e(TAG, e2.getMessage(), e2);
            return null;
        } catch (NoSuchPaddingException e3) {
            NetDiskLog.e(TAG, e3.getMessage(), e3);
            return null;
        } catch (IllegalBlockSizeException e4) {
            NetDiskLog.e(TAG, e4.getMessage(), e4);
            return null;
        } catch (BadPaddingException e5) {
            NetDiskLog.e(TAG, e5.getMessage(), e5);
            return null;
        } catch (InvalidKeySpecException e6) {
            NetDiskLog.e(TAG, e6.getMessage(), e6);
            return null;
        } catch (InvalidKeyException e7) {
            NetDiskLog.e(TAG, e7.getMessage(), e7);
            return null;
        }
    }
}
