package com.baidu.searchbox.video.feedflow.detail.livebottom;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.ext.common.InterceptAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.LiveInteractModel;
import com.baidu.searchbox.flowvideo.livestatus.repos.LiveStatusModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.FlowDetailState;
import com.baidu.searchbox.video.feedflow.detail.bottom.BottomBarReducerAdapterAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarCommentClickedAction;
import com.baidu.searchbox.video.feedflow.detail.liveentrance.LiveEntranceState;
import com.baidu.searchbox.video.feedflow.detail.liveplayer.LiveException;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarModel;
import com.baidu.searchbox.video.feedflow.flow.bottom.utils.TopBackUtilsKt;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowPadUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livebottom/LiveBottomBarAdapterMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "getItemIDList", "", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBottomBarAdapterMiddleware.kt */
public final class LiveBottomBarAdapterMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        LiveEntranceState liveEntranceState;
        FlowDetailModel data;
        LiveInteractModel liveInteract;
        String cmd;
        LiveEntranceState liveEntranceState2;
        FlowDetailModel data2;
        LiveInteractModel liveInteract2;
        String cmd2;
        FlowDetailModel model;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        LiveStatusModel liveStatusModel = null;
        if (action instanceof NetAction.Success) {
            if (store.getState().isActive()) {
                Object data3 = ((NetAction.Success) action).getData();
                FlowDetailModel bean = data3 instanceof FlowDetailModel ? (FlowDetailModel) data3 : null;
                if (bean != null) {
                    StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateData(LiveBottomBarMapper.INSTANCE.map(bean)));
                    if (bean.isLiveEnd()) {
                        StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateInputAlpha(0.3f));
                    }
                    StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableCommentView(true ^ bean.isLiveEnd()));
                }
                Object data4 = ((NetAction.Success) action).getData();
                LiveStatusModel it = data4 instanceof LiveStatusModel ? (LiveStatusModel) data4 : null;
                if (it != null) {
                    if (it.isLiveEnd()) {
                        liveStatusModel = it;
                    }
                    if (liveStatusModel != null) {
                        LiveStatusModel liveStatusModel2 = liveStatusModel;
                        StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateInputAlpha(0.3f));
                        StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableCommentView(false));
                    }
                }
            }
        } else if (action instanceof NestedAction.OnPageSelected) {
            StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateBarView(getItemIDList(store)));
            CommonState state = store.getState();
            CommonState commonState = state instanceof CommonState ? state : null;
            FlowDetailState flowDetailState = (FlowDetailState) (commonState != null ? commonState.select(FlowDetailState.class) : null);
            if (flowDetailState == null || (model = flowDetailState.getData()) == null) {
                StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateData((BottomBarModel) null));
                StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableCommentView(false));
            } else {
                StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateData(LiveBottomBarMapper.INSTANCE.map(model)));
                if (model.isLiveEnd()) {
                    StoreExtKt.post(store, new BottomBarReducerAdapterAction.UpdateInputAlpha(0.3f));
                }
                StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableCommentView(true ^ model.isLiveEnd()));
                return next.next(store, action);
            }
        } else if (!(action instanceof LiveException)) {
            String cmd3 = "";
            if (action instanceof BottomBarCommentClickedAction) {
                FlowDetailState flowDetailState2 = (FlowDetailState) store.getState().select(FlowDetailState.class);
                if (!(flowDetailState2 == null || (data2 = flowDetailState2.getData()) == null || (liveInteract2 = data2.getLiveInteract()) == null || (cmd2 = liveInteract2.getCmd()) == null)) {
                    cmd3 = cmd2;
                }
                if ((!StringsKt.isBlank(cmd3)) && (liveEntranceState2 = (LiveEntranceState) store.getState().select(LiveEntranceState.class)) != null) {
                    liveEntranceState2.setOpenLiveRoom(true);
                }
            } else if ((action instanceof InterceptAction) && (((InterceptAction) action).getOriginAction() instanceof BottomBarCommentClickedAction)) {
                FlowDetailState flowDetailState3 = (FlowDetailState) store.getState().select(FlowDetailState.class);
                if (!(flowDetailState3 == null || (data = flowDetailState3.getData()) == null || (liveInteract = data.getLiveInteract()) == null || (cmd = liveInteract.getCmd()) == null)) {
                    cmd3 = cmd;
                }
                if ((!StringsKt.isBlank(cmd3)) && (liveEntranceState = (LiveEntranceState) store.getState().select(LiveEntranceState.class)) != null) {
                    liveEntranceState.setOpenLiveRoom(true);
                }
            }
        } else if (store.getState().isActive()) {
            StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableCommentView(false));
        }
        return next.next(store, action);
    }

    private final List<Integer> getItemIDList(Store<CommonState> store) {
        List arrayList = new ArrayList();
        List $this$getItemIDList_u24lambda_u2d4 = arrayList;
        if (!TopBackUtilsKt.isTopBackSwitch() && VideoFlowPadUtilsKt.canShowBottomBackView(store)) {
            $this$getItemIDList_u24lambda_u2d4.add(1);
        }
        $this$getItemIDList_u24lambda_u2d4.add(10);
        return arrayList;
    }
}
