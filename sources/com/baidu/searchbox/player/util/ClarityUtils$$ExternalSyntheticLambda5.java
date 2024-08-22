package com.baidu.searchbox.player.util;

import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.player.model.ClarityUrlList;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ClarityUtils$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ BoxAccountManager f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ ClarityUrlList.ClarityUrl f$2;

    public /* synthetic */ ClarityUtils$$ExternalSyntheticLambda5(BoxAccountManager boxAccountManager, Function1 function1, ClarityUrlList.ClarityUrl clarityUrl) {
        this.f$0 = boxAccountManager;
        this.f$1 = function1;
        this.f$2 = clarityUrl;
    }

    public final void run() {
        ClarityUtils.m2420loginToSwitchClarity$lambda13$lambda12(this.f$0, this.f$1, this.f$2);
    }
}
