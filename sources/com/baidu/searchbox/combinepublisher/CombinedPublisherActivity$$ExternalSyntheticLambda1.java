package com.baidu.searchbox.combinepublisher;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.ugc.event.CombinePublisherEvent;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CombinedPublisherActivity$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ CombinedPublisherActivity f$0;
    public final /* synthetic */ UgcSchemeModel f$1;

    public /* synthetic */ CombinedPublisherActivity$$ExternalSyntheticLambda1(CombinedPublisherActivity combinedPublisherActivity, UgcSchemeModel ugcSchemeModel) {
        this.f$0 = combinedPublisherActivity;
        this.f$1 = ugcSchemeModel;
    }

    public final void call(Object obj) {
        CombinedPublisherActivity.m16691initData$lambda4(this.f$0, this.f$1, (CombinePublisherEvent) obj);
    }
}
