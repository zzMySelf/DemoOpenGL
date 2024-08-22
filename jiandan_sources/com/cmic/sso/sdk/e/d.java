package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class d {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(str.getBytes(a.h));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return q.a(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
