package com.baidu.sapi2.callback;

import com.baidu.sapi2.SapiAccount;

public abstract class GlobalCallback {
    public abstract void onLoginStatusChange();

    public void onLogoutSuccess(SapiAccount sapiAccount) {
    }

    public abstract void onNeedInitPassSdk();

    public void onValidateSuccess(SapiAccount sapiAccount) {
    }
}
