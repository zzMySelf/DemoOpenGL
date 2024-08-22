package com.baidu.swan.apps.scheme.actions.favorite;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.database.favorite.SwanAppFavoriteHelper;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckIsFavoriteAction extends BaseFavoriteAction {
    private static final String ACTION_TYPE = "/swanAPI/isFavor";
    private static final String KEY_INVOKE_FROM = "invokeFrom";
    private static final String KEY_IS_FAVOR = "isFavor";
    private static final String SKIP_AUTHORIZE = "boxjs";

    public CheckIsFavoriteAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    /* access modifiers changed from: protected */
    public void doAction(SwanApp swanApp, UnitedSchemeEntity entity, CallbackHandler handler, String callback) {
        JSONObject resultJson = new JSONObject();
        try {
            resultJson.put("isFavor", SwanAppFavoriteHelper.isSwanAppInFavorite(this.mAppKey) ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(resultJson, 0).toString(), callback);
    }

    /* access modifiers changed from: protected */
    public boolean checkParams(SwanApp swanApp, UnitedSchemeEntity entity) {
        String params = entity.getParam("params");
        if (TextUtils.isEmpty(params)) {
            return false;
        }
        try {
            this.mAppKey = this.isFavorButton ? swanApp.getAppKey() : new JSONObject(params).optString("appid");
            return !TextUtils.isEmpty(this.mAppKey);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean skipAuthorize(UnitedSchemeEntity entity) {
        String invokeFrom = SwanAppJSONUtils.parseString(entity.getParam("params")).optString("invokeFrom");
        if (TextUtils.isEmpty(invokeFrom)) {
            return false;
        }
        return TextUtils.equals(invokeFrom, "boxjs");
    }
}
