package com.baidu.searchbox.ioc;

import com.baidu.searchbox.ad.IAdCriusRuntime;
import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.util.FeedUtil;

public class AdCriusRuntimeImpl implements IAdCriusRuntime {
    public boolean getNightMode() {
        return FeedRuntime.getNightMode();
    }

    public int getFontLevel() {
        return FeedConfig.Font.FONT_LEVEL;
    }

    public void prefetchImage(String imageUrl) {
        FeedUtil.prefetchImage(imageUrl);
    }
}
