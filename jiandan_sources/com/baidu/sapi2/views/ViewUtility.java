package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewUtility implements NoProguard {

    public class a implements View.OnTouchListener {
        public final /* synthetic */ float a;

        public a(float f) {
            this.a = f;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action != 1 && action != 3) || Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                view.setAlpha(1.0f);
                return false;
            } else if (Build.VERSION.SDK_INT < 11) {
                return false;
            } else {
                view.setAlpha(this.a);
                return false;
            }
        }
    }

    public static boolean a(Activity activity, boolean z) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt((Object) null);
            int i3 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(8192);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            Window window2 = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window2, objArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        } else if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                Log.e(e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034 A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void enableStatusBarTint(android.app.Activity r3, int r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x0007
            return
        L_0x0007:
            com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ Exception -> 0x006b }
            com.baidu.sapi2.SapiConfiguration r0 = r0.getConfignation()     // Catch:{ Exception -> 0x006b }
            boolean r0 = r0.isNightMode     // Catch:{ Exception -> 0x006b }
            boolean r1 = com.baidu.sapi2.utils.DarkModeUtil.isDarkMode(r3)     // Catch:{ Exception -> 0x006b }
            if (r0 != 0) goto L_0x001c
            if (r1 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r0 = 0
            goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r1 = 23
            if (r0 == 0) goto L_0x0038
            r2 = -1
            if (r2 != r4) goto L_0x0038
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x006b }
            r2 = 2131100396(0x7f0602ec, float:1.7813172E38)
            if (r4 >= r1) goto L_0x0034
            android.content.res.Resources r4 = r3.getResources()     // Catch:{ Exception -> 0x006b }
            int r4 = r4.getColor(r2)     // Catch:{ Exception -> 0x006b }
            goto L_0x0038
        L_0x0034:
            int r4 = r3.getColor(r2)     // Catch:{ Exception -> 0x006b }
        L_0x0038:
            android.view.Window r3 = r3.getWindow()     // Catch:{ Exception -> 0x006b }
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlags(r2)     // Catch:{ Exception -> 0x006b }
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r3.clearFlags(r2)     // Catch:{ Exception -> 0x006b }
            r3.setStatusBarColor(r4)     // Catch:{ Exception -> 0x006b }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x006b }
            if (r4 < r1) goto L_0x006f
            if (r0 != 0) goto L_0x0059
            android.view.View r3 = r3.getDecorView()     // Catch:{ Exception -> 0x006b }
            r4 = 9216(0x2400, float:1.2914E-41)
            r3.setSystemUiVisibility(r4)     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x0059:
            android.view.View r4 = r3.getDecorView()     // Catch:{ Exception -> 0x006b }
            int r4 = r4.getSystemUiVisibility()     // Catch:{ Exception -> 0x006b }
            r4 = r4 & -8193(0xffffffffffffdfff, float:NaN)
            android.view.View r3 = r3.getDecorView()     // Catch:{ Exception -> 0x006b }
            r3.setSystemUiVisibility(r4)     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r3 = move-exception
            com.baidu.sapi2.utils.Log.e(r3)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.ViewUtility.enableStatusBarTint(android.app.Activity, int):void");
    }

    public static void enlargedOtherView(View view, int i2) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = (int) (((float) (layoutParams.width * i2)) / 100.0f);
            layoutParams.height = (int) (((float) (layoutParams.height * i2)) / 100.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    public static void enlargedTextView(TextView textView, int i2) {
        if (textView != null) {
            textView.setTextSize(0, (textView.getTextSize() * ((float) i2)) / 100.0f);
        }
    }

    public static void enlargedViews(View view, int i2) {
        if (view != null) {
            if (view instanceof Button) {
                enlargedTextView((TextView) view, i2);
            } else if (view instanceof TextView) {
                enlargedTextView((TextView) view, i2);
            } else {
                enlargedOtherView(view, i2);
            }
        }
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void newLoginStatusBarTint(Activity activity) {
        if (!b(activity, true)) {
            a(activity, true);
        }
        setTranslucentStatus(activity);
        setRootViewFitsSystemWindows(activity, false);
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null && onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void setOrientationToUndefined(Activity activity) {
        if (Build.VERSION.SDK_INT == 26) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
                declaredField.setAccessible(false);
            } catch (Throwable th2) {
                Log.e(th2);
            }
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup2.getChildCount() > 0 && (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) != null) {
                viewGroup.setFitsSystemWindows(z);
            }
        }
    }

    public static void setTranslucentStatus(Activity activity) {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 23) {
                if (!(SapiAccountManager.getInstance().getConfignation().isNightMode || DarkModeUtil.isDarkMode(activity))) {
                    i2 = 9472;
                    decorView.setSystemUiVisibility(i2);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                }
            }
            i2 = 1280;
            decorView.setSystemUiVisibility(i2);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (i3 >= 19) {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags |= 67108864;
            window2.setAttributes(attributes);
        }
    }

    public static void setViewClickAlpha(View view, float f) {
        if (view != null) {
            view.setOnTouchListener(new a(f));
        }
    }
}
