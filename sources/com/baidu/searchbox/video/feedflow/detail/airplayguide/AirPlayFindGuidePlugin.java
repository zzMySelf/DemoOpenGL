package com.baidu.searchbox.video.feedflow.detail.airplayguide;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.common.config.AirPlayOptSwitchConfig;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import com.baidu.searchbox.video.service.guidepriority.GuideType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/airplayguide/AirPlayFindGuidePlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "playerListener", "com/baidu/searchbox/video/feedflow/detail/airplayguide/AirPlayFindGuidePlugin$playerListener$1", "Lcom/baidu/searchbox/video/feedflow/detail/airplayguide/AirPlayFindGuidePlugin$playerListener$1;", "frequencyControlCanShow", "", "getDurationLimit", "", "getFindTipGuideSwitch", "hideGuide", "", "onAttachToManager", "onDestroy", "playerService", "Lcom/baidu/searchbox/video/feedflow/detail/player/service/IPlayerComponentService;", "registerGuide", "removePlayerListener", "showGuide", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AirPlayFindGuidePlugin.kt */
public final class AirPlayFindGuidePlugin extends LiveDataPlugin {
    private final AirPlayFindGuidePlugin$playerListener$1 playerListener = new AirPlayFindGuidePlugin$playerListener$1(this);

    public void onAttachToManager() {
        AirPlayFindGuideState $this$onAttachToManager_u24lambda_u2d8;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || (coreState = (CoreState) $this$subscribe$iv.subscribe(CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new AirPlayFindGuidePlugin$$ExternalSyntheticLambda0(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && ($this$onAttachToManager_u24lambda_u2d8 = (AirPlayFindGuideState) $this$subscribe$iv2.subscribe(AirPlayFindGuideState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d8.getOnPlayerFirstFrame().observe(this, new AirPlayFindGuidePlugin$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d8.getHideGuide().observe(this, new AirPlayFindGuidePlugin$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d8.getOnFindAirPlayDevice().observe(this, new AirPlayFindGuidePlugin$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d8.getOnGuideTipDismiss().observe(this, new AirPlayFindGuidePlugin$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-0  reason: not valid java name */
    public static final void m10577onAttachToManager$lambda0(AirPlayFindGuidePlugin this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = null;
        if (nestedAction instanceof NestedAction.OnBindData) {
            this$0.removePlayerListener();
            this$0.hideGuide();
            Store $this$select$iv = this$0.getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(AirPlayFindGuideState.class);
                }
                AirPlayFindGuideState airPlayFindGuideState = (AirPlayFindGuideState) obj;
                if (airPlayFindGuideState != null) {
                    airPlayFindGuideState.reset();
                }
            }
        } else if (nestedAction instanceof NestedAction.OnDetachFromScreen) {
            this$0.removePlayerListener();
            this$0.hideGuide();
            Store $this$select$iv2 = this$0.getStore();
            if ($this$select$iv2 != null) {
                AbsState state2 = $this$select$iv2.getState();
                CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
                if (commonState2 != null) {
                    obj = commonState2.select(AirPlayFindGuideState.class);
                }
                AirPlayFindGuideState airPlayFindGuideState2 = (AirPlayFindGuideState) obj;
                if (airPlayFindGuideState2 != null) {
                    airPlayFindGuideState2.reset();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-3  reason: not valid java name */
    public static final void m10578onAttachToManager$lambda8$lambda3(AirPlayFindGuidePlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getFindTipGuideSwitch() && !LandscapeFlowSwitchKt.isLandscapeFlowMode((Store<?>) this$0.getStore())) {
            IPlayerComponentService $this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d1 = this$0.playerService();
            boolean z = true;
            if ($this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d1 != null) {
                if ($this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d1.isAirPlayWorking() || $this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d1.isAirPlayLayerShowing() || ((float) BdPlayerUtils.orZero(Integer.valueOf($this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d1.getDuration()))) / 60.0f <= ((float) this$0.getDurationLimit())) {
                    z = false;
                }
            } else {
                z = false;
            }
            if (z && this$0.frequencyControlCanShow()) {
                this$0.registerGuide();
                IPlayerComponentService playerService = this$0.playerService();
                if (playerService != null) {
                    AirPlayFindGuidePlugin$playerListener$1 $this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d2 = this$0.playerListener;
                    $this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d2.setHasSearch(false);
                    playerService.addPlayerComponentListener($this$onAttachToManager_u24lambda_u2d8_u24lambda_u2d3_u24lambda_u2d2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-4  reason: not valid java name */
    public static final void m10579onAttachToManager$lambda8$lambda4(AirPlayFindGuidePlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideGuide();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        if (((r0.isAirPlayWorking() || r0.isAirPlayLayerShowing()) ? 1 : null) == null) goto L_0x005a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* renamed from: onAttachToManager$lambda-8$lambda-6  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m10580onAttachToManager$lambda8$lambda6(com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin r7, kotlin.Unit r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r0)
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x006e
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r3 = 1
            if (r0 == 0) goto L_0x003c
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0025
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0026
        L_0x0025:
            r5 = r1
        L_0x0026:
            if (r5 == 0) goto L_0x002f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState> r6 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0030
        L_0x002f:
            r5 = r1
        L_0x0030:
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState r5 = (com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState) r5
            if (r5 == 0) goto L_0x003c
            boolean r0 = r5.isSearching()
            if (r0 != r3) goto L_0x003c
            r0 = r3
            goto L_0x003d
        L_0x003c:
            r0 = r2
        L_0x003d:
            if (r0 == 0) goto L_0x006e
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r0 = r7.playerService()
            if (r0 == 0) goto L_0x0059
            r4 = 0
            boolean r5 = r0.isAirPlayWorking()
            if (r5 != 0) goto L_0x0055
            boolean r5 = r0.isAirPlayLayerShowing()
            if (r5 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r0 = r2
            goto L_0x0056
        L_0x0055:
            r0 = r3
        L_0x0056:
            if (r0 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r3 = r2
        L_0x005a:
            if (r3 == 0) goto L_0x006e
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x006e
            com.baidu.searchbox.video.feedflow.flow.guidemanager.ProgressGuideShow r3 = new com.baidu.searchbox.video.feedflow.flow.guidemanager.ProgressGuideShow
            r4 = 53
            r3.<init>(r4)
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r3)
        L_0x006e:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x008b
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0080
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0081
        L_0x0080:
            r4 = r1
        L_0x0081:
            if (r4 == 0) goto L_0x0089
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState> r1 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState.class
            java.lang.Object r1 = r4.select(r1)
        L_0x0089:
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState r1 = (com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState) r1
        L_0x008b:
            if (r1 != 0) goto L_0x008e
            goto L_0x0091
        L_0x008e:
            r1.setSearching(r2)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin.m10580onAttachToManager$lambda8$lambda6(com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin, kotlin.Unit):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: onAttachToManager$lambda-8$lambda-7  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m10581onAttachToManager$lambda8$lambda7(com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin r5, kotlin.Unit r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0024
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0019
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x001a
        L_0x0019:
            r3 = r1
        L_0x001a:
            if (r3 == 0) goto L_0x0022
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState> r1 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x0022:
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState r1 = (com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState) r1
        L_0x0024:
            if (r1 != 0) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            r0 = 0
            r1.setGuideShowing(r0)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin.m10581onAttachToManager$lambda8$lambda7(com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin, kotlin.Unit):void");
    }

    private final void registerGuide() {
        GuidePriorityService guidePriorityService = (GuidePriorityService) getManager().getService(GuidePriorityService.class);
        if (guidePriorityService != null) {
            GuidePriorityService.DefaultImpls.registerGuide$default(guidePriorityService, new AirPlayFindGuidePlugin$registerGuide$1(this), new AirPlayFindGuidePlugin$registerGuide$2(this), new AirPlayFindGuidePlugin$registerGuide$3(this), 53, true, GuideType.BUSINESS, false, 64, (Object) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showGuide() {
        /*
            r11 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            if (r0 == 0) goto L_0x003d
            com.baidu.searchbox.video.feedflow.detail.toast.ShowTipAction r10 = new com.baidu.searchbox.video.feedflow.detail.toast.ShowTipAction
            android.content.Context r1 = r11.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_airplay_find_toast_title
            java.lang.String r1 = r1.getString(r2)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            android.content.Context r1 = r11.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_airplay_find_toast_btn_text
            java.lang.String r1 = r1.getString(r3)
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r5 = 12
            r6 = 7000(0x1b58, double:3.4585E-320)
            com.baidu.searchbox.video.feedflow.detail.toast.TipLocation r8 = com.baidu.searchbox.video.feedflow.detail.toast.TipLocation.BOTTOM
            r9 = 1
            java.lang.String r4 = "airplay_find_toast_key"
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r8, r9)
            com.baidu.searchbox.feed.detail.frame.Action r10 = (com.baidu.searchbox.feed.detail.frame.Action) r10
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r10)
        L_0x003d:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            if (r0 == 0) goto L_0x004a
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideBtnShow r1 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideBtnShow.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x004a:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0068
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x005d
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x005e
        L_0x005d:
            r3 = r1
        L_0x005e:
            if (r3 == 0) goto L_0x0066
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState> r1 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x0066:
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState r1 = (com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState) r1
        L_0x0068:
            if (r1 != 0) goto L_0x006b
            goto L_0x006f
        L_0x006b:
            r0 = 1
            r1.setGuideShowing(r0)
        L_0x006f:
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideHelper r0 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideHelper.INSTANCE
            r0.onGuideShow()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin.showGuide():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r5.isGuideShowing() == true) goto L_0x002c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void hideGuide() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x002b
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0015
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0016
        L_0x0015:
            r5 = r3
        L_0x0016:
            if (r5 == 0) goto L_0x001f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState> r6 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0020
        L_0x001f:
            r5 = r3
        L_0x0020:
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState r5 = (com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState) r5
            if (r5 == 0) goto L_0x002b
            boolean r0 = r5.isGuideShowing()
            if (r0 != r1) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            if (r1 == 0) goto L_0x005e
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x004b
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0040
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0041
        L_0x0040:
            r4 = r3
        L_0x0041:
            if (r4 == 0) goto L_0x0049
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState> r3 = com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState.class
            java.lang.Object r3 = r4.select(r3)
        L_0x0049:
            com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState r3 = (com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuideState) r3
        L_0x004b:
            if (r3 != 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            r3.setGuideShowing(r2)
        L_0x0051:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x005e
            com.baidu.searchbox.video.feedflow.detail.toast.HideTipAction r1 = com.baidu.searchbox.video.feedflow.detail.toast.HideTipAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.airplayguide.AirPlayFindGuidePlugin.hideGuide():void");
    }

    private final void removePlayerListener() {
        IPlayerComponentService playerService = playerService();
        if (playerService != null) {
            playerService.removePlayerComponentListener(this.playerListener);
        }
    }

    /* access modifiers changed from: private */
    public final boolean frequencyControlCanShow() {
        return AirPlayFindGuideHelper.INSTANCE.canShowGuide();
    }

    private final IPlayerComponentService playerService() {
        return (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
    }

    private final int getDurationLimit() {
        AirPlayOptSwitchConfig airPlayOptSwitchConfig = FlowSwitchStateKt.flowSwitchState((Store<?>) getStore()).getAirPlayOptSwitchConfig();
        return BdPlayerUtils.orZero(airPlayOptSwitchConfig != null ? Integer.valueOf(airPlayOptSwitchConfig.getAirPlayAutoFindVideoDurationLimit()) : null);
    }

    private final boolean getFindTipGuideSwitch() {
        AirPlayOptSwitchConfig airPlayOptSwitchConfig = FlowSwitchStateKt.flowSwitchState((Store<?>) getStore()).getAirPlayOptSwitchConfig();
        return BdPlayerUtils.orFalse(airPlayOptSwitchConfig != null ? Boolean.valueOf(airPlayOptSwitchConfig.getAirPlayAutoFindSwitch()) : null);
    }

    public void onDestroy() {
        super.onDestroy();
        removePlayerListener();
    }
}
