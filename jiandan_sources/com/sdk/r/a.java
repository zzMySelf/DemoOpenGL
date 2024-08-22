package com.sdk.r;

import com.baidu.android.common.security.AESUtil;
import com.sdk.f.f;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a extends com.sdk.i.a {
    public static final String a = "com.sdk.r.a";
    public static boolean b = f.a;

    public static String a(int i2) {
        Random random = new Random();
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            String str2 = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(str2)) {
                int i4 = random.nextInt(2) % 2 == 0 ? 65 : 97;
                str = str + ((char) (random.nextInt(26) + i4));
            } else if ("num".equalsIgnoreCase(str2)) {
                str = str + String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() == 0) {
                return null;
            }
            if (str.trim().length() == 0) {
                return null;
            }
            if (str2 == null) {
                throw new Exception("decrypt key is null");
            } else if (str2.length() != 16) {
                throw new Exception("decrypt key length error");
            } else if (str3.length() == 16) {
                byte[] a2 = c.a(str);
                Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
                instance.init(2, new SecretKeySpec(str2.getBytes(com.baidu.apollon.heartbeat.a.h), AESUtil.ALGORITHM_NAME), new IvParameterSpec(str3.getBytes(com.baidu.apollon.heartbeat.a.h)));
                return new String(instance.doFinal(a2), com.baidu.apollon.heartbeat.a.h);
            } else {
                throw new Exception(" iv decrypt key length error");
            }
        } catch (Exception e) {
            throw new Exception("decrypt errot", e);
        }
    }

    public static String b(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str.trim().length() != 0) {
                        if (str2 == null) {
                            com.sdk.i.a.a(a, "EncryptCbcIv", "encrypt key is null", b);
                            return null;
                        } else if (str2.length() != 16) {
                            com.sdk.i.a.a(a, "EncryptCbcIv", "encrypt key length error", b);
                            return null;
                        } else if (str3.length() != 16) {
                            com.sdk.i.a.a(a, "EncryptCbcIv", "ivStr length error", b);
                            return null;
                        } else {
                            Cipher instance = Cipher.getInstance(AESUtil.TRANSFORMATION);
                            instance.init(1, new SecretKeySpec(str2.getBytes(com.baidu.apollon.heartbeat.a.h), AESUtil.ALGORITHM_NAME), new IvParameterSpec(str3.getBytes(com.baidu.apollon.heartbeat.a.h)));
                            return c.a(instance.doFinal(str.getBytes(com.baidu.apollon.heartbeat.a.h)));
                        }
                    }
                }
            } catch (Exception e) {
                com.sdk.i.a.a(a, "EncryptCbcIv", e.getMessage(), b);
                return null;
            }
        }
        com.sdk.i.a.a(a, "EncryptCbcIv", "encrypt content is null", b);
        return null;
    }
}
