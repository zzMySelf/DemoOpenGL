package com.baidu.browser.tablayout;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\u001a\u0006\u0010\t\u001a\u00020\n\u001a\u0006\u0010\u000b\u001a\u00020\n\u001a\u0006\u0010\f\u001a\u00020\n\u001a\u0006\u0010\r\u001a\u00020\n\u001a\u001c\u0010\u000e\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0010H\u0002\u001a\u0006\u0010\u0011\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"CHAT_SEARCH_ID", "", "SEARCH_CHAT_FROM", "SEARCH_CHAT_ID", "SEARCH_CHAT_PAGE", "SEARCH_CHAT_TYPE_CLICK", "SEARCH_CHAT_TYPE_SHOW", "SEARCH_CHAT_VALUE_BUB", "SEARCH_CHAT_VALUE_ICON", "chatIconBubClick", "", "chatIconBubShow", "chatIconClick", "chatIconShow", "onEvent", "map", "", "sideBarShowUbc", "lib-browser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchChatUbc.kt */
public final class SearchChatUbc {
    private static final String CHAT_SEARCH_ID = "6508";
    private static final String SEARCH_CHAT_FROM = "search";
    private static final String SEARCH_CHAT_ID = "6280";
    private static final String SEARCH_CHAT_PAGE = "se_resultpage";
    private static final String SEARCH_CHAT_TYPE_CLICK = "click";
    private static final String SEARCH_CHAT_TYPE_SHOW = "show";
    private static final String SEARCH_CHAT_VALUE_BUB = "pd_bub";
    private static final String SEARCH_CHAT_VALUE_ICON = "pd_icon";

    public static final void chatIconShow() {
        HashMap map = new HashMap();
        map.put("from", "search");
        map.put("page", SEARCH_CHAT_PAGE);
        map.put("type", "show");
        map.put("value", SEARCH_CHAT_VALUE_ICON);
        onEvent(map);
    }

    public static final void chatIconClick() {
        HashMap map = new HashMap();
        map.put("from", "search");
        map.put("page", SEARCH_CHAT_PAGE);
        map.put("type", "click");
        map.put("value", SEARCH_CHAT_VALUE_ICON);
        onEvent(map);
    }

    public static final void chatIconBubShow() {
        HashMap map = new HashMap();
        map.put("from", "search");
        map.put("page", SEARCH_CHAT_PAGE);
        map.put("type", "show");
        map.put("value", SEARCH_CHAT_VALUE_BUB);
        onEvent(map);
    }

    public static final void chatIconBubClick() {
        HashMap map = new HashMap();
        map.put("from", "search");
        map.put("page", SEARCH_CHAT_PAGE);
        map.put("type", "click");
        map.put("value", SEARCH_CHAT_VALUE_BUB);
        onEvent(map);
    }

    private static final void onEvent(Map<String, String> map) {
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SEARCH_CHAT_ID, map);
    }

    public static final void sideBarShowUbc() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("page", "resultpage");
            jsonObject.put("type", "show");
            jsonObject.put("value", "sidebar");
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("6508", jsonObject);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }
}
