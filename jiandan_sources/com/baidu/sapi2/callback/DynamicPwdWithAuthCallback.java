package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.DynamicPwdWithAuthResult;

public abstract class DynamicPwdWithAuthCallback implements CaptchaAware<DynamicPwdWithAuthResult>, NoProguard {
    public void onCaptchaRequired(DynamicPwdWithAuthResult dynamicPwdWithAuthResult) {
    }

    public void onFinish() {
    }

    public abstract void onSendAuthSms();

    public void onStart() {
    }
}
