package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.i.qw;

public class RotateProgress extends ImageView {
    public static final long DEFAULT_REFRESH_PERIOD = 100;
    public static final float DEFAULT_UPDATE_PERCENT = 0.5f;
    public static final int FULL_DEGREE = 360;
    public static final int FULL_PROGRESS = 100;
    public static final int START_DEGREE = -90;
    public static final String TAG = "RotateProgress";
    public int lastProgress;
    public Context mContext = null;
    public int mDdrawedDg = 0;
    public int mFirstColor;
    public int mFirstProgressDegree = 0;
    public boolean mIsShow = true;
    public boolean mIsSmooth = true;
    public RectF mOval = null;
    public Paint mPaint = null;
    public int mProgressWith;
    public int mSecondColor;
    public int mSecondProgressDegree = 0;
    public float mUpdatePercent = 0.5f;

    public RotateProgress(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.rotate_progress_rectangle_width);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.rotate_progress_rectangle_height);
        int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(R.dimen.rotate_progress_width);
        if (attributeSet == null) {
            this.mProgressWith = dimensionPixelSize3;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RotateProgress);
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
            dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize2);
            this.mProgressWith = obtainStyledAttributes.getDimensionPixelSize(0, dimensionPixelSize3);
            obtainStyledAttributes.recycle();
        }
        qw.ad(TAG, "init width = " + dimensionPixelSize + " height = " + dimensionPixelSize2 + " mProgressWith = " + this.mProgressWith);
        this.mFirstColor = context.getResources().getColor(R.color.light_blue);
        this.mSecondColor = context.getResources().getColor(R.color.light_blue);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth((float) this.mProgressWith);
        RectF rectF = new RectF();
        this.mOval = rectF;
        int i2 = (this.mProgressWith + 1) / 2;
        float f = (float) i2;
        rectF.set(f, f, (float) (dimensionPixelSize - i2), (float) (dimensionPixelSize2 - i2));
    }

    public RectF getDrawOval() {
        return this.mOval;
    }

    public int getProgress() {
        return this.lastProgress;
    }

    public int getProgressWith() {
        return this.mProgressWith;
    }

    public float getUpdatePercent() {
        return this.mUpdatePercent;
    }

    public boolean isShow() {
        return this.mIsShow;
    }

    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.mIsShow) {
            if (this.mFirstProgressDegree != 0) {
                this.mPaint.setColor(this.mFirstColor);
                canvas.drawArc(this.mOval, -90.0f, (float) this.mFirstProgressDegree, false, this.mPaint);
                this.mDdrawedDg = this.mFirstProgressDegree;
            }
            int i3 = this.mSecondProgressDegree;
            int i4 = i3 - this.mDdrawedDg;
            if (this.mIsSmooth && i3 != 360 && i4 > 0 && (i2 = (int) (((float) i4) * this.mUpdatePercent)) != 0) {
                postInvalidateDelayed(100);
                i4 = i2;
            }
            int i5 = this.mDdrawedDg + i4;
            this.mDdrawedDg = i5;
            if (this.mFirstProgressDegree < i5) {
                this.mPaint.setColor(this.mSecondColor);
                RectF rectF = this.mOval;
                int i6 = this.mFirstProgressDegree;
                canvas.drawArc(rectF, (float) (i6 - 90), (float) (this.mDdrawedDg - i6), false, this.mPaint);
            }
        }
    }

    public void setDrawOval(RectF rectF) {
        this.mOval = rectF;
    }

    public void setProgress(int i2, boolean z) {
        if (this.lastProgress != i2) {
            this.lastProgress = i2;
            this.mIsSmooth = z;
            this.mFirstProgressDegree = 0;
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 100) {
                i2 = 100;
            }
            this.mSecondProgressDegree = (i2 * FULL_DEGREE) / 100;
            postInvalidate();
        }
    }

    public void setProgressWith(int i2) {
        this.mProgressWith = i2;
    }

    public void setSecondColor(int i2) {
        this.mSecondColor = i2;
    }

    public void setShow(boolean z) {
        if (z != this.mIsShow) {
            this.mIsShow = z;
            postInvalidate();
        }
    }

    public void setUpdatePercent(float f) {
        this.mUpdatePercent = f;
    }

    public void setProgress(int i2) {
        setProgress(i2, false);
    }

    public void setProgress(int[] iArr, boolean z) {
        this.mIsSmooth = z;
        if (iArr != null && iArr.length == 2) {
            int i2 = 0;
            if (iArr[1] >= iArr[0]) {
                int i3 = iArr[0];
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 > 100) {
                    i3 = 100;
                }
                int i4 = iArr[1];
                if (i4 >= 0) {
                    i2 = i4;
                }
                if (i2 > 100) {
                    i2 = 100;
                }
                if (i2 < i3) {
                    i2 = i3;
                }
                this.mFirstProgressDegree = (i3 * FULL_DEGREE) / 100;
                this.mSecondProgressDegree = (i2 * FULL_DEGREE) / 100;
                postInvalidate();
            }
        }
    }

    public RotateProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public void setProgress(int[] iArr) {
        setProgress(iArr, false);
    }

    public RotateProgress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }
}
