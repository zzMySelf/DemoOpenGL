package com.baidu.searchbox.dynamicpublisher.location;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationComponent.kt */
final class LocationComponent$isSupportLocationModify$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ LocationComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationComponent$isSupportLocationModify$2(LocationComponent locationComponent) {
        super(0);
        this.this$0 = locationComponent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r0 = (r0 = (r0 = (com.baidu.searchbox.dynamicpublisher.DynamicPublishCoreState) (r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0.getState()).select(com.baidu.searchbox.dynamicpublisher.DynamicPublishCoreState.class)).getInitModel()).isSupportLocationModify();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke() {
        /*
            r2 = this;
            com.baidu.searchbox.dynamicpublisher.location.LocationComponent r0 = r2.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            if (r0 == 0) goto L_0x002b
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x002b
            java.lang.Class<com.baidu.searchbox.dynamicpublisher.DynamicPublishCoreState> r1 = com.baidu.searchbox.dynamicpublisher.DynamicPublishCoreState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.dynamicpublisher.DynamicPublishCoreState r0 = (com.baidu.searchbox.dynamicpublisher.DynamicPublishCoreState) r0
            if (r0 == 0) goto L_0x002b
            com.baidu.searchbox.dynamicpublisher.InitModel r0 = r0.getInitModel()
            if (r0 == 0) goto L_0x002b
            java.lang.Boolean r0 = r0.isSupportLocationModify()
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.booleanValue()
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.location.LocationComponent$isSupportLocationModify$2.invoke():java.lang.Boolean");
    }
}
