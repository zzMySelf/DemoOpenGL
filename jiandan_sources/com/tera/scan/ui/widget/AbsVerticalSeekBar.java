package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tera.scan.app.R$styleable;

public class AbsVerticalSeekBar extends VerticalProgressBar {
    public static final int NO_ALPHA = 255;
    public float mDisabledAlpha;
    public boolean mIsUserSeekable = true;
    public int mKeyProgressIncrement = 1;
    public Drawable mThumb;
    public int mThumbOffset;
    public float mTouchProgressOffset;

    public AbsVerticalSeekBar(Context context) {
        super(context);
    }

    private void attemptClaimDrag() {
        ViewParent viewParent = this.mParent;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private int getThumbOffset() {
        return this.mThumbOffset;
    }

    private void setThumbPos(int i2, Drawable drawable, float f, int i3) {
        int i4;
        int i5 = (i2 - this.mPaddingTop) - this.mPaddingBottom;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i6 = (int) ((1.0f - f) * ((float) ((i5 - intrinsicHeight) + (this.mThumbOffset * 2))));
        if (i3 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i3 = bounds.left;
            i4 = bounds.right;
        } else {
            i4 = i3 + intrinsicWidth;
        }
        drawable.setBounds(i3, i6, i4, intrinsicHeight + i6);
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        float f;
        int height = getHeight();
        int i2 = (height - this.mPaddingTop) - this.mPaddingBottom;
        int y = height - ((int) motionEvent.getY());
        int i3 = this.mPaddingBottom;
        float f2 = 0.0f;
        if (y < i3) {
            f = 0.0f;
        } else if (y > height - this.mPaddingTop) {
            f = 1.0f;
        } else {
            float f3 = ((float) (y - i3)) / ((float) i2);
            f2 = this.mTouchProgressOffset;
            f = f3;
        }
        setProgress((int) (f2 + (f * ((float) getMax()))), true);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (this.mDisabledAlpha * 255.0f));
        }
        Drawable drawable = this.mThumb;
        if (drawable != null && drawable.isStateful()) {
            this.mThumb.setState(getDrawableState());
        }
    }

    public int getKeyProgressIncrement() {
        return this.mKeyProgressIncrement;
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mThumb != null) {
            canvas.save();
            canvas.translate((float) this.mPaddingLeft, (float) (this.mPaddingTop - this.mThumbOffset));
            this.mThumb.draw(canvas);
            canvas.restore();
        }
    }

    public void onKeyChange() {
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        int progress = getProgress();
        if (i2 != 19) {
            if (i2 == 20 && progress > 0) {
                setProgress(progress - this.mKeyProgressIncrement, true);
                onKeyChange();
                return true;
            }
        } else if (progress < getMax()) {
            setProgress(progress + this.mKeyProgressIncrement, true);
            onKeyChange();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.mThumb;
        int i5 = 0;
        int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
        if (currentDrawable != null) {
            Math.max(this.mMinWidth, Math.min(this.mMaxWidth, currentDrawable.getIntrinsicWidth()));
            i5 = Math.max(intrinsicWidth, 0);
            i4 = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, currentDrawable.getIntrinsicHeight()));
        } else {
            i4 = 0;
        }
        setMeasuredDimension(View.resolveSize(i5 + this.mPaddingLeft + this.mPaddingRight, i2), View.resolveSize(i4 + this.mPaddingTop + this.mPaddingBottom, i3));
    }

    public void onProgressRefresh(float f, boolean z) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getHeight(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.mThumb;
        if (drawable == null) {
            i6 = 0;
        } else {
            i6 = drawable.getIntrinsicWidth();
        }
        int min = Math.min(this.mMaxWidth, (i2 - this.mPaddingRight) - this.mPaddingLeft);
        int max = getMax();
        float progress = max > 0 ? ((float) getProgress()) / ((float) max) : 0.0f;
        if (i6 > min) {
            int i7 = (i6 - min) / 2;
            if (drawable != null) {
                setThumbPos(i3, drawable, progress, i7 * -1);
            }
            if (currentDrawable != null) {
                currentDrawable.setBounds(i7, 0, ((i2 - this.mPaddingRight) - this.mPaddingLeft) - i7, (i3 - this.mPaddingBottom) - this.mPaddingTop);
                return;
            }
            return;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, 0, (i2 - this.mPaddingRight) - this.mPaddingLeft, (i3 - this.mPaddingBottom) - this.mPaddingTop);
        }
        int i8 = (min - i6) / 2;
        if (drawable != null) {
            setThumbPos(i3, drawable, progress, i8);
        }
    }

    public void onStartTrackingTouch() {
    }

    public void onStopTrackingTouch() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsUserSeekable || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setPressed(true);
            onStartTrackingTouch();
            trackTouchEvent(motionEvent);
        } else if (action == 1) {
            trackTouchEvent(motionEvent);
            onStopTrackingTouch();
            setPressed(false);
            invalidate();
        } else if (action == 2) {
            trackTouchEvent(motionEvent);
            attemptClaimDrag();
        } else if (action == 3) {
            onStopTrackingTouch();
            setPressed(false);
            invalidate();
        }
        return true;
    }

    public void setKeyProgressIncrement(int i2) {
        if (i2 < 0) {
            i2 = -i2;
        }
        this.mKeyProgressIncrement = i2;
    }

    public synchronized void setMax(int i2) {
        super.setMax(i2);
        if (this.mKeyProgressIncrement == 0 || getMax() / this.mKeyProgressIncrement > 20) {
            setKeyProgressIncrement(Math.max(1, Math.round(((float) getMax()) / 20.0f)));
        }
    }

    public void setThumb(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            this.mThumbOffset = drawable.getIntrinsicHeight() / 2;
        }
        this.mThumb = drawable;
        invalidate();
    }

    public void setThumbOffset(int i2) {
        this.mThumbOffset = i2;
        invalidate();
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mThumb || super.verifyDrawable(drawable);
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SeekBar, i2, 0);
        setThumb(obtainStyledAttributes.getDrawable(0));
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(1, getThumbOffset()));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Theme, 0, 0);
        this.mDisabledAlpha = obtainStyledAttributes2.getFloat(0, 0.5f);
        obtainStyledAttributes2.recycle();
    }
}
