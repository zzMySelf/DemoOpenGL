package com.baidu.searchbox.liveshow.feedpage;

import com.baidu.live.feedpage.LiveFeedPageContextImpl_Factory;

public class FeedPageRuntime {
    public static IFeedPageContext getFeePageContext() {
        return LiveFeedPageContextImpl_Factory.get();
    }
}
