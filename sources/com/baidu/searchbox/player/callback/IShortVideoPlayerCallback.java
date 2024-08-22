package com.baidu.searchbox.player.callback;

public interface IShortVideoPlayerCallback {
    void onPanelVisibilityChanged(boolean z);

    void onPauseBtnClick();

    void onReplayBtnClick();

    void onStartBtnClick();

    void onVideoSwitchToFull();

    void onVideoSwitchToHalf();
}
