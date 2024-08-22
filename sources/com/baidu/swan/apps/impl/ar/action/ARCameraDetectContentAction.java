package com.baidu.swan.apps.impl.ar.action;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.ar.SwanAppARCameraComponent;
import com.baidu.swan.apps.impl.ar.listener.OnFrameCapturedListener;
import com.baidu.swan.apps.impl.ar.manager.Util;
import com.baidu.swan.apps.impl.ar.model.ARCameraAttr;
import com.baidu.swan.apps.impl.ar.view.ARCameraView;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class ARCameraDetectContentAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swanAPI/ARCamera/detectContent";
    private static final int ERR_CODE_OTHERS = 1004;

    public ARCameraDetectContentAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        ARCameraAttr cameraModel = parseData(unitedSchemeEntity);
        if (cameraModel == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 1000, "detect: params invalid", 201, "");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        SwanAppARCameraComponent component = (SwanAppARCameraComponent) SwanAppComponentFinder.findComponent(cameraModel);
        if (component == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "detect: component is null", 1001, "get ar camera component is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera component is null");
            return false;
        }
        ARCameraView cameraView = (ARCameraView) component.getView();
        if (cameraView == null) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "detect: cameraView is null", 1001, "get ar camera view is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e("AbsARAction", "get ar camera view is null");
            return false;
        }
        String swanAppTmpPath = StorageUtil.getSwanAppTmpDirectory(swanApp.id);
        if (TextUtils.isEmpty(swanAppTmpPath)) {
            SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "detect: swanAppTmpPath is null", 1001, "");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final ARCameraView aRCameraView = cameraView;
        final String str = swanAppTmpPath;
        final UnitedSchemeEntity unitedSchemeEntity2 = entity;
        final CallbackHandler callbackHandler = handler;
        final SwanApp swanApp2 = swanApp;
        final ARCameraAttr aRCameraAttr = cameraModel;
        cameraView.captureAFrame(new OnFrameCapturedListener() {
            public void onFrameCaptured(final byte[] data, final int width, final int height) {
                SwanAppLog.i("AbsARAction", "onFrameCaptured: (" + width + ", " + height + ")");
                SwanAppExecutorUtils.postOnIO(new Runnable() {
                    public void run() {
                        StringBuilder sb;
                        String savePath = aRCameraView.getTakePhotoPath(str);
                        try {
                            File file = new File(savePath);
                            if (file.exists()) {
                                SwanAppLog.i("AbsARAction", "delete = " + file.delete());
                            }
                            if (file.getParentFile() != null) {
                                SwanAppLog.i("AbsARAction", "mkdirs = " + file.getParentFile().mkdirs());
                            }
                            new YuvImage(data, 17, width, height, (int[]) null).compressToJpeg(new Rect(0, 0, width, height), 80, new FileOutputStream(file));
                            if (1 != 0) {
                                sb = new StringBuilder();
                                SwanAppLog.i("AbsARAction", sb.append("save success path: ").append(savePath).toString());
                                ARCameraDetectContentAction.this.callbacks(unitedSchemeEntity2, callbackHandler, swanApp2, aRCameraAttr, StorageUtil.path2SchemeWithExt(savePath, swanApp2.id));
                                return;
                            }
                        } catch (Exception | OutOfMemoryError e2) {
                            if (ARCameraDetectContentAction.DEBUG) {
                                e2.printStackTrace();
                            }
                            if (0 != 0) {
                                sb = new StringBuilder();
                            }
                        } catch (Throwable th2) {
                            if (0 != 0) {
                                SwanAppLog.i("AbsARAction", "save success path: " + savePath);
                                ARCameraDetectContentAction.this.callbacks(unitedSchemeEntity2, callbackHandler, swanApp2, aRCameraAttr, StorageUtil.path2SchemeWithExt(savePath, swanApp2.id));
                            } else {
                                SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "detect: save failure", 1001, "save failure");
                                SwanAppLog.e("AbsARAction", "save failure");
                                ARCameraDetectContentAction.this.callbacks(unitedSchemeEntity2, callbackHandler, swanApp2, aRCameraAttr, (String) null);
                            }
                            throw th2;
                        }
                        SwanAppStabilityMonitor.onStabilityMonitor(SwanAppStabilityMonitor.SCENE_AR_CAMERA, 2001, "detect: save failure", 1001, "save failure");
                        SwanAppLog.e("AbsARAction", "save failure");
                        ARCameraDetectContentAction.this.callbacks(unitedSchemeEntity2, callbackHandler, swanApp2, aRCameraAttr, (String) null);
                    }
                }, "saveImage");
            }
        });
        callback(unitedSchemeEntity, handler, true);
        return true;
    }

    /* access modifiers changed from: private */
    public void callbacks(UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp, ARCameraAttr cameraModel, String path) {
        JSONObject resObject = new JSONObject();
        try {
            resObject.put("tempImagePath", path);
        } catch (JSONException e2) {
            Util.onExceptionError(cameraModel.slaveId, cameraModel.componentId);
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        UnitedSchemeUtility.safeCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(resObject, !TextUtils.isEmpty(path) ? 0 : 1004).toString(), cameraModel.cb);
    }
}
