package fe.mmm.qw.rg.de.xxx;

import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.business.textrecognition.PreViewActivity;
import fe.mmm.qw.th.qw.th.Cif;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    public static final void ad(@NotNull PreViewActivity preViewActivity, @NotNull TextView textView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(preViewActivity, "<this>");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Cif.qw(textView, str, 13.0f);
    }

    public static final int qw(@NotNull PreViewActivity preViewActivity) {
        Intrinsics.checkNotNullParameter(preViewActivity, "<this>");
        return R.color.color_F7F9FC;
    }
}
