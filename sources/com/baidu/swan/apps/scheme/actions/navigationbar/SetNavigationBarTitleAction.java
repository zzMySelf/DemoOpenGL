package com.baidu.swan.apps.scheme.actions.navigationbar;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppBaseFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import org.json.JSONObject;

@Deprecated
public class SetNavigationBarTitleAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/setNavigationBarTitle";
    private static final String MODULE_TAG = "navigationTitle";
    private static final String TAG = "BarTitleAction";

    public SetNavigationBarTitleAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (DEBUG) {
            Log.d(TAG, "handle entity: " + entity.toString());
        }
        JSONObject paramsJson = UnitedSchemeUtility.optParamsAsJo(entity);
        if (paramsJson == null) {
            SwanAppLog.e(MODULE_TAG, "paramsJson is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String title = paramsJson.optString("title");
        ISwanPageManager manager = SwanAppController.getInstance().getSwanPageManager();
        if (manager == null) {
            SwanAppLog.e(MODULE_TAG, "manager is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        SwanAppBaseFragment swanAppFragment = manager.getTopFragment();
        if (!(swanAppFragment != null && swanAppFragment.setActionbarTitle(title, true))) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            SwanAppLog.e(MODULE_TAG, "set title fail");
            return false;
        }
        UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
