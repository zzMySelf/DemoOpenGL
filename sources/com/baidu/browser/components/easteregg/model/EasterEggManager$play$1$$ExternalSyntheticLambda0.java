package com.baidu.browser.components.easteregg.model;

import android.content.Context;
import android.view.ViewParent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EasterEggManager$play$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ EasterEggManager f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ EasterEggModel f$2;
    public final /* synthetic */ ViewParent f$3;

    public /* synthetic */ EasterEggManager$play$1$$ExternalSyntheticLambda0(EasterEggManager easterEggManager, Context context, EasterEggModel easterEggModel, ViewParent viewParent) {
        this.f$0 = easterEggManager;
        this.f$1 = context;
        this.f$2 = easterEggModel;
        this.f$3 = viewParent;
    }

    public final void run() {
        EasterEggManager$play$1.m12672onDownLoadSuccess$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
