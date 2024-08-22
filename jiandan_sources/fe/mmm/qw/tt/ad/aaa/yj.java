package fe.mmm.qw.tt.ad.aaa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.baidu.apollon.utils.ResUtils;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.scanner.ocr.widget.ScanRectDecoration;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class yj implements ScanRectDecoration {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final th f8388ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Paint f8389de = new Paint();
    @NotNull
    public final String qw;

    public yj(@NotNull Context context, @NotNull String str, @NotNull th thVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(thVar, ResUtils.d);
        this.qw = str;
        this.f8388ad = thVar;
    }

    public final void ad(Canvas canvas, RectF rectF) {
        LoggerKt.d$default("绘制文案  " + this.qw, (Object) null, 1, (Object) null);
        this.f8389de.setColor(this.f8388ad.ad());
        this.f8389de.setTextSize(this.f8388ad.de());
        this.f8389de.setFakeBoldText(this.f8388ad.uk());
        this.f8389de.setStyle(Paint.Style.FILL);
        canvas.drawText(this.qw, fe(rectF, this.f8389de.measureText(this.qw)), de(rectF, this.f8388ad.de()), this.f8389de);
    }

    public final float de(RectF rectF, float f) {
        Paint.FontMetrics fontMetrics = this.f8389de.getFontMetrics();
        float f2 = fontMetrics.top;
        float centerY = rectF.centerY() + (Math.abs(f2) - ((Math.abs(f2) + Math.abs(fontMetrics.bottom)) / 2.0f));
        if ((this.f8388ad.qw() & 1) == 1) {
            centerY = rectF.top + f + this.f8388ad.yj();
        }
        return (this.f8388ad.qw() & 4) == 4 ? (rectF.bottom + f) - this.f8388ad.fe() : centerY;
    }

    public final float fe(RectF rectF, float f) {
        float centerX = (rectF.centerX() + this.f8388ad.rg()) - (f / 2.0f);
        if ((this.f8388ad.qw() & 8) == 8) {
            centerX = rectF.left + this.f8388ad.rg();
        }
        return (this.f8388ad.qw() & 2) == 2 ? (rectF.right - f) - this.f8388ad.th() : centerX;
    }

    public void qw(@NotNull Canvas canvas, @NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(rectF, "scanRect");
        ad(canvas, rectF);
    }
}
