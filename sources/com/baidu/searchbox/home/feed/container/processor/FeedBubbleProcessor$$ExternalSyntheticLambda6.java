package com.baidu.searchbox.home.feed.container.processor;

import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.feed.tab.model.FeedTabBubbleGuideModel;
import com.baidu.searchbox.feed.tab.navigation.utils.FeedTabBubbleManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedBubbleProcessor$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ FeedBubbleProcessor f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ FeedTabBubbleManager.GuidTypeHolder f$2;
    public final /* synthetic */ FeedTabBubbleManager.ShowCallback f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ FeedTabBubbleGuideModel f$5;
    public final /* synthetic */ PopupExclusionManagerMap.Operation f$6;

    public /* synthetic */ FeedBubbleProcessor$$ExternalSyntheticLambda6(FeedBubbleProcessor feedBubbleProcessor, String str, FeedTabBubbleManager.GuidTypeHolder guidTypeHolder, FeedTabBubbleManager.ShowCallback showCallback, boolean z, FeedTabBubbleGuideModel feedTabBubbleGuideModel, PopupExclusionManagerMap.Operation operation) {
        this.f$0 = feedBubbleProcessor;
        this.f$1 = str;
        this.f$2 = guidTypeHolder;
        this.f$3 = showCallback;
        this.f$4 = z;
        this.f$5 = feedTabBubbleGuideModel;
        this.f$6 = operation;
    }

    public final void run() {
        FeedBubbleProcessor.m20052showFeedBubbleGuideIfNeed$lambda19$lambda18$lambda17(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}
