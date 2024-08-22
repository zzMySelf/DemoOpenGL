package fe.fe.when.qw.qw.th;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.BaiduLBSPay;
import com.baidu.netdisk.trade.pay._;
import com.baidu.netdisk.trade.pay.channel._____;
import fe.fe.when.qw.qw.yj.ad;
import fe.fe.when.qw.qw.yj.de;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class pf implements _____ {
    public static final void de(MutableLiveData mutableLiveData, pf pfVar, int i2, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$result");
        Intrinsics.checkNotNullParameter(pfVar, "this$0");
        de.ad(mutableLiveData, pfVar.ad(Integer.valueOf(i2)), str);
    }

    public static final void fe(_ _2, String str, String str2, String str3) {
        _2.qw(str, str2, str3);
    }

    public static final void rg(MutableLiveData mutableLiveData, pf pfVar, int i2, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$result");
        Intrinsics.checkNotNullParameter(pfVar, "this$0");
        de.ad(mutableLiveData, pfVar.ad(Integer.valueOf(i2)), str);
    }

    public int ad(@Nullable Integer num) {
        if (num != null && num.intValue() == 2) {
            return 1004;
        }
        return (num != null && num.intValue() == 0) ? 0 : 1001;
    }

    public void qw(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull MutableLiveData<ad> mutableLiveData, @Nullable _ _2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "purchaseInfo");
        Intrinsics.checkNotNullParameter(mutableLiveData, "result");
        if (_2 == null) {
            BaiduLBSPay.getInstance().doPolymerAuthorizeSign(fragmentActivity, new yj(mutableLiveData, this), fe.fe.when.qw.qw.fe.ad.de(str));
        } else {
            BaiduLBSPay.getInstance().doPolymerAuthorizeSign(fragmentActivity, new uk(mutableLiveData, this), fe.fe.when.qw.qw.fe.ad.de(str), new ad(_2));
        }
    }
}
