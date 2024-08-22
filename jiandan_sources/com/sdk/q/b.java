package com.sdk.q;

import com.sdk.f.f;
import com.sdk.i.a;
import com.sdk.r.c;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class b extends a {
    public static String a = "RSA/ECB/PKCS1Padding";

    static {
        boolean z = f.a;
    }

    public static String a(String str, String str2) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) a.a(str2);
        if (!com.sdk.o.a.a(str).booleanValue()) {
            byte[] a2 = c.a(str);
            if (rSAPublicKey != null) {
                try {
                    Cipher instance = Cipher.getInstance(a);
                    instance.init(2, rSAPublicKey);
                    return new String(instance.doFinal(a2), Charset.defaultCharset()).trim();
                } catch (NoSuchAlgorithmException unused) {
                    throw new NoSuchAlgorithmException("无此解密算法");
                } catch (NoSuchPaddingException unused2) {
                    throw new NoSuchPaddingException("解密出错！不支持该填充机制");
                } catch (InvalidKeyException unused3) {
                    throw new InvalidKeyException("解密公钥非法,请检查");
                } catch (IllegalBlockSizeException unused4) {
                    throw new IllegalBlockSizeException("密文长度非法");
                } catch (BadPaddingException unused5) {
                    throw new BadPaddingException("密文数据已损坏");
                }
            } else {
                throw new Exception("解密公钥为空, 请设置");
            }
        } else {
            throw new Exception("rsaAes key is null");
        }
    }

    public static String b(String str, String str2) {
        PublicKey a2 = a.a(str);
        Cipher instance = Cipher.getInstance(a);
        instance.init(1, a2);
        return c.a(instance.doFinal(str2.getBytes(Charset.defaultCharset()))).toString();
    }
}
