package com.cmic.sso.sdk.e;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class i {
    public static final String a = "i";
    public static i d;
    public PublicKey b = null;
    public PublicKey c = null;

    public i() {
        try {
            b();
            if (this.c == null) {
                c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static i a() {
        if (d == null) {
            d = new i();
        }
        return d;
    }

    private void c() {
        try {
            this.c = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuyqBGJVxu+5Z2ZwItIhl\noxI53CVpYUR3OWAQyAQNcMhDDf3nGsxLLHP8kGWqrpLn1uAIgI+EIAl0sM+i1leD\nFD+sYU2rkUVZgpwO7ly+THBFw/YcZNwS094NBdhzxmCCFbCKHVNzDLirlV9T2q4k\nJhjaEmyCOtSU6+mdjcHhbcbF6lKYx8tfQlpPmyM5suFY138qtEoB4b+q/j8q22MI\naUotg1Av257RuMh97hAwoi5D7HS5LH0piLIN/au/X08rxbXnWNdgQtFtUeCNy3vw\nkO0ykg5qH942X8poQ+a9GgBUeDBpY4GSIv6/qq+zJxiJxpoL0SGKAP3FlcuLr07f\nxwIDAQAB", 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥输入流为空");
        }
    }

    public String b(byte[] bArr) {
        if (this.b == null) {
            c.a(a, "mServerPublicKey == null");
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
            instance.init(1, this.c);
            return Base64.encodeToString(instance.doFinal(bArr), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String a(byte[] bArr) {
        if (this.b == null) {
            c.a(a, "mServerPublicKey == null");
            return "";
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
            instance.init(1, this.b);
            return q.a(instance.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void b() {
        try {
            this.b = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNFGdEpQ1d8cPqekvvEDQyBGnI\nKwvjX9o3OmnnqWMGbIiFYIpc21QeG7aqizuWdXlgS5M9rstDfHQfG/AaPElJ7Yix\nBCau4hdVwFpRmb9NIuqavDeHKP9BKPZ01Ra5/666NGKBqmkRRer3lBCe6EKNUc2U\n/DZg6U/Q3CTPiORt/wIDAQAB", 0)));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
