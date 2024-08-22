package com.alipay.sdk.m.j0;

import android.content.Context;
import java.lang.reflect.Method;

public class b {
    public static final String a = "IdentifierManager";
    public static Object b;
    public static Class<?> c;
    public static Method d;
    public static Method e;
    public static Method f;
    public static Method g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            b = cls.newInstance();
            d = c.getMethod("getUDID", new Class[]{Context.class});
            e = c.getMethod("getOAID", new Class[]{Context.class});
            f = c.getMethod("getVAID", new Class[]{Context.class});
            g = c.getMethod("getAAID", new Class[]{Context.class});
        } catch (Exception unused) {
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, e);
    }

    public static String c(Context context) {
        return a(context, d);
    }

    public static String d(Context context) {
        return a(context, f);
    }

    public static String a(Context context) {
        return a(context, g);
    }

    public static String a(Context context, Method method) {
        Object obj = b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, new Object[]{context});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
