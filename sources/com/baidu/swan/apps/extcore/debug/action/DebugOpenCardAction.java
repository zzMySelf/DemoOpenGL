package com.baidu.swan.apps.extcore.debug.action;

import android.content.Context;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import org.json.JSONArray;
import org.json.JSONObject;

public class DebugOpenCardAction extends SwanAppAction {
    private static final String ACTION_NAME = "/swanAPI/debug/openMini";
    public static final String PARAM_CARDS_KEY = "cards";
    public static final String PARAM_FIXED_HEIGHT_KEY = "isFixedHeight";
    public static final String PARAM_GROUP_KEY = "group";
    public static final String PARAM_SCHEME_KEY = "scheme";

    public DebugOpenCardAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_NAME);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        JSONObject joParams = getParamAsJo(entity, "params");
        if (joParams == null) {
            Toast.makeText(context, R.string.aiapps_debug_params_empty, 1).show();
            return false;
        }
        JSONArray cards = joParams.optJSONArray("cards");
        if (cards == null) {
            Toast.makeText(context, R.string.aiapps_debug_scheme_empty, 1).show();
            return false;
        }
        SwanAppRuntime.getCardIoc().openSwanCardDebugActivity(cards.toString());
        return true;
    }
}
