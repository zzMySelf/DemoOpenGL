package fe.fe.when.qw.qw.i;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.BaiduLBSPay;
import com.baidu.netdisk.trade.pay._;
import com.baidu.netdisk.trade.pay.polymer.__;
import fe.fe.when.qw.qw.yj.ad;
import fe.fe.when.qw.qw.yj.de;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe implements __ {
    public static final void de(MutableLiveData mutableLiveData, fe feVar, int i2, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$result");
        Intrinsics.checkNotNullParameter(feVar, "this$0");
        mutableLiveData.setValue(feVar.ad(Integer.valueOf(i2), str));
    }

    public static final void fe(_ _2, String str, String str2, String str3) {
        _2.qw(str, str2, str3);
    }

    public static final void rg(MutableLiveData mutableLiveData, fe feVar, int i2, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$result");
        Intrinsics.checkNotNullParameter(feVar, "this$0");
        mutableLiveData.setValue(feVar.ad(Integer.valueOf(i2), str));
    }

    public final ad ad(Integer num, String str) {
        if (num != null && num.intValue() == 2) {
            return new ad(1004, str);
        }
        if (num != null && num.intValue() == 0) {
            return new ad(0, str);
        }
        return new ad(1001, str);
    }

    public void qw(@NotNull Context context, @NotNull String str, @NotNull MutableLiveData<ad> mutableLiveData, @Nullable _ _2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "purchaseInfo");
        Intrinsics.checkNotNullParameter(mutableLiveData, "result");
        Map<String, String> de2 = fe.fe.when.qw.qw.fe.ad.de(str);
        if (str.length() == 0) {
            de.qw(mutableLiveData);
        } else if (_2 == null) {
            BaiduLBSPay.getInstance().doPolymerPay(context, new ad(mutableLiveData, this), de2);
        } else {
            BaiduLBSPay.getInstance().doPolymerPay(context, new de(mutableLiveData, this), de2, new qw(_2));
        }
    }
}
