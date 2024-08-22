package com.baidu.android.pushservice.jni;

import java.lang.reflect.Method;

public class NativeReflect {
    static {
        try {
            System.loadLibrary("bdpush_V3_8");
        } catch (Throwable th2) {
        }
    }

    public static native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);
}
