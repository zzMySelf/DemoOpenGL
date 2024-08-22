package com.baidu.swan.apps.impl.ar.action;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.ar.SwanAppARCameraComponent;
import com.baidu.swan.apps.impl.ar.manager.Util;
import com.baidu.swan.apps.impl.ar.model.ARCameraAttr;
import com.baidu.swan.apps.impl.ar.view.ARCameraView;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;

public class SendLuaMsgToARAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swanAPI/ARCamera/arMessage";

    public SendLuaMsgToARAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        ARCameraAttr cameraModel = parseData(entity);
        if (cameraModel == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 1000, "sendLuaMsg: params invalid", 201, "");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppARCameraComponent component = (SwanAppARCameraComponent) SwanAppComponentFinder.findComponent(cameraModel);
        if (component == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "sendLuaMsg: component is null", 1001, "get ar camera component is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera component is null");
            return false;
        }
        ARCameraView cameraView = (ARCameraView) component.getView();
        if (cameraView == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "sendLuaMsg: cameraView is null", 1001, "get ar camera view is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera view is null");
            return false;
        }
        try {
            cameraView.sendMessage2Lua(Util.toMap(cameraModel.data));
            callback(entity, handler, true);
            return true;
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
