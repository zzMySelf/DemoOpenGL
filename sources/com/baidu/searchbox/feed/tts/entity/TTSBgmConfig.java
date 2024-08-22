package com.baidu.searchbox.feed.tts.entity;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.baidu.searchbox.feed.tts.interfaces.ITTSProvider;
import com.baidu.searchbox.feed.tts.utils.FeedTTSPreferenceUtil;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.File;

public class TTSBgmConfig implements NoProGuard {
    private static final String DEFAULT_JSON = "{\"version\":0,\"default_setting\":0,\"earphone_volume_android\":0,\"speaker_volume_android\":0,\"local_path\":\"\"}";
    private static final String PREF_TTS_BG_MUSIC = "prefs_ttsBgMusic";
    private static final String TAG = "TTSBgmConfig";
    private static String configInfo;
    private static TTSBgmConfig instance;
    @SerializedName("local_path")
    private String bgmFilePath;
    @SerializedName("earphone_volume_android")
    private float earphoneVolume;
    @SerializedName("default_setting")
    private int isBgmOpen;
    private String md5;
    private String name;
    private boolean showEnter;
    @SerializedName("speaker_volume_android")
    private float speakerVolume;
    private int version;

    private TTSBgmConfig() {
    }

    public static synchronized TTSBgmConfig getInstance() {
        TTSBgmConfig tTSBgmConfig;
        Class cls = TTSBgmConfig.class;
        synchronized (cls) {
            if (instance == null) {
                configInfo = FeedTTSPreferenceUtil.getString(PREF_TTS_BG_MUSIC, ITTSProvider.AB_VALUE_MUSIC_TTS_DEFAULT);
                if (TTSRuntime.DEBUG) {
                    Log.d(TAG, "getInstance " + configInfo);
                }
                if (TextUtils.isEmpty(configInfo)) {
                    instance = new TTSBgmConfig();
                } else {
                    try {
                        instance = (TTSBgmConfig) new Gson().fromJson(configInfo, cls);
                    } catch (Exception e2) {
                        instance = new TTSBgmConfig();
                        e2.printStackTrace();
                    }
                }
            }
            tTSBgmConfig = instance;
        }
        return tTSBgmConfig;
    }

    private void saveModifyToSP() {
        String json = new Gson().toJson((Object) instance);
        if (TTSRuntime.DEBUG) {
            Log.d(TAG, "saveModifyToSP " + json);
        }
        configInfo = json;
        FeedTTSPreferenceUtil.putString(PREF_TTS_BG_MUSIC, json);
    }

    public void resetConfig(String md52, int version2, String localPath, String name2) {
        this.md5 = md52;
        this.version = version2;
        this.bgmFilePath = localPath;
        this.name = name2;
        this.showEnter = true;
        saveModifyToSP();
    }

    public void setCurrentVolume(float volume) {
        if (TTSRuntime.getInstance().isHeadsetOn()) {
            this.earphoneVolume = volume;
        }
        this.speakerVolume = volume;
        saveModifyToSP();
    }

    public void preInitByBgmUniteEntity(TTSBgmUniteEntity uniteEntity) {
        this.isBgmOpen = uniteEntity.defaultSetting;
        this.earphoneVolume = uniteEntity.earphoneVolume.floatValue();
        this.speakerVolume = uniteEntity.speakerVolume.floatValue();
        saveModifyToSP();
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isBgmUseful() {
        return !TextUtils.isEmpty(configInfo);
    }

    public String getBgmFilePath() {
        return this.bgmFilePath;
    }

    public boolean isBgmFileExists() {
        return !TextUtils.isEmpty(this.bgmFilePath) && new File(this.bgmFilePath).exists();
    }

    public boolean isBgmOpen() {
        return this.isBgmOpen == 1 || FeedTTSPreferenceUtil.getBoolean("spIsTTSMusic", false);
    }

    public Float getEarphoneVolume() {
        float f2 = this.earphoneVolume;
        if (f2 < 0.0f) {
            return Float.valueOf(0.3f);
        }
        if (f2 > 1.0f) {
            return Float.valueOf(1.0f);
        }
        return Float.valueOf(f2);
    }

    public Float getSpeakerVolume() {
        float f2 = this.speakerVolume;
        if (f2 < 0.0f) {
            return Float.valueOf(0.5f);
        }
        if (f2 > 1.0f) {
            return Float.valueOf(1.0f);
        }
        return Float.valueOf(f2);
    }

    public Float getCurrentVolume() {
        if (TTSRuntime.getInstance().isHeadsetOn()) {
            return getEarphoneVolume();
        }
        return getSpeakerVolume();
    }

    public String getMd5() {
        return this.md5;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "无音乐" : this.name;
    }
}
