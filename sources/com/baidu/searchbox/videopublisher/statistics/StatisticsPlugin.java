package com.baidu.searchbox.videopublisher.statistics;

import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.publisher.PublisherDurationStat;
import com.baidu.searchbox.publisher.PublisherStat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/videopublisher/statistics/StatisticsPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "onPause", "", "onStart", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StatisticsPlugin.kt */
public final class StatisticsPlugin extends LiveDataPlugin {
    public void onStart() {
        super.onStart();
        PublisherDurationStat.statUgcPageDurationBegin();
    }

    public void onPause() {
        super.onPause();
        PublisherDurationStat.statUgcPageDurationEnd(PublisherStat.DurationPage.VIDEO_PUBLISH_PAGE);
    }
}
