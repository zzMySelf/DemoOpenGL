package com.baidu.searchbox.video.feedflow.detail.livebottom.statistic;

import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.InterceptAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.feedflow.detail.FlowDetailState;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarBackClickedAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarCommentClickedAction;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.ubc.UBC2736;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livebottom/statistic/LiveBottomBarStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "backUbcClick", "", "getLiveUbcExtJson", "Lorg/json/JSONObject;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBottomBarStatisticMiddleware.kt */
public final class LiveBottomBarStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        if (action2 instanceof BottomBarBackClickedAction) {
            backUbcClick(store);
        } else if (action2 instanceof BottomBarCommentClickedAction) {
            VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), UBC2736.TYPE.TYPE_INTO_LIVE_CLK, (String) null, (String) null, (String) null, (String) null, getLiveUbcExtJson(store), (ItemModel) null, false, (String) null, 956, (Object) null);
        } else if ((action2 instanceof InterceptAction) && (((InterceptAction) action2).getOriginAction() instanceof BottomBarCommentClickedAction)) {
            VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), UBC2736.TYPE.TYPE_INTO_LIVE_CLK, (String) null, (String) null, (String) null, (String) null, getLiveUbcExtJson(store), (ItemModel) null, false, (String) null, 956, (Object) null);
        }
        return next2.next(store2, action2);
    }

    private final void backUbcClick(Store<CommonState> store) {
        JSONObject specialExt;
        ItemModel $this$backUbcClick_u24lambda_u2d0 = (ItemModel) store.getState().select(ItemModel.class);
        if ($this$backUbcClick_u24lambda_u2d0 != null) {
            specialExt = VideoFlowUBCHelper.INSTANCE.createPdPdRecLog($this$backUbcClick_u24lambda_u2d0);
        } else {
            specialExt = null;
        }
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "toolbar", (String) null, "tool", (String) null, (String) null, specialExt, (ItemModel) null, false, "206", RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR, (Object) null);
    }

    private final JSONObject getLiveUbcExtJson(Store<CommonState> store) {
        List liveExtendTags;
        FlowDetailModel data;
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getLiveUbcExtJson_u24lambda_u2d1 = jSONObject;
        try {
            $this$getLiveUbcExtJson_u24lambda_u2d1.putOpt("clk_area", "comment");
            CommonState state = store.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            FlowDetailState flowDetailState = (FlowDetailState) (commonState != null ? commonState.select(FlowDetailState.class) : null);
            if (flowDetailState == null || (data = flowDetailState.getData()) == null || (liveExtendTags = data.getLiveExtendTags()) == null) {
                liveExtendTags = CollectionsKt.emptyList();
            }
            $this$getLiveUbcExtJson_u24lambda_u2d1.putOpt("label", liveExtendTags.toString());
            VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
            CommonState state2 = store.getState();
            CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
            if (commonState2 != null) {
                obj = commonState2.select(ItemModel.class);
            }
            videoFlowUBCHelper.appendYYLive($this$getLiveUbcExtJson_u24lambda_u2d1, (ItemModel) obj);
        } catch (JSONException e2) {
        }
        return jSONObject;
    }
}
