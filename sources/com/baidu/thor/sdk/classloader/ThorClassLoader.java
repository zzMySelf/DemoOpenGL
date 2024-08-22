package com.baidu.thor.sdk.classloader;

import dalvik.system.BaseDexClassLoader;
import java.io.File;

public class ThorClassLoader extends BaseDexClassLoader {
    private ClassLoader mHostClassLoader;

    public ThorClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, new File(str2), str3, (ClassLoader) null);
        this.mHostClassLoader = classLoader;
    }

    public Class<?> findOwnClass(String str) {
        Class<?> findLoadedClass = findLoadedClass(str);
        return findLoadedClass != null ? findLoadedClass : super.findClass(str);
    }

    public Class<?> loadClass(String str, boolean z) {
        Class<?> cls;
        try {
            cls = findOwnClass(str);
        } catch (ClassNotFoundException e2) {
            cls = null;
        }
        return cls != null ? cls : this.mHostClassLoader.loadClass(str);
    }
}
