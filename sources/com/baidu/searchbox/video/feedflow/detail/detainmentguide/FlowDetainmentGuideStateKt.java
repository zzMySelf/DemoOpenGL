package com.baidu.searchbox.video.feedflow.detail.detainmentguide;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u001e\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0007\u001a\u001e\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u001e\u0010\u0012\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u001a\u001e\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0007\u001a \u0010\u0017\u001a\u00020\u00182\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u001a\u001a\u00020\u00182\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u001a\u0010\u0010\u001b\u001a\u00020\u000b*\b\u0012\u0002\b\u0003\u0018\u00010\r\u001a \u0010\u001c\u001a\u00020\u0018*\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"GUIDE_DAY_RANGE", "", "GUIDE_EXIT_PERIOD", "GUIDE_STYLE", "GUIDE_TIME_RANGE", "GUIDE_USER_SCROLL_SWITCH", "ONE_DAY", "", "SCENE_SWITCH", "SCENE_VERSION", "canShowInDetainGuideDefaultCounts", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "defaultCount", "canShowInDetainGuideDefaultDays", "defaultDay", "getCurSceneString", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "isGetNewScene", "isInDetainGuideExitDays", "parseDetainGuideOperateConf", "", "operateConf", "resetDetainGuideSceneLocalData", "detainGuideNeedCountWithScene", "setDetainGuideConfWithScene", "scene", "sceneConf", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetainmentGuideState.kt */
public final class FlowDetainmentGuideStateKt {
    private static final String GUIDE_DAY_RANGE = "day_range";
    private static final String GUIDE_EXIT_PERIOD = "exit_day";
    private static final String GUIDE_STYLE = "style";
    private static final String GUIDE_TIME_RANGE = "time_range";
    private static final String GUIDE_USER_SCROLL_SWITCH = "user_scroll_switch";
    private static final int ONE_DAY = 86400000;
    private static final String SCENE_SWITCH = "scene_switch";
    private static final String SCENE_VERSION = "scene_version";

    public static final void parseDetainGuideOperateConf(Store<AbsState> store, String operateConf) {
        boolean z;
        FlowSwitchState flowSwitchState;
        FlowDetainmentGuideConfig $this$parseDetainGuideOperateConf_u24lambda_u2d0;
        FlowSwitchState flowSwitchState2;
        FlowSwitchState flowSwitchState3;
        Store<AbsState> store2 = store;
        String str = operateConf;
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            String compareKey = getCurSceneString(store2, false);
            try {
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) compareKey, false, 2, (Object) null)) {
                    JSONObject operateConfJsonObj = new JSONObject(str);
                    String newCompareKey = getCurSceneString(store2, true);
                    String optString = operateConfJsonObj.optString(newCompareKey);
                    Intrinsics.checkNotNullExpressionValue(optString, "operateConfJsonObj.optString(newCompareKey)");
                    if (optString.length() == 0) {
                        FlowDetainmentGuideConfig flowDetainGuideConfig = (store2 == null || (flowSwitchState3 = FlowSwitchStateKt.flowSwitchState((Store<?>) store)) == null) ? null : flowSwitchState3.getFlowDetainGuideConfig();
                        if (flowDetainGuideConfig != null) {
                            flowDetainGuideConfig.setNewScene(false);
                        }
                    } else {
                        FlowDetainmentGuideConfig flowDetainGuideConfig2 = (store2 == null || (flowSwitchState2 = FlowSwitchStateKt.flowSwitchState((Store<?>) store)) == null) ? null : flowSwitchState2.getFlowDetainGuideConfig();
                        if (flowDetainGuideConfig2 != null) {
                            flowDetainGuideConfig2.setNewScene(true);
                        }
                        compareKey = newCompareKey;
                    }
                    try {
                        String sceneConf = operateConfJsonObj.optString(compareKey);
                        Intrinsics.checkNotNullExpressionValue(sceneConf, "sceneConf");
                        setDetainGuideConfWithScene(store2, compareKey, sceneConf);
                        JSONObject curSceneJson = new JSONObject(sceneConf);
                        boolean customizedSceneSwitch = curSceneJson.optInt("scene_switch", 0) == 1;
                        int customizedGuideStyle = curSceneJson.optInt("style", -1);
                        int customizedGuideDay = curSceneJson.optInt("day_range", -1);
                        int customizedGuideTime = curSceneJson.optInt(GUIDE_TIME_RANGE, -1);
                        int customizedGuideExitTime = curSceneJson.optInt(GUIDE_EXIT_PERIOD, -1);
                        int customizedGuideUserScrollSwitch = curSceneJson.optInt(GUIDE_USER_SCROLL_SWITCH, -1);
                        int customizedSceneVersion = curSceneJson.optInt("scene_version");
                        JSONObject jSONObject = operateConfJsonObj;
                        String compareKey2 = compareKey;
                        try {
                            if (customizedSceneVersion > DIFactory.INSTANCE.getConfig().getDetainGuideSceneVersion(getCurSceneString$default(store2, false, 2, (Object) null))) {
                                resetDetainGuideSceneLocalData(store);
                                z = false;
                                DIFactory.INSTANCE.getConfig().setDetainGuideSceneVersion(getCurSceneString$default(store2, false, 2, (Object) null), customizedSceneVersion);
                            } else {
                                z = false;
                            }
                            if (!(store2 == null || (flowSwitchState = FlowSwitchStateKt.flowSwitchState((Store<?>) store)) == null || ($this$parseDetainGuideOperateConf_u24lambda_u2d0 = flowSwitchState.getFlowDetainGuideConfig()) == null)) {
                                if (customizedGuideStyle >= 0) {
                                    $this$parseDetainGuideOperateConf_u24lambda_u2d0.setGuideStyle(customizedGuideStyle);
                                }
                                if (customizedGuideDay >= 0) {
                                    $this$parseDetainGuideOperateConf_u24lambda_u2d0.setGuideDay(customizedGuideDay);
                                }
                                if (customizedGuideTime >= 0) {
                                    $this$parseDetainGuideOperateConf_u24lambda_u2d0.setGuideTime(customizedGuideTime);
                                }
                                if (customizedGuideExitTime >= 0) {
                                    $this$parseDetainGuideOperateConf_u24lambda_u2d0.setExitPeriod(customizedGuideExitTime);
                                }
                                if (customizedGuideUserScrollSwitch >= 0) {
                                    $this$parseDetainGuideOperateConf_u24lambda_u2d0.setUserScrollSwitch(customizedGuideUserScrollSwitch);
                                }
                                if (customizedGuideDay < 0 || customizedGuideTime < 0) {
                                    z = true;
                                }
                                $this$parseDetainGuideOperateConf_u24lambda_u2d0.setNeedTotalCount(z);
                                $this$parseDetainGuideOperateConf_u24lambda_u2d0.setSceneSwitch(customizedSceneSwitch);
                            }
                            String str2 = compareKey2;
                        } catch (JSONException e2) {
                            String str3 = compareKey2;
                        }
                    } catch (JSONException e3) {
                        String str4 = compareKey;
                    }
                }
            } catch (JSONException e4) {
            }
        }
    }

    public static /* synthetic */ String getCurSceneString$default(Store store, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return getCurSceneString(store, z);
    }

    public static final String getCurSceneString(Store<?> store, boolean isGetNewScene) {
        FlowSwitchState flowSwitchState;
        FlowDetainmentGuideConfig flowDetainGuideConfig;
        CommonState commonState = null;
        Object state = store != null ? store.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        boolean z = true;
        if (store == null || (flowSwitchState = FlowSwitchStateKt.flowSwitchState(store)) == null || (flowDetainGuideConfig = flowSwitchState.getFlowDetainGuideConfig()) == null || !flowDetainGuideConfig.isNewScene()) {
            z = false;
        }
        return UBCManifestKt.getRealCurSceneString(commonState, isGetNewScene, z);
    }

    public static final String getCurSceneString(CommonState state) {
        FlowSwitchState flowSwitchState;
        FlowDetainmentGuideConfig flowDetainGuideConfig;
        boolean z = true;
        if (state == null || (flowSwitchState = FlowSwitchStateKt.flowSwitchState(state)) == null || (flowDetainGuideConfig = flowSwitchState.getFlowDetainGuideConfig()) == null || !flowDetainGuideConfig.isNewScene()) {
            z = false;
        }
        return UBCManifestKt.getRealCurSceneString$default(state, false, z, 2, (Object) null);
    }

    public static final void resetDetainGuideSceneLocalData(Store<AbsState> store) {
        DIFactory.INSTANCE.getConfig().setDetainGuideShowCountWithScene(getCurSceneString$default(store, false, 2, (Object) null), 0);
        DIFactory.INSTANCE.getConfig().setDetainGuideFirstTimeWithScene(getCurSceneString$default(store, false, 2, (Object) null), 0);
    }

    public static final void setDetainGuideConfWithScene(Store<?> $this$setDetainGuideConfWithScene, String scene, String sceneConf) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(sceneConf, "sceneConf");
        if (FlowSwitchStateKt.flowSwitchState($this$setDetainGuideConfWithScene).getSwitchUpdatePerformer() != null) {
            DIFactory.INSTANCE.getConfig().setSecondJumpConfWithScene(scene, sceneConf);
        }
    }

    public static final boolean isInDetainGuideExitDays(Store<AbsState> store, int defaultDay) {
        long curSceneExitTime;
        FlowSwitchState flowSwitchState;
        FlowDetainmentGuideLocalConfig flowDetainGuideLocalConfig;
        if (store != null && detainGuideNeedCountWithScene(store)) {
            curSceneExitTime = DIFactory.INSTANCE.getConfig().getDetainGuideExitTimeWithScene(getCurSceneString$default(store, false, 2, (Object) null));
        } else {
            curSceneExitTime = (store == null || (flowSwitchState = FlowSwitchStateKt.flowSwitchState((Store<?>) store)) == null || (flowDetainGuideLocalConfig = flowSwitchState.getFlowDetainGuideLocalConfig()) == null) ? 0 : flowDetainGuideLocalConfig.getGuideExitTime();
        }
        return defaultDay < 0 || (System.currentTimeMillis() - curSceneExitTime) - ((long) (86400000 * defaultDay)) > 0;
    }

    public static final boolean canShowInDetainGuideDefaultDays(Store<AbsState> store, int defaultDay) {
        long curSceneFirstShowTime;
        FlowSwitchState flowSwitchState;
        FlowDetainmentGuideLocalConfig flowDetainGuideLocalConfig;
        if (store != null && detainGuideNeedCountWithScene(store)) {
            curSceneFirstShowTime = DIFactory.INSTANCE.getConfig().getDetainGuideFirstTimeWithScene(getCurSceneString$default(store, false, 2, (Object) null));
        } else {
            curSceneFirstShowTime = (store == null || (flowSwitchState = FlowSwitchStateKt.flowSwitchState((Store<?>) store)) == null || (flowDetainGuideLocalConfig = flowSwitchState.getFlowDetainGuideLocalConfig()) == null) ? 0 : flowDetainGuideLocalConfig.getGuideFirstTime();
        }
        if (defaultDay <= 0) {
            return false;
        }
        if ((System.currentTimeMillis() - curSceneFirstShowTime) - ((long) (86400000 * defaultDay)) <= 0) {
            return true;
        }
        if (store != null && detainGuideNeedCountWithScene(store)) {
            DIFactory.INSTANCE.getConfig().setDetainGuideShowCountWithScene(getCurSceneString$default(store, false, 2, (Object) null), 0);
        } else {
            DIFactory.INSTANCE.getConfig().setDetainGuideShowCount(0);
        }
        return true;
    }

    public static final boolean canShowInDetainGuideDefaultCounts(Store<AbsState> store, int defaultCount) {
        int currCount;
        FlowSwitchState flowSwitchState;
        FlowDetainmentGuideLocalConfig flowDetainGuideLocalConfig;
        if (store != null && detainGuideNeedCountWithScene(store)) {
            currCount = DIFactory.INSTANCE.getConfig().getDetainGuideShowCountWithScene(getCurSceneString$default(store, false, 2, (Object) null));
        } else {
            currCount = (store == null || (flowSwitchState = FlowSwitchStateKt.flowSwitchState((Store<?>) store)) == null || (flowDetainGuideLocalConfig = flowSwitchState.getFlowDetainGuideLocalConfig()) == null) ? 0 : flowDetainGuideLocalConfig.getGuideShowCount();
        }
        return currCount < defaultCount;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean detainGuideNeedCountWithScene(com.baidu.searchbox.feed.detail.frame.Store<?> r3) {
        /*
            com.baidu.searchbox.video.feedflow.common.FlowSwitchState r0 = com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt.flowSwitchState((com.baidu.searchbox.feed.detail.frame.Store<?>) r3)
            com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowDetainmentGuideConfig r0 = r0.getFlowDetainGuideConfig()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = r0.getOperateConf()
            if (r0 == 0) goto L_0x0021
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x001c
            r0 = r1
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            if (r0 != 0) goto L_0x0021
            r0 = r1
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            if (r0 == 0) goto L_0x003a
            com.baidu.searchbox.video.feedflow.common.FlowSwitchState r0 = com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt.flowSwitchState((com.baidu.searchbox.feed.detail.frame.Store<?>) r3)
            com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowDetainmentGuideConfig r0 = r0.getFlowDetainGuideConfig()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r0.getNeedTotalCount()
            if (r0 != 0) goto L_0x0036
            r0 = r1
            goto L_0x0037
        L_0x0036:
            r0 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.detainmentguide.FlowDetainmentGuideStateKt.detainGuideNeedCountWithScene(com.baidu.searchbox.feed.detail.frame.Store):boolean");
    }
}
