package com.baidu.swan.apps.behavior;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.nps.pm.db.BundleTable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.update.node.SwanAppAccreditNode;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.SwanAppUserVisitInfoUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetBehaviorInfoAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/getLaunchAppInfo";
    private static final String TAG = "GetBehaviorInfoAction";

    public GetBehaviorInfoAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (swanApp == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String cb = SwanAppJSONUtils.parseString(entity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(cb)) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        getBehaviorInfo(cb, handler);
        UnitedSchemeUtility.callCallback(handler, entity, 0);
        return true;
    }

    private void getBehaviorInfo(final String cb, final CallbackHandler handler) {
        SwanAppAccreditNode.getAccreditListData((TypedCallback<Map<String, ScopeInfo>>) new TypedCallback<Map<String, ScopeInfo>>() {
            public void onCallback(Map<String, ScopeInfo> scopeMap) {
                if (scopeMap == null) {
                    handler.handleSchemeDispatchCallback(cb, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    GetBehaviorInfoAction.this.handleCallback(cb, handler, scopeMap);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleCallback(String cb, CallbackHandler handler, Map<String, ScopeInfo> scopeInfo) {
        ScopeInfo openAppInfo = scopeInfo.get("scope_open_app");
        if (openAppInfo == null) {
            handler.handleSchemeDispatchCallback(cb, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return;
        }
        boolean forbidden = openAppInfo.forbidden;
        int launchCount = SwanAppUserVisitInfoUtils.getLaunchCount();
        long visitDuration = SwanAppUserVisitInfoUtils.getVisitDuration();
        List<String> ext = openAppInfo.ext;
        JSONArray extArray = new JSONArray();
        JSONObject data = new JSONObject();
        try {
            for (String str : ext) {
                extArray.put(str);
            }
            data.put("launchCount", launchCount);
            data.put("visitDuration", visitDuration);
            data.put(BundleTable.FORBIDDEN, forbidden);
            data.put("ext", extArray);
            if (DEBUG) {
                Log.i(TAG, "launchCount:" + launchCount + " visitDuration:" + visitDuration + " forbidden:" + forbidden + " ext:" + extArray.toString());
            }
            handler.handleSchemeDispatchCallback(cb, UnitedSchemeUtility.wrapCallbackParams(data, 0).toString());
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            handler.handleSchemeDispatchCallback(cb, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }
}
