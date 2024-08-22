package com.tera.scan.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tera.scan.app.R$styleable;

public class PullDownCircleProgressBar extends View {
    public static final boolean DEFAULT_FILL_MODE = true;
    public static final int DEFAULT_INSIDE_VALUE = 0;
    public static final int DEFAULT_MAX_VALUE = 100;
    public static final int DEFAULT_PAINT_COLOR = -13312;
    public static final int DEFAULT_PAINT_WIDTH = 10;
    public static final boolean DEFAULT_STROKE_CAP_ROUND = false;
    public static final String TAG = "PullDownCircleProgressBar";
    public Drawable mBackgroundPicture;
    public qw mCircleAttribute;
    public int mMainCurProgress;
    public int mMaxProgress;

    public class qw {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f7487ad = true;

        /* renamed from: de  reason: collision with root package name */
        public int f7488de = 0;

        /* renamed from: fe  reason: collision with root package name */
        public int f7489fe = 0;
        public RectF qw = new RectF();

        /* renamed from: rg  reason: collision with root package name */
        public int f7491rg = PullDownCircleProgressBar.DEFAULT_PAINT_COLOR;

        /* renamed from: th  reason: collision with root package name */
        public int f7492th = -90;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f7493uk = false;

        /* renamed from: yj  reason: collision with root package name */
        public Paint f7494yj;

        public qw() {
            Paint paint = new Paint();
            this.f7494yj = paint;
            paint.setAntiAlias(true);
            this.f7494yj.setStyle(Paint.Style.FILL);
            this.f7494yj.setStrokeWidth((float) this.f7489fe);
            this.f7494yj.setColor(this.f7491rg);
            if (this.f7493uk) {
                this.f7494yj.setStrokeCap(Paint.Cap.ROUND);
            }
        }

        public void ad(boolean z) {
            this.f7487ad = z;
            if (z) {
                this.f7494yj.setStyle(Paint.Style.FILL);
            } else {
                this.f7494yj.setStyle(Paint.Style.STROKE);
            }
        }

        public void de(int i2) {
            this.f7494yj.setColor(i2);
        }

        public void fe(int i2) {
            this.f7494yj.setStrokeWidth((float) i2);
        }

        public void qw(int i2, int i3) {
            int i4 = this.f7488de;
            if (i4 != 0) {
                RectF rectF = this.qw;
                int i5 = this.f7489fe;
                rectF.set((float) ((i5 / 2) + i4), (float) ((i5 / 2) + i4), (float) ((i2 - (i5 / 2)) - i4), (float) ((i3 - (i5 / 2)) - i4));
                return;
            }
            int paddingLeft = PullDownCircleProgressBar.this.getPaddingLeft();
            int paddingRight = PullDownCircleProgressBar.this.getPaddingRight();
            int paddingTop = PullDownCircleProgressBar.this.getPaddingTop();
            int paddingBottom = PullDownCircleProgressBar.this.getPaddingBottom();
            RectF rectF2 = this.qw;
            int i6 = this.f7489fe;
            rectF2.set((float) (paddingLeft + (i6 / 2)), (float) (paddingTop + (i6 / 2)), (float) ((i2 - paddingRight) - (i6 / 2)), (float) ((i3 - paddingBottom) - (i6 / 2)));
        }

        public void rg(boolean z) {
            this.f7493uk = z;
            if (z) {
                this.f7494yj.setStrokeCap(Paint.Cap.ROUND);
            }
        }
    }

    public PullDownCircleProgressBar(Context context) {
        super(context);
    }

    private synchronized void initDefaultParam() {
        this.mCircleAttribute = new qw();
        this.mMaxProgress = 100;
        this.mMainCurProgress = 0;
    }

    public synchronized int getMainProgress() {
        return this.mMainCurProgress;
    }

    public synchronized int getMaxProgress() {
        return this.mMaxProgress;
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.mCircleAttribute.qw, (float) this.mCircleAttribute.f7492th, (((float) this.mMainCurProgress) / ((float) this.mMaxProgress)) * 360.0f, this.mCircleAttribute.f7487ad, this.mCircleAttribute.f7494yj);
    }

    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getSize(i3);
        Drawable background = getBackground();
        this.mBackgroundPicture = background;
        if (background != null) {
            size = background.getMinimumWidth();
            this.mBackgroundPicture.getMinimumHeight();
        }
        setMeasuredDimension(View.resolveSize(size, i2), View.resolveSize(size, i3));
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.mCircleAttribute.qw(i2, i3);
    }

    public synchronized void setMainProgress(int i2) {
        this.mMainCurProgress = i2;
        if (i2 < 0) {
            this.mMainCurProgress = 0;
        }
        if (this.mMainCurProgress > this.mMaxProgress) {
            this.mMainCurProgress = this.mMaxProgress;
        }
        invalidate();
    }

    public PullDownCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initDefaultParam();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleProgressBar);
        this.mMaxProgress = obtainStyledAttributes.getInteger(4, 100);
        boolean z = obtainStyledAttributes.getBoolean(3, true);
        int i2 = obtainStyledAttributes.getInt(2, 10);
        this.mCircleAttribute.ad(z);
        if (!z) {
            this.mCircleAttribute.fe(i2);
        }
        this.mCircleAttribute.de(obtainStyledAttributes.getColor(1, DEFAULT_PAINT_COLOR));
        this.mCircleAttribute.f7488de = obtainStyledAttributes.getInt(0, 0);
        this.mCircleAttribute.rg(obtainStyledAttributes.getBoolean(5, false));
        obtainStyledAttributes.recycle();
    }
}
