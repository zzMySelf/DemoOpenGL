package com.baidu.searchbox.mall.comp.his.repo;

import rx.SingleSubscriber;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchHisRepo$$ExternalSyntheticLambda16 implements Action1 {
    public final /* synthetic */ SingleSubscriber f$0;

    public /* synthetic */ SearchHisRepo$$ExternalSyntheticLambda16(SingleSubscriber singleSubscriber) {
        this.f$0 = singleSubscriber;
    }

    public final void call(Object obj) {
        SearchHisRepo.m350deleteAll$lambda9$lambda7(this.f$0, (Boolean) obj);
    }
}
