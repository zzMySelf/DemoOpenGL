package com.baidu.searchbox.feed.list.domain.states;

public class SourceState implements NetState, DBState {
    private final Bridge mBridge;
    private boolean mIsAllHistoryReady;
    private boolean mIsFetchingFeed;
    private boolean mIsLoadingFeed;
    private boolean mIsNeedCancel = false;
    private boolean mIsPreConnecting;
    private boolean mIsPrefetchFeed;
    private int mLoadedCountFromDB = 0;
    private boolean mNeedFromStartWhileNotifyRanged = false;
    private final Object mPrefetchLock = new Object();

    public SourceState(Bridge bridge) {
        this.mBridge = bridge;
    }

    public Object getPrefetchLock() {
        return this.mPrefetchLock;
    }

    public void setAllHistoryReady(boolean isReady) {
        this.mIsAllHistoryReady = isReady;
    }

    public boolean isLoading() {
        return this.mIsLoadingFeed;
    }

    public boolean isRefreshing() {
        return this.mIsFetchingFeed;
    }

    public boolean isPreFetching() {
        return this.mIsPrefetchFeed;
    }

    public boolean isPreFetchTimeout() {
        return this.mBridge.isPrefetchTimeout();
    }

    public boolean isInRefreshInterval() {
        return this.mBridge.isInRefreshInterval();
    }

    public boolean isCanceledPrefetch() {
        return this.mIsNeedCancel;
    }

    public boolean isAllHistoryNotReady() {
        return !this.mIsAllHistoryReady;
    }

    public boolean isPreConnecting() {
        return this.mIsPreConnecting;
    }

    public void setPreFetching(boolean isFetching) {
        this.mIsPrefetchFeed = isFetching;
    }

    public void setRefreshing(boolean isRefreshing) {
        this.mIsFetchingFeed = isRefreshing;
    }

    public void setLoading(boolean isLoading) {
        this.mIsLoadingFeed = isLoading;
    }

    public void setPreConnecting(boolean isPreConnecting) {
        this.mIsPreConnecting = isPreConnecting;
    }

    public void setCanceledPrefetch(boolean isCanceled) {
        this.mIsNeedCancel = isCanceled;
    }

    public int getCursorIndex() {
        return this.mLoadedCountFromDB;
    }

    public void setCursorIndex(int index) {
        this.mLoadedCountFromDB = index;
    }

    public void notifyDeleteResult() {
        this.mLoadedCountFromDB--;
    }

    public boolean needFromStartWhileNotifyRanged() {
        return this.mNeedFromStartWhileNotifyRanged;
    }

    public void setNeedFromStartWhileNotifyRanged(boolean fromStartWhileNotifyRanged) {
        this.mNeedFromStartWhileNotifyRanged = fromStartWhileNotifyRanged;
    }
}
