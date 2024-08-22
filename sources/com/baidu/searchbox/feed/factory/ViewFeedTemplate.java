package com.baidu.searchbox.feed.factory;

import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;
import org.json.JSONObject;

public class ViewFeedTemplate extends SimpleFeedTemplate {
    public ViewFeedTemplate(String name, Class<? extends FeedTemplate> viewClass, SimpleFeedTemplate.Policy policy) {
        super(name, viewClass, FeedItemData.class, policy);
    }

    /* access modifiers changed from: protected */
    public final FeedItemData newItemModel(JSONObject dataObj) {
        return null;
    }

    public final int getItemModelClassCount() {
        return 0;
    }
}
