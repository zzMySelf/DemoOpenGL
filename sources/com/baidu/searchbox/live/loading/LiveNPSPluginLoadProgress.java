package com.baidu.searchbox.live.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.baidu.searchbox.nps.live.R;

public class LiveNPSPluginLoadProgress extends View {
    private float mMaxWidth;
    private int max;
    private RectF oval;
    private Paint paint;
    private int progress;
    private int progressColor;
    private float progressWidth;
    private int roundColor;
    private float roundWidth;
    private int startAngle;

    public LiveNPSPluginLoadProgress(Context context) {
        this(context, (AttributeSet) null);
    }

    public LiveNPSPluginLoadProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LiveNPSPluginLoadProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.paint = new Paint();
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LivePluginYYCircleProgress, defStyleAttr, 0);
        initByAttributes(attributes);
        attributes.recycle();
        this.oval = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* access modifiers changed from: protected */
    public void initByAttributes(TypedArray attributes) {
        this.roundColor = attributes.getColor(R.styleable.LivePluginYYCircleProgress_yy_circle_round_color, SupportMenu.CATEGORY_MASK);
        this.progressColor = attributes.getColor(R.styleable.LivePluginYYCircleProgress_yy_circle_progress_color, -16711936);
        this.max = attributes.getInt(R.styleable.LivePluginYYCircleProgress_yy_circle_max, 100);
        this.startAngle = attributes.getInt(R.styleable.LivePluginYYCircleProgress_yy_circle_angle, 0);
        this.roundWidth = attributes.getDimension(R.styleable.LivePluginYYCircleProgress_yy_circle_round_width, 1.0f);
        float dimension = attributes.getDimension(R.styleable.LivePluginYYCircleProgress_yy_circle_progress_width, 2.0f);
        this.progressWidth = dimension;
        this.mMaxWidth = Math.max(this.roundWidth, dimension);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float centerX = ((float) getWidth()) / 2.0f;
        float radius = centerX - (this.mMaxWidth / 2.0f);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(Color.parseColor("#00FFFFFF"));
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(centerX, centerX, radius, this.paint);
        this.paint.setStrokeWidth(this.progressWidth);
        this.paint.setColor(this.progressColor);
        this.oval.set(centerX - radius, centerX - radius, centerX + radius, centerX + radius);
        int sweepAngle = (this.progress * 360) / this.max;
        canvas.drawArc(this.oval, (float) this.startAngle, (float) sweepAngle, false, this.paint);
        this.paint.setColor(this.roundColor);
        this.paint.setStrokeWidth(this.roundWidth);
        RectF rectF = this.oval;
        int i2 = this.startAngle;
        canvas.drawArc(rectF, (float) (i2 + sweepAngle), (float) (630 - (i2 + sweepAngle)), false, this.paint);
    }

    public synchronized void setMax(int max2) {
        if (max2 >= 0) {
            this.max = max2;
        }
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public synchronized void setProgress(int progress2) {
        if (progress2 >= 0) {
            int i2 = this.max;
            if (progress2 > i2) {
                progress2 = i2;
            }
            this.progress = progress2;
            postInvalidate();
        }
    }
}
