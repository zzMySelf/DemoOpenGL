package com.baidu.searchbox.block;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockUbc {
    public static final String BLOCK_UBC_ID = "807";
    public static final String KEY_EXT = "ext";
    public static final String KEY_FROM = "from";
    private static final String TAG = "BlockUbc";
    public static final String VALUE_RESEARCH = "research";

    public static void uploadBlockEvent(JSONObject ext) {
        UBCManager ubc;
        if (ext != null && (ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            JSONObject data = new JSONObject();
            try {
                data.put("from", "research");
                data.put("ext", ext);
                ubc.onEvent(BLOCK_UBC_ID, data);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
