package com.baidu.searchbox.ioc;

import android.text.TextUtils;
import com.baidu.searchbox.feed.ad.prefetch.AdLandingPrefetchUtils;
import com.baidu.searchbox.feed.ad.prefetch.IAdLandingPrefetchProxy;
import com.baidu.searchbox.feed.h5.utils.HybridCacheUtils;
import com.baidu.searchbox.feed.h5.utils.HybridUtils;
import com.baidu.searchbox.lightbrowser.prerender.PreRenderTrigger;
import com.baidu.searchbox.lightbrowser.prerender.data.AdRenderData;
import com.baidu.searchbox.lightbrowser.prerender.ioc.IPreRenderContext;
import java.io.InputStream;

public class AdLandingPrefetchImpl implements IAdLandingPrefetchProxy {
    public String makeCacheId(String url, String adPrefetchSuffix) {
        return HybridUtils.makeCacheId(url, adPrefetchSuffix);
    }

    public InputStream getIsFromHybridCache(String makeCacheId) {
        return HybridCacheUtils.getIsFromHybridCache(makeCacheId);
    }

    public String getHybridCache(String makeCacheId) {
        return HybridCacheUtils.getHybridCache(makeCacheId);
    }

    public String getHybridCachePath(String makeCacheId) {
        return HybridCacheUtils.getHybridCachePath(makeCacheId);
    }

    public void saveHybridCache(String makeCacheId, String param) {
        HybridCacheUtils.saveHybridCache(makeCacheId, param);
    }

    public void saveHybridCache(String pageId, InputStream inputStream) {
        HybridCacheUtils.saveHybridCache(pageId, inputStream);
    }

    public boolean allowAble(String pvUrl) {
        return PreRenderTrigger.INSTANCE.consumable(PreRenderTrigger.Type.AD, AdRenderData.createConsumeData("", pvUrl));
    }

    public boolean preRenderFlagValid(String lpRealUrl) {
        return TextUtils.equals(IPreRenderContext.Impl.get().getCache(lpRealUrl, AdLandingPrefetchUtils.AD_PRERENDER_FLAG_KEY), "valid");
    }
}
