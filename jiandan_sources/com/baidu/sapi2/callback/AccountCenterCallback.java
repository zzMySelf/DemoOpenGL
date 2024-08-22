package com.baidu.sapi2.callback;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.result.AccountCenterResult;

public abstract class AccountCenterCallback {
    public void onBdussChange() {
    }

    public abstract void onFinish(AccountCenterResult accountCenterResult);

    public void onJumpTo(String str) {
    }

    public void onOpenDuVipPay(LoadDuVipPayCallBack loadDuVipPayCallBack) {
    }

    public abstract void onSocialBind(String str);

    public void onSyncAccount(SapiAccount sapiAccount) {
    }

    public void onUnbindThirdAccount(String str) {
    }

    public boolean shouldOverrideOpenCustomerService(Context context) {
        return false;
    }
}
