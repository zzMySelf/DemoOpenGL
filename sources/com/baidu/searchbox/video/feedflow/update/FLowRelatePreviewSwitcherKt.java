package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewConfig;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowSpHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u00103\u001a\u000204\u001a\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u000208\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"FLOW_VIDEO_RELATE_PREVIEW_CONFIG_VERSION", "", "FLOW_VIDEO_RELATE_PREVIEW_CONFIG_VERSION_FLOOR", "FLOW_VIDEO_RELATE_PREVIEW_CONFIG_VERSION_SCENE", "FLOW_VIDEO_RELATE_PREVIEW_DAY_RANGE", "FLOW_VIDEO_RELATE_PREVIEW_FIRST_VIDEO_SHOW", "FLOW_VIDEO_RELATE_PREVIEW_NOSCROLL_TIME", "FLOW_VIDEO_RELATE_PREVIEW_NOSHOW_DAY", "FLOW_VIDEO_RELATE_PREVIEW_OPERATE_CONF", "FLOW_VIDEO_RELATE_PREVIEW_PD_BLACK_LIST", "FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT", "FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT_FLOOR", "FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT_SCENE", "FLOW_VIDEO_RELATE_PREVIEW_SHOW_TIME", "FLOW_VIDEO_RELATE_PREVIEW_SHOW_TYPE", "FLOW_VIDEO_RELATE_PREVIEW_SOURCE_PAGE", "FLOW_VIDEO_RELATE_PREVIEW_START_TIME", "FLOW_VIDEO_RELATE_PREVIEW_START_TIME_FLOOR", "FLOW_VIDEO_RELATE_PREVIEW_START_TIME_SCENE", "FLOW_VIDEO_RELATE_PREVIEW_SWITCH", "FLOW_VIDEO_RELATE_PREVIEW_SWITCH_CONF", "FLOW_VIDEO_RELATE_PREVIEW_TIME_RANGE", "FLOW_VIDEO_RELATE_PREVIEW_TITLE", "FLOW_VIDEO_RELATE_PREVIEW_VIDEO_PROGRESS", "GUIDE_DAY_RANGE", "GUIDE_TIME_RANGE", "OPERATE_CONF", "PANEL_TITLE", "PD_BLACK_LIST", "RELATE_PREVIEW_CONF", "RELATE_PREVIEW_FIRST_VIDEO_SHOW", "RELATE_PREVIEW_SHOW_TIME", "RELATE_PREVIEW_SHOW_TYPE", "RELATE_PREVIEW_SWITCH", "RELATE_PREVIEW_VERSION", "RELATE_PREVIEW_VIDEO_PROGRESS", "SOURCE_PAGE", "UNSCROLL_TIME", "UNSHWO_DAY", "VIDEO_FLOW_RELATE_PREVIEW_CLOSE", "VIDEO_FLOW_RELATE_PREVIEW_CLOSE_FLOOR", "VIDEO_FLOW_RELATE_PREVIEW_CLOSE_SCENE", "VIDEO_FLOW_RELATE_PREVIEW_CLOSE_TIME", "VIDEO_FLOW_RELATE_PREVIEW_CLOSE_TIME_FLOOR", "VIDEO_FLOW_RELATE_PREVIEW_CLOSE_TIME_SCENE", "VIDEO_FLOW_RELATE_PREVIEW_NOSCROLL_TIME", "VIDEO_FLOW_RELATE_PREVIEW_NOSCROLL_TIME_FLOOR", "VIDEO_FLOW_RELATE_PREVIEW_NOSCROLL_TIME_SCENE", "VIDEO_FLOW_RELATE_PREVIEW_SHOW_TIME", "VIDEO_FLOW_RELATE_PREVIEW_SHOW_TIME_FLOOR", "VIDEO_FLOW_RELATE_PREVIEW_SHOW_TIME_SCENE", "getRelatedPreviewConfig", "Lcom/baidu/searchbox/video/feedflow/detail/relatedpreview/RelatedPreviewConfig;", "handleFlowRelatePreviewSwitch", "", "data", "Lorg/json/JSONObject;", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FLowRelatePreviewSwitcher.kt */
public final class FLowRelatePreviewSwitcherKt {
    public static final String FLOW_VIDEO_RELATE_PREVIEW_CONFIG_VERSION = "flow_video_releated_preview_config_version";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_CONFIG_VERSION_FLOOR = "flow_video_releated_preview_config_version_floor_";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_CONFIG_VERSION_SCENE = "flow_video_releated_preview_config_version_scene_";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_DAY_RANGE = "flow_video_releated_preview_day_range";
    public static final String FLOW_VIDEO_RELATE_PREVIEW_FIRST_VIDEO_SHOW = "flow_video_releated_preview_first_video_show";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_NOSCROLL_TIME = "flow_video_releated_preview_noscroll_time";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_NOSHOW_DAY = "flow_video_releated_preview_noshow_day";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_OPERATE_CONF = "flow_video_releated_preview_operate_conf";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_PD_BLACK_LIST = "flow_video_releated_preview_pd_black_list";
    public static final String FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT = "flow_video_releated_preview_show_count";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT_FLOOR = "flow_video_releated_preview_show_count_floor_";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT_SCENE = "flow_video_releated_preview_show_count_scene_";
    public static final String FLOW_VIDEO_RELATE_PREVIEW_SHOW_TIME = "flow_video_releated_preview_show_time_switch";
    public static final String FLOW_VIDEO_RELATE_PREVIEW_SHOW_TYPE = "flow_video_releated_preview_show_type";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_SOURCE_PAGE = "flow_video_releated_preview_source_page";
    public static final String FLOW_VIDEO_RELATE_PREVIEW_START_TIME = "flow_video_releated_preview_start_time";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_START_TIME_FLOOR = "flow_video_releated_preview_start_time_floor_";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_START_TIME_SCENE = "flow_video_releated_preview_start_time_scene_";
    public static final String FLOW_VIDEO_RELATE_PREVIEW_SWITCH = "flow_video_releated_preview_switch";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_SWITCH_CONF = "releated_preview_video";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_TIME_RANGE = "flow_video_releated_preview_time_range";
    private static final String FLOW_VIDEO_RELATE_PREVIEW_TITLE = "flow_video_releated_preview_releated_title";
    public static final String FLOW_VIDEO_RELATE_PREVIEW_VIDEO_PROGRESS = "flow_video_releated_preview_video_progress";
    private static final String GUIDE_DAY_RANGE = "guide_day_range";
    private static final String GUIDE_TIME_RANGE = "guide_time_range";
    private static final String OPERATE_CONF = "operate_conf";
    private static final String PANEL_TITLE = "title";
    private static final String PD_BLACK_LIST = "pd_blacklist";
    private static final String RELATE_PREVIEW_CONF = "releated_preview_conf";
    private static final String RELATE_PREVIEW_FIRST_VIDEO_SHOW = "onlyfirstvideo_switch";
    private static final String RELATE_PREVIEW_SHOW_TIME = "show_time";
    private static final String RELATE_PREVIEW_SHOW_TYPE = "type";
    private static final String RELATE_PREVIEW_SWITCH = "switch";
    private static final String RELATE_PREVIEW_VERSION = "version";
    private static final String RELATE_PREVIEW_VIDEO_PROGRESS = "video_progress";
    private static final String SOURCE_PAGE = "source_page";
    private static final String UNSCROLL_TIME = "guide_unscroll_time";
    private static final String UNSHWO_DAY = "guide_unscroll_day";
    public static final String VIDEO_FLOW_RELATE_PREVIEW_CLOSE = "flow_video_releated_preview_close";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_CLOSE_FLOOR = "flow_video_releated_preview_close_floor_";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_CLOSE_SCENE = "flow_video_releated_preview_close_scene_";
    public static final String VIDEO_FLOW_RELATE_PREVIEW_CLOSE_TIME = "flow_video_releated_preview_close_time";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_CLOSE_TIME_FLOOR = "flow_video_releated_preview_close_time_floor_";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_CLOSE_TIME_SCENE = "flow_video_releated_preview_close_time_scene_";
    public static final String VIDEO_FLOW_RELATE_PREVIEW_NOSCROLL_TIME = "flow_video_releated_preview_noscroll_count";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_NOSCROLL_TIME_FLOOR = "flow_video_releated_preview_noscroll_count_floor_";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_NOSCROLL_TIME_SCENE = "flow_video_releated_preview_noscroll_count_scene_";
    public static final String VIDEO_FLOW_RELATE_PREVIEW_SHOW_TIME = "flow_video_releated_preview_show_time_stamp";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_SHOW_TIME_FLOOR = "flow_video_releated_preview_show_time_stamp_floor_";
    private static final String VIDEO_FLOW_RELATE_PREVIEW_SHOW_TIME_SCENE = "flow_video_releated_preview_show_time_stamp_scene_";

    public static final void handleFlowRelatePreviewSwitch(JSONObject data) {
        JSONObject jSONObject = data;
        Intrinsics.checkNotNullParameter(jSONObject, "data");
        try {
            JSONObject relatePreviewSwitchConfig = jSONObject.optJSONObject(FLOW_VIDEO_RELATE_PREVIEW_SWITCH_CONF);
            FlowRelatePreviewSwitcher.INSTANCE.setSwitch(Intrinsics.areEqual((Object) relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optString("switch") : null, (Object) "1"));
            String showType = "2";
            String optString = relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optString("type", showType) : null;
            if (optString != null) {
                showType = optString;
            }
            FlowRelatePreviewSwitcher.INSTANCE.setShowType(showType);
            int masterVersion = BdPlayerUtils.orZero(relatePreviewSwitchConfig != null ? Integer.valueOf(relatePreviewSwitchConfig.optInt("version")) : null);
            if (masterVersion > FlowRelatePreviewSwitcher.getConfigVersionByLevel$default(FlowRelatePreviewSwitcher.INSTANCE, "total", (String) null, 2, (Object) null)) {
                FlowRelatePreviewSwitcher.INSTANCE.resetAllMasterLocalData();
                FlowRelatePreviewSwitcher.recordConfigVersionByLevel$default(FlowRelatePreviewSwitcher.INSTANCE, "total", (String) null, masterVersion, 2, (Object) null);
            }
            boolean isFirstVideoShow = Intrinsics.areEqual((Object) relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optString("onlyfirstvideo_switch") : null, (Object) "1");
            FlowRelatePreviewSwitcher.INSTANCE.setFirstVideoShow(isFirstVideoShow);
            int showTime = relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optInt("show_time", 0) : 0;
            FlowRelatePreviewSwitcher.INSTANCE.setShowTime(showTime);
            double videoProgress = 0.3d;
            if (relatePreviewSwitchConfig != null) {
                videoProgress = relatePreviewSwitchConfig.optDouble("video_progress", 0.3d);
            }
            FlowRelatePreviewSwitcher.INSTANCE.setVideoProgress(videoProgress);
            JSONObject dateConfig = relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optJSONObject(RELATE_PREVIEW_CONF) : null;
            int guideDay = dateConfig != null ? dateConfig.optInt("guide_day_range", 1) : 1;
            if (guideDay != VideoFlowSpHelper.INSTANCE.getInt(FLOW_VIDEO_RELATE_PREVIEW_DAY_RANGE, 1)) {
                VideoFlowSpHelper.INSTANCE.putInt(FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT, 0);
                int i2 = showTime;
                VideoFlowSpHelper.INSTANCE.putLong(FLOW_VIDEO_RELATE_PREVIEW_START_TIME, 0);
            }
            FlowRelatePreviewSwitcher.INSTANCE.setGuideDay(guideDay);
            int guideTime = dateConfig != null ? dateConfig.optInt("guide_time_range", 100) : 100;
            if (guideTime != VideoFlowSpHelper.INSTANCE.getInt(FLOW_VIDEO_RELATE_PREVIEW_TIME_RANGE, 100)) {
                VideoFlowSpHelper.INSTANCE.putInt(FLOW_VIDEO_RELATE_PREVIEW_SHOW_COUNT, 0);
                VideoFlowSpHelper.INSTANCE.putLong(FLOW_VIDEO_RELATE_PREVIEW_START_TIME, 0);
            }
            FlowRelatePreviewSwitcher.INSTANCE.setGuideTime(guideTime);
            int noScrollTime = 3;
            if (dateConfig != null) {
                noScrollTime = dateConfig.optInt("guide_unscroll_time", 3);
            }
            FlowRelatePreviewSwitcher.INSTANCE.setNoScrollTime(noScrollTime);
            int noShowDay = 999;
            if (dateConfig != null) {
                noShowDay = dateConfig.optInt("guide_unscroll_day", 999);
            }
            FlowRelatePreviewSwitcher.INSTANCE.setNoShowDay(noShowDay);
            String sourcePage = relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optString(SOURCE_PAGE) : null;
            String customConfig = "";
            if (sourcePage == null) {
                sourcePage = customConfig;
            }
            FlowRelatePreviewSwitcher.INSTANCE.setSourcePage(sourcePage);
            String pdString = relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optString(PD_BLACK_LIST) : null;
            if (pdString == null) {
                pdString = customConfig;
            }
            boolean z = isFirstVideoShow;
            FlowRelatePreviewSwitcher.INSTANCE.setPdString(pdString);
            String title = relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optString("title") : null;
            if (title == null) {
                title = customConfig;
            }
            FlowRelatePreviewSwitcher.INSTANCE.setTitleViewTxt(title);
            String optString2 = relatePreviewSwitchConfig != null ? relatePreviewSwitchConfig.optString(OPERATE_CONF) : null;
            if (optString2 != null) {
                customConfig = optString2;
            }
            FlowRelatePreviewSwitcher.INSTANCE.setOperateConf(customConfig);
        } catch (JSONException e2) {
        }
    }

    public static final RelatedPreviewConfig getRelatedPreviewConfig() {
        return FlowRelatePreviewSwitcher.INSTANCE.getRelatedPreviewConfig();
    }
}
