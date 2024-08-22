package com.baidu.searchbox.search.video.plugin.service;

import com.baidu.searchbox.search.video.container.VideoContainer;
import com.baidu.searchbox.search.video.plugin.adpater.BeeServiceAdapter;

public class BeeService extends BeeServiceAdapter {
    private VideoContainer mContainer;

    public BeeService(VideoContainer container) {
        this.mContainer = container;
    }

    public String getName() {
        return BeeService.class.getName();
    }

    public void goBack() {
        this.mContainer.goBack();
    }

    public void goHome() {
        this.mContainer.goHome();
    }
}
