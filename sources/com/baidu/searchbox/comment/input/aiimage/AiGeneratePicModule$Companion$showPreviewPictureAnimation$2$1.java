package com.baidu.searchbox.comment.input.aiimage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.comment.input.aiimage.AiGeneratePicModule;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/comment/input/aiimage/AiGeneratePicModule$Companion$showPreviewPictureAnimation$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiGeneratePicModule.kt */
public final class AiGeneratePicModule$Companion$showPreviewPictureAnimation$2$1 extends AnimatorListenerAdapter {
    final /* synthetic */ AiGeneratePicModule.OnPictureAnimateListener $animateListener;
    final /* synthetic */ AnimatorSet $animatorSet;
    final /* synthetic */ ViewGroup $rootView;
    final /* synthetic */ View $targetView;
    final /* synthetic */ SimpleDraweeView $transferView;

    AiGeneratePicModule$Companion$showPreviewPictureAnimation$2$1(AiGeneratePicModule.OnPictureAnimateListener $animateListener2, View $targetView2, ViewGroup $rootView2, SimpleDraweeView $transferView2, AnimatorSet $animatorSet2) {
        this.$animateListener = $animateListener2;
        this.$targetView = $targetView2;
        this.$rootView = $rootView2;
        this.$transferView = $transferView2;
        this.$animatorSet = $animatorSet2;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        AiGeneratePicModule.OnPictureAnimateListener onPictureAnimateListener = this.$animateListener;
        if (onPictureAnimateListener != null) {
            onPictureAnimateListener.onAnimateEnd();
        }
        this.$targetView.setVisibility(0);
        this.$rootView.removeView(this.$transferView);
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        AiGeneratePicModule.OnPictureAnimateListener onPictureAnimateListener = this.$animateListener;
        if (onPictureAnimateListener != null) {
            onPictureAnimateListener.onAnimateStart(this.$animatorSet);
        }
        this.$targetView.setVisibility(4);
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationCancel(animation);
        this.$rootView.removeView(this.$transferView);
        this.$targetView.setVisibility(0);
    }
}
