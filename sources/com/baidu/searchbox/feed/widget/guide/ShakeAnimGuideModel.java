package com.baidu.searchbox.feed.widget.guide;

import android.text.TextUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.download.constants.DownloadRecommendConstants;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.flow.impl.ShakeProcessor;
import com.baidu.searchbox.feed.widget.guide.help.ReceivedShakeDataEvent;
import com.baidu.searchbox.view.MiniVideoAdFormPopupView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\rH\u0007J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\"\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\rH\u0007J$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J\u0016\u0010\u001a\u001a\u00020\u0005*\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/widget/guide/ShakeAnimGuideModel;", "", "()V", "channelGuideSuffixMap", "", "", "showLock", "", "getShowLock", "()Z", "setShowLock", "(Z)V", "getQuickLong", "", "key", "channelId", "default", "getQuickString", "parseData", "", "obj", "Lorg/json/JSONObject;", "parseModel", "putQuickLong", "value", "putQuickString", "channelSuffix", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShakeAnimGuideModel.kt */
public final class ShakeAnimGuideModel {
    public static final ShakeAnimGuideModel INSTANCE = new ShakeAnimGuideModel();
    private static final Map<String, String> channelGuideSuffixMap = MapsKt.mapOf(TuplesKt.to("1", ""), TuplesKt.to("178", "_discover"));
    private static boolean showLock = true;

    private ShakeAnimGuideModel() {
    }

    public final boolean getShowLock() {
        return showLock;
    }

    public final void setShowLock(boolean z) {
        showLock = z;
    }

    public final void parseData(JSONObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        JSONObject json = obj.optJSONObject("slide_guide");
        if (json != null) {
            INSTANCE.parseModel(json, "1");
        }
        JSONObject findJson = obj.optJSONObject("slide_guide_find");
        if (findJson != null) {
            INSTANCE.parseModel(findJson, "178");
        }
    }

    private final void parseModel(JSONObject obj, String channelId) {
        String guideVersion = obj.optString("version");
        if (!TextUtils.equals(guideVersion, getQuickString("shake_anim_version", channelId, "0"))) {
            putQuickString("shake_anim_version", channelId, guideVersion);
            putQuickString(ShakeProcessor.USER_TYPE, channelId, obj.optString("user_type"));
            putQuickString(ShakeProcessor.SHOW_PAGE, channelId, obj.optString("show_page"));
            putQuickString(ShakeProcessor.GUIDE_TEXT, channelId, obj.optString("text"));
            putQuickString(ShakeProcessor.GUIDE_BG_COLOR, channelId, obj.optString(MiniVideoAdFormPopupView.BG_COLOR));
            putQuickString(ShakeProcessor.GUIDE_BG_NIGHT_COLOR, channelId, obj.optString("bg_night_color"));
            putQuickString(ShakeProcessor.SHAKE_ANIM_INTERVAL, channelId, obj.optString(DownloadRecommendConstants.UNINSTALLED_APK_TIPS_SHOW_TIMES_DAY_INTERVAL));
            putQuickString(ShakeProcessor.GUIDE_TEST_STYLE, channelId, obj.optString(ShakeProcessor.GUIDE_TEST_STYLE));
            GuideTraceLogger.ubcReceiveUpdate(channelId);
            BdEventBus.Companion.getDefault().post(new ReceivedShakeDataEvent(channelId));
        }
    }

    private final String channelSuffix(String $this$channelSuffix, String channelId) {
        return $this$channelSuffix + channelGuideSuffixMap.get(channelId);
    }

    @JvmStatic
    public static final void putQuickString(String key, String channelId, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        FeedPreferenceUtils.putQuickString(INSTANCE.channelSuffix(key, channelId), value);
    }

    @JvmStatic
    public static final String getQuickString(String key, String channelId, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        String quickString = FeedPreferenceUtils.getQuickString(INSTANCE.channelSuffix(key, channelId), str);
        Intrinsics.checkNotNullExpressionValue(quickString, "getQuickString(key.chann…ffix(channelId), default)");
        return quickString;
    }

    @JvmStatic
    public static final void putQuickLong(String key, String channelId, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        FeedPreferenceUtils.putQuickLong(INSTANCE.channelSuffix(key, channelId), value);
    }

    @JvmStatic
    public static final long getQuickLong(String key, String channelId, long j2) {
        Intrinsics.checkNotNullParameter(key, "key");
        return FeedPreferenceUtils.getQuickLong(INSTANCE.channelSuffix(key, channelId), j2);
    }
}
