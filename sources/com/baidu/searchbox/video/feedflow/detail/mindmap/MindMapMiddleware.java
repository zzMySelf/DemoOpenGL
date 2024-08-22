package com.baidu.searchbox.video.feedflow.detail.mindmap;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.mindmap.MindMapAction;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrSummaryAction;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.ocrinterface.OrcPanelSubHeaderType;
import com.baidu.searchbox.video.feedflow.detail.player.InvokePlayerPause;
import com.baidu.searchbox.video.feedflow.detail.player.InvokePlayerResume;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryLeftBtnViewClickAction;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryLeftViewType;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/mindmap/MindMapMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "showMindMapViewer", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MindMapMiddleware.kt */
public final class MindMapMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof OcrSummaryAction.OnPanelSubHeaderClickAction) {
            if (((OcrSummaryAction.OnPanelSubHeaderClickAction) action).getType() == OrcPanelSubHeaderType.MIND_TYPE) {
                showMindMapViewer(store);
            }
        } else if (action instanceof VideoSummaryLeftBtnViewClickAction) {
            if (((VideoSummaryLeftBtnViewClickAction) action).getType() == VideoSummaryLeftViewType.MIND_TYPE) {
                showMindMapViewer(store);
            }
        } else if ((action instanceof MindMapAction.MindMapViewVisibleChange) && !MIndMapConfigKt.getMindMapVideoPlaySwitch(store)) {
            if (((MindMapAction.MindMapViewVisibleChange) action).getVisible()) {
                StoreExtKt.post(store, new InvokePlayerPause(0));
            } else {
                StoreExtKt.post(store, new InvokePlayerResume(false));
            }
        }
        return next.next(store, action);
    }

    private final void showMindMapViewer(Store<CommonState> store) {
        if (!LandscapeFlowSwitchKt.isLandscapeFlowMode((Store<?>) store)) {
            CommonState state = store.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? state : null;
            if (commonState != null) {
                obj = commonState.select(MindMapState.class);
            }
            MindMapState mindMapState = (MindMapState) obj;
            boolean z = false;
            if (mindMapState != null && mindMapState.isMindMapDataValid()) {
                z = true;
            }
            if (z) {
                store.dispatch(new MindMapAction.MindMapViewVisibleChange(true));
            }
        }
    }
}
