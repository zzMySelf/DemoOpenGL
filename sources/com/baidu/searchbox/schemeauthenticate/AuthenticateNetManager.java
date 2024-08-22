package com.baidu.searchbox.schemeauthenticate;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.schemeauthenticate.SchemeAuthenticateMonitor;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthenticateNetManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_DATA = "data";
    private static final String KEY_ERRNO = "errno";
    private static final String KEY_EXPIRE_TIME = "scheme_timeout";
    public static final String KEY_EXT = "ext";
    public static final String KEY_NAME = "name";
    public static final String KEY_SCHEME_LIST = "scheme_list";
    private static final String KEY_SCHEME_LIST_H5 = "schemeList";
    public static final String KEY_SCHEME_VERSION = "scheme_version";
    public static final String KEY_TAG = "tag";
    private static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    private static final String TAG = AuthenticateNetManager.class.getSimpleName();

    public interface Authenticatecallback {
        void onFailure();

        void onNoNetwork();

        void onsucess(SiteauthenticateResult siteauthenticateResult);
    }

    public final void authenticateConfig(Context context, final String referUrl, JSONObject paramJson, final Authenticatecallback resultCallback) {
        String url = BaiduIdentityManager.getInstance().appendParam(SchemeAuthConfigUrl.getAuthenticateUrl(), 1);
        Map<String, String> map = new HashMap<>();
        JSONObject dataJson = new JSONObject();
        String type = null;
        try {
            dataJson.put(KEY_SCHEME_VERSION, "45");
            dataJson.put("url", referUrl);
            dataJson.put("ext", paramJson.getJSONObject("ext"));
            dataJson.put("scheme_list", paramJson.getJSONArray("schemeList"));
            type = paramJson.getString("type");
            dataJson.put("type", type);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "autherticate e:" + e2);
            }
        }
        if (DEBUG) {
            Log.i(TAG, "authenticate paramJson:" + dataJson.toString());
        }
        map.put("data", dataJson.toString());
        final String finalType = type;
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(context).postFormRequest().url(url)).addParams(map)).build().executeAsyncOnUIBack(new ResponseCallback<SiteauthenticateResult>() {
            public SiteauthenticateResult parseResponse(Response response, int i2) {
                if (response == null || response.body() == null) {
                    return null;
                }
                try {
                    return AuthenticateNetManager.this.parseSiteAuthenticateInfo(response.body().string());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }

            public void onSuccess(SiteauthenticateResult result, int i2) {
                if (resultCallback != null) {
                    if (result != null) {
                        result.setType(finalType);
                        result.setUrl(referUrl);
                    }
                    resultCallback.onsucess(result);
                }
            }

            public void onFail(Exception e2) {
                Authenticatecallback authenticatecallback = resultCallback;
                if (authenticatecallback != null) {
                    authenticatecallback.onFailure();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public SiteauthenticateResult parseSiteAuthenticateInfo(String response) throws Exception {
        if (DEBUG) {
            Log.i(TAG, "parseSiteAuthenticateInfo reponse:" + response);
        }
        try {
            JSONObject json = new JSONObject(response);
            json.optInt("errno");
            JSONObject jsonData = json.getJSONObject("data");
            String schemeList = jsonData.getString("scheme_list");
            long expireTime = jsonData.getLong(KEY_EXPIRE_TIME);
            SiteauthenticateResult result = new SiteauthenticateResult();
            result.setSchemeList(schemeList);
            result.setExpireTime(System.currentTimeMillis() + (1000 * expireTime));
            return result;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static class SiteauthenticateResult {
        private String errno;
        private long mExpireTime;
        private String mSchemeList;
        private String mType;
        private String mUrl;

        public String getUrl() {
            return this.mUrl;
        }

        public void setUrl(String url) {
            this.mUrl = url;
        }

        public String getSchemeList() {
            return this.mSchemeList;
        }

        public void setSchemeList(String schemeList) {
            this.mSchemeList = schemeList;
        }

        public long getExpireTime() {
            return this.mExpireTime;
        }

        public void setExpireTime(long expireTime) {
            this.mExpireTime = expireTime;
        }

        public String getType() {
            return this.mType;
        }

        public void setType(String type) {
            this.mType = type;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("url:").append(this.mUrl).append(",");
            sb.append("schemeList:").append(this.mSchemeList).append(",");
            sb.append("expireTime:").append(this.mExpireTime);
            return sb.toString();
        }
    }

    public static SchemeAuthenticateMonitor.SiteAuthenticateInfo siteauthenticateResult2SiteAuthenticateInfo(SiteauthenticateResult result) {
        SchemeAuthenticateMonitor.SiteAuthenticateInfo info = new SchemeAuthenticateMonitor.SiteAuthenticateInfo();
        String schemeList = result.getSchemeList();
        Map<String, String> schemeMap = new HashMap<>();
        try {
            schemeList2Map(schemeList, schemeMap);
            info.setSchemeList(schemeMap);
            info.setExpireTime(result.getExpireTime());
            info.setType(result.getType());
            info.setUrl(result.getUrl());
        } catch (Exception e2) {
            if (DEBUG) {
                Log.i(TAG, "result2Info exception:" + e2);
            }
        }
        return info;
    }

    public static void schemeList2Map(String schemeList, Map<String, String> schemeMap) throws JSONException {
        JSONArray jsonArray = new JSONArray(schemeList);
        int length = jsonArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i2);
            schemeMap.put(jsonObject.getString("name"), jsonObject.getString("tag"));
        }
    }
}
