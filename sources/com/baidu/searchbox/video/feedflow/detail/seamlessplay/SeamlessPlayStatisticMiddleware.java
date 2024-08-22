package com.baidu.searchbox.video.feedflow.detail.seamlessplay;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.player.OnPlayerSeekGestureComplete;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerSeekBarClick;
import com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessState;
import com.baidu.searchbox.video.feedflow.detail.seekbar.UserDragSeekBarStart;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.ubc.UBC6037;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/seamlessplay/SeamlessPlayStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isReportCountDown", "", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "uploadViewClick", "", "state", "value", "", "uploadViewShow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SeamlessPlayStatisticMiddleware.kt */
public final class SeamlessPlayStatisticMiddleware implements Middleware<CommonState> {
    private boolean isReportCountDown;

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        RunTimeStatus runTimeStatus;
        RunTimeStatus runTimeStatus2;
        RunTimeStatus runTimeStatus3;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        boolean z = false;
        Object obj = null;
        if (action instanceof NetAction.Success) {
            Object data = ((NetAction.Success) action).getData();
            if (data instanceof FlowDetailModel) {
                obj = (FlowDetailModel) data;
            }
            if (obj != null) {
                Object obj2 = obj;
                this.isReportCountDown = false;
            }
        } else if (action instanceof OnSeamlessPlayVisibleChanged) {
            if (CommonStateExtKt.isActive(store) && ((OnSeamlessPlayVisibleChanged) action).isShow()) {
                SeamlessState seamlessState = ((OnSeamlessPlayVisibleChanged) action).getSeamlessState();
                if (seamlessState instanceof SeamlessState.OnlyNext) {
                    uploadViewShow(store.getState(), UBC6037.Value.VALUE_WF_TQNEXT);
                } else if (seamlessState instanceof SeamlessState.OnlyPre) {
                    uploadViewShow(store.getState(), UBC6037.Value.VALUE_WF_LAST);
                } else {
                    uploadViewShow(store.getState(), UBC6037.Value.VALUE_WF_NEXT);
                    uploadViewShow(store.getState(), UBC6037.Value.VALUE_WF_LAST);
                }
            }
        } else if (action instanceof SeamlessPlayClick) {
            if (((SeamlessPlayClick) action).isCountDown()) {
                uploadViewClick(store.getState(), UBC6037.Value.VALUE_WF_COUNT);
            } else {
                CommonState state = store.getState();
                CommonState commonState = state instanceof CommonState ? state : null;
                if (commonState != null) {
                    obj = commonState.select(SeamlessPlayState.class);
                }
                SeamlessPlayState seamlessPlayState = (SeamlessPlayState) obj;
                if (seamlessPlayState != null && seamlessPlayState.hasPre(store)) {
                    z = true;
                }
                if (!z) {
                    uploadViewClick(store.getState(), UBC6037.Value.VALUE_WF_TQNEXT);
                } else if (((SeamlessPlayClick) action).isNext()) {
                    uploadViewClick(store.getState(), UBC6037.Value.VALUE_WF_NEXT);
                } else {
                    uploadViewClick(store.getState(), UBC6037.Value.VALUE_WF_LAST);
                }
            }
        } else if (action instanceof SeamlessPlayCountDownChange) {
            if (!this.isReportCountDown && ((SeamlessPlayCountDownChange) action).isStart()) {
                this.isReportCountDown = true;
                uploadViewShow(store.getState(), UBC6037.Value.VALUE_WF_COUNT);
            }
        } else if (action instanceof UserDragSeekBarStart) {
            CommonState state2 = store.getState();
            CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
            ItemModel itemModel = (ItemModel) (commonState2 != null ? commonState2.select(ItemModel.class) : null);
            if (!(itemModel == null || (runTimeStatus3 = itemModel.getRunTimeStatus()) == null)) {
                obj = runTimeStatus3.getSeamlessNodeModel();
            }
            if (obj != null) {
                uploadViewClick(store.getState(), UBC6037.Value.VALUE_WF_PROGRESSBAR);
            }
        } else if (action instanceof PlayerSeekBarClick) {
            CommonState state3 = store.getState();
            CommonState commonState3 = state3 instanceof CommonState ? state3 : null;
            ItemModel itemModel2 = (ItemModel) (commonState3 != null ? commonState3.select(ItemModel.class) : null);
            if (!(itemModel2 == null || (runTimeStatus2 = itemModel2.getRunTimeStatus()) == null)) {
                obj = runTimeStatus2.getSeamlessNodeModel();
            }
            if (obj != null) {
                uploadViewClick(store.getState(), UBC6037.Value.VALUE_WF_PROGRESSBAR);
            }
        } else if (action instanceof OnPlayerSeekGestureComplete) {
            CommonState state4 = store.getState();
            CommonState commonState4 = state4 instanceof CommonState ? state4 : null;
            ItemModel itemModel3 = (ItemModel) (commonState4 != null ? commonState4.select(ItemModel.class) : null);
            if (!(itemModel3 == null || (runTimeStatus = itemModel3.getRunTimeStatus()) == null)) {
                obj = runTimeStatus.getSeamlessNodeModel();
            }
            if (obj != null) {
                uploadViewClick(store.getState(), UBC6037.Value.VALUE_WF_PROGRESSBAR);
            }
        }
        return next.next(store, action);
    }

    private final void uploadViewShow(CommonState state, String value) {
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, state, "show", value, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, "6037", 504, (Object) null);
    }

    private final void uploadViewClick(CommonState state, String value) {
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, state, "click", value, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, "6037", 504, (Object) null);
    }
}
