package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;

public class SmoothProgressBar extends RotateProgressBar {
    private static final int FRAME_RATE = 36;

    public SmoothProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public SmoothProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SmoothProgressBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mFrameDuration = (int) ((((((float) this.mFrameDuration) * 12.0f) / 36.0f) / 2.0f) + 0.5f);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            if (SystemClock.uptimeMillis() - this.mLastDrawTime >= ((long) this.mFrameDuration)) {
                this.mLastDrawTime = SystemClock.uptimeMillis();
                this.mDegree += 277;
                if (this.mDegree >= 10000) {
                    this.mDegree -= 10000;
                }
                drawable.setLevel(this.mDegree);
                postInvalidateDelayed((long) this.mFrameDuration);
            }
        }
    }
}
