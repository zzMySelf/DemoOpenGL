package com.baidu.swan.bdtls.impl.request;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.api.module.network.RequestApi;
import com.baidu.swan.bdtls.impl.SwanBdtlsConfig;
import com.baidu.swan.bdtls.impl.SwanBdtlsConstants;
import com.baidu.swan.bdtls.impl.SwanBdtlsSessionController;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;

public class BdtlsRequestApi extends BdtlsRequest {
    private static final String BDTLS_URL = "url";
    private static final String CUSTOM_HOST = "customHost";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final int MAX_RETRY_COUNT = 3;
    private static final String PARAMS_EXT = "ext";
    private static final String TAG = "BdtlsRequestApi";
    /* access modifiers changed from: private */
    public Callback mCallback;
    private String mCancelTag;
    private String mHost;
    private String mHttpReferer;
    private JSONObject mRequestParams;
    private String mServiceId;
    private String mUrl;
    private int retryCount;

    public BdtlsRequestApi(String httpReferer, JSONObject params, String cancelTag, Callback callback) {
        this.mHttpReferer = httpReferer;
        this.mCallback = callback;
        this.mCancelTag = cancelTag;
        parseParams(params);
        method(this.mRequestParams.optString("method"));
    }

    private void parseParams(JSONObject params) {
        this.mRequestParams = params;
        this.mUrl = params.optString("url");
        JSONObject ext = this.mRequestParams.optJSONObject("ext");
        if (ext != null) {
            this.mHost = ext.optString(CUSTOM_HOST);
        }
    }

    private void retry() {
        this.retryCount++;
        request(this.mServiceId);
    }

    public void request(String serviceId) {
        this.mServiceId = serviceId;
        String requestData = "";
        JSONObject jSONObject = this.mRequestParams;
        if (jSONObject != null) {
            requestData = jSONObject.optString("data");
        }
        executeAsync(requestData);
    }

    public void request(byte[] encodeRequestData) {
        Callback callback;
        String value;
        JSONObject params = new JSONObject();
        try {
            params = new JSONObject(this.mRequestParams.toString());
            Uri uri = Uri.parse(this.mUrl);
            String path = uri.getPath();
            String query = uri.getQuery();
            StringBuilder bdtlsUrl = new StringBuilder((TextUtils.isEmpty(this.mHost) ? SwanBdtlsConstants.HANDSHAKE_URL : this.mHost + "/" + "bdtls") + "/" + this.mServiceId);
            String str = "";
            StringBuilder append = bdtlsUrl.append(TextUtils.isEmpty(path) ? str : path);
            if (!TextUtils.isEmpty(query)) {
                str = GameCenterUtils.SCHEME_SWAN_SUFFIX + query;
            }
            append.append(str);
            if (DEBUG) {
                Log.d(TAG, "bdtls url is : " + bdtlsUrl.toString());
            }
            JSONObject header = params.optJSONObject("header");
            if (this.isBdtlsRequest) {
                if (TextUtils.equals(getMethod(), "GET")) {
                    value = Base64.encodeToString(encodeRequestData, 2);
                } else {
                    value = "Bdtls";
                    params.putOpt("data", encodeRequestData);
                }
                header.put("Bdtls", value);
            }
            params.putOpt("header", header);
            params.putOpt("url", bdtlsUrl.toString());
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "Bdtls request data is invalid", e2);
            }
        }
        HttpRequest request = (HttpRequest) RequestApi.buildHttpRequest(this.mHttpReferer, params, this.mCancelTag).first;
        if (request == null && (callback = this.mCallback) != null) {
            callback.onFailure((Call) null, new IOException("request build fail, maybe your url is invalid"));
        }
        httpRequest(request);
    }

    private void httpRequest(HttpRequest request) {
        if (request != null) {
            request.executeAsync(new ResponseCallback() {
                public Object parseResponse(Response response, int i2) throws Exception {
                    BdtlsRequestApi.this.parseResult((Call) null, response);
                    return response;
                }

                public void onSuccess(Object o, int i2) {
                }

                public void onFail(Exception e2) {
                    if (SwanBdtlsConfig.DEBUG) {
                        Log.d("BDTLS", "Bdtls Request API onFailure = " + e2.getMessage());
                    }
                    if (BdtlsRequestApi.this.mCallback == null) {
                        return;
                    }
                    if (e2 instanceof IOException) {
                        BdtlsRequestApi.this.mCallback.onFailure((Call) null, (IOException) e2);
                    } else {
                        BdtlsRequestApi.this.mCallback.onFailure((Call) null, new IOException(e2));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void parseResult(Call call, Response response) throws IOException {
        Headers headers = response.headers();
        if (headers == null || !TextUtils.equals(headers.get("Bdtls"), "recovery")) {
            SwanBdtlsSessionController.getInstance().getSessionParams().resetRecoveryCount();
            if (this.isBdtlsRequest) {
                ResponseBody responseBody = response.body();
                String result = processResponseData(responseBody.bytes());
                if (SwanBdtlsConfig.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + result);
                }
                if (this.responseStatusCode == 1) {
                    Buffer appResponseBuffer = new Buffer();
                    appResponseBuffer.writeString(result, Charset.forName("utf-8"));
                    Response appResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), appResponseBuffer.size(), appResponseBuffer)).build();
                    Callback callback = this.mCallback;
                    if (callback != null) {
                        callback.onResponse(call, appResponse);
                    }
                    this.retryCount = 0;
                } else if (this.retryCount < 3) {
                    retry();
                } else {
                    this.mCallback.onFailure(call, new IOException("Url or serviceId is invalid"));
                    this.retryCount = 0;
                }
            } else {
                Callback callback2 = this.mCallback;
                if (callback2 != null) {
                    callback2.onResponse(call, response);
                }
            }
        } else {
            SwanBdtlsSessionController.getInstance().getSessionParams().setSessionStatusCode(0);
            if (SwanBdtlsSessionController.getInstance().getSessionParams().canRecovery()) {
                SwanBdtlsSessionController.getInstance().getSessionParams().addRecoveryCount();
                setBdtlsRequest(true);
                retry();
                return;
            }
            this.mCallback.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
        }
    }

    public void onRequestError(int statusCode) {
        if (SwanBdtlsConfig.DEBUG) {
            Log.d(TAG, "onRequestError=" + statusCode);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onFailure((Call) null, new IOException("request error  code : " + statusCode));
        }
    }

    public void onFail(IOException e2) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onFailure((Call) null, e2);
        }
    }
}
