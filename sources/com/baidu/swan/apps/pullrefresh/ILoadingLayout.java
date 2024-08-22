package com.baidu.swan.apps.pullrefresh;

public interface ILoadingLayout {

    public enum State {
        NONE,
        RESET,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        LOADING,
        NO_MORE_DATA,
        RELEASE_TO_LONG_REFRESH,
        LONG_REFRESHING
    }

    int getContentSize();

    State getState();

    void onPull(float f2);

    void setState(State state);
}
