package com.baidu.swan.game.ad.entity;

import org.json.JSONObject;

public class AdLandingDownloadInfo {
    public static final String DOWNLOAD_NO_PACKAGE = "4";
    public static final String DOWNLOAD_PACKAGE_BINDING = "2";
    public static final String DOWNLOAD_PACKAGE_NOT_BINDING = "3";
    public static final String DOWNLOAD_WHITE_LIST = "1";
    private static final String KEY_APK_SIZE = "apk_size";
    private static final String KEY_APK_URL = "apk_url";
    private static final String KEY_APP_ICON = "app_icon";
    private static final String KEY_APP_INFO = "app_info";
    private static final String KEY_APP_NAME = "app_name";
    private static final String KEY_DATA = "data";
    private static final String KEY_DEVELOPER = "developer_name";
    private static final String KEY_DOWNLOAD_HINT = "download_hint";
    private static final String KEY_DOWNLOAD_STATE = "download_state";
    private static final String KEY_FUNCTION = "function";
    private static final String KEY_PERMISSION = "permission";
    private static final String KEY_PRIVACY = "privacy";
    private static final String KEY_URL = "cmd";
    private static final String KEY_VERSION = "version";
    private String mApkSize;
    private String mApkUrl;
    private String mAppName;
    private String mDeveloper;
    private String mDownloadHint;
    private String mDownloadState;
    private String mFunction;
    private String mIcon;
    private String mPermission;
    private String mPrivacy;
    private String mVersion;

    public AdLandingDownloadInfo(String response) {
        if (response != null) {
            try {
                JSONObject downloadData = new JSONObject(response).getJSONObject("data");
                this.mDownloadState = downloadData.optString(KEY_DOWNLOAD_STATE, "");
                this.mDownloadHint = downloadData.optString(KEY_DOWNLOAD_HINT, "");
                JSONObject appInfo = downloadData.optJSONObject(KEY_APP_INFO);
                if (appInfo != null) {
                    this.mAppName = appInfo.optString("app_name", "");
                    this.mDeveloper = appInfo.optString("developer_name", "");
                    this.mIcon = appInfo.optString("app_icon", "");
                    JSONObject privacy = appInfo.optJSONObject("privacy");
                    if (privacy != null) {
                        this.mPrivacy = privacy.optString("cmd", "");
                    }
                    JSONObject permission = appInfo.optJSONObject("permission");
                    if (permission != null) {
                        this.mPermission = permission.optString("cmd", "");
                    }
                    JSONObject function = appInfo.optJSONObject("function");
                    if (function != null) {
                        this.mFunction = function.optString("cmd", "");
                    }
                    this.mApkUrl = appInfo.optString("apk_url", "");
                    this.mVersion = appInfo.optString("version", "");
                    this.mApkSize = appInfo.optString("apk_size", "");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getDeveloper() {
        return this.mDeveloper;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getPrivacy() {
        return this.mPrivacy;
    }

    public String getPermission() {
        return this.mPermission;
    }

    public String getFunction() {
        return this.mFunction;
    }

    public String getApkUrl() {
        return this.mApkUrl;
    }

    public String getApkSize() {
        return this.mApkSize;
    }

    public String getDownloadState() {
        return this.mDownloadState;
    }

    public String getDownloadHint() {
        return this.mDownloadHint;
    }
}
