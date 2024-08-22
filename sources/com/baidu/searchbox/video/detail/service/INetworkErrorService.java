package com.baidu.searchbox.video.detail.service;

public interface INetworkErrorService extends IService {
    void hideErrorView();

    void hideLoading();

    void showErrorView(boolean z);

    void showLoading();
}
