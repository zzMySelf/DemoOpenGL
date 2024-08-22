package com.baidu.apollon.utils.reflect;

import com.baidu.wallet.paysdk.datamodel.Bank;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class MethodUtils {
    public static Map<String, Method> a = new HashMap();

    public static String a(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append(Bank.HOT_BANK_LETTER);
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.toString());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append(Bank.HOT_BANK_LETTER);
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Method b(java.lang.Class<?> r2, java.lang.String r3, java.lang.Class<?>... r4) {
        /*
            java.lang.Class r2 = r2.getSuperclass()
        L_0x0004:
            r0 = 0
            if (r2 == 0) goto L_0x001c
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L_0x0017
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0016 }
            return r2
        L_0x0016:
            return r0
        L_0x0017:
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x0004
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.reflect.MethodUtils.b(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            Class[] interfaces = cls2.getInterfaces();
            for (int i2 = 0; i2 < interfaces.length; i2++) {
                if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                    try {
                        return interfaces[i2].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method c = c(interfaces[i2], str, clsArr);
                        if (c != null) {
                            return c;
                        }
                    }
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
        return null;
    }

    public static Method d(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method a2;
        String a3 = a(cls, str, clsArr);
        synchronized (a) {
            method = a.get(a3);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method method2 = cls.getMethod(str, clsArr);
            a.a((AccessibleObject) method2);
            synchronized (a) {
                a.put(a3, method2);
            }
            return method2;
        } catch (NoSuchMethodException unused) {
            Method method3 = null;
            for (Method method4 : cls.getMethods()) {
                if (method4.getName().equals(str) && a.a(clsArr, (Class<?>[]) method4.getParameterTypes(), true) && (a2 = a(method4)) != null && (method3 == null || a.a((Class<?>[]) a2.getParameterTypes(), (Class<?>[]) method3.getParameterTypes(), clsArr) < 0)) {
                    method3 = a2;
                }
            }
            if (method3 != null) {
                a.a((AccessibleObject) method3);
            }
            synchronized (a) {
                a.put(a3, method3);
                return method3;
            }
        }
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        String a2 = a(cls, str, clsArr);
        synchronized (a) {
            method = a.get(a2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        Method a3 = a(cls.getMethod(str, clsArr));
        synchronized (a) {
            a.put(a2, a3);
        }
        return a3;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Constructor<T> a2;
        b.a(cls != null, "class cannot be null", new Object[0]);
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            a.a((AccessibleObject) constructor);
            return constructor;
        } catch (NoSuchMethodException unused) {
            Constructor<T> constructor2 = null;
            for (Constructor constructor3 : cls.getConstructors()) {
                if (a.a(clsArr, (Class<?>[]) constructor3.getParameterTypes(), true) && (a2 = a(constructor3)) != null) {
                    a.a((AccessibleObject) a2);
                    if (constructor2 == null || a.a((Class<?>[]) a2.getParameterTypes(), (Class<?>[]) constructor2.getParameterTypes(), clsArr) < 0) {
                        constructor2 = a2;
                    }
                }
            }
            return constructor2;
        }
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] b = Utils.b(objArr);
        return invokeConstructor(cls, b, Utils.a(b));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] a2 = Utils.a(clsArr);
        Object[] b = Utils.b(objArr);
        Method d = d(obj.getClass(), str, a2);
        if (d != null) {
            return d.invoke(obj, b);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] a2 = Utils.a(clsArr);
        Object[] b = Utils.b(objArr);
        Method d = d(cls, str, a2);
        if (d != null) {
            return d.invoke((Object) null, b);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] b = Utils.b(objArr);
        Constructor<T> matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, Utils.a(clsArr));
        if (matchingAccessibleConstructor != null) {
            return matchingAccessibleConstructor.newInstance(b);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b = Utils.b(objArr);
        return invokeMethod(obj, str, b, Utils.a(b));
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b = Utils.b(objArr);
        return invokeStaticMethod(cls, str, b, Utils.a(b));
    }

    public static Method a(Method method) {
        if (!a.a((Member) method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        Method c = c(declaringClass, name, parameterTypes);
        return c == null ? b(declaringClass, name, parameterTypes) : c;
    }

    public static <T> Constructor<T> a(Constructor<T> constructor) {
        b.a(constructor != null, "constructor cannot be null", new Object[0]);
        if (!a.a((Member) constructor) || !a((Class<?>) constructor.getDeclaringClass())) {
            return null;
        }
        return constructor;
    }

    public static boolean a(Class<?> cls) {
        while (cls != null) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                return false;
            }
            cls = cls.getEnclosingClass();
        }
        return true;
    }
}
