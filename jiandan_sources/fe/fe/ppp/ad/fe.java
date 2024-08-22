package fe.fe.ppp.ad;

import com.baidu.android.common.security.AESUtil;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class fe {

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f2989ad;

        /* renamed from: de  reason: collision with root package name */
        public String f2990de;
        public String qw;

        public qw() {
            this(AESUtil.ALGORITHM_NAME, "AES/CBC/NoPadding", "UTF-8");
        }

        public byte[] ad(String str, String str2, String str3) throws Exception {
            if (str == null || str.length() == 0) {
                throw new Exception("Empty string");
            }
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.qw));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f2990de);
                Cipher instance = Cipher.getInstance(this.f2989ad);
                instance.init(1, secretKeySpec, ivParameterSpec);
                return instance.doFinal(qw(str).getBytes());
            } catch (NoSuchAlgorithmException e) {
                qw.fe(e);
                return null;
            } catch (NoSuchPaddingException e2) {
                qw.fe(e2);
                return null;
            }
        }

        public byte[] de(byte[] bArr, String str, String str2) throws Exception {
            if (bArr == null || bArr.length == 0) {
                throw new Exception("Empty string");
            }
            byte[] bArr2 = new byte[0];
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.qw));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f2990de);
                Cipher instance = Cipher.getInstance(this.f2989ad);
                instance.init(2, secretKeySpec, ivParameterSpec);
                return instance.doFinal(bArr);
            } catch (Throwable th2) {
                qw.fe(th2);
                return bArr2;
            }
        }

        public final String qw(String str) {
            int length = 16 - (str.getBytes().length % 16);
            for (int i2 = 0; i2 < length; i2++) {
                str = str + Ascii.CASE_MASK;
            }
            return str;
        }

        public qw(String str, String str2, String str3) {
            this.qw = "UTF-8";
            this.f2989ad = "AES/CBC/NoPadding";
            this.f2990de = AESUtil.ALGORITHM_NAME;
            this.f2990de = str;
            this.f2989ad = str2;
            this.qw = str3;
        }
    }

    public final String ad(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
        } catch (Exception unused) {
            qw.de("Security", "toHexString is error");
        }
        return sb.toString();
    }

    public String de(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return ad(instance.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String qw(byte[] bArr) {
        int i2;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length * 8;
        int i3 = 0;
        int i4 = 6;
        int i5 = 0;
        int i6 = 0;
        byte b = 0;
        do {
            if (i3 > 0 && i4 > 0) {
                if (i5 >= 0 && i5 < bArr.length - 1) {
                    b = (byte) (((bArr[i5] & 255) << i4) | ((bArr[i5 + 1] & 255) >> (8 - i4)));
                }
                b = (byte) (b & 63);
                i3 = 8 - i4;
                i4 = 6 - i3;
            } else if (i3 == 0) {
                if (i5 >= 0 && i5 < bArr.length) {
                    b = (byte) ((bArr[i5] & 255) >> (8 - i4));
                }
                i3 = 2;
                i4 = 4;
            } else if (i4 == 0) {
                if (i5 >= 0 && i5 < bArr.length) {
                    b = (byte) (bArr[i5] & 63);
                }
                i3 = 0;
                i4 = 6;
            }
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b));
            i6 += 6;
            i5 = i6 / 8;
            i2 = length - i6;
        } while (i2 >= 6);
        if (i2 > 0) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i2)) & 63)));
        }
        int i7 = length % 3;
        for (int i8 = 0; i8 < i7; i8++) {
            sb.append("=");
        }
        return sb.toString();
    }
}
