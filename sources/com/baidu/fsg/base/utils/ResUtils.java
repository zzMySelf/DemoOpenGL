package com.baidu.fsg.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.searchbox.hissug.ubc.UbcUserActionKt;
import java.io.InputStream;
import kotlin.UByte;

public final class ResUtils {
    public static final String ANIM = "anim";

    /* renamed from: a  reason: collision with root package name */
    private static final String f11820a = "id";

    /* renamed from: b  reason: collision with root package name */
    private static final String f11821b = "string";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11822c = "layout";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11823d = "style";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11824e = "drawable";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11825f = "color";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11826g = "array";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11827h = "attr";

    /* renamed from: i  reason: collision with root package name */
    private static final String f11828i = "dimen";

    /* renamed from: j  reason: collision with root package name */
    private static final String f11829j = "xml";
    private static final String k = "integer";
    private static final String l = "raw";
    private static Context m = null;

    private ResUtils() {
    }

    private static int a(Context context, String str, String str2) {
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
                Log.d(com.baidu.searchbox.qrcode.utils.ResUtils.TAG, "context instance is " + context);
                Log.d(com.baidu.searchbox.qrcode.utils.ResUtils.TAG, "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context);
            }
            return resources.getIdentifier(str2, str, packageName);
        }
    }

    private static int a(Context context, String str, String str2, String str3) {
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
                Log.d(com.baidu.searchbox.qrcode.utils.ResUtils.TAG, "context instance is " + context);
                Log.d(com.baidu.searchbox.qrcode.utils.ResUtils.TAG, "packake name is " + str + " attrName is " + str3 + ", context instance is " + context);
            }
            return resources.getIdentifier(str3, str2, str);
        }
    }

    private static String a(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
            if (z && i2 != bArr.length - 1) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    private static byte[] a(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = "concreteGetSign context 为空";
        } else {
            Log.i(UbcUserActionKt.CLICK_FEEDBACK, "name =" + str);
            if (TextUtils.isEmpty(str)) {
                str2 = "concreteGetSign name 为空";
            } else {
                Log.i(UbcUserActionKt.CLICK_FEEDBACK, "concreteGetSign 读取的文件内容是=" + str);
                try {
                    InputStream open = context.getAssets().open(str);
                    if (open != null) {
                        int available = open.available();
                        Log.i(UbcUserActionKt.CLICK_FEEDBACK, "concreteGetSign 读取的文件的长度是=" + available);
                        if (available > 0) {
                            byte[] bArr = new byte[available];
                            open.read(bArr);
                            open.close();
                            Log.d(UbcUserActionKt.CLICK_FEEDBACK, "concreteGetSign 读取文件的16进制: " + a(bArr, true));
                            return bArr;
                        }
                    }
                } catch (Exception e2) {
                    Log.e(UbcUserActionKt.CLICK_FEEDBACK, "concreteGetSign 读取文件发生了错误");
                    e2.printStackTrace();
                }
                return null;
            }
        }
        Log.i(UbcUserActionKt.CLICK_FEEDBACK, str2);
        return null;
    }

    public static int anim(Context context, String str) {
        return a(context, "anim", str);
    }

    public static int anim(Context context, String str, String str2) {
        return a(context, str, "anim", str2);
    }

    public static int array(Context context, String str) {
        return a(context, "array", str);
    }

    public static int attr(Context context, String str) {
        return a(context, "attr", str);
    }

    public static int color(Context context, String str) {
        return a(context, "color", str);
    }

    public static int dimen(Context context, String str) {
        return a(context, "dimen", str);
    }

    public static int drawable(Context context, String str) {
        return a(context, "drawable", str);
    }

    public static Animation getAnimation(Context context, String str) {
        return AnimationUtils.loadAnimation(context, anim(context, str));
    }

    public static Context getApplicationContext() {
        return m;
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
        return a(context, "integer", str);
    }

    public static int layout(Context context, String str) {
        return a(context, "layout", str);
    }

    public static int raw(Context context, String str) {
        return a(context, "raw", str);
    }

    public static byte[] readAssets(Context context, String str) {
        return a(context, str);
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            m = context.getApplicationContext();
        }
    }

    public static int string(Context context, String str) {
        return a(context, "string", str);
    }

    public static String string(String str) {
        try {
            Context context = m;
            return context.getString(a(context, "string", str));
        } catch (Exception e2) {
            return "";
        }
    }

    public static int style(Context context, String str) {
        return a(context, "style", str);
    }

    public static int xml(Context context, String str) {
        return a(context, f11829j, str);
    }
}
