package com.baidu.searchbox.video.feedflow.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.video.feedflow.view.VideoFlowRefreshHeaderView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/view/ChannelRefreshHeaderView$reverseWithLoading$2$onAnimationStart$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelRefreshHeaderView.kt */
public final class ChannelRefreshHeaderView$reverseWithLoading$2$onAnimationStart$2 extends AnimatorListenerAdapter {
    final /* synthetic */ Map<String, Object> $extend;
    final /* synthetic */ boolean $isPullDownRefresh;
    final /* synthetic */ ChannelRefreshHeaderView this$0;

    ChannelRefreshHeaderView$reverseWithLoading$2$onAnimationStart$2(ChannelRefreshHeaderView $receiver, boolean $isPullDownRefresh2, Map<String, ? extends Object> $extend2) {
        this.this$0 = $receiver;
        this.$isPullDownRefresh = $isPullDownRefresh2;
        this.$extend = $extend2;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.setRefreshing(true);
        VideoFlowRefreshHeaderView.RefreshStateListener refreshListener = this.this$0.getRefreshListener();
        if (refreshListener != null) {
            refreshListener.onRefresh(this.$isPullDownRefresh, this.$extend);
        }
    }
}
