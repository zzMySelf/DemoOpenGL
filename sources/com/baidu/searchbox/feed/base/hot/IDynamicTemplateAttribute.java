package com.baidu.searchbox.feed.base.hot;

import com.baidu.searchbox.feed.base.FeedTemplate;

public interface IDynamicTemplateAttribute {
    boolean couldShield();

    void getSize(FeedTemplate.SizeReadyCallback sizeReadyCallback);

    boolean needConsumeClick();
}
