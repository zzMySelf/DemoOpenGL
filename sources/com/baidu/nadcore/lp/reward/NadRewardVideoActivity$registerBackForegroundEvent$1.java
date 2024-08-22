package com.baidu.nadcore.lp.reward;

import com.baidu.nadcore.eventbus.ISubscriber;
import com.baidu.nadcore.eventbus.lifecycle.AdBackForegroundEvent;
import com.baidu.nadcore.lp.reward.util.NadRewardRequestUtil;
import com.baidu.nadcore.model.AdRewardVideoLpModel;
import com.baidu.nadcore.model.LottieDialogRewardData;
import com.baidu.nadcore.model.RewardData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/nadcore/lp/reward/NadRewardVideoActivity$registerBackForegroundEvent$1", "Lcom/baidu/nadcore/eventbus/ISubscriber;", "Lcom/baidu/nadcore/eventbus/lifecycle/AdBackForegroundEvent;", "onEvent", "", "event", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardVideoActivity.kt */
public final class NadRewardVideoActivity$registerBackForegroundEvent$1 extends ISubscriber<AdBackForegroundEvent> {
    final /* synthetic */ NadRewardVideoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadRewardVideoActivity$registerBackForegroundEvent$1(NadRewardVideoActivity $receiver, Class<AdBackForegroundEvent> $super_call_param$1) {
        super($super_call_param$1);
        this.this$0 = $receiver;
    }

    public void onEvent(AdBackForegroundEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isForeground) {
            AdRewardVideoLpModel access$getAdModel$p = this.this$0.adModel;
            AdRewardVideoLpModel adRewardVideoLpModel = null;
            if (access$getAdModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                access$getAdModel$p = null;
            }
            if (access$getAdModel$p.getRuntimeData().getLottieDialogBtnClick()) {
                NadRewardRequestUtil nadRewardRequestUtil = NadRewardRequestUtil.INSTANCE;
                AdRewardVideoLpModel access$getAdModel$p2 = this.this$0.adModel;
                if (access$getAdModel$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    access$getAdModel$p2 = null;
                }
                RewardData reward = access$getAdModel$p2.getReward();
                AdRewardVideoLpModel access$getAdModel$p3 = this.this$0.adModel;
                if (access$getAdModel$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    access$getAdModel$p3 = null;
                }
                LottieDialogRewardData lottieDialogRewardData = access$getAdModel$p3.getReward().getLottieDialogRewardData();
                nadRewardRequestUtil.requestFestivalData(reward, lottieDialogRewardData != null ? lottieDialogRewardData.getAppendUrl() : null, new NadRewardVideoActivity$registerBackForegroundEvent$1$onEvent$1(this.this$0));
                AdRewardVideoLpModel access$getAdModel$p4 = this.this$0.adModel;
                if (access$getAdModel$p4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                } else {
                    adRewardVideoLpModel = access$getAdModel$p4;
                }
                adRewardVideoLpModel.getRuntimeData().setLottieDialogBtnClick(false);
            }
        }
    }
}
