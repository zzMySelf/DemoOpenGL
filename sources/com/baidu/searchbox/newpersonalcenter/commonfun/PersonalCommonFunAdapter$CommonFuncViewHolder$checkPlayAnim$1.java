package com.baidu.searchbox.newpersonalcenter.commonfun;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.newpersonalcenter.commonfun.PersonalCommonFunAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/newpersonalcenter/commonfun/PersonalCommonFunAdapter$CommonFuncViewHolder$checkPlayAnim$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCommonFunAdapter.kt */
public final class PersonalCommonFunAdapter$CommonFuncViewHolder$checkPlayAnim$1 extends AnimatorListenerAdapter {
    final /* synthetic */ PersonalCommonFunAdapter.CommonFuncViewHolder this$0;

    PersonalCommonFunAdapter$CommonFuncViewHolder$checkPlayAnim$1(PersonalCommonFunAdapter.CommonFuncViewHolder $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.getImageView().setVisibility(4);
    }
}
