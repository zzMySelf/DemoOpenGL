package com.baidu.swan.apps.scheme.actions.route;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppStatsUtils;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import org.json.JSONObject;

public class NavigateBackSmartProgramAction extends NavigateProgramBaseAction {
    private static final String ACTION_TYPE = "/swanAPI/navigateBackProgram";
    private static final String TAG = "NavigateBackSmartProgram";

    public NavigateBackSmartProgramAction(UnitedSchemeBaseDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        boolean checkRes = paramCheck(entity, swanApp);
        if (this.mParamsJson.optJSONObject("extraData") == null) {
            SwanAppJSONUtils.setValue(this.mParamsJson, "extraData", new JSONObject());
        }
        if (!buildLaunchScheme(this.mCb, this.mParamsJson, handler, entity, swanApp) || !checkRes) {
            return false;
        }
        UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private boolean buildLaunchScheme(String cb, JSONObject paramsJson, CallbackHandler handler, UnitedSchemeEntity entity, SwanApp swanApp) {
        String str = cb;
        JSONObject jSONObject = paramsJson;
        CallbackHandler callbackHandler = handler;
        String[] attachedInfo = getAttachedInfo(swanApp);
        String originAppKey = attachedInfo[0];
        String originPkgType = attachedInfo[1];
        String originAppType = attachedInfo[2];
        String originFrom = attachedInfo[3];
        if (TextUtils.equals(originAppType, "mini")) {
            ISwanFrameContainer frameContainer = Swan.get().getSwanFrameContainer();
            if (frameContainer != null) {
                frameContainer.closeSwanApp();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            return true;
        } else if (TextUtils.isEmpty(originAppKey)) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            if (DEBUG) {
                Log.d(TAG, "navigateBackProgram can not be invoked before navigateToProgram");
            }
            return false;
        } else {
            UnitedSchemeEntity unitedSchemeEntity = entity;
            String previousPath = SwanAppLaunchInfo.getPathFromScheme(swanApp.getInfo().getLaunchScheme());
            String curPage = SwanAppPageParam.buildPageWithParams(SwanAppUtils.getCurSwanAppPageParam());
            JSONObject ubcObj = new JSONObject();
            SwanAppJSONUtils.setValue(ubcObj, "pre_appid", swanApp.getAppKey());
            SwanAppJSONUtils.setValue(ubcObj, "pre_source", getRootSource());
            SwanAppJSONUtils.setValue(jSONObject, "ubc", ubcObj);
            SwanAppJSONUtils.setValue(jSONObject, "pkgType", Integer.valueOf(originPkgType));
            SwanAppJSONUtils.setValue(jSONObject, "from", originFrom);
            SwanAppJSONUtils.setValue(jSONObject, "path", previousPath);
            SwanAppJSONUtils.setValue(jSONObject, "srcAppPage", curPage);
            SwanAppJSONUtils.setValue(jSONObject, "srcAppId", swanApp.getAppKey());
            NavigateToSmartProgramAction.addSessionIdToSysExtPart(paramsJson);
            NavigateToSmartProgramAction.addSearchLogToExtPart(paramsJson);
            String frameName = SwanAppStatsUtils.getFrameName(0);
            JSONObject jSONObject2 = ubcObj;
            Uri uri = new Uri.Builder().scheme(SwanAppRuntime.getConfig().getSchemeHeader()).authority(frameName).path(originAppKey + "/").appendQueryParameter("_baiduboxapp", paramsJson.toString()).build();
            if (DEBUG) {
                Log.i(TAG, uri.toString());
            }
            if (uri == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                return false;
            }
            int statusCode = 0;
            if (!SchemeRouter.invokeScheme(swanApp.getApplicationContext(), uri, "inside")) {
                statusCode = 1001;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(statusCode).toString());
            return true;
        }
    }

    private String[] getAttachedInfo(SwanApp swanApp) {
        String schemeParams = UnitedSchemeUtility.getParams(swanApp.getInfo().getLaunchScheme()).get("_baiduboxapp");
        String originAppKey = "";
        String originPkgType = "";
        String originAppTye = "";
        String originFrom = "";
        if (schemeParams != null) {
            JSONObject extObj = SwanAppJSONUtils.parseString(schemeParams).optJSONObject("sysExt");
            JSONObject attachedInfo = null;
            if (extObj != null) {
                attachedInfo = extObj.optJSONObject("attachedInfo");
            }
            if (attachedInfo != null) {
                originAppKey = attachedInfo.optString("originAppkey");
                originPkgType = attachedInfo.optString("originPkgType");
                originAppTye = attachedInfo.optString("originAppType");
                originFrom = attachedInfo.optString("originFrom");
            }
        }
        return new String[]{originAppKey, originPkgType, originAppTye, originFrom};
    }
}
