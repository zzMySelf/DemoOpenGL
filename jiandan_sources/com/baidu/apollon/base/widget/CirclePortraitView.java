package com.baidu.apollon.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CirclePortraitView extends NetImageView {
    public final Paint a = new Paint();
    public final Paint b = new Paint();
    public final RectF c = new RectF();
    public float d;
    public float e;

    public CirclePortraitView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        this.a.setAntiAlias(true);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.b.setAntiAlias(true);
        this.b.setColor(-1);
    }

    public void draw(Canvas canvas) {
        canvas.saveLayer(this.c, this.b, 31);
        float f = this.d;
        canvas.drawCircle(f / 2.0f, this.e / 2.0f, f / 2.0f, this.b);
        canvas.saveLayer(this.c, this.a, 31);
        super.draw(canvas);
        canvas.restore();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.d = (float) getWidth();
        float height = (float) getHeight();
        this.e = height;
        this.c.set(0.0f, 0.0f, this.d, height);
    }

    public CirclePortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public CirclePortraitView(Context context) {
        super(context);
        c();
    }
}
