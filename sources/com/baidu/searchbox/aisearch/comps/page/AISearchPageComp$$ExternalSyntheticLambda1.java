package com.baidu.searchbox.aisearch.comps.page;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import java.util.Set;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AISearchPageComp$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ AISearchPageComp f$0;
    public final /* synthetic */ Set f$1;

    public /* synthetic */ AISearchPageComp$$ExternalSyntheticLambda1(AISearchPageComp aISearchPageComp, Set set) {
        this.f$0 = aISearchPageComp;
        this.f$1 = set;
    }

    public final boolean apply(Object obj) {
        return AISearchPageComp.m15799clearMemoryCaches$lambda15$lambda14(this.f$0, this.f$1, (CacheKey) obj);
    }
}
