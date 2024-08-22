package com.baidu.swan.games.opendata;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.engine.IV8Engine;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.games.install.SwanGameBundleHelper;

public class SwanGameOpenDataContext {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanGameOpenDataContext";
    @V8JavascriptField
    public JsObject canvas = null;
    private IV8Engine mEngine;

    public SwanGameOpenDataContext(IV8Engine engine) {
        this.mEngine = engine;
        createOpenDataContext();
        includeOpenDataContext();
    }

    private boolean createOpenDataContext() {
        return requireJSFileForOpenData(this.mEngine.getInitBasePath(), SwanGameBundleHelper.SWAN_GAME_OPEN_DATA_SWAN_JS_FILE);
    }

    private boolean includeOpenDataContext() {
        String baseFilePath = SwanAppController.getInstance().getBaseUrl();
        String openDataJSFile = SwanGameOpenDataHelper.getInstance().getOpenDataJSRelativePath();
        if (DEBUG) {
            Log.d(TAG, "baseFilePath: " + baseFilePath);
            Log.d(TAG, "openDataJSFile: " + openDataJSFile);
        }
        return requireJSFileForOpenData(baseFilePath, openDataJSFile);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.mEngine.getOpenContext().destroyContext();
    }

    @JavascriptInterface
    public void postMessage(JsObject message) {
        this.mEngine.getOpenObject().dispatchEvent(new JSEvent("postmessage", message));
    }

    private boolean requireJSFileForOpenData(String baseFilePath, String jsFilePath) {
        if (!SwanGameOpenDataHelper.getInstance().isNeedOpenData() || TextUtils.isEmpty(baseFilePath)) {
            return false;
        }
        this.mEngine.getOpenContext().requireJsFile(baseFilePath, jsFilePath);
        return true;
    }
}
