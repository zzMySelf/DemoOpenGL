package com.dxmpay.wallet.paysdk.storage;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.utils.PassUtil;
import java.util.Map;

public final class PayPreferenceManager {
    public static final String PWDPAY_DISPLAY_SCORE_TIP = "pwdpay_display_score_tip";

    public static boolean getBoolean(Context context, String str, boolean z) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, "_dxm_pay.preferences", str, Boolean.valueOf(z))).booleanValue();
    }

    public static String getDxmDidToMd5(Context context) {
        Map<String, String> loginData = WalletLoginHelper.getInstance().getLoginData();
        if (loginData == null) {
            return null;
        }
        String str = loginData.get(PassUtil.DXM_DID);
        if (!TextUtils.isEmpty(str)) {
            return Md5Utils.toMD5(str);
        }
        return null;
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
        String str2 = loginData.get(PassUtil.DXM_DID);
        if (!TextUtils.isEmpty(str2)) {
            return Md5Utils.toMD5(str2);
        }
        String str3 = loginData.get("pass_user_name");
        if (!TextUtils.isEmpty(str3)) {
            return Md5Utils.toMD5(str3);
        }
        String str4 = loginData.get("pass_open_bduss");
        if (!TextUtils.isEmpty(str4)) {
            return Md5Utils.toMD5(str4);
        }
        return null;
    }

    public static void setBoolean(Context context, String str, boolean z) {
        SharedPreferencesUtils.setParam(context, "_dxm_pay.preferences", str, Boolean.valueOf(z));
    }
}
