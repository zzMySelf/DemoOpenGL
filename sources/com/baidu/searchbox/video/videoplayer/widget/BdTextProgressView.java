package com.baidu.searchbox.video.videoplayer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.player.utils.ViewUtil;
import com.baidu.searchbox.videoplayer.widget.R;

public class BdTextProgressView extends View {
    private static final int BOTTOM = 32;
    private static final int CENTER = 0;
    private static final int CENTER_HORIZONTAL = 3;
    private static final int CENTER_VERTICAL = 48;
    private static final int DEFAULT_GRAVITY = 1;
    private static final int DEFAULT_HEIGHT = ViewUtil.dp2px(15.0f);
    private static final String DEFAULT_PROGRESS_TIME_TEXT = "00:00:00";
    private static final float DEFAULT_TEXT_SIZE = 15.0f;
    private static final String DEFAULT_TIME_TEXT = "00:00";
    private static final int DEFAULT_WIDTH = ViewUtil.dp2px(120.0f);
    private static final int LEFT = 1;
    private static final int PROGRESS_MODE = 1;
    private static final int RIGHT = 2;
    private static final int SPACE = ViewUtil.dp2px(2.0f);
    private static final String TAG = "BdTextProgressView";
    private static final int TIME_MODE = 2;
    private static final int TOP = 16;
    private final int mGravity;
    private final Paint mPaint;
    private String mPositionText;
    private final int mProgressMode;
    private int mTextColor;
    private float mTextSize;
    private String mTimeText;

    public BdTextProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BdTextProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BdTextProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPositionText = DEFAULT_PROGRESS_TIME_TEXT;
        TypedArray mTypedArray = null;
        try {
            mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.BdTextProgressView);
            this.mTextSize = mTypedArray.getDimension(R.styleable.BdTextProgressView_progressTextSize, 15.0f);
            this.mTextColor = mTypedArray.getColor(R.styleable.BdTextProgressView_progressTextColor, -1);
            this.mGravity = mTypedArray.getInt(R.styleable.BdTextProgressView_progressGravity, 1);
            int i2 = mTypedArray.getInt(R.styleable.BdTextProgressView_progressTextMode, 1);
            this.mProgressMode = i2;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            paint.setColor(this.mTextColor);
            paint.setTextSize(this.mTextSize);
            if (i2 == 2) {
                paint.setFakeBoldText(true);
            }
        } finally {
            if (mTypedArray != null) {
                mTypedArray.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(setMeasuredWidth(widthMeasureSpec), setMeasuredHeight(heightMeasureSpec));
    }

    private int setMeasuredWidth(int widthMeasureSpec) {
        String text;
        if (this.mProgressMode == 1) {
            text = DEFAULT_PROGRESS_TIME_TEXT;
        } else {
            text = DEFAULT_TIME_TEXT;
        }
        int widthWrapContent = (int) this.mPaint.measureText(text);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode == 1073741824) {
            return widthSize;
        }
        if (widthMode == Integer.MIN_VALUE) {
            return widthWrapContent;
        }
        return DEFAULT_WIDTH;
    }

    private int setMeasuredHeight(int heightMeasureSpec) {
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == 1073741824) {
            return DEFAULT_HEIGHT;
        }
        if (heightMode == Integer.MIN_VALUE) {
            return Math.min(DEFAULT_HEIGHT, heightSize);
        }
        return DEFAULT_HEIGHT;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.mProgressMode;
        if (i2 == 1) {
            drawProgressText(canvas);
        } else if (i2 == 2) {
            drawTimeText(canvas);
        }
    }

    private void drawProgressText(Canvas canvas) {
        Paint.FontMetricsInt fontMetrics = this.mPaint.getFontMetricsInt();
        int baseline = (((getMeasuredHeight() - fontMetrics.bottom) + fontMetrics.top) / 2) - fontMetrics.top;
        canvas.drawText(this.mPositionText, (float) calculateLeftOffest(this.mGravity, (int) this.mPaint.measureText(this.mPositionText)), (float) baseline, this.mPaint);
    }

    private void drawTimeText(Canvas canvas) {
        Paint.FontMetricsInt fontMetrics = this.mPaint.getFontMetricsInt();
        int baseline = (((getMeasuredHeight() - fontMetrics.bottom) + fontMetrics.top) / 2) - fontMetrics.top;
        canvas.drawText(this.mTimeText, (float) calculateLeftOffest(this.mGravity, (int) this.mPaint.measureText(this.mTimeText)), (float) baseline, this.mPaint);
    }

    private int calculateLeftOffest(int gravity, int textWidth) {
        switch (this.mGravity) {
            case 0:
                return (getMeasuredWidth() - textWidth) / 2;
            case 1:
                return 0;
            case 2:
                return getMeasuredWidth() - textWidth;
            default:
                return 0;
        }
    }

    public String getPositionText() {
        return this.mPositionText;
    }

    public void setPositionText(String mPositionText2) {
        if (this.mProgressMode == 1) {
            this.mPositionText = mPositionText2;
            postInvalidate();
        }
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public void setTextColor(int mTextColor2) {
        this.mTextColor = mTextColor2;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public void setTextSize(float textSize) {
        this.mTextSize = textSize;
        this.mPaint.setTextSize(textSize);
        invalidate();
    }

    public void setTimeText(String timeText) {
        if (this.mProgressMode == 2) {
            this.mTimeText = timeText;
            postInvalidate();
        }
    }

    public String getTimeText() {
        return this.mTimeText;
    }

    public void setTypeface(Typeface tf, boolean isBold) {
        if (this.mPaint.getTypeface() != tf) {
            this.mPaint.setTypeface(tf);
        }
        this.mPaint.setFakeBoldText(isBold);
    }
}
