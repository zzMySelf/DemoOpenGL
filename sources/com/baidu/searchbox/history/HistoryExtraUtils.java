package com.baidu.searchbox.history;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.userassetsaggr.container.data.UserAssetsAggrConstants;
import org.json.JSONObject;

public class HistoryExtraUtils {
    public static String getServiceRateUrl(String extra) {
        try {
            return new JSONObject(extra).getJSONObject(UserAssetsAggrConstants.KEY_SERVICE_RATE_INFO).optString(UserAssetsAggrConstants.KEY_SERVICE_RATE_URL, "");
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return "";
        }
    }

    public static String getBaoInfo(String extra) {
        if (TextUtils.isEmpty(extra)) {
            return "";
        }
        try {
            return new JSONObject(extra).getJSONObject(UserAssetsAggrConstants.KEY_BAO_DATA_INFO).optString(UserAssetsAggrConstants.KEY_BAO_DATA, "");
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return "";
        }
    }
}
