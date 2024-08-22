package com.baidu.searchbox.download.center.clearcache;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DiskManager$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ DiskManager$$ExternalSyntheticLambda11(Function1 function1) {
        this.f$0 = function1;
    }

    public final void run() {
        DiskManager.m17088calculateCurrentDiskLevelAsync$lambda6(this.f$0);
    }
}
