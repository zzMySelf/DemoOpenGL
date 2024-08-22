package com.baidu.searchbox.padhome;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.config.eventmessage.HomeTabClickEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PadHomeView$$ExternalSyntheticLambda7 implements Action {
    public final /* synthetic */ PadHomeView f$0;

    public /* synthetic */ PadHomeView$$ExternalSyntheticLambda7(PadHomeView padHomeView) {
        this.f$0 = padHomeView;
    }

    public final void call(Object obj) {
        PadHomeView.m1862registerListeners$lambda16(this.f$0, (HomeTabClickEvent) obj);
    }
}
