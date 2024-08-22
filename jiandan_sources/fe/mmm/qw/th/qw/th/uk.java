package fe.mmm.qw.th.qw.th;

import android.content.Context;
import com.tera.scan.framework.kernel.BaseApplication;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class uk {
    @NotNull
    public static final String ad(int i2) {
        String string = qw().getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "globalContext().getString(stringId)");
        return string;
    }

    @NotNull
    public static final Context qw() {
        Context context = BaseApplication.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        return context;
    }
}
