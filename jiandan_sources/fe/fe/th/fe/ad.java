package fe.fe.th.fe;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class ad {
    public static byte[] ad(RSAPublicKey rSAPublicKey, byte[] bArr) {
        if (rSAPublicKey != null) {
            try {
                Cipher instance = Cipher.getInstance("RSA");
                instance.init(2, rSAPublicKey);
                return instance.doFinal(bArr);
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
        } else {
            throw new Exception("解密公钥为空, 请设置");
        }
    }

    public static RSAPublicKey qw(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(qw.de(str)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }
}
