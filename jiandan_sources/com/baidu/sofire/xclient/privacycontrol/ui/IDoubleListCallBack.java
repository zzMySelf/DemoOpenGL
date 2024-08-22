package com.baidu.sofire.xclient.privacycontrol.ui;

import com.baidu.sapi2.shell.result.WebAuthResult;

public interface IDoubleListCallBack {
    void onLoginFail(WebAuthResult webAuthResult);

    void onLoginSuccess(WebAuthResult webAuthResult);

    void onPassNotInit();
}
