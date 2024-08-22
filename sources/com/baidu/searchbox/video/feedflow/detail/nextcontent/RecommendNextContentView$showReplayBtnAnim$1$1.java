package com.baidu.searchbox.video.feedflow.detail.nextcontent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendNextContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/nextcontent/RecommendNextContentView$showReplayBtnAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommandNextContentView.kt */
public final class RecommendNextContentView$showReplayBtnAnim$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ RecommendNextContentView this$0;

    RecommendNextContentView$showReplayBtnAnim$1$1(RecommendNextContentView $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationStart(animation);
        TextView access$getNextDirectionBtn$p = this.this$0.nextDirectionBtn;
        if (access$getNextDirectionBtn$p != null) {
            access$getNextDirectionBtn$p.setVisibility(0);
        }
        TextView access$getNextDirectionBtn$p2 = this.this$0.nextDirectionBtn;
        if (access$getNextDirectionBtn$p2 != null) {
            access$getNextDirectionBtn$p2.setAlpha(0.0f);
        }
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        TextView access$getNextDirectionBtn$p = this.this$0.nextDirectionBtn;
        if (access$getNextDirectionBtn$p != null) {
            access$getNextDirectionBtn$p.setVisibility(0);
        }
        TextView access$getNextDirectionBtn$p2 = this.this$0.nextDirectionBtn;
        if (access$getNextDirectionBtn$p2 != null) {
            access$getNextDirectionBtn$p2.setTranslationX(1.0f);
        }
        ImageView access$getNextDirectionView$p = this.this$0.nextDirectionView;
        if (access$getNextDirectionView$p != null) {
            access$getNextDirectionView$p.setVisibility(8);
        }
        ImageView access$getNextDirectionView$p2 = this.this$0.nextDirectionView;
        if (access$getNextDirectionView$p2 != null) {
            access$getNextDirectionView$p2.setTranslationX(0.0f);
        }
        RecommendNextContentView.IRecommendNextContentViewClickListener iRecommendNextContentViewClickListener = this.this$0.getIRecommendNextContentViewClickListener();
        if (iRecommendNextContentViewClickListener != null) {
            iRecommendNextContentViewClickListener.onBtnShowed();
        }
    }
}
