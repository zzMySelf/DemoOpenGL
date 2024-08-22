package com.baidu.sapi2.views.logindialog.bean;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;

public class QuickLoginResult extends SapiResult implements NoProguard {
    public QuickLoginType mLoginType;
    public String mOperator;
}
