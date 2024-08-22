package com.baidu.searchbox.libsimcard.service;

import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.libsimcard.model.ExtraInfo;
import com.baidu.searchbox.libsimcard.model.SimCardData;
import com.baidu.searchbox.libsimcard.model.SimCardNetResult;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import okhttp3.Response;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class SimCardNetService {
    private static final String BDBOX_CONST = "bdbox";
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String DEFAULT_IP = "127.0.0.1";
    private static final String KEY_DATA = "data";
    private static final String KEY_DATASET = "dataset";
    private static final String KEY_ERRNO = "errno";
    private static final String KEY_PUBLICSRV = "publicsrv";
    private static final String KEY_SIMCARD = "simcard";
    private static final String PARAM_DATA = "data";
    private static final String PARAM_LOCALIP = "localip";
    private static final String PARAM_UNIKEY = "unikey";
    private static final String SERVICE_CONST = "service";
    private static final String SIMCARD_CONST = "simcard";
    private static final String SUCCESS_ERRNO = "0";
    private static final String TAG = SimCardNetService.class.getSimpleName();
    private static final String TYPE_CONST = "type";
    private static final String UNIKEY_VALUEHEADER = "010013";
    private static final String URL_PRE = "%s/searchbox?action=publicsrv";

    public SimCardNetResult querySimCard(Map<String, String> extraParams) {
        String unikeyValue = "010013" + random26();
        String url = UrlUtil.addParam(BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).appendParam(UrlUtil.addParam(String.format(URL_PRE, new Object[]{HostConfig.getSearchboxHostForHttps()}), "type", "simcard"), 1), PARAM_UNIKEY, unikeyValue);
        Map<String, String> postParams = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        String localip = "127.0.0.1";
        try {
            localip = getLocalIp();
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, e2.getMessage(), e2);
            }
        }
        try {
            jsonObject.put(PARAM_UNIKEY, unikeyValue);
            jsonObject.put(PARAM_LOCALIP, localip);
            if (extraParams != null) {
                for (Map.Entry<String, String> entry : extraParams.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e3) {
            if (DEBUG) {
                Log.e(TAG, e3.getMessage(), e3);
            }
        }
        postParams.put("data", jsonObject.toString());
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, postParams.toString());
        }
        Response response = null;
        try {
            response = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(url)).params(postParams)).build().executeSync();
            if (z) {
                Log.d(TAG, "发送鉴权请求,url=" + url);
            }
            if (response.isSuccessful()) {
                String resultString = response.body().string();
                if (z) {
                    Log.d(TAG, "simcard net response:" + resultString);
                }
                SimCardData simcard = parseServerData(resultString);
                SimCardNetResult simCardNetResult = new SimCardNetResult();
                if (simcard == null) {
                    simCardNetResult.setSuccess(false);
                    simCardNetResult.setExtraInfo(new ExtraInfo(localip));
                } else {
                    simCardNetResult.setSuccess(true);
                    simCardNetResult.setCorrectResult(simcard);
                    simCardNetResult.setExtraInfo(new ExtraInfo(localip));
                }
                if (response != null) {
                    response.body().close();
                }
                return simCardNetResult;
            }
            SimCardNetResult constructErrorResult = constructErrorResult(localip);
            if (response != null) {
                response.body().close();
            }
            return constructErrorResult;
        } catch (Exception e4) {
            if (DEBUG) {
                Log.e(TAG, e4.getMessage(), e4);
            }
            SimCardNetResult constructErrorResult2 = constructErrorResult(localip);
            if (response != null) {
                response.body().close();
            }
            return constructErrorResult2;
        } catch (Throwable th2) {
            if (response != null) {
                response.body().close();
            }
            throw th2;
        }
    }

    private SimCardNetResult constructErrorResult(String localip) {
        SimCardNetResult simCardNetResult = new SimCardNetResult();
        simCardNetResult.setSuccess(false);
        simCardNetResult.setExtraInfo(new ExtraInfo(localip));
        return simCardNetResult;
    }

    private SimCardData parseServerData(String serverResult) {
        JSONObject dataJson;
        JSONObject publicsrvJson;
        JSONObject simcardJson;
        JSONObject datasetJson;
        if (!TextUtils.isEmpty(serverResult)) {
            try {
                JSONObject resultJson = new JSONObject(serverResult);
                if (!"0".equals(resultJson.optString("errno")) || (dataJson = resultJson.optJSONObject("data")) == null || (publicsrvJson = dataJson.optJSONObject("publicsrv")) == null || (simcardJson = publicsrvJson.optJSONObject("simcard")) == null || (datasetJson = simcardJson.optJSONObject("dataset")) == null) {
                    return null;
                }
                return SimCardData.parseFromServer(datasetJson);
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.e(TAG, e2.getMessage(), e2);
                }
            }
        }
        return null;
    }

    private String random26() {
        String cuidMD5 = MD5Utils.toMd5((BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getUid() + UUID.randomUUID().toString()).getBytes(), false);
        int len = cuidMD5.length();
        String last20 = cuidMD5.substring(len - 20, len);
        String newStr = Integer.toHexString(Integer.parseInt(cuidMD5.substring(0, 6), 16) ^ Integer.parseInt(cuidMD5.substring(6, 12), 16));
        int newlen = newStr.length();
        if (newlen > 6) {
            newStr = newStr.substring(0, 6);
        } else if (newlen < 6) {
            for (int i2 = 0; i2 < 6 - newlen; i2++) {
                newStr = "0" + newStr;
            }
        }
        return newStr + last20;
    }

    public String getLocalIp() {
        String ipInfo = null;
        try {
            Enumeration<NetworkInterface> faces = NetworkInterface.getNetworkInterfaces();
            loop0:
            while (true) {
                if (!faces.hasMoreElements()) {
                    break;
                }
                Enumeration<InetAddress> addresses = faces.nextElement().getInetAddresses();
                while (true) {
                    if (addresses.hasMoreElements()) {
                        InetAddress inetAddress = addresses.nextElement();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            ipInfo = inetAddress.getHostAddress().toString();
                            break loop0;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "getIpInfo fail!" + e2.toString());
            }
        }
        if (TextUtils.isEmpty(ipInfo)) {
            return "127.0.0.1";
        }
        return ipInfo;
    }
}
