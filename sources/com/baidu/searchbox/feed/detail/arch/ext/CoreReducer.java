package com.baidu.searchbox.feed.detail.arch.ext;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/detail/arch/ext/CoreReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-component-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonState.kt */
public final class CoreReducer implements Reducer<CommonState> {
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bf, code lost:
        r0 = r0.getScheduleAction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r7, com.baidu.searchbox.feed.detail.frame.Action r8) {
        /*
            r6 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NetAction
            r1 = 0
            if (r0 == 0) goto L_0x002a
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x0021
            androidx.lifecycle.MutableLiveData r1 = r0.getNetAction()
        L_0x0021:
            if (r1 != 0) goto L_0x0025
            goto L_0x0168
        L_0x0025:
            r1.setValue(r8)
            goto L_0x0168
        L_0x002a:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CoreAction
            if (r0 == 0) goto L_0x0047
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x003e
            androidx.lifecycle.MutableLiveData r1 = r0.getCoreAction()
        L_0x003e:
            if (r1 != 0) goto L_0x0042
            goto L_0x0168
        L_0x0042:
            r1.setValue(r8)
            goto L_0x0168
        L_0x0047:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction
            if (r0 == 0) goto L_0x0092
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x005b
            androidx.lifecycle.MutableLiveData r1 = r0.getNestedAction()
        L_0x005b:
            if (r1 != 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r1.setValue(r8)
        L_0x0061:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected
            if (r0 == 0) goto L_0x007d
            r0 = r7
            r1 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r2 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x0168
            r1 = r8
            com.baidu.searchbox.feed.detail.arch.ext.NestedAction$OnPageSelected r1 = (com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected) r1
            int r1 = r1.getPosition()
            r0.savePosition(r1)
            goto L_0x0168
        L_0x007d:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            if (r0 == 0) goto L_0x0168
            r0 = r7
            r1 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r2 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x0168
            r0.resetPosition()
            goto L_0x0168
        L_0x0092:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.AuxiliaryNestedAction
            if (r0 == 0) goto L_0x00af
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x00a6
            androidx.lifecycle.MutableLiveData r1 = r0.getAuxiliaryNestedAction()
        L_0x00a6:
            if (r1 != 0) goto L_0x00aa
            goto L_0x0168
        L_0x00aa:
            r1.setValue(r8)
            goto L_0x0168
        L_0x00af:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction
            if (r0 == 0) goto L_0x0118
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x00cc
            androidx.lifecycle.MutableLiveData r0 = r0.getScheduleAction()
            if (r0 == 0) goto L_0x00cc
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction r0 = (com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction) r0
            goto L_0x00cd
        L_0x00cc:
            r0 = r1
        L_0x00cd:
            boolean r2 = r0 instanceof com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction.CustomTaskReady
            if (r2 == 0) goto L_0x00eb
            boolean r2 = r8 instanceof com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction.CustomTaskReady
            if (r2 == 0) goto L_0x00eb
            r2 = r8
            com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction$CustomTaskReady r2 = (com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction.CustomTaskReady) r2
            java.lang.String r2 = r2.getLevel()
            r3 = r0
            com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction$CustomTaskReady r3 = (com.baidu.searchbox.feed.detail.frame.ext.ScheduleAction.CustomTaskReady) r3
            java.lang.String r3 = r3.getLevel()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x00eb
            r2 = 1
            goto L_0x00ec
        L_0x00eb:
            r2 = 0
        L_0x00ec:
            java.lang.Class r3 = r8.getClass()
            if (r0 == 0) goto L_0x00f8
            java.lang.Class r4 = r0.getClass()
            goto L_0x00f9
        L_0x00f8:
            r4 = r1
        L_0x00f9:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0101
            if (r2 == 0) goto L_0x0168
        L_0x0101:
            r3 = r7
            r4 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r5 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r3
            if (r3 == 0) goto L_0x0111
            androidx.lifecycle.MutableLiveData r1 = r3.getScheduleAction()
        L_0x0111:
            if (r1 != 0) goto L_0x0114
            goto L_0x0168
        L_0x0114:
            r1.setValue(r8)
            goto L_0x0168
        L_0x0118:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CrossLayerServiceRegistered
            if (r0 == 0) goto L_0x0133
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x012c
            androidx.lifecycle.MutableLiveData r1 = r0.getCrossServiceState()
        L_0x012c:
            if (r1 != 0) goto L_0x012f
            goto L_0x0168
        L_0x012f:
            r1.setValue(r8)
            goto L_0x0168
        L_0x0133:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.OnItemStartFling
            if (r0 == 0) goto L_0x014e
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x0147
            androidx.lifecycle.MutableLiveData r1 = r0.getItemFlingStared()
        L_0x0147:
            if (r1 != 0) goto L_0x014a
            goto L_0x0168
        L_0x014a:
            r1.setValue(r8)
            goto L_0x0168
        L_0x014e:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.OnComponentManagerSwitch
            if (r0 == 0) goto L_0x0168
            r0 = r7
            r2 = 0
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r3 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r0 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r0
            if (r0 == 0) goto L_0x0162
            androidx.lifecycle.MutableLiveData r1 = r0.getManagerNeedReplace()
        L_0x0162:
            if (r1 != 0) goto L_0x0165
            goto L_0x0168
        L_0x0165:
            r1.setValue(r8)
        L_0x0168:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.detail.arch.ext.CoreReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
