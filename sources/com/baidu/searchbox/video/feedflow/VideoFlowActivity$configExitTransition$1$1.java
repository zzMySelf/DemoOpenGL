package com.baidu.searchbox.video.feedflow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.UbcBean;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.video.feedflow.common.IPageRightSlideListenerService;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.hotguide.HotGuideState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.tab.homebubble.HomeBarBubbleController;
import com.baidu.searchbox.video.feedflow.update.FlowHomeBottomBarSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/VideoFlowActivity$configExitTransition$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowActivity.kt */
public final class VideoFlowActivity$configExitTransition$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ VideoFlowActivity this$0;

    VideoFlowActivity$configExitTransition$1$1(VideoFlowActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        IPageRightSlideListenerService iPageRightSlideListenerService = (IPageRightSlideListenerService) this.this$0.getComponentManager().getService(IPageRightSlideListenerService.class);
        if (iPageRightSlideListenerService != null) {
            iPageRightSlideListenerService.onPageScaleStart();
        }
        State state = this.this$0.getStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(HotGuideState.class);
        }
        HotGuideState hotGuideState = (HotGuideState) obj;
        boolean z = true;
        if (hotGuideState == null || !hotGuideState.getIfPlay()) {
            z = false;
        }
        if (z) {
            DIFactory.INSTANCE.prepareHomeTabIconAnim();
        }
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        IPageRightSlideListenerService iPageRightSlideListenerService = (IPageRightSlideListenerService) this.this$0.getComponentManager().getService(IPageRightSlideListenerService.class);
        if (iPageRightSlideListenerService != null) {
            iPageRightSlideListenerService.onPageScaleClosed();
        }
        State state = this.this$0.getStore().getState();
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        HotGuideState hotGuideState = (HotGuideState) (commonState != null ? commonState.select(HotGuideState.class) : null);
        if (hotGuideState != null && hotGuideState.getIfPlay()) {
            HomeBarBubbleController homeBarBubbleController = HomeBarBubbleController.INSTANCE;
            State state2 = this.this$0.getStore().getState();
            CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
            UbcBean ubcBean = (UbcBean) (commonState2 != null ? commonState2.select(UbcBean.class) : null);
            ItemModel access$getCurItemModel = this.this$0.getCurItemModel();
            homeBarBubbleController.playHomeTabIconAndShowBubble(ubcBean, access$getCurItemModel != null ? access$getCurItemModel.getNid() : null);
            FlowHomeBottomBarSwitcher.INSTANCE.updateShowCount();
            VideoFlowActivity.tryShowHomeBarVideoLackGuide$default(this.this$0, false, 1, (Object) null);
        }
        this.this$0.saveCurrentVideoCache();
    }
}
