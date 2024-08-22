package fe.fe.when.qw.qw.th;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.pay.PayCallBack;
import com.baidu.netdisk.trade.pay._;
import com.baidu.netdisk.trade.pay.channel._____;
import com.baidu.wallet.api.BaiduWallet;
import fe.fe.when.qw.qw.yj.ad;
import fe.fe.when.qw.qw.yj.de;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.fe.when.qw.qw.th.if  reason: invalid class name */
public final class Cif implements _____ {

    /* renamed from: fe.fe.when.qw.qw.th.if$qw */
    public static final class qw implements PayCallBack {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Cif f3184ad;
        public final /* synthetic */ MutableLiveData<ad> qw;

        public qw(MutableLiveData<ad> mutableLiveData, Cif ifVar) {
            this.qw = mutableLiveData;
            this.f3184ad = ifVar;
        }

        public boolean isHideLoadingDialog() {
            return false;
        }

        public void onPayResult(int i2, @Nullable String str) {
            de.ad(this.qw, this.f3184ad.ad(Integer.valueOf(i2)), str);
        }
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
        BaiduWallet.getInstance().doPay(fragmentActivity, str, new qw(mutableLiveData, this));
    }
}
