package com.baidu.mms.voicesearch.mmsvoicesearchv2.model.utils;

import android.content.Context;
import com.baidu.mms.voicesearch.api.VoiceSearchManager;
import com.baidu.mms.voicesearch.voice.common.FileUtil;
import com.baidu.mms.voicesearch.voice.common.NewConfigCommonKt;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.voicesearch.component.utils.TaskDispatcher;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010\u0012\u001a\u00020\u0005\u001a\u0010\u0010\u0013\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u0010\u0010\u0014\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\b\u0010\u0015\u001a\u00020\u0011H\u0002\u001a\u0006\u0010\u0016\u001a\u00020\u0011\u001a\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"MICRO_PHONE_IN_FILE", "", "MICRO_PHONE_RETRY_FILE", "TAG", "VOICE_NEED_RETRY_STATUS_NO", "", "VOICE_NEED_RETRY_STATUS_YES", "VOICE_RETRY_READY_KEY", "VOICE_SP_KEY_RETRY_GUIDE_COUNT", "VOICE_SP_KEY_RETRY_GUIDE_START_TIME", "addRetryCount", "", "copyRetryFileAndSetStatus", "context", "Landroid/content/Context;", "errorCode", "copyRetryFileByErrorCode", "", "getIsNeedRetry", "getSpeechMicInFilePath", "getSpeechMicRetryPath", "isRetryFileReady", "isSpeechMicInFileReady", "resetRetryFile", "setIsNeedRetry", "needRetry", "lib-speech-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceRetryHelper.kt */
public final class VoiceRetryHelperKt {
    public static final String MICRO_PHONE_IN_FILE = "mms/micro_phone_infile.pcm";
    public static final String MICRO_PHONE_RETRY_FILE = "mms/micro_phone_infile_retry.pcm";
    private static final String TAG = "VoiceRetryHelper";
    public static final int VOICE_NEED_RETRY_STATUS_NO = 0;
    public static final int VOICE_NEED_RETRY_STATUS_YES = 1;
    public static final String VOICE_RETRY_READY_KEY = "reconnect";
    private static final String VOICE_SP_KEY_RETRY_GUIDE_COUNT = "voice_retry_count";
    private static final String VOICE_SP_KEY_RETRY_GUIDE_START_TIME = "voice_retry_guide_time";

    public static final String getSpeechMicInFilePath(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "mms/micro_phone_infile.pcm";
    }

    public static final String getSpeechMicRetryPath(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + MICRO_PHONE_RETRY_FILE;
    }

    private static final boolean isRetryFileReady() {
        File retryFile = new File(getSpeechMicRetryPath(VoiceSearchManager.getApplicationContext()));
        return retryFile.exists() && retryFile.length() > 0;
    }

    public static final boolean isSpeechMicInFileReady() {
        File retryFile = new File(getSpeechMicInFilePath(VoiceSearchManager.getApplicationContext()));
        return retryFile.exists() && retryFile.length() > 0;
    }

    public static final void copyRetryFileAndSetStatus(Context context, String errorCode) {
        TaskDispatcher.getSharedInstance().addToAsyncWorkingLoop(new VoiceRetryHelperKt$copyRetryFileAndSetStatus$1(context, errorCode));
    }

    public static final boolean copyRetryFileByErrorCode(Context context, String errorCode) {
        if (!VoiceErrorHelperKt.isNetErrorByCode(errorCode) && !VoiceErrorHelperKt.isNetTimeoutByCode(errorCode)) {
            return false;
        }
        File oldFile = new File(getSpeechMicInFilePath(context));
        File newFile = new File(getSpeechMicRetryPath(context));
        if (!oldFile.exists()) {
            return false;
        }
        if (!newFile.exists() || oldFile.length() != newFile.length()) {
            return FileUtil.copyFile(getSpeechMicInFilePath(context), getSpeechMicRetryPath(context));
        }
        return true;
    }

    public static final void resetRetryFile(Context context) {
        TaskDispatcher.getSharedInstance().addToAsyncWorkingLoop(new VoiceRetryHelperKt$resetRetryFile$1(context));
    }

    public static final void setIsNeedRetry(int needRetry) {
        if (needRetry == 1) {
            QuickPersistConfig.getInstance().putLong(VOICE_SP_KEY_RETRY_GUIDE_START_TIME, System.currentTimeMillis());
            QuickPersistConfig.getInstance().putInt(VOICE_SP_KEY_RETRY_GUIDE_COUNT, 0);
            return;
        }
        QuickPersistConfig.getInstance().remove(VOICE_SP_KEY_RETRY_GUIDE_START_TIME);
        QuickPersistConfig.getInstance().remove(VOICE_SP_KEY_RETRY_GUIDE_COUNT);
    }

    public static final int getIsNeedRetry() {
        long currTime = System.currentTimeMillis();
        long lastTime = QuickPersistConfig.getInstance().getLong(VOICE_SP_KEY_RETRY_GUIDE_START_TIME, 0);
        int count = QuickPersistConfig.getInstance().getInt(VOICE_SP_KEY_RETRY_GUIDE_COUNT, 0);
        String str = "5";
        String string = QuickPersistConfig.getInstance().getString(NewConfigCommonKt.NEW_CONFIG_RETRY_DURATION, str);
        if (string != null) {
            str = string;
        }
        String durationHourStr = str;
        String str2 = "3";
        String string2 = QuickPersistConfig.getInstance().getString(NewConfigCommonKt.NEW_CONFIG_RETRY_NUM, str2);
        if (string2 != null) {
            str2 = string2;
        }
        String confNumStr = str2;
        int durationHour = 5;
        int confNum = 3;
        try {
            durationHour = Integer.parseInt(durationHourStr);
            confNum = Integer.parseInt(confNumStr);
        } catch (Exception e2) {
        }
        if (currTime - lastTime <= ((long) (3600000 * durationHour)) && count < confNum && isRetryFileReady()) {
            return 1;
        }
        return 0;
    }

    public static final void addRetryCount() {
        QuickPersistConfig.getInstance().putInt(VOICE_SP_KEY_RETRY_GUIDE_COUNT, QuickPersistConfig.getInstance().getInt(VOICE_SP_KEY_RETRY_GUIDE_COUNT, 0) + 1);
    }
}
