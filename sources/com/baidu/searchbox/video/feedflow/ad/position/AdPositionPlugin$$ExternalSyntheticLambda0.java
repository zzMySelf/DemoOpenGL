package com.baidu.searchbox.video.feedflow.ad.position;

import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import com.baidu.searchbox.bdeventbus.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AdPositionPlugin$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ AdPositionPlugin f$0;

    public /* synthetic */ AdPositionPlugin$$ExternalSyntheticLambda0(AdPositionPlugin adPositionPlugin) {
        this.f$0 = adPositionPlugin;
    }

    public final void call(Object obj) {
        AdPositionPlugin.m5643registerBackForegroundEvent$lambda16(this.f$0, (BdBoxActivityLifecycle.BackForegroundEvent) obj);
    }
}
