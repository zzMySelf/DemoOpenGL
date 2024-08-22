package com.baidu.searchbox.video.detail.plugin.service;

import com.baidu.searchbox.video.detail.plugin.component.downloadslide.DownloadListBannerDividerComponent;
import com.baidu.searchbox.video.detail.service.adapter.DividerServiceAdapter;

public class DividerService extends DividerServiceAdapter {
    private DownloadListBannerDividerComponent mComponent;

    public DividerService(DownloadListBannerDividerComponent component) {
        this.mComponent = component;
    }

    public void controlVisibilityStatus(boolean show) {
        DownloadListBannerDividerComponent downloadListBannerDividerComponent = this.mComponent;
        if (downloadListBannerDividerComponent != null) {
            downloadListBannerDividerComponent.show();
        }
    }
}
