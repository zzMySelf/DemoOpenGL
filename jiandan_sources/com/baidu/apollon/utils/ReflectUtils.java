package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import com.baidu.android.common.others.IStringUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectUtils {
    public final Object a;
    public final boolean b = true;

    public class NULL {
        public NULL() {
        }
    }

    public ReflectUtils(Class<?> cls) {
        this.a = cls;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static Class<?> c(String str) throws RuntimeException {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Field d(String str) throws RuntimeException {
        Class type = type();
        try {
            return type.getField(str);
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) accessible(type.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new RuntimeException(e);
                    }
                }
            } while (type == null);
            throw new RuntimeException(e);
        }
    }

    public static ReflectUtils on(String str) throws RuntimeException {
        return on(c(str));
    }

    public static Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    public <P> P as(Class<P> cls) {
        final boolean z = this.a instanceof Map;
        AnonymousClass1 r1 = new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                int i2;
                String name = method.getName();
                try {
                    return ReflectUtils.on(ReflectUtils.this.a).call(name, objArr).get();
                } catch (RuntimeException e) {
                    if (z) {
                        Map map = (Map) ReflectUtils.this.a;
                        if (objArr == null) {
                            i2 = 0;
                        } else {
                            i2 = objArr.length;
                        }
                        if (i2 == 0 && name.startsWith("get")) {
                            return map.get(ReflectUtils.b(name.substring(3)));
                        }
                        if (i2 == 0 && name.startsWith("is")) {
                            return map.get(ReflectUtils.b(name.substring(2)));
                        }
                        if (i2 == 1 && name.startsWith("set")) {
                            map.put(ReflectUtils.b(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        };
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, r1);
    }

    public ReflectUtils call(String str) throws RuntimeException {
        return call(str, new Object[0]);
    }

    public ReflectUtils create() throws RuntimeException {
        return create(new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ReflectUtils) {
            return this.a.equals(((ReflectUtils) obj).get());
        }
        return false;
    }

    public ReflectUtils field(String str) throws RuntimeException {
        try {
            return on(d(str).get(this.a));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, ReflectUtils> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((!this.b) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        return linkedHashMap;
    }

    public <T> T get() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public ReflectUtils set(String str, Object obj) throws RuntimeException {
        try {
            Field d = d(str);
            d.setAccessible(true);
            d.set(this.a, a(obj));
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.a.toString();
    }

    public Class<?> type() {
        if (this.b) {
            return (Class) this.a;
        }
        return this.a.getClass();
    }

    public static ReflectUtils on(String str, ClassLoader classLoader) throws RuntimeException {
        return on(a(str, classLoader));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        return a(b(r4, r0), r3.a, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        throw new java.lang.RuntimeException(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.apollon.utils.ReflectUtils call(java.lang.String r4, java.lang.Object... r5) throws java.lang.RuntimeException {
        /*
            r3 = this;
            java.lang.Class[] r0 = a((java.lang.Object[]) r5)
            java.lang.reflect.Method r1 = r3.a((java.lang.String) r4, (java.lang.Class<?>[]) r0)     // Catch:{ NoSuchMethodException -> 0x000f }
            java.lang.Object r2 = r3.a     // Catch:{ NoSuchMethodException -> 0x000f }
            com.baidu.apollon.utils.ReflectUtils r4 = a((java.lang.reflect.Method) r1, (java.lang.Object) r2, (java.lang.Object[]) r5)     // Catch:{ NoSuchMethodException -> 0x000f }
            return r4
        L_0x000f:
            java.lang.reflect.Method r4 = r3.b(r4, r0)     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.Object r0 = r3.a     // Catch:{ NoSuchMethodException -> 0x001a }
            com.baidu.apollon.utils.ReflectUtils r4 = a((java.lang.reflect.Method) r4, (java.lang.Object) r0, (java.lang.Object[]) r5)     // Catch:{ NoSuchMethodException -> 0x001a }
            return r4
        L_0x001a:
            r4 = move-exception
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.ReflectUtils.call(java.lang.String, java.lang.Object[]):com.baidu.apollon.utils.ReflectUtils");
    }

    public ReflectUtils create(Object... objArr) throws RuntimeException {
        Class[] a2 = a(objArr);
        try {
            return a(type().getDeclaredConstructor(a2), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : type().getDeclaredConstructors()) {
                if (a((Class<?>[]) constructor.getParameterTypes(), (Class<?>[]) a2)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new RuntimeException(e);
        }
    }

    public <T> T get(String str) throws RuntimeException {
        return field(str).get();
    }

    public static ReflectUtils a(Constructor<?> constructor, Object... objArr) throws RuntimeException {
        try {
            return on(((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ReflectUtils on(Class<?> cls) {
        return new ReflectUtils(cls);
    }

    public ReflectUtils(Object obj) {
        this.a = obj;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class type = type();
        for (Method method : type.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : type.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + IStringUtil.CURRENT_PATH);
    }

    public static ReflectUtils on(Object obj) {
        return new ReflectUtils(obj);
    }

    public static ReflectUtils a(Method method, Object obj, Object... objArr) throws RuntimeException {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return on(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return on(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object a(Object obj) {
        return obj instanceof ReflectUtils ? ((ReflectUtils) obj).get() : obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?>[] a(java.lang.Object... r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0006
            java.lang.Class[] r3 = new java.lang.Class[r0]
            return r3
        L_0x0006:
            int r1 = r3.length
            java.lang.Class[] r1 = new java.lang.Class[r1]
        L_0x0009:
            int r2 = r3.length
            if (r0 >= r2) goto L_0x001c
            r2 = r3[r0]
            if (r2 != 0) goto L_0x0013
            java.lang.Class<com.baidu.apollon.utils.ReflectUtils$NULL> r2 = com.baidu.apollon.utils.ReflectUtils.NULL.class
            goto L_0x0017
        L_0x0013:
            java.lang.Class r2 = r2.getClass()
        L_0x0017:
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0009
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.ReflectUtils.a(java.lang.Object[]):java.lang.Class[]");
    }

    public static Class<?> a(String str, ClassLoader classLoader) throws RuntimeException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        throw new java.lang.NoSuchMethodException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        return r0.getDeclaredMethod(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r0 = r0.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != null) goto L_0x0009;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method a(java.lang.String r2, java.lang.Class<?>[] r3) throws java.lang.NoSuchMethodException {
        /*
            r1 = this;
            java.lang.Class r0 = r1.type()
            java.lang.reflect.Method r2 = r0.getMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x0009 }
            return r2
        L_0x0009:
            java.lang.reflect.Method r2 = r0.getDeclaredMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x000e }
            return r2
        L_0x000e:
            java.lang.Class r0 = r0.getSuperclass()
            if (r0 == 0) goto L_0x0015
            goto L_0x0009
        L_0x0015:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException
            r2.<init>()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.ReflectUtils.a(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a((Class<?>[]) method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr2.length; i2++) {
            if (clsArr2[i2] != NULL.class && !wrapper(clsArr[i2]).isAssignableFrom(wrapper(clsArr2[i2]))) {
                return false;
            }
        }
        return true;
    }
}
