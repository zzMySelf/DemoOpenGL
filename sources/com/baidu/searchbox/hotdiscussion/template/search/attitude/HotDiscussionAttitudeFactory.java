package com.baidu.searchbox.hotdiscussion.template.search.attitude;

import android.content.Context;
import com.baidu.searchbox.dynamic.template.HotDiscussionTemplateType;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.generalcommunity.injector.TemplateDecoderFactory;

public class HotDiscussionAttitudeFactory implements TemplateDecoderFactory {
    public String getType() {
        return HotDiscussionTemplateType.STAR_ATTITUDE;
    }

    public FeedItemData buildModel(FeedBaseModel baseModel) {
        return new HotDiscussionItemAttitudeData();
    }

    public FeedTemplate buildTemplate(Context context) {
        return new HotDiscussionAttitudeLayout(context);
    }
}
