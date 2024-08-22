package com.baidu.searchbox.account.session;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.app.account.BoxAccountPreference;
import com.baidu.android.app.account.BoxAccountRuntime;
import com.baidu.android.app.account.utils.LogDescription;
import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;

public class BoxLocalSession implements BoxAccountSession {
    private static final boolean DEBUG = BoxAccountRuntime.isDebug();
    private static final String ENCODE_TAG = "local_account";
    private static final String KEY_LOCAL_SESSION_BDUSS = "local_session_bduss";
    private static final String KEY_LOCAL_SESSION_DISPLAYNAME = "local_session_displayname";
    private static final String KEY_LOCAL_SESSION_ENCODE_BDUSS = "local_session_encode_bduss";
    private static final String KEY_LOCAL_SESSION_ENCODE_PTOKEN = "local_session_encode_ptoken";
    private static final String KEY_LOCAL_SESSION_PTOKEN = "local_session_ptoken";
    private static final String KEY_LOCAL_SESSION_STOKEN = "local_session_stoken";
    private static final String KEY_LOCAL_SESSION_UID = "local_session_uid";
    private static final String KEY_SESSION_PREF_7_3_2_UPDATED = "key_local_session_pref_7_3_2_updated";
    private static final String TAG = "BoxLocalSession";
    private Context mContext;

    public BoxLocalSession(Context context) {
        this.mContext = context.getApplicationContext();
        syncAccount();
    }

    public boolean isLogin() {
        boolean isLogin = !TextUtils.isEmpty(BoxAccountPreference.getAccountStringPreference(KEY_LOCAL_SESSION_ENCODE_BDUSS, (String) null));
        if (DEBUG) {
            Log.i(TAG, "isLogin:" + isLogin);
        }
        return isLogin;
    }

    private boolean isOldLogin() {
        boolean isLogin = !TextUtils.isEmpty(BoxAccountPreference.getAccountStringPreference(KEY_LOCAL_SESSION_BDUSS, (String) null));
        if (DEBUG) {
            Log.i(TAG, "isLogin:" + isLogin);
        }
        return isLogin;
    }

    public String getSession(String key, String defaultValue) {
        return decryptString(mapKey(key), BoxAccountPreference.getAccountStringPreference(mapKey(key), defaultValue));
    }

    public String getSession(String key) {
        return getSession(key, (String) null);
    }

    private String decryptString(String key, String value) {
        if (TextUtils.isEmpty(value)) {
            return value;
        }
        if (TextUtils.equals(key, KEY_LOCAL_SESSION_ENCODE_BDUSS) || TextUtils.equals(key, KEY_LOCAL_SESSION_ENCODE_PTOKEN)) {
            return SocialEncodeUtils.getSocialDecrypt(value, ENCODE_TAG);
        }
        return value;
    }

    public void setSesstion(BoxAccount account) {
        if (account != null) {
            BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_ENCODE_BDUSS, SocialEncodeUtils.getSocialEncryption(account.bduss, ENCODE_TAG));
            BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_UID, account.uid);
            BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_DISPLAYNAME, account.displayname);
            BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_ENCODE_PTOKEN, SocialEncodeUtils.getSocialEncryption(account.ptoken, ENCODE_TAG));
            LogUtils.writeOnlineLog(LogUtils.DATA_ID_PTOKEN, "tpl_stoken", "ptoken is null = " + TextUtils.isEmpty(account.ptoken), "local setSession", true, true, LogUtils.canUploadPtokenLog() && TextUtils.isEmpty(account.ptoken));
        }
        LogUtils.writeOnlineLog(LogDescription.EVENT_LOCAL_SESSION_CHANGES, "", "setSession", true, false);
    }

    private String mapKey(String sessionKey) {
        if (TextUtils.equals(sessionKey, "BoxAccount_bduss")) {
            return KEY_LOCAL_SESSION_ENCODE_BDUSS;
        }
        if (TextUtils.equals(sessionKey, "BoxAccount_ptoken")) {
            return KEY_LOCAL_SESSION_ENCODE_PTOKEN;
        }
        if (TextUtils.equals(sessionKey, "BoxAccount_displayname")) {
            return KEY_LOCAL_SESSION_DISPLAYNAME;
        }
        if (TextUtils.equals(sessionKey, "BoxAccount_uid")) {
            return KEY_LOCAL_SESSION_UID;
        }
        return sessionKey;
    }

    private void syncAccount() {
        if (TextUtils.isEmpty(BoxAccountPreference.getAccountStringPreference(KEY_SESSION_PREF_7_3_2_UPDATED, (String) null))) {
            if (isOldLogin()) {
                String ptoken = BoxAccountPreference.getAccountStringPreference(KEY_LOCAL_SESSION_PTOKEN, (String) null);
                String bduss = BoxAccountPreference.getAccountStringPreference(KEY_LOCAL_SESSION_BDUSS, (String) null);
                if (!TextUtils.isEmpty(ptoken)) {
                    String encodPtoken = SocialEncodeUtils.getSocialEncryption(ptoken, ENCODE_TAG);
                    LogUtils.writeOnlineLog(LogUtils.DATA_ID_PTOKEN, "tpl_stoken", "ptoken is null = " + TextUtils.isEmpty(ptoken), "syncAccount", false, true, LogUtils.canUploadPtokenLog() && TextUtils.isEmpty(ptoken));
                    BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_ENCODE_PTOKEN, encodPtoken);
                    BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_PTOKEN, (String) null);
                }
                if (!TextUtils.isEmpty(bduss)) {
                    BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_ENCODE_BDUSS, SocialEncodeUtils.getSocialEncryption(bduss, ENCODE_TAG));
                    BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_BDUSS, (String) null);
                }
                BoxAccountPreference.setAccountStringPreference(KEY_LOCAL_SESSION_STOKEN, (String) null);
            }
            BoxAccountPreference.setAccountStringPreference(KEY_SESSION_PREF_7_3_2_UPDATED, "updated");
        }
    }
}
