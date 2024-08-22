package com.baidu.searchbox.account.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u001a(\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"UBC_FROM_LOGIN_FULL", "", "UBC_ID_LOGIN_PANEL_RIGHTS", "UBC_TYPE_LOGIN_PANEL_LOGIN_CANCEL", "UBC_TYPE_LOGIN_PANEL_LOGIN_FAILED", "UBC_TYPE_LOGIN_PANEL_LOGIN_GRANT_SUCCESS", "UBC_TYPE_LOGIN_PANEL_LOGIN_SKIP", "UBC_TYPE_LOGIN_PANEL_LOGIN_SUCCESS_GRANT", "UBC_TYPE_LOGIN_PANEL_LOGIN_SUCCESS_GRANT_FAILED", "UBC_TYPE_LOGIN_PANEL_SHOW_RIGHTS", "commonStatistic", "", "id", "from", "type", "value", "page", "ext", "Lorg/json/JSONObject;", "onLoginRightsUBCStatistics", "lib-account_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UBCLoginPanelRightsStatistic.kt */
public final class UBCLoginPanelRightsStatisticKt {
    public static final String UBC_FROM_LOGIN_FULL = "login_full";
    public static final String UBC_ID_LOGIN_PANEL_RIGHTS = "6421";
    public static final String UBC_TYPE_LOGIN_PANEL_LOGIN_CANCEL = "login_cancel";
    public static final String UBC_TYPE_LOGIN_PANEL_LOGIN_FAILED = "login_failed";
    public static final String UBC_TYPE_LOGIN_PANEL_LOGIN_GRANT_SUCCESS = "login_grant_success";
    public static final String UBC_TYPE_LOGIN_PANEL_LOGIN_SKIP = "login_skip";
    public static final String UBC_TYPE_LOGIN_PANEL_LOGIN_SUCCESS_GRANT = "login_success_grant";
    public static final String UBC_TYPE_LOGIN_PANEL_LOGIN_SUCCESS_GRANT_FAILED = "login_grant_failed";
    public static final String UBC_TYPE_LOGIN_PANEL_SHOW_RIGHTS = "login_show";

    public static final void onLoginRightsUBCStatistics(String str, String str2) {
        onLoginRightsUBCStatistics$default(str, str2, (JSONObject) null, 4, (Object) null);
    }

    public static /* synthetic */ void onLoginRightsUBCStatistics$default(String str, String str2, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            jSONObject = null;
        }
        onLoginRightsUBCStatistics(str, str2, jSONObject);
    }

    public static final void onLoginRightsUBCStatistics(String type, String value, JSONObject ext) {
        commonStatistic("6421", UBC_FROM_LOGIN_FULL, type, value, (String) null, ext);
    }

    public static final void commonStatistic(String id, String from, String type, String value, String page, JSONObject ext) {
        Intrinsics.checkNotNullParameter(id, "id");
        JSONObject jsonObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(from)) {
                jsonObject.put("from", from);
            }
            if (!TextUtils.isEmpty(type)) {
                jsonObject.put("type", type);
            }
            if (!TextUtils.isEmpty(value)) {
                jsonObject.put("value", value);
            }
            if (!TextUtils.isEmpty(page)) {
                jsonObject.put("page", page);
            }
            if (ext != null) {
                jsonObject.put("ext", ext);
            }
        } catch (JSONException e2) {
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(id, jsonObject);
    }
}
