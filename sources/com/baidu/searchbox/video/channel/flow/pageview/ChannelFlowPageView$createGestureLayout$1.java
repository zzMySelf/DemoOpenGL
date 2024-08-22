package com.baidu.searchbox.video.channel.flow.pageview;

import android.view.MotionEvent;
import com.baidu.searchbox.video.channel.flow.pageview.drawer.IChannelDrawer;
import com.baidu.searchbox.video.feedflow.utils.SideGestureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/channel/flow/pageview/ChannelFlowPageView$createGestureLayout$1", "Lcom/baidu/searchbox/video/feedflow/utils/SideGestureManager$OnGsCallback;", "isSwitchOpen", "", "event", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowPageView.kt */
public final class ChannelFlowPageView$createGestureLayout$1 implements SideGestureManager.OnGsCallback {
    final /* synthetic */ ChannelFlowPageView this$0;

    ChannelFlowPageView$createGestureLayout$1(ChannelFlowPageView $receiver) {
        this.this$0 = $receiver;
    }

    public int getBottomOffset() {
        return SideGestureManager.OnGsCallback.DefaultImpls.getBottomOffset(this);
    }

    public Boolean isTouchInHotZone(MotionEvent event) {
        return SideGestureManager.OnGsCallback.DefaultImpls.isTouchInHotZone(this, event);
    }

    public void onTouchUp() {
        SideGestureManager.OnGsCallback.DefaultImpls.onTouchUp(this);
    }

    public Boolean isSwitchOpen(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        IChannelDrawer drawerManager = this.this$0.getDrawerManager();
        boolean z = false;
        if (drawerManager != null && drawerManager.isDrawerOpen()) {
            z = true;
        }
        return Boolean.valueOf(!z);
    }
}
