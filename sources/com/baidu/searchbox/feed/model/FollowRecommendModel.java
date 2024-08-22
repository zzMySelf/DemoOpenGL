package com.baidu.searchbox.feed.model;

import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataStarScroll;
import com.baidu.searchbox.feed.model.outcomment.CmdBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/model/FollowRecommendModel;", "", "()V", "items", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/model/FeedItemDataStarScroll$StarScrollItemData;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "lastShow", "", "getLastShow", "()Z", "setLastShow", "(Z)V", "store", "", "getStore", "()Ljava/lang/String;", "setStore", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowRecommendData.kt */
public final class FollowRecommendModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_CMD = "cmd";
    private static final String KEY_CONTENT_UPDATE_MARK = "content_update_mark";
    private static final String KEY_DESC = "desc";
    private static final String KEY_ID = "id";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_STORE = "_store";
    private static final String KEY_TAGS = "tags";
    private static final String KEY_THIRD_ID = "third_id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TYPE = "type";
    private static final String KEY_V_TYPE = "vtype";
    private static final String KEY_V_URL = "v_url";
    private static final String SUCCESS = "0";
    private ArrayList<FeedItemDataStarScroll.StarScrollItemData> items = new ArrayList<>();
    private boolean lastShow;
    private String store = "uid";
    private String title = "";

    @JvmStatic
    public static final FollowRecommendModel toModel(String str, String str2) {
        return Companion.toModel(str, str2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getStore() {
        return this.store;
    }

    public final void setStore(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.store = str;
    }

    public final ArrayList<FeedItemDataStarScroll.StarScrollItemData> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<FeedItemDataStarScroll.StarScrollItemData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.items = arrayList;
    }

    public final boolean getLastShow() {
        return this.lastShow;
    }

    public final void setLastShow(boolean z) {
        this.lastShow = z;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/feed/model/FollowRecommendModel$Companion;", "", "()V", "KEY_CMD", "", "KEY_CONTENT_UPDATE_MARK", "KEY_DESC", "KEY_ID", "KEY_IMAGE", "KEY_ITEMS", "KEY_STORE", "KEY_TAGS", "KEY_THIRD_ID", "KEY_TITLE", "KEY_TYPE", "KEY_V_TYPE", "KEY_V_URL", "SUCCESS", "parseItem", "Lcom/baidu/searchbox/feed/model/FeedItemDataStarScroll$StarScrollItemData;", "jsonObj", "Lorg/json/JSONObject;", "source", "toModel", "Lcom/baidu/searchbox/feed/model/FollowRecommendModel;", "jsonString", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FollowRecommendData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ FollowRecommendModel toModel$default(Companion companion, String str, String str2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            return companion.toModel(str, str2);
        }

        @JvmStatic
        public final FollowRecommendModel toModel(String jsonString, String source) {
            Object obj;
            JSONObject jsonObject;
            String str;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                if (jsonString == null) {
                    str = "";
                } else {
                    str = jsonString;
                }
                obj = Result.m8971constructorimpl(new JSONObject(str));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m8977isFailureimpl(obj)) {
                obj = null;
            }
            JSONObject jsonObject2 = (JSONObject) obj;
            if (jsonObject2 == null || !Intrinsics.areEqual((Object) jsonObject2.optString("errno", ""), (Object) "0")) {
                return null;
            }
            FollowRecommendModel followRecommendModel = new FollowRecommendModel();
            FollowRecommendModel $this$toModel_u24lambda_u2d5 = followRecommendModel;
            JSONObject dataJson = jsonObject2.optJSONObject("data");
            if (dataJson != null) {
                Intrinsics.checkNotNullExpressionValue(dataJson, "optJSONObject(\"data\")");
                String optString = dataJson.optString("title");
                Intrinsics.checkNotNullExpressionValue(optString, "dataJson.optString(KEY_TITLE)");
                $this$toModel_u24lambda_u2d5.setTitle(optString);
                String optString2 = dataJson.optString(FollowRecommendModel.KEY_STORE);
                Intrinsics.checkNotNullExpressionValue(optString2, "dataJson.optString(KEY_STORE)");
                $this$toModel_u24lambda_u2d5.setStore(optString2);
                JSONArray itemsJson = dataJson.optJSONArray("items");
                if (itemsJson != null) {
                    Intrinsics.checkNotNullExpressionValue(itemsJson, "optJSONArray(KEY_ITEMS)");
                    int i2 = 0;
                    int length = itemsJson.length();
                    while (i2 < length) {
                        JSONObject itemJson = itemsJson.optJSONObject(i2);
                        if (itemJson != null) {
                            Intrinsics.checkNotNullExpressionValue(itemJson, "optJSONObject(i)");
                            FeedItemDataStarScroll.StarScrollItemData it = FollowRecommendModel.Companion.parseItem(itemJson, source);
                            if (it != null) {
                                jsonObject = jsonObject2;
                                $this$toModel_u24lambda_u2d5.getItems().add(it);
                            } else {
                                jsonObject = jsonObject2;
                            }
                        } else {
                            String str2 = source;
                            jsonObject = jsonObject2;
                        }
                        i2++;
                        jsonObject2 = jsonObject;
                    }
                    String str3 = source;
                    JSONObject jSONObject = jsonObject2;
                } else {
                    String str4 = source;
                    JSONObject jSONObject2 = jsonObject2;
                }
            } else {
                String str5 = source;
                JSONObject jSONObject3 = jsonObject2;
            }
            return followRecommendModel;
        }

        static /* synthetic */ FeedItemDataStarScroll.StarScrollItemData parseItem$default(Companion companion, JSONObject jSONObject, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            return companion.parseItem(jSONObject, str);
        }

        private final FeedItemDataStarScroll.StarScrollItemData parseItem(JSONObject jsonObj, String source) {
            FeedItemDataStarScroll.StarScrollItemData starScrollItemData = new FeedItemDataStarScroll.StarScrollItemData();
            FeedItemDataStarScroll.StarScrollItemData $this$parseItem_u24lambda_u2d9 = starScrollItemData;
            if (jsonObj != null) {
                JSONObject it = jsonObj;
                $this$parseItem_u24lambda_u2d9.id = it.optString("id");
                $this$parseItem_u24lambda_u2d9.image = it.optString("image");
                $this$parseItem_u24lambda_u2d9.title = new FeedItemDataStarScroll.StarScrollItemData.Title();
                $this$parseItem_u24lambda_u2d9.title.text = it.optString("title");
                $this$parseItem_u24lambda_u2d9.title.align = "center";
                $this$parseItem_u24lambda_u2d9.desc = new FeedItemDataStarScroll.StarScrollItemData.Desc();
                $this$parseItem_u24lambda_u2d9.desc.text = it.optString("desc");
                $this$parseItem_u24lambda_u2d9.desc.align = "center";
                $this$parseItem_u24lambda_u2d9.vtype = it.optString("vtype");
                $this$parseItem_u24lambda_u2d9.vUrl = it.optString(FollowRecommendModel.KEY_V_URL);
                $this$parseItem_u24lambda_u2d9.followInfo = new FeedItemData.AdditionalInfo();
                $this$parseItem_u24lambda_u2d9.followInfo.type = it.optString("type");
                $this$parseItem_u24lambda_u2d9.followInfo.thirdId = it.optString("third_id");
                $this$parseItem_u24lambda_u2d9.followInfo.sFrom = "sbox";
                CharSequence charSequence = source;
                $this$parseItem_u24lambda_u2d9.followInfo.source = charSequence == null || charSequence.length() == 0 ? FollowRecommendConfigKt.DEFAULT_SOURCE : source;
                $this$parseItem_u24lambda_u2d9.followInfo.button = new FeedItemData.AdditionalInfo.FollowButton();
                $this$parseItem_u24lambda_u2d9.followInfo.button.state = "0";
                $this$parseItem_u24lambda_u2d9.followInfo.button.buttonDatas = new ArrayList<>();
                $this$parseItem_u24lambda_u2d9.followInfo.button.buttonDatas.add(FeedItemData.AdditionalInfo.FollowButton.ButtonData.defaultUnFollow());
                $this$parseItem_u24lambda_u2d9.followInfo.button.buttonDatas.add(FeedItemData.AdditionalInfo.FollowButton.ButtonData.defaultFollowed());
                $this$parseItem_u24lambda_u2d9.cmdBean = new CmdBean().toModel(it.optJSONObject("cmd"));
                JSONArray $this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6 = it.optJSONArray("tags");
                if ($this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6 != null) {
                    Intrinsics.checkNotNullExpressionValue($this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6, "optJSONArray(KEY_TAGS)");
                    int length = $this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.length();
                    for (int index = 0; index < length; index++) {
                        String tag = (String) $this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d6.get(index);
                        CharSequence charSequence2 = tag;
                        if (!(charSequence2 == null || charSequence2.length() == 0)) {
                            $this$parseItem_u24lambda_u2d9.tags.add(tag);
                        }
                    }
                }
                JSONArray $this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7 = it.optJSONArray(FollowRecommendModel.KEY_CONTENT_UPDATE_MARK);
                if ($this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7 != null) {
                    Intrinsics.checkNotNullExpressionValue($this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7, "optJSONArray(KEY_CONTENT_UPDATE_MARK)");
                    int length2 = $this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.length();
                    for (int index2 = 0; index2 < length2; index2++) {
                        String mark = (String) $this$parseItem_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.get(index2);
                        CharSequence charSequence3 = mark;
                        if (!(charSequence3 == null || charSequence3.length() == 0)) {
                            $this$parseItem_u24lambda_u2d9.contentUpdateMark.add(mark);
                        }
                    }
                }
                if ($this$parseItem_u24lambda_u2d9.tags.isEmpty() || $this$parseItem_u24lambda_u2d9.contentUpdateMark.isEmpty()) {
                    return null;
                }
            }
            return starScrollItemData;
        }
    }
}
