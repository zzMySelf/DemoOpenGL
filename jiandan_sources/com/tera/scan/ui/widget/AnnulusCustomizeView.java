package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import com.tera.scan.app.R$styleable;

public class AnnulusCustomizeView extends View {
    public static final int DEFAULT_COLOR = -1;
    public static final int FILL = 0;
    public static final int STROKE = 1;
    public int mAnnulusColor;
    public int mAnnulusWidth;
    public RectF mDrawOvalRectF;
    public float mDrawProgress;
    public int mIsShowText;
    public int mLoadColor;
    public int mOverflowColor;
    public Paint mPaint;
    public long mProgress;
    public int mProgressType;
    public int mTextColor;
    public int mTextSize;
    public long maxProgress;
    public Rect rect;

    public AnnulusCustomizeView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        this.mPaint = new Paint();
        this.rect = new Rect();
        this.mDrawOvalRectF = new RectF();
        this.mPaint.setTextSize((float) this.mTextSize);
        this.mPaint.getTextBounds("%", 0, 1, this.rect);
        long j = this.mProgress;
        long j2 = this.maxProgress;
        if (j > j2) {
            this.mDrawProgress = (float) j2;
        } else {
            this.mDrawProgress = (float) j;
        }
    }

    public long getMaxProgress() {
        return this.maxProgress;
    }

    public long getProgress() {
        return this.mProgress;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i2 = width - (this.mAnnulusWidth / 2);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth((float) this.mAnnulusWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mAnnulusColor);
        float f = (float) width;
        canvas.drawCircle(f, f, (float) i2, this.mPaint);
        if (this.mProgress > this.maxProgress) {
            this.mPaint.setColor(this.mOverflowColor);
        } else {
            this.mPaint.setColor(this.mLoadColor);
        }
        this.mPaint.setStrokeWidth((float) this.mAnnulusWidth);
        int i3 = this.mProgressType;
        if (i3 == 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            RectF rectF = this.mDrawOvalRectF;
            int i4 = width - i2;
            int i5 = this.mAnnulusWidth;
            int i6 = i2 + width;
            rectF.set((float) (i4 - (i5 / 2)), (float) (i4 - (i5 / 2)), (float) ((i5 / 2) + i6), (float) (i6 + (i5 / 2)));
            canvas.drawArc(this.mDrawOvalRectF, -90.0f, (this.mDrawProgress * 360.0f) / ((float) this.maxProgress), true, this.mPaint);
        } else if (i3 == 1) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            float f2 = (float) (width - i2);
            float f3 = (float) (i2 + width);
            this.mDrawOvalRectF.set(f2, f2, f3, f3);
            canvas.drawArc(this.mDrawOvalRectF, -90.0f, (this.mDrawProgress * 360.0f) / ((float) this.maxProgress), false, this.mPaint);
        }
        if (this.mIsShowText != 1) {
            int i7 = (int) ((this.mDrawProgress / ((float) this.maxProgress)) * 100.0f);
            this.mPaint.setColor(this.mTextColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeWidth(3.0f);
            Paint paint = this.mPaint;
            float measureText = paint.measureText(i7 + "%");
            canvas.drawText(i7 + "%", f - (measureText / 2.0f), (float) (width + (this.rect.height() / 2)), this.mPaint);
        }
    }

    public void setMaxProgress(long j) {
        if (j > 0) {
            this.maxProgress = j;
        }
    }

    public void setProgress(long j) {
        if (this.mProgress != j) {
            this.mProgress = j;
            long j2 = this.maxProgress;
            if (j > j2) {
                j = j2;
            }
            float f = (float) j;
            if (this.mDrawProgress != f) {
                this.mDrawProgress = f;
                postInvalidate();
            }
        }
    }

    public AnnulusCustomizeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnnulusCustomizeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mProgress = 0;
        this.mDrawProgress = 0.0f;
        this.maxProgress = 100;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AnnulusCustomizeView, i2, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == 1) {
                this.mAnnulusWidth = obtainStyledAttributes.getDimensionPixelSize(index, (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
            } else if (index == 0) {
                this.mAnnulusColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == 3) {
                this.mLoadColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == 4) {
                this.mOverflowColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == 7) {
                this.mTextColor = obtainStyledAttributes.getColor(index, -1);
            } else if (index == 8) {
                this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(index, (int) TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics()));
            } else if (index == 6) {
                this.mProgressType = obtainStyledAttributes.getInt(index, 1);
            } else if (index == 2) {
                this.mIsShowText = obtainStyledAttributes.getInt(index, 1);
            } else if (index == 5) {
                this.mProgress = (long) obtainStyledAttributes.getInt(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
        init();
    }
}
