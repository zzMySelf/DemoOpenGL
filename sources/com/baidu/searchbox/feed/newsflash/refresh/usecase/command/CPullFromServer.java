package com.baidu.searchbox.feed.newsflash.refresh.usecase.command;

public class CPullFromServer {
    public String mPullRefreshSource;

    public CPullFromServer(String source) {
        this.mPullRefreshSource = source;
    }
}
