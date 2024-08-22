package com.baidu.searchbox.video.feedflow.clearscreen;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenBottomAction;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenNewAction;
import com.baidu.searchbox.video.feedflow.clearscreen.statistic.ClearScreenFrom;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.OnCarouselPicTwoFingerPressEnd;
import com.baidu.searchbox.video.feedflow.detail.dynamic.longpicbtn.OnLongPicBtnClick;
import com.baidu.searchbox.video.feedflow.detail.dynamic.music.DynamicBgmActionManifest;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreAirPlayClickAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreClearScreenClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.ClearScreenBtnClick;
import com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameShownAction;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedAction;
import com.baidu.searchbox.video.feedflow.flow.slide.LeftSlideAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenNewMiddleware.kt */
public final class ClearScreenNewMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        ClearScreenFrom from;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        Object obj = null;
        if (action instanceof UninterestedAction ? true : action instanceof LongPressMoreAirPlayClickAction) {
            StoreExtKt.post(store, new ClearScreenNewAction.ExitClearScreen((ClearScreenFrom) null, 1, (DefaultConstructorMarker) null));
        } else if (action instanceof ClearScreenBottomAction.OnCloseBtnClicked) {
            StoreExtKt.post(store, new ClearScreenNewAction.ExitClearScreen(ClearScreenFrom.CLOSE_BAR));
        } else if (action instanceof OnCarouselPicTwoFingerPressEnd) {
            CommonState state = store.getState();
            CommonState commonState = state instanceof CommonState ? state : null;
            if (commonState != null) {
                obj = commonState.select(ClearScreenNewState.class);
            }
            ClearScreenNewState clearScreenNewState = (ClearScreenNewState) obj;
            if (clearScreenNewState != null) {
                ClearScreenNewState $this$apply_u24lambda_u2d0 = clearScreenNewState;
                if (((OnCarouselPicTwoFingerPressEnd) action).getEnlarge()) {
                    from = ClearScreenFrom.GESTURE_ENLARGE;
                } else {
                    from = ClearScreenFrom.GESTURE_NARROW;
                }
                if (!((OnCarouselPicTwoFingerPressEnd) action).getCancelNext()) {
                    if (!BdPlayerUtils.orFalse(Boolean.valueOf($this$apply_u24lambda_u2d0.isInClearScreen()))) {
                        store.dispatch(new ClearScreenNewAction.EnterClearScreen(from));
                    } else if (!((OnCarouselPicTwoFingerPressEnd) action).getEnlarge()) {
                        store.dispatch(new ClearScreenNewAction.ExitClearScreen(from));
                    }
                }
            }
        } else if (action instanceof ClearScreenBtnClick) {
            CommonState state2 = store.getState();
            CommonState commonState2 = state2 instanceof CommonState ? state2 : null;
            if (commonState2 != null) {
                obj = commonState2.select(ClearScreenNewState.class);
            }
            ClearScreenNewState $this$apply_u24lambda_u2d1 = (ClearScreenNewState) obj;
            if ($this$apply_u24lambda_u2d1 != null) {
                if (BdPlayerUtils.orFalse(Boolean.valueOf($this$apply_u24lambda_u2d1.isInClearScreen()))) {
                    StoreExtKt.post(store, new ClearScreenNewAction.ExitClearScreen(ClearScreenFrom.MENU));
                } else {
                    StoreExtKt.post(store, new ClearScreenNewAction.EnterClearScreen(ClearScreenFrom.MENU));
                }
            }
        } else if (action instanceof OnColumnLastFrameShownAction) {
            StoreExtKt.post(store, new ClearScreenNewAction.ExitClearScreen((ClearScreenFrom) null, 1, (DefaultConstructorMarker) null));
        } else if (action instanceof LeftSlideAction.OpenAction) {
            StoreExtKt.post(store, new ClearScreenNewAction.ExitClearScreen((ClearScreenFrom) null, 1, (DefaultConstructorMarker) null));
        } else if (action instanceof DynamicBgmActionManifest.OnBgmStatusChangedAction) {
            StoreExtKt.post(store, ClearScreenBottomAction.RefreshPlayBtnStatus.INSTANCE);
        } else if (action instanceof LongPressMoreClearScreenClickAction) {
            CommonState state3 = store.getState();
            CommonState commonState3 = state3 instanceof CommonState ? state3 : null;
            if (commonState3 != null) {
                obj = commonState3.select(ClearScreenNewState.class);
            }
            ClearScreenNewState $this$apply_u24lambda_u2d2 = (ClearScreenNewState) obj;
            if ($this$apply_u24lambda_u2d2 != null) {
                if (BdPlayerUtils.orFalse(Boolean.valueOf($this$apply_u24lambda_u2d2.isInClearScreen()))) {
                    StoreExtKt.post(store, new ClearScreenNewAction.ExitClearScreen(ClearScreenFrom.LONG_MENU));
                } else {
                    StoreExtKt.post(store, new ClearScreenNewAction.EnterClearScreen(ClearScreenFrom.LONG_MENU));
                }
            }
        } else if (action instanceof OnLongPicBtnClick) {
            StoreExtKt.post(store, new ClearScreenNewAction.EnterClearScreen(ClearScreenFrom.LONG_PIC_BTN));
        }
        return next.next(store, action);
    }
}
