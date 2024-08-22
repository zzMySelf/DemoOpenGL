package com.baidu.browser.components.activeask.utils;

import android.view.ViewGroup;
import com.baidu.browser.components.activeask.model.ActiveAskCardData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActiveAskManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ActiveAskManager f$0;
    public final /* synthetic */ ViewGroup f$1;
    public final /* synthetic */ ActiveAskCardData f$2;

    public /* synthetic */ ActiveAskManager$$ExternalSyntheticLambda2(ActiveAskManager activeAskManager, ViewGroup viewGroup, ActiveAskCardData activeAskCardData) {
        this.f$0 = activeAskManager;
        this.f$1 = viewGroup;
        this.f$2 = activeAskCardData;
    }

    public final void run() {
        ActiveAskManager.m12637mutexShow$lambda2(this.f$0, this.f$1, this.f$2);
    }
}
