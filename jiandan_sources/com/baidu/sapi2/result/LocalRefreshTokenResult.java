package com.baidu.sapi2.result;

public class LocalRefreshTokenResult extends SapiResult {
    public static final int RESULT_CODE_NO_CACHE = -401;
    public static final String RESULT_MSG_NO_CACHE = "本地无缓存";
    public static final String RESULT_MSG_SUCCESS = "成功";
    public static final String TAG = "LocalRefreshTokenResult";
    public String refreshToken;

    public LocalRefreshTokenResult() {
        this.msgMap.put(0, "成功");
        this.msgMap.put(-401, RESULT_MSG_NO_CACHE);
    }
}
