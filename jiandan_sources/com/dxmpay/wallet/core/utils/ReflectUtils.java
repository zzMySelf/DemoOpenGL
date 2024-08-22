package com.dxmpay.wallet.core.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectUtils {
    public static Object getProviderObject(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls == null) {
                return null;
            }
            Constructor<?> constructor = cls.getConstructor(new Class[0]);
            Object newInstance = cls.newInstance();
            newInstance.getClass();
            if (constructor != null) {
                return constructor.newInstance(new Object[0]);
            }
            return newInstance;
        } catch (ClassNotFoundException e) {
            LogUtil.e("ReflectUtils", e.getMessage(), e);
            return null;
        } catch (NoSuchMethodException e2) {
            LogUtil.e("ReflectUtils", e2.getMessage(), e2);
            return null;
        } catch (IllegalAccessException e3) {
            LogUtil.e("ReflectUtils", e3.getMessage(), e3);
            return null;
        } catch (InstantiationException e4) {
            LogUtil.e("ReflectUtils", e4.getMessage(), e4);
            return null;
        } catch (InvocationTargetException e5) {
            LogUtil.e("ReflectUtils", e5.getMessage(), e5);
            return null;
        }
    }
}
