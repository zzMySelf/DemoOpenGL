package com.baidu.nadcore.widget.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007JR\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/nadcore/widget/util/NadDynamicDrawableSpan;", "Landroid/text/style/DynamicDrawableSpan;", "rawDrawable", "Landroid/graphics/drawable/Drawable;", "fontSize", "", "drawableSize", "(Landroid/graphics/drawable/Drawable;II)V", "biasTop", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getDrawable", "nadcore-lib-widget"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDynamicDrawableSpan.kt */
public final class NadDynamicDrawableSpan extends DynamicDrawableSpan {
    private int biasTop;
    private final int drawableSize;
    private final int fontSize;
    private final Drawable rawDrawable;

    public NadDynamicDrawableSpan(Drawable rawDrawable2, int fontSize2, int drawableSize2) {
        Intrinsics.checkNotNullParameter(rawDrawable2, "rawDrawable");
        this.rawDrawable = rawDrawable2;
        this.fontSize = fontSize2;
        this.drawableSize = drawableSize2;
    }

    public Drawable getDrawable() {
        int height = this.drawableSize;
        int width = (this.rawDrawable.getIntrinsicWidth() * height) / this.rawDrawable.getIntrinsicHeight();
        this.biasTop = (this.fontSize - height) / 2;
        this.rawDrawable.setBounds(0, 0, width, height);
        return this.rawDrawable;
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.save();
        canvas.translate(x, (float) (((bottom - paint.getFontMetricsInt().bottom) - this.rawDrawable.getBounds().height()) + this.biasTop));
        this.rawDrawable.draw(canvas);
        canvas.restore();
    }
}
