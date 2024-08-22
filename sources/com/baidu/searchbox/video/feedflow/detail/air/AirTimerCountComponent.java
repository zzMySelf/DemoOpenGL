package com.baidu.searchbox.video.feedflow.detail.air;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/air/AirTimerCountComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "containerView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContainerView", "()Landroid/view/View;", "containerView$delegate", "Lkotlin/Lazy;", "delayedRunnable", "com/baidu/searchbox/video/feedflow/detail/air/AirTimerCountComponent$delayedRunnable$1", "Lcom/baidu/searchbox/video/feedflow/detail/air/AirTimerCountComponent$delayedRunnable$1;", "timerCount", "", "timerCountView", "Landroid/widget/TextView;", "createView", "getPlayerService", "Lcom/baidu/searchbox/video/feedflow/detail/player/service/IPlayerComponentService;", "isSelected", "", "onAttachToManager", "", "onDestroy", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "onPause", "onResume", "removeTask", "resumeTask", "setActive", "isActive", "tryResumeTask", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AirTimerCountComponent.kt */
public class AirTimerCountComponent extends LiveDataComponent {
    private final Lazy containerView$delegate = LazyKt.lazy(new AirTimerCountComponent$containerView$2(this));
    private final AirTimerCountComponent$delayedRunnable$1 delayedRunnable = new AirTimerCountComponent$delayedRunnable$1(this);
    /* access modifiers changed from: private */
    public int timerCount = -1;
    /* access modifiers changed from: private */
    public TextView timerCountView;

    /* access modifiers changed from: private */
    public final View getContainerView() {
        return (View) this.containerView$delegate.getValue();
    }

    public View createView() {
        View containerView = getContainerView();
        Intrinsics.checkNotNullExpressionValue(containerView, "containerView");
        return containerView;
    }

    public void onAttachToManager() {
        AirTimerCountState $this$onAttachToManager_u24lambda_u2d6;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || (coreState = (CoreState) $this$subscribe$iv.subscribe(CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new AirTimerCountComponent$$ExternalSyntheticLambda0(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && ($this$onAttachToManager_u24lambda_u2d6 = (AirTimerCountState) $this$subscribe$iv2.subscribe(AirTimerCountState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d6.getStartTask().observe(this, new AirTimerCountComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d6.getPageResume().observe(this, new AirTimerCountComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d6.getRemoveTask().observe(this, new AirTimerCountComponent$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d6.getHideView().observe(this, new AirTimerCountComponent$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-0  reason: not valid java name */
    public static final void m10568onAttachToManager$lambda0(AirTimerCountComponent this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(nestedAction, "nestedAction");
        this$0.onNestedAction(nestedAction);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-2  reason: not valid java name */
    public static final void m10569onAttachToManager$lambda6$lambda2(AirTimerCountComponent this$0, Unit it) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPlayerComponentService $this$onAttachToManager_u24lambda_u2d6_u24lambda_u2d2_u24lambda_u2d1 = this$0.getPlayerService();
        if ($this$onAttachToManager_u24lambda_u2d6_u24lambda_u2d2_u24lambda_u2d1 != null) {
            bool = Boolean.valueOf(($this$onAttachToManager_u24lambda_u2d6_u24lambda_u2d2_u24lambda_u2d1.isAirPlayWorking() || $this$onAttachToManager_u24lambda_u2d6_u24lambda_u2d2_u24lambda_u2d1.isAirPlayLayerShowing()) && !$this$onAttachToManager_u24lambda_u2d6_u24lambda_u2d2_u24lambda_u2d1.isAirPlayingVid());
        } else {
            bool = null;
        }
        if (BdPlayerUtils.orFalse(bool)) {
            this$0.resumeTask();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-3  reason: not valid java name */
    public static final void m10570onAttachToManager$lambda6$lambda3(AirTimerCountComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tryResumeTask();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-4  reason: not valid java name */
    public static final void m10571onAttachToManager$lambda6$lambda4(AirTimerCountComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeTask();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-5  reason: not valid java name */
    public static final void m10572onAttachToManager$lambda6$lambda5(AirTimerCountComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View containerView = this$0.getContainerView();
        if (containerView != null) {
            containerView.setVisibility(8);
        }
    }

    private final void onNestedAction(NestedAction nestedAction) {
        if (nestedAction instanceof NestedAction.OnBindData) {
            removeTask();
        } else if (nestedAction instanceof NestedAction.OnDetachFromScreen) {
            removeTask();
        } else if (nestedAction instanceof NestedAction.OnPageSelected) {
            tryResumeTask();
        }
    }

    /* access modifiers changed from: private */
    public final void removeTask() {
        this.timerCount = -1;
        View containerView = getContainerView();
        if (containerView != null) {
            containerView.setVisibility(8);
        }
        getContainerView().removeCallbacks(this.delayedRunnable);
        Store<AbsState> store = getStore();
        if (store != null) {
            StoreExtKt.post(store, AirTimerCountCancel.INSTANCE);
        }
    }

    public void onPause() {
        super.onPause();
        removeTask();
    }

    public void onResume() {
        super.onResume();
        tryResumeTask();
    }

    private final void tryResumeTask() {
        IPlayerComponentService $this$tryResumeTask_u24lambda_u2d7 = getPlayerService();
        if ($this$tryResumeTask_u24lambda_u2d7 != null && $this$tryResumeTask_u24lambda_u2d7.isAirPlayWorking() && !$this$tryResumeTask_u24lambda_u2d7.isAirPlayingVid() && isSelected()) {
            if ($this$tryResumeTask_u24lambda_u2d7.isPlayerPlaying() || $this$tryResumeTask_u24lambda_u2d7.isPlayerPause()) {
                resumeTask();
            }
        }
    }

    private final IPlayerComponentService getPlayerService() {
        return (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
    }

    public boolean isSelected() {
        Store<AbsState> store = getStore();
        CommonState commonState = null;
        State state = store != null ? (AbsState) store.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        if (commonState != null) {
            return commonState.isActive();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009a, code lost:
        if (r1.isFullScreen() == true) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void resumeTask() {
        /*
            r8 = this;
            boolean r0 = com.baidu.searchbox.player.helper.NetUtils.isNetDown()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x002e
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x001a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x001b
        L_0x001a:
            r3 = r1
        L_0x001b:
            if (r3 == 0) goto L_0x0024
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r4 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0025
        L_0x0024:
            r3 = r1
        L_0x0025:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            if (r3 == 0) goto L_0x002e
            java.lang.Object r0 = r3.getData()
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            boolean r2 = r0 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel
            if (r2 == 0) goto L_0x0036
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r0 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r0
            goto L_0x0037
        L_0x0036:
            r0 = r1
        L_0x0037:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0043
            boolean r0 = r0.isPayTypeAndLocked()
            if (r0 != r2) goto L_0x0043
            r0 = r2
            goto L_0x0044
        L_0x0043:
            r0 = r3
        L_0x0044:
            if (r0 == 0) goto L_0x0047
            return
        L_0x0047:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            boolean r0 = com.baidu.searchbox.video.feedflow.detail.air.AirPlaySwitchExtKt.airPlaySeamlessSwitch((com.baidu.searchbox.feed.detail.frame.Store<?>) r0)
            if (r0 == 0) goto L_0x005f
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            if (r0 == 0) goto L_0x005e
            com.baidu.searchbox.video.feedflow.detail.air.AirPlayCurrentVideo r1 = com.baidu.searchbox.video.feedflow.detail.air.AirPlayCurrentVideo.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x005e:
            return
        L_0x005f:
            r0 = 3
            r8.timerCount = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r4 = r8.timerCount
            java.lang.StringBuilder r0 = r0.append(r4)
            r4 = 115(0x73, float:1.61E-43)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            if (r4 == 0) goto L_0x009d
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0089
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x008a
        L_0x0089:
            r6 = r1
        L_0x008a:
            if (r6 == 0) goto L_0x0092
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState> r1 = com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState.class
            java.lang.Object r1 = r6.select(r1)
        L_0x0092:
            com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState r1 = (com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState) r1
            if (r1 == 0) goto L_0x009d
            boolean r1 = r1.isFullScreen()
            if (r1 != r2) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r2 = r3
        L_0x009e:
            if (r2 != 0) goto L_0x00b5
            android.view.View r1 = r8.getContainerView()
            if (r1 != 0) goto L_0x00a7
            goto L_0x00aa
        L_0x00a7:
            r1.setVisibility(r3)
        L_0x00aa:
            android.widget.TextView r1 = r8.timerCountView
            if (r1 != 0) goto L_0x00af
            goto L_0x00b5
        L_0x00af:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x00b5:
            android.view.View r1 = r8.getContainerView()
            com.baidu.searchbox.video.feedflow.detail.air.AirTimerCountComponent$delayedRunnable$1 r2 = r8.delayedRunnable
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.removeCallbacks(r2)
            android.view.View r1 = r8.getContainerView()
            com.baidu.searchbox.video.feedflow.detail.air.AirTimerCountComponent$delayedRunnable$1 r2 = r8.delayedRunnable
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r3 = 1000(0x3e8, double:4.94E-321)
            r1.postDelayed(r2, r3)
            com.baidu.searchbox.feed.detail.frame.Store r1 = r8.getStore()
            if (r1 == 0) goto L_0x00dd
            com.baidu.searchbox.video.feedflow.detail.air.AirTimerCountDown r2 = new com.baidu.searchbox.video.feedflow.detail.air.AirTimerCountDown
            r2.<init>(r0)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.air.AirTimerCountComponent.resumeTask():void");
    }

    public void onDestroy() {
        removeTask();
        super.onDestroy();
    }

    public void setActive(boolean isActive) {
        if (!isActive) {
            removeTask();
        } else {
            tryResumeTask();
        }
    }
}
