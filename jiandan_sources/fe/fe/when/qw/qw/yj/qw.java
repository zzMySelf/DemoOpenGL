package fe.fe.when.qw.qw.yj;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.channelpay.wxpay.ChannelWXPay;
import com.baidu.netdisk.trade.pay.channel._____;
import com.baidu.netdisk.trade.pay.finishpay.OnFinishPay;
import com.baidu.netdisk.trade.pay.finishpay._;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import fe.fe.when.qw.qw.th.Cswitch;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw implements OnFinishPay {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static _<BaseResp> f3193ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public static _<Intent> f3194de;
    @NotNull
    public static final qw qw = new qw();

    public void ad(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        _<Intent> _2 = f3194de;
        if (_2 == null) {
            LBSPayAli.getInstance().finishAuthPay(intent);
        } else if (_2 != null) {
            _2.ad(context, intent);
        }
    }

    public void de(@NotNull Context context, @Nullable BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(context, "context");
        _<BaseResp> _2 = f3193ad;
        if (_2 == null) {
            ChannelWXPay.getInstance().handlerPayResult(context, baseResp);
        } else if (_2 != null) {
            _2.ad(context, baseResp);
        }
    }

    public final void fe() {
        f3193ad = null;
        f3194de = null;
    }

    public final void qw(@NotNull _____ _____) {
        Intrinsics.checkNotNullParameter(_____, "iChannelPay");
        if (_____ instanceof Cswitch) {
            f3193ad = (_) _____;
        }
    }
}
