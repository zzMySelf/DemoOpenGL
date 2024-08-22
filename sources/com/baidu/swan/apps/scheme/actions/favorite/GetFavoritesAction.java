package com.baidu.swan.apps.scheme.actions.favorite;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetFavoritesAction extends BaseFavoriteAction {
    private static final String ACTION_TYPE = "/swanAPI/getFavor";
    private static final String KEY_APP_ID = "appid";
    private static final String KEY_FAVORS_ARRAY = "favors";
    private static final String KEY_FRAME_TYPE = "frameType";
    private static final String KEY_ICON_URL = "iconUrl";
    private static final String KEY_IS_NEW_FAVOR = "isNewFavor";
    private static final String KEY_PAY_PROTECTED = "payProtected";
    private static final String KEY_SCHEME = "scheme";
    private static final String KEY_SWAN_APP_TITLE = "title";
    private static final String KEY_SWAN_APP_TYPE = "type";
    private static final String SCHEME_CONSTANT_CONNECT = "\"}";
    private static final String SCHEME_CONSTANT_START = (SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"");
    private static final String SWAN_GAME_SCHEME_TEMPLET = (SchemeConfig.getSchemeHead() + "://swangame/%s");
    private static final String SWAN_SCHEME_WITH_ROOT_SOURCE = (SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"%s\",\"sysExt\":{\"rootSource\":\"%s\"}}");

    public GetFavoritesAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    /* access modifiers changed from: protected */
    public void doAction(SwanApp swanApp, UnitedSchemeEntity entity, CallbackHandler handler, String callback) {
        JSONArray favArray = new JSONArray();
        List<SwanFavorItemData> infos = SwanFavorDataManager.getInstance().getLocalFavorData();
        if (infos.size() > 0) {
            for (SwanFavorItemData info : infos) {
                favArray.put(generateJsonObjFromDbInfo(info));
            }
        }
        JSONObject resultJson = new JSONObject();
        try {
            resultJson.put("favors", favArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(resultJson, 0).toString(), callback);
    }

    private JSONObject generateJsonObjFromDbInfo(SwanFavorItemData info) {
        String scheme;
        JSONObject infoJson = new JSONObject();
        try {
            infoJson.put("appid", info.getAppKey());
            infoJson.put("type", info.getAppType());
            infoJson.put("iconUrl", info.getIconUrl());
            infoJson.put("title", info.getAppName());
            infoJson.put("frameType", info.getAppFrameType());
            infoJson.put("payProtected", info.getPayProtected());
            infoJson.put(KEY_IS_NEW_FAVOR, info.getIsNewFavor());
            infoJson.put("rootSource", info.getRootSource());
            if (info.getAppFrameType() == 1) {
                scheme = String.format(SWAN_GAME_SCHEME_TEMPLET, new Object[]{info.getAppKey()});
            } else if (!TextUtils.isEmpty(info.getRootSource())) {
                scheme = String.format(SWAN_SCHEME_WITH_ROOT_SOURCE, new Object[]{info.getAppKey(), info.getRootSource()});
            } else {
                scheme = SCHEME_CONSTANT_START + info.getAppKey() + "\"}";
            }
            infoJson.put("scheme", scheme);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return infoJson;
    }

    /* access modifiers changed from: protected */
    public boolean checkParams(SwanApp swanApp, UnitedSchemeEntity entity) {
        return true;
    }
}
