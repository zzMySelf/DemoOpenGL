package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;

public class RefreshLoadingDrawable extends Drawable {
    public static final String a = "RefreshLoadingView";
    public Paint b = new Paint();
    public Paint c = new Paint();
    public int d;
    public int e;
    public int f;
    public RectF g = new RectF();
    public Path h = new Path();

    /* renamed from: i  reason: collision with root package name */
    public int f3543i;
    public Context j;

    public RefreshLoadingDrawable(Context context, int i2, int i3) {
        i2 = i2 < 0 ? 0 : i2;
        this.d = i3;
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(context);
        this.j = applicationContext;
        int dip2px = DisplayUtils.dip2px(applicationContext, 1.0f);
        this.e = dip2px;
        int i4 = i2 + (dip2px * 2);
        this.f3543i = i4;
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setColor(this.d);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeJoin(Paint.Join.ROUND);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setStrokeWidth((float) this.e);
        this.c.set(this.b);
        RectF rectF = this.g;
        int i5 = this.e;
        int i6 = this.f3543i;
        rectF.set((float) i5, (float) i5, (float) (i6 - i5), (float) (i6 - i5));
        this.h.reset();
        float f2 = (float) i4;
        float f3 = 0.5f * f2;
        float f4 = 0.25f * f2;
        this.h.moveTo(f3, f4);
        float f5 = f2 * 0.75f;
        this.h.lineTo(f5, f3);
        this.h.lineTo(f3, f5);
        this.h.lineTo(f4, f3);
        this.h.close();
    }

    public static RefreshLoadingDrawable newInstanceBlue(Context context) {
        return new RefreshLoadingDrawable(context, DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(context), 18.0f), ResUtils.getColor(context, "wallet_base_font_text8Color"));
    }

    public static RefreshLoadingDrawable newInstanceRed(Context context) {
        return new RefreshLoadingDrawable(context, DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(context), 18.0f), ResUtils.getColor(context, "wallet_base_font_text6Color"));
    }

    public static RefreshLoadingDrawable newInstanceWhite(Context context) {
        return new RefreshLoadingDrawable(context, DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(context), 18.0f), ResUtils.getColor(context, "wallet_base_whiteColor"));
    }

    public void draw(Canvas canvas) {
        canvas.drawArc(this.g, -90.0f, (((float) this.f) * 360.0f) / 100.0f, false, this.b);
        if (this.f >= 100) {
            this.c.setColor(this.d);
            canvas.drawPath(this.h, this.c);
        }
    }

    public int getIntrinsicHeight() {
        return this.f3543i;
    }

    public int getIntrinsicWidth() {
        return this.f3543i;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setProgress(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 100) {
            i2 = 100;
        }
        if (this.f != i2) {
            this.f = i2;
        }
    }
}
