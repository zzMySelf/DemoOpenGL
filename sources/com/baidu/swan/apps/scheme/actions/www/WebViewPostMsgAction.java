package com.baidu.swan.apps.scheme.actions.www;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewWidget;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.view.container.util.SwanAppEventHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewPostMsgAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/webviewPostMessage";
    private static final String EVENT_NAME = "webview";
    public static final String EVENT_TYPE_MESSAGE = "message";
    private static final String KEY_COMPONENT_ID = "componentId";
    private static final String KEY_DATA = "data";
    private static final String KEY_EVENT_TYPE = "eventType";
    private static final String KEY_IS_AUTHORIZED = "isAuthorized";
    private static final String KEY_SLAVE_ID = "slaveId";
    private static final String KEY_WEBVIEW_ID = "webviewId";
    private static final String KEY_WV_ID = "wvID";
    private static final String MODULE_TAG = "webviewPostMsg";
    private static final String PARAM_DATA_KEY = "data";
    private static final String TAG = "WebViewPostMsgAction";
    private ISwanAppWebViewWidget mWebViewWidget;

    public WebViewPostMsgAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (DEBUG) {
            Log.d(TAG, "handle entity: " + entity.toString());
        }
        SwanAppLog.i(MODULE_TAG, "start post webview msg");
        ISwanAppWebViewWidget iSwanAppWebViewWidget = this.mWebViewWidget;
        if (iSwanAppWebViewWidget == null) {
            SwanAppLog.e(MODULE_TAG, "none webview widget");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
            return false;
        }
        WWWParams params = iSwanAppWebViewWidget.getParams();
        if (params == null) {
            SwanAppLog.e(MODULE_TAG, "none WWWParams");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
            return false;
        }
        JSONObject joParams = getParamAsJo(entity, "params");
        if (joParams == null) {
            SwanAppLog.e(MODULE_TAG, "none params");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        } else if (!joParams.has("data")) {
            SwanAppLog.e(MODULE_TAG, "none param data");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
            return false;
        } else {
            sendEventToMater(entity, handler, joParams, params);
            return true;
        }
    }

    private void sendEventToMater(UnitedSchemeEntity entity, CallbackHandler handler, JSONObject joParams, WWWParams params) {
        String data = joParams.optString("data");
        JSONObject dataObj = new JSONObject();
        try {
            dataObj.put("data", data);
            dataObj.put("eventType", "message");
            dataObj.put("wvID", joParams.optString("slaveId", params.slaveId));
            dataObj.put(KEY_WEBVIEW_ID, joParams.optString("componentId", params.componentId));
            dataObj.put("isAuthorized", params.instantMessage);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            SwanAppLog.e(MODULE_TAG, "meet json exception");
        }
        SwanAppEventHelper.sendEventToMaster(dataObj.optString("wvID"), dataObj.optString(KEY_WEBVIEW_ID), "webview", "message", dataObj);
        SwanAppLog.i(MODULE_TAG, "post webview msg success");
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, 0);
    }

    public void setWebViewWidget(ISwanAppWebViewWidget webViewWidget) {
        this.mWebViewWidget = webViewWidget;
    }
}
