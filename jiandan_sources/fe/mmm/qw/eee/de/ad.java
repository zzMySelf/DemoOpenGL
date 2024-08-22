package fe.mmm.qw.eee.de;

import android.view.View;
import com.baidu.aiscan.R;
import com.tera.scan.ui.view.widget.shadow.ShadowsKt;
import org.jetbrains.annotations.Nullable;

public final class ad {
    public static final void qw(@Nullable View view) {
        if (view != null) {
            ShadowsKt.qw(view, view.getResources().getColor(R.color.button_shadow_color), view.getResources().getDimension(R.dimen.dimen_16dp));
        }
    }
}
