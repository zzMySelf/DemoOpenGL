package com.baidu.searchbox.video.feedflow.flow.operation.element;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.home.tabs.constants.HomeTabIconBubbleConstants;
import com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction;
import com.baidu.searchbox.video.feedflow.ubc.UBC6274;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J:\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/operation/element/FlowOperationStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "reportUbc", "", "type", "", "value", "activityId", "ext", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowOperationStatisticMiddleware.kt */
public final class FlowOperationStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof FlowOperationAction.FlowFloatingOperationClickAction) {
            reportUbc(store, "click", "image", ((FlowOperationAction.FlowFloatingOperationClickAction) action).getActivityId(), ((FlowOperationAction.FlowFloatingOperationClickAction) action).getExt());
        } else if (action instanceof FlowOperationAction.FlowFloatingOperationShowAction) {
            reportUbc(store, "show", "image", ((FlowOperationAction.FlowFloatingOperationShowAction) action).getActivityId(), ((FlowOperationAction.FlowFloatingOperationShowAction) action).getExt());
        } else {
            String str = "2";
            if (action instanceof FlowOperationAction.FlowTimerClickAction) {
                JSONObject ext = new JSONObject();
                JSONObject $this$apply_u24lambda_u2d0 = ext;
                $this$apply_u24lambda_u2d0.putOpt("retract_id", ((FlowOperationAction.FlowTimerClickAction) action).getActivityId());
                if (!((FlowOperationAction.FlowTimerClickAction) action).isComplete()) {
                    str = "1";
                }
                $this$apply_u24lambda_u2d0.putOpt("retract_type", str);
                $this$apply_u24lambda_u2d0.putOpt("activity_num", String.valueOf(((FlowOperationAction.FlowTimerClickAction) action).getCurrStep()));
                reportUbc(store, UBC6274.Type.RETRACT_CLICK, "image", ((FlowOperationAction.FlowTimerClickAction) action).getActivityId(), ext.toString());
            } else if (action instanceof FlowOperationAction.FlowTimerShowAction) {
                JSONObject ext2 = new JSONObject();
                JSONObject $this$apply_u24lambda_u2d1 = ext2;
                $this$apply_u24lambda_u2d1.putOpt("retract_id", ((FlowOperationAction.FlowTimerShowAction) action).getActivityId());
                if (!((FlowOperationAction.FlowTimerShowAction) action).isComplete()) {
                    str = "1";
                }
                $this$apply_u24lambda_u2d1.putOpt("retract_type", str);
                $this$apply_u24lambda_u2d1.putOpt("activity_num", String.valueOf(((FlowOperationAction.FlowTimerShowAction) action).getCurrStep()));
                reportUbc(store, UBC6274.Type.RETRACT_SHOW, "image", ((FlowOperationAction.FlowTimerShowAction) action).getActivityId(), ext2.toString());
            }
        }
        return next.next(store, action);
    }

    private final void reportUbc(Store<CommonState> store, String type, String value, String activityId, String ext) {
        VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
        JSONObject $this$reportUbc_u24lambda_u2d2 = new JSONObject();
        $this$reportUbc_u24lambda_u2d2.putOpt(HomeTabIconBubbleConstants.ACTIVITY_ID, activityId);
        Unit unit = Unit.INSTANCE;
        videoFlowUBCHelper.uploadUbc6274(store, type, value, UbcExtBeanKt.mergeExt(ext, $this$reportUbc_u24lambda_u2d2.toString()));
    }
}
