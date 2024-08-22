package com.dxmpay.wallet.base.datamodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccountManager implements NoProguard {
    public static final String FILE_PREFERENCE_ACCOUNT = "account";
    public static final String PREFERENCES_NAME_PRE = "o2o_service.preferences";
    public static final String TAG = "AccountManager";
    public static AccountManager sInstance;
    public Context mContext;
    public final SharedPreferences mPreferences;
    public String mbfbToken;

    public class User implements Serializable {
        public static final long serialVersionUID = 1;
        public String tokenValue;
        public int userType;

        public User(int i2, String str) {
            this.userType = i2;
            this.tokenValue = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("user_type", this.userType);
                jSONObject.put("token_value", this.tokenValue);
            } catch (JSONException e) {
                LogUtil.e("AccountManager", e.getMessage(), e);
            }
            return jSONObject.toString();
        }
    }

    public AccountManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mPreferences = context.getSharedPreferences("account", 0);
    }

    private void delScanCodeSP() {
    }

    public static synchronized AccountManager getInstance(Context context) {
        AccountManager accountManager;
        synchronized (AccountManager.class) {
            if (sInstance == null) {
                sInstance = new AccountManager(context.getApplicationContext());
            }
            accountManager = sInstance;
        }
        return accountManager;
    }

    public String getBfbToken() {
        String str = this.mbfbToken;
        if (str != null) {
            return str;
        }
        "mtoken 为NULL mPreferences=" + this.mPreferences;
        return this.mPreferences.getString("token", (String) null);
    }

    public String getFileNamePrefix() {
        String localEncrypt1 = SecurePay.getInstance().localEncrypt1(WalletLoginHelper.getInstance().getPassUid());
        if (TextUtils.isEmpty(localEncrypt1)) {
            return "";
        }
        "PREFERENCES_NAME_PRE: uid " + localEncrypt1;
        return Md5Utils.toMD5(localEncrypt1);
    }

    public Map<String, String> getLoginData() {
        return WalletLoginHelper.getInstance().getLoginData();
    }

    public int getLoginType() {
        return WalletLoginHelper.getInstance().getLoginType();
    }

    public String getOpenBduss() {
        return WalletLoginHelper.getInstance().getOpenLoginToken();
    }

    public void logout() {
        delScanCodeSP();
    }

    public void setBfbToken(String str) {
        "setBfbToken=" + str;
        this.mbfbToken = str;
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putString("token", str);
        edit.apply();
    }
}
