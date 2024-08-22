package com.baidu.searchbox.hotdiscussion.linkage.compare;

import com.baidu.searchbox.feed.model.FeedBaseModel;

public class CommentTemplateCompare extends NormalTemplateCompare {
    public boolean isTemplateKey(String key, FeedBaseModel baseModel) {
        return super.isTemplateKey(key, baseModel);
    }
}
