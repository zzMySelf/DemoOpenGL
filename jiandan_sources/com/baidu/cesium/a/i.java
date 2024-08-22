package com.baidu.cesium.a;

import fe.fe.fe.fe.qw.ad;
import fe.fe.fe.fe.qw.th;
import java.lang.reflect.Method;

public class i {

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th2) {
            super(str, th2);
        }

        public a(Throwable th2) {
            super(th2);
        }
    }

    public static Method ad(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public static String qw(byte[] bArr) {
        byte[] qw = th.qw();
        return new String(ad.fe(qw, qw, bArr));
    }
}
