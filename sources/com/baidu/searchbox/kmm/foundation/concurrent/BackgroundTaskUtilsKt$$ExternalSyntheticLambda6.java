package com.baidu.searchbox.kmm.foundation.concurrent;

import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BackgroundTaskUtilsKt$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ BackgroundTaskUtilsKt$$ExternalSyntheticLambda6(Function0 function0) {
        this.f$0 = function0;
    }

    public final void run() {
        BackgroundTaskUtilsKt.m20631bgLowPriorityWork$lambda7(this.f$0);
    }
}
