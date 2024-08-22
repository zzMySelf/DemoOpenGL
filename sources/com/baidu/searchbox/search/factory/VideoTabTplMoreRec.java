package com.baidu.searchbox.search.factory;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.factory.ViewFeedTemplate;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import com.baidu.searchbox.search.template.VideoTabMoreRecView;

public class VideoTabTplMoreRec extends ViewFeedTemplate {
    public VideoTabTplMoreRec() {
        super(FeedTplNameCenter.VIDEO_SEARCH_MORE_RECOMMEND, VideoTabMoreRecView.class, SimpleFeedTemplate.Policy.POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        return new VideoTabMoreRecView(ctx);
    }
}
