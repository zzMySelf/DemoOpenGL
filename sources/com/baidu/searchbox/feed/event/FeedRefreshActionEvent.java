package com.baidu.searchbox.feed.event;

public class FeedRefreshActionEvent {
    public String channelId;
    public String refreshState;

    public FeedRefreshActionEvent(String channelId2, String refreshState2) {
        this.channelId = channelId2;
        this.refreshState = refreshState2;
    }
}
