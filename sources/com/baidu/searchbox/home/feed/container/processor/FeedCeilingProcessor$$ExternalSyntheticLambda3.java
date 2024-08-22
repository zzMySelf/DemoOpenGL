package com.baidu.searchbox.home.feed.container.processor;

import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.home.feed.CeilingScene;
import com.baidu.searchbox.homepage.extend.IHomeFun;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedCeilingProcessor$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ IHomeFun f$0;
    public final /* synthetic */ CeilingScene f$1;
    public final /* synthetic */ FeedCeilingProcessor f$2;
    public final /* synthetic */ MultiTabItemInfo f$3;

    public /* synthetic */ FeedCeilingProcessor$$ExternalSyntheticLambda3(IHomeFun iHomeFun, CeilingScene ceilingScene, FeedCeilingProcessor feedCeilingProcessor, MultiTabItemInfo multiTabItemInfo) {
        this.f$0 = iHomeFun;
        this.f$1 = ceilingScene;
        this.f$2 = feedCeilingProcessor;
        this.f$3 = multiTabItemInfo;
    }

    public final void run() {
        FeedCeilingProcessor.m20059notifyTabCeilingIfNeed$lambda9(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
