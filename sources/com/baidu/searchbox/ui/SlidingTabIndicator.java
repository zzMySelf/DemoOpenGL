package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

class SlidingTabIndicator extends LinearLayout {
    private static final float DRAG_VISCOSITY_PARAM = 2.3f;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private int mIndicatorLeft;
    private int mIndicatorPadding;
    private int mIndicatorRight;
    private final Paint mSelectedIndicatorPaint;
    private int mSelectedPosition;
    private float mSelectionOffset;

    public SlidingTabIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingTabIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIndicatorColor = -16776961;
        this.mIndicatorLeft = -1;
        this.mIndicatorRight = -1;
        setWillNotDraw(false);
        float f2 = getResources().getDisplayMetrics().density;
        this.mSelectedIndicatorPaint = new Paint();
    }

    public void setIndicatorColor(int color) {
        if (this.mIndicatorColor != color) {
            this.mIndicatorColor = color;
            invalidate();
        }
    }

    public void setIndicatorHeight(int height) {
        if (this.mIndicatorHeight != height) {
            this.mIndicatorHeight = height;
            invalidate();
        }
    }

    public void setIndicatorPadding(int padding) {
        if (this.mIndicatorPadding != padding) {
            this.mIndicatorPadding = padding;
            invalidate();
        }
    }

    public void setIndicatorPositionFromTabPosition(int position, float positionOffset) {
        this.mSelectedPosition = position;
        this.mSelectionOffset = positionOffset;
        updateIndicatorPosition();
    }

    private void updateIndicatorPosition() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mSelectedPosition >= childCount) {
                this.mSelectedPosition = childCount - 1;
            }
            View selectedTabItemView = getChildAt(this.mSelectedPosition);
            int left = selectedTabItemView.getLeft() + this.mIndicatorPadding;
            int right = selectedTabItemView.getRight() - this.mIndicatorPadding;
            if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                View nextTabItemView = getChildAt(this.mSelectedPosition + 1);
                int targetLeft = nextTabItemView.getLeft() + this.mIndicatorPadding;
                int targetRight = nextTabItemView.getRight() - this.mIndicatorPadding;
                float rightRatioAmplifier = 1.0f - ((float) Math.pow((double) (1.0f - this.mSelectionOffset), 2.299999952316284d));
                left += (int) (((float) (targetLeft - left)) * ((float) Math.pow((double) this.mSelectionOffset, 2.299999952316284d)));
                right += (int) (((float) (targetRight - right)) * rightRatioAmplifier);
            }
            setIndicatorPosition(left, right);
        }
    }

    private void setIndicatorPosition(int left, int right) {
        if (left != this.mIndicatorLeft || right != this.mIndicatorRight) {
            this.mIndicatorLeft = left;
            this.mIndicatorRight = right;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mSelectedIndicatorPaint.setColor(this.mIndicatorColor);
        int i2 = this.mIndicatorLeft;
        if (i2 >= 0 && this.mIndicatorRight > i2) {
            canvas.drawRect((float) i2, (float) (getHeight() - this.mIndicatorHeight), (float) this.mIndicatorRight, (float) getHeight(), this.mSelectedIndicatorPaint);
        }
    }
}
