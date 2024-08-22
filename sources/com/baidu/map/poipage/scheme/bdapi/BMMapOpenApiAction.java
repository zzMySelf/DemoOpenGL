package com.baidu.map.poipage.scheme.bdapi;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.map.poipage.scheme.dispatcher.UnitedSchemePoiMapDispatcher;
import com.baidu.map.poipage.utils.CommonUtils;
import com.baidu.map.poipage.utils.MLog;
import com.baidu.map.poipage.utils.OpenApiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseAction;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.model.SwanAppErrorPageParam;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONObject;

public class BMMapOpenApiAction extends UnitedSchemeBaseAction<UnitedSchemePoiMapDispatcher> {
    private static final String TAG = "BMMapOpenApiAction";

    public BMMapOpenApiAction(UnitedSchemePoiMapDispatcher dispatcher) {
        super(dispatcher);
    }

    public String getActionName() {
        return BdapiActionName.BM_MAP_OPEN_API_ACTION;
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        JSONObject root = null;
        try {
            HashMap<String, String> params = entity.getParams();
            if (params != null && params.containsKey("params")) {
                root = new JSONObject(URLDecoder.decode(params.get("params"), StandardCharsets.UTF_8.name()));
            }
        } catch (Exception e2) {
            MLog.e(TAG, "BMMapOpenApiAction handle: ", e2);
        }
        if (root == null) {
            return false;
        }
        try {
            String mapUrl = root.optString("mapUrl");
            String webUrl = root.optString(SwanAppErrorPageParam.KEY_SWAN_WEB_URL);
            if (!TextUtils.isEmpty(mapUrl) && CommonUtils.isBaiduMapInstalled(AppRuntime.getAppContext())) {
                OpenApiUtils.processUrl(mapUrl);
                return true;
            } else if (TextUtils.isEmpty(webUrl)) {
                return true;
            } else {
                OpenApiUtils.processUrl(webUrl);
                return true;
            }
        } catch (Exception e3) {
            MLog.e(TAG, "BMMapOpenApiAction scheme调起异常: ", e3);
            return true;
        }
    }
}
