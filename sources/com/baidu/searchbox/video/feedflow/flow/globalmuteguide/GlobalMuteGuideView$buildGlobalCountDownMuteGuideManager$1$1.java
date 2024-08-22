package com.baidu.searchbox.video.feedflow.flow.globalmuteguide;

import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalCountDownMuteGuideManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/globalmuteguide/GlobalMuteGuideView$buildGlobalCountDownMuteGuideManager$1$1", "Lcom/baidu/searchbox/video/feedflow/flow/globalmuteguide/GlobalCountDownMuteGuideManager$ICountDownMuteGuideListener;", "onCountDownGuideEnd", "", "onCountDownGuideStart", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlobalMuteGuideView.kt */
public final class GlobalMuteGuideView$buildGlobalCountDownMuteGuideManager$1$1 implements GlobalCountDownMuteGuideManager.ICountDownMuteGuideListener {
    final /* synthetic */ GlobalMuteGuideView this$0;

    GlobalMuteGuideView$buildGlobalCountDownMuteGuideManager$1$1(GlobalMuteGuideView $receiver) {
        this.this$0 = $receiver;
    }

    public void onCountDownGuideStart() {
        Function0<Unit> onCancelMuteGuideStart = this.this$0.getOnCancelMuteGuideStart();
        if (onCancelMuteGuideStart != null) {
            onCancelMuteGuideStart.invoke();
        }
    }

    public void onCountDownGuideEnd() {
        Function0<Unit> onCancelMuteGuideEnd = this.this$0.getOnCancelMuteGuideEnd();
        if (onCancelMuteGuideEnd != null) {
            onCancelMuteGuideEnd.invoke();
        }
    }
}
