package com.baidu.nadcore.lp.reward.view;

import com.baidu.nadcore.lp.reward.util.MultipleStartCountDownTime;
import com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView;
import com.baidu.nadcore.model.RewardData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/nadcore/lp/reward/view/NadVideoRewardCountDownView$setData$1", "Lcom/baidu/nadcore/lp/reward/util/MultipleStartCountDownTime;", "onFinish", "", "onTick", "millisUntilFinished", "", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadVideoRewardCountDownView.kt */
public final class NadVideoRewardCountDownView$setData$1 extends MultipleStartCountDownTime {
    final /* synthetic */ RewardData $rewardData;
    final /* synthetic */ int $taskDuration;
    final /* synthetic */ NadVideoRewardCountDownView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadVideoRewardCountDownView$setData$1(NadVideoRewardCountDownView $receiver, int $taskDuration2, RewardData $rewardData2, long $super_call_param$1) {
        super($super_call_param$1, 1000);
        this.this$0 = $receiver;
        this.$taskDuration = $taskDuration2;
        this.$rewardData = $rewardData2;
    }

    public void onTick(long millisUntilFinished) {
        Function0<Unit> noticeBoardShowCallback;
        Function0<Unit> bigCardShowCallback;
        Function0<Unit> suspendShowCallback;
        super.onTick(millisUntilFinished);
        long j2 = (long) 1000;
        if (((int) (millisUntilFinished / j2)) == this.this$0.getSuspendShowTime() && (suspendShowCallback = this.this$0.getSuspendShowCallback()) != null) {
            suspendShowCallback.invoke();
        }
        if (((int) (millisUntilFinished / j2)) == this.this$0.getBigCardShowTime() && (bigCardShowCallback = this.this$0.getBigCardShowCallback()) != null) {
            bigCardShowCallback.invoke();
        }
        if (((int) (millisUntilFinished / j2)) == this.this$0.getNoticeBoardShowTime() && (noticeBoardShowCallback = this.this$0.getNoticeBoardShowCallback()) != null) {
            noticeBoardShowCallback.invoke();
        }
        AbsRewardCountDownView.FloatLayerUpdateListener floatLayerListener = this.this$0.getFloatLayerListener();
        if (floatLayerListener != null) {
            floatLayerListener.onProgress(((long) this.$taskDuration) - (millisUntilFinished / j2));
        }
        this.this$0.getTvCountDown().setText(String.valueOf(millisUntilFinished / 1000));
    }

    public void onFinish() {
        Function0<Unit> countDownFinish = this.this$0.getCountDownFinish();
        if (countDownFinish != null) {
            countDownFinish.invoke();
        }
        this.this$0.doTaskComplete(this.$rewardData);
    }
}
