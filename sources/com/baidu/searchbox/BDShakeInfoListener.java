package com.baidu.searchbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.shake.update.tool.DebugShakeUtils;
import org.json.JSONException;

public class BDShakeInfoListener extends AbstractCommandListener<BDShakeInfoModel> {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String DEFAULT_VERSION = "0";
    public static final String KEY_SHAKE_SECOND_MAX_COUNT = "key_shake_second_max_count";
    public static final String KEY_SHAKE_SECOND_SWITCH = "key_shake_second_switch";
    public static final String KEY_SHAKE_SECOND_THRESHOLD = "key_shake_second_threshold";
    public static final String KEY_SHAKE_SECOND_TIME_INTERVAL = "key_shake_second_time_interval";
    public static final String KEY_SHAKE_THRESHOLD = "shake_threshold_key";
    public static final String OFFLINE_VERSION = "-1";
    public static final String SHAKE_INFO = "shakeInfo";
    public static final String SHAKE_INFO_ACTION = "shake_info";
    public static final String SHAKE_INFO_VERSION = "shake_info_v";
    private static final String TAG = "BDShakeInfoListener";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        String localVersion = getLocalVersion(context, module, action);
        if (!(postData == null || postData.getVersion() == null)) {
            postData.getVersion().put(SHAKE_INFO_ACTION, localVersion);
        }
        if (DEBUG) {
            Log.v(TAG, "BDShakeInfoListener request params: shake_info=" + localVersion);
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<BDShakeInfoModel> value) {
        if (value == null || !TextUtils.equals(action, SHAKE_INFO_ACTION)) {
            ShakeStatistics.ubc(ShakeStatistics.SHAKEINFO, "parameter", "value == null || value.data == null");
            return false;
        }
        String netVersion = value.version;
        if (TextUtils.isEmpty(netVersion)) {
            ShakeStatistics.ubc(ShakeStatistics.SHAKEINFO, "parameter", "netVersion=" + netVersion);
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "executeCommand: " + value.data);
        }
        String localVersion = getLocalVersion(context, module, action);
        BDShakeInfoModel model = (BDShakeInfoModel) value.data;
        if (model != null) {
            DebugShakeUtils.log("shakeinfo update =" + model.toString());
        }
        if (isOffline(netVersion)) {
            PreferenceUtils.setString(SHAKE_INFO_VERSION, netVersion);
            doStandardOffline();
            doSecondOffline();
            ShakeStatistics.ubc(ShakeStatistics.SHAKEINFO, "offline", "netVersion=" + netVersion + " model=" + (model == null ? "null" : model.toString()) + " isOffline()");
            return true;
        } else if (model == null) {
            ShakeStatistics.ubc(ShakeStatistics.SHAKEINFO, "parameter", "netVersion=" + netVersion + " model=null");
            return false;
        } else if (TextUtils.equals(netVersion, localVersion)) {
            return false;
        } else {
            processData(model);
            PreferenceUtils.setString(SHAKE_INFO_VERSION, netVersion);
            return true;
        }
    }

    private boolean processData(BDShakeInfoModel model) {
        if (model == null || TextUtils.isEmpty(model.threshold)) {
            return false;
        }
        doStandardParse(model);
        doSecondParse(model);
        return true;
    }

    private boolean doStandardParse(BDShakeInfoModel model) {
        if (model == null || TextUtils.isEmpty(model.threshold)) {
            return false;
        }
        try {
            float stdThreshold = Float.parseFloat(model.threshold);
            PreferenceUtils.setFloat(KEY_SHAKE_THRESHOLD, stdThreshold);
            BDShakeManager.getInstance().setThreshold(stdThreshold);
            return true;
        } catch (Exception e2) {
            if (!AppConfig.isDebug()) {
                BDShakeManager.getInstance().resetThreshold();
                return false;
            }
            throw new DebugException("BDShakeInfoListener.doStandardParse() fail model=" + model.toString());
        }
    }

    private boolean doSecondParse(BDShakeInfoModel model) {
        if (model == null) {
            return false;
        }
        if (TextUtils.isEmpty(model.secondThreshold) || TextUtils.isEmpty(model.secondTimeInterval) || TextUtils.isEmpty(model.secondMaxCount)) {
            doSecondOffline();
            return true;
        }
        String sThreshold = model.secondThreshold;
        String sTimeInterval = model.secondTimeInterval;
        String sMaxCount = model.secondMaxCount;
        try {
            float secondThreshold = Float.parseFloat(sThreshold);
            long secondTimeInterval = Long.parseLong(sTimeInterval);
            int secondMaxCount = Integer.parseInt(sMaxCount);
            if (!BDShakeManager.getInstance().verifyLowerParams(secondThreshold, secondMaxCount, secondTimeInterval)) {
                doSecondOffline();
                return true;
            }
            PreferenceUtils.setBoolean(KEY_SHAKE_SECOND_SWITCH, true);
            PreferenceUtils.setFloat(KEY_SHAKE_SECOND_THRESHOLD, secondThreshold);
            PreferenceUtils.setInt(KEY_SHAKE_SECOND_MAX_COUNT, secondMaxCount);
            PreferenceUtils.setLong(KEY_SHAKE_SECOND_TIME_INTERVAL, secondTimeInterval);
            BDShakeManager.getInstance().setSecondSwitchActive(true);
            BDShakeManager.getInstance().setLowerParams(secondThreshold, secondMaxCount, secondTimeInterval);
            return true;
        } catch (Exception e2) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            throw new DebugException("BDShakeInfoListener.doSecondParse() fail model=" + model.toString());
        }
    }

    public String getLocalVersion(Context context, String module, String action) {
        return PreferenceUtils.getString(SHAKE_INFO_VERSION, "0");
    }

    private boolean isOffline(String version) {
        return TextUtils.equals("-1", version);
    }

    private void doStandardOffline() {
        BDShakeManager.getInstance().resetThreshold();
        PreferenceUtils.removeKey(KEY_SHAKE_THRESHOLD);
    }

    private void doSecondOffline() {
        BDShakeManager.getInstance().setSecondSwitchActive(false);
        PreferenceUtils.setBoolean(KEY_SHAKE_SECOND_SWITCH, false);
        PreferenceUtils.setFloat(KEY_SHAKE_SECOND_THRESHOLD, 0.0f);
        PreferenceUtils.setInt(KEY_SHAKE_SECOND_MAX_COUNT, 0);
        PreferenceUtils.setLong(KEY_SHAKE_SECOND_TIME_INTERVAL, 0);
    }
}
