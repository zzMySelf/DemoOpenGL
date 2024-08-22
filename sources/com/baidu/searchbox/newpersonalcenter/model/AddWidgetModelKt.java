package com.baidu.searchbox.newpersonalcenter.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"KEY_WIDGETEXT", "", "KEY_WIDGETID", "toJson", "Lorg/json/JSONObject;", "Lcom/baidu/searchbox/newpersonalcenter/model/AddWidgetModel;", "lib-personal-center_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddWidgetModel.kt */
public final class AddWidgetModelKt {
    public static final String KEY_WIDGETEXT = "widgetExt";
    public static final String KEY_WIDGETID = "widgetID";

    public static final JSONObject toJson(AddWidgetModel $this$toJson) {
        Intrinsics.checkNotNullParameter($this$toJson, "<this>");
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$toJson_u24lambda_u2d0 = jSONObject;
        $this$toJson_u24lambda_u2d0.put("widgetID", $this$toJson.getOpenWidgetId());
        $this$toJson_u24lambda_u2d0.put(KEY_WIDGETEXT, $this$toJson.getOpenWidgetParams());
        return jSONObject;
    }
}
