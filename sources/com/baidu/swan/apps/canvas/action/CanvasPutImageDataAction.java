package com.baidu.swan.apps.canvas.action;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.model.CanvasPutImageDataModel;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.components.canvas.utils.SwanAppCanvasComponentUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import org.json.JSONObject;

@Deprecated
public class CanvasPutImageDataAction extends AbsCanvasAction {
    public static final String ACTION_TYPE = "/swanAPI/canvas/putImageData";
    public static final int ERR_INVALID_DATA = 2001;
    public static final int ERR_INVALID_SIZE = 2002;
    public static final String ERR_MSG_EXECUTE_FAIL = "error draw on canvas";
    public static final String ERR_MSG_INVALID_DATA = "data length invalid";
    public static final String ERR_MSG_INVALID_SIZE = "width / height must > 0";
    private static final String TASK_NAME = "CanvasPutImageDataAction";

    public /* bridge */ /* synthetic */ void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.callback(unitedSchemeEntity, callbackHandler, z);
    }

    public /* bridge */ /* synthetic */ View getBdWebViewBySlaveId(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.getBdWebViewBySlaveId(unitedSchemeEntity, str);
    }

    public /* bridge */ /* synthetic */ JSONObject resultCode(int i2) {
        return super.resultCode(i2);
    }

    public CanvasPutImageDataAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, final CallbackHandler handler, SwanApp swanApp) {
        SwanAppFragment fragment;
        final CanvasPutImageDataModel model = parseMsgToModel(entity);
        if (model == null) {
            SwanAppLog.e("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            entity.result = resultCode(201);
            return false;
        }
        if (TextUtils.isEmpty(model.slaveId) && (fragment = SwanAppController.getInstance().getTopSwanAppFragment()) != null) {
            model.slaveId = fragment.getSlaveWebViewId();
        }
        if (TextUtils.isEmpty(model.slaveId) || TextUtils.isEmpty(model.componentId)) {
            SwanAppLog.e("SwanAppCanvas", "CanvasPutImageData slave id = " + model.slaveId + " ; canvas id = " + model.componentId);
            entity.result = resultCode(201);
            return false;
        }
        final CanvasView canvasView = SwanAppCanvasComponentUtils.getCanvasViewByCanvasId(model);
        if (canvasView == null) {
            SwanAppLog.e("SwanAppCanvas", "CanvasPutImageData canvas view is null");
            entity.result = resultCode(201);
            return false;
        }
        SwanAppExecutorUtils.postOnIO(new Runnable() {
            public void run() {
                JSONObject paramsObj;
                int statusCode = model.decodeBitmap();
                if (statusCode == 0) {
                    paramsObj = UnitedSchemeUtility.wrapCallbackParams(0);
                    canvasView.addDrawActionList(model.getDrawActionList(), model.isReserve());
                    canvasView.postInvalidate();
                } else {
                    paramsObj = UnitedSchemeUtility.wrapCallbackParams(statusCode, CanvasPutImageDataAction.this.getErrorMessage(statusCode));
                }
                String callback = model.callback;
                if (!TextUtils.isEmpty(callback)) {
                    handler.handleSchemeDispatchCallback(callback, paramsObj.toString());
                }
            }
        }, TASK_NAME);
        UnitedSchemeUtility.callCallback(handler, entity, 0);
        return true;
    }

    /* access modifiers changed from: private */
    public String getErrorMessage(int statusCode) {
        switch (statusCode) {
            case 2001:
                return "data length invalid";
            case 2002:
                return "width / height must > 0";
            default:
                return "error draw on canvas";
        }
    }

    public CanvasPutImageDataModel parseMsgToModel(UnitedSchemeEntity entity) {
        String paramsJson = entity.getParams().get("params");
        if (!TextUtils.isEmpty(paramsJson)) {
            return new CanvasPutImageDataModel(paramsJson);
        }
        return null;
    }
}
