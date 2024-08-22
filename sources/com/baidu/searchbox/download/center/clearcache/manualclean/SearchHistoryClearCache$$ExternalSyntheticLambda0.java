package com.baidu.searchbox.download.center.clearcache.manualclean;

import com.baidu.searchbox.download.center.clearcache.BaseClearCache;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchHistoryClearCache$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BaseClearCache.CacheClearCallback f$0;

    public /* synthetic */ SearchHistoryClearCache$$ExternalSyntheticLambda0(BaseClearCache.CacheClearCallback cacheClearCallback) {
        this.f$0 = cacheClearCallback;
    }

    public final void run() {
        SearchHistoryClearCache.m17123clearCache$lambda0(this.f$0);
    }
}
