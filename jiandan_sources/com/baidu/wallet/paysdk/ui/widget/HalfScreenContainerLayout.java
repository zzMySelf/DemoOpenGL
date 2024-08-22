package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class HalfScreenContainerLayout extends LinearLayout {
    public boolean a = false;

    public HalfScreenContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isClickable() {
        return !this.a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a;
    }

    public void setClickable(boolean z) {
        this.a = !z;
    }
}
