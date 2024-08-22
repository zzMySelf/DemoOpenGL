package com.baidu.searchbox.sniff;

import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.init.RequestParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/sniff/AppSniffResChannel;", "Lcom/baidu/searchbox/pms/init/RequestParams$Channel;", "()V", "lib-appsniff-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppSniffResManager.kt */
public final class AppSniffResChannel extends RequestParams.Channel {
    public AppSniffResChannel() {
        super(FeedStatisticConstants.UBC_FEED_GAME_TYPE, "com.baidu.searchbox.appsniff.list", (PackageCallback) new AppSniffResPackageCallback());
    }
}
