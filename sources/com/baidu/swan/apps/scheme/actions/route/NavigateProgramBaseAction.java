package com.baidu.swan.apps.scheme.actions.route;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.utils.ParserUtils;
import org.json.JSONObject;

public abstract class NavigateProgramBaseAction extends SwanAppAction {
    protected static final String HOST_BAIDU = "baiduboxapp";
    protected static final String KEY_ATTACHED_INFO = "attachedInfo";
    protected static final String KEY_EXTRA_DATA = "extraData";
    protected static final String KEY_FROM = "from";
    protected static final String KEY_PATH = "path";
    protected static final String KEY_PKGTYPE = "pkgType";
    protected static final String KEY_PRE_APPID = "pre_appid";
    protected static final String KEY_PRE_SOURCE = "pre_source";
    protected static final String KEY_SRC_APP_ID = "srcAppId";
    protected static final String KEY_UBC = "ubc";
    protected static final String ORIGIN_APP_KEY = "originAppkey";
    public static final String ORIGIN_APP_TYPE = "originAppType";
    protected static final String ORIGIN_FROM = "originFrom";
    protected static final String ORIGIN_PKG_TYPE = "originPkgType";
    protected static final String SRC_APP_PAGE = "srcAppPage";
    protected String mCb;
    protected JSONObject mParamsJson;

    public NavigateProgramBaseAction(UnitedSchemeBaseDispatcher dispatcher, String name) {
        super(dispatcher, name);
    }

    /* access modifiers changed from: protected */
    public boolean paramCheck(UnitedSchemeEntity entity, SwanApp swanApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
        this.mParamsJson = optParamsAsJo;
        if (optParamsAsJo == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (swanApp == null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (swanApp.isAppInvisible()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String optString = this.mParamsJson.optString("cb");
            this.mCb = optString;
            if (!TextUtils.isEmpty(optString)) {
                return true;
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public String getRootSource() {
        SwanAppLaunchInfo info = Swan.get().getApp().getInfo();
        String launchFrom = info.getLaunchFrom();
        if (TextUtils.isEmpty(launchFrom)) {
            launchFrom = "NA";
        }
        Bundle extraBundle = info.getExtraData();
        String ubc = "";
        if (extraBundle != null) {
            ubc = extraBundle.getString("ubc");
        }
        return ParserUtils.parse(SwanAppJSONUtils.parseString(ubc), "pre_source", launchFrom);
    }
}
