package com.baidu.searchbox.launch.restore;

import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SystemKillManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SystemKillManager f$0;
    public final /* synthetic */ WeakReference f$1;
    public final /* synthetic */ Bundle f$2;

    public /* synthetic */ SystemKillManager$$ExternalSyntheticLambda1(SystemKillManager systemKillManager, WeakReference weakReference, Bundle bundle) {
        this.f$0 = systemKillManager;
        this.f$1 = weakReference;
        this.f$2 = bundle;
    }

    public final void run() {
        SystemKillManager.m20678checkUploadLog$lambda3$lambda2(this.f$0, this.f$1, this.f$2);
    }
}
