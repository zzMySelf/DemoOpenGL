package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;

public class DynamicPwdLoginResult extends SapiResult implements NoProguard {
    public static final int ERROR_CODE_EMPTY_DYNAMIC_PWD = -102;
    public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
    public static final String ERROR_MSG_EMPTY_DYNAMIC_PWD = "请输入动态密码";
    public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
    public static final String RESULT_MSG_SUCCESS = "登录成功";
    public boolean noNeedBack;
    public SapiAccount session;

    public DynamicPwdLoginResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-101, "请输入手机号");
        this.msgMap.put(-102, "请输入动态密码");
    }
}
