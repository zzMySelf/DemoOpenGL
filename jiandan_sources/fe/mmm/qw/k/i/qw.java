package fe.mmm.qw.k.i;

import androidx.fragment.app.FragmentActivity;
import com.baidu.netdisk.trade.pay.order.IPayResult;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import fe.fe.when.qw.qw.yj.ad;
import fe.mmm.qw.l.de;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("PayResultImpl")
public final class qw implements IPayResult {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final IBaseView f7980ad;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final fe.mmm.qw.k.o.qw f7981th;

    public qw(@Nullable IBaseView iBaseView, @NotNull fe.mmm.qw.k.o.qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "hybrid");
        this.f7980ad = iBaseView;
        this.f7981th = qwVar;
    }

    public void actionResult(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "result");
        LoggerKt.d$default("actionResult:" + adVar.de(), (Object) null, 1, (Object) null);
        this.f7981th.qw(adVar);
        IBaseView iBaseView = this.f7980ad;
        FragmentActivity activity = iBaseView != null ? iBaseView.getActivity() : null;
        if (activity != null) {
            LoggerKt.d$default("actionResult:" + activity, (Object) null, 1, (Object) null);
            if (activity instanceof IPayResult) {
                ((IPayResult) activity).actionResult(adVar);
            }
        }
    }

    public void openResultPage(@NotNull String str, @NotNull String str2) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "orderId");
        IBaseView iBaseView = this.f7980ad;
        FragmentActivity fragmentActivity = null;
        FragmentActivity activity2 = iBaseView != null ? iBaseView.getActivity() : null;
        LoggerKt.d$default("openResultPage:" + str + "  orderId:" + str2 + " payResult:" + activity2, (Object) null, 1, (Object) null);
        if (activity2 == null || !(activity2 instanceof IPayResult)) {
            LoggerKt.d$default("startWebPreview", (Object) null, 1, (Object) null);
            IBaseView iBaseView2 = this.f7980ad;
            if (iBaseView2 != null) {
                fragmentActivity = iBaseView2.getActivity();
            }
            de.ad(fragmentActivity, fe.mmm.qw.k.th.qw.ad(str, str2));
            IBaseView iBaseView3 = this.f7980ad;
            if (iBaseView3 != null && (activity = iBaseView3.getActivity()) != null) {
                activity.finish();
                return;
            }
            return;
        }
        LoggerKt.d$default("openResultPage", (Object) null, 1, (Object) null);
        ((IPayResult) activity2).openResultPage(str, str2);
    }
}
