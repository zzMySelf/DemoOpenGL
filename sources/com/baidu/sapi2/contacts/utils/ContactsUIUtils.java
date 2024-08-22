package com.baidu.sapi2.contacts.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;

public class ContactsUIUtils implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18218a = "UIUtils";

    public static boolean isDarkMode(Context context, SapiConfiguration sapiConfiguration) {
        if (context == null || sapiConfiguration == null) {
            return false;
        }
        try {
            if (!sapiConfiguration.isUIModeFollowSystem) {
                return sapiConfiguration.isDarkMode;
            }
            if (((UiModeManager) context.getSystemService("uimode")).getNightMode() == 2) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            Log.e(f18218a, e2.getMessage());
            return false;
        }
    }
}
