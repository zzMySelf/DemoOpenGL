package fe.mmm.qw.tt.ad.aaa;

import android.content.Context;
import com.baidu.aiscan.R;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class rg {
    @NotNull
    public static final fe ad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        float dimension = context.getResources().getDimension(R.dimen.scan_id_card_margin_horizontal);
        return fe.ad(qw(context), 0, 0.0f, dimension, dimension, 0.0f, 0, 0.0f, 0.0f, 1.5851852f, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, (Object) null);
    }

    @NotNull
    public static final fe de(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        float dimension = context.getResources().getDimension(R.dimen.scan_passport_margin_horizontal);
        return fe.ad(qw(context), 0, 0.0f, dimension, dimension, 0.0f, 0, 0.0f, 0.0f, 0.704f, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, (Object) null);
    }

    public static final fe qw(Context context) {
        float dimension = context.getResources().getDimension(R.dimen.scan_default_margin_horizontal);
        return new fe(context.getResources().getColor(R.color.card_scan_taking_background_color), 0.0f, dimension, dimension, 0.0f, context.getResources().getColor(R.color.card_scan_taking_focus_rect_border_color), context.getResources().getDimension(R.dimen.scan_card_border_width), context.getResources().getDimension(R.dimen.scan_card_corner_radius), 1.59f);
    }
}
