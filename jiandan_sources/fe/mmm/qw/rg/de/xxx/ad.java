package fe.mmm.qw.rg.de.xxx;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.baidu.netdisk.trade.privilege.MemberProduct;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivity;
import fe.mmm.qw.th.qw.rg.fe.de.qw;
import fe.mmm.qw.th.qw.th.Cif;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    public static final int ad(@NotNull TextRecognitionResultActivity textRecognitionResultActivity) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        return R.color.color_F7F9FC;
    }

    public static final boolean de(@NotNull TextRecognitionResultActivity textRecognitionResultActivity) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        return TradeAccount.f913rg.o(MemberProduct.SCAN_VIP);
    }

    public static final void fe(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @NotNull TextView textView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Cif.qw(textView, str, 13.0f);
    }

    public static final void qw(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "supportFragmentManager");
        Intrinsics.checkNotNullParameter(function1, "callback");
        function1.invoke(Boolean.TRUE);
    }

    public static final boolean rg(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @NotNull View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        qw.qw(view);
        return false;
    }

    public static final boolean th(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @NotNull View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        qw.qw(view);
        return false;
    }

    public static final boolean uk(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @NotNull View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        qw.qw(view);
        return false;
    }

    public static final boolean yj(@NotNull TextRecognitionResultActivity textRecognitionResultActivity, @NotNull View view) {
        Intrinsics.checkNotNullParameter(textRecognitionResultActivity, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        qw.fe(view);
        return true;
    }
}
