package com.baidu.searchbox.feed.refreshex;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.ubc.UBCManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RefreshNoDisplayItemsStatics {
    private static final String FROM_VALUE = "feed";
    private static final String NO_DISPLAY_UBC_ID = "5542";
    private static final String SOURCE_VALUE = "feed";
    private static final String UBC_KEY_EXT = "ext";
    private static final String UBC_KEY_FROM = "from";
    private static final String UBC_KEY_PAGE = "page";
    private static final String UBC_KEY_SOURCE = "source";
    private static final String UBC_KEY_VALUE = "value";

    public static void noDisplayItemsStatics(String page, List<FeedBaseModel> list) {
        try {
            if (list.size() > 0) {
                JSONObject ubcJson = new JSONObject();
                UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                ubcJson.put("from", "feed");
                ubcJson.put("page", page);
                ubcJson.put("source", "feed");
                ubcJson.put("value", list.size());
                JSONObject extJson = new JSONObject();
                JSONArray itemIds = new JSONArray();
                for (FeedBaseModel model : list) {
                    if (model != null) {
                        itemIds.put(model.id);
                    }
                }
                extJson.put("item_ids", itemIds);
                ubcJson.put("ext", extJson);
                ubc.onEvent(NO_DISPLAY_UBC_ID, ubcJson);
            }
        } catch (JSONException e2) {
        }
    }
}
