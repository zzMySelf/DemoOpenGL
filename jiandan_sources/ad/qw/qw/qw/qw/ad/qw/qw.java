package ad.qw.qw.qw.qw.ad.qw;

import _._._._._.__;
import _._._._._.___.___.___;
import ad.qw.qw.qw.qw.ad.de.ad;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.baidu.netdisk.trade.privilege.config.IRequest;
import com.baidu.netdisk.trade.privilege.io.model.ConsumeFreeCountResponse;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public final Pair<Boolean, Integer> qw(@NotNull String str, @Nullable String str2) {
        Object obj;
        Integer errCode;
        Intrinsics.checkNotNullParameter(str, "privilegeId");
        try {
            ___ qw = ad.f546de.qw();
            IRequest ad2 = __.f542ad.ad();
            obj = Result.m1155constructorimpl(qw.de(ad2 != null ? ad2.fe() : null, str, str2, String.valueOf(System.currentTimeMillis())).execute().body());
        } catch (Throwable th2) {
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        ConsumeFreeCountResponse consumeFreeCountResponse = (ConsumeFreeCountResponse) obj;
        boolean z = consumeFreeCountResponse != null && (errCode = consumeFreeCountResponse.getErrCode()) != null && errCode.intValue() == 0 && Intrinsics.areEqual((Object) consumeFreeCountResponse.getPrivilegeId(), (Object) str);
        int freeCount = (!z || consumeFreeCountResponse == null) ? -1 : consumeFreeCountResponse.getFreeCount();
        if (z) {
            TradeAccount.ggg(TradeAccount.f913rg, (Function0) null, 1, (Object) null);
        }
        return new Pair<>(Boolean.valueOf(z), Integer.valueOf(freeCount));
    }
}
