package ad.qw.qw.qw.qw.ad.qw;

import _._._._._.__;
import _._._._._.___.___.___;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.baidu.netdisk.trade.privilege.config.IRequest;
import com.baidu.netdisk.trade.privilege.io.model.Privilege;
import com.baidu.netdisk.trade.privilege.io.model.PrivilegeListResponse;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;

public final class ad {
    public final void qw() {
        Object obj;
        List<Privilege> list = null;
        try {
            ___ qw = ad.qw.qw.qw.qw.ad.de.ad.f546de.qw();
            IRequest ad2 = __.f542ad.ad();
            obj = Result.m1155constructorimpl((PrivilegeListResponse) ___.qw.ad(qw, ad2 != null ? ad2.fe() : null, 0, 2, (Object) null).execute().body());
        } catch (Throwable th2) {
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        PrivilegeListResponse privilegeListResponse = (PrivilegeListResponse) obj;
        TradeAccount tradeAccount = TradeAccount.f913rg;
        if (privilegeListResponse != null) {
            list = privilegeListResponse.getPrivileges();
        }
        tradeAccount.i(list);
    }
}
