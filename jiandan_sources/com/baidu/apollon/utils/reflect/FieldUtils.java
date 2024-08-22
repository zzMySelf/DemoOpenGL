package com.baidu.apollon.utils.reflect;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class FieldUtils {
    public static Map<String, Field> a = new HashMap();

    public static String a(Class<?> cls, String str) {
        return cls.toString() + Bank.HOT_BANK_LETTER + str;
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        b.a(cls != null, "The class must not be null", new Object[0]);
        b.a(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!a.a((Member) declaredField)) {
                if (!z) {
                    return null;
                }
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static Field getField(Class<?> cls, String str) {
        return a(cls, str, true);
    }

    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        b.a(field != null, "The field must not be null", new Object[0]);
        if (!z || field.isAccessible()) {
            a.a((AccessibleObject) field);
        } else {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        b.a(field != null, "The field must not be null", new Object[0]);
        b.a(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
        return readField(field, (Object) null, z);
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        b.a(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, true);
        b.a(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, obj, obj2, false);
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        b.a(field != null, "The field must not be null", new Object[0]);
        if (!z || field.isAccessible()) {
            a.a((AccessibleObject) field);
        } else {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        b.a(field != null, "The field must not be null", new Object[0]);
        b.a(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        writeField(field, (Object) null, obj, z);
    }

    public static Field a(Class<?> cls, String str, boolean z) {
        Field field;
        b.a(cls != null, "The class must not be null", new Object[0]);
        b.a(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
        String a2 = a(cls, str);
        synchronized (a) {
            field = a.get(a2);
        }
        if (field != null) {
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        Class<?> cls2 = cls;
        while (cls2 != null) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    if (z) {
                        declaredField.setAccessible(true);
                    } else {
                        continue;
                        cls2 = cls2.getSuperclass();
                    }
                }
                synchronized (a) {
                    a.put(a2, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field2 = null;
        for (Class field3 : Utils.getAllInterfaces(cls)) {
            try {
                Field field4 = field3.getField(str);
                b.a(field2 == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field2 = field4;
            } catch (NoSuchFieldException unused2) {
            }
        }
        synchronized (a) {
            a.put(a2, field2);
        }
        return field2;
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        Field a2 = a(cls, str, true);
        b.a(a2 != null, "Cannot locate field '%s' on %s", str, cls);
        return readStaticField(a2, true);
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return readField(field, obj, true);
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, true);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Field a2 = a(cls, str, true);
        b.a(a2 != null, "Cannot locate field %s on %s", str, cls);
        writeStaticField(a2, obj, true);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        b.a(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field a2 = a(cls, str, true);
        b.a(a2 != null, "Cannot locate field %s on %s", str, cls);
        return readField(a2, obj, false);
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        b.a(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field a2 = a(cls, str, true);
        b.a(a2 != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(a2, obj, obj2, z);
    }

    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        b.a(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field a2 = a(cls, str, z);
        b.a(a2 != null, "Cannot locate field %s on %s", str, cls);
        return readField(a2, obj, z);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, true);
    }
}
