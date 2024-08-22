package com.baidu.searchbox.mall.comp.sug.repo;

import com.baidu.searchbox.hissug.searchable.WebSearchable;
import com.baidu.searchbox.mall.comp.sug.model.SuggestionData;
import com.baidu.searchbox.mall.repo.MallApiService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/mall/comp/sug/repo/SugRepo;", "Lcom/baidu/searchbox/mall/repo/MallApiService;", "()V", "loadSugData", "Lrx/Observable;", "Lcom/baidu/searchbox/mall/comp/sug/model/SuggestionData;", "query", "", "sugId", "loadSugData$lib_search_mall_release", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SugRepo.kt */
public final class SugRepo extends MallApiService {
    public final Observable<SuggestionData> loadSugData$lib_search_mall_release(String query, String sugId) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(sugId, "sugId");
        Observable<SuggestionData> create = Observable.create(new SugRepo$$ExternalSyntheticLambda0(this, MapsKt.mapOf(TuplesKt.to("query", query), TuplesKt.to(WebSearchable.EXTRA_SUGID, sugId))));
        Intrinsics.checkNotNullExpressionValue(create, "create {\n            sen…\n            })\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSugData$lambda-0  reason: not valid java name */
    public static final void m416loadSugData$lambda0(SugRepo this$0, Map $params, Subscriber it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($params, "$params");
        String appendMappingParams = this$0.appendMappingParams(SugRepoKt.GET_SUG_URL);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        MallApiService.sendGetRequest$default((MallApiService) this$0, appendMappingParams, $params, it, (Function1) SugRepo$loadSugData$1$1.INSTANCE, 0, 16, (Object) null);
    }
}
