package com.baidu.swan.card.render.engine.event.msg;

import android.util.Log;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import java.util.Map;

public class SwanAppReadyMessage extends SwanAppCommonMessage {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "SwanAppReadyMessage";

    public SwanAppReadyMessage(String event) {
        super(event);
    }

    public SwanAppReadyMessage(String event, Map<String, String> params) {
        super(event, params);
        if (!DEBUG) {
            return;
        }
        if (params == null) {
            Log.w(TAG, "appReady Event is empty");
            return;
        }
        for (Map.Entry<String, String> entry : params.entrySet()) {
            Log.d(TAG, entry.getKey() + " : " + entry.getValue());
        }
    }
}
