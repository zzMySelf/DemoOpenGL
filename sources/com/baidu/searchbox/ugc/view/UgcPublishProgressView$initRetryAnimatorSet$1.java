package com.baidu.searchbox.ugc.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/ugc/view/UgcPublishProgressView$initRetryAnimatorSet$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcPublishProgressView.kt */
public final class UgcPublishProgressView$initRetryAnimatorSet$1 extends AnimatorListenerAdapter {
    final /* synthetic */ UgcPublishProgressView this$0;

    UgcPublishProgressView$initRetryAnimatorSet$1(UgcPublishProgressView $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationStart(animation);
        this.this$0.cancelAnimatorSet.cancel();
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        TextView access$getUgcPublishProgressCancel$p = this.this$0.ugcPublishProgressCancel;
        if (access$getUgcPublishProgressCancel$p != null) {
            access$getUgcPublishProgressCancel$p.setVisibility(0);
        }
        LinearLayout access$getUgcPublishProgressCreate$p = this.this$0.ugcPublishProgressCreate;
        if (access$getUgcPublishProgressCreate$p != null) {
            access$getUgcPublishProgressCreate$p.setVisibility(8);
        }
        TextView access$getUgcPublishProgressRetry$p = this.this$0.ugcPublishProgressRetry;
        if (access$getUgcPublishProgressRetry$p != null) {
            access$getUgcPublishProgressRetry$p.setVisibility(8);
        }
        TextView access$getUgcPublishProgressRetry$p2 = this.this$0.ugcPublishProgressRetry;
        if (access$getUgcPublishProgressRetry$p2 != null) {
            access$getUgcPublishProgressRetry$p2.setAlpha(1.0f);
        }
        ImageView access$getUgcPublishProgressDelete$p = this.this$0.ugcPublishProgressDelete;
        if (access$getUgcPublishProgressDelete$p != null) {
            access$getUgcPublishProgressDelete$p.setVisibility(8);
        }
        ImageView access$getUgcPublishProgressDelete$p2 = this.this$0.ugcPublishProgressDelete;
        if (access$getUgcPublishProgressDelete$p2 != null) {
            access$getUgcPublishProgressDelete$p2.setAlpha(1.0f);
        }
    }
}
