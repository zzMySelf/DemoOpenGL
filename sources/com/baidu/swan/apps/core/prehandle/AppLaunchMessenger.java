package com.baidu.swan.apps.core.prehandle;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.process.messaging.SwanAppMessenger;
import com.baidu.swan.apps.process.messaging.SwanMsgCooker;
import com.baidu.swan.apps.process.messaging.service.SwanClientPuppet;

public final class AppLaunchMessenger {
    public static final String BUNDLE_KEY_ON_APP_LAUNCH_EVENT = "swan_app_on_launch_event";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String TAG = "AppLaunchMessenger";

    public static void sendAppLaunchEvent(SwanClientPuppet client, Bundle info) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "sendAppLaunchEvent event start.");
        }
        Bundle bundle = new Bundle();
        bundle.putBundle(BUNDLE_KEY_ON_APP_LAUNCH_EVENT, info);
        SwanMsgCooker cooker = new SwanMsgCooker(122, bundle);
        SwanAppMessenger.get().send(cooker.addTarget(client.mProcess.getClientMsgTarget()).setSticky(true));
        if (z) {
            Log.d(TAG, "sendAppLaunchEvent event end.");
        }
    }
}
