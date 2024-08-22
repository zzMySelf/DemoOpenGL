package com.baidu.searchbox.home.feed;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.feed.event.FeedRefreshActionEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NewHomeFeedController$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ NewHomeFeedController f$0;

    public /* synthetic */ NewHomeFeedController$$ExternalSyntheticLambda0(NewHomeFeedController newHomeFeedController) {
        this.f$0 = newHomeFeedController;
    }

    public final void call(Object obj) {
        NewHomeFeedController.m20028registerBusEvent$lambda4(this.f$0, (FeedRefreshActionEvent) obj);
    }
}
