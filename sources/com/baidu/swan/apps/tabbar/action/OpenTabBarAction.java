package com.baidu.swan.apps.tabbar.action;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.tabbar.controller.SwanAppBottomBarViewController;
import org.json.JSONObject;

public class OpenTabBarAction extends BaseTabBarAction {
    private static final String ACTION_TYPE = "/swanAPI/openTabBar";
    private static final String MODULE_TAG = "openTabBar";
    protected static final String TAG = "OpenTabBarAction";

    public OpenTabBarAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        JSONObject paramsJson = UnitedSchemeUtility.optParamsAsJo(entity);
        if (paramsJson == null) {
            SwanAppLog.e(MODULE_TAG, "paramsJson is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (isNotTabFragment()) {
            SwanAppLog.e(TAG, "fail not TabBar page");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fail not TabBar page");
            return false;
        } else {
            SwanAppBottomBarViewController bottomBarViewController = getTabBarViewController();
            if (bottomBarViewController == null) {
                SwanAppLog.e(TAG, "tabBarViewController is null");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!bottomBarViewController.openBottomBar(paramsJson.optBoolean("animation"))) {
                SwanAppLog.e(MODULE_TAG, "open bottom bar fail");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }
}
