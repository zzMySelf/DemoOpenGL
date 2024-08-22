package com.baidu.sapi2.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import com.baidu.sapi2.SapiWebView;
import com.tera.scan.app.R$styleable;

public class RoundWebview extends SapiWebView {
    public float a = 0.0f;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    public int e;
    public int f;
    public int g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f963i;
    public Paint j;
    public float[] k = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    public RoundWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f963i = paint;
        paint.setColor(-1);
        this.f963i.setAntiAlias(true);
        this.f963i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setXfermode((Xfermode) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.sapi_sdk_RoundWebview);
        this.a = obtainStyledAttributes.getDimension(2, 0.0f);
        this.b = obtainStyledAttributes.getDimension(3, 0.0f);
        this.c = obtainStyledAttributes.getDimension(0, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(1, 0.0f);
        this.d = dimension;
        a(this.a, this.b, dimension, this.c);
    }

    public void onDraw(Canvas canvas) {
        this.g = getScrollX();
        this.h = getScrollY();
        Path path = new Path();
        int i2 = this.h;
        path.addRoundRect(new RectF(0.0f, (float) i2, (float) (this.g + this.e), (float) (i2 + this.f)), this.k, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.e = getMeasuredWidth();
        this.f = getMeasuredHeight();
    }

    public RoundWebview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.k;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f4;
        fArr[6] = f5;
        fArr[7] = f5;
    }
}
