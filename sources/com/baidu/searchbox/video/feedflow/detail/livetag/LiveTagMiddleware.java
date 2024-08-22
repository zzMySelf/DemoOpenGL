package com.baidu.searchbox.video.feedflow.detail.livetag;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.liveplayer.LiveException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livetag/LiveTagMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTagMiddleware.kt */
public final class LiveTagMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof NetAction.Success) {
            Object data = ((NetAction.Success) action).getData();
            Object obj = null;
            FlowDetailModel flowDetailModel = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
            if (flowDetailModel != null && !flowDetailModel.isOffLineVideo()) {
                CommonState state = store.getState();
                CommonState commonState = state instanceof CommonState ? state : null;
                if (commonState != null) {
                    obj = commonState.select(LiveTagState.class);
                }
                if (((LiveTagState) obj) != null) {
                    StoreExtKt.post(store, new LiveTagNetSuccess(flowDetailModel.getLiveTagText()));
                }
            }
        } else if (action instanceof NetAction.Failure) {
            if (Intrinsics.areEqual((Object) ((NetAction.Failure) action).getClazz(), (Object) FlowDetailModel.class)) {
                StoreExtKt.post(store, new LiveTagIsVisible(false));
            }
        } else if (action instanceof LiveException) {
            StoreExtKt.post(store, new LiveTagIsVisible(false));
        } else if (action instanceof NestedAction.OnBindData) {
            StoreExtKt.post(store, new LiveTagIsVisible(false));
        }
        return next.next(store, action);
    }
}
