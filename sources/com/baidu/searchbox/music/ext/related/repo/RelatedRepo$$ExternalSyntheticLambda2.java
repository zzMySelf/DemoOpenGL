package com.baidu.searchbox.music.ext.related.repo;

import rx.SingleSubscriber;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RelatedRepo$$ExternalSyntheticLambda2 implements Action1 {
    public final /* synthetic */ SingleSubscriber f$0;

    public /* synthetic */ RelatedRepo$$ExternalSyntheticLambda2(SingleSubscriber singleSubscriber) {
        this.f$0 = singleSubscriber;
    }

    public final void call(Object obj) {
        RelatedRepo.m1169loadRelatedModel$lambda2$lambda1(this.f$0, (Throwable) obj);
    }
}
