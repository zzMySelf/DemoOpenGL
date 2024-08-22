package com.baidu.swan.apps.input;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.components.input.SwanAppInputComponent;
import com.baidu.swan.apps.component.components.input.SwanAppInputComponentModel;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import org.json.JSONObject;

public class UpdateInputAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/updateInput";
    private static final String MODULE_TAG = "updateInput";
    private static final int NO_INPUT_EDIT_TEXT = 1001;

    public UpdateInputAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (swanApp == null) {
            SwanAppLog.e(MODULE_TAG, "illegal swanApp");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject paramsJson = UnitedSchemeUtility.optParamsAsJo(entity);
        if (paramsJson == null) {
            SwanAppLog.e(MODULE_TAG, "paramsJson is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String slaveId = paramsJson.optString("slaveId");
        String componentId = paramsJson.optString("componentId");
        SwanAppInputComponent component = (SwanAppInputComponent) SwanAppComponentFinder.findComponentById(slaveId, componentId);
        if (component == null) {
            SwanAppLog.e(MODULE_TAG, "input组件不存在");
            SwanAppLog.e("SwanAppAction", "can't find input component:#" + componentId);
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        SwanAppInputComponentModel model = (SwanAppInputComponentModel) component.getCloneModel();
        model.updateModel(paramsJson);
        boolean isSuccess = component.update(model).isSuccess();
        if (isSuccess) {
            SwanAppLog.i(MODULE_TAG, "update success");
            UnitedSchemeUtility.callCallback(handler, entity, 0);
        } else {
            UnitedSchemeUtility.callCallback(handler, entity, 1001);
        }
        return isSuccess;
    }
}
