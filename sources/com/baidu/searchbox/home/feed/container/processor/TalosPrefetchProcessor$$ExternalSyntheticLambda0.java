package com.baidu.searchbox.home.feed.container.processor;

import android.os.MessageQueue;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TalosPrefetchProcessor$$ExternalSyntheticLambda0 implements MessageQueue.IdleHandler {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ MultiTabItemInfo f$1;
    public final /* synthetic */ TalosPrefetchProcessor f$2;

    public /* synthetic */ TalosPrefetchProcessor$$ExternalSyntheticLambda0(int i2, MultiTabItemInfo multiTabItemInfo, TalosPrefetchProcessor talosPrefetchProcessor) {
        this.f$0 = i2;
        this.f$1 = multiTabItemInfo;
        this.f$2 = talosPrefetchProcessor;
    }

    public final boolean queueIdle() {
        return TalosPrefetchProcessor.m20115onPageSelected$lambda3(this.f$0, this.f$1, this.f$2);
    }
}
