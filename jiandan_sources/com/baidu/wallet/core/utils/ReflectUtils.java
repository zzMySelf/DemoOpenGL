package com.baidu.wallet.core.utils;

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
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
