package com.baidu.searchbox.comment.view.title;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/comment/view/title/CommentTitleAuthorImpl$updateStyle$dismissAnimation$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentTitleAuthorImpl.kt */
public final class CommentTitleAuthorImpl$updateStyle$dismissAnimation$1$1 implements Animation.AnimationListener {
    final /* synthetic */ View $goneView;
    final /* synthetic */ AlphaAnimation $showAnimation;
    final /* synthetic */ View $visibleView;
    final /* synthetic */ CommentTitleAuthorImpl this$0;

    CommentTitleAuthorImpl$updateStyle$dismissAnimation$1$1(CommentTitleAuthorImpl $receiver, View $goneView2, View $visibleView2, AlphaAnimation $showAnimation2) {
        this.this$0 = $receiver;
        this.$goneView = $goneView2;
        this.$visibleView = $visibleView2;
        this.$showAnimation = $showAnimation2;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.this$0.needChangeStyle) {
            this.$goneView.setVisibility(8);
            this.$visibleView.setVisibility(0);
            this.$visibleView.startAnimation(this.$showAnimation);
            return;
        }
        this.$goneView.setVisibility(0);
        this.$visibleView.setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
