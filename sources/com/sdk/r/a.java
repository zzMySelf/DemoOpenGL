package com.sdk.r;

import com.sdk.f.f;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a extends com.sdk.i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5565a = "com.sdk.r.a";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5566b = f.f5520a;

    public static String a(int i2) {
        StringBuilder sb;
        Random random = new Random();
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            String str2 = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(str2)) {
                sb = new StringBuilder().append(str).append((char) (random.nextInt(26) + (random.nextInt(2) % 2 == 0 ? 65 : 97)));
            } else if ("num".equalsIgnoreCase(str2)) {
                sb = new StringBuilder().append(str).append(String.valueOf(random.nextInt(10)));
            }
            str = sb.toString();
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
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                return new String(instance.doFinal(a2), "utf-8");
            } else {
                throw new Exception(" iv decrypt key length error");
            }
        } catch (Exception e2) {
            throw new Exception("decrypt errot", e2);
        }
    }

    public static String b(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str.trim().length() != 0) {
                        if (str2 == null) {
                            com.sdk.i.a.a(f5565a, "EncryptCbcIv", "encrypt key is null", f5566b);
                            return null;
                        } else if (str2.length() != 16) {
                            com.sdk.i.a.a(f5565a, "EncryptCbcIv", "encrypt key length error", f5566b);
                            return null;
                        } else if (str3.length() != 16) {
                            com.sdk.i.a.a(f5565a, "EncryptCbcIv", "ivStr length error", f5566b);
                            return null;
                        } else {
                            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                            instance.init(1, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                            return c.a(instance.doFinal(str.getBytes("utf-8")));
                        }
                    }
                }
            } catch (Exception e2) {
                com.sdk.i.a.a(f5565a, "EncryptCbcIv", e2.getMessage(), f5566b);
                return null;
            }
        }
        com.sdk.i.a.a(f5565a, "EncryptCbcIv", "encrypt content is null", f5566b);
        return null;
    }
}
