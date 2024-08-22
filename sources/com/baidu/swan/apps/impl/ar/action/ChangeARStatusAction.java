package com.baidu.swan.apps.impl.ar.action;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.ar.SwanAppARCameraComponent;
import com.baidu.swan.apps.impl.ar.model.ARCameraAttr;
import com.baidu.swan.apps.impl.ar.view.ARCameraView;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;

public class ChangeARStatusAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swanAPI/ARCamera/changeARStatus";
    private static final String AR_STATUS_START = "1";

    public ChangeARStatusAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        ARCameraAttr cameraModel = parseData(unitedSchemeEntity);
        if (cameraModel == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 1000, "changeARStatus: params invalid", 201, "");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppARCameraComponent component = (SwanAppARCameraComponent) SwanAppComponentFinder.findComponent(cameraModel);
        if (component == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "changeARStatus: component is null", 1001, "get ar camera component is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera component is null");
            return false;
        }
        ARCameraView cameraView = (ARCameraView) component.getView();
        if (cameraView == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "changeARStatus: cameraView is null", 1001, "get ar camera view is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera view is null");
            return false;
        }
        String playStatus = cameraModel.status;
        if ("1".equals(playStatus)) {
            SwanAppLog.i("AbsARAction", "play ar: arKey: " + cameraModel.arKey + ", arType: " + cameraModel.arType);
            cameraView.playCase(cameraModel.arKey, cameraModel.arType);
            callback(unitedSchemeEntity, handler, true);
            return true;
        }
        CallbackHandler callbackHandler = handler;
        SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "changeARStatus: wrong ar status, " + playStatus, 1001, "");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        SwanAppLog.e("AbsARAction", "wrong ar status " + playStatus);
        return false;
    }
}
