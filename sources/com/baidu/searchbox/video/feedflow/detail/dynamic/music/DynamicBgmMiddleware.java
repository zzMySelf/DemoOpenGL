package com.baidu.searchbox.video.feedflow.detail.dynamic.music;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.CarouselProgressBarView;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.OnCarouselProgressBarStateChanged;
import com.baidu.searchbox.video.feedflow.detail.dynamic.music.DynamicBgmActionManifest;
import com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim.CardPanelAction;
import com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim.CardPanelBgmStatus;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/music/DynamicBgmMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicBgmMiddleware.kt */
public class DynamicBgmMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof NestedAction.OnPageSelected) {
            StoreExtKt.post(store, new CardPanelAction.BgmStatusAction(CardPanelBgmStatus.START, 0, 2, (DefaultConstructorMarker) null));
        } else if (action instanceof NetAction.Success) {
            if (CommonStateExtKt.isActive(store)) {
                StoreExtKt.post(store, new CardPanelAction.BgmStatusAction(CardPanelBgmStatus.START, 0, 2, (DefaultConstructorMarker) null));
            }
        } else if (action instanceof NestedAction.OnDetachFromScreen) {
            StoreExtKt.post(store, new CardPanelAction.BgmStatusAction(CardPanelBgmStatus.STOP, 0, 2, (DefaultConstructorMarker) null));
        } else if (action instanceof OnCarouselProgressBarStateChanged) {
            if (((OnCarouselProgressBarStateChanged) action).isUserPauseOrResume()) {
                if (((OnCarouselProgressBarStateChanged) action).getState() == CarouselProgressBarView.State.PAUSE) {
                    StoreExtKt.post(store, new CardPanelAction.BgmStatusAction(CardPanelBgmStatus.PAUSE, 1));
                } else if (((OnCarouselProgressBarStateChanged) action).getState() == CarouselProgressBarView.State.RUNNING) {
                    StoreExtKt.post(store, new CardPanelAction.BgmStatusAction(CardPanelBgmStatus.RESUME, 0, 2, (DefaultConstructorMarker) null));
                }
            }
        } else if ((action instanceof DynamicBgmActionManifest.DynamicPlayerFirstFrame) && CommonStateExtKt.isFirstJump$default(store.getState(), (ItemModel) null, 1, (Object) null)) {
            store.dispatch(DynamicBgmActionManifest.DynamicFirstJumpPlayerFirstFrame.INSTANCE);
        }
        return next.next(store, action);
    }
}
