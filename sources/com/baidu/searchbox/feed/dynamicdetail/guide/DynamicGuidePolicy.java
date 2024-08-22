package com.baidu.searchbox.feed.dynamicdetail.guide;

import com.baidu.searchbox.feed.widget.scrolllguide.ArrowGuidePolicy;
import com.baidu.searchbox.feed.widget.scrolllguide.IGuidePolicyDiskCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/guide/DynamicGuidePolicy;", "Lcom/baidu/searchbox/feed/widget/scrolllguide/ArrowGuidePolicy;", "diskCache", "Lcom/baidu/searchbox/feed/widget/scrolllguide/IGuidePolicyDiskCache;", "(Lcom/baidu/searchbox/feed/widget/scrolllguide/IGuidePolicyDiskCache;)V", "guideStatus", "", "fromJson", "", "jsonString", "isValid", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicGuidePolicy.kt */
public final class DynamicGuidePolicy extends ArrowGuidePolicy {
    private String guideStatus = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicGuidePolicy(IGuidePolicyDiskCache diskCache) {
        super(diskCache);
        Intrinsics.checkNotNullParameter(diskCache, "diskCache");
        fromJson(diskCache.loadCache());
    }

    public void fromJson(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            JSONObject json = new JSONObject(jsonString);
            String optString = json.optString(DynamicGuidePolicyKt.KEY_GUIDE_STATUS, "0");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(KEY_GUIDE_STATUS, VALUE_GUIDE_NO)");
            this.guideStatus = optString;
            String optString2 = json.optString(DynamicGuidePolicyKt.KEY_GUIDE_TITLE, "");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(KEY_GUIDE_TITLE, \"\")");
            setGuideTitle(optString2);
            setGuideTimes(json.optInt("guide_times", 0));
            setGuideDelayMillis(json.optInt("guide_interval", 0));
            setGuideCycle(json.optInt(DynamicGuidePolicyKt.KEY_GUIDE_CYCLE, 0));
            setGuideDuration(json.optInt("guideDuration", 0));
            setOriginJson(jsonString);
        } catch (JSONException e2) {
        }
    }

    public boolean isValid() {
        if (Intrinsics.areEqual((Object) this.guideStatus, (Object) "1")) {
            if ((getGuideTitle().length() > 0) && getGuideTimes() > 0 && getGuideCycle() >= 0 && getGuideDelayMillis() >= 0) {
                return true;
            }
        }
        return false;
    }
}
