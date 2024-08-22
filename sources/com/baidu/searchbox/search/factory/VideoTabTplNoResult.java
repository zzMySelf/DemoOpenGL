package com.baidu.searchbox.search.factory;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.factory.ViewFeedTemplate;
import com.baidu.searchbox.search.template.VideoTabNoResultView;

public class VideoTabTplNoResult extends ViewFeedTemplate {
    public VideoTabTplNoResult() {
        super("search_no_result", VideoTabNoResultView.class, SimpleFeedTemplate.Policy.POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        return new VideoTabNoResultView(ctx);
    }
}
