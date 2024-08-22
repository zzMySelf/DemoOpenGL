package com.baidu.searchbox.aisearch.comps.aicard.repo;

import com.baidu.searchbox.aisearch.comps.aicard.model.AICardModel;
import com.baidu.searchbox.aisearch.repo.AISearchApiService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/aicard/repo/AIBusinessCardRepo;", "Lcom/baidu/searchbox/aisearch/repo/AISearchApiService;", "()V", "getAICardInfo", "Lrx/Single;", "Lcom/baidu/searchbox/aisearch/comps/aicard/model/AICardModel;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBusinessCardRepo.kt */
public final class AIBusinessCardRepo extends AISearchApiService {
    public final Single<AICardModel> getAICardInfo() {
        Single<AICardModel> create = Single.create(new AIBusinessCardRepo$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(create, "create {\n            sen…)\n            }\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAICardInfo$lambda-0  reason: not valid java name */
    public static final void m15143getAICardInfo$lambda0(AIBusinessCardRepo this$0, SingleSubscriber it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String access$getBUSINESS_CARD_REQUEST_URL$p = AIBusinessCardRepoKt.BUSINESS_CARD_REQUEST_URL;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.sendGetRequest(access$getBUSINESS_CARD_REQUEST_URL$p, (Map<String, String>) null, it, AIBusinessCardRepo$getAICardInfo$1$1.INSTANCE);
    }
}
