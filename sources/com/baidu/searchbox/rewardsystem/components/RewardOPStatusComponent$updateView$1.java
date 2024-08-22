package com.baidu.searchbox.rewardsystem.components;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.rewardsystem.components.base.BaseRewardOPComponent;
import com.baidu.searchbox.rewardsystem.utils.RewardDebugUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardOPStatusComponent.kt */
final class RewardOPStatusComponent$updateView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RewardOPStatusComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RewardOPStatusComponent$updateView$1(RewardOPStatusComponent rewardOPStatusComponent) {
        super(0);
        this.this$0 = rewardOPStatusComponent;
    }

    public final Unit invoke() {
        if (AppConfig.isDebug()) {
            RewardDebugUtils.INSTANCE.debug("updateView by " + this.this$0.curComponent);
        }
        BaseRewardOPComponent access$getCurComponent$p = this.this$0.curComponent;
        if (access$getCurComponent$p == null) {
            return null;
        }
        access$getCurComponent$p.updateView();
        return Unit.INSTANCE;
    }
}
