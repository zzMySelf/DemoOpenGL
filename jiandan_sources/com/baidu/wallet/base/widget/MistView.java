package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MistView extends FrameLayout {
    public static final int MASK_COLOR_DEFAULT_TRANSPARENT = Color.argb(127, 0, 0, 0);
    public static final long a = 100;
    public final Paint b = new Paint();
    public int c = MASK_COLOR_DEFAULT_TRANSPARENT;
    public final Rect d = new Rect();

    public MistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Rect getFocusFrame() {
        return this.d;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.b.setColor(this.c);
        if (this.d.width() != 0) {
            float f = (float) width;
            canvas.drawRect(0.0f, 0.0f, f, (float) this.d.top, this.b);
            Rect rect = this.d;
            canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) rect.bottom, this.b);
            Rect rect2 = this.d;
            Canvas canvas2 = canvas;
            float f2 = f;
            canvas2.drawRect((float) rect2.right, (float) rect2.top, f2, (float) rect2.bottom, this.b);
            canvas2.drawRect(0.0f, (float) this.d.bottom, f2, (float) height, this.b);
            Rect rect3 = this.d;
            postInvalidateDelayed(100, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
    }

    public void setMistColor(int i2) {
        this.c = i2;
        postInvalidate();
    }
}
