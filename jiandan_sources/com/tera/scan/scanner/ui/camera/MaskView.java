package com.tera.scan.scanner.ui.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.aiscan.R;
import java.io.File;

public class MaskView extends View {
    public static final int MASK_TYPE_BANK_CARD = 11;
    public static final int MASK_TYPE_ID_CARD_BACK = 2;
    public static final int MASK_TYPE_ID_CARD_FRONT = 1;
    public static final int MASK_TYPE_NONE = 0;
    public static final int MASK_TYPE_OCR = 12;
    public Paint eraser = new Paint(1);
    public Rect frame = new Rect();
    public int lineColor = -1;
    public Drawable locatorDrawable;
    public int maskColor = Color.argb(100, 0, 0, 0);
    public int maskType = 1;
    public Path path = new Path();
    public Paint pen = new Paint(1);

    public MaskView(Context context) {
        super(context);
        setLayerType(1, (Paint) null);
        this.pen.setColor(-1);
        this.pen.setStyle(Paint.Style.STROKE);
        this.pen.setStrokeWidth(6.0f);
        this.eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }

    private double calculateRate() {
        int integer = getContext().getResources().getInteger(R.integer.image_view_margin);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        return (double) ((((float) getContext().getResources().getInteger(R.integer.crop_image_view_height)) / f) / ((float) (((int) (((float) displayMetrics.widthPixels) / f)) - (integer * 2))));
    }

    private void capture(File file) {
    }

    private Path fillRectRound(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        this.path.reset();
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        float f7 = f3 - f;
        float f8 = f4 - f2;
        float f9 = f7 / 2.0f;
        if (f5 > f9) {
            f5 = f9;
        }
        float f10 = f8 / 2.0f;
        if (f6 > f10) {
            f6 = f10;
        }
        float f11 = f7 - (f5 * 2.0f);
        float f12 = f8 - (2.0f * f6);
        this.path.moveTo(f3, f2 + f6);
        float f13 = -f6;
        float f14 = -f5;
        this.path.rQuadTo(0.0f, f13, f14, f13);
        this.path.rLineTo(-f11, 0.0f);
        this.path.rQuadTo(f14, 0.0f, f14, f6);
        this.path.rLineTo(0.0f, f12);
        if (z) {
            this.path.rLineTo(0.0f, f6);
            this.path.rLineTo(f7, 0.0f);
            this.path.rLineTo(0.0f, f13);
        } else {
            this.path.rQuadTo(0.0f, f6, f5, f6);
            this.path.rLineTo(f11, 0.0f);
            this.path.rQuadTo(f5, 0.0f, f5, f13);
        }
        this.path.rLineTo(0.0f, -f12);
        this.path.close();
        return this.path;
    }

    private void init() {
        this.locatorDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, (Resources.Theme) null);
    }

    public Rect getFrameRect() {
        int i2 = this.maskType;
        if (i2 == 0 || i2 == 12) {
            return new Rect(0, 0, getWidth(), getHeight());
        }
        return new Rect(this.frame);
    }

    public int getMaskType() {
        return this.maskType;
    }

    @RequiresApi(api = 21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.frame.width();
        int height = this.frame.height();
        Rect rect = this.frame;
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        canvas.drawColor(this.maskColor);
        float f = (float) i2;
        float f2 = (float) i3;
        float f3 = (float) i5;
        fillRectRound(f, f2, (float) i4, f3, 30.0f, 30.0f, false);
        canvas.drawPath(this.path, this.pen);
        canvas.drawPath(this.path, this.eraser);
        int i6 = this.maskType;
        if (i6 == 1) {
            float f4 = (float) width;
            float f5 = (float) height;
            this.locatorDrawable.setBounds((int) ((0.5974155f * f4) + f), (int) ((0.17405063f * f5) + f2), (int) (f + (f4 * 0.95725644f)), (int) (f2 + (f5 * 0.7531645f)));
        } else if (i6 == 2) {
            float f6 = (float) width;
            float f7 = (float) height;
            this.locatorDrawable.setBounds((int) ((0.050695825f * f6) + f), (int) ((0.07594936f * f7) + f2), (int) (f + (f6 * 0.24850895f)), (int) (f2 + (f7 * 0.41455695f)));
        }
        Drawable drawable = this.locatorDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 > 0 && i3 > 0) {
            int i6 = (int) (((float) i2) * (i3 > i2 ? 0.9f : 0.72f));
            int calculateRate = (int) (((double) i6) * calculateRate());
            int i7 = (i2 - i6) / 2;
            int i8 = (i3 - calculateRate) / 2;
            Rect rect = this.frame;
            rect.left = i7;
            rect.top = i8;
            rect.right = i6 + i7;
            rect.bottom = calculateRate + i8;
        }
    }

    public void setLineColor(int i2) {
        this.lineColor = i2;
    }

    public void setMaskColor(int i2) {
        this.maskColor = i2;
    }

    public void setMaskType(int i2) {
        this.maskType = i2;
        if (i2 == 1) {
            this.locatorDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_front, (Resources.Theme) null);
        } else if (i2 == 2) {
            this.locatorDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.bd_ocr_id_card_locator_back, (Resources.Theme) null);
        }
        invalidate();
    }

    public void setOrientation(int i2) {
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, (Paint) null);
        this.pen.setColor(-1);
        this.pen.setStyle(Paint.Style.STROKE);
        this.pen.setStrokeWidth(6.0f);
        this.eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }

    public MaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayerType(1, (Paint) null);
        this.pen.setColor(-1);
        this.pen.setStyle(Paint.Style.STROKE);
        this.pen.setStrokeWidth(6.0f);
        this.eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        init();
    }
}
