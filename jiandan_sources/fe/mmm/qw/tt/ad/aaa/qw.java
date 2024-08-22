package fe.mmm.qw.tt.ad.aaa;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.baidu.aiscan.R;
import com.tera.scan.scanner.ocr.widget.ScanRectDecoration;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw implements ScanRectDecoration {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f8380ad;
    @NotNull
    public final Context qw;

    public qw(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = context;
        this.f8380ad = z;
        new Paint();
    }

    public final void ad(Canvas canvas, Context context, RectF rectF) {
        Resources resources = context.getResources();
        if (resources != null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.scan_id_card_back_emblem_icon);
            float dimension = rectF.left + resources.getDimension(R.dimen.scan_id_card_back_emblem_margin_left);
            float dimension2 = rectF.top + resources.getDimension(R.dimen.scan_id_card_back_emblem_margin_top);
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(dimension, dimension2, resources.getDimension(R.dimen.scan_id_card_back_emblem_width) + dimension, resources.getDimension(R.dimen.scan_id_card_back_emblem_height) + dimension2), (Paint) null);
        }
    }

    public final void de(Canvas canvas, Context context, RectF rectF) {
        Resources resources = context.getResources();
        if (resources != null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.scan_id_card_front_header_icon);
            float dimension = rectF.top + resources.getDimension(R.dimen.scan_id_card_front_head_margin_top);
            float dimension2 = rectF.right - resources.getDimension(R.dimen.scan_id_card_front_head_margin_right);
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(dimension2 - resources.getDimension(R.dimen.scan_id_card_front_head_width), dimension, dimension2, resources.getDimension(R.dimen.scan_id_card_front_head_height) + dimension), (Paint) null);
        }
    }

    public final yj fe(Context context, boolean z) {
        CharSequence charSequence;
        if (z) {
            charSequence = context.getResources().getText(R.string.id_card_tab_front);
        } else {
            charSequence = context.getResources().getText(R.string.id_card_tab_back);
        }
        Intrinsics.checkNotNullExpressionValue(charSequence, "if (isFront) context.res….string.id_card_tab_back)");
        return new yj(context, charSequence.toString(), new th(20, context.getResources().getColor(R.color.scan_id_card_tips_below_card_rect_text_color), context.getResources().getDimension(R.dimen.scan_id_card_tips_below_card_rect_text_size), false, 0.0f, 0.0f, 0.0f, -context.getResources().getDimension(R.dimen.scan_id_card_tips_below_card_rect_margin_top), 120, (DefaultConstructorMarker) null));
    }

    public void qw(@NotNull Canvas canvas, @NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(rectF, "scanRect");
        if (this.f8380ad) {
            de(canvas, this.qw, rectF);
        } else {
            ad(canvas, this.qw, rectF);
        }
        fe(this.qw, this.f8380ad).qw(canvas, rectF);
    }
}
