package com.baidu.apollon.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WalletToast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    public static final int h = 3500;

    /* renamed from: i  reason: collision with root package name */
    public static final int f694i = 2000;
    public static List<View> j = new ArrayList();
    public static CancleRunnable k;
    public Context a;
    public int b;
    public int c;
    public int d;
    public int e;
    public float f;
    public float g;
    public WindowManager l;
    public View m;
    public WindowManager.LayoutParams n;

    /* renamed from: o  reason: collision with root package name */
    public Handler f695o = new Handler(Looper.getMainLooper());

    public class CancleRunnable implements Runnable {
        public volatile boolean a = false;

        public CancleRunnable() {
        }

        public void discard() {
            this.a = true;
        }

        public void run() {
            if (!this.a) {
                WalletToast.this.a();
            }
        }
    }

    public WalletToast(Context context) {
        this.l = (WindowManager) context.getSystemService("window");
        this.a = context;
        Toast toast = new Toast(context);
        this.e = toast.getYOffset();
        a(toast);
    }

    public int getDuration() {
        return this.b;
    }

    public int getGravity() {
        return this.c;
    }

    public float getHorizontalMargin() {
        return this.g;
    }

    public float getVerticalMargin() {
        return this.f;
    }

    public View getView() {
        return this.m;
    }

    public int getXOffset() {
        return this.d;
    }

    public int getYOffset() {
        return this.e;
    }

    public void setDuration(int i2) {
        this.b = i2;
    }

    public void setGravity(int i2, int i3, int i4) {
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public void setMargin(float f2, float f3) {
        this.g = f2;
        this.f = f3;
    }

    public void setView(View view) {
        this.m = view;
    }

    public void show() {
        this.f695o.post(new Runnable() {
            public void run() {
                WalletToast.this.a();
                WalletToast walletToast = WalletToast.this;
                walletToast.a(walletToast.m);
            }
        });
    }

    private void b(View view) {
        if (view != null && view.getParent() != null) {
            try {
                this.l.removeView(view);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(Toast toast) {
        try {
            Field declaredField = toast.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(toast);
            Field declaredField2 = obj.getClass().getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            this.n = (WindowManager.LayoutParams) declaredField2.get(obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.n = layoutParams;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.type = 2005;
            layoutParams.windowAnimations = ResUtils.style(this.a, "EbpayActivityAnim2");
            this.n.setTitle("Toast");
            this.n.flags = 152;
        }
        this.c = 17;
        this.e = 0;
        this.m = toast.getView();
    }

    @SuppressLint({"ShowToast"})
    public WalletToast(Context context, String str, int i2) {
        this.l = (WindowManager) context.getSystemService("window");
        this.a = context;
        Toast makeText = Toast.makeText(context, str, i2);
        this.e = makeText.getYOffset();
        a(makeText);
    }

    /* access modifiers changed from: private */
    public void a() {
        CancleRunnable cancleRunnable = k;
        if (cancleRunnable != null) {
            cancleRunnable.discard();
            this.f695o.removeCallbacks(k);
            k = null;
        }
        for (View b2 : j) {
            b(b2);
        }
        j.clear();
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(this.a);
        if (applicationContext == null) {
            applicationContext = this.a;
        }
        this.l = (WindowManager) applicationContext.getSystemService("window");
        int i2 = this.c;
        WindowManager.LayoutParams layoutParams = this.n;
        layoutParams.gravity = i2;
        if ((i2 & 7) == 7) {
            layoutParams.horizontalWeight = 1.0f;
        }
        if ((i2 & 112) == 112) {
            this.n.verticalWeight = 1.0f;
        }
        WindowManager.LayoutParams layoutParams2 = this.n;
        layoutParams2.x = this.d;
        layoutParams2.y = this.e;
        layoutParams2.verticalMargin = this.f;
        layoutParams2.horizontalMargin = this.g;
        try {
            if (view.getParent() != null) {
                this.l.updateViewLayout(view, this.n);
            } else {
                this.l.addView(view, this.n);
            }
            j.add(view);
            CancleRunnable cancleRunnable = new CancleRunnable();
            k = cancleRunnable;
            this.f695o.postDelayed(cancleRunnable, this.b == 1 ? 3500 : ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
        } catch (Exception unused) {
        }
    }
}
