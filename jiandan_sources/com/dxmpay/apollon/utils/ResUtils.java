package com.dxmpay.apollon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class ResUtils {
    public static final String ANIM = "anim";

    public static int ad(Context context, String str, String str2, String str3) {
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
            LogUtil.d("ResUtils", "context instance is " + context);
            LogUtil.d("ResUtils", "packake name is " + str + " attrName is " + str3 + ", context instance is " + context);
            return resources.getIdentifier(str3, str2, str);
        }
    }

    public static int anim(Context context, String str) {
        return qw(context, "anim", str);
    }

    public static int array(Context context, String str) {
        return qw(context, "array", str);
    }

    public static int attr(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.h, str);
    }

    public static int color(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.f, str);
    }

    public static int dimen(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.f719i, str);
    }

    public static int drawable(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.e, str);
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
            } catch (Exception e) {
                LogUtil.e("ResUtils", e.getMessage(), e);
            }
        }
        return "";
    }

    public static String[] getStringArray(Context context, String str) {
        return context.getResources().getStringArray(array(context, str));
    }

    public static int id(Context context, String str) {
        return qw(context, "id", str);
    }

    public static int integer(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.k, str);
    }

    public static int layout(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.c, str);
    }

    public static int qw(Context context, String str, String str2) {
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
            LogUtil.d("ResUtils", "context instance is " + context);
            LogUtil.d("ResUtils", "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context);
            return resources.getIdentifier(str2, str, packageName);
        }
    }

    public static int raw(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.l, str);
    }

    public static int string(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.b, str);
    }

    public static int style(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.d, str);
    }

    public static int xml(Context context, String str) {
        return qw(context, com.baidu.apollon.utils.ResUtils.j, str);
    }

    public static int anim(Context context, String str, String str2) {
        return ad(context, str, "anim", str2);
    }
}
