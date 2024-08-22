package fe.mmm.qw.tt.ad.aaa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import com.baidu.aiscan.R;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.tera.scan.scanner.ocr.widget.ScanRectDecoration;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de implements ScanRectDecoration {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Paint f8369ad = new Paint();

    /* renamed from: de  reason: collision with root package name */
    public final float f8370de = this.qw.getResources().getDimension(R.dimen.scan_passport_dash_width);

    /* renamed from: fe  reason: collision with root package name */
    public final float f8371fe = this.qw.getResources().getDimension(R.dimen.scan_passport_dash_gap);
    @NotNull
    public final Context qw;

    public de(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = context;
    }

    public final void ad(Canvas canvas, RectF rectF) {
        this.f8369ad.setColor(this.qw.getResources().getColor(R.color.scan_passport_dash_line_color));
        this.f8369ad.setStrokeWidth(this.qw.getResources().getDimension(R.dimen.scan_card_border_width));
        this.f8369ad.setAntiAlias(true);
        this.f8369ad.setStyle(Paint.Style.STROKE);
        this.f8369ad.setPathEffect(new DashPathEffect(new float[]{this.f8370de, this.f8371fe}, 0.0f));
        float centerY = rectF.centerY();
        canvas.drawLine(rectF.left, centerY, rectF.right, centerY, this.f8369ad);
    }

    public final yj de(Context context) {
        CharSequence text = context.getResources().getText(R.string.default_text_decoration_text);
        Intrinsics.checkNotNullExpressionValue(text, "context.resources.getTex…ult_text_decoration_text)");
        return new yj(context, text.toString(), new th(16, context.getResources().getColor(R.color.scan_id_card_tips_below_card_rect_text_color), context.getResources().getDimension(R.dimen.scan_id_card_tips_below_card_rect_text_size), false, 0.0f, 0.0f, 0.0f, 0.0f, LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC, (DefaultConstructorMarker) null));
    }

    public void qw(@NotNull Canvas canvas, @NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(rectF, "scanRect");
        ad(canvas, rectF);
        de(this.qw).qw(canvas, rectF);
    }
}
