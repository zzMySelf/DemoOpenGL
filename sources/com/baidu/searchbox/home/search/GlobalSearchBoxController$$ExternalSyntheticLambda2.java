package com.baidu.searchbox.home.search;

import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import com.baidu.searchbox.bdeventbus.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GlobalSearchBoxController$$ExternalSyntheticLambda2 implements Action {
    public final /* synthetic */ GlobalSearchBoxController f$0;

    public /* synthetic */ GlobalSearchBoxController$$ExternalSyntheticLambda2(GlobalSearchBoxController globalSearchBoxController) {
        this.f$0 = globalSearchBoxController;
    }

    public final void call(Object obj) {
        GlobalSearchBoxController.m20177registerEventBus$lambda4(this.f$0, (BdBoxActivityLifecycle.BackForegroundEvent) obj);
    }
}
