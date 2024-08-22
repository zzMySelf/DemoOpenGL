package com.baidu.searchbox.video.feedflow.detail.favor.statistic;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.detail.favor.favorpanel.FavorPanelGuideShownAction;
import com.baidu.searchbox.video.feedflow.detail.favor.favorshortguide.FavorShortGuideUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.ubc.UBC6304;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/favor/statistic/FavorStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getSpecialExt", "Lorg/json/JSONObject;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorStatisticMiddleware.kt */
public final class FavorStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Store<CommonState> store2 = store;
        Action action2 = action;
        Next<CommonState> next2 = next;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(next2, "next");
        if ((action2 instanceof FavorPanelGuideShownAction) && ((FavorPanelGuideShownAction) action2).isShowing()) {
            VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), "show", UBC6304.Value.VALUE_ADD_PRESS_TOAST, (String) null, (String) null, (String) null, getSpecialExt(store), (ItemModel) null, false, UBCManifestKt.UBC_ID_6304, 440, (Object) null);
        }
        return next2.next(store2, action2);
    }

    private final JSONObject getSpecialExt(Store<CommonState> store) {
        ItemModel<?> curItemModel;
        VideoItemModel transformVideoItemModel;
        CommonState state = store.getState();
        String str = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        FlowState flowState = (FlowState) (commonState != null ? commonState.select(FlowState.class) : null);
        boolean curVideoShowShortBtn = BdPlayerUtils.orFalse((flowState == null || (curItemModel = flowState.getCurItemModel()) == null || (transformVideoItemModel = FlowModelUtilsKt.transformVideoItemModel(curItemModel)) == null) ? null : Boolean.valueOf(transformVideoItemModel.isShortPlay())) && FavorShortGuideUtilsKt.isHitExperimentOfShortFavor((Store<?>) store);
        JSONObject extObject = new JSONObject();
        JSONObject $this$getSpecialExt_u24lambda_u2d0 = extObject;
        CommonState state2 = store.getState();
        CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
        ItemModel itemModel = (ItemModel) (commonState2 != null ? commonState2.select(ItemModel.class) : null);
        if (itemModel != null) {
            str = itemModel.getNid();
        }
        $this$getSpecialExt_u24lambda_u2d0.putOpt("id", str);
        if (curVideoShowShortBtn) {
            $this$getSpecialExt_u24lambda_u2d0.putOpt("is_collection_zj", "1");
        }
        return extObject;
    }
}
