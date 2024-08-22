package com.baidu.browser.sailor.util;

import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: BdReflectUtils */
public final class d {
    public static Object a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, Object obj2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th2) {
            Log.e("BdReflectUtils", th2.getMessage(), th2);
            return obj2;
        }
    }
}
