package com.baidu.growthsystem.wealth.common.base.anim;

import android.animation.Animator;
import com.baidu.growthsystem.business.common.view.dialogtoast.animation.DefaultAnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/growthsystem/wealth/common/base/anim/WealthVideoDialogParabolaUpAnim$createDialogPackUpAnimation$2", "Lcom/baidu/growthsystem/business/common/view/dialogtoast/animation/DefaultAnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoDialogParabolaUpAnim.kt */
public final class WealthVideoDialogParabolaUpAnim$createDialogPackUpAnimation$2 extends DefaultAnimatorListener {
    final /* synthetic */ Animator.AnimatorListener $animatorListener;

    WealthVideoDialogParabolaUpAnim$createDialogPackUpAnimation$2(Animator.AnimatorListener $animatorListener2) {
        this.$animatorListener = $animatorListener2;
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$animatorListener.onAnimationCancel(animation);
    }
}
