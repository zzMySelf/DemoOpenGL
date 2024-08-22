package com.baidu.searchbox.feed.listpage.application.command;

import com.baidu.searchbox.feed.listpage.domain.LoadingState;
import com.baidu.searchbox.feed.listpage.domain.transform.ComposePostTransformer;
import com.baidu.searchbox.feed.model.FeedBaseModel;

public class PullToRefreshRequest {
    public final String refreshState;
    public final LoadingState state;
    public final ComposePostTransformer<FeedBaseModel> transformer;

    public PullToRefreshRequest(String refreshState2, LoadingState state2, ComposePostTransformer transformer2) {
        this.refreshState = refreshState2;
        this.state = state2;
        this.transformer = transformer2;
    }
}
