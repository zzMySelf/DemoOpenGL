package com.baidu.searchbox.ui.bubble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class BubbleDrawable extends Drawable {
    private float mArrowHeight;
    private float mArrowPosition;
    private float mArrowWidth;
    private float mCornersRadius;
    private Paint mPaint;
    private Path mPath = new Path();
    private RectF mRect;
    private Paint mStrokePaint;
    private Path mStrokePath;
    private float mStrokeWidth;

    public BubbleDrawable(RectF rect, float arrowWidth, float cornersRadius, float arrowHeight, float arrowPosition, float strokeWidth, int strokeColor, int bubbleColor, ArrowDirection arrowDirection) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        this.mRect = rect;
        this.mArrowWidth = arrowWidth;
        this.mCornersRadius = cornersRadius;
        this.mArrowHeight = arrowHeight;
        this.mArrowPosition = arrowPosition;
        this.mStrokeWidth = strokeWidth;
        paint.setColor(bubbleColor);
        if (strokeWidth > 0.0f) {
            Paint paint2 = new Paint(1);
            this.mStrokePaint = paint2;
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mStrokePaint.setColor(strokeColor);
            this.mStrokePath = new Path();
            initPath(arrowDirection, this.mPath, this.mStrokeWidth);
            initPath(arrowDirection, this.mStrokePath, 0.0f);
            return;
        }
        initPath(arrowDirection, this.mPath, 0.0f);
    }

    public void draw(Canvas canvas) {
        if (this.mStrokeWidth > 0.0f) {
            canvas.drawPath(this.mStrokePath, this.mStrokePaint);
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public int getOpacity() {
        return -2;
    }

    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.mPaint.setColorFilter(cf);
    }

    public int getIntrinsicWidth() {
        return (int) this.mRect.width();
    }

    public int getIntrinsicHeight() {
        return (int) this.mRect.height();
    }

    /* renamed from: com.baidu.searchbox.ui.bubble.BubbleDrawable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private void initPath(ArrowDirection arrowDirection, Path path, float strokeWidth) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[arrowDirection.ordinal()]) {
            case 1:
                float f2 = this.mCornersRadius;
                if (f2 <= 0.0f) {
                    initLeftSquarePath(this.mRect, path, strokeWidth);
                    return;
                } else if (strokeWidth <= 0.0f || strokeWidth <= f2) {
                    initLeftRoundedPath(this.mRect, path, strokeWidth);
                    return;
                } else {
                    initLeftSquarePath(this.mRect, path, strokeWidth);
                    return;
                }
            case 2:
                float f3 = this.mCornersRadius;
                if (f3 <= 0.0f) {
                    initTopSquarePath(this.mRect, path, strokeWidth);
                    return;
                } else if (strokeWidth <= 0.0f || strokeWidth <= f3) {
                    initTopRoundedPath(this.mRect, path, strokeWidth);
                    return;
                } else {
                    initTopSquarePath(this.mRect, path, strokeWidth);
                    return;
                }
            case 3:
                float f4 = this.mCornersRadius;
                if (f4 <= 0.0f) {
                    initRightSquarePath(this.mRect, path, strokeWidth);
                    return;
                } else if (strokeWidth <= 0.0f || strokeWidth <= f4) {
                    initRightRoundedPath(this.mRect, path, strokeWidth);
                    return;
                } else {
                    initRightSquarePath(this.mRect, path, strokeWidth);
                    return;
                }
            case 4:
                float f5 = this.mCornersRadius;
                if (f5 <= 0.0f) {
                    initBottomSquarePath(this.mRect, path, strokeWidth);
                    return;
                } else if (strokeWidth <= 0.0f || strokeWidth <= f5) {
                    initBottomRoundedPath(this.mRect, path, strokeWidth);
                    return;
                } else {
                    initBottomSquarePath(this.mRect, path, strokeWidth);
                    return;
                }
            default:
                return;
        }
    }

    private void initLeftRoundedPath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(this.mArrowWidth + rect.left + this.mCornersRadius + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.mCornersRadius) - strokeWidth, rect.top + strokeWidth);
        path.arcTo(new RectF(rect.right - this.mCornersRadius, rect.top + strokeWidth, rect.right - strokeWidth, this.mCornersRadius + rect.top), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.mCornersRadius) - strokeWidth);
        path.arcTo(new RectF(rect.right - this.mCornersRadius, rect.bottom - this.mCornersRadius, rect.right - strokeWidth, rect.bottom - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.mArrowWidth + this.mCornersRadius + strokeWidth, rect.bottom - strokeWidth);
        float f2 = rect.bottom;
        float f3 = this.mCornersRadius;
        path.arcTo(new RectF(rect.left + this.mArrowWidth + strokeWidth, f2 - f3, f3 + rect.left + this.mArrowWidth, rect.bottom - strokeWidth), 90.0f, 90.0f);
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, (this.mArrowHeight + this.mArrowPosition) - (strokeWidth / 2.0f));
        path.lineTo(rect.left + strokeWidth + strokeWidth, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, this.mArrowPosition + (strokeWidth / 2.0f));
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, rect.top + this.mCornersRadius + strokeWidth);
        path.arcTo(new RectF(rect.left + this.mArrowWidth + strokeWidth, rect.top + strokeWidth, this.mCornersRadius + rect.left + this.mArrowWidth, this.mCornersRadius + rect.top), 180.0f, 90.0f);
        path.close();
    }

    private void initLeftSquarePath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(this.mArrowWidth + rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.width() - strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, (this.mArrowHeight + this.mArrowPosition) - (strokeWidth / 2.0f));
        path.lineTo(rect.left + strokeWidth + strokeWidth, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, this.mArrowPosition + (strokeWidth / 2.0f));
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    private void initTopRoundedPath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + Math.min(this.mArrowPosition, this.mCornersRadius) + strokeWidth, rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + (strokeWidth / 2.0f), rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo(rect.left + (this.mArrowWidth / 2.0f) + this.mArrowPosition, rect.top + strokeWidth + strokeWidth);
        path.lineTo(((rect.left + this.mArrowWidth) + this.mArrowPosition) - (strokeWidth / 2.0f), rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo((rect.right - this.mCornersRadius) - strokeWidth, rect.top + this.mArrowHeight + strokeWidth);
        path.arcTo(new RectF(rect.right - this.mCornersRadius, rect.top + this.mArrowHeight + strokeWidth, rect.right - strokeWidth, this.mCornersRadius + rect.top + this.mArrowHeight), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.mCornersRadius) - strokeWidth);
        path.arcTo(new RectF(rect.right - this.mCornersRadius, rect.bottom - this.mCornersRadius, rect.right - strokeWidth, rect.bottom - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.mCornersRadius + strokeWidth, rect.bottom - strokeWidth);
        float f2 = rect.bottom;
        float f3 = this.mCornersRadius;
        path.arcTo(new RectF(rect.left + strokeWidth, f2 - f3, f3 + rect.left, rect.bottom - strokeWidth), 90.0f, 90.0f);
        path.lineTo(rect.left + strokeWidth, rect.top + this.mArrowHeight + this.mCornersRadius + strokeWidth);
        path.arcTo(new RectF(rect.left + strokeWidth, rect.top + this.mArrowHeight + strokeWidth, this.mCornersRadius + rect.left, this.mCornersRadius + rect.top + this.mArrowHeight), 180.0f, 90.0f);
        path.close();
    }

    private void initTopSquarePath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.mArrowPosition + strokeWidth, rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + (strokeWidth / 2.0f), rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo(rect.left + (this.mArrowWidth / 2.0f) + this.mArrowPosition, rect.top + strokeWidth + strokeWidth);
        path.lineTo(((rect.left + this.mArrowWidth) + this.mArrowPosition) - (strokeWidth / 2.0f), rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + this.mArrowHeight + strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + strokeWidth, rect.top + this.mArrowHeight + strokeWidth);
        path.close();
    }

    private void initRightRoundedPath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.mCornersRadius + strokeWidth, rect.top + strokeWidth);
        path.lineTo(((rect.width() - this.mCornersRadius) - this.mArrowWidth) - strokeWidth, rect.top + strokeWidth);
        path.arcTo(new RectF((rect.right - this.mCornersRadius) - this.mArrowWidth, rect.top + strokeWidth, (rect.right - this.mArrowWidth) - strokeWidth, this.mCornersRadius + rect.top), 270.0f, 90.0f);
        path.lineTo((rect.right - this.mArrowWidth) - strokeWidth, this.mArrowPosition + (strokeWidth / 2.0f));
        path.lineTo((rect.right - strokeWidth) - strokeWidth, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo((rect.right - this.mArrowWidth) - strokeWidth, (this.mArrowPosition + this.mArrowHeight) - (strokeWidth / 2.0f));
        path.lineTo((rect.right - this.mArrowWidth) - strokeWidth, (rect.bottom - this.mCornersRadius) - strokeWidth);
        path.arcTo(new RectF((rect.right - this.mCornersRadius) - this.mArrowWidth, rect.bottom - this.mCornersRadius, (rect.right - this.mArrowWidth) - strokeWidth, rect.bottom - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.mArrowWidth + strokeWidth, rect.bottom - strokeWidth);
        float f2 = rect.bottom;
        float f3 = this.mCornersRadius;
        path.arcTo(new RectF(rect.left + strokeWidth, f2 - f3, f3 + rect.left, rect.bottom - strokeWidth), 90.0f, 90.0f);
        path.arcTo(new RectF(rect.left + strokeWidth, rect.top + strokeWidth, this.mCornersRadius + rect.left, this.mCornersRadius + rect.top), 180.0f, 90.0f);
        path.close();
    }

    private void initRightSquarePath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.mArrowWidth) - strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.right - this.mArrowWidth) - strokeWidth, this.mArrowPosition + (strokeWidth / 2.0f));
        path.lineTo((rect.right - strokeWidth) - strokeWidth, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo((rect.right - this.mArrowWidth) - strokeWidth, (this.mArrowPosition + this.mArrowHeight) - (strokeWidth / 2.0f));
        path.lineTo((rect.right - this.mArrowWidth) - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    private void initBottomRoundedPath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.mCornersRadius + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.mCornersRadius) - strokeWidth, rect.top + strokeWidth);
        path.arcTo(new RectF(rect.right - this.mCornersRadius, rect.top + strokeWidth, rect.right - strokeWidth, this.mCornersRadius + rect.top), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, ((rect.bottom - this.mArrowHeight) - this.mCornersRadius) - strokeWidth);
        path.arcTo(new RectF(rect.right - this.mCornersRadius, (rect.bottom - this.mCornersRadius) - this.mArrowHeight, rect.right - strokeWidth, (rect.bottom - this.mArrowHeight) - strokeWidth), 0.0f, 90.0f);
        path.lineTo(((rect.left + this.mArrowWidth) + this.mArrowPosition) - (strokeWidth / 2.0f), (rect.bottom - this.mArrowHeight) - strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + (this.mArrowWidth / 2.0f), (rect.bottom - strokeWidth) - strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + (strokeWidth / 2.0f), (rect.bottom - this.mArrowHeight) - strokeWidth);
        path.lineTo(rect.left + Math.min(this.mCornersRadius, this.mArrowPosition) + strokeWidth, (rect.bottom - this.mArrowHeight) - strokeWidth);
        float f2 = rect.bottom;
        float f3 = this.mCornersRadius;
        path.arcTo(new RectF(rect.left + strokeWidth, (f2 - f3) - this.mArrowHeight, f3 + rect.left, (rect.bottom - this.mArrowHeight) - strokeWidth), 90.0f, 90.0f);
        path.lineTo(rect.left + strokeWidth, rect.top + this.mCornersRadius + strokeWidth);
        path.arcTo(new RectF(rect.left + strokeWidth, rect.top + strokeWidth, this.mCornersRadius + rect.left, this.mCornersRadius + rect.top), 180.0f, 90.0f);
        path.close();
    }

    private void initBottomSquarePath(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.mArrowHeight) - strokeWidth);
        path.lineTo(((rect.left + this.mArrowWidth) + this.mArrowPosition) - (strokeWidth / 2.0f), (rect.bottom - this.mArrowHeight) - strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + (this.mArrowWidth / 2.0f), (rect.bottom - strokeWidth) - strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + (strokeWidth / 2.0f), (rect.bottom - this.mArrowHeight) - strokeWidth);
        path.lineTo(rect.left + this.mArrowPosition + strokeWidth, (rect.bottom - this.mArrowHeight) - strokeWidth);
        path.lineTo(rect.left + strokeWidth, (rect.bottom - this.mArrowHeight) - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.close();
    }
}
