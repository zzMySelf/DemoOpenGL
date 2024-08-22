package com.baidu.searchbox.aisearch.comps.conversationmanager.repo;

import com.baidu.searchbox.aisearch.comps.conversationmanager.model.AIBotModel;
import com.baidu.searchbox.aisearch.repo.AISearchApiService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/repo/AIBotRepo;", "Lcom/baidu/searchbox/aisearch/repo/AISearchApiService;", "()V", "getAIBotList", "Lrx/Single;", "Lcom/baidu/searchbox/aisearch/comps/conversationmanager/model/AIBotModel;", "pagesize", "", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBotRepo.kt */
public final class AIBotRepo extends AISearchApiService {
    public static /* synthetic */ Single getAIBotList$default(AIBotRepo aIBotRepo, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 20;
        }
        return aIBotRepo.getAIBotList(i2);
    }

    public final Single<AIBotModel> getAIBotList(int pagesize) {
        Single<AIBotModel> create = Single.create(new AIBotRepo$$ExternalSyntheticLambda0(this, MapsKt.mapOf(TuplesKt.to("pagesize", String.valueOf(pagesize)))));
        Intrinsics.checkNotNullExpressionValue(create, "create {\n            sen…)\n            }\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAIBotList$lambda-0  reason: not valid java name */
    public static final void m15726getAIBotList$lambda0(AIBotRepo this$0, Map $params, SingleSubscriber it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($params, "$params");
        String access$getAI_BOT_REQUEST_URL$p = AIBotRepoKt.AI_BOT_REQUEST_URL;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.sendGetRequest(access$getAI_BOT_REQUEST_URL$p, $params, it, AIBotRepo$getAIBotList$1$1.INSTANCE);
    }
}
