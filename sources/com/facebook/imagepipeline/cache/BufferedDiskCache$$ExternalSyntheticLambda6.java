package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BufferedDiskCache$$ExternalSyntheticLambda6 implements Callable {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ BufferedDiskCache f$1;
    public final /* synthetic */ CacheKey f$2;

    public /* synthetic */ BufferedDiskCache$$ExternalSyntheticLambda6(Object obj, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        this.f$0 = obj;
        this.f$1 = bufferedDiskCache;
        this.f$2 = cacheKey;
    }

    public final Object call() {
        return BufferedDiskCache.m8188probe$lambda2(this.f$0, this.f$1, this.f$2);
    }
}
