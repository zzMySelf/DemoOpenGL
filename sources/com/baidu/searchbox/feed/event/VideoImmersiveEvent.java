package com.baidu.searchbox.feed.event;

import com.baidu.searchbox.feed.model.FeedBaseModel;

public class VideoImmersiveEvent {
    public static final int TYPE_AD_VIDEO_TAIL = 2;
    public static final int TYPE_AD_VIDEO_TAIL_END = 3;
    public static final int TYPE_END = 1;
    public static final int TYPE_SHOW_NEXT_TIP = 0;
    public boolean isUpdateStrategy = true;
    public int type;
    public FeedBaseModel videoModel;

    public VideoImmersiveEvent(FeedBaseModel videoModel2, int type2) {
        this.videoModel = videoModel2;
        this.type = type2;
    }

    public void setUpdateStrategy(boolean isUpdateStrategy2) {
        this.isUpdateStrategy = isUpdateStrategy2;
    }
}
