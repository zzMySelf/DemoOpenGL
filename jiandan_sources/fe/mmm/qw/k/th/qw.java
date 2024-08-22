package fe.mmm.qw.k.th;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public static final String ad(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "orderId");
        if (!(str == null || str.length() == 0)) {
            return str;
        }
        return "https://aiscan.baidu.com/wap/vip/paySuccess?show_basic=true&entry=pay&order_no=" + str2 + "&version=" + fe.mmm.qw.de.ad.qw.qw.f7746ad;
    }

    @NotNull
    public static final String qw(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "orderId");
        if (!(str == null || str.length() == 0)) {
            return str;
        }
        return "https://aiscan.baidu.com/wap/vip/paySuccess?show_basic=true&entry=pay&isHalfCashier=1&order_no=" + str2 + "&version=" + fe.mmm.qw.de.ad.qw.qw.f7746ad;
    }
}
