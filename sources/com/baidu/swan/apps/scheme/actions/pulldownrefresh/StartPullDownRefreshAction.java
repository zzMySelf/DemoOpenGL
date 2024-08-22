package com.baidu.swan.apps.scheme.actions.pulldownrefresh;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.pullrefresh.PullToRefreshBaseWebView;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;

public class StartPullDownRefreshAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/startPullDownRefresh";
    private static final long DELAY_MILL_IS = 100;
    private static final String MODULE_TAG = "startPullDownRefresh";

    public StartPullDownRefreshAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (swanApp != null) {
            swanApp.getSwanForbidden().checkIsForbidden(swanApp.getAppId());
        }
        if (swanApp == null || !swanApp.isAppInvisible()) {
            ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
            if (manager == null) {
                SwanAppLog.e(MODULE_TAG, "manager is null");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!(manager.getTopFragment() instanceof SwanAppFragment)) {
                SwanAppLog.e(MODULE_TAG, "top fragment error");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                SwanAppFragment swanAppFragment = (SwanAppFragment) manager.getTopFragment();
                if (swanAppFragment.getPullToRefreshWebView() == null) {
                    SwanAppLog.e(MODULE_TAG, "view is null");
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                PullToRefreshBaseWebView refreshWebView = swanAppFragment.getPullToRefreshWebView();
                if (refreshWebView == null) {
                    SwanAppLog.e(MODULE_TAG, "view is null");
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (refreshWebView.isPreventPullToRefresh()) {
                    SwanAppLog.e(MODULE_TAG, "prevent pull to refresh");
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    SwanAppLog.i(MODULE_TAG, "start pull refresh");
                    swanAppFragment.getPullToRefreshWebView().doPullRefreshing(true, 100);
                    UnitedSchemeUtility.callCallback(handler, entity, 0);
                    return true;
                }
            }
        } else {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
    }
}
