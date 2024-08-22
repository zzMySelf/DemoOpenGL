package com.baidu.tts.audiouploader;

import java.util.HashMap;

public final class CtrError {
    public static final int ERROR_AUDIO_RECORDER_BUSY = 1005;
    public static final int ERROR_AUDIO_RECORDER_READ = 1004;
    public static final int ERROR_ENVDETECT_EXCEPTION = 2001;
    public static final int ERROR_IS_BUSY = 2002;
    public static final int ERROR_NETWORK_DISCONNECT = 3006;
    public static final int ERROR_NETWORK_FAIL_CONNECT = 3002;
    public static final int ERROR_NETWORK_FAIL_READ = 3004;
    public static final int ERROR_NETWORK_FAIL_SEND = 3005;
    public static final int ERROR_NETWORK_NOT_AVAILABLE = 3001;
    public static final int ERROR_NETWORK_TIMEOUT_CONNECT = 3003;
    public static final int ERROR_RECORDER_INIT_FAILED = 1003;
    public static final int ERROR_RECORDER_NO_PERMISSION = 1002;
    public static final int ERROR_RECORDER_UNAVAILABLE = 1001;
    public static final int ERROR_SERVER_CALLBACK = 4001;
    static HashMap<Integer, String> sErrorMap;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        sErrorMap = hashMap;
        hashMap.put(1001, "Recorder is not available");
        sErrorMap.put(1003, "Recorder init failed");
        sErrorMap.put(1002, "No audio recorder permission");
        sErrorMap.put(1004, "Audio recorder read fail");
        sErrorMap.put(1005, "Audio recorder is busy");
        sErrorMap.put(2001, "Environment detect exception");
        sErrorMap.put(2002, "Is running and busy");
        sErrorMap.put(3001, "Network is not available");
        sErrorMap.put(3002, "Network connect  filed");
        sErrorMap.put(3003, "Network connect timeout");
        sErrorMap.put(3004, "Network read data failed");
        sErrorMap.put(3005, "Network send data failed");
        sErrorMap.put(3006, "Network is abnormal disconnect");
        sErrorMap.put(4001, "Server callback error");
    }

    public static String getDescFromCode(int code) {
        return sErrorMap.get(Integer.valueOf(code));
    }

    public static TimbreRecorderError getTrError(int code) {
        return getTrError(code, getDescFromCode(code));
    }

    public static TimbreRecorderError getTrError(int code, String detailMessage) {
        return getTrError(code, detailMessage, (Throwable) null);
    }

    public static TimbreRecorderError getTrError(int code, String detailMessage, Throwable throwable) {
        TimbreRecorderError mTrError = new TimbreRecorderError();
        mTrError.setCode(code);
        mTrError.setMessage(getDescFromCode(code));
        mTrError.setDetailMessage(detailMessage);
        mTrError.setThrowable(throwable);
        return mTrError;
    }
}
