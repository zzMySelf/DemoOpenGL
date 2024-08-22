package com.dxmpay.apollon.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FlymeStatusBarFontUtils {
    public static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 0;
    public static final String TAG = "FlymeStatusBarFontUtils";
    public static Method mSetStatusBarColorIcon;
    public static Method mSetStatusBarDarkIcon;
    public static Field mStatusBarColorFiled;

    static {
        Class<Activity> cls = Activity.class;
        try {
            mSetStatusBarColorIcon = cls.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException unused) {
        }
        Class<Activity> cls2 = Activity.class;
        try {
            mSetStatusBarDarkIcon = cls2.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("mStatusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt((Object) null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(layoutParams);
            int i4 = z ? i2 | i3 : (~i2) & i3;
            if (i3 == i4) {
                return false;
            }
            declaredField2.setInt(layoutParams, i4);
            return true;
        } catch (NoSuchFieldException e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return false;
        } catch (IllegalAccessException e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            return false;
        } catch (IllegalArgumentException e3) {
            LogUtil.e(TAG, e3.getMessage(), e3);
            return false;
        } catch (Throwable th2) {
            LogUtil.e(TAG, th2.getMessage(), th2);
            return false;
        }
    }

    public static boolean isBlackColor(int i2, int i3) {
        return toGrey(i2) < i3;
    }

    public static void setStatusBarColor(Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i2) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i2));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i2) {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Integer.valueOf(i2)});
            } catch (IllegalAccessException e) {
                LogUtil.e(TAG, e.getMessage(), e);
            } catch (InvocationTargetException e2) {
                LogUtil.e(TAG, e2.getMessage(), e2);
            }
        } else {
            boolean isBlackColor = isBlackColor(i2, 50);
            if (mStatusBarColorFiled != null) {
                setStatusBarDarkIcon(activity, isBlackColor, isBlackColor);
                setStatusBarDarkIcon(activity.getWindow(), i2);
                return;
            }
            setStatusBarDarkIcon(activity, isBlackColor);
        }
    }

    public static int toGrey(int i2) {
        return (((((i2 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16) * 38) + (((65280 & i2) >> 8) * 75)) + ((i2 & 255) * 15)) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i2) {
        try {
            setStatusBarColor(window, i2);
            if (Build.VERSION.SDK_INT > 22) {
                setStatusBarDarkIcon(window.getDecorView(), true);
            }
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage(), e);
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z) {
        setStatusBarDarkIcon(activity, z, true);
    }

    public static void setStatusBarDarkIcon(View view, boolean z) {
        int i2;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i2 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i2 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            changeMeizuFlag(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z);
            setStatusBarColor(window, 0);
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z, boolean z2) {
        Method method = mSetStatusBarDarkIcon;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                LogUtil.e(TAG, e.getMessage(), e);
            } catch (InvocationTargetException e2) {
                LogUtil.e(TAG, e2.getMessage(), e2);
            }
        } else if (z2) {
            setStatusBarDarkIcon(activity.getWindow(), z);
        }
    }
}
