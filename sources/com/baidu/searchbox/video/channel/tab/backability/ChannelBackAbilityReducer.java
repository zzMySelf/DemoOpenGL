package com.baidu.searchbox.video.channel.tab.backability;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.UserVisibleHint;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.ui.drawerslide.DynamicUtilsKt;
import com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.detail.DetailItemSelected;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.tab.back.BackAbilityReducer;
import com.baidu.searchbox.video.feedflow.tab.back.BackAbilityState;
import com.baidu.searchbox.video.feedflow.tab.back.BackAbilityStateKt;
import com.baidu.searchbox.video.feedflow.tab.back.BackAbilityVisible;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/backability/ChannelBackAbilityReducer;", "Lcom/baidu/searchbox/video/feedflow/tab/back/BackAbilityReducer;", "()V", "onDetailItemSelected", "", "action", "Lcom/baidu/searchbox/video/feedflow/detail/DetailItemSelected;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "onLeaveVideoChannel", "parseBackAbility", "reduce", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelBackAbilityReducer.kt */
public final class ChannelBackAbilityReducer extends BackAbilityReducer {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof VideoChannelFlowPageAction.SchemeJumpAction) {
            parseBackAbility(state);
            BackAbilityState backAbilityState = (BackAbilityState) state.select(BackAbilityState.class);
            if (backAbilityState != null) {
                backAbilityState.clearHistoryItem();
            }
        } else if ((action instanceof UserVisibleHint) && !((UserVisibleHint) action).getVisible()) {
            onLeaveVideoChannel(state);
        }
        return super.reduce(state, action);
    }

    private final void onLeaveVideoChannel(CommonState state) {
        BackAbilityState $this$onLeaveVideoChannel_u24lambda_u2d0 = (BackAbilityState) state.select(BackAbilityState.class);
        if ($this$onLeaveVideoChannel_u24lambda_u2d0 != null && BackAbilityStateKt.hasBackHomeAbility($this$onLeaveVideoChannel_u24lambda_u2d0)) {
            if (VideoBizUtilsKt.isPdFromFeedTabVideo(UBCManifestKt.getPd(state))) {
                $this$onLeaveVideoChannel_u24lambda_u2d0.getShowVideoTabBubble().setValue(Unit.INSTANCE);
            }
            $this$onLeaveVideoChannel_u24lambda_u2d0.getEnable().setValue(new BackAbilityVisible(false, false, 2, (DefaultConstructorMarker) null));
            $this$onLeaveVideoChannel_u24lambda_u2d0.isOnKeyDownEnable().setValue(false);
        }
    }

    private final void parseBackAbility(CommonState state) {
        try {
            IntentData intentData = (IntentData) state.select(IntentData.class);
            String str = null;
            String str2 = intentData != null ? intentData.extendBusiness : null;
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            JSONObject backAbility = new JSONObject(str2).optJSONObject("backAbility");
            BackAbilityState backAbilityState = (BackAbilityState) state.select(BackAbilityState.class);
            if (backAbilityState != null) {
                BackAbilityState $this$parseBackAbility_u24lambda_u2d1 = backAbilityState;
                String optString = backAbility != null ? backAbility.optString("enable") : null;
                if (optString == null) {
                    optString = str3;
                }
                boolean enableStatus = Intrinsics.areEqual((Object) optString, (Object) "1");
                $this$parseBackAbility_u24lambda_u2d1.getEnable().setValue(new BackAbilityVisible(enableStatus, false, 2, (DefaultConstructorMarker) null));
                $this$parseBackAbility_u24lambda_u2d1.isOnKeyDownEnable().setValue(Boolean.valueOf(enableStatus));
                String optString2 = backAbility != null ? backAbility.optString("dismissCondition") : null;
                if (optString2 != null) {
                    str3 = optString2;
                }
                $this$parseBackAbility_u24lambda_u2d1.setDismissCondition(DynamicUtilsKt.toIntSafely(str3));
                $this$parseBackAbility_u24lambda_u2d1.setType(backAbility != null ? backAbility.optString("type") : null);
                if (backAbility != null) {
                    str = backAbility.optString("guideText");
                }
                $this$parseBackAbility_u24lambda_u2d1.setGuideText(str);
            }
        } catch (Exception e2) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDetailItemSelected(DetailItemSelected action, CommonState state) {
        BackAbilityState $this$onDetailItemSelected_u24lambda_u2d2;
        BackAbilityState backAbilityState;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        ItemModel<?> itemModel = action.getItemModel();
        String id = itemModel != null ? itemModel.getId() : null;
        if (id == null) {
            id = "";
        }
        if (!LandscapeFlowSwitchKt.isLandscapeFlowMode((AbsState) state) && (backAbilityState = (BackAbilityState) state.select(BackAbilityState.class)) != null) {
            backAbilityState.addShowItemId(id);
        }
        BackAbilityState backAbilityState2 = (BackAbilityState) state.select(BackAbilityState.class);
        if ((backAbilityState2 != null && backAbilityState2.isAchieveLimit()) && ($this$onDetailItemSelected_u24lambda_u2d2 = (BackAbilityState) state.select(BackAbilityState.class)) != null) {
            $this$onDetailItemSelected_u24lambda_u2d2.getEnable().setValue(new BackAbilityVisible(false, true));
        }
    }
}
