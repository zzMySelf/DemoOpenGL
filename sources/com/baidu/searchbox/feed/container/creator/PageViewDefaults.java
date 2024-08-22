package com.baidu.searchbox.feed.container.creator;

import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.tab.view.FeedBasePageView;
import com.baidu.searchbox.feed.tab.view.FeedFlowContextFactory;
import com.baidu.searchbox.feed.tab.view.MainFeedPageView;
import com.baidu.searchbox.feed.widget.feedflow.IPagerView;

public class PageViewDefaults {
    public static IPagerView getDefaultPage() {
        return new MainFeedPageView();
    }

    public static IPagerView getTalosDegradedPage() {
        return new FeedBasePageView(new FeedFlowContextFactory());
    }

    public static IPagerView getWebPage() {
        return FeedRuntime.getFeedContext().getFeedWebPageView();
    }
}
