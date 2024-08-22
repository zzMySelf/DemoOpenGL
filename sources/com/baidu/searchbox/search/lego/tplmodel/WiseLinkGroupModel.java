package com.baidu.searchbox.search.lego.tplmodel;

import com.baidu.browser.explore.toptip.TopTipConstantKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/search/lego/tplmodel/WiseLinkGroupModel;", "", "()V", "options", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/search/lego/tplmodel/WiseLinkItemModel;", "Lkotlin/collections/ArrayList;", "getOptions", "()Ljava/util/ArrayList;", "parse2Model", "", "dataJson", "Lorg/json/JSONObject;", "toJson", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WiseLinkGroupModel.kt */
public final class WiseLinkGroupModel {
    private final ArrayList<WiseLinkItemModel> options = new ArrayList<>();

    public final ArrayList<WiseLinkItemModel> getOptions() {
        return this.options;
    }

    public final void parse2Model(JSONObject dataJson) {
        Intrinsics.checkNotNullParameter(dataJson, TopTipConstantKt.DATA_JSON);
        this.options.clear();
        JSONArray it = dataJson.optJSONArray("options");
        if (it != null) {
            int length = it.length();
            for (int index = 0; index < length; index++) {
                JSONObject itemObj = it.optJSONObject(index);
                if (itemObj != null) {
                    Intrinsics.checkNotNullExpressionValue(itemObj, "optJSONObject(index)");
                    WiseLinkItemModel item = new WiseLinkItemModel();
                    item.parse2Model(itemObj);
                    this.options.add(item);
                }
            }
        }
    }

    public final JSONObject toJson() {
        return new JSONObject();
    }
}
