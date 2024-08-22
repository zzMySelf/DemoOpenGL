package com.baidu.searchbox.feed.biserialdetail.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007JR\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J4\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/view/TopRightImageSpan;", "Landroid/text/style/ImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "leftPadding", "", "rightPadding", "(Landroid/graphics/drawable/Drawable;FF)V", "topOffset", "getTopOffset", "()F", "topOffset$delegate", "Lkotlin/Lazy;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopRightImageSpan.kt */
public final class TopRightImageSpan extends ImageSpan {
    private final float leftPadding;
    private final float rightPadding;
    private final Lazy topOffset$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopRightImageSpan(Drawable drawable, float f2, float f3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) != 0 ? 0.0f : f3);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopRightImageSpan(Drawable d2, float leftPadding2, float rightPadding2) {
        super(d2);
        Intrinsics.checkNotNullParameter(d2, "d");
        this.leftPadding = leftPadding2;
        this.rightPadding = rightPadding2;
        this.topOffset$delegate = LazyKt.lazy(TopRightImageSpan$topOffset$2.INSTANCE);
    }

    private final float getTopOffset() {
        return ((Number) this.topOffset$delegate.getValue()).floatValue();
    }

    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Rect rect;
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        if (drawable == null || (rect = drawable.getBounds()) == null) {
            return super.getSize(paint, text, start, end, fm);
        }
        return (int) (((float) rect.width()) + this.leftPadding + this.rightPadding);
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float iconY;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable d2 = getDrawable();
        canvas.save();
        float iconX = this.leftPadding + x;
        if (top == 0) {
            iconY = 0.0f;
        } else {
            iconY = ((float) top) - getTopOffset();
        }
        canvas.translate(iconX, iconY);
        d2.draw(canvas);
        canvas.restore();
    }
}
