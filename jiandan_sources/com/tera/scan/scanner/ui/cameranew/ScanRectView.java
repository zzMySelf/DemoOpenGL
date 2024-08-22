package com.tera.scan.scanner.ui.cameranew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.aiscan.R;
import fe.mmm.qw.p030switch.th.de.ad.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\tXD¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tera/scan/scanner/ui/cameranew/ScanRectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerX", "", "centerY", "cornerWidth", "paint", "Landroid/graphics/Paint;", "scanPaint", "scanRadius", "scanRect", "Landroid/graphics/RectF;", "getScanRect", "()Landroid/graphics/RectF;", "screenRate", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanRectView extends View {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public float centerX;
    public float centerY;
    public final int cornerWidth;
    @NotNull
    public final Paint paint;
    @NotNull
    public final Paint scanPaint;
    public final int scanRadius;
    @NotNull
    public final RectF scanRect;
    public final int screenRate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanRectView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void init(Context context) {
        this.scanPaint.setColor(ContextCompat.getColor(context, R.color.scan_code_default_bg));
        this.paint.setColor(-1);
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
    public final RectF getScanRect() {
        return this.scanRect;
    }

    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            boolean z = true;
            if (this.centerX == 0.0f) {
                if (this.centerY != 0.0f) {
                    z = false;
                }
                if (z) {
                    float f = (float) 2;
                    this.centerX = ((float) getWidth()) / f;
                    float height = ((float) getHeight()) / f;
                    this.centerY = height;
                    RectF rectF = this.scanRect;
                    float f2 = this.centerX;
                    int i2 = this.scanRadius;
                    rectF.left = f2 - ((float) i2);
                    rectF.top = height - ((float) i2);
                    rectF.right = f2 + ((float) i2);
                    rectF.bottom = height + ((float) i2);
                }
            }
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), this.scanRect.top, this.scanPaint);
            RectF rectF2 = this.scanRect;
            canvas.drawRect(0.0f, rectF2.top, rectF2.left, (float) canvas.getHeight(), this.scanPaint);
            RectF rectF3 = this.scanRect;
            Canvas canvas2 = canvas;
            canvas2.drawRect(rectF3.right, rectF3.top, (float) canvas.getWidth(), (float) canvas.getHeight(), this.scanPaint);
            RectF rectF4 = this.scanRect;
            canvas2.drawRect(rectF4.left, rectF4.bottom, rectF4.right, (float) canvas.getHeight(), this.scanPaint);
            RectF rectF5 = this.scanRect;
            float f3 = rectF5.left;
            float f4 = rectF5.top;
            canvas2.drawRect(f3, f4, f3 + ((float) this.screenRate), f4 + ((float) this.cornerWidth), this.paint);
            RectF rectF6 = this.scanRect;
            float f5 = rectF6.left;
            float f6 = rectF6.top;
            canvas2.drawRect(f5, f6, f5 + ((float) this.cornerWidth), f6 + ((float) this.screenRate), this.paint);
            RectF rectF7 = this.scanRect;
            float f7 = rectF7.right;
            float f8 = rectF7.top;
            canvas.drawRect(f7 - ((float) this.screenRate), f8, f7, f8 + ((float) this.cornerWidth), this.paint);
            RectF rectF8 = this.scanRect;
            float f9 = rectF8.right;
            float f10 = rectF8.top;
            Canvas canvas3 = canvas;
            canvas3.drawRect(f9 - ((float) this.cornerWidth), f10, f9, f10 + ((float) this.screenRate), this.paint);
            RectF rectF9 = this.scanRect;
            float f11 = rectF9.left;
            float f12 = rectF9.bottom;
            canvas3.drawRect(f11, f12 - ((float) this.cornerWidth), f11 + ((float) this.screenRate), f12, this.paint);
            RectF rectF10 = this.scanRect;
            float f13 = rectF10.left;
            float f14 = rectF10.bottom;
            canvas3.drawRect(f13, f14 - ((float) this.screenRate), f13 + ((float) this.cornerWidth), f14, this.paint);
            RectF rectF11 = this.scanRect;
            float f15 = rectF11.right;
            float f16 = rectF11.bottom;
            canvas.drawRect(f15 - ((float) this.screenRate), f16 - ((float) this.cornerWidth), f15, f16, this.paint);
            RectF rectF12 = this.scanRect;
            float f17 = rectF12.right;
            float f18 = rectF12.bottom;
            canvas.drawRect(f17 - ((float) this.cornerWidth), f18 - ((float) this.screenRate), f17, f18, this.paint);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanRectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanRectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.scanRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.scanPaint = new Paint();
        this.scanRadius = qw.qw(getContext(), 130.0f);
        this.paint = new Paint();
        this.screenRate = 40;
        this.cornerWidth = 10;
        init(context);
    }
}
