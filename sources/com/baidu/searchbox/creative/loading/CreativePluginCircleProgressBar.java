package com.baidu.searchbox.creative.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.creative.R;

public class CreativePluginCircleProgressBar extends View implements ICreativePluginProgress {
    private float mCenterX;
    private float mCenterY;
    private int mCircleColor;
    private float mCircleWidth;
    private final Paint mPaint;
    private int mProgress;
    private int mProgressColor;
    private float mRadius;
    private String mText;
    private int mTextColor;
    private float mTextSize;

    public CreativePluginCircleProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public CreativePluginCircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CreativePluginCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPaint = new Paint();
        init(context, attrs);
    }

    public void setText(String text) {
        this.mText = text;
        postInvalidate();
    }

    public void setProgress(int progress) {
        if (progress < 0) {
            progress = 0;
        }
        if (progress > 100) {
            progress = 100;
        }
        this.mProgress = progress;
        this.mText = "" + this.mProgress + '%';
        postInvalidate();
    }

    private void init(Context context, AttributeSet attrs) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(50.0f);
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.creative_plugin_circle_progressbar);
            this.mCircleWidth = array.getDimension(R.styleable.creative_plugin_circle_progressbar_creativePluginProgressCircleWidth, getResources().getDimension(R.dimen.creative_plugin_circle_progressbar_circle_width_default));
            this.mCircleColor = array.getColor(R.styleable.creative_plugin_circle_progressbar_creativePluginProgressCircleColor, getResources().getColor(R.color.creative_plugin_load_circle_color));
            this.mProgressColor = array.getColor(R.styleable.creative_plugin_circle_progressbar_creativePluginProgressColor, getResources().getColor(R.color.creative_plugin_load_txt_color));
            this.mText = array.getString(R.styleable.creative_plugin_circle_progressbar_creativePluginProgressCircleText);
            this.mTextSize = array.getDimension(R.styleable.creative_plugin_circle_progressbar_creativePluginProgressCircleTextSize, getResources().getDimension(R.dimen.creative_plugin_circle_progressbar_text_size_default));
            this.mTextColor = array.getColor(R.styleable.creative_plugin_circle_progressbar_creativePluginProgressCircleTextColor, getResources().getColor(R.color.creative_plugin_load_txt_color));
            array.recycle();
        } else {
            this.mCircleWidth = getResources().getDimension(R.dimen.creative_plugin_circle_progressbar_circle_width_default);
            this.mCircleColor = getResources().getColor(R.color.creative_plugin_load_circle_color);
            this.mProgressColor = getResources().getColor(R.color.creative_plugin_load_txt_color);
            this.mTextSize = getResources().getDimension(R.dimen.creative_plugin_circle_progressbar_text_size_default);
            this.mTextColor = getResources().getColor(R.color.creative_plugin_load_txt_color);
        }
        this.mPaint.setStrokeWidth(this.mCircleWidth);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mRadius = (((float) getWidth()) / 2.0f) - this.mCircleWidth;
        this.mCenterX = (float) (getWidth() / 2);
        this.mCenterY = (float) (getHeight() / 2);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mCircleColor);
        canvas.drawCircle(this.mCenterX, this.mCenterY, this.mRadius, this.mPaint);
        this.mPaint.setColor(this.mProgressColor);
        float f2 = this.mCenterX;
        float f3 = this.mRadius;
        float f4 = this.mCenterY;
        canvas.drawArc(new RectF(f2 - f3, f4 - f3, f2 + f3, f4 + f3), -90.0f, (((float) this.mProgress) * 360.0f) / 100.0f, false, this.mPaint);
        if (this.mText != null) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mTextColor);
            this.mPaint.setTextSize(this.mTextSize);
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
            canvas.drawText(this.mText, this.mCenterX, (this.mCenterY + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom, this.mPaint);
        }
    }
}
