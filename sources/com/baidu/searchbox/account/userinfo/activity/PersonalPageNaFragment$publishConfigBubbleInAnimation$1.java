package com.baidu.searchbox.account.userinfo.activity;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.account.userinfo.utils.PublishConfigBubbleAnimationManager;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/PersonalPageNaFragment$publishConfigBubbleInAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
public final class PersonalPageNaFragment$publishConfigBubbleInAnimation$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function0<Unit> $onInAnimationEnd;
    final /* synthetic */ PersonalPageNaFragment this$0;

    PersonalPageNaFragment$publishConfigBubbleInAnimation$1(PersonalPageNaFragment $receiver, Function0<Unit> $onInAnimationEnd2) {
        this.this$0 = $receiver;
        this.$onInAnimationEnd = $onInAnimationEnd2;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        View access$getPublishConfigBubbleLayout$p = this.this$0.publishConfigBubbleLayout;
        View view2 = null;
        if (access$getPublishConfigBubbleLayout$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishConfigBubbleLayout");
            access$getPublishConfigBubbleLayout$p = null;
        }
        access$getPublishConfigBubbleLayout$p.setVisibility(0);
        View access$getPublishConfigBubble$p = this.this$0.publishConfigBubble;
        if (access$getPublishConfigBubble$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishConfigBubble");
        } else {
            view2 = access$getPublishConfigBubble$p;
        }
        view2.setVisibility(0);
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        PublishConfigBubbleAnimationManager access$getPublishConfigBubbleAnimationManager = this.this$0.getPublishConfigBubbleAnimationManager();
        SimpleDraweeView access$getPublishConfigBubbleImage$p = this.this$0.publishConfigBubbleImage;
        View view2 = null;
        if (access$getPublishConfigBubbleImage$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishConfigBubbleImage");
            access$getPublishConfigBubbleImage$p = null;
        }
        View view3 = access$getPublishConfigBubbleImage$p;
        TextView access$getPublishConfigBubbleText$p = this.this$0.publishConfigBubbleText;
        if (access$getPublishConfigBubbleText$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishConfigBubbleText");
            access$getPublishConfigBubbleText$p = null;
        }
        View view4 = access$getPublishConfigBubbleText$p;
        View access$getPublishConfigBubbleTextLayout$p = this.this$0.publishConfigBubbleTextLayout;
        if (access$getPublishConfigBubbleTextLayout$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishConfigBubbleTextLayout");
        } else {
            view2 = access$getPublishConfigBubbleTextLayout$p;
        }
        access$getPublishConfigBubbleAnimationManager.doPublishConfigBubbleTextInAnimation(view3, view4, (float) view2.getHeight(), new PersonalPageNaFragment$publishConfigBubbleInAnimation$1$onAnimationEnd$1(this.this$0, this.$onInAnimationEnd));
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }
}
