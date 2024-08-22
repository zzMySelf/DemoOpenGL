package com.baidu.swan.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppDocument;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.network.NetworkDef;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.util.SwanAppDocumentUtil;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.File;
import org.json.JSONObject;

public class OpenDocumentAction extends SwanAppAction implements NetworkDef {
    public static final String ACTION_TYPE = "/swanAPI/file/openDocument";
    public static final String MESSAGE_DOWNLOAD_PLUGIN_FAIL = "download plugin fail";
    public static final String MESSAGE_DOWNLOAD_PLUGIN_SUCCESS = "download plugin success";
    public static final String MESSAGE_ILLEGAL_ACTIVITY = "illegal activity == null";
    public static final String MESSAGE_ILLEGAL_APPID = "illegal appId";
    public static final String MESSAGE_ILLEGAL_FILEPATH = "illegal filePath";
    public static final String MESSAGE_ILLEGAL_FILE_EXT = "illegal file ext";
    public static final String MESSAGE_ILLEGAL_FILE_MIMETYPE = "illegal file mimeType";
    public static final String MESSAGE_ILLEGAL_PARAMS = "illegal params";
    public static final String MESSAGE_ILLEGAL_REALFILEPATH = "illegal realFilePath";
    public static final String MESSAGE_ILLEGAL_SWAN_APP = "swanApp is null";
    public static final String MESSAGE_ILLEGAL_URI_PATH = "illegal Uri path";
    public static final String MESSAGE_NOT_FOUND_PLUGIN = "not found plugin,mimeType=";
    public static final String MESSAGE_NOT_SUPPORT_MIMETYPE = "not support this mimeType=";
    public static final String PACKAGE_NAME = "packageName";
    public static final String PARAMS_FILEPATH = "filePath";
    public static final String PARAMS_FILETYPE = "fileType";
    public static final String RESULT = "result";
    private static final String TOAST_MAKE_TIPS = "功能更新，请重启百度APP后使用";
    int RESULT_CODE_NEED_RESTART = 3;
    int RESULT_CODE_SUCCESS = 1;

    public interface PluginDownloadCallBack {
        void downloadFail();

        void downloadSuccess(int i2);
    }

    public OpenDocumentAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        String fileExt;
        Uri path;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        CallbackHandler callbackHandler = handler;
        if (swanApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else if (swanApp.isAppInvisible()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject joParams = getParamAsJo(unitedSchemeEntity, "params");
            if (joParams == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String filePath = joParams.optString("filePath");
            if (TextUtils.isEmpty(filePath)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_FILEPATH);
                return false;
            }
            String appId = SwanApp.getSwanAppId();
            if (TextUtils.isEmpty(appId)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String realFilePath = StorageUtil.scheme2Path(filePath, appId);
            if (TextUtils.isEmpty(realFilePath)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_REALFILEPATH);
                return false;
            }
            String fileType = joParams.optString("fileType");
            String fileExt2 = SwanAppFileUtils.getFileSuffixFromPath(realFilePath);
            if (!TextUtils.isEmpty(fileExt2)) {
                fileExt = fileExt2;
            } else if (!TextUtils.isEmpty(fileType)) {
                fileExt = fileType;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_FILE_EXT);
                return false;
            }
            String mimeType = SwanAppDocumentUtil.guessSupportMimeTypeFromExt(fileExt);
            if (TextUtils.isEmpty(mimeType)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_FILE_MIMETYPE);
                return false;
            }
            Uri path2 = Uri.parse(realFilePath);
            if (path2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_URI_PATH);
                return false;
            }
            if (path2.getScheme() == null) {
                path = Uri.fromFile(new File(realFilePath));
            } else {
                path = path2;
            }
            Activity activity = Swan.get().getActivity();
            if (activity == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_ACTIVITY);
                return false;
            } else if (!SwanAppDocumentUtil.getSupportMimeType(mimeType)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, MESSAGE_NOT_SUPPORT_MIMETYPE + mimeType);
                return false;
            } else {
                String cb = joParams.optString("cb");
                ISwanAppDocument swanAppDocument = SwanAppRuntime.getDocumentRuntime();
                if (swanAppDocument.isReadPluginAvailable(activity, mimeType)) {
                    swanAppDocument.open(activity, path, mimeType);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    callbackHandler.handleSchemeDispatchCallback(cb, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return true;
                } else if (TextUtils.isEmpty(cb)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, MESSAGE_NOT_FOUND_PLUGIN + mimeType);
                    return false;
                } else {
                    ISwanAppDocument iSwanAppDocument = swanAppDocument;
                    Activity activity2 = activity;
                    Uri uri = path;
                    downloadPlugin(activity, mimeType, path, cb, handler);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
            }
        }
    }

    private void downloadPlugin(Activity activity, String mimeType, Uri path, String cb, CallbackHandler handler) {
        final Activity activity2 = activity;
        final Uri uri = path;
        final String str = mimeType;
        final CallbackHandler callbackHandler = handler;
        final String str2 = cb;
        SwanAppRuntime.getDocumentRuntime().downloadPlugin(activity, mimeType, new PluginDownloadCallBack() {
            public void downloadSuccess(int resultCode) {
                SwanAppRuntime.getDocumentRuntime().open(activity2, uri, str);
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(0, OpenDocumentAction.MESSAGE_DOWNLOAD_PLUGIN_SUCCESS).toString());
            }

            public void downloadFail() {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, OpenDocumentAction.MESSAGE_DOWNLOAD_PLUGIN_FAIL).toString());
            }
        });
    }
}
