package com.baidu.mms.voicesearch.voice.lightapp;

public interface VoiceSearchLightAppCallBack {
    public static final int CALL_BACK_CODE_FORBIDDEN_PATH = 4;
    public static final int CALL_BACK_CODE_SUCCESS = 0;
    public static final int CALL_BACK_CODE_UNKNOWN_ERROR = 1;
    public static final int CALL_BACK_CODE_USER_CANCELLED = 3;
    public static final int CALL_BACK_CODE_WRONG_PARAMETERS = 2;

    void sendLightAppResult(int i2, String str);
}
