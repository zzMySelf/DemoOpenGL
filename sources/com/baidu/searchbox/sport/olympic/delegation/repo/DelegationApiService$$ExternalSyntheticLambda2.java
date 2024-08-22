package com.baidu.searchbox.sport.olympic.delegation.repo;

import java.util.Map;
import rx.Single;
import rx.SingleSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DelegationApiService$$ExternalSyntheticLambda2 implements Single.OnSubscribe {
    public final /* synthetic */ DelegationApiService f$0;
    public final /* synthetic */ Map f$1;

    public /* synthetic */ DelegationApiService$$ExternalSyntheticLambda2(DelegationApiService delegationApiService, Map map) {
        this.f$0 = delegationApiService;
        this.f$1 = map;
    }

    public final void call(Object obj) {
        DelegationApiService.m3395getDelegationPageModel$lambda0(this.f$0, this.f$1, (SingleSubscriber) obj);
    }
}
