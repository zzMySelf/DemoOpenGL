package com.baidu.swan.apps.scheme.actions.www;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.component.base.SwanAppBaseComponentModel;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WWWParams extends SwanAppBaseComponentModel {
    private static final String ADSORB_SPACING_KEY = "adsorbSpacing";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String ENABLE_ADSORB_KEY = "enableAdsorb";
    private static final String ENABLE_DRAG_KEY = "enableDrag";
    private static final String ENABLE_WINDOW_MODE_KEY = "enableWindowMode";
    public static final String INJECTION_KEY = "injection";
    private static final String OPACITY_KEY = "opacity";
    private static final String PARAMS_KEY = "params";
    public static final String QUICK_PASS_TYPE = "quickPass";
    private static final String SRC_KEY = "src";
    private static final String STYLE_KEY = "style";
    private static final String TARGET_URL_KEY = "targetUrls";
    private static final String TYPE_KEY = "type";
    private static final String UA_KEY = "userAgent";
    private static final String VIEW_ID_KEY = "viewId";
    private static final String Z_INDEX_KEY = "zIndex";
    public float adsorbSpacing = 17.0f;
    public boolean enableAdsorb = true;
    public boolean enableDrag = false;
    public boolean enableWindowMode = false;
    public String injection;
    public boolean instantMessage = false;
    public boolean isNeedCheckWebDomain = true;
    public String mSrc;
    public List<String> mTargeUrls;
    public String mType;
    public String mUa;
    public float opacity = 1.0f;
    public float zIndex;

    public WWWParams() {
        super("webView", "viewId");
    }

    public void parseFromJson(JSONObject json) throws JSONException {
        if (json != null) {
            super.parseFromJson(json);
            this.mSrc = json.optString("src");
            this.mUa = json.optString("userAgent");
            this.mType = json.optString("type");
            this.enableWindowMode = json.optBoolean(ENABLE_WINDOW_MODE_KEY, false);
            this.enableDrag = json.optBoolean(ENABLE_DRAG_KEY, false);
            this.enableAdsorb = json.optBoolean(ENABLE_ADSORB_KEY, true);
            this.adsorbSpacing = (float) SwanAppUIUtils.dp2px((float) json.optDouble(ADSORB_SPACING_KEY));
            JSONObject style = json.optJSONObject("style");
            if (style != null) {
                try {
                    this.opacity = Float.parseFloat(style.optString("opacity", "1"));
                } catch (NumberFormatException e2) {
                    this.opacity = 1.0f;
                }
                this.zIndex = (float) style.optDouble("zIndex", 0.0d);
            }
            JSONArray jsonArray = json.optJSONArray(TARGET_URL_KEY);
            if (!(jsonArray == null || jsonArray.length() == 0)) {
                this.mTargeUrls = new ArrayList();
                int length = jsonArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.mTargeUrls.add(jsonArray.optString(i2));
                }
            }
            this.injection = json.optString(INJECTION_KEY);
        }
    }

    static WWWParams parseWWWParams(UnitedSchemeEntity entity) {
        if (entity == null) {
            return null;
        }
        String paramsValue = entity.getParams().get("params");
        WWWParams wwwParams = new WWWParams();
        try {
            wwwParams.parseFromJson(new JSONObject(paramsValue));
            return wwwParams;
        } catch (JSONException jsonEx) {
            SwanAppLog.e("WebView", "parsing params occurs exception", jsonEx);
            return null;
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.slaveId);
    }
}
