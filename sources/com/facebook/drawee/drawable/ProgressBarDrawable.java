package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class ProgressBarDrawable extends Drawable implements CloneableDrawable {
    private int mBackgroundColor = Integer.MIN_VALUE;
    private int mBarWidth = 20;
    private int mColor = -2147450625;
    private boolean mHideWhenZero = false;
    private boolean mIsVertical = false;
    private int mLevel = 0;
    private int mPadding = 10;
    private final Paint mPaint = new Paint(1);
    private final Path mPath = new Path();
    private int mRadius = 0;
    private final RectF mRect = new RectF();

    public void setColor(int color) {
        if (this.mColor != color) {
            this.mColor = color;
            invalidateSelf();
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        if (this.mBackgroundColor != backgroundColor) {
            this.mBackgroundColor = backgroundColor;
            invalidateSelf();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setPadding(int padding) {
        if (this.mPadding != padding) {
            this.mPadding = padding;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect padding) {
        int i2 = this.mPadding;
        padding.set(i2, i2, i2, i2);
        return this.mPadding != 0;
    }

    public void setBarWidth(int barWidth) {
        if (this.mBarWidth != barWidth) {
            this.mBarWidth = barWidth;
            invalidateSelf();
        }
    }

    public int getBarWidth() {
        return this.mBarWidth;
    }

    public void setHideWhenZero(boolean hideWhenZero) {
        this.mHideWhenZero = hideWhenZero;
    }

    public boolean getHideWhenZero() {
        return this.mHideWhenZero;
    }

    public void setRadius(int radius) {
        if (this.mRadius != radius) {
            this.mRadius = radius;
            invalidateSelf();
        }
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setIsVertical(boolean isVertical) {
        if (this.mIsVertical != isVertical) {
            this.mIsVertical = isVertical;
            invalidateSelf();
        }
    }

    public boolean getIsVertical() {
        return this.mIsVertical;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int level) {
        this.mLevel = level;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.mPaint.setColorFilter(cf);
    }

    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(this.mPaint.getColor());
    }

    public void draw(Canvas canvas) {
        if (this.mHideWhenZero && this.mLevel == 0) {
            return;
        }
        if (this.mIsVertical) {
            drawVerticalBar(canvas, 10000, this.mBackgroundColor);
            drawVerticalBar(canvas, this.mLevel, this.mColor);
            return;
        }
        drawHorizontalBar(canvas, 10000, this.mBackgroundColor);
        drawHorizontalBar(canvas, this.mLevel, this.mColor);
    }

    public Drawable cloneDrawable() {
        ProgressBarDrawable copy = new ProgressBarDrawable();
        copy.mBackgroundColor = this.mBackgroundColor;
        copy.mColor = this.mColor;
        copy.mPadding = this.mPadding;
        copy.mBarWidth = this.mBarWidth;
        copy.mLevel = this.mLevel;
        copy.mRadius = this.mRadius;
        copy.mHideWhenZero = this.mHideWhenZero;
        copy.mIsVertical = this.mIsVertical;
        return copy;
    }

    private void drawHorizontalBar(Canvas canvas, int level, int color) {
        Rect bounds = getBounds();
        int xpos = bounds.left + this.mPadding;
        int i2 = bounds.bottom - this.mPadding;
        int i3 = this.mBarWidth;
        int ypos = i2 - i3;
        this.mRect.set((float) xpos, (float) ypos, (float) (xpos + (((bounds.width() - (this.mPadding * 2)) * level) / 10000)), (float) (i3 + ypos));
        drawBar(canvas, color);
    }

    private void drawVerticalBar(Canvas canvas, int level, int color) {
        Rect bounds = getBounds();
        int xpos = bounds.left + this.mPadding;
        int ypos = bounds.top + this.mPadding;
        this.mRect.set((float) xpos, (float) ypos, (float) (this.mBarWidth + xpos), (float) (ypos + (((bounds.height() - (this.mPadding * 2)) * level) / 10000)));
        drawBar(canvas, color);
    }

    private void drawBar(Canvas canvas, int color) {
        this.mPaint.setColor(color);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPath.reset();
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        this.mPath.addRoundRect(this.mRect, (float) Math.min(this.mRadius, this.mBarWidth / 2), (float) Math.min(this.mRadius, this.mBarWidth / 2), Path.Direction.CW);
        canvas.drawPath(this.mPath, this.mPaint);
    }
}
