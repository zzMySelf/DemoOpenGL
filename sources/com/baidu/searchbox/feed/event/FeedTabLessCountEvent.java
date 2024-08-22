package com.baidu.searchbox.feed.event;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/event/FeedTabLessCountEvent;", "", "tabCount", "", "(I)V", "getTabCount", "()I", "setTabCount", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTabLessCountEvent.kt */
public final class FeedTabLessCountEvent {
    private int tabCount;

    public FeedTabLessCountEvent(int tabCount2) {
        this.tabCount = tabCount2;
    }

    public final int getTabCount() {
        return this.tabCount;
    }

    public final void setTabCount(int i2) {
        this.tabCount = i2;
    }
}
