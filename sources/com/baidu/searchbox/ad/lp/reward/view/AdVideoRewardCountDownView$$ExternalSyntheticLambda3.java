package com.baidu.searchbox.ad.lp.reward.view;

import android.animation.ValueAnimator;
import com.baidu.searchbox.ad.lp.reward.data.RewardData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AdVideoRewardCountDownView$$ExternalSyntheticLambda3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AdVideoRewardCountDownView f$0;
    public final /* synthetic */ RewardData f$1;

    public /* synthetic */ AdVideoRewardCountDownView$$ExternalSyntheticLambda3(AdVideoRewardCountDownView adVideoRewardCountDownView, RewardData rewardData) {
        this.f$0 = adVideoRewardCountDownView;
        this.f$1 = rewardData;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AdVideoRewardCountDownView.m14750doTaskComplete$lambda4$lambda3(this.f$0, this.f$1, valueAnimator);
    }
}
