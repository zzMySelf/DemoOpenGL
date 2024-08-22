package fe.fe.when.qw.qw.uk.qw;

import androidx.lifecycle.MutableLiveData;
import com.baidu.netdisk.trade.pay.config.IRequest;
import com.baidu.netdisk.trade.pay.config._;
import com.baidu.netdisk.trade.pay.order.__.___;
import com.baidu.netdisk.trade.pay.order.model.Purchase;
import fe.fe.when.qw.qw.uk.ad.ad;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    public final void qw(@NotNull Map<String, String> map, @NotNull MutableLiveData<Purchase> mutableLiveData) {
        Object obj;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(mutableLiveData, "livedata");
        Object obj2 = null;
        try {
            Result.Companion companion = Result.Companion;
            ___ qw = ad.qw.qw();
            IRequest qw2 = _.qw.qw();
            obj = Result.m1155constructorimpl(qw.qw(map, qw2 != null ? qw2.fe() : null).execute().body());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m1161isFailureimpl(obj)) {
            obj2 = obj;
        }
        mutableLiveData.postValue(obj2);
    }
}
