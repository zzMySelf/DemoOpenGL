package com.baidu.searchbox.youthhome.tools.util;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.kmm.home.youth.YouthHomeLv1TabUBCKt;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002\u001a.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002\u001a.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0006\u0010\u0011\u001a\u00020\f\u001a\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f\u001a\u0006\u0010\u0013\u001a\u00020\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"UBC_ID_HOME_DURATION_6833", "", "UBC_TOOL_FROM", "UBC_TOOL_PAGE", "UBC_TOOL_TYPE", "YOUTH_HOME_LV1_TAB_ID_TOOLS", "getJsonFromParams", "Lorg/json/JSONObject;", "from", "type", "page", "homeV1TabViewUbcFlowBegin", "Lcom/baidu/ubc/Flow;", "eventId", "homeV1TabViewUbcFlowEnd", "", "flow", "onYouthHomeToolDurationBegin", "onYouthHomeToolDurationEnd", "refreshEvent", "youth-home-tools_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeV1ToolUbcUtils.kt */
public final class YouthHomeV1ToolUbcUtilsKt {
    public static final String UBC_ID_HOME_DURATION_6833 = "6833";
    public static final String UBC_TOOL_FROM = "feed_tab";
    public static final String UBC_TOOL_PAGE = "tools";
    public static final String UBC_TOOL_TYPE = "duration";
    public static final String YOUTH_HOME_LV1_TAB_ID_TOOLS = "523";

    public static final Flow onYouthHomeToolDurationBegin() {
        return homeV1TabViewUbcFlowBegin(UBC_ID_HOME_DURATION_6833, "feed_tab", "duration", "tools");
    }

    public static final void onYouthHomeToolDurationEnd(Flow flow) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        homeV1TabViewUbcFlowEnd(flow, "feed_tab", "duration", "tools");
    }

    private static final Flow homeV1TabViewUbcFlowBegin(String eventId, String from, String type, String page) {
        String paramString = getJsonFromParams(from, type, page).toString();
        Intrinsics.checkNotNullExpressionValue(paramString, "getJsonFromParams(from, type, page).toString()");
        Flow beginFlow = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(eventId, paramString);
        Intrinsics.checkNotNullExpressionValue(beginFlow, "ubcManagerService.beginFlow(eventId, paramString)");
        return beginFlow;
    }

    private static final void homeV1TabViewUbcFlowEnd(Flow flow, String from, String type, String page) {
        UBCManager ubcManagerService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        String paramString = getJsonFromParams(from, type, page).toString();
        Intrinsics.checkNotNullExpressionValue(paramString, "getJsonFromParams(from, type, page).toString()");
        ubcManagerService.flowSetValueWithDuration(flow, paramString);
        ubcManagerService.flowEnd(flow);
    }

    private static final JSONObject getJsonFromParams(String from, String type, String page) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getJsonFromParams_u24lambda_u2d0 = jSONObject;
        try {
            $this$getJsonFromParams_u24lambda_u2d0.putOpt("from", from);
            $this$getJsonFromParams_u24lambda_u2d0.putOpt("type", type);
            $this$getJsonFromParams_u24lambda_u2d0.putOpt("page", page);
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    public static final void refreshEvent() {
        YouthHomeLv1TabUBCKt.onYouthHomeLv1TabClick("523", "doubleclick");
    }
}
