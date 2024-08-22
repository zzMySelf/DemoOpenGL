package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;

public class DynamicPwdWithAuthResult extends SapiResult implements NoProguard {
    public static final int ERROR_CODE_EMPTY_DYNAMIC_PWD = -102;
    public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
    public static final int ERROR_CODE_LOOPER_FAILUREL = -302;
    public static final int ERROR_CODE_LOOPER_USER_CANCEL = -301;
    public static final String ERROR_MSG_EMPTY_DYNAMIC_PWD = "请输入动态密码";
    public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
    public static final String ERROR_MSG_LOOPER_FAILUREL = "授权登录失败";
    public static final String ERROR_MSG_LOOPER_USER_CANCEL = "您已取消授权";
    public static final String RESULT_MSG_SUCCESS = "动态密码发送成功";
    public boolean isSmsAuthLogin;
    public boolean noNeedBack;
    public SapiAccount session;
    public int smsCodeLength;

    public DynamicPwdWithAuthResult() {
        this.msgMap.put(0, "动态密码发送成功");
        this.msgMap.put(-101, "请输入手机号");
        this.msgMap.put(-102, "请输入动态密码");
        this.msgMap.put(-301, ERROR_MSG_LOOPER_USER_CANCEL);
        this.msgMap.put(-302, ERROR_MSG_LOOPER_FAILUREL);
    }
}
