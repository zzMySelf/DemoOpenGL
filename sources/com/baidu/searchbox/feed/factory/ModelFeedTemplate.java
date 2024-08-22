package com.baidu.searchbox.feed.factory;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;

public class ModelFeedTemplate extends SimpleFeedTemplate {
    public ModelFeedTemplate(String name, Class<? extends FeedItemData> modelClass, SimpleFeedTemplate.Policy policy) {
        super(name, FeedTemplate.class, modelClass, policy);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        return null;
    }

    public int getItemViewClassCount() {
        return 0;
    }
}
