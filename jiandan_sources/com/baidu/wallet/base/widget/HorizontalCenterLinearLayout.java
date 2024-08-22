package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public class HorizontalCenterLinearLayout extends LinearLayout {
    public Runnable a = new Runnable() {
        public void run() {
            HorizontalCenterLinearLayout.this.a();
        }
    };
    public int b;
    public int c;
    public boolean d;

    public HorizontalCenterLinearLayout(Context context) {
        super(context);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(this.a);
    }

    /* access modifiers changed from: private */
    public void a() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i2 = 0;
        int i3 = iArr[0];
        int i4 = getResources().getDisplayMetrics().widthPixels;
        if (i4 > 0) {
            int width = (i4 - getWidth()) - i3;
            int abs = Math.abs(i3 - width);
            if (abs != 0) {
                if (i3 <= width) {
                    i2 = abs;
                    abs = 0;
                }
                if (!this.d) {
                    this.b = getPaddingLeft();
                    this.c = getPaddingRight();
                    this.d = true;
                }
                setPadding(this.b + i2, getPaddingTop(), this.c + abs, getPaddingBottom());
            }
        }
    }

    public HorizontalCenterLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalCenterLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
