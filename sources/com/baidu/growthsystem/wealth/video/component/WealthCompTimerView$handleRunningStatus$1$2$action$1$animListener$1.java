package com.baidu.growthsystem.wealth.video.component;

import com.baidu.growthsystem.wealth.video.component.widget.listener.IWealthAnimListener;
import com.baidu.growthsystem.wealth.video.data.WealthVideoTaskData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/baidu/growthsystem/wealth/video/component/WealthCompTimerView$handleRunningStatus$1$2$action$1$animListener$1", "Lcom/baidu/growthsystem/wealth/video/component/widget/listener/IWealthAnimListener;", "onAnimationCancel", "", "onAnimationEnd", "handled", "", "onAnimationStart", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthCompTimerView.kt */
public final class WealthCompTimerView$handleRunningStatus$1$2$action$1$animListener$1 implements IWealthAnimListener {
    final /* synthetic */ WealthVideoTaskData $data;
    final /* synthetic */ WealthCompTimerView this$0;

    WealthCompTimerView$handleRunningStatus$1$2$action$1$animListener$1(WealthCompTimerView $receiver, WealthVideoTaskData $data2) {
        this.this$0 = $receiver;
        this.$data = $data2;
    }

    public void onAnimationStart() {
        WealthToastRewardCallback toastRewardCallback = this.this$0.getToastRewardCallback();
        if (toastRewardCallback != null) {
            toastRewardCallback.onToastRewardStart(this.this$0.isInBackground());
        }
    }

    public void onAnimationCancel() {
        WealthToastRewardCallback toastRewardCallback = this.this$0.getToastRewardCallback();
        if (toastRewardCallback != null) {
            toastRewardCallback.onToastRewardCancel(this.this$0.isInBackground());
        }
    }

    public void onAnimationEnd(boolean handled) {
        this.this$0.showCoinWithdrawTip(this.$data, new WealthCompTimerView$handleRunningStatus$1$2$action$1$animListener$1$onAnimationEnd$1(this.$data, this.this$0));
    }
}
