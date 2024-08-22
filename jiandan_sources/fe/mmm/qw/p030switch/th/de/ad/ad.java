package fe.mmm.qw.p030switch.th.de.ad;

import androidx.annotation.StringRes;
import com.tera.scan.framework.kernel.BaseApplication;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.switch.th.de.ad.ad  reason: invalid package */
public final class ad {
    @NotNull
    public static final String qw(@StringRes int i2) {
        String string = BaseApplication.mContext.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(id)");
        return string;
    }
}
