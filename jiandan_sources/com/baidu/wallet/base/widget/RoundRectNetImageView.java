package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;

public class RoundRectNetImageView extends NetImageView {
    public String a = RoundRectNetImageView.class.getName();
    public int b;
    public int c;
    public int d;
    public Bitmap e;
    public Paint f;
    public Paint g;
    public final Matrix h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    public boolean f1151i = true;
    public int j = 0;
    public int k = 0;

    public RoundRectNetImageView(Context context) {
        super(context);
        c();
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f1151i = true;
        this.j = -1;
    }

    private int b(int i2) {
        return View.MeasureSpec.getMode(i2) == 1073741824 ? View.MeasureSpec.getSize(i2) : this.c;
    }

    private void c() {
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setAntiAlias(true);
        this.h.set((Matrix) null);
        this.h.postTranslate((float) this.b, (float) this.c);
        this.d = DisplayUtils.dip2px(getContext(), 39.0f);
    }

    private void d() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        if (bitmapDrawable == null) {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(this.k);
        }
        if (bitmapDrawable != null) {
            this.e = bitmapDrawable.getBitmap();
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.f1151i) {
            d();
            if (this.e != null) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.e, this.b, this.c, false);
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(createScaledBitmap, tileMode, tileMode);
                bitmapShader.setLocalMatrix(this.h);
                this.f.setShader(bitmapShader);
            } else {
                return;
            }
        } else {
            this.f.setColor(this.j);
        }
        Path path = new Path();
        path.moveTo((float) this.d, 0.0f);
        path.lineTo((float) (this.b - this.d), 0.0f);
        int i2 = this.b;
        path.quadTo((float) i2, 0.0f, (float) i2, (float) this.d);
        path.lineTo((float) this.b, (float) (this.c - this.d));
        int i3 = this.b;
        int i4 = this.c;
        path.quadTo((float) i3, (float) i4, (float) (i3 - this.d), (float) i4);
        path.lineTo((float) this.d, (float) this.c);
        int i5 = this.c;
        path.quadTo(0.0f, (float) i5, 0.0f, (float) (i5 - this.d));
        path.lineTo(0.0f, (float) this.d);
        path.quadTo(0.0f, 0.0f, (float) this.d, 0.0f);
        path.close();
        canvas.drawPath(path, this.f);
    }

    public void onMeasure(int i2, int i3) {
        int a2 = a(i2);
        int b2 = b(i3);
        this.b = a2;
        this.c = b2;
        setMeasuredDimension(a2, b2);
    }

    public void setBackgroudColor(int i2) {
        this.j = i2;
    }

    public void setCornerSize(int i2) {
        this.d = i2;
    }

    public void setResId(int i2) {
        setImageResource(0);
        setImageResource(i2);
        invalidate();
    }

    private int a(int i2) {
        return View.MeasureSpec.getMode(i2) == 1073741824 ? View.MeasureSpec.getSize(i2) : this.b;
    }

    public RoundRectNetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
        c();
    }

    public RoundRectNetImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
        c();
    }
}
