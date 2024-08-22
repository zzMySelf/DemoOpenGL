package com.baidu.nadcore.sweetsqlite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static <T> T instance(Class<T> clazz) {
        try {
            return clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(clazz + " can't init new instance by default constructor.", e2);
        }
    }

    public static Method declaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class " + clazz.getCanonicalName() + " can't find method " + name, e2);
        }
    }

    public static <T> T invoke(Method method, Object receiver, Object... args) {
        try {
            return method.invoke(receiver, args);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Method " + method.getName() + " can't call on " + receiver.getClass(), e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalArgumentException("Method " + method.getName() + " can't call on " + receiver.getClass(), e3);
        }
    }

    public static Field declaredField(Class<?> clazz, String name) {
        try {
            return clazz.getDeclaredField(name);
        } catch (NoSuchFieldException e2) {
            throw new IllegalArgumentException(clazz.toString() + " can't find " + name + " field.", e2);
        }
    }
}
