package com.baidu.searchbox.feed.template.tplinterface;

public interface IVideoPlayerControl {
    void forceStopPlay();

    boolean hasClicked();

    boolean isPlaying();

    void pausePlay();

    void startPlay();

    void stopPlay();
}
