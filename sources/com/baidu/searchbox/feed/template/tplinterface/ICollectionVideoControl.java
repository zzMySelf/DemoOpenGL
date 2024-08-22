package com.baidu.searchbox.feed.template.tplinterface;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.player.BaseVideoPlayer;

public interface ICollectionVideoControl extends IVideoPlayerControl {
    void destroyVideo();

    FeedBaseModel getFeedBaseModel();

    FrameLayout getVideoHolder();

    View getVideoShadow();

    boolean isPlayerPlay();

    boolean isSupportAutoPlay();

    void lightOffIfNeed();

    void lightOnBottomInfoAWhile();

    void lightOnBottomInfoAlways();

    void lightOnIfNeed();

    void lightOnPlayAreaIfNeed();

    void onUpdateProgress(int i2, int i3);

    void resumePlayer();

    void setPlayer(BaseVideoPlayer baseVideoPlayer);

    void startAutoPlay(boolean z);

    void updateBottomTitle(FeedBaseModel feedBaseModel);

    void updateHighlightSwitchChangeAnimation();
}
