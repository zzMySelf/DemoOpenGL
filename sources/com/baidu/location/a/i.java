package com.baidu.location.a;

import android.util.Base64;
import com.baidu.location.Jni;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private IvParameterSpec f13720a;

    /* renamed from: b  reason: collision with root package name */
    private SecretKeySpec f13721b;

    /* renamed from: c  reason: collision with root package name */
    private Cipher f13722c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13723d;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static i f13724a = new i();
    }

    private i() {
        this.f13723d = false;
        try {
            String str = Jni.getldkaiv();
            if (str != null && str.contains("|")) {
                String[] split = str.split("\\|");
                this.f13720a = new IvParameterSpec(split[1].getBytes("UTF-8"));
                this.f13721b = new SecretKeySpec(split[0].getBytes("UTF-8"), "AES");
                this.f13722c = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                this.f13723d = true;
            }
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
    }

    public static i a() {
        return a.f13724a;
    }

    public String a(String str) {
        if (!this.f13723d) {
            return null;
        }
        try {
            this.f13722c.init(2, this.f13721b, this.f13720a);
            return new String(this.f13722c.doFinal(Base64.decode(str, 0)), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public synchronized String b(String str) {
        if (!this.f13723d) {
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(2, this.f13721b, this.f13720a);
            return new String(instance.doFinal(Base64.decode(str, 0)), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean b() {
        return this.f13723d;
    }

    public String c(String str) {
        if (!this.f13723d) {
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(1, this.f13721b, this.f13720a);
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
