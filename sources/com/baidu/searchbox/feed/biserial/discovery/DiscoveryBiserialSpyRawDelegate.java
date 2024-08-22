package com.baidu.searchbox.feed.biserial.discovery;

import android.content.Context;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.biserial.general.GeneralBiserialSpyRawDelegate;

class DiscoveryBiserialSpyRawDelegate extends GeneralBiserialSpyRawDelegate {
    public DiscoveryBiserialSpyRawDelegate(String channelId, Context context) {
        super(channelId, context);
    }

    public boolean needColdBootRefreshImmediately() {
        return FeedAbtestManager.isBiserialColdRefresh();
    }
}
