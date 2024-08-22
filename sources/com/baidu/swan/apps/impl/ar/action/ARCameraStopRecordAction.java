package com.baidu.swan.apps.impl.ar.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.ar.SwanAppARCameraComponent;
import com.baidu.swan.apps.impl.ar.manager.Util;
import com.baidu.swan.apps.impl.ar.model.ARCameraAttr;
import com.baidu.swan.apps.impl.ar.view.ARCameraView;
import com.baidu.swan.apps.permission.RequestPermissionHelper;
import com.baidu.swan.apps.permission.RequestPermissionListener;
import com.baidu.swan.apps.permission.SwanAppPermission;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.setting.SwanAppSetting;
import com.baidu.swan.apps.setting.oauth.OAuthUtils;
import com.baidu.swan.apps.setting.oauth.TaskResult;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitorExternInfo;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.io.File;
import java.util.HashMap;

public class ARCameraStopRecordAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swanAPI/ARCamera/stopRecord";

    public ARCameraStopRecordAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        ARCameraAttr cameraModel = parseData(unitedSchemeEntity);
        if (cameraModel == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 1000, "stop: params invalid", 201, "");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppARCameraComponent component = (SwanAppARCameraComponent) SwanAppComponentFinder.findComponent(cameraModel);
        if (component == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "stop: component is null", 1001, "get ar camera component is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera component is null");
            return false;
        }
        ARCameraView preview = (ARCameraView) component.getView();
        if (preview == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "stop: preView is null", 1001, "get ar camera view is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera view is null");
            return false;
        } else if (TextUtils.isEmpty(StorageUtil.getSwanAppTmpDirectory(swanApp.id))) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "stop: swanAppTmpPath is null", 1001, "");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            SwanAppSetting setting = swanApp.getSetting();
            final CallbackHandler callbackHandler = handler;
            final UnitedSchemeEntity unitedSchemeEntity2 = entity;
            final Context context2 = context;
            final SwanApp swanApp2 = swanApp;
            final ARCameraAttr aRCameraAttr = cameraModel;
            AnonymousClass1 r8 = r0;
            final ARCameraView aRCameraView = preview;
            AnonymousClass1 r0 = new TypedCallback<TaskResult<Authorize.Result>>() {
                public void onCallback(TaskResult<Authorize.Result> result) {
                    if (!OAuthUtils.isAuthorizeOk(result)) {
                        int errorCode = result.getErrorCode();
                        String errorMsg = "authorize recorder failed : " + OAuthUtils.getErrorMessage(errorCode);
                        SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 1005, errorMsg, errorCode, errorMsg, new SwanAppStabilityMonitorExternInfo.Builder().setActionName(SwanAppStabilityMonitor.SCENE_AR_CAMERA).setExposedMsg("please call this api after apply for permission").build());
                        OAuthUtils.processPermissionDeny(result, callbackHandler, unitedSchemeEntity2);
                        return;
                    }
                    TaskResult<Authorize.Result> taskResult = result;
                    ARCameraStopRecordAction.this.handleAuthorized(context2, unitedSchemeEntity2, callbackHandler, swanApp2, aRCameraAttr, aRCameraView);
                }
            };
            setting.checkOrAuthorize(context, "mapp_record", r8);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void handleAuthorized(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp, ARCameraAttr model, ARCameraView preview) {
        if (!Util.hasCameraPermission(context) || !Util.hasRecordPermission(context)) {
            final UnitedSchemeEntity unitedSchemeEntity = entity;
            final CallbackHandler callbackHandler = handler;
            final SwanApp swanApp2 = swanApp;
            final ARCameraView aRCameraView = preview;
            final ARCameraAttr aRCameraAttr = model;
            RequestPermissionHelper.requestPermissionWithDialog(context, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, SwanAppPermission.REQUEST_CAMERA_CODE, new RequestPermissionListener() {
                public void onAuthorizedSuccess(String msg) {
                    ARCameraStopRecordAction.this.stopRecord(unitedSchemeEntity, callbackHandler, swanApp2, aRCameraView, aRCameraAttr);
                }

                public void onAuthorizedFailed(int errorCode, String errorMsg) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 10005);
                }
            });
            return;
        }
        stopRecord(entity, handler, swanApp, preview, model);
    }

    /* access modifiers changed from: private */
    public void stopRecord(UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp, ARCameraView preview, ARCameraAttr cameraModel) {
        boolean start = false;
        try {
            start = preview.stopRecord();
        } catch (Exception e2) {
            preview.removeVideoPath();
            Util.onExceptionError(cameraModel.slaveId, cameraModel.componentId);
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        String videoPath = preview.getVideoPath();
        if (!start || !isValidVideo(videoPath)) {
            callback(entity, handler, false);
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put("tempVideoPath", StorageUtil.path2SchemeWithExt(videoPath, swanApp.id));
            callBackWithData(entity, handler, map, "");
        }
        preview.removeVideoPath();
    }

    private boolean isValidVideo(String videoPath) {
        if (!(!TextUtils.isEmpty(videoPath))) {
            return false;
        }
        File videoFile = new File(videoPath);
        if (!videoFile.exists() || videoFile.length() <= 0) {
            return false;
        }
        return true;
    }
}
