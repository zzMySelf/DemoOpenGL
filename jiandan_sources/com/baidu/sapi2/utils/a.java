package com.baidu.sapi2.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.apollon.utils.ResUtils;

public final class a {
    public Activity a;
    public View b;
    public int c;
    public FrameLayout.LayoutParams d = ((FrameLayout.LayoutParams) this.b.getLayoutParams());

    /* renamed from: com.baidu.sapi2.utils.a$a  reason: collision with other inner class name */
    public class C0039a implements ViewTreeObserver.OnGlobalLayoutListener {
        public C0039a() {
        }

        public void onGlobalLayout() {
            a.this.b();
        }
    }

    public a(Activity activity) {
        this.a = activity;
        View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.b = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new C0039a());
    }

    /* access modifiers changed from: private */
    public void b() {
        int a2 = a();
        if (a2 != this.c) {
            int height = this.b.getRootView().getHeight();
            int i2 = height - a2;
            if (i2 > height / 4) {
                this.d.height = height - i2;
            } else {
                this.d.height = a2;
            }
            this.b.requestLayout();
            this.c = a2;
        }
    }

    public static void a(Activity activity) {
        new a(activity);
    }

    private int a() {
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        Resources resources = this.a.getResources();
        int identifier = resources.getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
        if (identifier <= 0) {
            return rect.bottom - rect.top;
        }
        return (rect.bottom - rect.top) + resources.getDimensionPixelSize(identifier);
    }
}
