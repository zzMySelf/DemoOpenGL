package com.baidu.searchbox.feed.ad.proxy;

public interface IFeedPageAdProxy {
    int[] getFeedListVisibleRange();

    boolean isPaused();

    void scrollBy(int i2, int i3);

    void scrollItemToListTop(String str, long j2);
}
