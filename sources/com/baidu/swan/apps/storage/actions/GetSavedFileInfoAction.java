package com.baidu.swan.apps.storage.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.SwanAppSchemeStatusCode;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.storage.FileInfo;
import com.baidu.swan.apps.storage.StorageUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class GetSavedFileInfoAction extends SwanAppAction {
    public static final String ACTION_TYPE = "/swanAPI/file/getSavedFileInfo";
    private static final String KEY_CREATE_TIME = "createTime";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String KEY_SIZE = "size";
    private static final String MODULE_TAG = "getSavedFile";

    public GetSavedFileInfoAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        UnitedSchemeEntity unitedSchemeEntity = entity;
        CallbackHandler callbackHandler = handler;
        if (context == null || callbackHandler == null || swanApp == null || swanApp.getStorage() == null) {
            SwanAppLog.e(MODULE_TAG, "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject params = UnitedSchemeUtility.optParamsAsJo(entity);
        if (params == null) {
            SwanAppLog.e(MODULE_TAG, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String filePath = StorageUtil.scheme2Path(params.optString("filePath"), SwanApp.getSwanAppId());
        if (DEBUG) {
            Log.d("GetSavedFileInfoAction", "——> handle: fileUrl " + params.optString("filePath"));
            Log.d("GetSavedFileInfoAction", "——> handle: filePath " + filePath);
        }
        if (TextUtils.isEmpty(filePath)) {
            SwanAppLog.e(MODULE_TAG, "file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        FileInfo fileInfo = swanApp.getStorage().getSavedFileInfo(filePath);
        if (fileInfo == null) {
            SwanAppLog.e(MODULE_TAG, "file info is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, SwanAppSchemeStatusCode.getErrMessage(2001)));
            if (DEBUG) {
                Log.d("GetSavedFileInfoAction", "——> handle: file not exist");
            }
            return false;
        }
        JSONObject joData = new JSONObject();
        try {
            joData.put("createTime", (long) Math.round((float) (fileInfo.getCreatedTime() / 1000)));
            joData.put("size", fileInfo.getSize());
            if (DEBUG) {
                Log.d("GetSavedFileInfoAction", "——> handle: fileInfo (" + joData.get("createTime") + " , " + joData.get("size") + ")");
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(joData, 0));
            return true;
        } catch (JSONException e2) {
            SwanAppLog.w(MODULE_TAG, "file info to json fail");
            e2.printStackTrace();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, SwanAppSchemeStatusCode.getErrMessage(2003)));
            if (DEBUG) {
                Log.d("GetSavedFileInfoAction", "——> handle: jsonException ");
            }
            return false;
        }
    }
}
