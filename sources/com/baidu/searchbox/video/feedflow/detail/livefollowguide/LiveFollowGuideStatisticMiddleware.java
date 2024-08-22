package com.baidu.searchbox.video.feedflow.detail.livefollowguide;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.livesummary.LiveSummaryAuthorFollowAction;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.ubc.UBC5943;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J$\u0010\r\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livefollowguide/LiveFollowGuideStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getUbcRdcExtJson", "Lorg/json/JSONObject;", "ubcLiveFollowGuide", "", "type", "", "value", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFollowGuideStatisticMiddleware.kt */
public final class LiveFollowGuideStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof LiveFollowGuideClickAction) {
            ubcLiveFollowGuide(store, "click", UBC5943.Value.VALUE_FOLLOW_EVOKE);
        } else if (action instanceof LiveFollowGuideShowAction) {
            ubcLiveFollowGuide(store, "show", UBC5943.Value.VALUE_FOLLOW_EVOKE);
        } else if (action instanceof LiveSummaryAuthorFollowAction.FollowBtnClick) {
            ubcLiveFollowGuide(store, "click", UBC5943.Value.VALUE_UNAME_ATTENTION);
        } else if (action instanceof LiveSummaryAuthorFollowAction.FollowBtnShow) {
            ubcLiveFollowGuide(store, "show", UBC5943.Value.VALUE_UNAME_ATTENTION);
        }
        return next.next(store, action);
    }

    public final void ubcLiveFollowGuide(Store<CommonState> store, String type, String value) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), type, value, (String) null, (String) null, (String) null, getUbcRdcExtJson(store), (ItemModel) null, false, UBCManifestKt.UBC_ID_5943, 440, (Object) null);
    }

    private final JSONObject getUbcRdcExtJson(Store<CommonState> store) {
        CommonItemData commonItemData;
        CommonState state = store.getState();
        String yyLiveId = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        ItemModel itemModel = (ItemModel) (commonState != null ? commonState.select(ItemModel.class) : null);
        JSONObject extLog = (itemModel == null || (commonItemData = itemModel.getCommonItemData()) == null) ? null : commonItemData.getExtLogJo();
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getUbcRdcExtJson_u24lambda_u2d1 = jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject $this$getUbcRdcExtJson_u24lambda_u2d1_u24lambda_u2d0 = jSONObject2;
            if (extLog != null) {
                yyLiveId = extLog.optString("yyliveid");
            }
            if (Intrinsics.areEqual((Object) "1", (Object) yyLiveId)) {
                $this$getUbcRdcExtJson_u24lambda_u2d1_u24lambda_u2d0.putOpt("yysid", Integer.valueOf(extLog.optInt("yysid")));
                $this$getUbcRdcExtJson_u24lambda_u2d1_u24lambda_u2d0.putOpt("yyssid", Integer.valueOf(extLog.optInt("yyssid")));
                $this$getUbcRdcExtJson_u24lambda_u2d1_u24lambda_u2d0.putOpt("yyuid", Long.valueOf(extLog.optLong("yyuid")));
                $this$getUbcRdcExtJson_u24lambda_u2d1_u24lambda_u2d0.putOpt("template_id", Integer.valueOf(extLog.optInt("template_id")));
                $this$getUbcRdcExtJson_u24lambda_u2d1_u24lambda_u2d0.putOpt("hdid", extLog.optString("hdid"));
                $this$getUbcRdcExtJson_u24lambda_u2d1_u24lambda_u2d0.putOpt("yyliveid", yyLiveId);
            }
            Unit unit = Unit.INSTANCE;
            $this$getUbcRdcExtJson_u24lambda_u2d1.put("rdc_ext", jSONObject2);
        } catch (Exception e2) {
        }
        return jSONObject;
    }
}
