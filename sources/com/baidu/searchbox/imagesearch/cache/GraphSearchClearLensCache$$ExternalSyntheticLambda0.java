package com.baidu.searchbox.imagesearch.cache;

import com.baidu.searchbox.download.center.clearcache.BaseClearCache;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphSearchClearLensCache$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BaseClearCache.CacheClearCallback f$0;

    public /* synthetic */ GraphSearchClearLensCache$$ExternalSyntheticLambda0(BaseClearCache.CacheClearCallback cacheClearCallback) {
        this.f$0 = cacheClearCallback;
    }

    public final void run() {
        GraphSearchClearLensCache.m20378clearCache$lambda0(this.f$0);
    }
}
