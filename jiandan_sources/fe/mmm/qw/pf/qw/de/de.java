package fe.mmm.qw.pf.qw.de;

import android.graphics.Typeface;
import com.baidu.aiscan.R;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.ui.view.widget.UITextView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de {
    public static final void qw(@NotNull LocalImageSelectActivity localImageSelectActivity) {
        Intrinsics.checkNotNullParameter(localImageSelectActivity, "<this>");
        ((UITextView) localImageSelectActivity._$_findCachedViewById(R.id.select_count_text)).setTypeface(Typeface.defaultFromStyle(1));
    }
}
