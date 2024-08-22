package com.baidu.searchbox.aibot.repo.collect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/aibot/repo/collect/AIBotCollectModel;", "json", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBotCollectRepo.kt */
final class AIBotCollectRepo$addCollectPostRequest$1$1 extends Lambda implements Function1<JSONObject, AIBotCollectModel> {
    public static final AIBotCollectRepo$addCollectPostRequest$1$1 INSTANCE = new AIBotCollectRepo$addCollectPostRequest$1$1();

    AIBotCollectRepo$addCollectPostRequest$1$1() {
        super(1);
    }

    public final AIBotCollectModel invoke(JSONObject json) {
        return AIBotCollectModel.Companion.fromJson(0, json);
    }
}
