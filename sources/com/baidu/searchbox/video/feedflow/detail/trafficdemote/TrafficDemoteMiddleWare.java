package com.baidu.searchbox.video.feedflow.detail.trafficdemote;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.trafficdemote.TrafficDemoteDataManager;
import com.baidu.searchbox.player.trafficdemote.TrafficDemoteDataManagerKt;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.LongPressMenuItemClickAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame;
import com.baidu.searchbox.video.feedflow.detail.toast.OnTipBtnClickAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/trafficdemote/TrafficDemoteMiddleWare;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "isSendPrepareAction", "", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "deliverAction", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrafficDemoteMiddleWare.kt */
public final class TrafficDemoteMiddleWare implements Middleware<CommonState> {
    private boolean isSendPrepareAction;

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof PlayerFirstFrame) {
            TrafficDemoteDataManager.INSTANCE.savePlayInMobile();
            Action $this$apply_u24lambda_u2d0 = deliverAction(store, ((PlayerFirstFrame) action).getItemModel());
            if ($this$apply_u24lambda_u2d0 != null) {
                StoreExtKt.post(store, $this$apply_u24lambda_u2d0);
            }
        } else if (action instanceof OnTipBtnClickAction) {
            if (Intrinsics.areEqual((Object) ((OnTipBtnClickAction) action).getTipKey(), (Object) TrafficDemoteDataManagerKt.KEY_TRAFFIC_DEMOTE_TIP)) {
                StoreExtKt.post(store, new TrafficDemoteTipClickAction(((OnTipBtnClickAction) action).getTipKey()));
            }
        } else if ((action instanceof LongPressMenuItemClickAction) && ((LongPressMenuItemClickAction) action).getItemType() == 22) {
            Object ext = ((LongPressMenuItemClickAction) action).getExt();
            StoreExtKt.post(store, new TrafficDemoteSwitchClickAction(BdPlayerUtils.orFalse(ext instanceof Boolean ? (Boolean) ext : null)));
        }
        return next.next(store, action);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r6.getRunTimeStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.feed.detail.frame.Action deliverAction(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r5, com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r6) {
        /*
            r4 = this;
            com.baidu.searchbox.player.trafficdemote.TrafficDemoteDataManager r0 = com.baidu.searchbox.player.trafficdemote.TrafficDemoteDataManager.INSTANCE
            boolean r0 = r0.isNeedShowBottomTip()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            if (r6 == 0) goto L_0x0017
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r0 = r6.getRunTimeStatus()
            if (r0 == 0) goto L_0x0017
            int r0 = r0.getPosition()
            goto L_0x0018
        L_0x0017:
            r0 = -1
        L_0x0018:
            r2 = 0
            boolean r3 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.isPageSourceFromChannelFlow((com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState>) r5)
            if (r3 == 0) goto L_0x0020
            r2 = 1
        L_0x0020:
            if (r0 == r2) goto L_0x0031
            boolean r3 = r4.isSendPrepareAction
            if (r3 != 0) goto L_0x0029
            if (r0 < r2) goto L_0x0029
            goto L_0x0031
        L_0x0029:
            if (r0 <= r2) goto L_0x0030
            com.baidu.searchbox.video.feedflow.detail.trafficdemote.TrafficDemoteTipShowAction r1 = com.baidu.searchbox.video.feedflow.detail.trafficdemote.TrafficDemoteTipShowAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            return r1
        L_0x0030:
            return r1
        L_0x0031:
            r1 = 1
            r4.isSendPrepareAction = r1
            com.baidu.searchbox.video.feedflow.detail.trafficdemote.TrafficDemoteTipPrepareAction r1 = com.baidu.searchbox.video.feedflow.detail.trafficdemote.TrafficDemoteTipPrepareAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.trafficdemote.TrafficDemoteMiddleWare.deliverAction(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.video.feedflow.flow.list.ItemModel):com.baidu.searchbox.feed.detail.frame.Action");
    }
}
