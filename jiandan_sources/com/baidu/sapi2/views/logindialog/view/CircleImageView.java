package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tera.scan.app.R$styleable;

public class CircleImageView extends ImageView {
    public static final ImageView.ScaleType p = ImageView.ScaleType.CENTER_CROP;
    public static final Bitmap.Config q = Bitmap.Config.ARGB_8888;
    public static final int r = 1;
    public static final int s = 0;
    public static final int t = -16777216;
    public final RectF a;
    public final RectF b;
    public final Matrix c;
    public final Paint d;
    public final Paint e;
    public int f;
    public int g;
    public Bitmap h;

    /* renamed from: i  reason: collision with root package name */
    public BitmapShader f982i;
    public int j;
    public int k;
    public float l;
    public float m;
    public boolean n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f983o;

    public CircleImageView(Context context) {
        super(context);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = -16777216;
        this.g = 0;
        a();
    }

    private void a() {
        super.setScaleType(p);
        this.n = true;
        if (this.f983o) {
            b();
            this.f983o = false;
        }
    }

    private void b() {
        if (!this.n) {
            this.f983o = true;
            return;
        }
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f982i = new BitmapShader(bitmap, tileMode, tileMode);
            this.d.setAntiAlias(true);
            this.d.setShader(this.f982i);
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setAntiAlias(true);
            this.e.setColor(this.f);
            this.e.setStrokeWidth((float) this.g);
            this.k = this.h.getHeight();
            this.j = this.h.getWidth();
            this.b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.m = Math.min((this.b.height() - ((float) this.g)) / 2.0f, (this.b.width() - ((float) this.g)) / 2.0f);
            RectF rectF = this.a;
            float f2 = (float) this.g;
            rectF.set(f2, f2, this.b.width() - ((float) this.g), this.b.height() - ((float) this.g));
            this.l = Math.min(this.a.height() / 2.0f, this.a.width() / 2.0f);
            c();
            invalidate();
        }
    }

    private void c() {
        float f2;
        float f3;
        this.c.set((Matrix) null);
        float f4 = 0.0f;
        if (((float) this.j) * this.a.height() > this.a.width() * ((float) this.k)) {
            f3 = this.a.height() / ((float) this.k);
            f4 = (this.a.width() - (((float) this.j) * f3)) * 0.5f;
            f2 = 0.0f;
        } else {
            f3 = this.a.width() / ((float) this.j);
            f2 = (this.a.height() - (((float) this.k) * f3)) * 0.5f;
        }
        this.c.setScale(f3, f3);
        Matrix matrix = this.c;
        int i2 = this.g;
        matrix.postTranslate((float) (((int) (f4 + 0.5f)) + i2), (float) (((int) (f2 + 0.5f)) + i2));
        this.f982i.setLocalMatrix(this.c);
    }

    public int getBorderColor() {
        return this.f;
    }

    public int getBorderWidth() {
        return this.g;
    }

    public ImageView.ScaleType getScaleType() {
        return p;
    }

    public void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.l, this.d);
            if (this.g != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.m, this.e);
            }
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        b();
    }

    public void setBorderColor(int i2) {
        if (i2 != this.f) {
            this.f = i2;
            this.e.setColor(i2);
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.g) {
            this.g = i2;
            b();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.h = a(drawable);
        b();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        this.h = a(getDrawable());
        b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.h = a(getDrawable());
        b();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    private Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(1, 1, q);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), q);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = -16777216;
        this.g = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.sapi_sdk_circle_image_view, i2, 0);
        this.g = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f = obtainStyledAttributes.getColor(0, -16777216);
        obtainStyledAttributes.recycle();
        a();
    }
}
