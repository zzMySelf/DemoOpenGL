package com.baidu.apollon.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

public class StatusBarManager {
    public a mBarParams;

    public final class a {
        public int a;
        public int b;
        public float c;
        public View d;
        public boolean e;
        public int f;

        public a() {
            this.a = 0;
            this.b = -16777216;
            this.c = 0.0f;
            this.e = false;
        }
    }

    public StatusBarManager() {
        buildParams();
    }

    private void setupStatusBarView(Activity activity) {
        a aVar = this.mBarParams;
        if (aVar.d == null) {
            aVar.d = new View(activity);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(activity));
        layoutParams.gravity = 48;
        this.mBarParams.d.setLayoutParams(layoutParams);
        a aVar2 = this.mBarParams;
        aVar2.d.setBackgroundColor(StatusBarUtils.blendARGB(aVar2.a, aVar2.b, aVar2.c));
        this.mBarParams.d.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) this.mBarParams.d.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mBarParams.d);
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.mBarParams.d);
    }

    public void apply(Activity activity) {
        if (activity != null) {
            int i2 = Build.VERSION.SDK_INT;
            int i3 = 9472;
            if (i2 >= 27) {
                activity.getWindow().clearFlags(67108864);
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                if (!this.mBarParams.e) {
                    i3 = 1280;
                }
                Window window = activity.getWindow();
                a aVar = this.mBarParams;
                window.setStatusBarColor(StatusBarUtils.blendARGB(aVar.a, aVar.b, aVar.c));
                activity.getWindow().getDecorView().setSystemUiVisibility(i3);
            } else if (i2 >= 19) {
                int i4 = 256;
                if (i2 < 21 || ImmersiveOSUtils.isEMUI3_1()) {
                    activity.getWindow().addFlags(67108864);
                    setupStatusBarView(activity);
                } else {
                    activity.getWindow().clearFlags(67108864);
                    activity.getWindow().addFlags(Integer.MIN_VALUE);
                    if (Build.VERSION.SDK_INT < 23 || !this.mBarParams.e) {
                        i3 = 1280;
                    }
                    Window window2 = activity.getWindow();
                    a aVar2 = this.mBarParams;
                    window2.setStatusBarColor(StatusBarUtils.blendARGB(aVar2.a, aVar2.b, aVar2.c));
                    i4 = i3;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(i4);
                if (ImmersiveOSUtils.isMIUI6Plus()) {
                    StatusBarUtils.setMIUIStatusBarDarkFont(activity.getWindow(), this.mBarParams.e);
                }
                if (ImmersiveOSUtils.isFlymeOS4Plus()) {
                    a aVar3 = this.mBarParams;
                    int i5 = aVar3.f;
                    if (i5 != 0) {
                        FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, i5);
                    } else if (Build.VERSION.SDK_INT < 23) {
                        FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, aVar3.e);
                    }
                }
            }
        }
    }

    public void buildParams() {
        this.mBarParams = new a();
    }

    public void release() {
        this.mBarParams = null;
    }

    public void setFlymeStatusBarFontColor(Context context, int i2) {
        this.mBarParams.f = context.getResources().getColor(i2);
    }

    public void setTitleAlpha(View view, int i2, float f) {
        if (view != null) {
            view.setBackgroundColor(StatusBarUtils.blendARGB(0, view.getContext().getResources().getColor(i2), f));
        }
    }

    public void statusBarAlpha(float f) {
        this.mBarParams.c = f;
    }

    public void statusBarColor(Context context, int i2) {
        statusBarColorInt(context.getResources().getColor(i2));
    }

    public void statusBarColorInt(int i2) {
        this.mBarParams.a = i2;
    }

    public void statusBarDarkFont(boolean z, float f) {
        if (!z) {
            this.mBarParams.f = 0;
        }
        if (!ImmersiveOSUtils.isSupportStatusBarDarkFont()) {
            this.mBarParams.c = f;
        } else if (!ImmersiveOSUtils.isSpecialOS() || !z) {
            a aVar = this.mBarParams;
            aVar.e = z;
            aVar.c = 0.0f;
        } else {
            a aVar2 = this.mBarParams;
            aVar2.c = f;
            aVar2.e = false;
        }
    }
}
