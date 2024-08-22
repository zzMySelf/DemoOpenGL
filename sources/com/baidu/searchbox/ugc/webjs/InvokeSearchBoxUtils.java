package com.baidu.searchbox.ugc.webjs;

import android.content.Context;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.DuMixController;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import java.util.Set;
import okhttp3.Response;
import org.apache.commons.codec.digest4util.EncryptUtils;

public class InvokeSearchBoxUtils {
    private static final int APP_ID_QUANMIN = 0;
    private static final int APP_ID_SEARCHBOX = 6;
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final int HTTP_STATUS_CODE_OK = 200;
    private static final String PARAM_APP_ID = "app_id";
    private static final String PARAM_PLATFORM = "platform";
    private static final String PARAM_SDK_VERSION = "sdk_version";
    private static final String PARAM_UH = "uh";
    private static final String PARAM_UT = "ut";
    private static final String SIGN_SECRET = "BAIDU_SHOUBAI_PUBLISH_VIDEO";
    private static final String TAG = InvokeSearchBoxUtils.class.getSimpleName();

    public static String invokeNetworkRequest(String url, String data, boolean isPost, boolean isCaptureFilter) {
        HttpRequestBuilder builder;
        String finalUrl = UgcServerApiUtils.processCommonParams(url);
        if (DEBUG) {
            String str = TAG;
            Log.d(str, "url = " + url);
            Log.d(str, "data = " + data);
        }
        if (isCaptureFilter) {
            if (!UgcRuntime.getUgcInterface().isPrivacySwitchOpen()) {
                finalUrl = replaceQueryParam(replaceQueryParam(finalUrl, "ut", getUTParam()), PARAM_UH, getUHParam());
            }
            finalUrl = replaceQueryParam(replaceQueryParam(replaceQueryParam(finalUrl, "sdk_version", Integer.valueOf(DuMixController.getVersionCode())), "app_id", 6), "platform", 1);
        }
        String responseStr = null;
        try {
            HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
            if (isCaptureFilter) {
                builder = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) httpManager.postFormRequest().addParam("data", data)).addParam("sign", getSign(data, SIGN_SECRET))).requestFrom(20)).requestSubFrom(3)).enableStat(true);
            } else {
                builder = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) httpManager.postFormRequest().addParam("data", data)).requestSubFrom(3)).enableStat(true);
            }
            Response response = builder.url(finalUrl).cookieManager((CookieManager) UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false)).build().executeSync();
            if (!(response == null || response.code() != 200 || response.body() == null)) {
                responseStr = response.body().string();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (DEBUG) {
            Log.d(TAG, url + "\n  responseStr = " + responseStr);
        }
        return responseStr;
    }

    public static String getSign(String data, String secret) {
        return EncryptUtils.encrypt("MD5", (data + secret).getBytes(), false);
    }

    private static String getUTParam() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MODEL).append("_").append(Build.VERSION.RELEASE).append("_").append(Build.VERSION.SDK_INT).append("_").append(Build.BRAND.replace("_", ""));
        return stringBuilder.toString();
    }

    private static String getUHParam() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER).append(",").append(Build.HARDWARE).append(",").append(Build.BOARD).append(",").append(supportGyroscope());
        return stringBuilder.toString();
    }

    public static int supportGyroscope() {
        Context context = AppRuntime.getAppContext();
        if (context == null) {
            return 0;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        if ((sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true) {
            return 1;
        }
        return 0;
    }

    public static String replaceQueryParam(String uri, String key, Object valueObj) {
        if (TextUtils.isEmpty(uri) || TextUtils.isEmpty(key) || valueObj == null) {
            return uri;
        }
        String value = String.valueOf(valueObj);
        Uri originUri = Uri.parse(uri);
        if (TextUtils.isEmpty(originUri.getQueryParameter(key))) {
            return originUri.buildUpon().appendQueryParameter(key, value).build().toString();
        }
        Set<String> queryNames = originUri.getQueryParameterNames();
        Uri.Builder newUriBuilder = originUri.buildUpon().clearQuery();
        for (String name : queryNames) {
            if (TextUtils.equals(name, key)) {
                newUriBuilder.appendQueryParameter(name, value);
            } else {
                newUriBuilder.appendQueryParameter(name, originUri.getQueryParameter(name));
            }
        }
        return newUriBuilder.build().toString();
    }
}
