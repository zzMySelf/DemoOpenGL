package com.baidu.searchbox.rewardsystem.components;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.rewardsystem.components.base.BaseRewardOPComponent;
import com.baidu.searchbox.rewardsystem.event.TaskVisibleStateChangeEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardOPStatusComponent.kt */
final class RewardOPStatusComponent$setVisibility$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isVisible;
    final /* synthetic */ RewardOPStatusComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RewardOPStatusComponent$setVisibility$1(RewardOPStatusComponent rewardOPStatusComponent, boolean z) {
        super(0);
        this.this$0 = rewardOPStatusComponent;
        this.$isVisible = z;
    }

    public final Unit invoke() {
        BaseRewardOPComponent it = this.this$0.curComponent;
        if (it == null) {
            return null;
        }
        RewardOPStatusComponent rewardOPStatusComponent = this.this$0;
        boolean z = this.$isVisible;
        boolean prevVisibleState = rewardOPStatusComponent.isVisible();
        it.setVisibility(z);
        if (z) {
            if (!prevVisibleState) {
                BdEventBus.Companion.getDefault().post(new TaskVisibleStateChangeEvent(true));
            }
        } else if (prevVisibleState) {
            BdEventBus.Companion.getDefault().post(new TaskVisibleStateChangeEvent(false));
        }
        return Unit.INSTANCE;
    }
}
