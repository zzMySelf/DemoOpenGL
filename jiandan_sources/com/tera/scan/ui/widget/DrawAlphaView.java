package com.tera.scan.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class DrawAlphaView extends View {
    public Paint paint;

    public DrawAlphaView(Context context) {
        super(context);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(-16777216);
        this.paint.setAlpha(0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(this.paint);
    }

    public void setAlpha(float f) {
        this.paint.setAlpha((int) (f * 255.0f));
        invalidate();
    }

    public DrawAlphaView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(-16777216);
        this.paint.setAlpha(0);
    }

    public DrawAlphaView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(-16777216);
        this.paint.setAlpha(0);
    }
}
