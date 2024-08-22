package com.baidu.searchbox.player.util;

import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.player.model.ClarityUrlList;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ClarityUtils$$ExternalSyntheticLambda3 implements ILoginResultListener {
    public final /* synthetic */ BoxAccountManager f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ ClarityUrlList.ClarityUrl f$2;
    public final /* synthetic */ LoginParams f$3;
    public final /* synthetic */ ILoginResultListener f$4;

    public /* synthetic */ ClarityUtils$$ExternalSyntheticLambda3(BoxAccountManager boxAccountManager, Function1 function1, ClarityUrlList.ClarityUrl clarityUrl, LoginParams loginParams, ILoginResultListener iLoginResultListener) {
        this.f$0 = boxAccountManager;
        this.f$1 = function1;
        this.f$2 = clarityUrl;
        this.f$3 = loginParams;
        this.f$4 = iLoginResultListener;
    }

    public final void onResult(int i2) {
        ClarityUtils.m2417login$lambda15(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, i2);
    }
}
