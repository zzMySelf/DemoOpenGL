package com.baidu.searchbox.video.hotflow.flow;

import android.view.MotionEvent;
import com.baidu.searchbox.video.feedflow.detail.seekbar.ISeekBarService;
import com.baidu.searchbox.video.feedflow.view.VideoFlowGestureContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/hotflow/flow/HotFlowLayoutManager$initManager$2", "Lcom/baidu/searchbox/video/feedflow/view/VideoFlowGestureContainer$SeekBarCallbackListener;", "seekBarNeedConsume", "", "ev", "Landroid/view/MotionEvent;", "seekBarTouchEvent", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotFlowLayoutManager.kt */
public final class HotFlowLayoutManager$initManager$2 implements VideoFlowGestureContainer.SeekBarCallbackListener {
    final /* synthetic */ HotFlowLayoutManager this$0;

    HotFlowLayoutManager$initManager$2(HotFlowLayoutManager $receiver) {
        this.this$0 = $receiver;
    }

    public boolean seekBarNeedConsume(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        ISeekBarService iSeekBarService = (ISeekBarService) this.this$0.getManager().getService(ISeekBarService.class);
        if (iSeekBarService != null) {
            return iSeekBarService.consumeEvent(ev);
        }
        return false;
    }

    public boolean seekBarTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        ISeekBarService iSeekBarService = (ISeekBarService) this.this$0.getManager().getService(ISeekBarService.class);
        if (iSeekBarService != null) {
            return iSeekBarService.onTouchEvent(ev);
        }
        return false;
    }
}
