package com.baidu.searchbox.userassetsaggr.container.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class UserAssetsAggrUbc {
    public static final String EVENT_KEY = "785";
    public static final String EXT_CLASSIFY_TYPE = "classify_type";
    public static final String EXT_IS_UPDATE = "is_update";
    public static final String EXT_KEY_FOLD_NAME = "fold_name";
    public static final String EXT_KEY_IS_RECOMMEND_FOLDER = "is_recommend_folder";
    public static final String EXT_KEY_QUERY = "query";
    public static final String EXT_KEY_TITLE = "title";
    public static final String EXT_KEY_TPLID = "tplid";
    public static final String EXT_KEY_UKEY = "ukey";
    public static final String EXT_KEY_URL = "url";
    public static final String EXT_NUMBER = "number";
    public static final String EXT_VALUE_IS_RECOMMEND_FOLDER = "1";
    public static final String EXT_VALUE_NOT_RECOMMEND_FOLDER = "0";
    public static final String FROM_BASE = "base";
    public static final String FROM_TOOL = "tool";
    public static final String KEY_REPORTER_EXTRA_INFO = "reporterExtraInfo";
    public static final String PAGE_FAV_SEARCH = "search_fav";
    public static final String PAGE_FAV_TAB = "tab_fav";
    public static final String PAGE_HIS = "tab_favhis";
    public static final String PAGE_HISTORY_SEARCH = "search_his";
    public static final String PAGE_HISTORY_TAB = "tab_his";
    public static final String PAGE_PRAISE_TAB = "tab_like";
    public static final String PAGE_SEARCH_SUG = "search_sug";
    public static final String ROOT_SOURCE = "rootSource";
    public static final String SEARCH_WEB_TITLE_FILTER = "无标题网页";
    public static final String SOURCE_BI_SERIAL_CLOSE = "tuijian_close";
    public static final String SOURCE_BI_SERIAL_MORE = "tuijian_more";
    public static final String SOURCE_DELETE_RIGHT_BOTTOM = "select_all_delete";
    public static final String SOURCE_EDIT_LEFT_TOP = "edit_btn";
    public static final String SOURCE_EDIT_RIGHT_MENU = "menu_btn_edit";
    public static final String SOURCE_ENTER_FAV_SEARCH = "tab_fav";
    public static final String SOURCE_ENTER_HIS_SEARCH = "tab_his";
    public static final String SOURCE_ENTER_LIKE_SEARCH = "tab_like";
    public static final String SOURCE_ENTER_PUSH_SEARCH = "tab_push";
    public static final String SOURCE_FAV_SORT = "fav_sort";
    public static final String SOURCE_FROM_CLICK = "from_click";
    public static final String SOURCE_FROM_TOAST = "from_toast";
    public static final String SOURCE_HIS_SORT = "his_sort";
    public static final String SOURCE_MENU_EDIT_TIPS = "edit_tooltip";
    public static final String SOURCE_MENU_NEW_BUILD_TIPS = "folder_tip";
    public static final String SOURCE_MENU_RIGHT_TOP = "menu_btn";
    public static final String SOURCE_PRAISE_SORT = "like_sort";
    public static final String SOURCE_PRESS_MENU = "press_menu";
    public static final String SOURCE_SEARCH_BTN = "search_btn";
    public static final String SOURCE_SEARCH_HISTORY = "search_history";
    public static final String SOURCE_SEARCH_HISTORY_DELETE_BTN = "search_history_delete";
    public static final String SOURCE_SHARE_FAIL = "share_fail";
    public static final String TEMPLATE_AD = "ad";
    public static final String TEMPLATE_SAD = "sad";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_CLOSE_CLICK = "close_click";
    public static final String TYPE_SHOW = "show";
    public static final String TYPE_SHOW_FEED = "show_feed";
    public static final String TYPE_WEB_TRANSLOAD_FAILED = "wangpan_fail";
    public static final String UBC_VALUE_FAV_SORT_VIDEO = "fav_sort_video";
    public static final String VALUE_ADD_FOLDER = "add_folder";
    public static final String VALUE_ADD_NEW_BUILT = "add_new_built";
    public static final String VALUE_ADD_PANNEL = "add_pannel";
    public static final String VALUE_APPRAISE = "appraise";
    public static final String VALUE_DELETE = "delete";
    public static final String VALUE_EDIT = "edit";
    public static final String VALUE_FAV_AD = "fav_ad";
    public static final String VALUE_FAV_READ_FOLDER = "fav_read_folder";
    public static final String VALUE_FAV_SAD = "fav_sad";
    public static final String VALUE_FAV_SORT_ALL = "fav_sort_all";
    public static final String VALUE_FAV_SORT_NEWS = "fav_sort_news";
    public static final String VALUE_FAV_SORT_VIDEO = "fav_sort_video";
    public static final String VALUE_FEEDBACK = "feedback";
    public static final String VALUE_FILM = "web_video_landingH5";
    public static final String VALUE_FINISH_NEW_BUILT = "finish_new_built";
    public static final String VALUE_HISTORY_AD = "his_ad";
    public static final String VALUE_HISTORY_SAD = "his_sad";
    public static final String VALUE_HIS_SORT_ALL = "his_sort_all";
    public static final String VALUE_HIS_SORT_NEWS = "his_sort_news";
    public static final String VALUE_HIS_SORT_VIDEO = "his_sort_viedo";
    public static final String VALUE_MOVE = "move";
    public static final String VALUE_NEW_BUILT_PANNEL = "new_built_pannel";
    public static final String VALUE_PLAY = "play";
    public static final String VALUE_PLAYLET = "short_play";
    public static final String VALUE_PRIVATE = "private";
    public static final String VALUE_RATE = "rate";
    public static final String VALUE_RENAME = "rename";
    public static final String VALUE_REPORT = "report";
    public static final String VALUE_SEARCH_ALL = "search_all";
    public static final String VALUE_SHARE = "share";
    public static final String VALUE_WEB_VIDEO = "web_video";
    public static final String VALUE_WEB_VIDEO_UPDATE = "web_video_update";
    public static final String WEB_FILM_QUERY = "fav_his_query";
    public static final String WEB_FILM_SA = "fav_his_sa";
    public static final String WEB_FILM_SA_VALUE = "ouh_deadlink_huisou";
    public static final String WEB_FILM_TITLE = "fav_his_title";
    public static final String WEB_FILM_TITLE_TYPE = "fav_his_title_type";
    public static HashMap<String, Boolean> sHasReportUbcItem = new HashMap<>();

    public static void event(String type, String page, String source, String value) {
        event(type, page, source, value, "");
    }

    public static void event(String type, String page, String source, String value, String ext) {
        event("tool", type, page, source, value, ext);
    }

    public static void event(String from, String type, String page, String source, String value, String ext) {
        UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        Map<String, String> ubcMap = new HashMap<>();
        if (!TextUtils.isEmpty(from)) {
            ubcMap.put("from", from);
        }
        if (!TextUtils.isEmpty(type)) {
            ubcMap.put("type", type);
        }
        if (!TextUtils.isEmpty(page)) {
            ubcMap.put("page", page);
        }
        if (!TextUtils.isEmpty(source)) {
            ubcMap.put("source", source);
        }
        if (!TextUtils.isEmpty(value)) {
            ubcMap.put("value", value);
        }
        if (!TextUtils.isEmpty(ext)) {
            ubcMap.put("ext", ext);
        }
        ubcManager.onEvent("785", ubcMap);
        if (AppConfig.isDebug()) {
            Log.d("UserAssetsAggrUbc", "ubc is" + ubcMap.toString());
        }
    }

    public static void eventFirstShowUbc(String key, String page, String source, String value, String ext) {
        Boolean isShowed = sHasReportUbcItem.get(key);
        if (isShowed == null || !isShowed.booleanValue()) {
            event("show", page, source, value, ext);
            sHasReportUbcItem.put(key, true);
        }
    }

    public static void biSerialViewShowEvent(String page, String source, String value) {
        Boolean isShowed = sHasReportUbcItem.get(value);
        if (isShowed == null || !isShowed.booleanValue()) {
            event(TYPE_SHOW_FEED, page, source, value);
            sHasReportUbcItem.put(value, true);
        }
    }

    public static void biSerialCloseButtonClickEvent(String page, String source) {
        event("click", page, source, (String) null);
    }

    public static void event(HashMap<String, String> ubcMap) {
        if (ubcMap != null) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("785", (Map<String, String>) ubcMap);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getUbcValue(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            int r1 = r4.hashCode()
            switch(r1) {
                case -1553291407: goto L_0x002b;
                case -1553289240: goto L_0x0020;
                case -710145020: goto L_0x0015;
                case -710142853: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0036
        L_0x000a:
            java.lang.String r1 = "search_his"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0009
            r1 = 1
            goto L_0x0037
        L_0x0015:
            java.lang.String r1 = "search_fav"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0009
            r1 = 2
            goto L_0x0037
        L_0x0020:
            java.lang.String r1 = "tab_his"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x0037
        L_0x002b:
            java.lang.String r1 = "tab_fav"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0009
            r1 = 3
            goto L_0x0037
        L_0x0036:
            r1 = -1
        L_0x0037:
            java.lang.String r2 = "sad"
            java.lang.String r3 = "ad"
            switch(r1) {
                case 0: goto L_0x0052;
                case 1: goto L_0x0052;
                case 2: goto L_0x0040;
                case 3: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0063
        L_0x0040:
            boolean r1 = android.text.TextUtils.equals(r3, r5)
            if (r1 == 0) goto L_0x0049
            java.lang.String r0 = "fav_ad"
            goto L_0x0063
        L_0x0049:
            boolean r1 = android.text.TextUtils.equals(r2, r5)
            if (r1 == 0) goto L_0x0063
            java.lang.String r0 = "fav_sad"
            goto L_0x0063
        L_0x0052:
            boolean r1 = android.text.TextUtils.equals(r3, r5)
            if (r1 == 0) goto L_0x005b
            java.lang.String r0 = "his_ad"
            goto L_0x0063
        L_0x005b:
            boolean r1 = android.text.TextUtils.equals(r2, r5)
            if (r1 == 0) goto L_0x0063
            java.lang.String r0 = "his_sad"
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsAggrUbc.getUbcValue(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String buildSearchHistoryExt(int position, String history) {
        try {
            JSONObject ext = new JSONObject();
            ext.putOpt("number", Integer.valueOf(position + 1));
            ext.putOpt("name", history);
            return ext.toString();
        } catch (Exception e2) {
            if (!AppConfig.isDebug()) {
                return "";
            }
            e2.printStackTrace();
            return "";
        }
    }

    public static String getEnterSearchSource(int tabIndex) {
        switch (tabIndex) {
            case 0:
                return "tab_fav";
            case 1:
                return "tab_his";
            case 2:
                return "tab_push";
            case 3:
                return "tab_like";
            default:
                return "";
        }
    }
}
