package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.SmsLoginLooperResult;

public abstract class SmsLoginLooperCallback implements NoProguard {
    public abstract void onFailure(SmsLoginLooperResult smsLoginLooperResult);

    public abstract void onLoginDone(SmsLoginLooperResult smsLoginLooperResult);

    public abstract void onOpenAuthDone(SmsLoginLooperResult smsLoginLooperResult);

    public abstract void onUserCancel(SmsLoginLooperResult smsLoginLooperResult);
}
