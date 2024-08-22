package com.baidu.searchbox.live.interfaces.eshop;

import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/eshop/SoftLiveAdBean;", "", "()V", "extData", "Lorg/json/JSONObject;", "getExtData", "()Lorg/json/JSONObject;", "setExtData", "(Lorg/json/JSONObject;)V", "extraParam", "", "getExtraParam", "()Ljava/lang/String;", "setExtraParam", "(Ljava/lang/String;)V", "feedFloorType", "getFeedFloorType", "setFeedFloorType", "id", "getId", "setId", "nid", "getNid", "setNid", "vid", "getVid", "setVid", "onParseData", "", "json", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SoftLiveAdBean.kt */
public final class SoftLiveAdBean {
    private JSONObject extData;
    private String extraParam;
    private String feedFloorType = "";
    private String id = "";
    private String nid = "";
    private String vid = "";

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.id = str;
    }

    public final String getNid() {
        return this.nid;
    }

    public final void setNid(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.nid = str;
    }

    public final String getVid() {
        return this.vid;
    }

    public final void setVid(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.vid = str;
    }

    public final String getFeedFloorType() {
        return this.feedFloorType;
    }

    public final void setFeedFloorType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.feedFloorType = str;
    }

    public final JSONObject getExtData() {
        return this.extData;
    }

    public final void setExtData(JSONObject jSONObject) {
        this.extData = jSONObject;
    }

    public final String getExtraParam() {
        return this.extraParam;
    }

    public final void setExtraParam(String str) {
        this.extraParam = str;
    }

    public final void onParseData(JSONObject json) {
        Intrinsics.checkParameterIsNotNull(json, "json");
        JSONObject $this$apply = json;
        try {
            String optString = $this$apply.optString("id");
            Intrinsics.checkExpressionValueIsNotNull(optString, "optString(\"id\")");
            this.id = optString;
            String optString2 = $this$apply.optString("nid");
            Intrinsics.checkExpressionValueIsNotNull(optString2, "optString(\"nid\")");
            this.nid = optString2;
            String optString3 = $this$apply.optString("vid");
            Intrinsics.checkExpressionValueIsNotNull(optString3, "optString(\"vid\")");
            this.vid = optString3;
            String optString4 = $this$apply.optString("feed_floor_type");
            Intrinsics.checkExpressionValueIsNotNull(optString4, "optString(\"feed_floor_type\")");
            this.feedFloorType = optString4;
            JSONObject optJSONObject = $this$apply.optJSONObject("extra_info");
            this.extraParam = optJSONObject != null ? optJSONObject.optString(DelegateDef.EXTRA_PARAMS) : null;
            this.extData = $this$apply.optJSONObject("extra_data");
        } catch (JSONException e2) {
        }
    }
}
