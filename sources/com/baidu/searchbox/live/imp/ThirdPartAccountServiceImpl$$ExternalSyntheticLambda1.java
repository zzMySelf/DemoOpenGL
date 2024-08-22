package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ThirdPartAccountServiceImpl$$ExternalSyntheticLambda1 implements ILoginResultListener {
    public final /* synthetic */ ThirdPartAccountService.LoginResultCallback f$0;

    public /* synthetic */ ThirdPartAccountServiceImpl$$ExternalSyntheticLambda1(ThirdPartAccountService.LoginResultCallback loginResultCallback) {
        this.f$0 = loginResultCallback;
    }

    public final void onResult(int i2) {
        ThirdPartAccountServiceImpl.m164showLoginDialog$lambda1(this.f$0, i2);
    }
}
