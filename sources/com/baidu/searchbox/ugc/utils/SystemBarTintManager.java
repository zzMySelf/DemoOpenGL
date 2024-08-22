package com.baidu.searchbox.ugc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import java.lang.reflect.Method;

public class SystemBarTintManager {
    public static final int DEFAULT_TINT_COLOR = -1728053248;
    /* access modifiers changed from: private */
    public static String sNavBarOverride;
    private final SystemBarConfig mConfig;
    private boolean mNavBarAvailable;
    private boolean mNavBarTintEnabled;
    private View mNavBarTintView;
    private boolean mStatusBarAvailable;
    private boolean mStatusBarTintEnabled;
    private View mStatusBarTintView;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method m = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                m.setAccessible(true);
                sNavBarOverride = (String) m.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable th2) {
                sNavBarOverride = null;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public SystemBarTintManager(Activity activity) {
        Window win = activity.getWindow();
        ViewGroup decorViewGroup = (ViewGroup) win.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray a2 = activity.obtainStyledAttributes(new int[]{com.baidu.searchbox.ui.SystemBarTintManager.windowTranslucentStatus, com.baidu.searchbox.ui.SystemBarTintManager.windowTranslucentNavigation});
            try {
                this.mStatusBarAvailable = a2.getBoolean(0, false);
                this.mNavBarAvailable = a2.getBoolean(1, false);
                a2.recycle();
                WindowManager.LayoutParams winParams = win.getAttributes();
                if ((winParams.flags & 67108864) != 0) {
                    this.mStatusBarAvailable = true;
                }
                if ((winParams.flags & com.baidu.searchbox.ui.SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0) {
                    this.mNavBarAvailable = true;
                }
            } catch (Throwable th2) {
                a2.recycle();
                throw th2;
            }
        }
        SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.mStatusBarAvailable, this.mNavBarAvailable);
        this.mConfig = systemBarConfig;
        if (!systemBarConfig.hasNavigtionBar()) {
            this.mNavBarAvailable = false;
        }
        if (this.mStatusBarAvailable) {
            setupStatusBarView(activity, decorViewGroup);
        }
        if (this.mNavBarAvailable) {
            setupNavBarView(activity, decorViewGroup);
        }
    }

    public void setStatusBarTintEnabled(boolean enabled) {
        View view2;
        this.mStatusBarTintEnabled = enabled;
        if (this.mStatusBarAvailable && (view2 = this.mStatusBarTintView) != null) {
            view2.setVisibility(enabled ? 0 : 8);
        }
    }

    public void setNavigationBarTintEnabled(boolean enabled) {
        View view2;
        this.mNavBarTintEnabled = enabled;
        if (this.mNavBarAvailable && (view2 = this.mNavBarTintView) != null) {
            view2.setVisibility(enabled ? 0 : 8);
        }
    }

    public void setTintColor(int color) {
        setStatusBarTintColor(color);
        setNavigationBarTintColor(color);
    }

    public void setTintResource(int res) {
        setStatusBarTintResource(res);
        setNavigationBarTintResource(res);
    }

    public void setTintDrawable(Drawable drawable) {
        setStatusBarTintDrawable(drawable);
        setNavigationBarTintDrawable(drawable);
    }

    public void setTintAlpha(float alpha) {
        setStatusBarAlpha(alpha);
        setNavigationBarAlpha(alpha);
    }

    public void setStatusBarTintColor(int color) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundColor(color);
        }
    }

    public void setStatusBarTintResource(int res) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundResource(res);
        }
    }

    public void setStatusBarTintDrawable(Drawable drawable) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundDrawable(drawable);
        }
    }

    public void setStatusBarAlpha(float alpha) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setAlpha(alpha);
        }
    }

    public void setNavigationBarTintColor(int color) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundColor(color);
        }
    }

    public void setNavigationBarTintResource(int res) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundResource(res);
        }
    }

    public void setNavigationBarTintDrawable(Drawable drawable) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setBackgroundDrawable(drawable);
        }
    }

    public void setNavigationBarAlpha(float alpha) {
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setAlpha(alpha);
        }
    }

    public SystemBarConfig getConfig() {
        return this.mConfig;
    }

    public boolean isStatusBarTintEnabled() {
        return this.mStatusBarTintEnabled;
    }

    public boolean isNavBarTintEnabled() {
        return this.mNavBarTintEnabled;
    }

    private void setupStatusBarView(Context context, ViewGroup decorViewGroup) {
        this.mStatusBarTintView = new View(context);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, this.mConfig.getStatusBarHeight());
        params.gravity = 48;
        if (this.mNavBarAvailable && !this.mConfig.isNavigationAtBottom()) {
            params.rightMargin = this.mConfig.getNavigationBarWidth();
        }
        this.mStatusBarTintView.setLayoutParams(params);
        this.mStatusBarTintView.setBackgroundColor(-1728053248);
        this.mStatusBarTintView.setVisibility(8);
        decorViewGroup.addView(this.mStatusBarTintView);
    }

    private void setupNavBarView(Context context, ViewGroup decorViewGroup) {
        FrameLayout.LayoutParams params;
        this.mNavBarTintView = new View(context);
        if (this.mConfig.isNavigationAtBottom()) {
            params = new FrameLayout.LayoutParams(-1, this.mConfig.getNavigationBarHeight());
            params.gravity = 80;
        } else {
            params = new FrameLayout.LayoutParams(this.mConfig.getNavigationBarWidth(), -1);
            params.gravity = 5;
        }
        this.mNavBarTintView.setLayoutParams(params);
        this.mNavBarTintView.setBackgroundColor(-1728053248);
        this.mNavBarTintView.setVisibility(8);
        decorViewGroup.addView(this.mNavBarTintView);
    }

    public static class SystemBarConfig {
        private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
        private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
        private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
        private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
        private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
        private final int mActionBarHeight;
        private final boolean mHasNavigationBar;
        private final boolean mInPortrait;
        private final int mNavigationBarHeight;
        private final int mNavigationBarWidth;
        private final float mSmallestWidthDp;
        private final int mStatusBarHeight;
        private final boolean mTranslucentNavBar;
        private final boolean mTranslucentStatusBar;

        private SystemBarConfig(Activity activity, boolean translucentStatusBar, boolean traslucentNavBar) {
            Resources res = activity.getResources();
            boolean z = false;
            this.mInPortrait = res.getConfiguration().orientation == 1;
            this.mSmallestWidthDp = getSmallestWidthDp(activity);
            this.mStatusBarHeight = getInternalDimensionSize(res, STATUS_BAR_HEIGHT_RES_NAME);
            this.mActionBarHeight = getActionBarHeight(activity);
            int navigationBarHeight = getNavigationBarHeight(activity);
            this.mNavigationBarHeight = navigationBarHeight;
            this.mNavigationBarWidth = getNavigationBarWidth(activity);
            this.mHasNavigationBar = navigationBarHeight > 0 ? true : z;
            this.mTranslucentStatusBar = translucentStatusBar;
            this.mTranslucentNavBar = traslucentNavBar;
        }

        private int getActionBarHeight(Context context) {
            TypedValue tv = new TypedValue();
            context.getTheme().resolveAttribute(16843499, tv, true);
            return TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }

        public int getActionBarHeight() {
            return this.mActionBarHeight;
        }

        private int getNavigationBarHeight(Context context) {
            String key;
            Resources res = context.getResources();
            if (!hasNavBar(context)) {
                return 0;
            }
            if (this.mInPortrait) {
                key = "navigation_bar_height";
            } else {
                key = "navigation_bar_height_landscape";
            }
            return getInternalDimensionSize(res, key);
        }

        public int getNavigationBarHeight() {
            return this.mNavigationBarHeight;
        }

        private int getNavigationBarWidth(Context context) {
            Resources res = context.getResources();
            if (hasNavBar(context)) {
                return getInternalDimensionSize(res, NAV_BAR_WIDTH_RES_NAME);
            }
            return 0;
        }

        public int getNavigationBarWidth() {
            return this.mNavigationBarWidth;
        }

        private boolean hasNavBar(Context context) {
            Resources res = context.getResources();
            int resourceId = res.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
            if (resourceId == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean hasNav = res.getBoolean(resourceId);
            if ("1".equals(SystemBarTintManager.sNavBarOverride)) {
                return false;
            }
            if ("0".equals(SystemBarTintManager.sNavBarOverride)) {
                return true;
            }
            return hasNav;
        }

        private int getInternalDimensionSize(Resources res, String key) {
            int resourceId = res.getIdentifier(key, ResUtils.DIMEN, "android");
            if (resourceId > 0) {
                return res.getDimensionPixelSize(resourceId);
            }
            return 0;
        }

        private float getSmallestWidthDp(Activity activity) {
            DisplayMetrics metrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            }
            return Math.min(((float) metrics.widthPixels) / metrics.density, ((float) metrics.heightPixels) / metrics.density);
        }

        public boolean isNavigationAtBottom() {
            return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.mHasNavigationBar;
        }

        public int getPixelInsetTop(boolean withActionBar) {
            int i2 = 0;
            int i3 = this.mTranslucentStatusBar ? this.mStatusBarHeight : 0;
            if (withActionBar) {
                i2 = this.mActionBarHeight;
            }
            return i3 + i2;
        }

        public int getPixelInsetBottom() {
            if (!this.mTranslucentNavBar || !isNavigationAtBottom()) {
                return 0;
            }
            return this.mNavigationBarHeight;
        }

        public int getPixelInsetRight() {
            if (!this.mTranslucentNavBar || isNavigationAtBottom()) {
                return 0;
            }
            return this.mNavigationBarWidth;
        }
    }
}
