package com.baidu.searchbox.paywall.basic;

import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PaywallBasicPresenter$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ CacheCallbck f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;

    public /* synthetic */ PaywallBasicPresenter$$ExternalSyntheticLambda2(CacheCallbck cacheCallbck, Ref.ObjectRef objectRef) {
        this.f$0 = cacheCallbck;
        this.f$1 = objectRef;
    }

    public final void run() {
        PaywallBasicPresenter.m1901loadCacheAsync$lambda4$lambda3(this.f$0, this.f$1);
    }
}
