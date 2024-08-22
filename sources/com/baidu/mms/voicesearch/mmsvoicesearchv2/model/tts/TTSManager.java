package com.baidu.mms.voicesearch.mmsvoicesearchv2.model.tts;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mms.voicesearch.voice.common.NewConfigCommonKt;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.speechbundle.R;
import com.baidu.voicesearch.component.common.SharedPreferenceUtil;
import com.baidu.voicesearch.component.voice.BluetoothSCOConnectionManager;

public class TTSManager {
    public static final int BROADCAST_CLOSE_ALL = 0;
    public static final int BROADCAST_JUST_EARPHONE = 2;
    public static final int BROADCAST_OPEN_ALL = 1;
    public static final String KEY_TTS_NEW_STATUS = "tts_status";
    public static final String KEY_TTS_SWITCH = "tts_switch";
    public static final String KEY_TTS_SWITCH_HINT = "tts_switch_hint";
    private static final String TAG = "TTSManager";
    public static final boolean TTS_SWITCH_DEFAULT_VALUE = false;
    private static TTSManager instance = new TTSManager();

    public static TTSManager getInstance() {
        return instance;
    }

    public void setTTSHint(Context context, String hint) {
        if (context != null && hint != null) {
            SharedPreferenceUtil.saveDataToSharedPreference(context, KEY_TTS_SWITCH_HINT, hint);
        }
    }

    public void clearTTSHint(Context context) {
        if (context != null) {
            SharedPreferenceUtil.removeDataToSharedPreference(context, KEY_TTS_SWITCH_HINT);
        }
    }

    public String getTTSHint(Context context) {
        if (context == null) {
            return "";
        }
        String hint = SharedPreferenceUtil.getDataFromSharedPreference(context, KEY_TTS_SWITCH_HINT, "");
        if (TextUtils.isEmpty(hint)) {
            return context.getResources().getString(R.string.mms_voice_voicebroadcast_hint);
        }
        return hint;
    }

    public void setTTSEnable(Context context, boolean isEnable) {
        if (context == null) {
            return;
        }
        if (isEnable) {
            SharedPreferenceUtil.saveDataToSharedPreference(context, "tts_status", 1);
        } else {
            SharedPreferenceUtil.saveDataToSharedPreference(context, "tts_status", 0);
        }
    }

    public void setTTSStatus(Context context, int ttsStatus) {
        if (context != null) {
            SharedPreferenceUtil.saveDataToSharedPreference(context, "tts_status", Integer.valueOf(ttsStatus));
        }
    }

    public boolean getTTSEnable(Context context) {
        if (context == null) {
            return false;
        }
        if (SharedPreferenceUtil.isContain(context, "tts_switch")) {
            boolean isEnable = SharedPreferenceUtil.getDataFromSharedPreference(context, "tts_switch", false);
            SharedPreferenceUtil.removeDataToSharedPreference(context, "tts_switch");
            if (!isEnable) {
                setTTSStatus(context, 2);
                return BluetoothSCOConnectionManager.INSTANCE.hasEarphoneLinked();
            }
            setTTSStatus(context, 1);
            return true;
        } else if (!SharedPreferenceUtil.isContain(context, "tts_status")) {
            if (isTtsDefaultOpen()) {
                setTTSStatus(context, 1);
            } else {
                setTTSStatus(context, 2);
            }
            return BluetoothSCOConnectionManager.INSTANCE.hasEarphoneLinked();
        } else {
            int result = SharedPreferenceUtil.getDataFromSharedPreference(context, "tts_status", 2);
            if (result == 0) {
                return false;
            }
            if (result == 1) {
                return true;
            }
            return BluetoothSCOConnectionManager.INSTANCE.hasEarphoneLinked();
        }
    }

    public int getTTSStatus(Context context) {
        if (context == null) {
            return 2;
        }
        if (SharedPreferenceUtil.isContain(context, "tts_switch")) {
            boolean isEnable = SharedPreferenceUtil.getDataFromSharedPreference(context, "tts_switch", false);
            SharedPreferenceUtil.removeDataToSharedPreference(context, "tts_switch");
            if (!isEnable) {
                setTTSStatus(context, 2);
                return 2;
            }
            setTTSStatus(context, 1);
            return 1;
        } else if (SharedPreferenceUtil.isContain(context, "tts_status")) {
            return SharedPreferenceUtil.getDataFromSharedPreference(context, "tts_status", 2);
        } else {
            setTTSStatus(context, 2);
            return 2;
        }
    }

    public boolean isTtsDefaultOpen() {
        return "1".equals(QuickPersistConfig.getInstance().getString(NewConfigCommonKt.NEW_CONFIG_TTS_DEFAULT_OPEN, "0"));
    }
}
