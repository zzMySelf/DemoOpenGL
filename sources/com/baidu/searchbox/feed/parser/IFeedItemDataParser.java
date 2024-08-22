package com.baidu.searchbox.feed.parser;

import com.baidu.searchbox.feed.base.FeedTemplateManager;
import com.baidu.searchbox.feed.model.FeedProtocolEntity;

public interface IFeedItemDataParser<T> {
    void fillItemData(String str, FeedProtocolEntity feedProtocolEntity, T t, FeedTemplateManager feedTemplateManager);
}
