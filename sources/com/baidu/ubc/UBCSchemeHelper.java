package com.baidu.ubc;

import android.text.TextUtils;
import com.baidu.mms.voicesearch.voice.utils.Constant;
import com.baidu.pyramid.runtime.multiprocess.AppProcessManager;
import com.heytap.mcssdk.constant.IntentConstant;
import org.json.JSONException;
import org.json.JSONObject;

public class UBCSchemeHelper {
    private static final int LOG_VERIFY_MAX_TIMEOUT = 86400;
    private long mUploadAllTimeout;
    private int mUploadPvAll;
    private int mUploadUvAll;

    private UBCSchemeHelper() {
        this.mUploadPvAll = 0;
        this.mUploadUvAll = 0;
        this.mUploadAllTimeout = 0;
        UbcSpUtil ubcSp = UbcSpUtil.getInstance();
        long timeout = ubcSp.getLong("ubc_log_verify_timeout", 0);
        if (System.currentTimeMillis() > timeout) {
            ubcSp.putInt("ubc_log_verify_pvall", 0);
            ubcSp.putInt("ubc_log_verify_uvall", 0);
            ubcSp.putLong("ubc_log_verify_timeout", 0);
            return;
        }
        this.mUploadPvAll = ubcSp.getInt("ubc_log_verify_pvall", 0);
        this.mUploadUvAll = ubcSp.getInt("ubc_log_verify_uvall", 0);
        this.mUploadAllTimeout = timeout;
    }

    private static final class Holder {
        static final UBCSchemeHelper INSTANCE = new UBCSchemeHelper();

        private Holder() {
        }
    }

    public static UBCSchemeHelper getInstance() {
        return Holder.INSTANCE;
    }

    public boolean handleLogVerifySetting(String pvAllStr, String uvAllStr, String timeoutStr, JSONObject responseData) {
        if (responseData == null || TextUtils.isEmpty(timeoutStr) || TextUtils.isEmpty(pvAllStr) || TextUtils.isEmpty(uvAllStr)) {
            return false;
        }
        try {
            if (!AppProcessManager.isServerProcess()) {
                responseData.put("msg", "Not in main process!");
                return false;
            }
            try {
                int pvAll = Integer.parseInt(pvAllStr);
                int uvAll = Integer.parseInt(uvAllStr);
                int timeout = Integer.parseInt(timeoutStr);
                if (timeout > 0) {
                    if (timeout <= 86400) {
                        setLogVerifySettings(pvAll, uvAll, timeout);
                        responseData.put("pvAll", "1");
                        responseData.put("uvAll", "1");
                        String commonParams = UBCHelper.getCommonParamUrl(Constant.COMMON_PARAMS);
                        if (!TextUtils.isEmpty(commonParams)) {
                            responseData.put("commonParam", commonParams);
                        }
                        if (TextUtils.isEmpty(BuildConfig.SDK_VERSION)) {
                            return true;
                        }
                        responseData.put(IntentConstant.SDK_VERSION, BuildConfig.SDK_VERSION);
                        return true;
                    }
                }
                responseData.put("msg", "The timeout is invalid ! The timeout should between 1 and 86400.");
                return false;
            } catch (NumberFormatException e2) {
                responseData.put("msg", "Params should be string of number!");
                return false;
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void setLogVerifySettings(int pvAll, int uvAll, int timeout) {
        this.mUploadPvAll = pvAll;
        this.mUploadUvAll = uvAll;
        this.mUploadAllTimeout = System.currentTimeMillis() + (((long) timeout) * 1000);
        UbcSpUtil ubcSp = UbcSpUtil.getInstance();
        ubcSp.putInt("ubc_log_verify_pvall", this.mUploadPvAll);
        ubcSp.putInt("ubc_log_verify_uvall", this.mUploadUvAll);
        ubcSp.putLong("ubc_log_verify_timeout", this.mUploadAllTimeout);
    }

    /* access modifiers changed from: package-private */
    public boolean canUploadPvAll() {
        return this.mUploadPvAll > 0 && System.currentTimeMillis() < this.mUploadAllTimeout;
    }

    /* access modifiers changed from: package-private */
    public boolean canUploadUvAll() {
        return this.mUploadUvAll > 0 && System.currentTimeMillis() < this.mUploadAllTimeout;
    }
}
