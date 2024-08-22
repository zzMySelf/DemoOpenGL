package com.baidu.sofire.b;

import com.baidu.sofire.a.a;
import dalvik.system.DexClassLoader;

public class i extends DexClassLoader {
    public i(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    public Class<?> a(String str) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (Throwable unused) {
            int i2 = a.a;
            return findLoadedClass;
        }
    }

    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
            } catch (Throwable unused) {
            }
            if (findLoadedClass == null) {
                try {
                    if (getParent() != null) {
                        findLoadedClass = getParent().loadClass(str);
                    } else {
                        findLoadedClass = (Class) getClass().getDeclaredMethod("findBootstrapClassOrNull", new Class[]{String.class}).invoke(this, new Object[]{str});
                    }
                } catch (Throwable unused2) {
                    int i2 = a.a;
                }
            }
        }
        if (z) {
            resolveClass(findLoadedClass);
        }
        if (findLoadedClass == null) {
            try {
                return super.loadClass(str, z);
            } catch (Throwable unused3) {
                int i3 = a.a;
            }
        }
        return findLoadedClass;
    }
}
