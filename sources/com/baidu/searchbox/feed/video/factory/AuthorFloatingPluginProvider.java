package com.baidu.searchbox.feed.video.factory;

import com.baidu.searchbox.feed.detail.arch.api.ComponentProvider;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.video.detail.plugin.component.author.AuthorInnerComponent;
import com.baidu.searchbox.video.detail.plugin.component.author.AuthorOuterComponent;
import com.baidu.searchbox.video.detail.plugin.component.author.AuthorPlugin;
import com.baidu.searchbox.video.detail.plugin.component.author.DownloadFloatingComponent;
import com.baidu.searchbox.video.detail.plugin.component.banner.VideoGoodsBannerComponent;
import com.baidu.searchbox.video.detail.plugin.component.general.FloatingComponent;

public class AuthorFloatingPluginProvider extends FeedPluginProvider {
    public String getProviderName() {
        return AuthorFloatingPluginProvider.class.getName();
    }

    @ComponentProvider
    public IPlugin providerFloatingComponent() {
        return new FloatingComponent();
    }

    @ComponentProvider
    public IPlugin providerAuthorInnerComponent() {
        return new AuthorInnerComponent();
    }

    @ComponentProvider
    public IPlugin providerAuthorOuterComponent() {
        return new AuthorOuterComponent();
    }

    @ComponentProvider
    public IPlugin providerAuthorPlugin() {
        return new AuthorPlugin();
    }

    @ComponentProvider
    public IPlugin providerDownloadFloatingComponent() {
        return new DownloadFloatingComponent();
    }

    @ComponentProvider
    public IPlugin providerGoodsBannerComponent() {
        return new VideoGoodsBannerComponent();
    }
}
