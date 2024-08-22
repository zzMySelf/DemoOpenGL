package com.baidu.searchbox.feed.parser;

import com.baidu.searchbox.feed.ad.model.AdModuleData;
import com.baidu.searchbox.feed.model.FeedItemData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/parser/AdModuleDataParser;", "Lcom/baidu/searchbox/feed/parser/FeedItemDataPartParser;", "()V", "fromJson", "", "jsonObject", "Lorg/json/JSONObject;", "itemData", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "toJson", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedItemDataPartParsers.kt */
public final class AdModuleDataParser implements FeedItemDataPartParser {
    public static final AdModuleDataParser INSTANCE = new AdModuleDataParser();

    private AdModuleDataParser() {
    }

    public void fromJson(JSONObject jsonObject, FeedItemData itemData) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        AdModuleData ad = itemData.ad;
        Intrinsics.checkNotNullExpressionValue(ad, "itemData.ad");
        ad.fromJson(jsonObject, itemData);
    }

    public void toJson(JSONObject jsonObject, FeedItemData itemData) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        AdModuleData ad = itemData.ad;
        Intrinsics.checkNotNullExpressionValue(ad, "itemData.ad");
        ad.toJson(jsonObject, itemData);
    }
}
