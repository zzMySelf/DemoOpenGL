package fe.mmm.qw.pf.qw.de;

import com.baidu.aiscan.R;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import fe.mmm.qw.th.qw.th.o;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "LocalImageSelectActivityFlavor")
public final class ad {
    public static final void qw(@NotNull LocalImageSelectActivity localImageSelectActivity) {
        Intrinsics.checkNotNullParameter(localImageSelectActivity, "<this>");
        o.uk(localImageSelectActivity.getString(R.string.choose_image_overflow, new Object[]{Integer.valueOf(localImageSelectActivity.maxCount)}));
    }
}
