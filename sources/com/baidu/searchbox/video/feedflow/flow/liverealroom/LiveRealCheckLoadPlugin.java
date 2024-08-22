package com.baidu.searchbox.video.feedflow.flow.liverealroom;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.live.host2live.video.LiveType;
import com.baidu.searchbox.video.feedflow.detail.livereal.LiveAtcData;
import com.baidu.searchbox.video.feedflow.detail.livereal.LiveCheckStatus;
import com.baidu.searchbox.video.feedflow.detail.livereal.MediaAndYYController;
import com.baidu.searchbox.video.feedflow.detail.livereal.VideoInsertLiveManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/liverealroom/LiveRealCheckLoadPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "checkAndLoadLive", "", "type", "Lcom/baidu/searchbox/live/host2live/video/LiveType;", "checkNextYYRealLive", "loadLivePluginCallback", "com/baidu/searchbox/video/feedflow/flow/liverealroom/LiveRealCheckLoadPlugin$loadLivePluginCallback$1", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;)Lcom/baidu/searchbox/video/feedflow/flow/liverealroom/LiveRealCheckLoadPlugin$loadLivePluginCallback$1;", "onAttachToManager", "onDestroy", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveRealCheckLoadPlugin.kt */
public final class LiveRealCheckLoadPlugin extends LiveDataPlugin {
    public void onAttachToManager() {
        LiveRealCheckLoadState liveRealCheckLoadState;
        MutableLiveData<Unit> yyLiveNeedLoad;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && (liveRealCheckLoadState = (LiveRealCheckLoadState) $this$subscribe$iv.subscribe(LiveRealCheckLoadState.class)) != null && (yyLiveNeedLoad = liveRealCheckLoadState.getYyLiveNeedLoad()) != null) {
            yyLiveNeedLoad.observe(this, new LiveRealCheckLoadPlugin$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-0  reason: not valid java name */
    public static final void m6518onAttachToManager$lambda0(LiveRealCheckLoadPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkAndLoadLive(LiveType.YY);
    }

    private final void checkAndLoadLive(LiveType type) {
        LiveAtcData liveAct = MediaAndYYController.INSTANCE.getLiveAct(getContext().hashCode(), type);
        if ((liveAct != null ? liveAct.getCheckStatus() : null) == LiveCheckStatus.NO_CHECK) {
            LiveAtcData liveAct2 = MediaAndYYController.INSTANCE.getLiveAct(getContext().hashCode(), type);
            if (liveAct2 != null) {
                liveAct2.setCheckStatus(LiveCheckStatus.EXECUTE_CHECK_ING);
            }
            VideoInsertLiveManager.INSTANCE.checkAndLoadLivePlugin(type, loadLivePluginCallback(type));
        }
    }

    private final LiveRealCheckLoadPlugin$loadLivePluginCallback$1 loadLivePluginCallback(LiveType type) {
        return new LiveRealCheckLoadPlugin$loadLivePluginCallback$1(this, type);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkNextYYRealLive(com.baidu.searchbox.live.host2live.video.LiveType r7) {
        /*
            r6 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r6.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x002d
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0013
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 == 0) goto L_0x001d
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r4 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r3 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r3
            if (r3 == 0) goto L_0x002d
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r0 = r3.getCurItemModel()
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.getNid()
            goto L_0x002e
        L_0x002d:
            r0 = r1
        L_0x002e:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x003c
            int r2 = r2.length()
            if (r2 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = 0
            goto L_0x003d
        L_0x003c:
            r2 = 1
        L_0x003d:
            if (r2 == 0) goto L_0x0040
            return
        L_0x0040:
            com.baidu.searchbox.feed.detail.frame.Store r2 = r6.getStore()
            if (r2 == 0) goto L_0x0080
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r2.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0052
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0053
        L_0x0052:
            r4 = r1
        L_0x0053:
            if (r4 == 0) goto L_0x005b
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r1 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r1 = r4.select(r1)
        L_0x005b:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r1 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r1
            if (r1 == 0) goto L_0x0080
            com.baidu.searchbox.video.feedflow.flow.liverealroom.LiveRealCheckLoadPlugin$checkNextYYRealLive$1 r2 = new com.baidu.searchbox.video.feedflow.flow.liverealroom.LiveRealCheckLoadPlugin$checkNextYYRealLive$1
            r2.<init>(r6)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = r1.getNextItemByNid(r0, r2)
            if (r1 == 0) goto L_0x0080
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.Store r3 = r6.getStore()
            if (r3 == 0) goto L_0x007f
            com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerAction$LiveRealObtainActAction r4 = new com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerAction$LiveRealObtainActAction
            r4.<init>(r7)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r3, r4)
        L_0x007f:
            goto L_0x0081
        L_0x0080:
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.liverealroom.LiveRealCheckLoadPlugin.checkNextYYRealLive(com.baidu.searchbox.live.host2live.video.LiveType):void");
    }

    public void onDestroy() {
        super.onDestroy();
        MediaAndYYController.INSTANCE.clearAct(getContext().hashCode());
    }
}
