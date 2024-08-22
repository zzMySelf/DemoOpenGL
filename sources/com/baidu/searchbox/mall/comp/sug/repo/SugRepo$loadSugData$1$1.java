package com.baidu.searchbox.mall.comp.sug.repo;

import com.baidu.searchbox.mall.comp.sug.model.SuggestionData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/mall/comp/sug/model/SuggestionData;", "jsonObject", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SugRepo.kt */
final class SugRepo$loadSugData$1$1 extends Lambda implements Function1<JSONObject, SuggestionData> {
    public static final SugRepo$loadSugData$1$1 INSTANCE = new SugRepo$loadSugData$1$1();

    SugRepo$loadSugData$1$1() {
        super(1);
    }

    public final SuggestionData invoke(JSONObject jsonObject) {
        return SuggestionData.Companion.parseFromJson(jsonObject);
    }
}
