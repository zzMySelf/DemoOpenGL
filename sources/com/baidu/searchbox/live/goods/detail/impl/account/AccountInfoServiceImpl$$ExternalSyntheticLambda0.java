package com.baidu.searchbox.live.goods.detail.impl.account;

import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.live.goods.detail.interfaces.account.IAccountManagerService;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AccountInfoServiceImpl$$ExternalSyntheticLambda0 implements ILoginResultListener {
    public final /* synthetic */ IAccountManagerService.LoginResultListener f$0;

    public /* synthetic */ AccountInfoServiceImpl$$ExternalSyntheticLambda0(IAccountManagerService.LoginResultListener loginResultListener) {
        this.f$0 = loginResultListener;
    }

    public final void onResult(int i2) {
        AccountInfoServiceImpl.m122login$lambda0(this.f$0, i2);
    }
}
