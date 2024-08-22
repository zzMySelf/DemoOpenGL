package com.baidu.searchbox.home.adjust;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import org.json.JSONException;

public class KeyboardAdjustListener extends AbstractCommandListener<KeyboardAdjustModel> {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String DEFAULT_VERSION = "0";
    public static final String KEYBOARD_ADJUST_ACTION = "keyboard_adjust";
    private static final String KEYBOARD_ADJUST_VERSION = "keyboard_adjust_v";
    private static final String TAG = "KeyboardAdjustListener";
    public static final String ZERO = "0";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        String localVersion = getLocalVersion(context, module, action);
        if (!(postData == null || postData.getVersion() == null)) {
            postData.getVersion().put(KEYBOARD_ADJUST_ACTION, localVersion);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "post data version. === " + postData.getVersion());
            }
        }
        if (DEBUG) {
            Log.v(TAG, "KeyboardAdjustListener request params: keyboard_adjust=" + localVersion);
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<KeyboardAdjustModel> value) {
        if (DEBUG) {
            Log.d(TAG, "KeyboardAdjustListener action is : " + action);
        }
        if (value == null || !TextUtils.equals(action, KEYBOARD_ADJUST_ACTION)) {
            return false;
        }
        PreferenceUtils.setString(KEYBOARD_ADJUST_VERSION, value.version);
        KeyboardAdjustModel keyboardAdjustModel = (KeyboardAdjustModel) value.data;
        if (keyboardAdjustModel == null) {
            setSwitch(true);
            return true;
        }
        setSwitch(!TextUtils.equals(keyboardAdjustModel.auth, "0"));
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return PreferenceUtils.getString(KEYBOARD_ADJUST_VERSION, "0");
    }

    private void setSwitch(boolean value) {
        QuickPersistConfig.getInstance().putBoolean(QuickPersistConfigConst.KEY_MAINACTIVITY_INPUTMODE_ADJUSTPAN, value);
    }
}
