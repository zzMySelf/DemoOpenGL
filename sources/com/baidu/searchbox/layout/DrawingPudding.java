package com.baidu.searchbox.layout;

import android.graphics.Canvas;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH$J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H$J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0004J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/layout/DrawingPudding;", "Lcom/baidu/searchbox/layout/PuddingView;", "priority", "", "(I)V", "height", "visibility", "width", "doDraw", "", "canvas", "Landroid/graphics/Canvas;", "doLayout", "l", "t", "r", "b", "doMeasure", "widthMeasureSpec", "heightMeasureSpec", "getMeasuredHeight", "getMeasuredWidth", "getPriority", "getVisibility", "onDraw", "clipBounds", "Landroid/graphics/Rect;", "onMeasure", "setMeasuredDimension", "measuredWidth", "measuredHeight", "setVisibility", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: pudding.kt */
public abstract class DrawingPudding implements PuddingView {
    private int height;
    private final int priority;
    private int visibility;
    private int width;

    /* access modifiers changed from: protected */
    public abstract void onDraw(Canvas canvas, Rect rect);

    /* access modifiers changed from: protected */
    public abstract void onMeasure(int i2, int i3);

    public DrawingPudding(int priority2) {
        this.priority = priority2;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getMeasuredWidth() {
        return this.width;
    }

    public int getMeasuredHeight() {
        return this.height;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int visibility2) {
        this.visibility = visibility2;
    }

    public void doMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.visibility != 8) {
            onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void doLayout(int l, int t, int r, int b2) {
    }

    public void doDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.visibility == 0) {
            Rect rect = canvas.getClipBounds();
            Intrinsics.checkNotNullExpressionValue(rect, "canvas.clipBounds");
            onDraw(canvas, rect);
        }
    }

    /* access modifiers changed from: protected */
    public final void setMeasuredDimension(int measuredWidth, int measuredHeight) {
        this.width = measuredWidth;
        this.height = measuredHeight;
    }
}
