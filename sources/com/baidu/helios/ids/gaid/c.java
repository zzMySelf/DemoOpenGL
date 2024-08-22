package com.baidu.helios.ids.gaid;

import com.baidu.helios.common.gene.HeliosDNA;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class c {

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

    c() {
    }

    private static Class<?> a(Class<?> cls) {
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        throw new IllegalArgumentException(String.format("Don't know the wrapper type for primitive type %s.", new Object[]{cls}));
    }

    public static Object a(Class<?> cls, Object[] objArr) {
        return (objArr == null || objArr.length <= 0) ? cls.newInstance() : b(cls, objArr);
    }

    public static String a(byte[] bArr) {
        return new String(new HeliosDNA().reverseTranscript(bArr), "UTF-8");
    }

    public static Method a(Class<?> cls, String str, Class<?>[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    private static Object b(Class<?> cls, Object[] objArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (parameterTypes.length >= objArr.length) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < objArr.length) {
                    Object obj = objArr[i2];
                    while (obj != null && i3 < parameterTypes.length) {
                        Class<?> cls2 = parameterTypes[i3];
                        if (cls2.isPrimitive()) {
                            cls2 = a(cls2);
                        }
                        if (cls2.isInstance(obj)) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 == parameterTypes.length) {
                        break;
                    }
                    i3++;
                    i2++;
                }
                if (i2 != objArr.length) {
                    continue;
                } else if (constructor == null || parameterTypes.length < constructor.getParameterTypes().length) {
                    constructor = constructor2;
                } else if (parameterTypes.length == constructor.getParameterTypes().length) {
                    throw new IllegalArgumentException("Multiple consturctors match parameters");
                }
            }
        }
        if (constructor != null) {
            return constructor.newInstance(objArr);
        }
        return null;
    }
}
