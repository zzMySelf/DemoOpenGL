package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {
    public boolean a;
    public SparseIntArray b;

    public NoScrollViewPager(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a && super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i2, int i3) {
        super.scrollTo(i2, i3);
    }

    public void setScanScroll(boolean z) {
        this.a = z;
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = new SparseIntArray();
    }
}
