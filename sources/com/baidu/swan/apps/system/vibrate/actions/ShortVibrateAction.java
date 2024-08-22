package com.baidu.swan.apps.system.vibrate.actions;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.system.vibrate.utils.SwanAppVibrateManager;

public class ShortVibrateAction extends SwanAppAction {
    public static final String MODULE_NAME = "/swanAPI/vibrateShort";
    private static final String TAG = "ShortVibrateAction";

    public ShortVibrateAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, MODULE_NAME);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (DEBUG) {
            Log.d(TAG, "handle entity: " + entity.toString());
        }
        if (swanApp == null || !swanApp.isAppInvisible()) {
            SwanAppVibrateManager.getInstance().vibrateShort();
            UnitedSchemeUtility.callCallback(handler, entity, 0);
            return true;
        }
        if (DEBUG) {
            Log.d(TAG, "ShortVibrateAction does not supported when app is invisible.");
        }
        entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
        return false;
    }
}
