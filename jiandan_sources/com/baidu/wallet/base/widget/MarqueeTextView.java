package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;

public class MarqueeTextView extends TextView implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final int f1147i = 2000;
    public int a;
    public boolean b = true;
    public int c;
    public int d;
    public int e = 0;
    public int f = 2;
    public int g = 10;
    public boolean h = false;

    public MarqueeTextView(Context context) {
        super(context);
    }

    private int getTextWidth() {
        int measureText = (int) getPaint().measureText(getText().toString());
        this.c = measureText;
        return measureText;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            int width = getWidth();
            this.d = width;
            if (width > getTextWidth()) {
                this.b = true;
                return;
            }
            int scrollX = getScrollX();
            this.e = scrollX;
            this.a = scrollX;
            this.h = false;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.b = true;
        removeCallbacks(this);
        int i5 = this.e;
        this.a = i5;
        scrollTo(i5, 0);
        super.onTextChanged(charSequence, i2, i3, i4);
        this.h = true;
        this.b = false;
        postDelayed(this, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
    }

    public void run() {
        int i2 = this.a + this.f;
        this.a = i2;
        scrollTo(i2, 0);
        if (!this.b) {
            if (getScrollX() >= this.c - this.d) {
                scrollTo(this.e, 0);
                this.a = this.e;
                postDelayed(this, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
            } else if (getScrollX() >= (this.c - this.d) - this.f) {
                postDelayed(this, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
            } else {
                postDelayed(this, (long) this.g);
            }
        }
    }

    public void stop() {
        this.b = true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
