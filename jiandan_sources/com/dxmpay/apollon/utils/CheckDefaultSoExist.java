package com.dxmpay.apollon.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.idl.license.License;
import java.lang.reflect.Method;

public class CheckDefaultSoExist {
    public static final String[] FACE_SO_NAME_ARRAY = {License.LICENSE_ASSETS_FILE, "FaceSDK"};

    public static String ad(Context context, String str) {
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader == null) {
            return null;
        }
        try {
            Method declaredMethod = classLoader.getClass().getDeclaredMethod("findLibrary", new Class[]{String.class});
            if (declaredMethod == null) {
                return null;
            }
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            Object invoke = declaredMethod.invoke(classLoader, new Object[]{str});
            if (invoke != null) {
                if (invoke instanceof String) {
                    return (String) invoke;
                }
            }
            return null;
        } catch (Exception e) {
            LogUtil.errord("findLibrary2", e.toString());
            return "catch Exception";
        }
    }

    public static boolean isExist(Context context, String[] strArr) {
        String str;
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str2 : strArr) {
            if (Build.VERSION.SDK_INT > 8) {
                str = qw(context, str2);
            } else {
                str = ad(context, str2);
            }
            if (TextUtils.isEmpty(str)) {
                LogUtil.errord("CheckDefaultSoExist", str2 + " so is not exist ,please put the " + str2 + " so file in the right folder");
                return false;
            }
        }
        return true;
    }

    public static String qw(Context context, String str) {
        Object invoke;
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader == null) {
            return null;
        }
        try {
            Method method = classLoader.getClass().getMethod("findLibrary", new Class[]{String.class});
            if (!(method == null || (invoke = method.invoke(classLoader, new Object[]{str})) == null)) {
                if (invoke instanceof String) {
                    return (String) invoke;
                }
            }
            return null;
        } catch (Exception e) {
            LogUtil.errord("findLibrary1", e.toString());
            return "catch Exception";
        }
    }
}
