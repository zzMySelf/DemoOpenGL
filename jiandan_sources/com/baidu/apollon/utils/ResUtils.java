package com.baidu.apollon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.apollon.ApollonConstants;

public final class ResUtils {
    public static final String ANIM = "anim";
    public static final String a = "id";
    public static final String b = "string";
    public static final String c = "layout";
    public static final String d = "style";
    public static final String e = "drawable";
    public static final String f = "color";
    public static final String g = "array";
    public static final String h = "attr";

    /* renamed from: i  reason: collision with root package name */
    public static final String f719i = "dimen";
    public static final String j = "xml";
    public static final String k = "integer";
    public static final String l = "raw";

    public static int a(Context context, String str, String str2) {
        if (context == null) {
            throw new NullPointerException("the context is null");
        } else if (str == null || str.trim().length() == 0) {
            throw new NullPointerException("the type is null or empty");
        } else if (str2 == null || str2.trim().length() == 0) {
            throw new NullPointerException("the attrNme is null or empty");
        } else {
            Resources resources = context.getResources();
            String packageName = context.getPackageName();
            if (ChannelUtils.isSpecailPackage()) {
                packageName = "com.baidu.wallet";
            }
            if (ApollonConstants.DEBUG) {
                "context instance is " + context;
                "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context;
            }
            return resources.getIdentifier(str2, str, packageName);
        }
    }

    public static int anim(Context context, String str) {
        return a(context, "anim", str);
    }

    public static int array(Context context, String str) {
        return a(context, "array", str);
    }

    public static int attr(Context context, String str) {
        return a(context, h, str);
    }

    public static int color(Context context, String str) {
        return a(context, f, str);
    }

    public static int dimen(Context context, String str) {
        return a(context, f719i, str);
    }

    public static int drawable(Context context, String str) {
        return a(context, e, str);
    }

    public static Animation getAnimation(Context context, String str) {
        return AnimationUtils.loadAnimation(context, anim(context, str));
    }

    public static int getColor(Context context, String str) {
        LogUtil.d("aaa", "name is " + str + "+++ color id is " + color(context, str));
        return context.getResources().getColor(color(context, str));
    }

    public static float getDimension(Context context, String str) {
        return context.getResources().getDimension(dimen(context, str));
    }

    public static Drawable getDrawable(Context context, String str) {
        return context.getResources().getDrawable(drawable(context, str));
    }

    public static int getInteger(Context context, String str) {
        return context.getResources().getInteger(integer(context, str));
    }

    public static String getString(Context context, String str) {
        if (!(context == null || context.getResources() == null)) {
            try {
                return context.getResources().getString(string(context, str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static String[] getStringArray(Context context, String str) {
        return context.getResources().getStringArray(array(context, str));
    }

    public static int id(Context context, String str) {
        return a(context, "id", str);
    }

    public static int integer(Context context, String str) {
        return a(context, k, str);
    }

    public static int layout(Context context, String str) {
        return a(context, c, str);
    }

    public static int raw(Context context, String str) {
        return a(context, l, str);
    }

    public static int string(Context context, String str) {
        return a(context, b, str);
    }

    public static int style(Context context, String str) {
        return a(context, d, str);
    }

    public static int xml(Context context, String str) {
        return a(context, j, str);
    }

    public static int anim(Context context, String str, String str2) {
        return a(context, str, "anim", str2);
    }

    public static int a(Context context, String str, String str2, String str3) {
        if (context == null) {
            throw new NullPointerException("the context is null");
        } else if (str2 == null || str2.trim().length() == 0) {
            throw new NullPointerException("the type is null or empty");
        } else if (str3 == null || str3.trim().length() == 0) {
            throw new NullPointerException("the attrNme is null or empty");
        } else {
            Resources resources = context.getResources();
            if (ChannelUtils.isSpecailPackage()) {
                str = "com.baidu.wallet";
            }
            if (ApollonConstants.DEBUG) {
                "context instance is " + context;
                "packake name is " + str + " attrName is " + str3 + ", context instance is " + context;
            }
            return resources.getIdentifier(str3, str2, str);
        }
    }
}
