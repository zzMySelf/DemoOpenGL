package com.baidu.sapi2.views.logindialog.interf;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.GetDynamicPwdResult;

public interface ISendSmsCallback extends NoProguard {
    void onSendSmsFailure(String str, GetDynamicPwdResult getDynamicPwdResult);

    void onSendSmsSuccess(boolean z, String str, GetDynamicPwdResult getDynamicPwdResult);
}
