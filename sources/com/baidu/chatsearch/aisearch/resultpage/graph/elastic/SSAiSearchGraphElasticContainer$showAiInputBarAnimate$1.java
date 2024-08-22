package com.baidu.chatsearch.aisearch.resultpage.graph.elastic;

import android.view.View;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/chatsearch/aisearch/resultpage/graph/elastic/SSAiSearchGraphElasticContainer$showAiInputBarAnimate$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiSearchGraphElasticContainer.kt */
public final class SSAiSearchGraphElasticContainer$showAiInputBarAnimate$1 implements Animation.AnimationListener {
    final /* synthetic */ SSAiSearchGraphElasticContainer this$0;

    SSAiSearchGraphElasticContainer$showAiInputBarAnimate$1(SSAiSearchGraphElasticContainer $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        View access$getChatInputSnapShotView$p = this.this$0.chatInputSnapShotView;
        if (access$getChatInputSnapShotView$p != null) {
            access$getChatInputSnapShotView$p.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        View access$getChatInputSnapShotView$p = this.this$0.chatInputSnapShotView;
        if (access$getChatInputSnapShotView$p != null) {
            access$getChatInputSnapShotView$p.setVisibility(8);
        }
        this.this$0.setFullScreenMode(true);
    }

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }
}
