package fe.mmm.qw.p024if.pf.yj;

import androidx.core.app.NotificationCompat;
import com.tera.scan.flutter.plugin.router.NetdiskRouterPluginProxy;
import io.flutter.plugin.common.MethodCall;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.pf.yj.qw  reason: invalid package */
public final class qw {
    @Nullable
    public static final String qw(@NotNull NetdiskRouterPluginProxy netdiskRouterPluginProxy, @NotNull MethodCall methodCall) {
        Intrinsics.checkNotNullParameter(netdiskRouterPluginProxy, "<this>");
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        return (String) methodCall.argument("vipFrom");
    }
}
