package com.baidu.searchbox.video.feedflow.ad.adform;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.feed.event.AdFormPopupWindowEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AdFormPopComponent$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ AdFormPopComponent f$0;

    public /* synthetic */ AdFormPopComponent$$ExternalSyntheticLambda0(AdFormPopComponent adFormPopComponent) {
        this.f$0 = adFormPopComponent;
    }

    public final void call(Object obj) {
        AdFormPopComponent.m5433registerPopWindowEventBus$lambda5(this.f$0, (AdFormPopupWindowEvent) obj);
    }
}
