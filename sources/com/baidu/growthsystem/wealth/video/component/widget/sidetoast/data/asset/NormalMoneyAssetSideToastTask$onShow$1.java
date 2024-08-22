package com.baidu.growthsystem.wealth.video.component.widget.sidetoast.data.asset;

import com.baidu.growthsystem.wealth.video.component.widget.listener.IWealthAnimListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/growthsystem/wealth/video/component/widget/sidetoast/data/asset/NormalMoneyAssetSideToastTask$onShow$1", "Lcom/baidu/growthsystem/wealth/video/component/widget/listener/IWealthAnimListener;", "onAnimationCancel", "", "onAnimationEnd", "handled", "", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NormalMoneyAssetSideToastData.kt */
public final class NormalMoneyAssetSideToastTask$onShow$1 implements IWealthAnimListener {
    final /* synthetic */ Function0<Unit> $next;
    final /* synthetic */ NormalMoneyAssetSideToastTask this$0;

    NormalMoneyAssetSideToastTask$onShow$1(Function0<Unit> $next2, NormalMoneyAssetSideToastTask $receiver) {
        this.$next = $next2;
        this.this$0 = $receiver;
    }

    public void onAnimationStart() {
        IWealthAnimListener.DefaultImpls.onAnimationStart(this);
    }

    public void onAnimationCancel() {
        this.$next.invoke();
    }

    public void onAnimationEnd(boolean handled) {
        if (!handled) {
            this.this$0.getCompTimerViewUbc().doShowFloatWidgetActionUbc();
        }
        this.$next.invoke();
    }
}
