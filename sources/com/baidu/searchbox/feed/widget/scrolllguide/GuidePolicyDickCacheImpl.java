package com.baidu.searchbox.feed.widget.scrolllguide;

import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.safemode.impl.config.ConfigImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/widget/scrolllguide/GuidePolicyDickCacheImpl;", "Lcom/baidu/searchbox/feed/widget/scrolllguide/IGuidePolicyDiskCache;", "businessPrefix", "", "(Ljava/lang/String;)V", "getLastShowTime", "", "getShowedCount", "", "loadCache", "saveCache", "", "policy", "saveLastShowTime", "saveShowedCount", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuidePolicyDickCacheImpl.kt */
public final class GuidePolicyDickCacheImpl implements IGuidePolicyDiskCache {
    private final String businessPrefix;

    public GuidePolicyDickCacheImpl(String businessPrefix2) {
        Intrinsics.checkNotNullParameter(businessPrefix2, "businessPrefix");
        this.businessPrefix = businessPrefix2;
    }

    public String loadCache() {
        String string = FeedPreferenceUtils.getString(this.businessPrefix + GuidePolicyDickCacheImplKt.SP_FIND_DETAIL_GUIDE_CONF, "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(businessPrefix…ND_DETAIL_GUIDE_CONF, \"\")");
        return string;
    }

    public void saveCache(String policy) {
        Intrinsics.checkNotNullParameter(policy, ConfigImpl.JSONConstant.POLICY);
        FeedPreferenceUtils.putString(this.businessPrefix + GuidePolicyDickCacheImplKt.SP_FIND_DETAIL_GUIDE_CONF, policy);
    }

    public int getShowedCount() {
        return FeedPreferenceUtils.getInt(this.businessPrefix + GuidePolicyDickCacheImplKt.SP_GUIDE_SHOWED_COUNT, 0);
    }

    public long getLastShowTime() {
        return FeedPreferenceUtils.getLong(this.businessPrefix + GuidePolicyDickCacheImplKt.SP_GUIDE_LAST_SHOW_TIME, 0);
    }

    public void saveLastShowTime() {
        FeedPreferenceUtils.putLong(this.businessPrefix + GuidePolicyDickCacheImplKt.SP_GUIDE_LAST_SHOW_TIME, System.currentTimeMillis());
    }

    public void saveShowedCount() {
        FeedPreferenceUtils.putInt(this.businessPrefix + GuidePolicyDickCacheImplKt.SP_GUIDE_SHOWED_COUNT, getShowedCount() + 1);
    }
}
