package com.baidu.searchbox.feed.widget.feedflow;

public interface PullRefreshToSecondFloorListener {
    void changeToPullingState();

    void changeToSecondFloorState();

    int getRefreshViewActualOffset();

    float getTriggerRefreshLength();
}
