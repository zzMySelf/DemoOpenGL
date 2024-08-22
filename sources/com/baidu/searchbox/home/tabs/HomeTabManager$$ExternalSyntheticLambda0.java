package com.baidu.searchbox.home.tabs;

import com.baidu.searchbox.home.tabs.extend.IIconAnimCallBack;
import com.baidu.searchbox.home.tabs.extend.IconAnimType;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeTabManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ HomeTabManager f$0;
    public final /* synthetic */ IconAnimType f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ IIconAnimCallBack f$3;

    public /* synthetic */ HomeTabManager$$ExternalSyntheticLambda0(HomeTabManager homeTabManager, IconAnimType iconAnimType, String str, IIconAnimCallBack iIconAnimCallBack) {
        this.f$0 = homeTabManager;
        this.f$1 = iconAnimType;
        this.f$2 = str;
        this.f$3 = iIconAnimCallBack;
    }

    public final void run() {
        this.f$0.m99lambda$playIconAnim$1$combaidusearchboxhometabsHomeTabManager(this.f$1, this.f$2, this.f$3);
    }
}
