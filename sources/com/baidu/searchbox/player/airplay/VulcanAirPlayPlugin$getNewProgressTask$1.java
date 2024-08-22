package com.baidu.searchbox.player.airplay;

import android.widget.FrameLayout;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/player/airplay/VulcanAirPlayPlugin$getNewProgressTask$1", "Ljava/util/TimerTask;", "run", "", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanAirPlayPlugin.kt */
public final class VulcanAirPlayPlugin$getNewProgressTask$1 extends TimerTask {
    final /* synthetic */ VulcanAirPlayPlugin this$0;

    VulcanAirPlayPlugin$getNewProgressTask$1(VulcanAirPlayPlugin $receiver) {
        this.this$0 = $receiver;
    }

    /* access modifiers changed from: private */
    /* renamed from: run$lambda-0  reason: not valid java name */
    public static final void m2287run$lambda0(VulcanAirPlayPlugin this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.handleProgress();
    }

    public void run() {
        FrameLayout frameLayout;
        VulcanAirPlayLayer airPlayLayer = this.this$0.getAirPlayLayer();
        if (airPlayLayer != null && (frameLayout = (FrameLayout) airPlayLayer.getContentView()) != null) {
            frameLayout.post(new VulcanAirPlayPlugin$getNewProgressTask$1$$ExternalSyntheticLambda0(this.this$0));
        }
    }
}
