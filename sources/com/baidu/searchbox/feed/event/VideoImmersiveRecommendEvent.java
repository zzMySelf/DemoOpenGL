package com.baidu.searchbox.feed.event;

import com.baidu.searchbox.feed.model.FeedBaseModel;

public class VideoImmersiveRecommendEvent extends VideoBaseEvent {
    public VideoImmersiveRecommendEvent(FeedBaseModel feedBaseModel, String type) {
        super(feedBaseModel, type, (String) null);
    }
}
