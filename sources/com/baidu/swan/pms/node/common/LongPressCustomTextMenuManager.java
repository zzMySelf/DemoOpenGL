package com.baidu.swan.pms.node.common;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.pms.PMSRuntime;
import com.baidu.swan.pms.node.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

public class LongPressCustomTextMenuManager {
    public static final String KEY_IMAGE = "image";
    public static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String TAG = "LongPressCustomTextMenuManager";
    private static volatile LongPressCustomTextMenuManager sInstance;

    private LongPressCustomTextMenuManager() {
    }

    public static LongPressCustomTextMenuManager getInstance() {
        if (sInstance == null) {
            synchronized (LongPressCustomTextMenuManager.class) {
                if (sInstance == null) {
                    sInstance = new LongPressCustomTextMenuManager();
                }
            }
        }
        return sInstance;
    }

    public Pair<String, String> getCustomText(int type) {
        String data = PMSRuntime.getPMSContext().getIpcSharedPrefs().getString(Constants.KEY_LONGPRESS_TEXT_MENU_DATA, (String) null);
        if (TextUtils.isEmpty(data)) {
            return null;
        }
        try {
            JSONArray array = new JSONArray(data);
            int length = array.length();
            for (int index = 0; index < length; index++) {
                JSONObject menuObj = array.optJSONObject(index);
                if (menuObj != null && type == menuObj.optInt("type")) {
                    return new Pair<>(menuObj.optString("name"), menuObj.optString("image"));
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public String getVersion() {
        return PMSRuntime.getPMSContext().getIpcSharedPrefs().getString(Constants.KEY_LONGPRESS_TEXT_MENU_NODE_VERSION, "0");
    }

    /* access modifiers changed from: package-private */
    public void process(JSONObject data) {
        JSONArray tips;
        if (data != null) {
            String version = data.optString("version");
            if (!TextUtils.isEmpty(version) && (tips = data.optJSONArray("data")) != null) {
                PMSRuntime.getPMSContext().getIpcSharedPrefs().putString(Constants.KEY_LONGPRESS_TEXT_MENU_NODE_VERSION, version);
                PMSRuntime.getPMSContext().getIpcSharedPrefs().putString(Constants.KEY_LONGPRESS_TEXT_MENU_DATA, tips.toString());
            }
        }
    }
}
