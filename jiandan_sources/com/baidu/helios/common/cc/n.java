package com.baidu.helios.common.cc;

import fe.fe.pf.yj.de.ad;
import java.lang.reflect.Method;

public class n {

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
        return new String(new ad().qw(bArr), "UTF-8");
    }
}
