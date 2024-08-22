package fe.mmm.qw.f.ad.de;

import com.dlife.ctaccountapi.t;
import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import com.tera.scan.ui.utils.log.IUIKitLog;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static IUIKitLog f7766ad;
    @NotNull
    public static final qw qw = new qw();

    public final void ad(@NotNull String str, @NotNull String str2, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(th2, t.a);
        IUIKitLog iUIKitLog = f7766ad;
        if (iUIKitLog != null) {
            iUIKitLog.qw("UIKit." + str, str2, th2);
        }
    }

    public final void qw(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        IUIKitLog iUIKitLog = f7766ad;
        if (iUIKitLog != null) {
            iUIKitLog.d("UIKit." + str, str2);
        }
    }
}
