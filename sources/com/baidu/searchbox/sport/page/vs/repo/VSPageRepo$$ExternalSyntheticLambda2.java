package com.baidu.searchbox.sport.page.vs.repo;

import com.baidu.searchbox.sport.repo.SportApiResult;
import rx.functions.Func1;
import rx.subjects.ReplaySubject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VSPageRepo$$ExternalSyntheticLambda2 implements Func1 {
    public final /* synthetic */ ReplaySubject f$0;

    public /* synthetic */ VSPageRepo$$ExternalSyntheticLambda2(ReplaySubject replaySubject) {
        this.f$0 = replaySubject;
    }

    public final Object call(Object obj) {
        return VSPageRepo.m4169getPageModel$lambda3(this.f$0, (SportApiResult) obj);
    }
}
