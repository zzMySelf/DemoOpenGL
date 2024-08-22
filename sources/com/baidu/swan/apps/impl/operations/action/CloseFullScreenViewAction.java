package com.baidu.swan.apps.impl.operations.action;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.operations.FullScreenH5Manager;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;

public class CloseFullScreenViewAction extends SwanAppAction {
    private static final String ACTION_TYPE = "/swanAPI/closeFullScreenView";
    private static final String TAG = "CloseFullScreenView";

    public CloseFullScreenViewAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        if (swanApp == null) {
            SwanAppLog.e(TAG, "illegal swanApp");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        FullScreenH5Manager.close();
        UnitedSchemeUtility.callCallback(handler, entity, 0);
        return true;
    }
}
