package com.baidu.swan.apps.impl.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.base.utils.UrlUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.config.URLConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.config.SwanUrlConfig;
import com.baidu.swan.apps.impl.menu.favorite.SwanAppPageFavoriteHelper;
import com.baidu.swan.apps.impl.network.AntiReplayToken;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.menu.favorite.SwanAppBosAuthorizeInfo;
import com.baidu.swan.apps.network.NetworkDef;
import com.baidu.swan.apps.storage.sp.SwanAppSpHelper;
import com.baidu.swan.apps.upload.IBosManager;
import com.baidu.swan.apps.upload.UploadBosApi;
import com.baidu.swan.apps.util.SwanAppEncryptUtils;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.network.config.SwanNetworkConfig;
import com.baidu.swan.network.manager.SwanHttpManager;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpDate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BosUtils {
    private static final String AES_ALGORITHM = "AES/CBC/PKCS7Padding";
    private static final String AES_IV = "4d3579b50ff03ad6";
    private static final String BOS_META_KEY_ENCRYPTED_AES_KEY = "eAesK";
    private static final String BOS_NAME_LIST = "oname_list";
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String DEFAULT_ENDPOINT = "https://bj.bcebos.com";
    private static final String HOST = "bj.bcebos.com";
    private static final String RESPONSE_BODY_SUB_DATA = "data";
    private static final String RESPONSE_BODY_SUB_ERROR = "error";
    private static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXfjKtQqPusapuNMCkiJeGyjpD\nYoPclgE7ONM8mF39wG7ICC4m4+LoaikFkHW6gC9qrO2BqR98mw8TTdcWyy4mfn0n\nJUqhUTLzjr4VhzP2FN61ZDRrjXiay6G5hvOfiEo3wrnBjMLzT6vUqRvKE3sJHnjs\nR6oIvLWOEMSpWnyifwIDAQAB\n";
    private static final String SP_KEY_SERVER_TIME_DELTA_COMMENT = "server_time_delta_comment";
    private static final String SP_KEY_SERVER_TIME_DELTA_EXCEPTION = "server_time_delta_exception";
    public static final String TAG = "BosUtils";

    public static void checkAuthorizeForBos(Context context, String realFileName, IBosManager.OnCheckBosAuthorizeResultListener listener) {
        Context context2 = context;
        String str = realFileName;
        final IBosManager.OnCheckBosAuthorizeResultListener onCheckBosAuthorizeResultListener = listener;
        if (context2 == null || TextUtils.isEmpty(realFileName)) {
            onCheckBosAuthorizeResultListener.finish((JSONObject) null, (String) null);
            return;
        }
        final String uploadFileName = buildUploadFileName(context2, SwanAppPageFavoriteHelper.getBitmapLocalFilePath(context), str.substring(str.lastIndexOf(".")));
        String baseUrl = SwanUrlConfig.getCommentBosServiceUrl();
        if (DEBUG) {
            Log.d(TAG, String.format("checkAuthorizeForBos: isUploadToSpecifiedBucket=%s uploadFileName=%s", new Object[]{false, uploadFileName}));
        }
        for (Map.Entry<String, String> entry : new AntiReplayToken(getServerTimeDelta(SP_KEY_SERVER_TIME_DELTA_COMMENT)).queryMap.entrySet()) {
            baseUrl = UrlUtils.addParam(baseUrl, entry.getKey(), entry.getValue());
        }
        String url = URLConfig.processCommonParams(baseUrl, true);
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        RequestBody body = createRequestBody(uploadFileName);
        if (body == null) {
            onCheckBosAuthorizeResultListener.finish((JSONObject) null, (String) null);
            return;
        }
        SwanNetworkConfig config = new SwanNetworkConfig(url, body, new ResponseCallback<JSONObject>(SP_KEY_SERVER_TIME_DELTA_COMMENT) {
            public JSONObject parseResponse(Response response, int statusCode) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                String str = response.body().string();
                BosUtils.updateServerTimeDelta(response, System.currentTimeMillis(), BosUtils.SP_KEY_SERVER_TIME_DELTA_COMMENT);
                return new JSONObject(str);
            }

            public void onSuccess(JSONObject response, int statusCode) {
                IBosManager.OnCheckBosAuthorizeResultListener onCheckBosAuthorizeResultListener = onCheckBosAuthorizeResultListener;
                if (onCheckBosAuthorizeResultListener != null) {
                    onCheckBosAuthorizeResultListener.finish(response, uploadFileName);
                }
            }

            public void onFail(Exception exception) {
                IBosManager.OnCheckBosAuthorizeResultListener onCheckBosAuthorizeResultListener = onCheckBosAuthorizeResultListener;
                if (onCheckBosAuthorizeResultListener != null) {
                    onCheckBosAuthorizeResultListener.finish((JSONObject) null, (String) null);
                }
            }
        });
        config.isAddUa = SwanHttpManager.getDefault().enableFrameworkUa();
        config.isAddCookie = false;
        config.headers = headersMap;
        SwanHttpManager.getDefault().execPostRequest(config);
    }

    public static void checkAuthorizeForBos(Context context, String realFileName, boolean isUploadSpecifiedBucket, JSONObject paramsJo, IBosManager.OnCheckBosAuthorizeResultListener listener) {
        if (isUploadSpecifiedBucket) {
            if (TextUtils.isEmpty(paramsJo.optString(UploadBosApi.PARAM_ENDPOINT))) {
                SwanAppJSONUtils.setValue(paramsJo, UploadBosApi.PARAM_ENDPOINT, DEFAULT_ENDPOINT);
            }
            JSONObject bodyData = new JSONObject();
            SwanAppJSONUtils.setValue(bodyData, "data", paramsJo);
            SwanAppJSONUtils.setValue(bodyData, "error", "0");
            String uploadFileName = paramsJo.optString("fileName", "");
            JSONObject responseBody = new JSONObject();
            SwanAppJSONUtils.setValue(responseBody, "data", bodyData);
            SwanAppJSONUtils.setValue(responseBody, "errno", "0");
            listener.finish(responseBody, uploadFileName);
            return;
        }
        checkAuthorizeForBos(context, realFileName, listener);
    }

    public static void checkAuth(final String picKey, final IBosManager.OnCheckBosAuthorizeResultListener listener) {
        String baseUrl = URLConfig.appendLaunchId(SwanAppRuntime.getConfigRuntime().getExceptionUploadBosAuthUrl());
        for (Map.Entry<String, String> entry : new AntiReplayToken(getServerTimeDelta(SP_KEY_SERVER_TIME_DELTA_EXCEPTION)).queryMap.entrySet()) {
            baseUrl = UrlUtils.addParam(baseUrl, entry.getKey(), entry.getValue());
        }
        String url = CommonUrlParamManager.getInstance().processUrl(baseUrl);
        RequestBody body = createRequestBody(picKey);
        if (body == null) {
            listener.finish((JSONObject) null, (String) null);
            return;
        }
        SwanNetworkConfig config = new SwanNetworkConfig(url, body, new ResponseCallback<JSONObject>() {
            public JSONObject parseResponse(Response response, int statusCode) throws Exception {
                SwanAppLog.logToFile(BosUtils.TAG, "#checkAuth #parseResponse statusCode=" + statusCode + " response=" + response);
                if (response == null || response.body() == null) {
                    return null;
                }
                String str = response.body().string();
                BosUtils.updateServerTimeDelta(response, System.currentTimeMillis(), BosUtils.SP_KEY_SERVER_TIME_DELTA_EXCEPTION);
                return new JSONObject(str);
            }

            public void onSuccess(JSONObject response, int statusCode) {
                IBosManager.OnCheckBosAuthorizeResultListener onCheckBosAuthorizeResultListener = IBosManager.OnCheckBosAuthorizeResultListener.this;
                if (onCheckBosAuthorizeResultListener != null) {
                    onCheckBosAuthorizeResultListener.finish(response, picKey);
                }
            }

            public void onFail(Exception exception) {
                SwanAppLog.logToFile(BosUtils.TAG, "#checkAuth #onFail", exception);
                IBosManager.OnCheckBosAuthorizeResultListener onCheckBosAuthorizeResultListener = IBosManager.OnCheckBosAuthorizeResultListener.this;
                if (onCheckBosAuthorizeResultListener != null) {
                    onCheckBosAuthorizeResultListener.finish((JSONObject) null, (String) null);
                }
            }
        });
        config.isAddUa = SwanHttpManager.getDefault().enableFrameworkUa();
        config.headers = Collections.singletonMap("Content-Type", "application/json");
        SwanHttpManager.getDefault().execPostRequest(config);
    }

    private static RequestBody createRequestBody(String bosFileName) {
        try {
            JSONArray picList = new JSONArray();
            picList.put(bosFileName);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(BOS_NAME_LIST, picList);
            return RequestBody.create(NetworkDef.ContentType.JSON, jsonObject.toString());
        } catch (JSONException e2) {
            if (!DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean uploadToBos(byte[] content, SwanAppBosAuthorizeInfo info, boolean isEncrypt) {
        PutObjectResponse response;
        if (content == null || info == null || content.length == 0) {
            SwanAppLog.logToFile(TAG, "#uploadToBos [check args fail]");
            return false;
        } else if (TextUtils.isEmpty(info.ak) || TextUtils.isEmpty(info.sk) || TextUtils.isEmpty(info.token) || TextUtils.isEmpty(info.bosObject)) {
            SwanAppLog.logToFile(TAG, "#uploadToBos [check info fail]");
            return false;
        } else {
            try {
                BosClientConfiguration bosConfig = new BosClientConfiguration();
                bosConfig.setCredentials(new DefaultBceSessionCredentials(info.ak, info.sk, info.token));
                bosConfig.setEndpoint(HOST);
                BosClient bosClient = new BosClient(bosConfig);
                PutObjectRequest request = createPutObjectRequest(info, content, isEncrypt);
                if (!(request == null || (response = bosClient.putObject(request)) == null || TextUtils.isEmpty(response.getETag()))) {
                    SwanAppLog.logToFile(TAG, "#uploadToBos [upload success]");
                    return true;
                }
            } catch (Exception e2) {
                SwanAppLog.logToFile(TAG, "#uploadToBos [error]", e2);
            }
            return false;
        }
    }

    private static PutObjectRequest createPutObjectRequest(SwanAppBosAuthorizeInfo info, byte[] content, boolean isEncrypt) {
        if (!isEncrypt) {
            return new PutObjectRequest(info.bucket, info.bosObject, (InputStream) new ByteArrayInputStream(content));
        }
        byte[] randomAesKey = SwanAppEncryptUtils.genRandomAesKey();
        byte[] decryptContent = SwanAppEncryptUtils.aesEncrypt(randomAesKey, content, "AES/CBC/PKCS7Padding", AES_IV);
        if (decryptContent == null) {
            SwanAppLog.logToFile(TAG, "#createPutObjectRequest aesEncrypt fail");
            return null;
        }
        String base64EncryptedAesKey = SwanAppEncryptUtils.rsaEncrypt(RSA_PUBLIC_KEY, randomAesKey);
        if (TextUtils.isEmpty(base64EncryptedAesKey)) {
            SwanAppLog.logToFile(TAG, "#createPutObjectRequest rsaEncrypt fail");
            return null;
        }
        PutObjectRequest request = new PutObjectRequest(info.bucket, info.bosObject, (InputStream) new ByteArrayInputStream(decryptContent));
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.addUserMetadata(BOS_META_KEY_ENCRYPTED_AES_KEY, base64EncryptedAesKey);
        request.setObjectMetadata(metadata);
        return request;
    }

    public static boolean uploadBosFile(String filePath, SwanAppBosAuthorizeInfo info, String contentType) {
        if (TextUtils.isEmpty(filePath) || info == null || TextUtils.isEmpty(info.ak) || TextUtils.isEmpty(info.sk) || TextUtils.isEmpty(info.token) || TextUtils.isEmpty(info.bosObject)) {
            return false;
        }
        if (TextUtils.isEmpty(contentType)) {
            contentType = "application/octet-stream";
        }
        try {
            BosClientConfiguration bosConfig = new BosClientConfiguration();
            bosConfig.setCredentials(new DefaultBceSessionCredentials(info.ak, info.sk, info.token));
            bosConfig.setEndpoint(info.endpoint);
            BosClient bosClient = new BosClient(bosConfig);
            File file = new File(filePath);
            if (file.exists()) {
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(contentType);
                PutObjectResponse response = bosClient.putObject(info.bucket, info.bosObject, file, metadata);
                if (response != null && !TextUtils.isEmpty(response.getETag())) {
                    if (!DEBUG) {
                        return true;
                    }
                    Log.i(TAG, "uploadBosFile: upload success.");
                    return true;
                }
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    static String buildUploadFileName(Context context, String filePath, String endType) {
        return SwanAppPageFavoriteHelper.buildBitmapName(filePath, context) + endType;
    }

    public static void updateServerTimeDelta(Response response, long responseAt, String spKey) {
        Date date;
        String strDate = response.header("Date");
        if (!TextUtils.isEmpty(strDate) && (date = HttpDate.parse(strDate)) != null) {
            long time = date.getTime();
            if (time >= 1) {
                long diff = responseAt - time;
                SwanAppSpHelper.getInstance().putLong(spKey, diff);
                if (DEBUG) {
                    Log.i("getServerTimeDelta", "deltaTime sDate:" + date + "  sTime:" + time + "   diff:" + diff);
                }
            }
        }
    }

    private static long getServerTimeDelta(String spKey) {
        long diff = SwanAppSpHelper.getInstance().getLong(spKey, 0);
        if (DEBUG) {
            Log.i("getServerTimeDelta", "deltaTime get:" + diff);
        }
        return diff;
    }

    private static String generateFormIdRasign(long time, long delta) {
        return Long.toHexString(AntiReplayToken.crc32(time + "#" + delta));
    }
}
