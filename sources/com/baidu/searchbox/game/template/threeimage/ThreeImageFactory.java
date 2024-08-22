package com.baidu.searchbox.game.template.threeimage;

import android.content.Context;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.game.template.TemplateType;
import com.baidu.searchbox.generalcommunity.injector.TemplateDecoderFactory;

public class ThreeImageFactory implements TemplateDecoderFactory {
    public FeedItemData buildModel(FeedBaseModel baseModel) {
        return new CommunityItemDataThreeImage();
    }

    public FeedTemplate buildTemplate(Context context) {
        return new CommunityThreeImage(context);
    }

    public String getType() {
        return TemplateType.THREE_IMAGE;
    }
}
