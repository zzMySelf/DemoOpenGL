package com.baidu.sapi2.views.logindialog.interf;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;

public interface ILoginConfirmCallback extends NoProguard {
    void onFailure(QuickLoginResult quickLoginResult);

    void onPostLogin(boolean z, Runnable runnable);

    void onSuccess(QuickLoginResult quickLoginResult);
}
