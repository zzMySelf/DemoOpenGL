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
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewUtility implements NoProguard {

    class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f18352a;

        a(float f2) {
            this.f18352a = f2;
        }

        public boolean onTouch(View view2, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action != 1 && action != 3) || Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                view2.setAlpha(1.0f);
                return false;
            } else if (Build.VERSION.SDK_INT < 11) {
                return false;
            } else {
                view2.setAlpha(this.f18352a);
                return false;
            }
        }
    }

    private static boolean a(Activity activity, boolean z) {
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
        } catch (Throwable th2) {
            return false;
        }
    }

    private static boolean b(Activity activity, boolean z) {
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
        } catch (Throwable th2) {
            return false;
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        } else if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028 A[Catch:{ Exception -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033 A[Catch:{ Exception -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e A[Catch:{ Exception -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void enableStatusBarTint(android.app.Activity r3, int r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x0007
            return
        L_0x0007:
            com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ Exception -> 0x006c }
            com.baidu.sapi2.SapiConfiguration r0 = r0.getConfignation()     // Catch:{ Exception -> 0x006c }
            boolean r0 = r0.isNightMode     // Catch:{ Exception -> 0x006c }
            boolean r1 = com.baidu.sapi2.utils.DarkModeUtil.isDarkMode(r3)     // Catch:{ Exception -> 0x006c }
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
            if (r0 == 0) goto L_0x0039
            r2 = -1
            if (r2 != r4) goto L_0x0039
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x006c }
            if (r4 >= r1) goto L_0x0033
            android.content.res.Resources r4 = r3.getResources()     // Catch:{ Exception -> 0x006c }
            int r2 = com.baidu.passport.sapi2.R.color.sapi_sdk_dark_mode_title_color     // Catch:{ Exception -> 0x006c }
            int r4 = r4.getColor(r2)     // Catch:{ Exception -> 0x006c }
            goto L_0x0039
        L_0x0033:
            int r4 = com.baidu.passport.sapi2.R.color.sapi_sdk_dark_mode_title_color     // Catch:{ Exception -> 0x006c }
            int r4 = r3.getColor(r4)     // Catch:{ Exception -> 0x006c }
        L_0x0039:
            android.view.Window r3 = r3.getWindow()     // Catch:{ Exception -> 0x006c }
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlags(r2)     // Catch:{ Exception -> 0x006c }
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r3.clearFlags(r2)     // Catch:{ Exception -> 0x006c }
            r3.setStatusBarColor(r4)     // Catch:{ Exception -> 0x006c }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x006c }
            if (r4 < r1) goto L_0x0070
            if (r0 != 0) goto L_0x005a
            android.view.View r3 = r3.getDecorView()     // Catch:{ Exception -> 0x006c }
            r4 = 9216(0x2400, float:1.2914E-41)
            r3.setSystemUiVisibility(r4)     // Catch:{ Exception -> 0x006c }
            goto L_0x0070
        L_0x005a:
            android.view.View r4 = r3.getDecorView()     // Catch:{ Exception -> 0x006c }
            int r4 = r4.getSystemUiVisibility()     // Catch:{ Exception -> 0x006c }
            r4 = r4 & -8193(0xffffffffffffdfff, float:NaN)
            android.view.View r3 = r3.getDecorView()     // Catch:{ Exception -> 0x006c }
            r3.setSystemUiVisibility(r4)     // Catch:{ Exception -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r3 = move-exception
            com.baidu.sapi2.utils.Log.e(r3)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.ViewUtility.enableStatusBarTint(android.app.Activity, int):void");
    }

    public static void enlargedOtherView(View view2, int i2) {
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = (int) (((float) (layoutParams.width * i2)) / 100.0f);
            layoutParams.height = (int) (((float) (layoutParams.height * i2)) / 100.0f);
            view2.setLayoutParams(layoutParams);
        }
    }

    public static void enlargedTextView(TextView textView, int i2) {
        if (textView != null) {
            textView.setTextSize(0, (textView.getTextSize() * ((float) i2)) / 100.0f);
        }
    }

    public static void enlargedViews(View view2, int i2) {
        if (view2 != null) {
            if (view2 instanceof Button) {
                enlargedTextView((TextView) view2, i2);
            } else if (view2 instanceof TextView) {
                enlargedTextView((TextView) view2, i2);
            } else {
                enlargedOtherView(view2, i2);
            }
        }
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", ResUtils.DIMEN, "android");
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

    public static void setOnClickListener(View view2, View.OnClickListener onClickListener) {
        if (view2 != null && onClickListener != null) {
            view2.setOnClickListener(onClickListener);
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

    public static void setViewClickAlpha(View view2, float f2) {
        if (view2 != null) {
            view2.setOnTouchListener(new a(f2));
        }
    }
}
