package com.baidu.swan.apps.ai;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.jsinjection.JsInjectConstantFileKt;
import com.baidu.searchbox.socialshare.utils.SocialConstants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.widget.net.WidgetNetConstatsKt;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.api.module.network.CallServiceRequest;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.network.BaseRequestAction;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.swan.SwanAppStabilityMonitor;
import com.baidu.swan.apps.storage.StorageUtil;
import com.baidu.swan.apps.util.SwanAppImageUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.network.config.SwanNetworkConfig;
import com.baidu.swan.network.manager.SwanHttpManager;
import com.baidu.swan.pms.PMSRuntime;
import com.baidu.swan.utils.DeviceInfoUtils;
import com.baidu.swan.utils.SwanAppMD5Utils;
import com.baidu.yun.service.NetdiskConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AiRequestUtils {
    static final String CONTENT_LENGTH = "Content-Length";
    static final String DATA = "data";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String FACE_DETECT = "/rest/2.0/face/v3/detect";
    static final String HEADERS = "Headers";
    static final int REG_HEIGHT = 1080;
    static final int REG_WIDTH = 1920;
    private static final String SCHEME_CLOUD = "cloud";
    private static final String SERVICE_CLOUD_REQUEST = "cloud";
    public static final String TAG = "AiRequestUtils";

    public static Request buildRequest(SwanApp swanApp, JSONObject joRequest, UnitedSchemeEntity entity) {
        JSONObject fileMapJson;
        File tempFile;
        JSONObject jSONObject = joRequest;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        Request request = null;
        if (jSONObject == null) {
            setCallBackMsg(unitedSchemeEntity, 202, "illegal entity");
            return null;
        }
        JSONObject stringMapJson = jSONObject.optJSONObject("stringMap");
        JSONObject fileMapJson2 = jSONObject.optJSONObject("fileMap");
        String service = jSONObject.optString("service");
        String api = jSONObject.optString("api");
        if (swanApp == null || stringMapJson == null || TextUtils.isEmpty(service)) {
        } else if (TextUtils.isEmpty(api)) {
            JSONObject jSONObject2 = fileMapJson2;
        } else {
            MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            Iterator<String> iter = stringMapJson.keys();
            while (iter.hasNext()) {
                String stringMapKey = iter.next();
                multipartBodyBuilder.addFormDataPart(stringMapKey, stringMapJson.optString(stringMapKey));
            }
            int i2 = 1001;
            if (fileMapJson2 != null) {
                Iterator<String> iter2 = fileMapJson2.keys();
                while (iter2.hasNext()) {
                    String fileMapKey = iter2.next();
                    String filePath = StorageUtil.scheme2Path(fileMapJson2.optString(fileMapKey), SwanApp.getSwanAppId());
                    if (!TextUtils.isEmpty(filePath)) {
                        File uploadFile = new File(filePath);
                        if (!uploadFile.exists()) {
                            setCallBackMsg(unitedSchemeEntity, i2, "upload file not exist");
                            return request;
                        } else if (uploadFile.length() > 10485760) {
                            setCallBackMsg(unitedSchemeEntity, i2, "upload file too large");
                            return null;
                        } else {
                            File tempFile2 = uploadFile;
                            if (TextUtils.equals(api, FACE_DETECT)) {
                                File tempFile3 = SwanAppImageUtils.getTempFile(uploadFile.getName());
                                if (!SwanAppImageUtils.compressImage(uploadFile, tempFile3, 1920, 1080)) {
                                    tempFile = tempFile3;
                                    fileMapJson = fileMapJson2;
                                    SwanAppStabilityMonitor.onStabilityMonitor("image", 2001, "compress image failed", 1001, "compress image failed");
                                    SwanAppLog.e(TAG, "compress image failed");
                                } else {
                                    tempFile = tempFile3;
                                    fileMapJson = fileMapJson2;
                                }
                                tempFile2 = tempFile;
                            } else {
                                fileMapJson = fileMapJson2;
                            }
                            multipartBodyBuilder.addFormDataPart(fileMapKey, tempFile2.getName(), new UploadFileRequestBody(tempFile2));
                        }
                    } else {
                        fileMapJson = fileMapJson2;
                    }
                    JSONObject jSONObject3 = joRequest;
                    fileMapJson2 = fileMapJson;
                    request = null;
                    i2 = 1001;
                }
            }
            String apiKey = swanApp.getAppKey();
            long timestamp = SwanAppRuntime.getCloudUrl().getServiceTime(AppRuntime.getAppContext());
            String cuid = SwanAppRuntime.getSwanAppAccountRuntime().getEncryptionDeviceIdentity(AppRuntime.getAppContext());
            String encrypted = sign(stringMapJson, apiKey, timestamp, cuid);
            if (encrypted == null) {
                setCallBackMsg(unitedSchemeEntity, 1001, "sign error");
                return null;
            }
            HttpUrl baseHttpUrl = HttpUrl.parse(SwanAppRuntime.getCommonParamRuntime().processUrl(SwanAppRuntime.getConfigRuntime().getSwanAppCommonAiUrl() + "/" + service + api));
            if (baseHttpUrl == null) {
                setCallBackMsg(unitedSchemeEntity, 1001, "request url error");
                return null;
            }
            HttpUrl.Builder httpUrlBuilder = baseHttpUrl.newBuilder();
            httpUrlBuilder.addQueryParameter("ai_sign", encrypted);
            httpUrlBuilder.addQueryParameter(SocialConstants.PARAM_SHORT_API_KEY, apiKey);
            httpUrlBuilder.addQueryParameter("timestamp", String.valueOf(timestamp));
            httpUrlBuilder.addQueryParameter(CallServiceRequest.PARAM_KEY_HOST_APP, PMSRuntime.getPMSContext().getHostAppName());
            httpUrlBuilder.addQueryParameter(CallServiceRequest.PARAM_KEY_HOST_APP_VERSION, PMSRuntime.getPMSContext().getHostAppVersion());
            httpUrlBuilder.addQueryParameter("sdk_ver", PMSRuntime.getPMSContext().getSwanNativeVersion());
            httpUrlBuilder.addQueryParameter("swan_core_ver", PMSRuntime.getPMSContext().getSwanCoreVersionName(Swan.get().getFrameType()));
            httpUrlBuilder.addQueryParameter(CallServiceRequest.PARAM_KEY_HOST_OPERATING_SYSTEM, DeviceInfoUtils.getOS());
            httpUrlBuilder.addQueryParameter(CallServiceRequest.PARAM_KEY_HOST_OPERATING_SYSTEM_VERSION, DeviceInfoUtils.getOsVersion());
            String str = apiKey;
            Request.Builder builder = new Request.Builder().url(httpUrlBuilder.build()).post(multipartBodyBuilder.build());
            MultipartBody.Builder builder2 = multipartBodyBuilder;
            String bduss = SwanAppRuntime.getSwanAppAccountRuntime().getAccountIdentity(AppRuntime.getAppContext());
            String str2 = cuid;
            String cookies = "BDUSS=" + bduss;
            if (!TextUtils.isEmpty(bduss)) {
                builder.addHeader("Cookie", cookies);
            }
            return builder.build();
        }
        setCallBackMsg(unitedSchemeEntity, 202, BaseRequestAction.MESSAGE_ILLEGAL_REQUEST);
        return null;
    }

    public static void postHttpRequest(String url, RequestBody requestBody, ResponseCallback responseCallback) {
        SwanNetworkConfig config = new SwanNetworkConfig(url, requestBody, responseCallback);
        config.isAddUa = true;
        config.isAddCookie = true;
        config.setTimeout = true;
        SwanHttpManager.getDefault().execPostRequest(config);
    }

    public static String sign(JSONObject stringMapJson, String apiKey, long timestamp, String cuid) {
        try {
            Iterator<String> iterator = stringMapJson.keys();
            ArrayList<String> arrayList = new ArrayList<>();
            while (iterator.hasNext()) {
                arrayList.add(iterator.next());
            }
            Collections.sort(arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            for (String mapKey : arrayList) {
                try {
                    String mapValue = stringMapJson.optString(mapKey);
                    stringBuilder.append(urlEncodeInSign(mapKey));
                    stringBuilder.append("=");
                    stringBuilder.append(urlEncodeInSign(mapValue));
                    stringBuilder.append("&");
                } catch (Exception e2) {
                    return null;
                }
            }
            JSONObject jSONObject = stringMapJson;
            String plainText = stringBuilder.toString();
            if (plainText.endsWith("&")) {
                plainText = plainText.substring(0, plainText.length() - 1);
            }
            String plainTextMd5 = SwanAppMD5Utils.toMd5(plainText.getBytes(), false);
            byte[] aesKeyTrim = Arrays.copyOf(Base64.decode(SwanAppMD5Utils.toMd5(apiKey.getBytes(), false), 0), 24);
            byte[] aesIVTrim = Arrays.copyOf(Base64.decode(SwanAppMD5Utils.toMd5(String.format("%s%d", new Object[]{cuid, Long.valueOf(timestamp)}).getBytes(), false).getBytes(), 0), 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            Iterator<String> it = iterator;
            cipher.init(1, new SecretKeySpec(aesKeyTrim, "AES"), new IvParameterSpec(aesIVTrim));
            byte[] encrypted = cipher.doFinal(plainTextMd5.getBytes());
            ArrayList arrayList2 = arrayList;
            byte[] aesbyte = Base64.encode(encrypted, 0);
            byte[] bArr = encrypted;
            StringBuilder sb = stringBuilder;
            String aesStr = new String(aesbyte, StandardCharsets.UTF_8);
            if (aesStr.endsWith("\n")) {
                byte[] bArr2 = aesbyte;
                return aesStr.substring(0, aesStr.length() - 1);
            }
            return aesStr;
        } catch (Exception e3) {
            JSONObject jSONObject2 = stringMapJson;
            return null;
        }
    }

    private static String urlEncodeInSign(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String patchedEncodedStr = URLEncoder.encode(str, "UTF-8");
        if (patchedEncodedStr.contains("%7E")) {
            patchedEncodedStr = patchedEncodedStr.replace("%7E", Constants.WAVE_SEPARATOR);
        }
        if (patchedEncodedStr.contains("*")) {
            return patchedEncodedStr.replace("*", "%2A");
        }
        return patchedEncodedStr;
    }

    private static String getEncodeValue(String value) {
        try {
            return URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            if (!DEBUG) {
                return value;
            }
            e2.printStackTrace();
            return value;
        }
    }

    private static void setCallBackMsg(UnitedSchemeEntity entity, int errCode, String errMsg) {
        if (entity != null) {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(errCode, errMsg);
        }
    }

    public static <T> void aiBdtlsRequest(Request request, ResponseCallback<T> responseCallback) {
        if (request == null) {
            responseCallback.onFail(new Exception("request is null!"));
            return;
        }
        Map<String, String> headers = new HashMap<>();
        for (String name : request.headers().names()) {
            headers.put(name, request.headers().get(name));
        }
        if (DEBUG) {
            SwanAppLog.d(TAG, "bdtls reqest url: " + request.url());
            SwanAppLog.d(TAG, "bdtls request headers: " + request.headers());
        }
        SwanNetworkConfig networkConfig = new SwanNetworkConfig(request.url().toString(), responseCallback);
        networkConfig.headers = headers;
        networkConfig.requestBody = request.body();
        networkConfig.isAddCookie = true;
        SwanAppRuntime.getBdtls().request(networkConfig);
    }

    public static void getCloudUrl(String imgUrl, final TypedCallback<String> callback) {
        if (TextUtils.isEmpty(imgUrl) || !imgUrl.startsWith(NetdiskConstants.SCENE_CLOUD)) {
            callback.onCallback(null);
            return;
        }
        URI uri = URI.create(imgUrl);
        String workspaceId = uri.getHost();
        if (!TextUtils.isEmpty(uri.toString()) || !TextUtils.isEmpty(workspaceId)) {
            Request request = buildRequest(SwanApp.get(), getCloudUrlParams(imgUrl), (UnitedSchemeEntity) null);
            if (SwanApp.get() == null) {
                callback.onCallback(null);
            } else {
                aiBdtlsRequest(request, new ResponseCallback<Object>() {
                    public Object parseResponse(Response response, int i2) throws Exception {
                        AiRequestUtils.getCloudUrlParseResult(response, TypedCallback.this);
                        return response;
                    }

                    public void onSuccess(Object o, int i2) {
                    }

                    public void onFail(Exception e2) {
                        TypedCallback.this.onCallback(null);
                    }
                });
            }
        } else {
            callback.onCallback(null);
        }
    }

    /* access modifiers changed from: private */
    public static void getCloudUrlParseResult(Response response, TypedCallback<String> callback) {
        if (callback != null) {
            if (response == null) {
                callback.onCallback(null);
                return;
            }
            try {
                JSONObject responseBody = new JSONObject();
                if (response.body() != null) {
                    responseBody = new JSONObject(response.body().string());
                }
                if (DEBUG) {
                    SwanAppLog.d(TAG, "response body: " + responseBody);
                }
                String downloadUrl = responseBody.optString("DownloadUrl");
                if (!TextUtils.isEmpty(downloadUrl)) {
                    callback.onCallback(downloadUrl);
                } else {
                    callback.onCallback(null);
                }
            } catch (Exception e2) {
                callback.onCallback(null);
            }
        }
    }

    public static void getCloudUrlList(JSONArray cloudUrls, final TypedCallback<String> callback) {
        if (cloudUrls == null || cloudUrls.length() <= 0) {
            callback.onCallback(null);
            return;
        }
        Request request = buildRequest(SwanApp.get(), getCloudUrlListParams(cloudUrls.toString()), (UnitedSchemeEntity) null);
        if (SwanApp.get() == null) {
            callback.onCallback(null);
        } else {
            aiBdtlsRequest(request, new ResponseCallback<Object>() {
                public Object parseResponse(Response response, int i2) throws Exception {
                    AiRequestUtils.getCloudUrlListParseResult(response, TypedCallback.this);
                    return response;
                }

                public void onSuccess(Object o, int i2) {
                }

                public void onFail(Exception e2) {
                    TypedCallback.this.onCallback(null);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void getCloudUrlListParseResult(Response response, TypedCallback<String> callback) {
        if (callback != null) {
            if (response == null) {
                callback.onCallback(null);
                return;
            }
            JSONObject responseBody = new JSONObject();
            if (response.body() != null) {
                try {
                    responseBody = new JSONObject(response.body().string());
                } catch (IOException | JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    callback.onCallback(null);
                }
            }
            if (DEBUG) {
                SwanAppLog.d(TAG, "response body: " + responseBody);
            }
            JSONArray fileListResponse = responseBody.optJSONArray(JsInjectConstantFileKt.KEY_FILE_LIST);
            if (fileListResponse == null) {
                callback.onCallback(null);
            } else {
                callback.onCallback(fileListResponse.toString());
            }
        }
    }

    private static JSONObject getCloudUrlListParams(String urlList) {
        return getParams(urlList, (String) null);
    }

    private static JSONObject getCloudUrlParams(String url) {
        return getParams((String) null, url);
    }

    private static JSONObject getParams(String fileIDList, String fileID) {
        JSONObject params = new JSONObject();
        JSONObject map = new JSONObject();
        try {
            if (!TextUtils.isEmpty(fileID)) {
                map.put("fileID", fileID);
                params.put("api", "/v1/workspace/storage/request-download");
            }
            if (!TextUtils.isEmpty(fileIDList)) {
                params.put("api", "/v1/workspace/storage/batch-download");
                map.put(JsInjectConstantFileKt.KEY_FILE_LIST, fileIDList);
            }
            params.put("service", NetdiskConstants.SCENE_CLOUD);
            params.put("stringMap", map);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return params;
    }

    static JSONObject getResponseObject(Response response) {
        String responseString = null;
        try {
            if (response.body() != null) {
                responseString = response.body().string();
            }
            return new JSONObject(responseString);
        } catch (IOException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return null;
        } catch (JSONException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    static boolean isRequestFail(String errNo) {
        return getErrNoCode(errNo) != 0;
    }

    static JSONObject getSuccessMsg(String fileID, String tempFilePath, String message) {
        JSONObject successMsg = new JSONObject();
        try {
            successMsg.put("errMsg", message);
            successMsg.put("statusCode", 200);
            if (!TextUtils.isEmpty(fileID)) {
                successMsg.put("fileID", fileID);
            }
            if (!TextUtils.isEmpty(tempFilePath)) {
                successMsg.put("tempFilePath", tempFilePath);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return successMsg;
    }

    static int getErrNoCode(String errNo) {
        if (TextUtils.isEmpty(errNo)) {
            return 1001;
        }
        try {
            return Integer.parseInt(errNo);
        } catch (NumberFormatException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return 1001;
        }
    }

    static String getErrorMsg(String errMsg) {
        return TextUtils.isEmpty(errMsg) ? WidgetNetConstatsKt.ERROR_MSG_REQUEST_FAIL : errMsg;
    }
}
