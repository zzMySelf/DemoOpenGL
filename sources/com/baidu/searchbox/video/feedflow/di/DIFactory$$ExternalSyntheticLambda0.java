package com.baidu.searchbox.video.feedflow.di;

import android.os.MessageQueue;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DIFactory$$ExternalSyntheticLambda0 implements MessageQueue.IdleHandler {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ DIFactory$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final boolean queueIdle() {
        return DIFactory.m20780addIdleHandler$lambda6(this.f$0);
    }
}
