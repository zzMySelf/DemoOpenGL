package com.baidu.searchbox.video.feedflow.ad.rotationpop;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.share.SharePanelVisibleChangeAction;
import com.baidu.searchbox.video.feedflow.ad.detail.AdData;
import com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpAction;
import com.baidu.searchbox.video.feedflow.ad.moveup.PanelType;
import com.baidu.searchbox.video.feedflow.ad.rotationpop.NadVideoRotationPopAction;
import com.baidu.searchbox.video.feedflow.ad.tailframe.AdTailFrameAction;
import com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.MoreMenuNewPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.OnHideLongPressMenuAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.OnShowLongPressMenuAction;
import com.baidu.searchbox.video.feedflow.detail.more.OnMorePanelVisibleChange;
import com.baidu.searchbox.video.feedflow.flow.list.MultiWindowModeChanged;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/rotationpop/NadVideoRotationPopMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadVideoRotationPopMiddleware.kt */
public final class NadVideoRotationPopMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof NetAction.Success) {
            Object data = ((NetAction.Success) action).getData();
            AdData bean = data instanceof AdData ? (AdData) data : null;
            if (bean != null) {
                StoreExtKt.post(store, new NadVideoRotationPopAction.SetData(bean.getRotationPop()));
            }
        } else {
            boolean can = false;
            if (action instanceof NadMoveUpAction.IsPanelShow) {
                PanelType actionState = ((NadMoveUpAction.IsPanelShow) action).isStart();
                if (!(actionState == PanelType.PANEL_COMMENT || actionState == PanelType.PANEL_ECOMMERCE || actionState == PanelType.DAZZLE)) {
                    can = true;
                }
                StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(can));
                StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(can));
            } else {
                if (action instanceof AdTailFrameAction.ShowAction ? true : action instanceof OnShowLongPressMenuAction) {
                    StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(false));
                    StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(false));
                } else {
                    if (action instanceof AdTailFrameAction.HideAction ? true : action instanceof OnHideLongPressMenuAction) {
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(true));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(true));
                    } else if (action instanceof MoreMenuNewPanelVisibleChangedAction) {
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(!((MoreMenuNewPanelVisibleChangedAction) action).getVisible()));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(!((MoreMenuNewPanelVisibleChangedAction) action).getVisible()));
                    } else if (action instanceof DislikeNewPanelVisibleChangedAction) {
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(!((DislikeNewPanelVisibleChangedAction) action).isVisible()));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(!((DislikeNewPanelVisibleChangedAction) action).isVisible()));
                    } else if (action instanceof SharePanelVisibleChangeAction) {
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(!((SharePanelVisibleChangeAction) action).isVisible()));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(!((SharePanelVisibleChangeAction) action).isVisible()));
                    } else if (action instanceof OnMorePanelVisibleChange) {
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(!((OnMorePanelVisibleChange) action).isVisible()));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(!((OnMorePanelVisibleChange) action).isVisible()));
                    } else if (action instanceof NestedAction.OnDetachFromScreen) {
                        StoreExtKt.post(store, NadVideoRotationPopAction.Reset.INSTANCE);
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(false));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(false));
                    } else if (action instanceof NestedAction.OnAttachToScreen) {
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(true));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(true));
                    } else if (action instanceof MultiWindowModeChanged) {
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowShowStateChange(!((MultiWindowModeChanged) action).isInMultiWindowMode()));
                        StoreExtKt.post(store, new NadVideoRotationPopAction.AllowSensorActive(!((MultiWindowModeChanged) action).isInMultiWindowMode()));
                    }
                }
            }
        }
        return next.next(store, action);
    }
}
