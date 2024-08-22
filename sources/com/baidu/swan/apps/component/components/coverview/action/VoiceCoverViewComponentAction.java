package com.baidu.swan.apps.component.components.coverview.action;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.base.SwanAppComponentResult;
import com.baidu.swan.apps.component.components.coverview.text.SwanAppCoverViewComponent;
import com.baidu.swan.apps.component.components.coverview.voice.SwanAppVoiceCoverViewComponent;
import com.baidu.swan.apps.component.components.coverview.voice.SwanAppVoiceCoverViewComponentModel;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.AbsSwanAppWidgetAction;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceCoverViewComponentAction extends AbsSwanAppWidgetAction {
    private static final String MODULE_NAME = "/swanAPI/voicepanel";
    private static final String TAG = "Component-Action-VoiceCoverView";

    public VoiceCoverViewComponentAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, MODULE_NAME);
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public boolean insertAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler, String subAction, SwanApp swanApp) {
        if (DEBUG) {
            Log.d(TAG, "insert");
        }
        if (!Swan.get().getApp().getSetting().checkAuthorizeFromLocalCache(ScopeInfo.SCOPE_VOICE_PANEL)) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(10005, "system deny");
            SwanAppLog.e(MODULE_NAME, entity.result.toString());
            return false;
        }
        SwanAppVoiceCoverViewComponentModel model = generateComponentModel(entity);
        if (model == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            SwanAppLog.e(TAG, "model is null");
            return false;
        }
        SwanAppComponentResult result = new SwanAppVoiceCoverViewComponent(context, model, handler).insert();
        boolean isSuccess = result.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(handler, entity, 0);
        } else {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, result.msg);
        }
        return isSuccess;
    }

    public boolean updateAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler, String subAction, SwanApp swanApp) {
        if (DEBUG) {
            Log.d(TAG, "update");
        }
        SwanAppVoiceCoverViewComponentModel model = generateComponentModel(entity);
        if (model == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            SwanAppLog.e(TAG, "model is null");
            return false;
        }
        SwanAppCoverViewComponent component = (SwanAppCoverViewComponent) SwanAppComponentFinder.findComponent(model);
        if (component == null) {
            String msg = "can't find coverView component:#" + model.componentId;
            SwanAppLog.e(TAG, msg);
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, msg);
            return false;
        }
        SwanAppComponentResult result = component.update(model);
        boolean isSuccess = result.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(handler, entity, 0);
        } else {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, result.msg);
        }
        return isSuccess;
    }

    public boolean removeAction(Context context, UnitedSchemeEntity entity, CallbackHandler handler, String subAction, SwanApp swanApp) {
        if (DEBUG) {
            Log.d(TAG, "remove");
        }
        SwanAppVoiceCoverViewComponentModel model = generateComponentModel(entity);
        if (model == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            SwanAppLog.e(TAG, "model is null");
            return false;
        }
        SwanAppCoverViewComponent component = (SwanAppCoverViewComponent) SwanAppComponentFinder.findComponent(model);
        if (component == null) {
            String msg = "can't find coverView component:#" + model.componentId;
            SwanAppLog.e(TAG, msg);
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, msg);
            return false;
        }
        SwanAppComponentResult result = component.remove();
        boolean isSuccess = result.isSuccess();
        if (isSuccess) {
            UnitedSchemeUtility.callCallback(handler, entity, 0);
        } else {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, result.msg);
        }
        return isSuccess;
    }

    private SwanAppVoiceCoverViewComponentModel generateComponentModel(UnitedSchemeEntity entity) {
        if (entity == null) {
            return null;
        }
        JSONObject jsonObject = getParamsJSONObject(entity);
        if (jsonObject == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            SwanAppLog.e(TAG, "params is null");
            return null;
        }
        SwanAppVoiceCoverViewComponentModel model = new SwanAppVoiceCoverViewComponentModel();
        try {
            model.parseFromJson(jsonObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            SwanAppLog.e(TAG, "model parse exception:", e2);
        }
        return model;
    }
}
