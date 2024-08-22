package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;

public class ValidateWithHaoKanResult extends SapiResult implements NoProguard {
    public static final int ERROR_CODE_BDUSS_EMPTY = -101;
    public static final int ERROR_CODE_IS_NOT_INIT = -104;
    public static final int ERROR_CODE_PACKAGE_ERROR = -103;
    public static final int ERROR_CODE_PASS_LOGIN = -102;
    public static final int ERROR_CODE_PTOKEN_IS_EMPTY = -105;
    public static final String ERROR_MSG_BDUSS_EMPTY = "BDUSS EMPTY";
    public static final String ERROR_MSG_IS_NOT_INIT = "Pass SDK未初始化";
    public static final String ERROR_MSG_PACKAGE_ERROR = "包名验证不通过";
    public static final String ERROR_MSG_PASS_LOGIN = "Pass 登录态不为空";
    public static final String ERROR_MSG_PTOKEN_IS_EMPTY = "cookie中 ptoken为空";
    public static final String ERROR_MSG_UNKNOWN = "登录失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 400021;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";

    public ValidateWithHaoKanResult() {
        this.msgMap.put(400021, "用户登录状态失效，请重新登录");
        this.msgMap.put(-101, "BDUSS EMPTY");
        this.msgMap.put(-102, ERROR_MSG_PASS_LOGIN);
        this.msgMap.put(-103, ERROR_MSG_PACKAGE_ERROR);
        this.msgMap.put(-104, "Pass SDK未初始化");
        this.msgMap.put(-105, ERROR_MSG_PTOKEN_IS_EMPTY);
        this.msgMap.put(-202, "登录失败");
    }
}
