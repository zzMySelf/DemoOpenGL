package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* compiled from: SearchBox */
public class PolyFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17214a;

    public PolyFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(boolean z) {
        this.f17214a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f17214a) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PolyFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17214a = false;
    }
}
