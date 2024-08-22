package com.baidu.searchbox.video.feedflow.detail.halfscreen;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.gesture.ClickScrollToTargetPosition;
import com.baidu.searchbox.video.feedflow.detail.halfscreen.switcher.HalfScreenSwitchConfigKt;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomNextRecommendCloseBtnClick;
import com.baidu.searchbox.video.feedflow.flow.bottom.RecommendNextEntryClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.RecommendNextEntryShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.RecommendNextHalfShowAction;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.ubc.UBC6037;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0002J0\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/halfscreen/HalfScreenStatisticMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getStatisticModel", "Lcom/baidu/searchbox/video/feedflow/detail/halfscreen/HalfScreenStatisticModel;", "updateStatisticModel", "", "model", "uploadHalfScreenPanel", "behavior", "", "value", "specialExt", "Lorg/json/JSONObject;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HalfScreenStatisticMiddleware.kt */
public final class HalfScreenStatisticMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        String type;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        Boolean bool = null;
        if (action instanceof NestedAction.OnPageSelected) {
            if (HalfScreenSwitchConfigKt.canShowHalfScreen$default((Store) store, false, 1, (Object) null) && !getStatisticModel(store).getSelectedShown()) {
                uploadHalfScreenPanel(store, "show", UBC6037.Value.VALUE_HALF_SCREEN_VIDEO1_SHOW, (JSONObject) null);
                HalfScreenStatisticModel $this$apply_u24lambda_u2d0 = getStatisticModel(store);
                $this$apply_u24lambda_u2d0.setSelectedShown(true);
                Unit unit = Unit.INSTANCE;
                updateStatisticModel(store, $this$apply_u24lambda_u2d0);
            }
        } else if (action instanceof RecommendNextHalfShowAction) {
            CommonState state = store.getState();
            CommonState commonState = state instanceof CommonState ? state : null;
            FlowState flowState = (FlowState) (commonState != null ? commonState.select(FlowState.class) : null);
            ItemModel itemModel = flowState != null ? FlowState.getNextItem$default(flowState, (Function1) null, 1, (Object) null) : null;
            if (!getStatisticModel(store).getAttachViewShown() && HalfScreenSwitchConfigKt.canShowHalfScreen$default((Store) store, false, 1, (Object) null)) {
                JSONObject ext = new JSONObject();
                if (BdPlayerUtils.orFalse(itemModel != null ? Boolean.valueOf(ItemTypeManifestKt.isVideoItem((ItemModel<?>) itemModel)) : null)) {
                    type = "video";
                } else {
                    if (itemModel != null) {
                        bool = Boolean.valueOf(ItemTypeManifestKt.isAdItem((ItemModel<?>) itemModel));
                    }
                    if (BdPlayerUtils.orFalse(bool)) {
                        type = "adv";
                    } else {
                        type = "other";
                    }
                }
                ext.putOpt("card_show_type", type);
                uploadHalfScreenPanel(store, "show", UBC6037.Value.VALUE_HALF_SCREEN_VIDEO2_SHOW, ext);
                HalfScreenStatisticModel $this$apply_u24lambda_u2d1 = getStatisticModel(store);
                $this$apply_u24lambda_u2d1.setAttachViewShown(true);
                Unit unit2 = Unit.INSTANCE;
                updateStatisticModel(store, $this$apply_u24lambda_u2d1);
            }
        } else if (action instanceof RecommendNextEntryShowAction) {
            if (HalfScreenSwitchConfigKt.canShowHalfScreen$default((Store) store, false, 1, (Object) null) && !getStatisticModel(store).getDibarShown()) {
                uploadHalfScreenPanel(store, "show", UBC6037.Value.VALUE_HALF_SCREEN_DIBAR_UP_SHOW, (JSONObject) null);
                HalfScreenStatisticModel $this$apply_u24lambda_u2d2 = getStatisticModel(store);
                $this$apply_u24lambda_u2d2.setDibarShown(true);
                Unit unit3 = Unit.INSTANCE;
                updateStatisticModel(store, $this$apply_u24lambda_u2d2);
            }
        } else if (action instanceof RecommendNextEntryClickAction) {
            if (CommonStateExtKt.isActive(store)) {
                uploadHalfScreenPanel(store, "click", UBC6037.Value.VALUE_HALF_SCREEN_DIBAR_UP_CLICK, (JSONObject) null);
            }
        } else if (action instanceof BottomNextRecommendCloseBtnClick) {
            if (CommonStateExtKt.isActive(store)) {
                uploadHalfScreenPanel(store, "click", UBC6037.Value.VALUE_HALF_SCREEN_DIBAR_UP_CLOSE, (JSONObject) null);
            }
        } else if (action instanceof ClickScrollToTargetPosition) {
            uploadHalfScreenPanel(store, "click", UBC6037.Value.VALUE_HALF_SCREEN_VIDEO2_CLICK, (JSONObject) null);
        }
        return next.next(store, action);
    }

    private final void uploadHalfScreenPanel(Store<CommonState> store, String behavior, String value, JSONObject specialExt) {
        VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, store.getState(), behavior, value, (String) null, (String) null, (String) null, specialExt, (ItemModel) null, false, "6037", 440, (Object) null);
    }

    private final void updateStatisticModel(Store<CommonState> store, HalfScreenStatisticModel model) {
        CommonState state = store.getState();
        RunTimeStatus runTimeStatus = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        ItemModel itemModel = (ItemModel) (commonState != null ? commonState.select(ItemModel.class) : null);
        if (itemModel != null) {
            runTimeStatus = itemModel.getRunTimeStatus();
        }
        if (runTimeStatus != null) {
            runTimeStatus.setHalfScreenStatisticModel(model);
        }
    }

    private final HalfScreenStatisticModel getStatisticModel(Store<CommonState> store) {
        RunTimeStatus runTimeStatus;
        HalfScreenStatisticModel halfScreenStatisticModel;
        CommonState state = store.getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        if (commonState != null) {
            obj = commonState.select(ItemModel.class);
        }
        ItemModel itemModel = (ItemModel) obj;
        return (itemModel == null || (runTimeStatus = itemModel.getRunTimeStatus()) == null || (halfScreenStatisticModel = runTimeStatus.getHalfScreenStatisticModel()) == null) ? new HalfScreenStatisticModel(false, false, false, 7, (DefaultConstructorMarker) null) : halfScreenStatisticModel;
    }
}
