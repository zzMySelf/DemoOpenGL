package com.baidu.searchbox.video.feedflow.ad.followmove;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.share.SharePanelVisibleChangeAction;
import com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager;
import com.baidu.searchbox.video.feedflow.ad.followmove.NadVideoFollowMoveAction;
import com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpAction;
import com.baidu.searchbox.video.feedflow.ad.moveup.PanelType;
import com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction;
import com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.MoreMenuNewPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.OnHideLongPressMenuAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.OnShowLongPressMenuAction;
import com.baidu.searchbox.video.feedflow.detail.more.OnMorePanelVisibleChange;
import com.baidu.searchbox.video.feedflow.flow.list.MultiWindowModeChanged;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/followmove/NadVideoFollowMoveMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadVideoFollowMoveMiddleware.kt */
public final class NadVideoFollowMoveMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        boolean can = false;
        if (action instanceof NadMoveUpAction.IsPanelShow) {
            PanelType actionState = ((NadMoveUpAction.IsPanelShow) action).isStart();
            if (!(actionState == PanelType.PANEL_COMMENT || actionState == PanelType.PANEL_ECOMMERCE || actionState == PanelType.DAZZLE)) {
                can = true;
            }
            StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(can));
        } else {
            if (action instanceof AdTailFrameAction.ShowAction) {
                z = true;
            } else {
                z = action instanceof OnShowLongPressMenuAction;
            }
            if (z) {
                StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(false));
            } else {
                if (action instanceof AdTailFrameAction.HideAction) {
                    z2 = true;
                } else {
                    z2 = action instanceof OnHideLongPressMenuAction;
                }
                if (z2) {
                    StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(true));
                } else if (action instanceof SharePanelVisibleChangeAction) {
                    StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(!((SharePanelVisibleChangeAction) action).isVisible()));
                } else if (action instanceof OnMorePanelVisibleChange) {
                    StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(!((OnMorePanelVisibleChange) action).isVisible()));
                } else if (action instanceof MultiWindowModeChanged) {
                    StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(!((MultiWindowModeChanged) action).isInMultiWindowMode()));
                } else if (action instanceof MoreMenuNewPanelVisibleChangedAction) {
                    StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(!((MoreMenuNewPanelVisibleChangedAction) action).getVisible()));
                } else if (action instanceof DislikeNewPanelVisibleChangedAction) {
                    StoreExtKt.post(store, new NadVideoFollowMoveAction.CanFollowMoveStateChange(!((DislikeNewPanelVisibleChangedAction) action).isVisible()));
                } else if (action instanceof UpdateFlowStyle) {
                    StoreExtKt.post(store, new NadVideoFollowMoveAction.CanShortVideoExpand(AdReduxExpManager.INSTANCE.canShortVideoFollowMoveByRatio()));
                }
            }
        }
        return next.next(store, action);
    }
}
