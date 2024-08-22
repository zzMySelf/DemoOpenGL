package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.tera.scan.app.R$styleable;

public class RoundedCornerLayout extends FrameLayout {
    public static final float CORNER_RADIUS = 4.0f;
    public float cornerRadius;
    public Bitmap maskBitmap;
    public Paint maskPaint;
    public Paint paint;

    public RoundedCornerLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    private Bitmap createMask(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        float f = (float) i2;
        float f2 = (float) i3;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint2);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        float f3 = this.cornerRadius;
        canvas.drawRoundRect(rectF, f3, f3, paint2);
        return createBitmap;
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.RoundedCornerLayout);
        float f = 4.0f;
        if (obtainStyledAttributes.hasValue(0)) {
            f = obtainStyledAttributes.getFloat(0, 4.0f);
        }
        obtainStyledAttributes.recycle();
        this.cornerRadius = TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        this.paint = new Paint(1);
        Paint paint2 = new Paint(3);
        this.maskPaint = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        if (this.maskBitmap == null) {
            this.maskBitmap = createMask(canvas.getWidth(), canvas.getHeight());
        }
        canvas2.drawBitmap(this.maskBitmap, 0.0f, 0.0f, this.maskPaint);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.paint);
    }

    public RoundedCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public RoundedCornerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet, i2);
    }
}
