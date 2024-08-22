package com.tera.scan.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.baidu.aiscan.R;

public class WebProgressBar extends ProgressBar {
    public static final int MIN_PERCENT = 10;
    public Paint paint;
    public int percent;

    public WebProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        if (this.percent < 100) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, (((float) getMeasuredWidth()) * ((float) Math.max(this.percent, 10))) / 100.0f, (float) getMeasuredHeight(), this.paint);
        }
    }

    public synchronized void setProgress(int i2) {
        this.percent = i2;
        postInvalidate();
    }

    public void setTintColor(int i2) {
        this.paint.setColor(i2);
    }

    public WebProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.percent = 10;
        int color = getResources().getColor(R.color.green);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setColor(color);
    }

    public WebProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.percent = 10;
    }
}
