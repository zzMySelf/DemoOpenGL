package com.baidu.nadcore.download.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.model.AdDownloadBean;
import com.baidu.nadcore.download.presenter.IAdDownloadView;
import com.baidu.nadcore.uad.R;
import com.baidu.nadcore.utils.DeviceUtils;

public class AdProgressButton extends View implements IAdDownloadView<AdProgressButton> {
    protected int mForegroundColor;
    protected Paint mForegroundPaint;
    protected int mMax = 100;
    protected int mProgress = 0;
    protected int mRadius = 0;
    private String mText;
    private int mTextColor = -1;
    private Typeface mTextFace;
    private Paint mTextPaint;
    private float mTextSize = 10.0f;
    protected int strokeWidth = 0;

    public AdProgressButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public AdProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AdProgressButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.nad_progress);
        int defaultTextColor = getResources().getColor(R.color.nad_progress_download_button_text_color);
        int defaultFgColor = getResources().getColor(R.color.nad_progress_download_button_fg);
        int defaultTextSize = DeviceUtils.ScreenInfo.dp2px(getContext(), 11.0f);
        int defaultRadian = DeviceUtils.ScreenInfo.dp2px(getContext(), 12.0f);
        this.strokeWidth = 1;
        this.mForegroundColor = typedArray.getInteger(R.styleable.nad_progress_nad_btn_foreground, defaultFgColor);
        this.mTextColor = typedArray.getColor(R.styleable.nad_progress_nad_btn_textColor, defaultTextColor);
        this.mMax = typedArray.getInteger(R.styleable.nad_progress_nad_btn_max, this.mMax);
        this.mProgress = typedArray.getInteger(R.styleable.nad_progress_nad_btn_progress, 0);
        this.mText = typedArray.getString(R.styleable.nad_progress_nad_btn_text);
        this.mTextSize = typedArray.getDimension(R.styleable.nad_progress_nad_btn_textSize, (float) defaultTextSize);
        this.mRadius = typedArray.getDimensionPixelSize(R.styleable.nad_progress_nad_btn_radius, defaultRadian);
        typedArray.recycle();
        this.mTextFace = Typeface.defaultFromStyle(1);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.nad_feed_download_btn_bg));
        initPaint();
    }

    /* access modifiers changed from: protected */
    public void initPaint() {
        this.mForegroundPaint = new Paint();
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTypeface(this.mTextFace);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawProgressView(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.mText, (((float) getMeasuredWidth()) - this.mTextPaint.measureText(this.mText)) / 2.0f, (((float) (getHeight() / 2)) - fontMetrics.descent) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f), this.mTextPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawProgressView(Canvas canvas) {
        if (this.mProgress > 0) {
            int left = this.strokeWidth;
            int top = this.strokeWidth;
            int right = getMeasuredWidth() - this.strokeWidth;
            int bottom = getMeasuredHeight() - this.strokeWidth;
            float progressPercent = ((float) this.mProgress) / (((float) this.mMax) + 0.0f);
            RectF oval = new RectF((float) left, (float) top, (float) right, (float) bottom);
            Paint paint = this.mForegroundPaint;
            LinearGradient linearGradient = r9;
            LinearGradient linearGradient2 = new LinearGradient((float) left, 0.0f, (float) right, 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{progressPercent, progressPercent + 0.001f}, Shader.TileMode.CLAMP);
            paint.setShader(linearGradient);
            int i2 = this.mRadius;
            canvas.drawRoundRect(oval, (float) i2, (float) i2, this.mForegroundPaint);
            return;
        }
        Canvas canvas2 = canvas;
    }

    public void setMax(int max) {
        this.mMax = max;
    }

    public void setText(String text) {
        this.mText = text;
        postInvalidate();
    }

    public void setForeground(int color) {
        this.mForegroundColor = color;
        initPaint();
        postInvalidate();
    }

    public void setTextSize(int size) {
        this.mTextSize = (float) size;
        initPaint();
        postInvalidate();
    }

    public void setTextColor(int color) {
        this.mTextColor = color;
        initPaint();
        postInvalidate();
    }

    public void setProgress(int progress) {
        if (progress <= this.mMax) {
            this.mProgress = progress;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public void setProgressNoText(int progress) {
        if (progress <= this.mMax) {
            this.mProgress = progress;
            this.mText = "";
            postInvalidate();
        }
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setRadius(int radius) {
        this.mRadius = radius;
    }

    public AdProgressButton getRealView() {
        return this;
    }

    public void bind(ViewGroup parent) {
        if (parent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
            params.addRule(13, -1);
            parent.addView(this, params);
            parent.setVisibility(0);
        }
    }

    public void update(String text, AdDownloadBean data) {
        if (data.status == AdDownloadStatus.DOWNLOADING) {
            setProgress((int) (data.progress * 100.0f));
            return;
        }
        setProgressNoText(0);
        setText(text);
    }
}
