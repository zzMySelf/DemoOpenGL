package com.baidu.searchbox.video.feedflow.detail.share;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/share/BottomShareReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/share/ShareReducer;", "()V", "reduce", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomShareReducer.kt */
public final class BottomShareReducer extends ShareReducer {
    /* JADX WARNING: type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r6, com.baidu.searchbox.feed.detail.frame.Action r7) {
        /*
            r5 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim
            r1 = 1
            if (r0 == 0) goto L_0x0014
            r0 = r1
            goto L_0x0016
        L_0x0014:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerAction.ShowTheaterFirstITemComponent
        L_0x0016:
            if (r0 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            boolean r1 = r7 instanceof com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerAction.HideTheaterFirstITemComponent
        L_0x001b:
            if (r1 == 0) goto L_0x001e
            return r6
        L_0x001e:
            boolean r0 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CoreAction.NewIntent
            r1 = 0
            if (r0 == 0) goto L_0x0040
            r0 = r6
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.share.ShareState> r3 = com.baidu.searchbox.video.feedflow.detail.share.ShareState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.share.ShareState r0 = (com.baidu.searchbox.video.feedflow.detail.share.ShareState) r0
            if (r0 == 0) goto L_0x0033
            androidx.lifecycle.MutableLiveData r1 = r0.isEnable()
        L_0x0033:
            if (r1 != 0) goto L_0x0037
            goto L_0x00ab
        L_0x0037:
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.setValue(r0)
            goto L_0x00ab
        L_0x0040:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction
            if (r0 == 0) goto L_0x00ab
            r0 = r7
            com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction r0 = (com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction) r0
            java.lang.String r0 = r0.getNid()
            r2 = r6
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r4 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r2 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r2
            if (r2 == 0) goto L_0x005b
            java.lang.String r1 = r2.getNid()
        L_0x005b:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00ab
            r0 = r6
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.share.ShareState> r2 = com.baidu.searchbox.video.feedflow.detail.share.ShareState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.share.ShareState r0 = (com.baidu.searchbox.video.feedflow.detail.share.ShareState) r0
            if (r0 == 0) goto L_0x008c
            r1 = 0
            androidx.lifecycle.MutableLiveData r2 = r0.isEnable()
            r3 = r7
            com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction r3 = (com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction) r3
            java.lang.Boolean r3 = r3.isEnable()
            r2.setValue(r3)
            androidx.lifecycle.MutableLiveData r2 = r0.getAddButtons()
            r3 = r7
            com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction r3 = (com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction) r3
            java.util.List r3 = r3.getAddButton()
            r2.setValue(r3)
        L_0x008c:
            r0 = r6
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.component.share.CommonShareState> r2 = com.baidu.searchbox.video.component.share.CommonShareState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.component.share.CommonShareState r0 = (com.baidu.searchbox.video.component.share.CommonShareState) r0
            if (r0 == 0) goto L_0x00ab
            r1 = 0
            androidx.lifecycle.MutableLiveData r2 = r0.getShareNumModel()
            r3 = r7
            com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction r3 = (com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction) r3
            com.baidu.searchbox.video.component.share.ShareNumModel r3 = r3.getShareNumModel()
            r2.setValue(r3)
            r0.processShareNum()
        L_0x00ab:
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r0 = super.reduce((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6, (com.baidu.searchbox.feed.detail.frame.Action) r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.share.BottomShareReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
