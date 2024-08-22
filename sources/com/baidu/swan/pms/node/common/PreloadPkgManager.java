package com.baidu.swan.pms.node.common;

import android.text.TextUtils;
import com.baidu.swan.pms.PMSRuntime;
import com.baidu.swan.utils.SwanDefaultSharedPrefsImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadPkgManager {
    private static final String KEY_PERSONAL_CENTER_APPS_KEY = "personal_center_apps_key";
    private static final String KEY_PERSONAL_CENTER_VERSION = "personal_center_version";
    public static final String KEY_PUSH_PKG_PRELOAD_APP_KEYS = "push_pkg_preload_app_keys";
    public static final String KEY_PUSH_PKG_PRELOAD_VERSION = "push_pkg_preload_version";
    private static final String SWITCH_KEY_PERSONAL_PRE_DOWNLOAD_OPT = "swan_personal_pre_download_opt";
    private static final boolean SWITCH_VALUE_PERSONAL_PRE_DOWNLOAD_OPT = PMSRuntime.getPMSContext().getBooleanCommonSwitch(SWITCH_KEY_PERSONAL_PRE_DOWNLOAD_OPT, true);
    private static volatile PreloadPkgManager sInstance;
    private CleanStrategyPrefs mSharedPrefs = new CleanStrategyPrefs();

    public static PreloadPkgManager getInstance() {
        if (sInstance == null) {
            synchronized (PreloadPkgManager.class) {
                if (sInstance == null) {
                    sInstance = new PreloadPkgManager();
                }
            }
        }
        return sInstance;
    }

    private PreloadPkgManager() {
    }

    public String getVersion() {
        return this.mSharedPrefs.getString("version", "0");
    }

    public String getPersonalCenterPreloadPkgVersion() {
        return this.mSharedPrefs.getString(KEY_PERSONAL_CENTER_VERSION, "0");
    }

    public String getPushPkgPreloadVersion() {
        return this.mSharedPrefs.getString(KEY_PUSH_PKG_PRELOAD_VERSION, "0");
    }

    /* access modifiers changed from: package-private */
    public void process(JSONObject data) {
        PreloadPkgData preloadPkgData;
        if (data != null && (preloadPkgData = PreloadPkgData.createFromJson(data)) != null) {
            PMSRuntime.getPMSContext().preloadPkg(preloadPkgData);
        }
    }

    /* access modifiers changed from: package-private */
    public void processPushPkgPreload(JSONObject obj) {
        PreloadPkgData preloadPkgData = PreloadPkgData.createFromJson(obj);
        if (preloadPkgData != null) {
            String version = preloadPkgData.getVersion();
            if (TextUtils.isEmpty(version)) {
                version = "0";
            }
            this.mSharedPrefs.putString(KEY_PUSH_PKG_PRELOAD_VERSION, version);
            PMSRuntime.getPMSContext().pushPkgPreload(preloadPkgData);
        }
    }

    /* access modifiers changed from: package-private */
    public void processPersonalCenterPreloadData(JSONObject obj) {
        JSONArray appsArrObj;
        if (obj != null && obj.optInt("errno", -1) == 0) {
            String version = obj.optString("version");
            if (TextUtils.isEmpty(version)) {
                version = "0";
            }
            this.mSharedPrefs.putString(KEY_PERSONAL_CENTER_VERSION, version);
            JSONObject dataObj = obj.optJSONObject("data");
            if (dataObj != null && (appsArrObj = dataObj.optJSONArray("appkeys")) != null) {
                this.mSharedPrefs.putString(KEY_PERSONAL_CENTER_APPS_KEY, appsArrObj.toString());
            }
        }
    }

    public List<String> getPersonalCenterPreloadAppList() {
        List<String> appKeyList = new ArrayList<>();
        String appKeys = this.mSharedPrefs.getString(KEY_PERSONAL_CENTER_APPS_KEY, (String) null);
        if (TextUtils.isEmpty(appKeys)) {
            return appKeyList;
        }
        try {
            JSONArray array = new JSONArray(appKeys);
            int length = array.length();
            if (SWITCH_VALUE_PERSONAL_PRE_DOWNLOAD_OPT && length > 2) {
                length = 2;
            }
            for (int index = 0; index < length; index++) {
                String appKey = array.optString(index);
                if (!TextUtils.isEmpty(appKey)) {
                    appKeyList.add(appKey);
                }
            }
        } catch (Exception e2) {
        }
        return appKeyList;
    }

    public void onPkgPreloaded(PreloadPkgData data) {
        if (data != null) {
            this.mSharedPrefs.edit().putString("version", data.getVersion()).apply();
        }
    }

    public static class CleanStrategyPrefs extends SwanDefaultSharedPrefsImpl {
        public static final String PREF_NAME = "swan_preload_package";

        CleanStrategyPrefs() {
            super(PREF_NAME);
        }
    }
}
