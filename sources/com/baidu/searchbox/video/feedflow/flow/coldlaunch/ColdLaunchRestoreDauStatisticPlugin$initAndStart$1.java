package com.baidu.searchbox.video.feedflow.flow.coldlaunch;

import com.baidu.android.util.time.CountDownTimer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/coldlaunch/ColdLaunchRestoreDauStatisticPlugin$initAndStart$1", "Lcom/baidu/android/util/time/CountDownTimer$StatusListener;", "onFinish", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColdLaunchRestoreDauStatisticPlugin.kt */
public final class ColdLaunchRestoreDauStatisticPlugin$initAndStart$1 extends CountDownTimer.StatusListener {
    final /* synthetic */ ColdLaunchRestoreDauStatisticPlugin this$0;

    ColdLaunchRestoreDauStatisticPlugin$initAndStart$1(ColdLaunchRestoreDauStatisticPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onFinish() {
        this.this$0.report();
    }
}
