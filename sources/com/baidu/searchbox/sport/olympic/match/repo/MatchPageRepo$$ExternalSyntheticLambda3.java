package com.baidu.searchbox.sport.olympic.match.repo;

import rx.SingleSubscriber;
import rx.functions.Action1;
import rx.subjects.ReplaySubject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MatchPageRepo$$ExternalSyntheticLambda3 implements Action1 {
    public final /* synthetic */ SingleSubscriber f$0;
    public final /* synthetic */ ReplaySubject f$1;

    public /* synthetic */ MatchPageRepo$$ExternalSyntheticLambda3(SingleSubscriber singleSubscriber, ReplaySubject replaySubject) {
        this.f$0 = singleSubscriber;
        this.f$1 = replaySubject;
    }

    public final void call(Object obj) {
        MatchPageRepo.m3508preloadMatchPageModel$lambda3(this.f$0, this.f$1, (Throwable) obj);
    }
}
