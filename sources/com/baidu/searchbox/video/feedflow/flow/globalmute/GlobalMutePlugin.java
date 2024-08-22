package com.baidu.searchbox.video.feedflow.flow.globalmute;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.player.property.GroupScope;
import com.baidu.searchbox.player.property.MuteProperty;
import com.baidu.searchbox.player.property.PlayerPropertyManifestKt;
import com.baidu.searchbox.player.property.PropertyManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/globalmute/GlobalMutePlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "injectService", "", "isGlobalMuteMode", "", "onAttachToManager", "onResume", "setActive", "isActive", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlobalMutePlugin.kt */
public final class GlobalMutePlugin extends LiveDataPlugin {
    public void onAttachToManager() {
        GlobalMuteState $this$onAttachToManager_u24lambda_u2d1;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d1 = (GlobalMuteState) store.subscribe((Class<T>) GlobalMuteState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d1.getChangeGlobalMuteState().observe(this, new GlobalMutePlugin$$ExternalSyntheticLambda0(this, $this$onAttachToManager_u24lambda_u2d1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1$lambda-0  reason: not valid java name */
    public static final void m6347onAttachToManager$lambda1$lambda0(GlobalMutePlugin this$0, GlobalMuteState $this_apply, Boolean isMute) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        if (CommonStateExtKt.isActive(this$0.getStore()) || isMute.booleanValue()) {
            $this_apply.clearTempMuteState();
            Intrinsics.checkNotNullExpressionValue(isMute, "isMute");
            $this_apply.setGlobalMuteState(isMute.booleanValue());
            IPlayerComponentService playerComponentService = (IPlayerComponentService) this$0.getManager().getService(IPlayerComponentService.class);
            if (playerComponentService == null) {
                PropertyManager.notifyPropertyChanged$default(PropertyManager.INSTANCE, new MuteProperty(isMute.booleanValue(), new GroupScope(PlayerPropertyManifestKt.FEED_GLOBAL_MUTE_GROUP_NAME)), (Object) null, 2, (Object) null);
                BdVideoLog.d(GlobalMuteGuideHelperKt.TAG_MUTE, "GlobalMutePlugin notifyPropertyChanged " + isMute);
            } else if (!playerComponentService.isFloatingMode() || !$this_apply.isSetMuteOnDestroy()) {
                IPlayerComponentService.DefaultImpls.setMuteMode$default(playerComponentService, isMute.booleanValue(), false, false, 6, (Object) null);
                BdVideoLog.d(GlobalMuteGuideHelperKt.TAG_MUTE, "GlobalMutePlugin setMuteMode " + isMute);
            } else {
                IPlayerComponentService.DefaultImpls.setMuteMode$default(playerComponentService, false, false, false, 6, (Object) null);
                playerComponentService.setMuteMode(true, false, false);
            }
        } else {
            $this_apply.setTempMuteState(isMute);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r6.isNeedRestoreMuteState() == true) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setActive(boolean r8) {
        /*
            r7 = this;
            super.setActive(r8)
            if (r8 == 0) goto L_0x003e
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002e
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x001a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001b
        L_0x001a:
            r4 = r6
        L_0x001b:
            if (r4 == 0) goto L_0x0023
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState> r5 = com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x0023:
            com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState r6 = (com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState) r6
            if (r6 == 0) goto L_0x002e
            boolean r0 = r6.isNeedRestoreMuteState()
            if (r0 != r1) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            if (r1 == 0) goto L_0x003e
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x003e
            com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteAction$TryRestoreGlobalMuteStatus r1 = com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteAction.TryRestoreGlobalMuteStatus.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMutePlugin.setActive(boolean):void");
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(IGlobalMuteService.class, new GlobalMuteService(this));
    }

    public final boolean isGlobalMuteMode() {
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(GlobalMuteState.class);
            }
            GlobalMuteState globalMuteState = (GlobalMuteState) obj;
            if (globalMuteState != null) {
                return globalMuteState.getGlobalMuteState();
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r5 = this;
            super.onResume()
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0021
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0016
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0017
        L_0x0016:
            r3 = r1
        L_0x0017:
            if (r3 == 0) goto L_0x001f
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState> r1 = com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x001f:
            com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState r1 = (com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMuteState) r1
        L_0x0021:
            if (r1 != 0) goto L_0x0024
            goto L_0x002d
        L_0x0024:
            com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelper r0 = com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideHelper.INSTANCE
            boolean r0 = r0.isGlobalMuteOpen()
            r1.setGlobalMuteState(r0)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.globalmute.GlobalMutePlugin.onResume():void");
    }
}
