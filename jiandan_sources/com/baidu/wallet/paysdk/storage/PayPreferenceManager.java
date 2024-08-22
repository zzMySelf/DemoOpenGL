package com.baidu.wallet.paysdk.storage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import java.util.Map;

public final class PayPreferenceManager {
    public static final String PWDPAY_DISPLAY_SCORE_TIP = "pwdpay_display_score_tip";
    public static final String a = "_pay.preferences";
    public static final String b = "wallet_interface.preferences";

    public static boolean getBoolean(Context context, String str, boolean z) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, "_pay.preferences", str, Boolean.valueOf(z))).booleanValue();
    }

    public static String getNewPpKey(Context context) {
        Map<String, String> loginData = WalletLoginHelper.getInstance().getLoginData();
        if (loginData == null) {
            return null;
        }
        String str = loginData.get("pass_union_id");
        if (!TextUtils.isEmpty(str)) {
            return Md5Utils.toMD5(str);
        }
        String str2 = loginData.get("pass_user_name");
        if (!TextUtils.isEmpty(str2)) {
            return Md5Utils.toMD5(str2);
        }
        String str3 = loginData.get("pass_open_bduss");
        if (!TextUtils.isEmpty(str3)) {
            return Md5Utils.toMD5(str3);
        }
        return null;
    }

    public static String getPpCheckTime(Context context) {
        String newPpKey = getNewPpKey(context);
        if (TextUtils.isEmpty(newPpKey)) {
            return "";
        }
        return (String) SharedPreferencesUtils.getParam(context, "_pay.preferences", newPpKey + "time", "");
    }

    public static boolean getPpSwitch(Context context) {
        return false;
    }

    public static String getUserToken() {
        String newPpKey = getNewPpKey((Context) null);
        return TextUtils.isEmpty(newPpKey) ? "1af5e6a72da623b78e1edbb73605964f" : newPpKey;
    }

    public static String getWalletInterfaceData(Context context, String str, String str2) {
        return (String) SharedPreferencesUtils.getParam(context, b, str, str2);
    }

    public static void setBoolean(Context context, String str, boolean z) {
        SharedPreferencesUtils.setParam(context, "_pay.preferences", str, Boolean.valueOf(z));
    }

    public static void setPpCheckTime(Context context, String str) {
        String newPpKey = getNewPpKey(context);
        if (!TextUtils.isEmpty(newPpKey)) {
            SharedPreferencesUtils.setParam(context, "_pay.preferences", newPpKey + "time", str);
        }
    }

    public static void setPpSwitch(Context context, boolean z) {
        String newPpKey = getNewPpKey(context);
        if (!TextUtils.isEmpty(newPpKey)) {
            SharedPreferencesUtils.setParam(context, "_pay.preferences", newPpKey, Boolean.valueOf(z));
        }
    }

    public static void setWalletInterfaceData(Context context, String str, String str2) {
        SharedPreferencesUtils.setParam(context, b, str, str2);
    }
}
