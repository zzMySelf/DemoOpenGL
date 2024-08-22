package com.bun.miitmdid.provider.xiaomi;

import android.content.Context;
import androidx.annotation.Keep;
import java.lang.reflect.Method;

@Keep
public class IdentifierManager {
    @Keep
    public static Class<?> sClass;
    @Keep
    public static Method sGetAAID;
    @Keep
    public static Method sGetOAID;
    @Keep
    public static Method sGetUDID;
    @Keep
    public static Method sGetVAID;
    @Keep
    public static Object sIdProivderImpl;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProivderImpl = cls.newInstance();
            sGetUDID = sClass.getMethod("getUDID", new Class[]{Context.class});
            sGetOAID = sClass.getMethod("getOAID", new Class[]{Context.class});
            sGetVAID = sClass.getMethod("getVAID", new Class[]{Context.class});
            sGetAAID = sClass.getMethod("getAAID", new Class[]{Context.class});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Keep
    public static native String getAAID(Context context);

    @Keep
    public static native String getOAID(Context context);

    @Keep
    public static native String getUDID(Context context);

    @Keep
    public static native String getVAID(Context context);

    @Keep
    public static native String invokeMethod(Context context, Method method);

    @Keep
    public static native boolean isSupported();
}
