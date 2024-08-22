package com.baidu.searchbox.introduction.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.rewardsystem.newtimer.net.TimerStatusInfoRequester;
import com.baidu.searchbox.rewardsystem.repo.RewardTaskRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/introduction/ui/TaskGuideDialog$cancelIntoTimer$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskGuideDialog.kt */
public final class TaskGuideDialog$cancelIntoTimer$1 extends AnimatorListenerAdapter {
    final /* synthetic */ TaskGuideDialog this$0;

    TaskGuideDialog$cancelIntoTimer$1(TaskGuideDialog $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        this.this$0.dismissDialog();
        this.this$0.registerTimerActiveEvent();
        RewardTaskRepo.INSTANCE.request("6", TimerStatusInfoRequester.REQUEST_FROM_POP_UP_VALUE);
    }
}
