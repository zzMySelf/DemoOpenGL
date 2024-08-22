package com.baidu.swan.apps.jsbridge.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.api.SwanApiBinding;
import com.baidu.swan.apps.core.container.JSContainer;
import com.baidu.swan.apps.engine.IV8Engine;
import com.baidu.swan.apps.jsbridge.SwanAppBaseJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;

public class SwanAppBindingDelegate {
    private SwanApiBinding mSwanApiBinding;
    private SwanAppBaseJsBridge mSwanAppGlobalJsBridge;
    private SwanAppBaseJsBridge mSwanAppJsBridge;
    private SwanAppUtilsJavaScriptInterface mUtilsJsBridge;

    public void doBinding(JSContainer container, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher dispatcher) {
        if (container != null && context != null && callbackHandler != null && dispatcher != null) {
            SwanApiBinding swanApiBinding = new SwanApiBinding(context, callbackHandler, container);
            this.mSwanApiBinding = swanApiBinding;
            bindCommonJsBridge(container, context, callbackHandler, dispatcher, swanApiBinding);
            if (container instanceof IV8Engine) {
                bindV8JsBridge(container, context, this.mSwanApiBinding);
            } else {
                bindWebViewJsBridge(container);
            }
        }
    }

    public void injectJsInterfaces(Context context, JSContainer container) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, container);
        this.mUtilsJsBridge = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        container.addJavascriptInterface(this.mUtilsJsBridge, "Bdbox_android_utils");
        this.mUtilsJsBridge.setForceShareLight(true);
    }

    private void bindCommonJsBridge(JSContainer container, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher dispatcher, SwanApiBinding swanApiBinding) {
        SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, dispatcher, callbackHandler, container);
        this.mSwanAppGlobalJsBridge = swanAppGlobalJsBridge;
        container.addJavascriptInterface(swanAppGlobalJsBridge, "Bdbox_android_jsbridge");
        SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, dispatcher, callbackHandler, container);
        this.mSwanAppJsBridge = swanAppJsBridge;
        container.addJavascriptInterface(swanAppJsBridge, "Bdbox_aiapps_jsbridge");
        container.addJavascriptInterface(new SwanAppPreloadJsBridge(container), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        swanApiBinding.bindSwanApis(container);
    }

    private void bindWebViewJsBridge(JSContainer container) {
        container.addJavascriptInterface(new SwanAppNativeSwanJsBridge(container), "_naSwan");
    }

    private void bindV8JsBridge(JSContainer container, Context context, SwanApiBinding swanApiBinding) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, container);
        this.mUtilsJsBridge = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        container.addJavascriptInterface(this.mUtilsJsBridge, "Bdbox_android_utils");
        swanApiBinding.bindOnlyV8SwanApis(container);
    }

    public void attachContextToBridge(Activity activity) {
        SwanAppBaseJsBridge swanAppBaseJsBridge = this.mSwanAppGlobalJsBridge;
        if (swanAppBaseJsBridge != null) {
            swanAppBaseJsBridge.setActivityRef(activity);
        }
        SwanAppBaseJsBridge swanAppBaseJsBridge2 = this.mSwanAppJsBridge;
        if (swanAppBaseJsBridge2 != null) {
            swanAppBaseJsBridge2.setActivityRef(activity);
        }
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.mUtilsJsBridge;
        if (swanAppUtilsJavaScriptInterface != null) {
            swanAppUtilsJavaScriptInterface.setActivity(activity);
        }
        SwanApiBinding swanApiBinding = this.mSwanApiBinding;
        if (swanApiBinding != null) {
            swanApiBinding.setActivityRef(activity);
        }
    }
}
