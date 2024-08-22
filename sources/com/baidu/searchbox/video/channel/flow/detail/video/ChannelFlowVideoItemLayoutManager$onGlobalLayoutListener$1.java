package com.baidu.searchbox.video.channel.flow.detail.video;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/channel/flow/detail/video/ChannelFlowVideoItemLayoutManager$onGlobalLayoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowVideoItemLayoutManager.kt */
public final class ChannelFlowVideoItemLayoutManager$onGlobalLayoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ChannelFlowVideoItemLayoutManager this$0;

    ChannelFlowVideoItemLayoutManager$onGlobalLayoutListener$1(ChannelFlowVideoItemLayoutManager $receiver) {
        this.this$0 = $receiver;
    }

    public void onGlobalLayout() {
        RelativeLayout access$getPageContainerPortrait$p = this.this$0.pageContainerPortrait;
        if (access$getPageContainerPortrait$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContainerPortrait");
            access$getPageContainerPortrait$p = null;
        }
        access$getPageContainerPortrait$p.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.this$0.updateCenterContainerPosition();
    }
}
