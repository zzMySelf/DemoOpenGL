package com.baidu.helios.channels.upc;

import fe.fe.pf.yj.de.ad;
import java.lang.reflect.Method;

public class ReflectUtil {

    public static class MethodInvokeException extends Exception {
        public MethodInvokeException(String str) {
            super(str);
        }

        public MethodInvokeException(String str, Throwable th2) {
            super(str, th2);
        }

        public MethodInvokeException(Throwable th2) {
            super(th2);
        }
    }

    public static String ad(byte[] bArr) throws Exception {
        return new String(new ad().qw(bArr));
    }

    public static Method qw(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
