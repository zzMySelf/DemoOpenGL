package com.baidu.searchbox.schemedispatch.united.module;

import com.baidu.browser.explore.container.SearchBoxContainer;
import com.baidu.searchbox.browserenhanceengine.container.Container;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UnitedSchemeSearchDispatcher$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Container f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ UnitedSchemeSearchDispatcher$$ExternalSyntheticLambda1(Container container, String str) {
        this.f$0 = container;
        this.f$1 = str;
    }

    public final void run() {
        ((SearchBoxContainer) this.f$0).handleChangeQuery(this.f$1);
    }
}
