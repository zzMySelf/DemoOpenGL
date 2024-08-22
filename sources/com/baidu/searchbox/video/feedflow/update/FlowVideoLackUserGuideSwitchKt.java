package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import com.baidu.searchbox.video.detail.switcher.VideoUpdateSwitcher;
import com.baidu.searchbox.video.feedflow.tab.videolackguide.FlowVideoLackGuideConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010;\u001a\u00020<\u001a\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8B@BX\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \"+\u0010#\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8B@BX\u0002¢\u0006\u0012\n\u0004\b&\u0010\"\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010 \"+\u0010'\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8B@BX\u0002¢\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 \"+\u0010+\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8B@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\"\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 \"+\u0010/\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8B@BX\u0002¢\u0006\u0012\n\u0004\b2\u0010\"\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 \"+\u00103\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8B@BX\u0002¢\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 \"+\u00107\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0002¢\u0006\u0012\n\u0004\b:\u0010\u001a\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018¨\u0006A"}, d2 = {"KEY_VIDEO_LACK_USER_GUIDE_AVOID_SWITCH", "", "KEY_VIDEO_LACK_USER_GUIDE_CLOSE_COUNT_LIMIT", "KEY_VIDEO_LACK_USER_GUIDE_CLOSE_DAY_LIMIT", "KEY_VIDEO_LACK_USER_GUIDE_DAY_SHOW_MAX", "KEY_VIDEO_LACK_USER_GUIDE_DAY_TOTAL_SHOW_MAX", "KEY_VIDEO_LACK_USER_GUIDE_DISMISS_DAYS", "KEY_VIDEO_LACK_USER_GUIDE_OVERLOOK_MAX", "KEY_VIDEO_LACK_USER_GUIDE_SWITCH", "NAME_VIDEO_LACK_USER_GUIDE_AVOID_SWITCH", "NAME_VIDEO_LACK_USER_GUIDE_CONFIG", "NAME_VIDEO_LACK_USER_GUIDE_DAY_SHOW", "NAME_VIDEO_LACK_USER_GUIDE_DAY_TOTAL_SHOW", "NAME_VIDEO_LACK_USER_GUIDE_LIMIT_X", "NAME_VIDEO_LACK_USER_GUIDE_LIMIT_Y", "NAME_VIDEO_LACK_USER_GUIDE_LIMIT_Z", "NAME_VIDEO_LACK_USER_GUIDE_OVERLOOK_MAX", "NAME_VIDEO_LACK_USER_GUIDE_SWITCH", "<set-?>", "", "videoLackUserGuideAvoidSwitch", "getVideoLackUserGuideAvoidSwitch", "()Z", "setVideoLackUserGuideAvoidSwitch", "(Z)V", "videoLackUserGuideAvoidSwitch$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoUpdateSwitcher;", "", "videoLackUserGuideDayShowMax", "getVideoLackUserGuideDayShowMax", "()I", "setVideoLackUserGuideDayShowMax", "(I)V", "videoLackUserGuideDayShowMax$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "videoLackUserGuideDayTotalShowMax", "getVideoLackUserGuideDayTotalShowMax", "setVideoLackUserGuideDayTotalShowMax", "videoLackUserGuideDayTotalShowMax$delegate", "videoLackUserGuideDismissCountLimit", "getVideoLackUserGuideDismissCountLimit", "setVideoLackUserGuideDismissCountLimit", "videoLackUserGuideDismissCountLimit$delegate", "videoLackUserGuideDismissDayLimit", "getVideoLackUserGuideDismissDayLimit", "setVideoLackUserGuideDismissDayLimit", "videoLackUserGuideDismissDayLimit$delegate", "videoLackUserGuideDismissDays", "getVideoLackUserGuideDismissDays", "setVideoLackUserGuideDismissDays", "videoLackUserGuideDismissDays$delegate", "videoLackUserGuideOverlookMax", "getVideoLackUserGuideOverlookMax", "setVideoLackUserGuideOverlookMax", "videoLackUserGuideOverlookMax$delegate", "videoLackUserGuideSwitch", "getVideoLackUserGuideSwitch", "setVideoLackUserGuideSwitch", "videoLackUserGuideSwitch$delegate", "getVideoLackUserGuideConfig", "Lcom/baidu/searchbox/video/feedflow/tab/videolackguide/FlowVideoLackGuideConfig;", "handleFlowVideoLackUserGuideConfig", "", "data", "Lorg/json/JSONObject;", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoLackUserGuideSwitch.kt */
public final class FlowVideoLackUserGuideSwitchKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private static final String KEY_VIDEO_LACK_USER_GUIDE_AVOID_SWITCH = "video_lack_user_guide_avoid_switch";
    private static final String KEY_VIDEO_LACK_USER_GUIDE_CLOSE_COUNT_LIMIT = "video_lack_user_guide_close_count_limit";
    private static final String KEY_VIDEO_LACK_USER_GUIDE_CLOSE_DAY_LIMIT = "video_lack_user_guide_close_day_limit";
    private static final String KEY_VIDEO_LACK_USER_GUIDE_DAY_SHOW_MAX = "video_lack_user_guide_day_show_max";
    private static final String KEY_VIDEO_LACK_USER_GUIDE_DAY_TOTAL_SHOW_MAX = "video_lack_user_guide_day_total_show_max";
    private static final String KEY_VIDEO_LACK_USER_GUIDE_DISMISS_DAYS = "video_lack_user_guide_dismiss_days";
    private static final String KEY_VIDEO_LACK_USER_GUIDE_OVERLOOK_MAX = "video_lack_user_guide_overlook_max";
    private static final String KEY_VIDEO_LACK_USER_GUIDE_SWITCH = "video_lack_user_guide_switch";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_AVOID_SWITCH = "bubble_avoid_switch";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_CONFIG = "dibar_showless_bubble";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_DAY_SHOW = "show_time";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_DAY_TOTAL_SHOW = "show_time_all";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_LIMIT_X = "exit_period";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_LIMIT_Y = "exit_trigger_cnt";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_LIMIT_Z = "exit_days";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_OVERLOOK_MAX = "exit_max_cnt";
    private static final String NAME_VIDEO_LACK_USER_GUIDE_SWITCH = "bubble_show_switch";
    private static final VideoUpdateSwitcher videoLackUserGuideAvoidSwitch$delegate = new VideoUpdateSwitcher(KEY_VIDEO_LACK_USER_GUIDE_AVOID_SWITCH, false);
    private static final VideoSPData videoLackUserGuideDayShowMax$delegate = new VideoSPData(KEY_VIDEO_LACK_USER_GUIDE_DAY_SHOW_MAX, (Object) null, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoSPData videoLackUserGuideDayTotalShowMax$delegate = new VideoSPData(KEY_VIDEO_LACK_USER_GUIDE_DAY_TOTAL_SHOW_MAX, (Object) null, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoSPData videoLackUserGuideDismissCountLimit$delegate = new VideoSPData(KEY_VIDEO_LACK_USER_GUIDE_CLOSE_COUNT_LIMIT, (Object) null, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoSPData videoLackUserGuideDismissDayLimit$delegate = new VideoSPData(KEY_VIDEO_LACK_USER_GUIDE_CLOSE_DAY_LIMIT, (Object) null, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoSPData videoLackUserGuideDismissDays$delegate = new VideoSPData(KEY_VIDEO_LACK_USER_GUIDE_DISMISS_DAYS, (Object) null, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoSPData videoLackUserGuideOverlookMax$delegate = new VideoSPData(KEY_VIDEO_LACK_USER_GUIDE_OVERLOOK_MAX, (Object) null, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoUpdateSwitcher videoLackUserGuideSwitch$delegate = new VideoUpdateSwitcher(KEY_VIDEO_LACK_USER_GUIDE_SWITCH, false);

    static {
        Class<FlowVideoLackUserGuideSwitchKt> cls = FlowVideoLackUserGuideSwitchKt.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideSwitch", "getVideoLackUserGuideSwitch()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideAvoidSwitch", "getVideoLackUserGuideAvoidSwitch()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideDayShowMax", "getVideoLackUserGuideDayShowMax()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideDayTotalShowMax", "getVideoLackUserGuideDayTotalShowMax()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideOverlookMax", "getVideoLackUserGuideOverlookMax()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideDismissDayLimit", "getVideoLackUserGuideDismissDayLimit()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideDismissCountLimit", "getVideoLackUserGuideDismissCountLimit()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "videoLackUserGuideDismissDays", "getVideoLackUserGuideDismissDays()I", 1))};
    }

    public static final boolean getVideoLackUserGuideSwitch() {
        return ((Boolean) videoLackUserGuideSwitch$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    public static final void setVideoLackUserGuideSwitch(boolean z) {
        videoLackUserGuideSwitch$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public static final boolean getVideoLackUserGuideAvoidSwitch() {
        return ((Boolean) videoLackUserGuideAvoidSwitch$delegate.getValue((Object) null, $$delegatedProperties[1])).booleanValue();
    }

    public static final void setVideoLackUserGuideAvoidSwitch(boolean z) {
        videoLackUserGuideAvoidSwitch$delegate.setValue((Object) null, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    private static final int getVideoLackUserGuideDayShowMax() {
        return ((Number) videoLackUserGuideDayShowMax$delegate.getValue((Object) null, $$delegatedProperties[2])).intValue();
    }

    private static final void setVideoLackUserGuideDayShowMax(int i2) {
        videoLackUserGuideDayShowMax$delegate.setValue((Object) null, $$delegatedProperties[2], Integer.valueOf(i2));
    }

    private static final int getVideoLackUserGuideDayTotalShowMax() {
        return ((Number) videoLackUserGuideDayTotalShowMax$delegate.getValue((Object) null, $$delegatedProperties[3])).intValue();
    }

    private static final void setVideoLackUserGuideDayTotalShowMax(int i2) {
        videoLackUserGuideDayTotalShowMax$delegate.setValue((Object) null, $$delegatedProperties[3], Integer.valueOf(i2));
    }

    private static final int getVideoLackUserGuideOverlookMax() {
        return ((Number) videoLackUserGuideOverlookMax$delegate.getValue((Object) null, $$delegatedProperties[4])).intValue();
    }

    private static final void setVideoLackUserGuideOverlookMax(int i2) {
        videoLackUserGuideOverlookMax$delegate.setValue((Object) null, $$delegatedProperties[4], Integer.valueOf(i2));
    }

    private static final int getVideoLackUserGuideDismissDayLimit() {
        return ((Number) videoLackUserGuideDismissDayLimit$delegate.getValue((Object) null, $$delegatedProperties[5])).intValue();
    }

    private static final void setVideoLackUserGuideDismissDayLimit(int i2) {
        videoLackUserGuideDismissDayLimit$delegate.setValue((Object) null, $$delegatedProperties[5], Integer.valueOf(i2));
    }

    private static final int getVideoLackUserGuideDismissCountLimit() {
        return ((Number) videoLackUserGuideDismissCountLimit$delegate.getValue((Object) null, $$delegatedProperties[6])).intValue();
    }

    private static final void setVideoLackUserGuideDismissCountLimit(int i2) {
        videoLackUserGuideDismissCountLimit$delegate.setValue((Object) null, $$delegatedProperties[6], Integer.valueOf(i2));
    }

    private static final int getVideoLackUserGuideDismissDays() {
        return ((Number) videoLackUserGuideDismissDays$delegate.getValue((Object) null, $$delegatedProperties[7])).intValue();
    }

    private static final void setVideoLackUserGuideDismissDays(int i2) {
        videoLackUserGuideDismissDays$delegate.setValue((Object) null, $$delegatedProperties[7], Integer.valueOf(i2));
    }

    public static final void handleFlowVideoLackUserGuideConfig(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            JSONObject nodeConfig = data.optJSONObject(NAME_VIDEO_LACK_USER_GUIDE_CONFIG);
            Integer num = null;
            setVideoLackUserGuideSwitch(Intrinsics.areEqual((Object) nodeConfig != null ? nodeConfig.optString(NAME_VIDEO_LACK_USER_GUIDE_SWITCH) : null, (Object) "1"));
            setVideoLackUserGuideAvoidSwitch(Intrinsics.areEqual((Object) nodeConfig != null ? nodeConfig.optString(NAME_VIDEO_LACK_USER_GUIDE_AVOID_SWITCH) : null, (Object) "1"));
            setVideoLackUserGuideDayShowMax(BdPlayerUtils.orZero(nodeConfig != null ? Integer.valueOf(nodeConfig.optInt("show_time")) : null));
            setVideoLackUserGuideDayTotalShowMax(BdPlayerUtils.orZero(nodeConfig != null ? Integer.valueOf(nodeConfig.optInt(NAME_VIDEO_LACK_USER_GUIDE_DAY_TOTAL_SHOW)) : null));
            setVideoLackUserGuideOverlookMax(BdPlayerUtils.orZero(nodeConfig != null ? Integer.valueOf(nodeConfig.optInt(NAME_VIDEO_LACK_USER_GUIDE_OVERLOOK_MAX)) : null));
            setVideoLackUserGuideDismissDayLimit(BdPlayerUtils.orZero(nodeConfig != null ? Integer.valueOf(nodeConfig.optInt(NAME_VIDEO_LACK_USER_GUIDE_LIMIT_X)) : null));
            setVideoLackUserGuideDismissCountLimit(BdPlayerUtils.orZero(nodeConfig != null ? Integer.valueOf(nodeConfig.optInt(NAME_VIDEO_LACK_USER_GUIDE_LIMIT_Y)) : null));
            if (nodeConfig != null) {
                num = Integer.valueOf(nodeConfig.optInt(NAME_VIDEO_LACK_USER_GUIDE_LIMIT_Z));
            }
            setVideoLackUserGuideDismissDays(BdPlayerUtils.orZero(num));
        } catch (JSONException e2) {
        }
    }

    public static final FlowVideoLackGuideConfig getVideoLackUserGuideConfig() {
        return new FlowVideoLackGuideConfig(getVideoLackUserGuideSwitch(), getVideoLackUserGuideAvoidSwitch(), getVideoLackUserGuideDayShowMax(), getVideoLackUserGuideDayTotalShowMax(), getVideoLackUserGuideOverlookMax(), getVideoLackUserGuideDismissDayLimit(), getVideoLackUserGuideDismissCountLimit(), getVideoLackUserGuideDismissDays());
    }
}
