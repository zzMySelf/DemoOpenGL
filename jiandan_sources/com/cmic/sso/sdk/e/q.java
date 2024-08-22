package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.cmic.sso.sdk.a;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import java.util.UUID;

public class q {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(b >>> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static String b() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String c() {
        return d().replace("-", "");
    }

    public static String d() {
        return UUID.randomUUID().toString();
    }

    public static void c(a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceElasped", ""))) {
            aVar.a("interfaceElasped", str);
            return;
        }
        aVar.a("interfaceElasped", aVar.b("interfaceElasped") + i.b + str);
    }

    public static void b(a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceCode", ""))) {
            aVar.a("interfaceCode", str);
            return;
        }
        aVar.a("interfaceCode", aVar.b("interfaceCode") + i.b + str);
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static void a(a aVar, String str) {
        if (TextUtils.isEmpty(aVar.b("interfaceType", ""))) {
            aVar.a("interfaceType", str);
            return;
        }
        aVar.a("interfaceType", aVar.b("interfaceType") + i.b + str);
    }

    public static boolean a(com.cmic.sso.sdk.a.a aVar) {
        return k.a("logCloseTime", 0) + ((long) (((aVar.l() * 60) * 60) * 1000)) >= System.currentTimeMillis();
    }
}
