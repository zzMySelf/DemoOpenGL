package com.baidu.searchbox.video.detail.plugin.service;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.video.detail.plugin.component.author.DownloadFloatingComponent;
import com.baidu.searchbox.video.detail.plugin.component.author.model.AuthorModel;
import com.baidu.searchbox.video.detail.plugin.component.right.ui.VideoDetailDownloadView;

public class DownloadOuterService implements IDownloadOuterService {
    private DownloadFloatingComponent mOuterComponent;

    public DownloadOuterService(DownloadFloatingComponent downloadFloatingComponent) {
        this.mOuterComponent = downloadFloatingComponent;
    }

    public void bindData(VideoDetailDownloadView.AppInfo appInfo) {
        this.mOuterComponent.bindData(appInfo);
    }

    public void bindData(AuthorModel authorInfo) {
    }

    public void setMainViewVisible(int visibility) {
        this.mOuterComponent.setVisibility(visibility);
    }

    public void onScrollFinish(RecyclerView recyclerView) {
    }

    public View getMainView() {
        return this.mOuterComponent.getMainView();
    }

    public View getChildView() {
        return null;
    }

    public String getName() {
        return DownloadOuterService.class.getName();
    }
}
