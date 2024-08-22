package com.baidu.apollon.utils.reflect;

import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {
    public static final Object[] a = new Object[0];
    public static final Class<?>[] b = new Class[0];
    public static final String c = "(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";
    public static final Pattern d = Pattern.compile(c);

    public static boolean a(Object[] objArr, Object[] objArr2) {
        if (objArr == null && objArr2 != null && objArr2.length > 0) {
            return false;
        }
        if (objArr2 != null || objArr == null || objArr.length <= 0) {
            return objArr == null || objArr2 == null || objArr.length == objArr2.length;
        }
        return false;
    }

    public static Object[] b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return a;
        }
        return objArr;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(cls, (HashSet<Class<?>>) linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static boolean isMethodDeclaredThrowable(Method method, Throwable th2) {
        Class[] exceptionTypes;
        boolean z;
        if (th2 instanceof RuntimeException) {
            return true;
        }
        if (method == null || th2 == null || ((exceptionTypes = method.getExceptionTypes()) == null && exceptionTypes.length <= 0)) {
            return false;
        }
        try {
            String name = method.getName();
            if (!LightappBusinessClient.ACCEPT_MESSAGE_CB.equals(name)) {
                if (!"sendto".equals(name)) {
                    z = false;
                    if ((th2 instanceof SocketException) && z && method.getDeclaringClass().getName().indexOf("libcore") >= 0) {
                        return true;
                    }
                    for (Class cls : exceptionTypes) {
                        if (cls.isInstance(th2) || cls.isAssignableFrom(th2.getClass())) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            z = true;
            return true;
        } catch (Throwable unused) {
        }
    }

    public static boolean validateJavaIdentifier(String str) {
        return d.matcher(str).matches();
    }

    public static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return b;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
        }
        return clsArr;
    }

    public static Class<?>[] a(Class<?>[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return b;
        }
        return clsArr;
    }

    public static void a(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            for (Class cls3 : cls2.getInterfaces()) {
                if (hashSet.add(cls3)) {
                    a((Class<?>) cls3, hashSet);
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
    }
}
