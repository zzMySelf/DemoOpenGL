package com.baidu.megapp.hook.reflect;

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

public class Reflect {
    private final boolean isClass = true;
    /* access modifiers changed from: private */
    public final Object object;

    public static <T extends AccessibleObject> T accessible(T accessible) {
        if (accessible == null) {
            return null;
        }
        if (accessible instanceof Member) {
            Member member = (Member) accessible;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return accessible;
            }
        }
        if (!accessible.isAccessible()) {
            accessible.setAccessible(true);
        }
        return accessible;
    }

    private Reflect(Class<?> type) {
        this.object = type;
    }

    private Reflect(Object object2) {
        this.object = object2;
    }

    public <T> T get() {
        return this.object;
    }

    public <T> T get(String name) throws ReflectException {
        return field(name).get();
    }

    public Reflect set(String name, Object value) throws ReflectException {
        try {
            Field field = field0(name);
            field.setAccessible(true);
            field.set(this.object, unwrap(value));
            return this;
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    public Reflect field(String name) throws ReflectException {
        try {
            return on(field0(name).get(this.object));
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    private Field field0(String name) throws ReflectException {
        Class type = type();
        try {
            return type.getField(name);
        } catch (NoSuchFieldException e2) {
            do {
                try {
                    return (Field) accessible(type.getDeclaredField(name));
                } catch (NoSuchFieldException e3) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException((Throwable) e2);
                    }
                }
            } while (type == null);
            throw new ReflectException((Throwable) e2);
        }
    }

    public Map<String, Reflect> fields() {
        Map<String, Reflect> result = new LinkedHashMap<>();
        Class type = type();
        do {
            for (Field field : type.getDeclaredFields()) {
                if ((!this.isClass) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!result.containsKey(name)) {
                        result.put(name, field(name));
                    }
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        return result;
    }

    public Reflect call(String name) throws ReflectException {
        return call(name, new Object[0]);
    }

    public Reflect call(String name, Object... args) throws ReflectException {
        Class<?>[] types = types(args);
        try {
            return on(exactMethod(name, types), this.object, args);
        } catch (NoSuchMethodException e2) {
            try {
                return on(similarMethod(name, types), this.object, args);
            } catch (NoSuchMethodException e1) {
                throw new ReflectException((Throwable) e1);
            }
        }
    }

    private Method exactMethod(String name, Class<?>[] types) throws NoSuchMethodException {
        Class type = type();
        try {
            return type.getMethod(name, types);
        } catch (NoSuchMethodException e2) {
            do {
                try {
                    return type.getDeclaredMethod(name, types);
                } catch (NoSuchMethodException e3) {
                    type = type.getSuperclass();
                    if (type != null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private Method similarMethod(String name, Class<?>[] types) throws NoSuchMethodException {
        Class type = type();
        for (Method method : type.getMethods()) {
            if (isSimilarSignature(method, name, types)) {
                return method;
            }
        }
        do {
            for (Method method2 : type.getDeclaredMethods()) {
                if (isSimilarSignature(method2, name, types)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + name + " with params " + Arrays.toString(types) + " could be found on type " + type() + ".");
    }

    private boolean isSimilarSignature(Method possiblyMatchingMethod, String desiredMethodName, Class<?>[] desiredParamTypes) {
        return possiblyMatchingMethod.getName().equals(desiredMethodName) && match(possiblyMatchingMethod.getParameterTypes(), desiredParamTypes);
    }

    public Reflect create() throws ReflectException {
        return create(new Object[0]);
    }

    public Reflect create(Object... args) throws ReflectException {
        Class<?>[] types = types(args);
        try {
            return on(type().getDeclaredConstructor(types), args);
        } catch (NoSuchMethodException e2) {
            for (Constructor<?> constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), types)) {
                    return on(constructor, args);
                }
            }
            throw new ReflectException((Throwable) e2);
        }
    }

    public <P> P as(Class<P> proxyType) {
        final boolean isMap = this.object instanceof Map;
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                try {
                    return Reflect.on(Reflect.this.object).call(name, args).get();
                } catch (ReflectException e2) {
                    if (isMap) {
                        Map<String, Object> map = (Map) Reflect.this.object;
                        int length = args == null ? 0 : args.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(Reflect.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(Reflect.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(Reflect.property(name.substring(3)), args[0]);
                            return null;
                        }
                    }
                    throw e2;
                }
            }
        };
        return Proxy.newProxyInstance(proxyType.getClassLoader(), new Class[]{proxyType}, handler);
    }

    /* access modifiers changed from: private */
    public static String property(String string) {
        int length = string.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return string.toLowerCase();
        }
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }

    private boolean match(Class<?>[] declaredTypes, Class<?>[] actualTypes) {
        if (declaredTypes.length != actualTypes.length) {
            return false;
        }
        for (int i2 = 0; i2 < actualTypes.length; i2++) {
            if (actualTypes[i2] != NULL.class && !wrapper(declaredTypes[i2]).isAssignableFrom(wrapper(actualTypes[i2]))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.object.equals(((Reflect) obj).get());
        }
        return false;
    }

    public String toString() {
        return this.object.toString();
    }

    public static Reflect on(String name) throws ReflectException {
        return on(forName(name));
    }

    public static Reflect on(String name, ClassLoader classLoader) throws ReflectException {
        return on(forName(name, classLoader));
    }

    public static Reflect on(Class<?> clazz) {
        return new Reflect(clazz);
    }

    public static Reflect on(Object object2) {
        return new Reflect(object2);
    }

    private static Reflect on(Constructor<?> constructor, Object... args) throws ReflectException {
        try {
            return on(((Constructor) accessible(constructor)).newInstance(args));
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    private static Reflect on(Method method, Object object2, Object... args) throws ReflectException {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return on(method.invoke(object2, args));
            }
            method.invoke(object2, args);
            return on(object2);
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    private static Object unwrap(Object object2) {
        if (object2 instanceof Reflect) {
            return ((Reflect) object2).get();
        }
        return object2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Class<?>[] types(java.lang.Object... r4) {
        /*
            if (r4 != 0) goto L_0x0006
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            return r0
        L_0x0006:
            int r0 = r4.length
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
        L_0x000a:
            int r2 = r4.length
            if (r1 >= r2) goto L_0x001d
            r2 = r4[r1]
            if (r2 != 0) goto L_0x0014
            java.lang.Class<com.baidu.megapp.hook.reflect.Reflect$NULL> r3 = com.baidu.megapp.hook.reflect.Reflect.NULL.class
            goto L_0x0018
        L_0x0014:
            java.lang.Class r3 = r2.getClass()
        L_0x0018:
            r0[r1] = r3
            int r1 = r1 + 1
            goto L_0x000a
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.megapp.hook.reflect.Reflect.types(java.lang.Object[]):java.lang.Class[]");
    }

    private static Class<?> forName(String name) throws ReflectException {
        try {
            return Class.forName(name);
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    private static Class<?> forName(String name, ClassLoader classLoader) throws ReflectException {
        try {
            return Class.forName(name, true, classLoader);
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    public Class<?> type() {
        if (this.isClass) {
            return (Class) this.object;
        }
        return this.object.getClass();
    }

    public static Class<?> wrapper(Class<?> type) {
        if (type == null) {
            return null;
        }
        if (type.isPrimitive()) {
            if (Boolean.TYPE == type) {
                return Boolean.class;
            }
            if (Integer.TYPE == type) {
                return Integer.class;
            }
            if (Long.TYPE == type) {
                return Long.class;
            }
            if (Short.TYPE == type) {
                return Short.class;
            }
            if (Byte.TYPE == type) {
                return Byte.class;
            }
            if (Double.TYPE == type) {
                return Double.class;
            }
            if (Float.TYPE == type) {
                return Float.class;
            }
            if (Character.TYPE == type) {
                return Character.class;
            }
            if (Void.TYPE == type) {
                return Void.class;
            }
        }
        return type;
    }

    private static class NULL {
        private NULL() {
        }
    }
}
