package com.alipay.sdk.m.e;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.json.alipay.b;

public final class g implements i, j {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.Object r9) {
        /*
            r8 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.Class r1 = r9.getClass()
        L_0x0009:
            java.lang.reflect.Field[] r2 = r1.getDeclaredFields()
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005b
            if (r2 == 0) goto L_0x0056
            int r3 = r2.length
            if (r3 <= 0) goto L_0x0056
            int r3 = r2.length
            r4 = 0
        L_0x001c:
            if (r4 >= r3) goto L_0x0056
            r5 = r2[r4]
            if (r5 == 0) goto L_0x0049
            if (r9 != 0) goto L_0x0025
            goto L_0x0049
        L_0x0025:
            java.lang.String r6 = r5.getName()
            java.lang.String r7 = "this$0"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0032
            goto L_0x0049
        L_0x0032:
            boolean r6 = r5.isAccessible()
            r7 = 1
            r5.setAccessible(r7)
            java.lang.Object r7 = r5.get(r9)
            if (r7 != 0) goto L_0x0041
            goto L_0x0049
        L_0x0041:
            r5.setAccessible(r6)
            java.lang.Object r6 = com.alipay.sdk.m.e.f.b(r7)
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            if (r6 == 0) goto L_0x0053
            java.lang.String r5 = r5.getName()
            r0.put(r5, r6)
        L_0x0053:
            int r4 = r4 + 1
            goto L_0x001c
        L_0x0056:
            java.lang.Class r1 = r1.getSuperclass()
            goto L_0x0009
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.e.g.a(java.lang.Object):java.lang.Object");
    }

    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(b.class)) {
            return null;
        }
        b bVar = (b) obj;
        Class cls = (Class) type;
        Object newInstance = cls.newInstance();
        while (!cls.equals(Object.class)) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    String name = field.getName();
                    Type genericType = field.getGenericType();
                    if (bVar.b(name)) {
                        field.setAccessible(true);
                        field.set(newInstance, e.a(bVar.a(name), genericType));
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return newInstance;
    }

    public final boolean a(Class<?> cls) {
        return true;
    }
}
