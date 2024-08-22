package com.baidu.swan.apps.menu.favorite;

import android.text.TextUtils;
import com.baidu.swan.apps.upload.UploadBosApi;
import org.json.JSONObject;

public class SwanAppBosAuthorizeInfo {
    private static final String BASE_URL = "https://b0.bdstatic.com";
    private static final String DEFAULT_HOST = "bj.bcebos.com";
    public static final String ERROR_CODE_SUCCESS = "0";
    public String ak;
    public String bosObject;
    public String bosUrl;
    public String bucket;
    public String endpoint;
    public String sk;
    public String token;

    public static SwanAppBosAuthorizeInfo parseAuthorizeData(JSONObject data, String key) {
        JSONObject imageInfo;
        if (data == null) {
            return null;
        }
        SwanAppBosAuthorizeInfo info = new SwanAppBosAuthorizeInfo();
        info.ak = data.optString("ak");
        info.sk = data.optString("sk");
        info.token = data.optString("token");
        info.bucket = data.optString("bucket");
        JSONObject nameList = data.optJSONObject("oname_list");
        if (!(nameList == null || (imageInfo = nameList.optJSONObject(key)) == null)) {
            info.bosObject = imageInfo.optString("bosobject");
        }
        info.bosUrl = BASE_URL + info.bosObject;
        return info;
    }

    public static SwanAppBosAuthorizeInfo parseCommentAuth(JSONObject responseJson, String key) {
        JSONObject imageInfo;
        if (responseJson == null) {
            return null;
        }
        JSONObject data = responseJson.optJSONObject("data");
        String errCode = responseJson.optString("error");
        if (data == null || !TextUtils.equals(errCode, "0")) {
            return null;
        }
        SwanAppBosAuthorizeInfo info = new SwanAppBosAuthorizeInfo();
        info.ak = data.optString("ak");
        info.sk = data.optString("sk");
        info.token = data.optString("token");
        info.bucket = data.optString("bucket");
        String endpoint2 = data.optString(UploadBosApi.PARAM_ENDPOINT);
        info.endpoint = TextUtils.isEmpty(endpoint2) ? DEFAULT_HOST : endpoint2;
        JSONObject nameList = data.optJSONObject("oname_list");
        if (!(nameList == null || (imageInfo = nameList.optJSONObject(key)) == null)) {
            info.bosObject = imageInfo.optString("bosobject");
            info.bosUrl = imageInfo.optString("bosurl");
        }
        return info;
    }
}
