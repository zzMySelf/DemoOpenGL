package com.tera.scan.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;

public class TextProgressbar extends ProgressBar {
    public static final String TAG = "TextProgressbar";
    public Paint mPaint;
    public Rect mRect;
    public String mText;
    public float mTextSize = 24.0f;

    public TextProgressbar(Context context) {
        super(context);
        initText();
    }

    private void initText() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mRect = new Rect();
    }

    public void onDraw(Canvas canvas) {
        Resources resources;
        super.onDraw(canvas);
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        this.mPaint.setTextSize(TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics()));
        Paint paint = this.mPaint;
        String str = this.mText;
        paint.getTextBounds(str, 0, str.length(), this.mRect);
        canvas.drawText(this.mText, (float) ((getWidth() / 2) - this.mRect.centerX()), (float) ((getHeight() / 2) - this.mRect.centerY()), this.mPaint);
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
    }

    public TextProgressbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initText();
    }

    public TextProgressbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initText();
    }
}
