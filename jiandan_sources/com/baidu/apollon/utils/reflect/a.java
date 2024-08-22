package com.baidu.apollon.utils.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static final int a = 7;
    public static final Class<?>[] b = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    public static final Map<Class<?>, Class<?>> c = new HashMap();
    public static final Map<Class<?>, Class<?>> d = new HashMap();

    static {
        c.put(Boolean.TYPE, Boolean.class);
        c.put(Byte.TYPE, Byte.class);
        c.put(Character.TYPE, Character.class);
        c.put(Short.TYPE, Short.class);
        c.put(Integer.TYPE, Integer.class);
        c.put(Long.TYPE, Long.class);
        c.put(Double.TYPE, Double.class);
        c.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = c;
        Class cls = Void.TYPE;
        map.put(cls, cls);
        for (Class next : c.keySet()) {
            Class cls2 = c.get(next);
            if (!next.equals(cls2)) {
                d.put(cls2, next);
            }
        }
    }

    public static boolean a(int i2) {
        return (i2 & 7) == 0;
    }

    public static boolean a(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic();
    }

    public static Class<?> b(Class<?> cls) {
        return d.get(cls);
    }

    public static float c(Class<?> cls, Class<?> cls2) {
        float f;
        if (!cls.isPrimitive()) {
            cls = b(cls);
            f = 0.1f;
        } else {
            f = 0.0f;
        }
        int i2 = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = b;
            if (i2 >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i2]) {
                f += 0.1f;
                if (i2 < clsArr.length - 1) {
                    cls = clsArr[i2 + 1];
                }
            }
            i2++;
        }
        return f;
    }

    public static boolean a(AccessibleObject accessibleObject) {
        if (accessibleObject != null && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && a(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }

    public static float b(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return c(cls, cls2);
        }
        float f = 0.0f;
        Class<? super Object> cls3 = cls;
        while (true) {
            if (cls3 != null && !cls2.equals(cls3)) {
                if (cls2.isInterface() && a(cls3, cls2)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls3 = cls3.getSuperclass();
            } else {
                break;
            }
        }
        return cls3 == null ? f + 1.5f : f;
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        return a(cls, cls2, true);
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!Utils.a((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = Utils.b;
        }
        if (clsArr2 == null) {
            clsArr2 = Utils.b;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!a(clsArr[i2], clsArr2[i2], z)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = a(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = b(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (Integer.TYPE.equals(cls)) {
            if (Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                return true;
            }
            return false;
        } else if (Long.TYPE.equals(cls)) {
            if (Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                return true;
            }
            return false;
        } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
            return false;
        } else {
            if (Float.TYPE.equals(cls)) {
                return Double.TYPE.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            } else if (Short.TYPE.equals(cls)) {
                if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            } else if (!Byte.TYPE.equals(cls)) {
                return false;
            } else {
                if (Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            }
        }
    }

    public static Class<?> a(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : c.get(cls);
    }

    public static int a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float a2 = a(clsArr3, clsArr);
        float a3 = a(clsArr3, clsArr2);
        if (a2 < a3) {
            return -1;
        }
        return a3 < a2 ? 1 : 0;
    }

    public static float a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            f += b(clsArr[i2], clsArr2[i2]);
        }
        return f;
    }
}
