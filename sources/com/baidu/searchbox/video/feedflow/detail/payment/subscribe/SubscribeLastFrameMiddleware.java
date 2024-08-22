package com.baidu.searchbox.video.feedflow.detail.payment.subscribe;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/subscribe/SubscribeLastFrameMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubscribeLastFrameMiddleware.kt */
public final class SubscribeLastFrameMiddleware implements Middleware<CommonState> {
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r9, com.baidu.searchbox.feed.detail.frame.Action r10, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r10 instanceof com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete
            if (r0 == 0) goto L_0x00f7
            r0 = r9
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r2 = r0.getState()
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r4 = 0
            if (r3 == 0) goto L_0x0024
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x0025
        L_0x0024:
            r2 = r4
        L_0x0025:
            if (r2 == 0) goto L_0x002e
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentPlayerState> r3 = com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentPlayerState.class
            java.lang.Object r2 = r2.select(r3)
            goto L_0x002f
        L_0x002e:
            r2 = r4
        L_0x002f:
            com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentPlayerState r2 = (com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentPlayerState) r2
            r0 = 1
            r1 = 0
            if (r2 == 0) goto L_0x003d
            boolean r2 = r2.getShowPreviewEndPayView()
            if (r2 != r0) goto L_0x003d
            r2 = r0
            goto L_0x003e
        L_0x003d:
            r2 = r1
        L_0x003e:
            if (r2 == 0) goto L_0x00f1
            com.baidu.searchbox.feed.detail.frame.State r2 = r9.getState()
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            r3 = r10
            com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete r3 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete) r3
            r5 = r2
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameState> r7 = com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameState.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameState r5 = (com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameState) r5
            if (r5 == 0) goto L_0x005d
            boolean r5 = r5.canShow()
            if (r5 != r0) goto L_0x005d
            r5 = r0
            goto L_0x005e
        L_0x005d:
            r5 = r1
        L_0x005e:
            if (r5 == 0) goto L_0x008d
            r5 = r2
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.autoplay.PaymentAutoPlayInterceptState> r7 = com.baidu.searchbox.video.feedflow.detail.payment.autoplay.PaymentAutoPlayInterceptState.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.detail.payment.autoplay.PaymentAutoPlayInterceptState r5 = (com.baidu.searchbox.video.feedflow.detail.payment.autoplay.PaymentAutoPlayInterceptState) r5
            if (r5 == 0) goto L_0x0074
            boolean r5 = r5.getCanAutoPlay()
            if (r5 != r0) goto L_0x0074
            r5 = r0
            goto L_0x0075
        L_0x0074:
            r5 = r1
        L_0x0075:
            if (r5 != 0) goto L_0x008d
            r5 = r2
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState> r7 = com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState.class
            java.lang.Object r5 = r5.select(r7)
            com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState r5 = (com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState) r5
            if (r5 == 0) goto L_0x0088
            androidx.lifecycle.MutableLiveData r5 = r5.getCollectionModel()
            goto L_0x0089
        L_0x0088:
            r5 = r4
        L_0x0089:
            if (r5 == 0) goto L_0x008d
            r5 = r0
            goto L_0x008e
        L_0x008d:
            r5 = r1
        L_0x008e:
            r3.setPaymentSubscribeLastFrameShowing(r5)
            r3 = r9
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x009e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x009f
        L_0x009e:
            r6 = r4
        L_0x009f:
            if (r6 == 0) goto L_0x00a8
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r7 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x00a9
        L_0x00a8:
            r6 = r4
        L_0x00a9:
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r6 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r6
            if (r6 == 0) goto L_0x00b4
            boolean r3 = r6.isInterceptAutoShowPanel()
            if (r3 != r0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r0 = r1
        L_0x00b5:
            if (r0 == 0) goto L_0x00f7
            com.baidu.searchbox.feed.detail.frame.State r1 = r9.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            boolean r1 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r1)
            if (r1 == 0) goto L_0x00f7
            r1 = r9
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r1.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x00d1
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00d2
        L_0x00d1:
            r5 = r4
        L_0x00d2:
            if (r5 == 0) goto L_0x00db
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState> r6 = com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x00dc
        L_0x00db:
            r5 = r4
        L_0x00dc:
            com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState r5 = (com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState) r5
            if (r5 == 0) goto L_0x00e4
            androidx.lifecycle.MutableLiveData r4 = r5.getReplay()
        L_0x00e4:
            if (r4 != 0) goto L_0x00e7
            goto L_0x00ec
        L_0x00e7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r4.setValue(r1)
        L_0x00ec:
            com.baidu.searchbox.feed.detail.frame.Consumer r1 = com.baidu.searchbox.feed.detail.frame.Consumer.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            return r1
        L_0x00f1:
            r0 = r10
            com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete r0 = (com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete) r0
            r0.setPaymentSubscribeLastFrameShowing(r1)
        L_0x00f7:
            com.baidu.searchbox.feed.detail.frame.Action r0 = r11.next(r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }
}
