package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MistView extends FrameLayout {
    public static final int MASK_COLOR_DEFAULT_TRANSPARENT = Color.argb(127, 0, 0, 0);
    public final Paint a = new Paint();
    public int b = MASK_COLOR_DEFAULT_TRANSPARENT;
    public final Rect c = new Rect();

    public MistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Rect getFocusFrame() {
        return this.c;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.a.setColor(this.b);
        if (this.c.width() != 0) {
            float f = (float) width;
            canvas.drawRect(0.0f, 0.0f, f, (float) this.c.top, this.a);
            Rect rect = this.c;
            canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) rect.bottom, this.a);
            Rect rect2 = this.c;
            Canvas canvas2 = canvas;
            float f2 = f;
            canvas2.drawRect((float) rect2.right, (float) rect2.top, f2, (float) rect2.bottom, this.a);
            canvas2.drawRect(0.0f, (float) this.c.bottom, f2, (float) height, this.a);
            Rect rect3 = this.c;
            postInvalidateDelayed(100, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
    }

    public void setMistColor(int i2) {
        this.b = i2;
        postInvalidate();
    }
}
