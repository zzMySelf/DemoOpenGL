package com.baidu.swan.game.ad.ioc.interfaces;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.swan.game.ad.component.VideoParams;
import com.baidu.swan.game.ad.interfaces.IAdVideoPlayerListener;

public interface IAdVideoPlayer {
    IAdVideoPlayer create(Context context, VideoParams videoParams);

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void handleInitRecord();

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    boolean onBackPressed();

    void onBackground();

    void onForeground();

    void open(VideoParams videoParams);

    void pause();

    void reset();

    void resume();

    void seekTo(int i2);

    void setFullScreen(boolean z, int i2);

    void setListener(IAdVideoPlayerListener iAdVideoPlayerListener);

    void setSupportOrientation(boolean z);

    void setVideoHolder(FrameLayout frameLayout);

    void start();

    void stop();

    void updatePlayerConfigInternal(VideoParams videoParams, boolean z);
}
