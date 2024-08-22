package com.baidu.searchbox.video.feedflow;

import android.view.View;
import com.baidu.searchbox.video.feedflow.common.IPageRightSlideListenerService;
import com.baidu.searchbox.video.feedflow.flow.list.OnPanelOpenedAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnPanelSlideCloseAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnPanelSlideStartAction;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/video/feedflow/VideoFlowActivity$addSlideExtraListener$1", "Lcom/baidu/searchbox/widget/SlidingPaneLayout$PanelSlideListener;", "onPanelClosed", "", "view", "Landroid/view/View;", "onPanelOpened", "onPanelSlide", "v", "", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowActivity.kt */
public final class VideoFlowActivity$addSlideExtraListener$1 implements SlidingPaneLayout.PanelSlideListener {
    final /* synthetic */ VideoFlowActivity this$0;

    VideoFlowActivity$addSlideExtraListener$1(VideoFlowActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onPanelSlide(View view2, float v) {
        IPageRightSlideListenerService iPageRightSlideListenerService = (IPageRightSlideListenerService) this.this$0.getComponentManager().getService(IPageRightSlideListenerService.class);
        if (iPageRightSlideListenerService != null) {
            iPageRightSlideListenerService.onPanelSlide(view2, v);
        }
        if (!this.this$0.isOnPanelSlide) {
            this.this$0.isOnPanelSlide = true;
            this.this$0.getStore().dispatch(OnPanelSlideStartAction.INSTANCE);
        }
    }

    public void onPanelOpened(View view2) {
        this.this$0.isSlideFinish = true;
        IPageRightSlideListenerService iPageRightSlideListenerService = (IPageRightSlideListenerService) this.this$0.getComponentManager().getService(IPageRightSlideListenerService.class);
        if (iPageRightSlideListenerService != null) {
            iPageRightSlideListenerService.onPanelOpened(view2);
        }
        this.this$0.getStore().dispatch(OnPanelOpenedAction.INSTANCE);
    }

    public void onPanelClosed(View view2) {
        IPageRightSlideListenerService iPageRightSlideListenerService = (IPageRightSlideListenerService) this.this$0.getComponentManager().getService(IPageRightSlideListenerService.class);
        if (iPageRightSlideListenerService != null) {
            iPageRightSlideListenerService.onPanelClosed(view2);
        }
        this.this$0.isOnPanelSlide = false;
        this.this$0.getStore().dispatch(OnPanelSlideCloseAction.INSTANCE);
    }
}
