package com.baidu.searchbox.feed.factory;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.SimpleFeedTemplate;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataHotSearchFooter;
import com.baidu.searchbox.feed.template.FeedHotSearchFooterView;
import com.baidu.searchbox.feed.template.constant.FeedTplNameCenter;
import org.json.JSONObject;

public class FeedTplHotSearchFooter extends SimpleFeedTemplate {
    public FeedTplHotSearchFooter() {
        super(FeedTplNameCenter.HOT_SEARCH_FOOTER_ITEMS, FeedHotSearchFooterView.class, FeedItemDataHotSearchFooter.class, SimpleFeedTemplate.Policy.POLICY);
    }

    /* access modifiers changed from: protected */
    public FeedTemplate newItemView(Context ctx) {
        return new FeedHotSearchFooterView(ctx);
    }

    /* access modifiers changed from: protected */
    public FeedItemData newItemModel(JSONObject dataObj) {
        return new FeedItemDataHotSearchFooter();
    }
}
