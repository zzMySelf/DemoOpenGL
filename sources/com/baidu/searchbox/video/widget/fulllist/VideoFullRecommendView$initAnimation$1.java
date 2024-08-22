package com.baidu.searchbox.video.widget.fulllist;

import android.view.animation.Animation;
import com.baidu.searchbox.video.detail.utils.AnimationListenerAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/widget/fulllist/VideoFullRecommendView$initAnimation$1", "Lcom/baidu/searchbox/video/detail/utils/AnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFullRecommendView.kt */
public final class VideoFullRecommendView$initAnimation$1 extends AnimationListenerAdapter {
    final /* synthetic */ VideoFullRecommendView this$0;

    VideoFullRecommendView$initAnimation$1(VideoFullRecommendView $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        this.this$0.detachFromParentNoAnim();
    }
}
