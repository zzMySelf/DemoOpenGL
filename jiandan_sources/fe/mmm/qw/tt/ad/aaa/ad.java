package fe.mmm.qw.tt.ad.aaa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.baidu.aiscan.R;
import com.tera.scan.scanner.ocr.widget.ScanRectDecoration;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad implements ScanRectDecoration {
    @NotNull
    public final Context qw;

    public ad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = context;
    }

    public final yj ad(Context context) {
        CharSequence text = context.getResources().getText(R.string.default_text_decoration_text);
        Intrinsics.checkNotNullExpressionValue(text, "context.resources.getTex…ult_text_decoration_text)");
        return new yj(context, text.toString(), new th(20, context.getResources().getColor(R.color.scan_id_card_tips_below_card_rect_text_color), context.getResources().getDimension(R.dimen.scan_id_card_tips_below_card_rect_text_size), false, 0.0f, 0.0f, 0.0f, -context.getResources().getDimension(R.dimen.scan_id_card_tips_below_card_rect_margin_top), 120, (DefaultConstructorMarker) null));
    }

    public void qw(@NotNull Canvas canvas, @NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(rectF, "scanRect");
        ad(this.qw).qw(canvas, rectF);
    }
}
