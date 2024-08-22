package com.baidu.swan.gamecenter.appmanager.action;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.gamecenter.IGameCenterCallback;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.util.SwanAppActivityUtils;
import com.baidu.swan.apps.util.SwanAppRomUtils;
import com.baidu.swan.gamecenter.R;
import com.baidu.swan.gamecenter.main.GameCenterAction;
import org.json.JSONObject;

public class GameCenterOpenSpaceCleanActivity extends GameCenterAction {
    private static final String ACTION_NAME = "openSpaceCleanActivity";
    private static final String HUAWEI_CLASS_NAME = "com.huawei.systemmanager.appfeature.spacecleaner.SpaceCleanActivity";
    private static final String HUAWEI_PACKAGE_NAME = "com.huawei.systemmanager";
    private static final String MIUI_CLASS_NAME = "com.miui.optimizecenter.MainActivity";
    private static final String MIUI_PACKAGE_NAME = "com.miui.cleanmaster";
    private static final String OPPO_CLASS_NAME = "com.coloros.phonemanager.clear.ClearActivity";
    private static final String OPPO_PACKAGE_NAME = "com.coloros.phonemanager";
    private static final String VIVO_CLASS_NAME = "com.iqoo.secure.clean.PhoneCleanActivity2";
    private static final String VIVO_PACKAGE_NAME = "com.iqoo.secure";

    public GameCenterOpenSpaceCleanActivity() {
        super(ACTION_NAME);
    }

    public SwanApiResult handle(JSONObject paramsJson, IGameCenterCallback callback) {
        boolean result = false;
        if (SwanAppRomUtils.isEmui()) {
            result = startCleanActivity(HUAWEI_PACKAGE_NAME, HUAWEI_CLASS_NAME);
        } else if (SwanAppRomUtils.isMiui()) {
            result = startCleanActivity(MIUI_PACKAGE_NAME, MIUI_CLASS_NAME);
        } else if (SwanAppRomUtils.isOppo()) {
            result = startCleanActivity(OPPO_PACKAGE_NAME, OPPO_CLASS_NAME);
        } else if (SwanAppRomUtils.isVivo()) {
            result = startCleanActivity(VIVO_PACKAGE_NAME, VIVO_CLASS_NAME);
        }
        if (!result) {
            Toast.makeText(SwanAppRuntime.getAppContext(), R.string.aiapps_goto_clean_activity_fail, 0).show();
        }
        callback.onSuccess((JSONObject) null);
        return null;
    }

    private boolean startCleanActivity(String packageName, String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        return SwanAppActivityUtils.startActivitySafely((Context) SwanAppRuntime.getAppContext(), intent, true, false);
    }
}
