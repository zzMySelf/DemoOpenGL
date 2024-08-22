package com.baidu.sofire.xclient.privacycontrol.ui;

import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;

public class PassWebAuthListener extends WebAuthListener {
    public IDoubleListCallBack mCallBack;

    public PassWebAuthListener(IDoubleListCallBack iDoubleListCallBack) {
        this.mCallBack = iDoubleListCallBack;
    }

    public void onFailure(WebAuthResult webAuthResult) {
        IDoubleListCallBack iDoubleListCallBack = this.mCallBack;
        if (iDoubleListCallBack != null) {
            iDoubleListCallBack.onLoginFail(webAuthResult);
        }
    }

    public void onSuccess(WebAuthResult webAuthResult) {
        IDoubleListCallBack iDoubleListCallBack = this.mCallBack;
        if (iDoubleListCallBack != null) {
            iDoubleListCallBack.onLoginSuccess(webAuthResult);
        }
    }
}
