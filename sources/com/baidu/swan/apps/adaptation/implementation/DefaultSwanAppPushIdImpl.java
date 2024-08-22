package com.baidu.swan.apps.adaptation.implementation;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.paywall.UnitedSchemePaywallDispatcher;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppPushId;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.swan.apps.config.DefaultAntiReplayToken;
import com.baidu.swan.apps.config.URLConfig;
import com.baidu.swan.apps.form.SwanAppFormIdCallback;
import com.baidu.swan.apps.form.TemplateInfo;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.network.NetworkDef;
import com.baidu.swan.apps.pay.callback.SwanAppPayIdCallback;
import com.baidu.swan.apps.push.SwanAppPushIdCallback;
import com.baidu.swan.network.SwanNetworkRuntime;
import com.baidu.swan.network.config.SwanNetworkConfig;
import com.baidu.swan.network.manager.SwanHttpManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DefaultSwanAppPushIdImpl implements ISwanAppPushId {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static int FORM_ID_TYPE = 0;
    private static final String JSON_KEY_DATA = "data";
    private static final String JSON_KEY_ERRNO = "errno";
    private static final String JSON_KEY_LIST = "list";
    private static final String JSON_KEY_TEMPLATE_ID = "template_id";
    private static final String JSON_KEY_TEMPLATE_TITLE = "template_title";
    private static final String JSON_KEY_TIP = "tip";
    private static final String JSON_KEY_TIP_MSG = "tipmsg";
    private static int MSG_FORM_ID_TYPE = 2;
    private static final String PARAM_APPKEY = "appkey";
    private static final String PARAM_APP_KEY = "app_key";
    private static final String PARAM_DELTA = "delta";
    private static final String PARAM_DETAIL = "detail";
    private static final String PARAM_RASIGN = "rasign";
    private static final String PARAM_SUBSCRIBE_ID = "sub_id";
    private static final String PARAM_TEMPLATE_ID = "template_id";
    private static final String PARAM_TEMPLATE_IDS = "template_ids";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PARAM_UNIQUE_ID = "uniq_id";
    private static int PAY_ID_TYPE = 1;
    private static final String PAY_VALUE_DELTA = "payid";
    private static final int REQUEST_SUCCESS = 0;
    private static final String SYMBOL_CONNECTOR = "&";
    private static final String TAG = "SwanAppPushIdImpl";
    private static final String VALUE_DELTA = "smartapp_formid";

    public void getMsgTpl(String appKey, Set<String> templateIds, final SubscribeHelper.GetMsgTplCallback callback) {
        JSONObject body = new JSONObject();
        try {
            body.put("app_key", appKey);
            JSONArray templateIdArr = new JSONArray();
            if (templateIds != null && templateIds.size() > 0) {
                for (String template : templateIds) {
                    templateIdArr.put(template);
                }
            }
            body.put(PARAM_TEMPLATE_IDS, templateIdArr);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        SwanNetworkConfig networkConfig = new SwanNetworkConfig(getSwanAppMsgTpl(), new SimpleResponseCallback(new SwanAppPushIdCallback() {
            public void onSuccess(JSONObject jsonObject) {
                String errorMsg = null;
                if (jsonObject != null) {
                    if (jsonObject.optInt("errno") == 0) {
                        JSONObject dataJson = jsonObject.optJSONObject("data");
                        if (dataJson != null) {
                            callback.onMsgTpl(dataJson.optString("tip"), DefaultSwanAppPushIdImpl.this.convertToList(dataJson.optJSONArray("list")), false);
                            return;
                        }
                    } else {
                        errorMsg = jsonObject.optString("tipmsg");
                    }
                }
                callback.onMsgTpl(errorMsg, (List<TemplateInfo>) null, false);
            }

            public void onFail(String msg) {
                callback.onMsgTpl(msg, (List<TemplateInfo>) null, false);
            }
        })).createRequestBody(NetworkDef.ContentType.JSON, body.toString());
        if (SwanHttpManager.getDefault().enableFrameworkUa()) {
            networkConfig.isAddUa = true;
        }
        networkConfig.isAddCookie = true;
        SwanHttpManager.getDefault().execPostRequest(networkConfig);
    }

    /* access modifiers changed from: private */
    public List<TemplateInfo> convertToList(JSONArray templateJSONArray) {
        if (templateJSONArray == null) {
            return null;
        }
        int length = templateJSONArray.length();
        int len = length;
        if (length == 0) {
            return null;
        }
        List<TemplateInfo> templateInfoList = new ArrayList<>(len);
        for (int index = 0; index < len; index++) {
            JSONObject templateJson = templateJSONArray.optJSONObject(index);
            if (templateJson != null) {
                String id = templateJson.optString("template_id");
                String title = templateJson.optString(JSON_KEY_TEMPLATE_TITLE);
                if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(title)) {
                    templateInfoList.add(new TemplateInfo(id, title));
                }
            }
        }
        return templateInfoList;
    }

    public void getFormId(String appKey, SwanAppFormIdCallback callback) {
        String requestFormIdUrl = buildUrlWithParams(FORM_ID_TYPE);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) SwanHttpManager.getDefault().postFormRequest().url(requestFormIdUrl)).cookieManager(SwanAppRuntime.getCookieRuntime().createCookieManager())).addParam("appkey", appKey)).build().executeAsyncOnUIBack(new SimpleResponseCallback(callback));
    }

    public void getMsgFormId(String appKey, List<String> templateIds, String uniqueId, boolean isFromLowerVersion, SwanAppFormIdCallback callback) {
        JSONObject body = new JSONObject();
        try {
            body.put("app_key", appKey);
            JSONObject subscribeData = new JSONObject();
            subscribeData.put(PARAM_SUBSCRIBE_ID, uniqueId);
            if (isFromLowerVersion) {
                subscribeData.put("template_id", templateIds.get(0));
            } else {
                JSONArray templateIdJsonArr = new JSONArray();
                for (String id : templateIds) {
                    templateIdJsonArr.put(id);
                }
                subscribeData.put(PARAM_TEMPLATE_IDS, templateIdJsonArr);
            }
            JSONArray detail = new JSONArray();
            detail.put(subscribeData);
            body.put("detail", detail);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        SwanNetworkConfig networkConfig = new SwanNetworkConfig(buildUrlWithParams(MSG_FORM_ID_TYPE), new SimpleResponseCallback(callback)).createRequestBody(NetworkDef.ContentType.JSON, body.toString());
        networkConfig.isAddUa = true;
        networkConfig.isAddCookie = true;
        SwanHttpManager.getDefault().execPostRequest(networkConfig);
    }

    public String getQueryOrDeleteFormIdUrl() {
        long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Uri.Builder builder = Uri.parse(getFormIdSubScribeUrl()).buildUpon();
        builder.appendQueryParameter("timestamp", String.valueOf(time)).appendQueryParameter(PARAM_RASIGN, DefaultAntiReplayToken.create().generateFormIdRasign(time)).appendQueryParameter("delta", VALUE_DELTA);
        return builder.toString();
    }

    public void getPayId(String appKey, SwanAppPayIdCallback callback) {
        requestPushId(buildUrlWithParams(PAY_ID_TYPE), appKey, callback);
    }

    private String buildUrlWithParams(int type) {
        String delta;
        String raSign;
        StringBuilder sb;
        long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        String timestamp = "timestamp=" + time;
        if (type == FORM_ID_TYPE) {
            sb = new StringBuilder(getSwanAppFormIdUrl());
            raSign = "rasign=" + DefaultAntiReplayToken.create().generateFormIdRasign(time);
            delta = "delta=smartapp_formid";
        } else if (type == MSG_FORM_ID_TYPE) {
            sb = new StringBuilder(getSwanAppMsgFormIdUrl());
            raSign = "rasign=" + DefaultAntiReplayToken.create().generateFormIdRasign(time);
            delta = "delta=smartapp_formid";
        } else {
            sb = new StringBuilder(getSwanAppPayIdUrl());
            raSign = "rasign=" + DefaultAntiReplayToken.create().generatePayIdRasign(time);
            delta = "delta=payid";
        }
        sb.append("&");
        sb.append(timestamp).append("&");
        sb.append(raSign).append("&");
        sb.append(delta);
        return URLConfig.processCommonParams(sb.toString());
    }

    private void requestPushId(String url, String appKey, SwanAppPushIdCallback callback) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) SwanHttpManager.getDefault().postFormRequest().url(url)).cookieManager(SwanAppRuntime.getCookieRuntime().createCookieManager())).userAgent(SwanNetworkRuntime.getSwanNetwork().getUserAgent())).addParam("appkey", appKey)).build().executeAsyncOnUIBack(new SimpleResponseCallback(callback));
    }

    private static class SimpleResponseCallback extends ResponseCallback<JSONObject> {
        private final SwanAppPushIdCallback mSwanAppPushIdCallback;

        SimpleResponseCallback(SwanAppPushIdCallback mSwanAppPushIdCallback2) {
            this.mSwanAppPushIdCallback = mSwanAppPushIdCallback2;
        }

        public JSONObject parseResponse(Response response, int statusCode) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            String resp = response.body().string();
            if (DefaultSwanAppPushIdImpl.DEBUG) {
                Log.d(DefaultSwanAppPushIdImpl.TAG, "statusCode:" + statusCode + ", response=" + resp);
            }
            if (!TextUtils.isEmpty(resp)) {
                return new JSONObject(resp);
            }
            return null;
        }

        public void onSuccess(JSONObject response, int statusCode) {
            SwanAppPushIdCallback swanAppPushIdCallback = this.mSwanAppPushIdCallback;
            if (swanAppPushIdCallback != null) {
                if (response == null) {
                    swanAppPushIdCallback.onFail(UnitedSchemePaywallDispatcher.ERROR_REQUEST_FAIL);
                } else {
                    swanAppPushIdCallback.onSuccess(response);
                }
            }
        }

        public void onFail(Exception exception) {
            if (DefaultSwanAppPushIdImpl.DEBUG) {
                Log.e(DefaultSwanAppPushIdImpl.TAG, "SimpleResponseCallback", exception);
            }
            SwanAppPushIdCallback swanAppPushIdCallback = this.mSwanAppPushIdCallback;
            if (swanAppPushIdCallback != null) {
                swanAppPushIdCallback.onFail(exception.toString());
            }
        }
    }

    public static String getSwanAppFormIdUrl() {
        return URLConfig.processCommonParams(String.format("%s/ma/formid/new", new Object[]{URLConfig.BAIDU_HOST}), true);
    }

    public static String getSwanAppMsgFormIdUrl() {
        return URLConfig.processCommonParams(String.format("%s/ma/component/sub/create", new Object[]{URLConfig.BAIDU_HOST}), true);
    }

    public static String getSwanAppPayIdUrl() {
        return URLConfig.processCommonParams(String.format("%s/ma/payid/new", new Object[]{URLConfig.BAIDU_HOST}), true);
    }

    public static String getSwanAppMsgTpl() {
        return URLConfig.processCommonParams(String.format("%s/ma/component/msgtpl", new Object[]{URLConfig.BAIDU_HOST}), true);
    }

    public static String getFormIdSubScribeUrl() {
        return URLConfig.processCommonParams(String.format("%s/ma/formid/multi_action", new Object[]{URLConfig.BAIDU_HOST}), true);
    }
}
