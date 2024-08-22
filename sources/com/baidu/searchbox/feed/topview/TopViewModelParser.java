package com.baidu.searchbox.feed.topview;

import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.parser.ValidationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/topview/TopViewModelParser;", "", "()V", "parse", "Lcom/baidu/searchbox/feed/topview/FeedTopViewModel;", "json", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopViewModelParser.kt */
public final class TopViewModelParser {
    public final FeedTopViewModel parse(String json) {
        JSONObject it;
        int position;
        String optString;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject itemObject = null;
        if (json.length() == 0) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(json).optJSONObject("data");
            if (optJSONObject != null) {
                itemObject = optJSONObject.optJSONObject(FeedTopViewRequesterKt.CMD);
            }
            if (itemObject == null || (it = itemObject.optJSONObject("item")) == null) {
                return null;
            }
            Object parse = FeedApi.DataParsers.defaultBaseModelConfig().build().parse(it);
            Intrinsics.checkNotNullExpressionValue(parse, "parser.parse(it)");
            FeedBaseModel feedBaseModel = (FeedBaseModel) parse;
            ValidationResult result = FeedBaseModel.checkValidate(feedBaseModel);
            Intrinsics.checkNotNullExpressionValue(result, "checkValidate(feedBaseModel)");
            if (!result.isOk()) {
                return null;
            }
            JSONObject optJSONObject2 = itemObject.optJSONObject("policies");
            if (optJSONObject2 == null || (optString = optJSONObject2.optString("position")) == null || (intOrNull = StringsKt.toIntOrNull(optString)) == null) {
                position = -1;
            } else {
                position = intOrNull.intValue();
            }
            return new FeedTopViewModel(feedBaseModel, position);
        } catch (JSONException e2) {
            return null;
        }
    }
}
