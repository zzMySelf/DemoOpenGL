package com.baidu.swan.apps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.lang.reflect.Field;

public class RotateProgressBar extends ProgressBar {
    protected static final int ANIMATION_RESOLUTION = 200;
    protected static final int INCREMENT = 30;
    protected static final int MAX_DEGREE = 360;
    protected static final int MAX_LEVEL = 10000;
    protected Drawable mCurrentDrawable;
    protected int mDegree = 0;
    protected int mFrameDuration;
    protected long mLastDrawTime;

    public RotateProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RotateProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RotateProgressBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mFrameDuration = 200;
        try {
            Field field = ProgressBar.class.getDeclaredField("mDuration");
            if (field != null) {
                field.setAccessible(true);
                this.mFrameDuration = (int) ((((float) field.getInt(this)) / 12.0f) + 0.5f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            long delay = SystemClock.uptimeMillis() - this.mLastDrawTime;
            int i2 = this.mFrameDuration;
            if (delay < ((long) i2)) {
                postInvalidateDelayed(((long) i2) - delay);
            } else {
                this.mLastDrawTime = SystemClock.uptimeMillis();
                int i3 = this.mDegree + 30;
                this.mDegree = i3;
                if (i3 >= 360) {
                    this.mDegree = 0;
                }
                drawable.setLevel((int) (((float) (this.mDegree * 10000)) / 360.0f));
                postInvalidateDelayed((long) this.mFrameDuration);
            }
        }
    }

    public synchronized void setIndeterminateDrawable(Drawable d2) {
        super.setIndeterminateDrawable(d2);
        if (isIndeterminate()) {
            this.mCurrentDrawable = d2;
        }
    }

    public synchronized void setIndeterminate(boolean indeterminate) {
        super.setIndeterminate(indeterminate);
        if (indeterminate) {
            this.mCurrentDrawable = getIndeterminateDrawable();
        }
    }

    public void invalidateDrawable(Drawable dr) {
    }
}
