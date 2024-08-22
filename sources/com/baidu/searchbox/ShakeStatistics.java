package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;

public class ShakeStatistics {
    public static final String EXT = "ext";
    public static final String FROM = "from";
    public static final String ID = "901";
    public static final String OFFLINE = "offline";
    public static final String PAGE = "page";
    public static final String PARAMETER = "parameter";
    public static final String SHAKE = "shake";
    public static final String SHAKEINFO = "shakeinfo";
    public static final String TAG = "ShakeStatistics";
    public static final String TOOL = "tool";
    public static final String TYPE = "type";
    public static final String VALUE = "value";

    public static final void ubc(String type, String value, String ext) {
        JSONObject data = new JSONObject();
        boolean isEnable = false;
        try {
            data.put("from", "tool");
            data.put("page", "shake");
            if (!TextUtils.isEmpty(type)) {
                data.put("type", type);
                isEnable = true;
            }
            if (!TextUtils.isEmpty(value)) {
                data.put("value", value);
                isEnable = true;
            }
            if (!TextUtils.isEmpty(ext)) {
                data.put("ext", ext);
                isEnable = true;
            }
        } catch (Exception e2) {
            isEnable = false;
        }
        if (isEnable) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("901", data.toString(), 0);
        }
    }
}
