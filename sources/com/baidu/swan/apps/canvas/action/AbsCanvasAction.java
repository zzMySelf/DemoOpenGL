package com.baidu.swan.apps.canvas.action;

import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebView;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager;
import com.baidu.swan.apps.canvas.model.CanvasBasicModel;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import org.json.JSONObject;

@Deprecated
abstract class AbsCanvasAction extends SwanAppAction implements ICanvasPreHandle {
    static final String CANVAS_BASE_MODULE = "/swanAPI/canvas/";
    static final String MODULE_TAG = "SwanAppCanvas";

    AbsCanvasAction(UnitedSchemeSwanAppDispatcher dispatcher, String name) {
        super(dispatcher, name);
    }

    public CanvasBasicModel parseMsgToModel(UnitedSchemeEntity entity) {
        return new CanvasBasicModel(entity.getParams().get("params"));
    }

    public View getBdWebViewBySlaveId(UnitedSchemeEntity entity, String slaveId) {
        ISwanAppWebViewManager manager = SwanAppController.getInstance().getWebViewManager(slaveId);
        if (manager == null) {
            entity.result = resultCode(1001);
            return null;
        }
        ISwanAppWebView ngWebView = manager.getWebView();
        if (ngWebView != null) {
            return ngWebView.getCurrentWebView();
        }
        entity.result = resultCode(1001);
        return null;
    }

    public JSONObject resultCode(int statusCode) {
        return UnitedSchemeUtility.wrapCallbackParams(statusCode);
    }

    public void callback(UnitedSchemeEntity entity, CallbackHandler handler, boolean isSuccess) {
        UnitedSchemeUtility.callCallback(handler, entity, isSuccess ? 0 : 1001);
    }
}
