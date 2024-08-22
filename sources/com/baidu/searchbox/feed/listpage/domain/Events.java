package com.baidu.searchbox.feed.listpage.domain;

public interface Events {
    void publishLoadMoreFailed(LoadMoreState loadMoreState, LoadMoreResult loadMoreResult);

    void publishLoadMoreLoading(LoadMoreState loadMoreState, LoadMoreResult loadMoreResult);

    void publishLoadMoreSuccess(LoadMoreState loadMoreState, LoadMoreResult loadMoreResult);
}
