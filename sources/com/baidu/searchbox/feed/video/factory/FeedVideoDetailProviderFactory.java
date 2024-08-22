package com.baidu.searchbox.feed.video.factory;

import com.baidu.searchbox.feed.video.layoutmanager.FeedLayoutManager;
import com.baidu.searchbox.feed.video.layoutmanager.FloatingLayoutManager;
import com.baidu.searchbox.video.detail.DefaultProviderFactory;
import com.baidu.searchbox.video.detail.controller.VideoDetailAbtestManager;
import com.baidu.searchbox.video.detail.core.DataManager;
import com.baidu.searchbox.video.detail.core.LayoutManager;
import com.baidu.searchbox.video.detail.core.provider.IPluginProvider;

public class FeedVideoDetailProviderFactory extends DefaultProviderFactory {
    public IPluginProvider getPluginProvider() {
        if (VideoDetailAbtestManager.getGoodsFloatingSwitch() && VideoDetailAbtestManager.getAuthorFloatingSwitch()) {
            return new AllFloatingPluginProvider();
        }
        if (VideoDetailAbtestManager.getGoodsFloatingSwitch()) {
            return new GoodsBannerFloatingPluginProvider();
        }
        if (VideoDetailAbtestManager.getAuthorFloatingSwitch()) {
            return new AuthorFloatingPluginProvider();
        }
        return new NoFloatingPluginProvider();
    }

    public DataManager getDataManager() {
        return new FeedVideoDetailDataManager();
    }

    public LayoutManager getLayoutManager() {
        if (VideoDetailAbtestManager.getAuthorFloatingSwitch() || VideoDetailAbtestManager.getGoodsFloatingSwitch()) {
            return new FloatingLayoutManager();
        }
        return new FeedLayoutManager();
    }
}
