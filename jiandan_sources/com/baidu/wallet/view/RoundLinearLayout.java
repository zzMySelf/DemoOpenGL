package com.baidu.wallet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.core.utils.LogUtil;
import com.tera.scan.app.R$styleable;

public class RoundLinearLayout extends LinearLayout {
    public static float[] HALF_RADII = {20.0f, 20.0f, 20.0f, 20.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public static float[] RECT_RADII = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public float a;
    public Path b;
    public RectF c;
    public Paint d;
    public float[] e;

    public RoundLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundLinearLayouts);
            float dimension = obtainStyledAttributes.getDimension(0, this.a);
            this.a = dimension;
            this.e = new float[]{dimension, dimension, dimension, dimension, dimension, dimension, dimension, dimension};
            float dimension2 = obtainStyledAttributes.getDimension(1, 0.0f);
            if (dimension2 != 0.0f) {
                Paint paint = new Paint();
                this.d = paint;
                paint.setAntiAlias(true);
                this.d.setStrokeWidth(dimension2);
                this.d.setStyle(Paint.Style.STROKE);
                this.d.setColor(Color.parseColor("#ffffff"));
            }
            obtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
        this.b = new Path();
        this.c = new RectF();
    }

    public void draw(Canvas canvas) {
        try {
            canvas.clipPath(this.b);
        } catch (Exception unused) {
            LogUtil.d("don't support clipPath");
        }
        super.draw(canvas);
        Paint paint = this.d;
        if (paint != null) {
            RectF rectF = this.c;
            float f = this.a;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.c.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        a();
    }

    public void setRoundLayoutRadius(float f) {
        this.a = f;
        this.e = new float[]{f, f, f, f, f, f, f, f};
        a();
        postInvalidate();
    }

    public void setRoundPath(float[] fArr) {
        if (fArr != null && fArr.length == 8) {
            this.e = fArr;
            a();
            postInvalidate();
        }
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float dip2px = (float) DisplayUtils.dip2px(BaiduWalletDelegate.getInstance().getAppContext(), 12.0f);
        this.a = dip2px;
        this.e = new float[]{dip2px, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px};
        a(context, attributeSet);
    }

    private void a() {
        this.b.reset();
        this.b.addRoundRect(this.c, this.e, Path.Direction.CW);
    }
}
