package com.baidu.searchbox.search.video.plugin.service;

import com.baidu.searchbox.search.video.plugin.SearchMenuPlugin;
import com.baidu.searchbox.search.video.plugin.adpater.SearchMenuServiceAdapter;

public class SearchMenuService extends SearchMenuServiceAdapter {
    private SearchMenuPlugin mPlugin;

    public SearchMenuService(SearchMenuPlugin plugin) {
        this.mPlugin = plugin;
    }

    public String getName() {
        return SearchMenuService.class.getName();
    }

    public void showMenu(int i2) {
        this.mPlugin.showMenu(i2);
    }

    public void dismissMenu() {
        this.mPlugin.dismissMenu();
    }

    public void updateVideoDownloadItem(int i2) {
        this.mPlugin.updateVideoDownloadItem(i2);
    }
}
