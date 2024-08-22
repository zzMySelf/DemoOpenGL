package fe.mmm.qw.k.fe;

import com.baidu.netdisk.trade.privilege.MemberProduct;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull
    public static final ad qw = new ad();

    public static final void de(Function1 function1, Boolean bool) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        function1.invoke(bool);
    }

    public final void ad(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        TradeAccount.f913rg.uk(new qw(function1));
    }

    public final boolean qw() {
        return TradeAccount.f913rg.o(MemberProduct.SCAN_VIP);
    }
}
