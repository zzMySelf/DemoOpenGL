package com.baidu.talos.adapter;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public interface ITalosDTConfigAdapter {
    public static final ITalosDTConfigAdapter DEFAULT = new ITalosDTConfigAdapter$$ExternalSyntheticLambda0();
    public static final String MODULE_NAME_KEY = "module_name";
    public static final String PACKAGE_NAME_KEY = "package_name";
    public static final String PRECOMPILE_BUNDLE_KEY = "precompile_disabled";
    public static final String PRELOAD_BUNDLE_KEY = "preload_disabled";
    public static final String PRERENDER_KEY = "prerender_disabled";
    public static final String RENDER_KEY = "render_disabled";
    public static final String RUNTIME_PREHEAT_KEY = "preheat_disabled";
    public static final int SWITCH_OFF = 0;
    public static final int SWITCH_ON = 1;
    public static final String TAG = "TLS_DT_CONFIG";

    JSONObject getConfig();

    boolean getSwitch(String key, boolean defaultValue) {
        JSONObject jsonConfig = getConfig();
        if (jsonConfig == null) {
            return defaultValue;
        }
        return jsonConfig.optInt(key, 0) != 1;
    }

    boolean getSwitch(String key, String packageName, String moduleName, boolean defaultValue) {
        JSONArray jsonArray;
        JSONObject jsonConfig = getConfig();
        if (!(jsonConfig == null || (jsonArray = jsonConfig.optJSONArray(key)) == null)) {
            if (jsonArray.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                JSONObject itemJSON = jsonArray.optJSONObject(i2);
                if (itemJSON != null) {
                    String pName = itemJSON.optString("package_name", (String) null);
                    String mName = itemJSON.optString(MODULE_NAME_KEY, (String) null);
                    if ((pName == null || TextUtils.equals(pName, packageName)) && (mName == null || TextUtils.equals(mName, moduleName))) {
                        return false;
                    }
                }
            }
        }
        return defaultValue;
    }

    static /* synthetic */ JSONObject lambda$static$0() {
        return null;
    }
}
