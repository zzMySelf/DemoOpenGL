package com.baidu.searchbox.search.debug;

import android.widget.CompoundButton;
import com.baidu.searchbox.appmanager.AppRestartController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchDebugConfigProvider$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ CompoundButton f$0;

    public /* synthetic */ SearchDebugConfigProvider$$ExternalSyntheticLambda1(CompoundButton compoundButton) {
        this.f$0 = compoundButton;
    }

    public final void run() {
        AppRestartController.restart(this.f$0.getContext());
    }
}
