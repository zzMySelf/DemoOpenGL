package com.baidu.searchbox.video.detail.plugin.component.collection.model;

import android.text.TextUtils;
import com.baidu.searchbox.feed.model.FeedBackData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.utils.FeedModelFactory;
import com.baidu.searchbox.video.template.collection.detailcomp.FeedItemDataVideoCollectionFloating;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"fromJson", "Lcom/baidu/searchbox/video/detail/plugin/component/collection/model/CollectionModel;", "jsonObject", "Lorg/json/JSONObject;", "lib-detail-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionModel.kt */
public final class CollectionModelKt {
    public static final CollectionModel fromJson(JSONObject jsonObject) {
        CollectionModel collectionModel = new CollectionModel();
        if (jsonObject == null) {
            return collectionModel;
        }
        collectionModel.setHasPrev(jsonObject.optBoolean("hasPrev"));
        collectionModel.setHasNext(jsonObject.optBoolean("hasNext"));
        collectionModel.setShowNum(jsonObject.optInt("showNum"));
        String optString = jsonObject.optString("collectionTitle");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"collectionTitle\")");
        collectionModel.setCollectionTitle(optString);
        String optString2 = jsonObject.optString("collId");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"collId\")");
        collectionModel.setCollId(optString2);
        String optString3 = jsonObject.optString("curIndex", "0");
        Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(\"curIndex\", \"0\")");
        collectionModel.setCurrentIndex(Integer.parseInt(optString3));
        collectionModel.setShowOrderNum(TextUtils.equals(jsonObject.optString("showOrderNum"), "1"));
        String optString4 = jsonObject.optString("source");
        Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"source\")");
        collectionModel.setSource(optString4);
        JSONObject headerObj = jsonObject.optJSONObject("header");
        String optString5 = headerObj != null ? headerObj.optString("videoNum") : null;
        String str = "";
        if (optString5 == null) {
            optString5 = str;
        }
        collectionModel.setVideoNum(optString5);
        String optString6 = headerObj != null ? headerObj.optString("playNum") : null;
        if (optString6 == null) {
            optString6 = str;
        }
        collectionModel.setPlayNum(optString6);
        String optString7 = headerObj != null ? headerObj.optString("desc") : null;
        if (optString7 != null) {
            str = optString7;
        }
        collectionModel.setDesc(str);
        JSONArray listArray = jsonObject.optJSONArray("list");
        if (listArray != null) {
            JSONArray jSONArray = listArray;
            int index = 0;
            int length = listArray.length();
            while (index < length) {
                Object obj = listArray.get(index);
                if (obj != null) {
                    JSONObject itemObj = (JSONObject) obj;
                    FeedBaseModel feedBaseModel = FeedModelFactory.createNormalBaseModel();
                    Intrinsics.checkNotNullExpressionValue(feedBaseModel, "createNormalBaseModel()");
                    feedBaseModel.layout = itemObj.optString("layout");
                    feedBaseModel.id = itemObj.optString("id");
                    FeedItemDataVideoCollectionFloating data = new FeedItemDataVideoCollectionFloating();
                    JSONObject optJSONObject = itemObj.optJSONObject("data");
                    data.toModel(optJSONObject != null ? optJSONObject.put("showOrderNum", collectionModel.getShowOrderNum()) : null);
                    feedBaseModel.data = data;
                    feedBaseModel.feedback = FeedBackData.parseFromJSON(itemObj.optJSONObject("feedback"));
                    collectionModel.getList().add(feedBaseModel);
                    index++;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
        }
        return collectionModel;
    }
}
