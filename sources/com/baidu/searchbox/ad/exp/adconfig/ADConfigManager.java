package com.baidu.searchbox.ad.exp.adconfig;

import android.text.TextUtils;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.ad.util.MapUtils;
import com.baidu.searchbox.ad.util.SafeSpUtils;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.ad.AdFileUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ADConfigManager {
    private static final boolean DEBUG = false;
    protected static final String GLOBAL = "global";
    private static final String SIGN = "_ad_adc_conf_sign";
    private static final String TAG = "ADCConfigManager";
    /* access modifiers changed from: private */
    public static final Object mConfigLock = new Object();
    protected boolean hasUpdateFromSp;
    /* access modifiers changed from: private */
    public final ADConfig mConfig;

    public boolean checkGlobalConfContainsKey(String paramKey) {
        if (TextUtils.isEmpty(paramKey)) {
            return false;
        }
        updateValueFromSp("global");
        return this.mConfig.getGlobalConfMap().containsKey(paramKey);
    }

    public boolean checkPlaceConfContainsKey(String whichPlace, String paramKey) {
        if (TextUtils.isEmpty(whichPlace) || TextUtils.isEmpty(paramKey)) {
            return false;
        }
        updateValueFromSp(whichPlace);
        Map<String, String> placeConfMap = this.mConfig.getPlaceConfMap().get(whichPlace);
        if (placeConfMap == null) {
            return false;
        }
        return placeConfMap.containsKey(paramKey);
    }

    public String getGlobalConfStr(String paramKey, String defaultValue) {
        if (!TextUtils.isEmpty(paramKey) && checkGlobalConfContainsKey(paramKey)) {
            return this.mConfig.getGlobalConfMap().get(paramKey);
        }
        return defaultValue;
    }

    public int getGlobalConfInt(String paramKey, int defaultValue) {
        String valueStr;
        if (TextUtils.isEmpty(paramKey) || !checkGlobalConfContainsKey(paramKey) || (valueStr = this.mConfig.getGlobalConfMap().get(paramKey)) == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(valueStr);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public long getGlobalConfLong(String paramKey, long defaultValue) {
        String valueStr;
        if (TextUtils.isEmpty(paramKey) || !checkGlobalConfContainsKey(paramKey) || (valueStr = this.mConfig.getGlobalConfMap().get(paramKey)) == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(valueStr);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public double getGlobalConfDouble(String paramKey, double defaultValue) {
        String valueStr;
        if (TextUtils.isEmpty(paramKey) || !checkGlobalConfContainsKey(paramKey) || (valueStr = this.mConfig.getGlobalConfMap().get(paramKey)) == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(valueStr);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public String getPlaceConfStr(String whichPlace, String paramKey, String defaultValue) {
        if (TextUtils.isEmpty(whichPlace) || TextUtils.isEmpty(paramKey) || !checkPlaceConfContainsKey(whichPlace, paramKey)) {
            return defaultValue;
        }
        return (String) this.mConfig.getPlaceConfMap().get(whichPlace).get(paramKey);
    }

    public int getPlaceConfInt(String whichPlace, String paramKey, int defaultValue) {
        String valueStr;
        if (TextUtils.isEmpty(whichPlace) || TextUtils.isEmpty(paramKey) || !checkPlaceConfContainsKey(whichPlace, paramKey) || (valueStr = (String) this.mConfig.getPlaceConfMap().get(whichPlace).get(paramKey)) == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(valueStr);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public long getPlaceConfLong(String whichPlace, String paramKey, long defaultValue) {
        String valueStr;
        if (TextUtils.isEmpty(whichPlace) || TextUtils.isEmpty(paramKey) || !checkPlaceConfContainsKey(whichPlace, paramKey) || (valueStr = (String) this.mConfig.getPlaceConfMap().get(whichPlace).get(paramKey)) == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(valueStr);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public double getPlaceConfDouble(String whichPlace, String paramKey, double defaultValue) {
        String valueStr;
        if (TextUtils.isEmpty(whichPlace) || TextUtils.isEmpty(paramKey) || !checkPlaceConfContainsKey(whichPlace, paramKey) || (valueStr = (String) this.mConfig.getPlaceConfMap().get(whichPlace).get(paramKey)) == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(valueStr);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 10 */
    public void parseFromNetwork(String source) throws ADConfigError {
        if (source == null || TextUtils.isEmpty(source)) {
            throw ADConfigError.error("1", ADConfigError.REASON_NULL_RESPONSE_BODY);
        }
        try {
            JSONObject responseJson = new JSONObject(source);
            if (!responseJson.has("error_code")) {
                throw ADConfigError.error("4", ADConfigError.REASON_NULL_CODE);
            } else if (!TextUtils.equals(responseJson.optString("error_code"), "0")) {
                throw ADConfigError.error("3", ADConfigError.REASON_WRONG_CODE);
            } else if (!responseJson.has("error_message")) {
                throw ADConfigError.error("6", ADConfigError.REASON_NULL_MSG);
            } else if (TextUtils.equals(responseJson.optString("error_message"), "success")) {
                String dataStr = responseJson.optString("data");
                if (!TextUtils.isEmpty(dataStr)) {
                    JSONObject data = new JSONObject(dataStr);
                    String dataSign = data.optString("sign");
                    if (TextUtils.isEmpty(dataSign)) {
                        throw ADConfigError.error("2", ADConfigError.REASON_NULL_SIGN);
                    } else if (!TextUtils.equals(dataSign, QuickPersistConfig.getInstance().getString(SIGN, ""))) {
                        QuickPersistConfig.getInstance().putString(SIGN, dataSign);
                        synchronized (mConfigLock) {
                            this.mConfig.update(data, true);
                            this.mConfig.persistence(data);
                        }
                    }
                } else {
                    throw ADConfigError.error("7", ADConfigError.REASON_NULL_DATA);
                }
            } else {
                throw ADConfigError.error("5", ADConfigError.REASON_WRONG_MSG);
            }
        } catch (JSONException e2) {
            throw ADConfigError.error("9", ADConfigError.REASON_RESPONSE_PARSE_ERROR);
        }
    }

    @Deprecated
    public void parseFromDb() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                synchronized (ADConfigManager.mConfigLock) {
                    if (!ADConfigManager.this.mConfig.hasUpdatedFromNet()) {
                        String localConfFile = AdFileUtil.INSTANCE.readCacheStr(ADConfig.KEY_FILE_NAME);
                        if (localConfFile != null) {
                            try {
                                if (!TextUtils.isEmpty(localConfFile)) {
                                    ADConfigManager.this.mConfig.update(new JSONObject(localConfFile), false);
                                }
                            } catch (JSONException e2) {
                            }
                        }
                    }
                }
            }
        }, "_ad_config_db_loader", 2);
    }

    public static ADConfigManager instance() {
        return InstanceHolder.INSTANCE;
    }

    private ADConfigManager() {
        this.mConfig = new ADConfig();
        this.hasUpdateFromSp = false;
    }

    private static final class InstanceHolder {
        public static final ADConfigManager INSTANCE = new ADConfigManager();

        private InstanceHolder() {
        }
    }

    /* access modifiers changed from: package-private */
    public void resetConfigUpdateFlag() {
        this.mConfig.resetADConfigRequestFlag();
    }

    /* access modifiers changed from: package-private */
    public void configHashUpdatedFromNet() {
        this.mConfig.configHasUpdatedFromNet();
    }

    private void updateValueFromSp(String place) {
        Map<String, ?> all;
        Map<String, ?> all2;
        if (place != null && !place.contains("/")) {
            if ("global".equals(place)) {
                if (!this.hasUpdateFromSp && (all2 = SafeSpUtils.getAll(new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences("ad.launch.config." + place)))) != null) {
                    MapUtils.putAll(this.mConfig.getGlobalConfMap(), all2);
                    this.hasUpdateFromSp = true;
                }
            } else if (this.mConfig.getPlaceConfMap().get(place) == null && (all = SafeSpUtils.getAll(new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences("ad.launch.config." + place)))) != null) {
                this.mConfig.getPlaceConfMap().put(place, all);
            }
        }
    }
}
