package com.baidu.searchbox.video.channel.tab;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;
import com.baidu.searchbox.home.tabs.update.HomeLaunchTabListener;
import com.baidu.searchbox.performance.speed.SpeedOptimize;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.settings.extend.ISettingsFun;
import com.baidu.searchbox.video.channel.HomeTabOperationManager;
import com.baidu.searchbox.video.channel.flow.scheme.ChannelSchemeJumpManager;
import com.baidu.searchbox.video.channel.flow.searchfold.SearchFoldConditionState;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.FlowComponentConstantManifestKt;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdAutoEnterType;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.tab.PageTabModel;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.utils.SchemeSearchBoxConfig;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010\u001d\u001a\u00020\u001e\u001a\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"\u001a\u0012\u0010#\u001a\u0004\u0018\u00010$2\b\u0010!\u001a\u0004\u0018\u00010\"\u001a\u0016\u0010#\u001a\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&\u001a\b\u0010'\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010(\u001a\u00020)\u001a\u0006\u0010*\u001a\u00020)\u001a\u0010\u0010+\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010-\u001a\u00020)2\u0006\u0010!\u001a\u00020\"\u001a\u0010\u0010.\u001a\u00020)2\b\u0010!\u001a\u0004\u0018\u00010\"\u001a\u0014\u0010.\u001a\u00020)2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&\u001a\n\u0010/\u001a\u000200*\u000201\u001a\f\u00102\u001a\u00020)*\u0004\u0018\u00010\"\u001a\u0010\u00102\u001a\u00020)*\b\u0012\u0002\b\u0003\u0018\u00010&\u001a\f\u00103\u001a\u00020)*\u0004\u0018\u000101\u001a\f\u00104\u001a\u00020)*\u0004\u0018\u000101\u001a\f\u00105\u001a\u000200*\u0004\u0018\u000101\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\" \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u00066"}, d2 = {"CHANNEL_SECONDARY_TASK_LEVEL_1", "", "CHANNEL_SECONDARY_TASK_LEVEL_2", "CHANNEL_SECONDARY_TASK_LEVEL_3", "KEY_CHANNEL_SOURCE_IN_INTENT", "MUTE_CONFIG_TAG_DEFAULT", "MUTE_CONFIG_TAG_SCHEME", "SEARCH_CONFIG_TAG_COLD_START", "SEARCH_CONFIG_TAG_OFFSITE", "SEARCH_CONFIG_TAG_SCHEME", "TOP_VIEW_MUTE_SETTING", "TOP_VIEW_MUTE_SETTING_LAST_TAG", "TOP_VIEW_MUTE_SETTING_TAG", "TOP_VIEW_SEARCH_BOX_CONFIG", "TOP_VIEW_SEARCH_BOX_CONFIG_TAG", "VALUE_CHANNEL_SOURCE_IN_INTENT", "channelRootManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "getChannelRootManager", "()Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "setChannelRootManager", "(Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;)V", "pageTabConfig", "Lcom/baidu/searchbox/video/feedflow/tab/PageTabModel;", "getPageTabConfig", "()Lcom/baidu/searchbox/video/feedflow/tab/PageTabModel;", "pageTabConfig$delegate", "Lkotlin/Lazy;", "getChannelDefaultSelectedTabId", "getColdAutoEnterType", "Lcom/baidu/searchbox/video/feedflow/flow/launchpanel/ColdAutoEnterType;", "getSchemeMuteConfig", "Lcom/baidu/searchbox/video/feedflow/utils/SchemeMuteConfig;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getSchemeSearchBoxConfig", "Lcom/baidu/searchbox/video/feedflow/utils/SchemeSearchBoxConfig;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "getSelectTabIdBySubTag", "isChannelInDarkMode", "", "isColdAutoEnterVideoTab", "isHasTopViewKey", "ext", "isShowSearchBoxFromFeedVideo", "isTopViewEnter", "clearSchemeTag", "", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "isColdEnterVideoTab", "isFeedChannelSource", "isFromAdTopView", "setFeedChannelKey", "video-channel_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTabUtils.kt */
public final class ChannelTabUtilsKt {
    public static final String CHANNEL_SECONDARY_TASK_LEVEL_1 = "channel_secondary_Task_Level_1";
    public static final String CHANNEL_SECONDARY_TASK_LEVEL_2 = "channel_secondary_Task_Level_2";
    public static final String CHANNEL_SECONDARY_TASK_LEVEL_3 = "channel_secondary_Task_Level_3";
    private static final String KEY_CHANNEL_SOURCE_IN_INTENT = "key_channel_source_in_intent";
    private static final String MUTE_CONFIG_TAG_DEFAULT = "mute_config_tag_default";
    private static final String MUTE_CONFIG_TAG_SCHEME = "mute_config_tag_scheme";
    private static final String SEARCH_CONFIG_TAG_COLD_START = "search_config_tag_cold_start";
    private static final String SEARCH_CONFIG_TAG_OFFSITE = "search_config_tag_offSite";
    private static final String SEARCH_CONFIG_TAG_SCHEME = "search_config_tag_scheme";
    private static final String TOP_VIEW_MUTE_SETTING = "top_view_mute_setting";
    private static final String TOP_VIEW_MUTE_SETTING_LAST_TAG = "top_view_mute_setting_last_tag";
    private static final String TOP_VIEW_MUTE_SETTING_TAG = "top_view_mute_setting_tag";
    private static final String TOP_VIEW_SEARCH_BOX_CONFIG = "top_view_search_box_config";
    private static final String TOP_VIEW_SEARCH_BOX_CONFIG_TAG = "top_view_search_box_config_tag";
    private static final String VALUE_CHANNEL_SOURCE_IN_INTENT = "feed_channel";
    private static ComponentArchManager channelRootManager;
    private static final Lazy pageTabConfig$delegate = LazyKt.lazy(ChannelTabUtilsKt$pageTabConfig$2.INSTANCE);

    public static final ComponentArchManager getChannelRootManager() {
        return channelRootManager;
    }

    public static final void setChannelRootManager(ComponentArchManager componentArchManager) {
        channelRootManager = componentArchManager;
    }

    private static final PageTabModel getPageTabConfig() {
        return (PageTabModel) pageTabConfig$delegate.getValue();
    }

    public static final String getChannelDefaultSelectedTabId() {
        String jumpTabId = ChannelSchemeJumpManager.INSTANCE.getJumpId();
        CharSequence charSequence = jumpTabId;
        boolean z = false;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            jumpTabId = HomeTabOperationManager.INSTANCE.getJumpTabId();
        }
        CharSequence charSequence2 = jumpTabId;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (z) {
            return getSelectTabIdBySubTag();
        }
        return jumpTabId;
    }

    public static final boolean isTopViewEnter(Store<?> store) {
        CommonState commonState = null;
        Object state = store != null ? store.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return isTopViewEnter(commonState);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r3.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isTopViewEnter(com.baidu.searchbox.feed.detail.arch.ext.CommonState r3) {
        /*
            if (r3 == 0) goto L_0x0011
            r0 = r3
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r2 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.extendBusiness
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            boolean r1 = isHasTopViewKey(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.ChannelTabUtilsKt.isTopViewEnter(com.baidu.searchbox.feed.detail.arch.ext.CommonState):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isHasTopViewKey(java.lang.String r5) {
        /*
            r0 = 0
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0035 }
            r2 = 1
            if (r1 == 0) goto L_0x0011
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x0035 }
            if (r1 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r1 = r0
            goto L_0x0012
        L_0x0011:
            r1 = r2
        L_0x0012:
            if (r1 == 0) goto L_0x001a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0035 }
            r1.<init>()     // Catch:{ Exception -> 0x0035 }
            goto L_0x001f
        L_0x001a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0035 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0035 }
        L_0x001f:
            java.lang.String r3 = "topview_key"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = "extObj.optString(KEY_TOPVIEW_AD_KEY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0035 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0035 }
            if (r3 <= 0) goto L_0x0037
            r0 = r2
            goto L_0x0037
        L_0x0035:
            r1 = move-exception
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.ChannelTabUtilsKt.isHasTopViewKey(java.lang.String):boolean");
    }

    public static final boolean isFromAdTopView(IntentData $this$isFromAdTopView) {
        return isHasTopViewKey($this$isFromAdTopView != null ? $this$isFromAdTopView.extendBusiness : null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState) r5.select(com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isColdEnterVideoTab(com.baidu.searchbox.feed.detail.arch.ext.CommonState r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0017
            r2 = r5
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState> r4 = com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState r2 = (com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState) r2
            if (r2 == 0) goto L_0x0017
            boolean r2 = r2.isColdLaunchAutoEnterVideoTab()
            if (r2 != r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.ChannelTabUtilsKt.isColdEnterVideoTab(com.baidu.searchbox.feed.detail.arch.ext.CommonState):boolean");
    }

    public static final boolean isColdEnterVideoTab(Store<?> $this$isColdEnterVideoTab) {
        if ($this$isColdEnterVideoTab != null) {
            Object state = $this$isColdEnterVideoTab.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(ColdLaunchEnterVideoTabState.class);
            }
            ColdLaunchEnterVideoTabState coldLaunchEnterVideoTabState = (ColdLaunchEnterVideoTabState) obj;
            if (coldLaunchEnterVideoTabState != null && coldLaunchEnterVideoTabState.isColdLaunchAutoEnterVideoTab()) {
                return true;
            }
        }
        return false;
    }

    public static final SchemeSearchBoxConfig getSchemeSearchBoxConfig(Store<?> store) {
        CommonState commonState = null;
        Object state = store != null ? store.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return getSchemeSearchBoxConfig(commonState);
    }

    public static final SchemeSearchBoxConfig getSchemeSearchBoxConfig(CommonState state) {
        String str;
        SchemeSearchBoxConfig $this$getSchemeSearchBoxConfig_u24lambda_u2d2;
        Integer num;
        Integer num2;
        if (state == null) {
            return null;
        }
        try {
            IntentData intentData = (IntentData) state.select(IntentData.class);
            if (intentData == null) {
                return null;
            }
            IntentData intentData2 = intentData;
            Object extend = intentData2.getExtend(TOP_VIEW_SEARCH_BOX_CONFIG);
            SchemeSearchBoxConfig intentConfig = extend instanceof SchemeSearchBoxConfig ? (SchemeSearchBoxConfig) extend : null;
            Object intentConfigTag = intentData2.getExtend(TOP_VIEW_SEARCH_BOX_CONFIG_TAG);
            if (intentConfig != null && Intrinsics.areEqual(intentConfigTag, (Object) intentConfig.getTag())) {
                return intentConfig;
            }
            String str2 = intentData2.extendBusiness;
            String serverDismissDuration = "";
            if (str2 == null) {
                str2 = serverDismissDuration;
            }
            String extBusiness = str2;
            JSONObject config = extBusiness.length() == 0 ? null : new JSONObject(extBusiness).optJSONObject(SpeedOptimize.PAGE_SEARCHBOX);
            if (config != null) {
                String optString = config.optString("styleTypeNew");
                if (optString == null) {
                    optString = serverDismissDuration;
                }
                String str3 = optString;
                if (str3.length() == 0) {
                    str = config.optString("styleType");
                    if (str == null) {
                        str = serverDismissDuration;
                    }
                    Object serverStyle = str;
                } else {
                    str = str3;
                }
                String optString2 = config.optString("dismissDuration");
                if (optString2 != null) {
                    serverDismissDuration = optString2;
                }
                String serverDismissLimitLength = config.optString("dismissLimitLength");
                String serverQuery = config.optString("query");
                String serverQueryValidLength = config.optString("queryValidLength");
                String serverSwitch = config.optString("disableAutoSwitchQuery");
                SchemeSearchBoxConfig schemeSearchBoxConfig = new SchemeSearchBoxConfig((String) null, (String) null, (Integer) null, (String) null, false, (Integer) null, (String) null, 127, (DefaultConstructorMarker) null);
                SchemeSearchBoxConfig $this$getSchemeSearchBoxConfig_u24lambda_u2d22 = schemeSearchBoxConfig;
                if (!StringsKt.isBlank(str)) {
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2 = $this$getSchemeSearchBoxConfig_u24lambda_u2d22;
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2.setStyleType(str);
                } else {
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2 = $this$getSchemeSearchBoxConfig_u24lambda_u2d22;
                }
                if (!StringsKt.isBlank(serverDismissDuration)) {
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2.setDismissDuration(serverDismissDuration);
                }
                Intrinsics.checkNotNullExpressionValue(serverDismissLimitLength, "serverDismissLimitLength");
                if (serverDismissLimitLength.length() > 0) {
                    try {
                        num2 = Integer.valueOf(Integer.parseInt(serverDismissLimitLength));
                    } catch (Exception e2) {
                        num2 = 1;
                    }
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2.setDismissLimitLength(num2);
                }
                Intrinsics.checkNotNullExpressionValue(serverQuery, "serverQuery");
                if (!StringsKt.isBlank(serverQuery)) {
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2.setQuery(serverQuery);
                }
                String serverSwitch2 = serverSwitch;
                Intrinsics.checkNotNullExpressionValue(serverSwitch2, "serverSwitch");
                if (!StringsKt.isBlank(serverSwitch2)) {
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2.setDisableAutoSwitchQuery(Intrinsics.areEqual((Object) serverSwitch2, (Object) "1"));
                }
                Intrinsics.checkNotNullExpressionValue(serverQueryValidLength, "serverQueryValidLength");
                if (serverQueryValidLength.length() > 0) {
                    try {
                        num = Integer.valueOf(Integer.parseInt(serverQueryValidLength));
                    } catch (Exception e3) {
                        num = -1;
                    }
                    $this$getSchemeSearchBoxConfig_u24lambda_u2d2.setQueryValidLength(num);
                }
                $this$getSchemeSearchBoxConfig_u24lambda_u2d2.setTag(SEARCH_CONFIG_TAG_SCHEME);
                SchemeSearchBoxConfig configModel = schemeSearchBoxConfig;
                intentData2.putExtend(TOP_VIEW_SEARCH_BOX_CONFIG, configModel);
                intentData2.putExtend(TOP_VIEW_SEARCH_BOX_CONFIG_TAG, configModel.getTag());
                return configModel;
            } else if (VideoFlowUtilsKt.offSiteLaunchPayment(state)) {
                SchemeSearchBoxConfig schemeSearchBoxConfig2 = new SchemeSearchBoxConfig((String) null, (String) null, (Integer) null, (String) null, false, (Integer) null, (String) null, 127, (DefaultConstructorMarker) null);
                SchemeSearchBoxConfig $this$getSchemeSearchBoxConfig_u24lambda_u2d0 = schemeSearchBoxConfig2;
                $this$getSchemeSearchBoxConfig_u24lambda_u2d0.setStyleType("expand");
                $this$getSchemeSearchBoxConfig_u24lambda_u2d0.setDismissLimitLength((Integer) null);
                $this$getSchemeSearchBoxConfig_u24lambda_u2d0.setTag(SEARCH_CONFIG_TAG_OFFSITE);
                intentData2.putExtend(TOP_VIEW_SEARCH_BOX_CONFIG, schemeSearchBoxConfig2);
                intentData2.putExtend(TOP_VIEW_SEARCH_BOX_CONFIG_TAG, schemeSearchBoxConfig2.getTag());
                return schemeSearchBoxConfig2;
            } else if (!isColdEnterVideoTab(state) || !isFeedChannelSource(intentData2)) {
                return null;
            } else {
                SchemeSearchBoxConfig schemeSearchBoxConfig3 = new SchemeSearchBoxConfig((String) null, (String) null, (Integer) null, (String) null, false, (Integer) null, (String) null, 127, (DefaultConstructorMarker) null);
                SchemeSearchBoxConfig $this$getSchemeSearchBoxConfig_u24lambda_u2d1 = schemeSearchBoxConfig3;
                $this$getSchemeSearchBoxConfig_u24lambda_u2d1.setStyleType(FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
                $this$getSchemeSearchBoxConfig_u24lambda_u2d1.addSupportLayout(ItemTypeManifestKt.getVideoOriginType());
                $this$getSchemeSearchBoxConfig_u24lambda_u2d1.addSupportLayout(ItemTypeManifestKt.AD_VIDEO_ITEM_LAYOUT);
                $this$getSchemeSearchBoxConfig_u24lambda_u2d1.addSupportLayout(ItemTypeManifestKt.AD_LIVE_ITEM_LAYOUT);
                $this$getSchemeSearchBoxConfig_u24lambda_u2d1.addSupportLayout(ItemTypeManifestKt.LIVE_ITEM_LAYOUT);
                SearchFoldConditionState searchFoldConditionState = (SearchFoldConditionState) state.select(SearchFoldConditionState.class);
                $this$getSchemeSearchBoxConfig_u24lambda_u2d1.setDismissLimitLength(Integer.valueOf(BdPlayerUtils.orZero(searchFoldConditionState != null ? Integer.valueOf(searchFoldConditionState.getSearchFoldCondition()) : null)));
                $this$getSchemeSearchBoxConfig_u24lambda_u2d1.setTag(SEARCH_CONFIG_TAG_COLD_START);
                intentData2.putExtend(TOP_VIEW_SEARCH_BOX_CONFIG, schemeSearchBoxConfig3);
                intentData2.putExtend(TOP_VIEW_SEARCH_BOX_CONFIG_TAG, schemeSearchBoxConfig3.getTag());
                return schemeSearchBoxConfig3;
            }
        } catch (Exception e4) {
            SchemeSearchBoxConfig schemeSearchBoxConfig4 = null;
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b7, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3.getExtend(TOP_VIEW_MUTE_SETTING_LAST_TAG), (java.lang.Object) MUTE_CONFIG_TAG_DEFAULT) == false) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig getSchemeMuteConfig(com.baidu.searchbox.feed.detail.arch.ext.CommonState r21) {
        /*
            java.lang.String r0 = "top_view_mute_setting_tag"
            java.lang.String r1 = "top_view_mute_setting"
            r2 = 0
            if (r21 == 0) goto L_0x0151
            r3 = r21
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r5 = r3.select(r5)     // Catch:{ Exception -> 0x014a }
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5     // Catch:{ Exception -> 0x014a }
            if (r5 != 0) goto L_0x0019
            r1 = r2
            goto L_0x0152
        L_0x0019:
            r3 = r5
            java.lang.Object r4 = r3.getExtend(r1)     // Catch:{ Exception -> 0x014a }
            boolean r5 = r4 instanceof com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig     // Catch:{ Exception -> 0x014a }
            if (r5 == 0) goto L_0x0025
            com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig r4 = (com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig) r4     // Catch:{ Exception -> 0x014a }
            goto L_0x0026
        L_0x0025:
            r4 = r2
        L_0x0026:
            java.lang.Object r5 = r3.getExtend(r0)     // Catch:{ Exception -> 0x014a }
            if (r4 == 0) goto L_0x0037
            java.lang.String r6 = r4.getTag()     // Catch:{ Exception -> 0x014a }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ Exception -> 0x014a }
            if (r6 == 0) goto L_0x0037
            return r4
        L_0x0037:
            java.lang.String r6 = r3.extendBusiness     // Catch:{ Exception -> 0x014a }
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x003e
            r6 = r7
        L_0x003e:
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x014a }
            int r8 = r8.length()     // Catch:{ Exception -> 0x014a }
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L_0x004b
            r8 = r10
            goto L_0x004c
        L_0x004b:
            r8 = r9
        L_0x004c:
            java.lang.String r11 = "duration"
            java.lang.String r12 = "disable"
            if (r8 == 0) goto L_0x0054
            r8 = r2
            goto L_0x0095
        L_0x0054:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x014a }
            r8.<init>(r6)     // Catch:{ Exception -> 0x014a }
            java.lang.String r13 = "muteSetting"
            org.json.JSONObject r8 = r8.optJSONObject(r13)     // Catch:{ Exception -> 0x014a }
            if (r8 == 0) goto L_0x0066
            java.lang.String r13 = r8.optString(r12)     // Catch:{ Exception -> 0x014a }
            goto L_0x0067
        L_0x0066:
            r13 = r2
        L_0x0067:
            if (r13 != 0) goto L_0x006a
            r13 = r7
        L_0x006a:
            if (r8 == 0) goto L_0x0071
            java.lang.String r14 = r8.optString(r11)     // Catch:{ Exception -> 0x014a }
            goto L_0x0072
        L_0x0071:
            r14 = r2
        L_0x0072:
            if (r14 != 0) goto L_0x0075
            r14 = r7
        L_0x0075:
            r15 = r13
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x014a }
            int r15 = r15.length()     // Catch:{ Exception -> 0x014a }
            if (r15 != 0) goto L_0x0080
            r15 = r10
            goto L_0x0081
        L_0x0080:
            r15 = r9
        L_0x0081:
            if (r15 == 0) goto L_0x0094
            r15 = r14
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x014a }
            int r15 = r15.length()     // Catch:{ Exception -> 0x014a }
            if (r15 != 0) goto L_0x008d
            r9 = r10
        L_0x008d:
            if (r9 == 0) goto L_0x0094
            r9 = r2
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch:{ Exception -> 0x014a }
            r8 = r2
            goto L_0x0095
        L_0x0094:
        L_0x0095:
            java.lang.String r9 = "top_view_mute_setting_last_tag"
            if (r8 != 0) goto L_0x00ec
            boolean r13 = isFeedChannelSource(r3)     // Catch:{ Exception -> 0x014a }
            if (r13 == 0) goto L_0x00ec
            boolean r13 = isTopViewEnter((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r21)     // Catch:{ Exception -> 0x014a }
            java.lang.String r14 = "mute_config_tag_default"
            if (r13 != 0) goto L_0x00b9
            boolean r13 = isColdEnterVideoTab((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r21)     // Catch:{ Exception -> 0x014a }
            if (r13 == 0) goto L_0x00ec
            java.lang.Object r13 = r3.getExtend(r9)     // Catch:{ Exception -> 0x014a }
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x014a }
            if (r13 != 0) goto L_0x00ec
        L_0x00b9:
            com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig r7 = new com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig     // Catch:{ Exception -> 0x014a }
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 7
            r20 = 0
            r15 = r7
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x014a }
            r10 = r7
            r11 = 0
            java.lang.String r12 = "0"
            r10.setDisableValue(r12)     // Catch:{ Exception -> 0x014a }
            java.lang.String r12 = "3"
            r10.setDuration(r12)     // Catch:{ Exception -> 0x014a }
            r7.setTag(r14)     // Catch:{ Exception -> 0x014a }
            r3.putExtend(r1, r7)     // Catch:{ Exception -> 0x014a }
            java.lang.String r1 = r7.getTag()     // Catch:{ Exception -> 0x014a }
            r3.putExtend(r0, r1)     // Catch:{ Exception -> 0x014a }
            java.lang.String r0 = r7.getTag()     // Catch:{ Exception -> 0x014a }
            r3.putExtend(r9, r0)     // Catch:{ Exception -> 0x014a }
            return r7
        L_0x00ec:
            if (r8 == 0) goto L_0x00f3
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x014a }
            goto L_0x00f4
        L_0x00f3:
            r12 = r2
        L_0x00f4:
            if (r12 != 0) goto L_0x00f7
            r12 = r7
        L_0x00f7:
            if (r8 == 0) goto L_0x00fe
            java.lang.String r11 = r8.optString(r11)     // Catch:{ Exception -> 0x014a }
            goto L_0x00ff
        L_0x00fe:
            r11 = r2
        L_0x00ff:
            if (r11 != 0) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r7 = r11
        L_0x0103:
            com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig r11 = new com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig     // Catch:{ Exception -> 0x014a }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 7
            r18 = 0
            r13 = r11
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x014a }
            r13 = r11
            r14 = 0
            r15 = r12
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x014a }
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)     // Catch:{ Exception -> 0x014a }
            r15 = r15 ^ r10
            java.lang.String r2 = "mute_config_tag_scheme"
            if (r15 == 0) goto L_0x0125
            r13.setDisableValue(r12)     // Catch:{ Exception -> 0x014a }
            r13.setTag(r2)     // Catch:{ Exception -> 0x014a }
        L_0x0125:
            r15 = r7
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x014a }
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)     // Catch:{ Exception -> 0x014a }
            r10 = r10 ^ r15
            if (r10 == 0) goto L_0x0135
            r13.setDuration(r7)     // Catch:{ Exception -> 0x014a }
            r13.setTag(r2)     // Catch:{ Exception -> 0x014a }
        L_0x0135:
            r2 = r11
            r3.putExtend(r1, r2)     // Catch:{ Exception -> 0x014a }
            java.lang.String r1 = r2.getTag()     // Catch:{ Exception -> 0x014a }
            r3.putExtend(r0, r1)     // Catch:{ Exception -> 0x014a }
            java.lang.String r0 = r2.getTag()     // Catch:{ Exception -> 0x014a }
            r3.putExtend(r9, r0)     // Catch:{ Exception -> 0x014a }
            goto L_0x0150
        L_0x014a:
            r0 = move-exception
            r1 = 0
            r2 = r1
            com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig r2 = (com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig) r2
            r2 = r1
        L_0x0150:
            return r2
        L_0x0151:
            r1 = r2
        L_0x0152:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.ChannelTabUtilsKt.getSchemeMuteConfig(com.baidu.searchbox.feed.detail.arch.ext.CommonState):com.baidu.searchbox.video.feedflow.utils.SchemeMuteConfig");
    }

    public static final void clearSchemeTag(IntentData $this$clearSchemeTag) {
        Intrinsics.checkNotNullParameter($this$clearSchemeTag, "<this>");
        $this$clearSchemeTag.putExtend(TOP_VIEW_SEARCH_BOX_CONFIG_TAG, "");
        $this$clearSchemeTag.putExtend(TOP_VIEW_MUTE_SETTING_TAG, "");
    }

    public static final boolean isColdAutoEnterVideoTab() {
        ISettingsFun iSettingsFun = (ISettingsFun) ServiceManager.getService(ISettingsFun.Companion.getSERVICE_REFERENCE());
        return Intrinsics.areEqual((Object) "Video", (Object) iSettingsFun != null ? iSettingsFun.getColdLaunchDefaultTab() : null) || Intrinsics.areEqual((Object) "Video", (Object) QuickPersistConfig.getInstance().getString(HomeLaunchTabListener.KEY_LAUNCH_TAB_BUILD_TAG, ""));
    }

    public static final ColdAutoEnterType getColdAutoEnterType() {
        ISettingsFun iSettingsFun = (ISettingsFun) ServiceManager.getService(ISettingsFun.Companion.getSERVICE_REFERENCE());
        String defaultTab = iSettingsFun != null ? iSettingsFun.getColdLaunchDefaultTab() : null;
        String launchDefaultTab = QuickPersistConfig.getInstance().getString(HomeLaunchTabListener.KEY_LAUNCH_TAB_BUILD_TAG, "");
        if (Intrinsics.areEqual((Object) "Video", (Object) defaultTab)) {
            return ColdAutoEnterType.MANUAL;
        }
        if (Intrinsics.areEqual((Object) "Video", (Object) launchDefaultTab)) {
            return ColdAutoEnterType.AUTO;
        }
        return ColdAutoEnterType.NONE;
    }

    public static final boolean isShowSearchBoxFromFeedVideo(CommonState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        try {
            IntentData intentData = (IntentData) state.select(IntentData.class);
            String str = null;
            String str2 = intentData != null ? intentData.extendBusiness : null;
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject("backAbility");
            String optString = optJSONObject != null ? optJSONObject.optString("enable") : null;
            if (optString != null) {
                str3 = optString;
            }
            boolean hasBackAbility = Intrinsics.areEqual((Object) str3, (Object) "1");
            SchemeSearchBoxConfig searchMarkConfig = getSchemeSearchBoxConfig(state);
            if (!hasBackAbility || !VideoBizUtilsKt.isPdFromFeedTabVideo(UBCManifestKt.getPd(state))) {
                return false;
            }
            if (searchMarkConfig != null) {
                str = searchMarkConfig.getTag();
            }
            if (Intrinsics.areEqual((Object) SEARCH_CONFIG_TAG_SCHEME, (Object) str)) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isChannelInDarkMode() {
        /*
            com.baidu.searchbox.video.channel.abtest.ChannelAbTestManager r0 = com.baidu.searchbox.video.channel.abtest.ChannelAbTestManager.INSTANCE
            boolean r0 = r0.getBottomBarCanSwitchTheme()
            r1 = 1
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = channelRootManager
            r2 = 0
            if (r0 == 0) goto L_0x0035
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            if (r0 == 0) goto L_0x0035
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0021
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0022
        L_0x0021:
            r4 = r2
        L_0x0022:
            if (r4 == 0) goto L_0x002b
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r5 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x002c
        L_0x002b:
            r4 = r2
        L_0x002c:
            com.baidu.searchbox.video.feedflow.tab.TabState r4 = (com.baidu.searchbox.video.feedflow.tab.TabState) r4
            if (r4 == 0) goto L_0x0035
            java.lang.String r0 = r4.getCurTabStyle()
            goto L_0x0036
        L_0x0035:
            r0 = r2
        L_0x0036:
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = ""
        L_0x003a:
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0045
            r3 = r1
            goto L_0x0046
        L_0x0045:
            r3 = 0
        L_0x0046:
            java.lang.String r4 = "light"
            if (r3 == 0) goto L_0x0050
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            r1 = r1 ^ r2
            return r1
        L_0x0050:
            com.baidu.searchbox.video.feedflow.tab.PageTabModel r3 = getPageTabConfig()
            java.util.List r5 = r3.getTabList()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x009b
            java.util.List r5 = r3.getTabList()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0068:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0085
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r7 = (com.baidu.searchbox.video.feedflow.tab.TabInfoModel) r7
            r8 = 0
            java.lang.String r9 = r7.getId()
            java.lang.String r10 = r3.getSelectTab()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r7 == 0) goto L_0x0068
            goto L_0x0086
        L_0x0085:
            r6 = r2
        L_0x0086:
            r5 = r6
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r5 = (com.baidu.searchbox.video.feedflow.tab.TabInfoModel) r5
            if (r5 == 0) goto L_0x0095
            com.baidu.searchbox.video.feedflow.tab.TabStyleModel r6 = r5.getTabStyle()
            if (r6 == 0) goto L_0x0095
            java.lang.String r2 = r6.getPreferredTheme()
        L_0x0095:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            r1 = r1 ^ r2
            return r1
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.ChannelTabUtilsKt.isChannelInDarkMode():boolean");
    }

    public static final void setFeedChannelKey(IntentData $this$setFeedChannelKey) {
        if ($this$setFeedChannelKey != null) {
            $this$setFeedChannelKey.putExtend(KEY_CHANNEL_SOURCE_IN_INTENT, VALUE_CHANNEL_SOURCE_IN_INTENT);
        }
    }

    public static final boolean isFeedChannelSource(IntentData $this$isFeedChannelSource) {
        return Intrinsics.areEqual($this$isFeedChannelSource != null ? $this$isFeedChannelSource.getExtend(KEY_CHANNEL_SOURCE_IN_INTENT) : null, (Object) VALUE_CHANNEL_SOURCE_IN_INTENT);
    }

    public static final String getSelectTabIdBySubTag() {
        IHomeTabFun iHomeTabFun = (IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE);
        if (Intrinsics.areEqual((Object) iHomeTabFun != null ? iHomeTabFun.getSubTabTag("Video") : null, (Object) "short_play")) {
            return "13";
        }
        return null;
    }
}
