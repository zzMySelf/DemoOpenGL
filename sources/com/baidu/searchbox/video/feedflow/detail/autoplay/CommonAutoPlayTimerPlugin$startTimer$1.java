package com.baidu.searchbox.video.feedflow.detail.autoplay;

import com.baidu.searchbox.feed.detail.frame.Store;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/autoplay/CommonAutoPlayTimerPlugin$startTimer$1", "Lcom/baidu/searchbox/video/feedflow/detail/autoplay/IAutoPlayTimerCallback;", "onFinish", "", "onTick", "millisUntilFinished", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonAutoPlayTimerPlugin.kt */
public final class CommonAutoPlayTimerPlugin$startTimer$1 implements IAutoPlayTimerCallback {
    final /* synthetic */ CommonAutoPlayTimerPlugin this$0;

    CommonAutoPlayTimerPlugin$startTimer$1(CommonAutoPlayTimerPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onTick(long millisUntilFinished) {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new OnAutoPlayCountDownTickAction(millisUntilFinished));
        }
    }

    public void onFinish() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(OnAutoPlayCountDownFinishedAction.INSTANCE);
        }
    }
}
