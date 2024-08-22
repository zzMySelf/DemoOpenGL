package com.baidu.sapi2.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;

public class DarkModeUtil implements NoProguard {
    public static final String TAG = "SAPI DarkModeUtil";

    public static boolean isDarkMode(Context context) {
        if (context == null) {
            return false;
        }
        try {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration == null) {
                return false;
            }
            if (!sapiConfiguration.isUIModeFollowSystem) {
                return sapiConfiguration.isDarkMode;
            }
            if (((UiModeManager) context.getSystemService("uimode")).getNightMode() == 2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }
}
