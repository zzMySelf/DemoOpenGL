package com.baidu.sapi2.result;

public class LoadQrUrlResult extends SapiResult {
    public static final int ERROR_CODE_HANDLE_LOGIN = -10001;
    public static final int ERROR_CODE_LOGIN_SUCCESS = -10002;
    public static final String ERROR_MSG_HANDLE_LOGIN = "请登录";
    public static final String ERROR_MSG_LOGIN_SUCCESS = "获取登录态成功";
    public boolean isAccountDestory = false;

    public LoadQrUrlResult() {
        this.msgMap.put(-10001, "请登录");
        this.msgMap.put(-10002, "获取登录态成功");
    }
}
