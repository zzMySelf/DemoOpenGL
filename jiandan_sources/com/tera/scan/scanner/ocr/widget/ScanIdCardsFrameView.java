package com.tera.scan.scanner.ocr.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import fe.mmm.qw.tt.ad.aaa.fe;
import fe.mmm.qw.tt.ad.aaa.rg;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001d\u001a\u00020\u000fJ\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u001b\u0010 \u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\"H\u0000¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/tera/scan/scanner/ocr/widget/ScanIdCardsFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "category", "scanCardsBackgroundPaint", "Landroid/graphics/Paint;", "scanCardsTransparentRect", "Landroid/graphics/RectF;", "scanRectBorderPaint", "scanRectDecoration", "", "Lcom/tera/scan/scanner/ocr/widget/ScanRectDecoration;", "drawDecorations", "", "canvas", "Landroid/graphics/Canvas;", "drawScanBackground", "style", "Lcom/tera/scan/scanner/ocr/widget/ScanRectStyle;", "drawScanRectBorder", "drawScanTransparentRect", "getCardsFrameRect", "getScanRectStyle", "onDraw", "setDecorations", "decorations", "", "setDecorations$scanner_aiscanConfigRelease", "setScanInCardsCategory", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsFrameView extends View {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public int category;
    @NotNull
    public final Paint scanCardsBackgroundPaint;
    @NotNull
    public final RectF scanCardsTransparentRect;
    @NotNull
    public final Paint scanRectBorderPaint;
    @NotNull
    public List<ScanRectDecoration> scanRectDecoration;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanIdCardsFrameView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void drawDecorations(Canvas canvas) {
        for (ScanRectDecoration qw : this.scanRectDecoration) {
            qw.qw(canvas, getCardsFrameRect());
        }
    }

    private final void drawScanBackground(Canvas canvas, fe feVar) {
        this.scanCardsBackgroundPaint.setColor(feVar.de());
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.scanCardsBackgroundPaint);
    }

    private final void drawScanRectBorder(Canvas canvas, fe feVar) {
        this.scanRectBorderPaint.setColor(feVar.fe());
        this.scanRectBorderPaint.setStrokeWidth(feVar.th());
        this.scanRectBorderPaint.setAntiAlias(true);
        this.scanRectBorderPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(this.scanCardsTransparentRect, feVar.rg(), feVar.rg(), this.scanRectBorderPaint);
    }

    private final void drawScanTransparentRect(Canvas canvas, fe feVar) {
        this.scanCardsBackgroundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float f = (float) 2;
        float height = ((float) getHeight()) / f;
        float width = ((((float) getWidth()) - feVar.yj()) - feVar.uk()) / feVar.i();
        this.scanCardsTransparentRect.left = ((float) getLeft()) + feVar.yj();
        RectF rectF = this.scanCardsTransparentRect;
        float f2 = width / f;
        rectF.top = height - f2;
        rectF.right = ((float) getRight()) - feVar.uk();
        RectF rectF2 = this.scanCardsTransparentRect;
        rectF2.bottom = height + f2;
        canvas.drawRoundRect(rectF2, feVar.rg(), feVar.rg(), this.scanCardsBackgroundPaint);
        this.scanCardsBackgroundPaint.setXfermode((Xfermode) null);
    }

    private final fe getScanRectStyle() {
        int i2 = this.category;
        if (i2 == 1) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return rg.ad(context);
        } else if (i2 != 6) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return rg.ad(context2);
        } else {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            return rg.de(context3);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @NotNull
    public final RectF getCardsFrameRect() {
        return this.scanCardsTransparentRect;
    }

    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        fe scanRectStyle = getScanRectStyle();
        if (canvas != null) {
            drawScanBackground(canvas, scanRectStyle);
            drawScanTransparentRect(canvas, scanRectStyle);
            drawScanRectBorder(canvas, scanRectStyle);
            drawDecorations(canvas);
        }
    }

    public final void setDecorations$scanner_aiscanConfigRelease(@NotNull List<? extends ScanRectDecoration> list) {
        Intrinsics.checkNotNullParameter(list, "decorations");
        this.scanRectDecoration.clear();
        this.scanRectDecoration.addAll(list);
        postInvalidate();
    }

    public final void setScanInCardsCategory(int i2) {
        this.category = i2;
        postInvalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanIdCardsFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanIdCardsFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.category = 1;
        this.scanCardsTransparentRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.scanCardsBackgroundPaint = new Paint();
        this.scanRectBorderPaint = new Paint();
        this.scanRectDecoration = new ArrayList();
    }
}
