package com.baidu.searchbox.feed.tab.interaction;

public interface IDataRefreshable {
    void onExternalRefresh(String str, String str2);

    void onPreFetchData(int i2);

    void refreshFeedIfNeed();
}
