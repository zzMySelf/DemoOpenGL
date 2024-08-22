package com.dxmpay.apollon.statusbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.lang.reflect.Method;

public class StatusBarUtils {
    public static final int STATUS_BAR_DEFAULT_HEIGHT = 25;
    public static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    public static final String TAG = "StatusBarUtils";
    public static int mStatusBarHeight = 0;
    public static float sBarAlpha = 0.3f;

    public static class qw implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View f4046ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f4047th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Context f4048yj;

        public qw(View view, ViewGroup.LayoutParams layoutParams, Context context) {
            this.f4046ad = view;
            this.f4047th = layoutParams;
            this.f4048yj = context;
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 19) {
                this.f4046ad.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.f4047th.height = this.f4046ad.getHeight() + StatusBarUtils.getStatusBarHeight(this.f4048yj);
                View view = this.f4046ad;
                view.setPadding(view.getPaddingLeft(), this.f4046ad.getPaddingTop() + StatusBarUtils.getStatusBarHeight(this.f4048yj), this.f4046ad.getPaddingRight(), this.f4046ad.getPaddingBottom());
                this.f4046ad.setLayoutParams(this.f4047th);
            }
        }
    }

    public static int blendARGB(int i2, int i3, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f2) + (((float) Color.alpha(i3)) * f)), (int) ((((float) Color.red(i2)) * f2) + (((float) Color.red(i3)) * f)), (int) ((((float) Color.green(i2)) * f2) + (((float) Color.green(i3)) * f)), (int) ((((float) Color.blue(i2)) * f2) + (((float) Color.blue(i3)) * f)));
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getInternalDimensionSize(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize > 0 ? dimensionPixelSize : dip2px(context, 25.0f);
    }

    public static int getStatusBarHeight(Context context) {
        if (mStatusBarHeight == 0) {
            mStatusBarHeight = getInternalDimensionSize(context);
        }
        return mStatusBarHeight;
    }

    public static void setMIUIStatusBarDarkFont(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (z) {
                    method.invoke(window, new Object[]{Integer.valueOf(i2), Integer.valueOf(i2)});
                    return;
                }
                method.invoke(window, new Object[]{0, Integer.valueOf(i2)});
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
        }
    }

    public static void setTitleBar(Context context, View view) {
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i2 = layoutParams.height;
            if (i2 == -2 || i2 == -1) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new qw(view, layoutParams, context));
                return;
            }
            layoutParams.height = i2 + getStatusBarHeight(context);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
            view.setLayoutParams(layoutParams);
        }
    }
}
