package com.baidu.nadcore.download.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.nadcore.uad.R;

public class BannerDownloadView extends AppCompatTextView {
    private static final float DEFAULT_PROGRESS = 0.0f;
    private final Paint mBoundsPaint = new Paint();
    private final RectF mBoundsRectf = new RectF();
    private int mForegroundColorEnd;
    private int mForegroundColorStart;
    private final Paint mForegroundPaint = new Paint();
    private float mMaxProgress = 1.0f;
    private float mProgress = 0.0f;
    private final RectF mProgressRectf = new RectF();
    private int mRadius = 0;
    private String mText;
    private int mTextColor = -1;
    private final Paint mTextPaint = new Paint();
    private float mTextSize = 10.0f;
    private int strokeWidth = 0;

    public BannerDownloadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BannerDownloadView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.nad_progress);
        int defaultTextColor = getResources().getColor(R.color.nad_download_button_text_color);
        int defaultFgColor = getResources().getColor(R.color.nad_download_button_fg_start);
        int defaultRadian = getResources().getDimensionPixelSize(R.dimen.nad_progress_button_radian);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.nad_progress_button_frame);
        this.mForegroundColorStart = typedArray.getInteger(R.styleable.nad_progress_nad_btn_foreground, defaultFgColor);
        this.mForegroundColorEnd = typedArray.getColor(R.styleable.nad_progress_nad_btn_foreground_end, getResources().getColor(R.color.nad_download_button_fg_end));
        this.mTextColor = typedArray.getColor(R.styleable.nad_progress_nad_btn_textColor, defaultTextColor);
        this.mMaxProgress = typedArray.getFloat(R.styleable.nad_progress_nad_btn_max, this.mMaxProgress);
        this.mProgress = typedArray.getFloat(R.styleable.nad_progress_nad_btn_progress, 0.0f);
        this.mText = typedArray.getString(R.styleable.nad_progress_nad_btn_text);
        this.mTextSize = typedArray.getDimension(R.styleable.nad_progress_nad_btn_textSize, (float) ((int) getResources().getDimension(R.dimen.nad_progress_button_font_size)));
        this.mRadius = typedArray.getDimensionPixelSize(R.styleable.nad_progress_nad_btn_radius, defaultRadian);
        typedArray.recycle();
        initPaint();
    }

    private void initPaint() {
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.mBoundsPaint.setAntiAlias(true);
        this.mBoundsPaint.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0.0f) {
            drawProgress(canvas);
        }
        drawBounds(canvas);
        if (!TextUtils.isEmpty(this.mText)) {
            drawText(canvas);
        }
    }

    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float textCenterVerticalBaseX = (((float) getMeasuredWidth()) - this.mTextPaint.measureText(this.mText)) / 2.0f;
        canvas.drawText(this.mText, textCenterVerticalBaseX, (float) (((double) ((((float) (getHeight() / 2)) - fontMetrics.descent) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f))) + 0.5d), this.mTextPaint);
    }

    private void drawBounds(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.mBoundsRectf.left = 0.0f;
        this.mBoundsRectf.top = 0.0f;
        this.mBoundsRectf.right = (float) getMeasuredWidth();
        this.mBoundsRectf.bottom = (float) getMeasuredHeight();
        this.mBoundsPaint.setStrokeWidth((float) this.strokeWidth);
        this.mBoundsPaint.setColor(Color.parseColor("#E5E5E5"));
        RectF rectF = this.mBoundsRectf;
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.mBoundsPaint);
    }

    private void drawProgress(Canvas canvas) {
        this.mRadius = getMeasuredHeight() / 2;
        this.mProgressRectf.left = (float) this.strokeWidth;
        this.mProgressRectf.top = (float) this.strokeWidth;
        this.mProgressRectf.bottom = (float) (getMeasuredHeight() - this.strokeWidth);
        this.mProgressRectf.right = ((float) getMeasuredWidth()) * this.mProgress;
        float f2 = this.mProgressRectf.right;
        int i2 = this.mRadius;
        if (f2 < ((float) (i2 * 2))) {
            this.mProgressRectf.right = (float) (i2 * 2);
        }
        this.mForegroundPaint.setShader(new LinearGradient(0.0f, 0.0f, this.mProgressRectf.right, 0.0f, new int[]{this.mForegroundColorStart, this.mForegroundColorEnd}, (float[]) null, Shader.TileMode.CLAMP));
        RectF rectF = this.mProgressRectf;
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, this.mForegroundPaint);
    }

    public void setText(String text) {
        if (text != null && !text.equals(this.mText)) {
            this.mText = text;
            postInvalidate();
        }
    }

    public void setTextColor(int color) {
        if (color != this.mTextColor) {
            this.mTextColor = color;
            initPaint();
            postInvalidate();
        }
    }

    public void setProgress(float progress) {
        if (progress >= 0.0f && progress <= this.mMaxProgress && progress != this.mProgress) {
            this.mProgress = progress;
            postInvalidate();
        }
    }
}
