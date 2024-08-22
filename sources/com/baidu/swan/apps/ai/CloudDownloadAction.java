package com.baidu.swan.apps.ai;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.network.BaseRequestAction;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.DownloadFileAction;
import com.baidu.swan.network.config.SwanNetworkConfig;
import com.baidu.swan.network.manager.SwanHttpManager;
import com.baidu.swan.utils.SwanAppFileUtils;
import com.baidu.swan.utils.SwanAppStreamUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudDownloadAction extends BaseCloudAction {
    private static final String ACTION_TYPE = "/swanAPI/cloudDownloadFile";
    private static final String ERR_MSG_DOWNLOAD_FAIL = "downloadFile:fail";
    private static final String ERR_MSG_DOWNLOAD_SUCCESS = "downloadFile:ok";
    private static final String MIME_TYPE_APPLICATION_JSON = "application/json";
    private static final String TAG = "CloudDownloadAction";

    public CloudDownloadAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        return super.handle(context, entity, handler, swanApp);
    }

    /* access modifiers changed from: protected */
    public void onCloudResponse(Response response, CallbackHandler handler, String cb) {
        if (!response.isSuccessful()) {
            onFail(handler, cb, 1001, ERR_MSG_DOWNLOAD_FAIL);
            return;
        }
        JSONObject responseBody = AiRequestUtils.getResponseObject(response);
        if (responseBody == null || !response.isSuccessful()) {
            onFail(handler, cb, 1001, ERR_MSG_DOWNLOAD_FAIL);
            return;
        }
        if (DEBUG) {
            SwanAppLog.d(TAG, "response body: " + responseBody);
        }
        String errNo = responseBody.optString("errno", String.valueOf(0));
        String errMsg = responseBody.optString("errmsg");
        if (AiRequestUtils.isRequestFail(errNo)) {
            onDownloadFail(handler, cb, errNo, errMsg);
            return;
        }
        String downloadUrl = responseBody.optString("DownloadUrl");
        if (TextUtils.isEmpty(downloadUrl)) {
            onDownloadFail(handler, cb, errNo, errMsg);
        } else {
            downloadFile(downloadUrl, handler, cb);
        }
    }

    public void downloadFile(String url, CallbackHandler handler, String cb) {
        if (SwanApp.get() == null) {
            onDownloadFail(handler, cb, (String) null, (String) null);
        } else {
            httpRequest(url, cb, handler);
        }
    }

    private void httpRequest(final String url, final String cb, final CallbackHandler handler) {
        SwanNetworkConfig config = new SwanNetworkConfig(url, new ResponseCallback() {
            public Object parseResponse(Response response, int i2) {
                CloudDownloadAction.this.parseResult(response, url, cb, handler);
                return response;
            }

            public void onSuccess(Object o, int i2) {
            }

            public void onFail(Exception e2) {
                CloudDownloadAction.this.onDownloadFail(handler, cb, (String) null, CloudDownloadAction.ERR_MSG_DOWNLOAD_FAIL + e2.getMessage());
            }
        });
        config.isAddUa = true;
        config.isAddCookie = false;
        config.setTimeout = true;
        SwanHttpManager.getDefault().execGetRequest(config);
    }

    /* access modifiers changed from: private */
    public void parseResult(Response response, String url, String cb, CallbackHandler handler) {
        if (!response.isSuccessful()) {
            onDownloadFail(handler, cb, (String) null, ERR_MSG_DOWNLOAD_FAIL);
            return;
        }
        String realPath = null;
        try {
            realPath = DownloadFileAction.getTmpFileRealPath(BaseRequestAction.toJo(response.headers()), SwanAppFileUtils.getFileSuffixFromPath(url));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(realPath)) {
            onDownloadFail(handler, cb, (String) null, (String) null);
            return;
        }
        String path = SwanAppController.getInstance().getSwanFilePaths().realPathToScheme(realPath);
        if (TextUtils.isEmpty(path)) {
            onDownloadFail(handler, cb, (String) null, (String) null);
        } else if (saveFile(response, realPath)) {
            onSuccess(handler, cb, AiRequestUtils.getSuccessMsg((String) null, path, ERR_MSG_DOWNLOAD_SUCCESS));
        } else {
            onDownloadFail(handler, cb, (String) null, (String) null);
        }
    }

    public boolean saveFile(Response response, String realFilePath) {
        InputStream inputStream = null;
        if (response.body() != null) {
            inputStream = response.body().byteStream();
        }
        File saveFile = new File(realFilePath);
        if (saveFile.exists()) {
            saveFile.delete();
            try {
                saveFile.createNewFile();
            } catch (IOException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return SwanAppStreamUtils.streamToFile(inputStream, saveFile);
    }

    /* access modifiers changed from: private */
    public void onDownloadFail(CallbackHandler handler, String cb, String errNo, String errMsg) {
        if (TextUtils.isEmpty(errNo)) {
            onFail(handler, cb, 1001, ERR_MSG_DOWNLOAD_FAIL);
        } else {
            onFail(handler, cb, 1001, AiRequestUtils.getErrorMsg(errMsg));
        }
    }
}
