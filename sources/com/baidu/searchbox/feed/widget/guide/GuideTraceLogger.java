package com.baidu.searchbox.feed.widget.guide;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.statistic.FeedUBCWrapper;
import com.baidu.searchbox.theme.skin.utils.SkinDataParser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J.\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/feed/widget/guide/GuideTraceLogger;", "", "()V", "log4Guide", "", "message", "", "channelId", "ubcGuideView", "type", "subType", "ubcReceiveUpdate", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuideTraceLogger.kt */
public final class GuideTraceLogger {
    public static final GuideTraceLogger INSTANCE = new GuideTraceLogger();

    private GuideTraceLogger() {
    }

    @JvmStatic
    public static final void log4Guide(String message, String channelId) {
        Intrinsics.checkNotNullParameter(message, "message");
        OnLineLog.get(OnLineLog.TAG_CONTAINER).d("ShakeManager,, channelId=" + channelId + ", message=" + message);
    }

    @JvmStatic
    public static final void ubcReceiveUpdate(String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ubcGuideView$default(INSTANCE, SkinDataParser.KEY_ATTRS_SUM, (String) null, (String) null, channelId, 6, (Object) null);
    }

    static /* synthetic */ void ubcGuideView$default(GuideTraceLogger guideTraceLogger, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "";
        }
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        guideTraceLogger.ubcGuideView(str, str2, str3, str4);
    }

    private final void ubcGuideView(String type, String subType, String message, String channelId) {
        JSONObject map = new JSONObject();
        try {
            JSONObject ext = new JSONObject();
            ext.put("type", type);
            ext.put("subtype", subType);
            ext.put("message", message);
            ext.put("channel_id", channelId);
            map.put("ext", ext);
            map.put("type", "for_analyze");
            FeedUBCWrapper.ubcOnEvent(FeedStatisticConstants.UBC_USER_GUIDE_ID, map);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }
}
