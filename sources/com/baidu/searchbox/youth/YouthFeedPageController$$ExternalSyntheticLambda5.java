package com.baidu.searchbox.youth;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.feed.event.FeedRecommendRefreshEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class YouthFeedPageController$$ExternalSyntheticLambda5 implements Action {
    public final /* synthetic */ YouthFeedPageController f$0;

    public /* synthetic */ YouthFeedPageController$$ExternalSyntheticLambda5(YouthFeedPageController youthFeedPageController) {
        this.f$0 = youthFeedPageController;
    }

    public final void call(Object obj) {
        YouthFeedPageController.m7775registerRefreshEvent$lambda12(this.f$0, (FeedRecommendRefreshEvent) obj);
    }
}
