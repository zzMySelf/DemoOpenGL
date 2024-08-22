package com.baidu.searchbox.video.detail.plugin.service;

import com.baidu.searchbox.video.detail.model.CommentInfo;
import com.baidu.searchbox.video.detail.plugin.BarragePlugin;
import com.baidu.searchbox.video.detail.service.adapter.BarrageServiceAdapter;

public class BarrageService extends BarrageServiceAdapter {
    private BarragePlugin mPlugin;

    public BarrageService(BarragePlugin plugin) {
        this.mPlugin = plugin;
    }

    public void setupBarrage(CommentInfo info) {
        this.mPlugin.setupBarrage(info);
    }

    public void loadBarrage() {
        this.mPlugin.loadBarrage();
    }

    public void reloadBarrage() {
        this.mPlugin.reloadBarrage();
    }
}
