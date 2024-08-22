package com.baidu.swan.card.render.engine.v8inspector;

import android.util.Log;
import com.baidu.swan.card.card.core.SwanCardCoreRuntime;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanCardUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class V8Module {
    private static final String APP_VERSION = "appVersion";
    private static final String ATTACHED = "attached";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String DESCRIPTION = "description";
    private static final String DEV_TOOLS_FROUNTED_URL = "devtoolsFrontendUrl";
    private static final String EMPTY = "empty";
    private static final String HOST = "localhost";
    private static final String ID = "id";
    private static final String PORT = "4000";
    private static final String SCREEN_X = "screenX";
    private static final String SCREEN_Y = "screenY";
    private static final String SWAN_CORE_VERSION = "swanJsVersion";
    private static final String TAG = "V8Module";
    private static final String TITLE = "title";
    private static final String TYPE = "type";
    private static final String URL = "url";
    private static final String V8_URL = "localhost:4000";
    private static final String VISIBLE = "visible";
    private static final String WEB_SOCKET_DEBUGGER_URL = "webSocketDebuggerUrl";
    private static String mTitle = "V8Master";
    private static String mType = "page";
    private static String mUrl = SwanCardCoreRuntime.MASTER_JS_PATH;
    private static String mWebSocketDebuggerUrl = "ws://localhost:4000";
    private String devtoolsFrontendUrl = "devtools://devtools/bundled/inspector.html?ws=localhost:4000";
    private boolean mAttached = false;
    private boolean mEmpty = true;
    private String mId = String.valueOf(System.currentTimeMillis());
    private int mScreenX = 0;
    private int mScreenY = 0;
    private boolean mVisible = true;

    public String toString() {
        JSONArray array = new JSONArray();
        JSONObject module = new JSONObject();
        JSONObject description = new JSONObject();
        try {
            module.putOpt("title", mTitle);
            module.putOpt("type", mType);
            module.putOpt("url", mUrl);
            module.putOpt(WEB_SOCKET_DEBUGGER_URL, mWebSocketDebuggerUrl);
            module.putOpt("id", this.mId);
            module.putOpt(DEV_TOOLS_FROUNTED_URL, this.devtoolsFrontendUrl);
            module.putOpt(SWAN_CORE_VERSION, SwanCardRuntime.getSwanCardContext().getSwanCoreVersionName());
            module.putOpt("appVersion", SwanCardUtil.getVersionName());
            description.putOpt(ATTACHED, Boolean.valueOf(this.mAttached));
            description.putOpt("empty", Boolean.valueOf(this.mEmpty));
            description.putOpt(SCREEN_X, Integer.valueOf(this.mScreenX));
            description.putOpt(SCREEN_Y, Integer.valueOf(this.mScreenY));
            description.putOpt("visible", Boolean.valueOf(this.mVisible));
            module.putOpt("description", description.toString());
            array.put(module);
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "Build V8 module fail", e2);
            }
        }
        return array.toString();
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
