package com.baidu.searchbox.lockscreen.commandlistener;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.lockscreen.config.BubbleConfig;
import com.baidu.searchbox.lockscreen.config.ScreenOnConfig;
import com.baidu.searchbox.lockscreen.config.VoiceSearchConfig;
import com.google.gson.annotations.SerializedName;

public class LockScreenJsonData implements NoProGuard {
    @SerializedName("auto_slide")
    public boolean mAutoSlide = false;
    @SerializedName("auto_slide_interval")
    public String mAutoSlideInterval = "";
    @SerializedName("bubble")
    public BubbleConfig mBubbleConfig;
    @SerializedName("fingerprint_listen")
    public boolean mFingerprintListen = true;
    @SerializedName("interval")
    public long mInterval;
    @SerializedName("need_permission_guide")
    public boolean mNeedPermissionGuide = false;
    @SerializedName("noti_clickable")
    public boolean mNotiClickable = true;
    @SerializedName("notice")
    public String mNotice;
    @SerializedName("once_unlock")
    public boolean mOnceUnlock = true;
    @SerializedName("permission_guide_anim_cmd")
    public String mPermissionGuideAnimCmd = "";
    @SerializedName("permission_sys_setting_cmd")
    public String mPermissionSysSettingCmd = "";
    @SerializedName("register_type")
    public String mRegisterType = "";
    @SerializedName("screen_listen_mode")
    public String mScreenListenMode = "SCREEN_OFF";
    @SerializedName("keep_screen_on_duration")
    public ScreenOnConfig mScreenOnConfig;
    @SerializedName("state")
    public String mState;
    @SerializedName("lockscreen_survey_url")
    public String mSurveyUrl = "";
    @SerializedName("ubc")
    public String mUbcConfig;
    @SerializedName("user_present_listen")
    public boolean mUserPresentListen = true;
    @SerializedName("voicesearch")
    public VoiceSearchConfig mVoiceSearchConfig;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mState) && !TextUtils.isEmpty(this.mNotice);
    }

    public String toString() {
        return "state: " + this.mState + " , interval: " + this.mInterval + ", guideNotice:" + this.mNotice;
    }
}
