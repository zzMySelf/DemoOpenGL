package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;

public class GetDynamicPwdResult extends SapiResult implements NoProguard {
    public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
    public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
    public static final int RESULT_CODE_CAPTCHA_REQUIRED = 5;
    public static final int RESULT_CODE_GET_DPASS_FREQUENTLY = 4;
    public static final int RESULT_CODE_USERINFO_NOT_EXIST = 12;
    public static final String RESULT_MSG_SUCCESS = "动态密码发送成功";
    public boolean noNeedBack;
    public int smsCodeLength;

    public GetDynamicPwdResult() {
        this.msgMap.put(0, "动态密码发送成功");
        this.msgMap.put(-101, "请输入手机号");
    }
}
