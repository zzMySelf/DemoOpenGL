package com.baidu.tinyioc.core.support;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

public class BeanUtils {
    private BeanUtils() {
    }

    public static Constructor<?> getMatchedConstructor(Class<?> beanClassImpl, Object[][] out, Object... args) {
        Object[] objArr = args;
        if (objArr == null || objArr.length == 0) {
            for (Constructor<?> constructor : beanClassImpl.getDeclaredConstructors()) {
                if (constructor.getParameterCount() == 0) {
                    return constructor;
                }
            }
            return null;
        }
        int len = objArr.length;
        Class<?>[] argTypes = new Class[len];
        for (int i2 = 0; i2 < len; i2++) {
            argTypes[i2] = objArr[i2].getClass();
        }
        for (Constructor<?> constructor2 : beanClassImpl.getDeclaredConstructors()) {
            Class<?>[] paramTypes = constructor2.getParameterTypes();
            int size = paramTypes.length;
            if (!constructor2.isVarArgs()) {
                if (size != len) {
                    continue;
                } else {
                    int j2 = 0;
                    while (j2 < size) {
                        if (isTypeEquals(paramTypes[j2], argTypes[j2])) {
                            j2++;
                        }
                    }
                    return constructor2;
                }
            } else if (size > len + 1) {
                continue;
            } else {
                int j3 = 0;
                while (true) {
                    if (j3 < size - 1) {
                        if (!isTypeEquals(paramTypes[j3], argTypes[j3])) {
                            break;
                        }
                        j3++;
                    } else if (len >= size) {
                        Class<?> componentType = paramTypes[size - 1].getComponentType();
                        int k = size - 1;
                        while (k < len) {
                            if (isTypeEquals(componentType, argTypes[k])) {
                                k++;
                            }
                        }
                        Object[] newArgs = new Object[size];
                        Object varArgs = Array.newInstance(componentType, (len - size) + 1);
                        newArgs[size - 1] = varArgs;
                        int varArgsIndex = 0;
                        for (int m = 0; m < len; m++) {
                            if (m < size - 1) {
                                newArgs[m] = objArr[m];
                            } else {
                                Array.set(varArgs, varArgsIndex, objArr[m]);
                                varArgsIndex++;
                            }
                        }
                        out[0] = newArgs;
                    }
                }
                return constructor2;
            }
        }
        return null;
    }

    private static boolean isTypeEquals(Class<?> left, Class<?> right) {
        if (left.isLocalClass() || right.isLocalClass()) {
            return false;
        }
        boolean leftIsArray = left.isArray();
        boolean rightIsArray = right.isArray();
        if ((leftIsArray && !rightIsArray) || (!leftIsArray && rightIsArray)) {
            return false;
        }
        if (leftIsArray) {
            return isArraySame(left, right);
        }
        boolean leftIsPrimitive = left.isPrimitive();
        boolean rightIsPrimitive = right.isPrimitive();
        if ((!leftIsPrimitive && !rightIsPrimitive) || (leftIsPrimitive && rightIsPrimitive)) {
            return left.equals(right);
        }
        if (leftIsPrimitive) {
            return isTypeBoxing(right, left);
        }
        return isTypeBoxing(left, right);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isTypeBoxing(java.lang.Class<?> r3, java.lang.Class<?> r4) {
        /*
            java.lang.String r0 = r4.getTypeName()
            int r1 = r0.hashCode()
            r2 = 0
            switch(r1) {
                case -1325958191: goto L_0x0056;
                case 104431: goto L_0x004b;
                case 3039496: goto L_0x0041;
                case 3052374: goto L_0x0037;
                case 3327612: goto L_0x002c;
                case 64711720: goto L_0x0022;
                case 97526364: goto L_0x0018;
                case 109413500: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0060
        L_0x000d:
            java.lang.String r1 = "short"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = 1
            goto L_0x0061
        L_0x0018:
            java.lang.String r1 = "float"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = 4
            goto L_0x0061
        L_0x0022:
            java.lang.String r1 = "boolean"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = 6
            goto L_0x0061
        L_0x002c:
            java.lang.String r1 = "long"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = 3
            goto L_0x0061
        L_0x0037:
            java.lang.String r1 = "char"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = 7
            goto L_0x0061
        L_0x0041:
            java.lang.String r1 = "byte"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = r2
            goto L_0x0061
        L_0x004b:
            java.lang.String r1 = "int"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = 2
            goto L_0x0061
        L_0x0056:
            java.lang.String r1 = "double"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000c
            r1 = 5
            goto L_0x0061
        L_0x0060:
            r1 = -1
        L_0x0061:
            switch(r1) {
                case 0: goto L_0x0096;
                case 1: goto L_0x008f;
                case 2: goto L_0x0088;
                case 3: goto L_0x0081;
                case 4: goto L_0x007a;
                case 5: goto L_0x0073;
                case 6: goto L_0x006c;
                case 7: goto L_0x0065;
                default: goto L_0x0064;
            }
        L_0x0064:
            return r2
        L_0x0065:
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            boolean r1 = r1.equals(r3)
            return r1
        L_0x006c:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            boolean r1 = r1.equals(r3)
            return r1
        L_0x0073:
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            boolean r1 = r1.equals(r3)
            return r1
        L_0x007a:
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            boolean r1 = r1.equals(r3)
            return r1
        L_0x0081:
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            boolean r1 = r1.equals(r3)
            return r1
        L_0x0088:
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            boolean r1 = r1.equals(r3)
            return r1
        L_0x008f:
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
            boolean r1 = r1.equals(r3)
            return r1
        L_0x0096:
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            boolean r1 = r1.equals(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tinyioc.core.support.BeanUtils.isTypeBoxing(java.lang.Class, java.lang.Class):boolean");
    }

    private static boolean isArraySame(Class<?> left, Class<?> right) {
        int leftCount = 0;
        Class<?> leftArrayClass = left;
        while (leftArrayClass.isArray()) {
            leftCount++;
            leftArrayClass = leftArrayClass.getComponentType();
        }
        int rightCount = 0;
        Class<?> rightArrayClass = right;
        while (rightArrayClass.isArray()) {
            rightCount++;
            rightArrayClass = rightArrayClass.getComponentType();
        }
        return leftCount == rightCount && isTypeEquals(leftArrayClass, rightArrayClass);
    }
}
