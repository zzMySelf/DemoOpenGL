package com.baidu.searchbox.feed.container.creator.identity;

import com.baidu.searchbox.feed.container.creator.PageParams;
import com.baidu.texas.context.ContextMap;

public class PageKeyChannelType extends PageKey {
    public PageKeyChannelType(String key) {
        super(key);
    }

    /* access modifiers changed from: protected */
    public String getIdentifyKey(ContextMap<String> paramsMap) {
        return (String) paramsMap.getUserData(PageParams.KEY_LIST_TYPE, "");
    }
}
