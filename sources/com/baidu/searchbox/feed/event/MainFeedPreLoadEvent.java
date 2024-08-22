package com.baidu.searchbox.feed.event;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.ArrayList;

public class MainFeedPreLoadEvent {
    public ArrayList<FeedBaseModel> historyFeeds;

    public MainFeedPreLoadEvent(ArrayList<FeedBaseModel> historyFeeds2) {
        this.historyFeeds = historyFeeds2;
    }
}
