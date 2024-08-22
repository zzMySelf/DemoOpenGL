package com.baidu.searchbox.video.detail.plugin.component.reward.listener;

import com.baidu.searchbox.reward.OnRewardListener;
import com.baidu.searchbox.video.detail.plugin.component.reward.api.IRewardAbilityProvider;
import com.baidu.searchbox.video.detail.plugin.component.reward.api.IRewardButtonContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/reward/listener/RewardListener;", "Lcom/baidu/searchbox/reward/OnRewardListener;", "rewardButtonContainer", "Lcom/baidu/searchbox/video/detail/plugin/component/reward/api/IRewardButtonContainer;", "rewardProvider", "Lcom/baidu/searchbox/video/detail/plugin/component/reward/api/IRewardAbilityProvider;", "(Lcom/baidu/searchbox/video/detail/plugin/component/reward/api/IRewardButtonContainer;Lcom/baidu/searchbox/video/detail/plugin/component/reward/api/IRewardAbilityProvider;)V", "onCancel", "", "onComplete", "amount", "", "toast", "", "rewardCount", "onDismiss", "onFail", "onShow", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardListener.kt */
public final class RewardListener implements OnRewardListener {
    private final IRewardButtonContainer rewardButtonContainer;
    private final IRewardAbilityProvider rewardProvider;

    public RewardListener(IRewardButtonContainer rewardButtonContainer2, IRewardAbilityProvider rewardProvider2) {
        Intrinsics.checkNotNullParameter(rewardButtonContainer2, "rewardButtonContainer");
        this.rewardButtonContainer = rewardButtonContainer2;
        this.rewardProvider = rewardProvider2;
    }

    public void onComplete(long amount, String toast, String rewardCount) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        CharSequence charSequence = rewardCount;
        if (!(charSequence == null || charSequence.length() == 0)) {
            this.rewardButtonContainer.updateRewardButtonText(rewardCount);
        }
        IRewardAbilityProvider iRewardAbilityProvider = this.rewardProvider;
        if (iRewardAbilityProvider != null) {
            iRewardAbilityProvider.rewardComplete(toast);
        }
    }

    public void onCancel() {
    }

    public void onFail() {
    }

    public void onShow() {
        IRewardAbilityProvider iRewardAbilityProvider = this.rewardProvider;
        if (iRewardAbilityProvider != null) {
            iRewardAbilityProvider.rewardPanelShow();
        }
    }

    public void onDismiss() {
        IRewardAbilityProvider iRewardAbilityProvider = this.rewardProvider;
        if (iRewardAbilityProvider != null) {
            iRewardAbilityProvider.rewardPanelDismiss();
        }
    }
}
