package com.baidu.searchbox.feed.dependency.iocimpl;

import com.baidu.keyevent.PlainEventMonitor;
import com.baidu.searchbox.feed.h5.HybridConstants;
import com.baidu.searchbox.feed.h5.HybridManager;
import com.baidu.searchbox.feed.h5.prefetch.LandingPrefetchUtil;
import com.baidu.searchbox.feed.h5.utils.HybridCacheUtils;
import com.baidu.searchbox.feed.h5.utils.HybridUtils;
import com.baidu.searchbox.feed.ioc.IFeedNews;
import com.baidu.searchbox.feed.news.preheat.NewsTplMiddleware;
import com.baidu.searchbox.lightbrowser.prerender.PreRenderTrigger;
import com.baidu.searchbox.lightbrowser.prerender.data.AdRenderData;
import java.util.Map;

public class FeedNewsImpl implements IFeedNews {
    public void removeAllNewsCache() {
        HybridManager.clearCacheAsync();
    }

    public void removeNewsCacheById(String key) {
        HybridCacheUtils.removeCacheAsync(HybridUtils.makeCacheId(key, HybridConstants.RES_HTML_SUFFIX));
    }

    public void producePreRenderFroAd(String baseUrl, String data) {
        PreRenderTrigger.INSTANCE.produce(PreRenderTrigger.Type.AD, AdRenderData.createProduceData(baseUrl, (Map<String, String>) null));
    }

    public String getImageCache(String key, boolean needLog) {
        return LandingPrefetchUtil.getImageCache(key, needLog);
    }

    public void triggerPreHeatNewsTpl(boolean hardEnvironment) {
        PlainEventMonitor.getInstance().plainEventStart("triggerPreHeatNewsTpl");
        NewsTplMiddleware.triggerPreHeatNewsTpl(hardEnvironment);
        PlainEventMonitor.getInstance().plainEventEnd("triggerPreHeatNewsTpl");
    }
}
