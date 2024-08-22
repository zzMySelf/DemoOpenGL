package com.baidu.searchbox.video.feedflow.ad.moveup;

import android.animation.ValueAnimator;
import androidx.lifecycle.MutableLiveData;
import com.baidu.nadcore.business.webpanel.IPanelPopupWindowScroll;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.video.component.comment.service.ICommentDragService;
import com.baidu.searchbox.video.component.comment.service.ICommentViewService;
import com.baidu.searchbox.video.detail.utils.NumberUtilsKt;
import com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpAnimationPlugin$dragListener$2;
import com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpAnimationPlugin$popUpDragListener$2;
import com.baidu.searchbox.video.feedflow.detail.moveup.IPanelMoveUpService;
import com.baidu.searchbox.video.feedflow.detail.moveup.PanelMoveUpListener;
import com.baidu.searchbox.video.service.PageContainerService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0006\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fJ\u000f\u0010 \u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\fJ\r\u0010$\u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\b\u0010%\u001a\u00020\u001dH\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010&\u001a\u00020\u001dH\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u000e\u00100\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001a¨\u00061"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "curProgress", "", "dragListener", "com/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin$dragListener$2$1", "getDragListener", "()Lcom/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin$dragListener$2$1;", "dragListener$delegate", "Lkotlin/Lazy;", "isPanelShowing", "", "moveUpListenerSet", "", "Lcom/baidu/searchbox/video/feedflow/detail/moveup/PanelMoveUpListener;", "panelType", "Lcom/baidu/searchbox/video/feedflow/ad/moveup/PanelType;", "popUpDragListener", "com/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin$popUpDragListener$2$1", "getPopUpDragListener", "()Lcom/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin$popUpDragListener$2$1;", "popUpDragListener$delegate", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "progressAnimator$delegate", "addInnerListener", "", "addMoveUplListener", "listener", "calculatePanelHeight", "", "()Ljava/lang/Integer;", "canVideoMoveUp", "getPanelHeight", "injectService", "onAttachToManager", "onDestroy", "onNestedAction", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "onPanelHide", "onPanelShow", "onProgressChanged", "showProgress", "removeInnerListener", "removeMoveUpListener", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadMoveUpAnimationPlugin.kt */
public final class NadMoveUpAnimationPlugin extends LiveDataPlugin {
    private float curProgress;
    private final Lazy dragListener$delegate = LazyKt.lazy(new NadMoveUpAnimationPlugin$dragListener$2(this));
    private boolean isPanelShowing;
    private final List<PanelMoveUpListener> moveUpListenerSet = new ArrayList();
    private PanelType panelType = PanelType.PANEL_HIDE;
    private final Lazy popUpDragListener$delegate = LazyKt.lazy(new NadMoveUpAnimationPlugin$popUpDragListener$2(this));
    private final Lazy progressAnimator$delegate = LazyKt.lazy(new NadMoveUpAnimationPlugin$progressAnimator$2(this));

    private final NadMoveUpAnimationPlugin$popUpDragListener$2.AnonymousClass1 getPopUpDragListener() {
        return (NadMoveUpAnimationPlugin$popUpDragListener$2.AnonymousClass1) this.popUpDragListener$delegate.getValue();
    }

    private final NadMoveUpAnimationPlugin$dragListener$2.AnonymousClass1 getDragListener() {
        return (NadMoveUpAnimationPlugin$dragListener$2.AnonymousClass1) this.dragListener$delegate.getValue();
    }

    private final ValueAnimator getProgressAnimator() {
        Object value = this.progressAnimator$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-progressAnimator>(...)");
        return (ValueAnimator) value;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean canVideoMoveUp() {
        /*
            r7 = this;
            com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager r0 = com.baidu.searchbox.video.feedflow.ad.AdReduxExpManager.INSTANCE
            boolean r0 = r0.getAdVideoMoveUpSwitch()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0036
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x0032
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x001d
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001e
        L_0x001d:
            r4 = r6
        L_0x001e:
            if (r4 == 0) goto L_0x0026
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState> r5 = com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x0026:
            com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState r6 = (com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState) r6
            if (r6 == 0) goto L_0x0032
            boolean r0 = r6.isFullScreen()
            if (r0 != 0) goto L_0x0032
            r0 = r1
            goto L_0x0033
        L_0x0032:
            r0 = r2
        L_0x0033:
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpAnimationPlugin.canVideoMoveUp():boolean");
    }

    public void onAttachToManager() {
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        NadMoveUpState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d2 = (NadMoveUpState) store.subscribe((Class<T>) NadMoveUpState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d2.getWindow().observe(this, new NadMoveUpAnimationPlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d2.isStart().observe(this, new NadMoveUpAnimationPlugin$$ExternalSyntheticLambda1(this));
        }
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && (coreState = (CoreState) $this$subscribe$iv.subscribe(CoreState.class)) != null && (nestedAction = coreState.getNestedAction()) != null) {
            nestedAction.observe(this, new NadMoveUpAnimationPlugin$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-0  reason: not valid java name */
    public static final void m5608onAttachToManager$lambda2$lambda0(NadMoveUpAnimationPlugin this$0, IPanelPopupWindowScroll popUp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (popUp != null) {
            popUp.setScrollListener(this$0.getPopUpDragListener());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    public static final void m5609onAttachToManager$lambda2$lambda1(NadMoveUpAnimationPlugin this$0, PanelType isPanelShown) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isPanelShown != PanelType.PANEL_HIDE) {
            Intrinsics.checkNotNullExpressionValue(isPanelShown, "isPanelShown");
            this$0.panelType = isPanelShown;
            this$0.onPanelShow();
            return;
        }
        this$0.panelType = PanelType.PANEL_HIDE;
        this$0.onPanelHide();
    }

    /* access modifiers changed from: private */
    public final void onNestedAction(NestedAction action) {
        if ((action instanceof NestedAction.OnDetachFromScreen) && this.isPanelShowing) {
            getProgressAnimator().cancel();
            onProgressChanged(0.0f);
            this.isPanelShowing = false;
        }
    }

    public final void addMoveUplListener(PanelMoveUpListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.moveUpListenerSet.add(listener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r5 = this;
            super.onDestroy()
            java.util.List<com.baidu.searchbox.video.feedflow.detail.moveup.PanelMoveUpListener> r0 = r5.moveUpListenerSet
            r0.clear()
            r5.removeInnerListener()
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0032
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x001e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            if (r3 == 0) goto L_0x0028
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState> r4 = com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0029
        L_0x0028:
            r3 = r1
        L_0x0029:
            com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState r3 = (com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState) r3
            if (r3 == 0) goto L_0x0032
            androidx.lifecycle.MutableLiveData r0 = r3.getWindow()
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            if (r0 != 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            r0.setValue(r1)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpAnimationPlugin.onDestroy():void");
    }

    private final void onPanelShow() {
        removeInnerListener();
        if (canVideoMoveUp()) {
            addInnerListener();
            for (PanelMoveUpListener panelMoveUpListener : this.moveUpListenerSet) {
                panelMoveUpListener.onPanelShown();
            }
            getProgressAnimator().cancel();
            getProgressAnimator().setFloatValues(new float[]{1.0f});
            getProgressAnimator().setDuration(240);
            getProgressAnimator().start();
            this.isPanelShowing = true;
        }
    }

    private final void onPanelHide() {
        if (canVideoMoveUp() && this.isPanelShowing) {
            for (PanelMoveUpListener panelMoveUpListener : this.moveUpListenerSet) {
                panelMoveUpListener.onPanelHidden();
            }
            getProgressAnimator().cancel();
            getProgressAnimator().setFloatValues(new float[]{this.curProgress, 0.0f});
            getProgressAnimator().setDuration((long) NumberUtilsKt.rangeLimit(((float) 240) * this.curProgress, 48.0f, 240.0f));
            getProgressAnimator().start();
            this.isPanelShowing = false;
        }
    }

    public final void removeMoveUpListener(PanelMoveUpListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.moveUpListenerSet.remove(listener);
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(ICommentViewService.class, new NadCommentViewServiceImpl(this));
        getManager().registerServices(IPanelMoveUpService.class, new NadPanelMoveUpService(this));
        getManager().registerServices(INadPanelSizeService.class, new NadPanelSizeServiceImpl(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer getPanelHeight() {
        /*
            r7 = this;
            boolean r0 = r7.canVideoMoveUp()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            com.baidu.searchbox.video.feedflow.ad.moveup.PanelType r0 = r7.panelType
            com.baidu.searchbox.video.feedflow.ad.moveup.PanelType r2 = com.baidu.searchbox.video.feedflow.ad.moveup.PanelType.PANEL_ECOMMERCE
            if (r0 == r2) goto L_0x0014
            com.baidu.searchbox.video.feedflow.ad.moveup.PanelType r0 = r7.panelType
            com.baidu.searchbox.video.feedflow.ad.moveup.PanelType r2 = com.baidu.searchbox.video.feedflow.ad.moveup.PanelType.DAZZLE
            if (r0 != r2) goto L_0x007d
        L_0x0014:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x0042
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0026
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            if (r3 == 0) goto L_0x0030
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState> r4 = com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0031
        L_0x0030:
            r3 = r1
        L_0x0031:
            com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState r3 = (com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState) r3
            if (r3 == 0) goto L_0x0042
            androidx.lifecycle.MutableLiveData r0 = r3.getWindow()
            if (r0 == 0) goto L_0x0042
            java.lang.Object r0 = r0.getValue()
            com.baidu.nadcore.business.webpanel.IPanelPopupWindowScroll r0 = (com.baidu.nadcore.business.webpanel.IPanelPopupWindowScroll) r0
            goto L_0x0043
        L_0x0042:
            r0 = r1
        L_0x0043:
            if (r0 == 0) goto L_0x007d
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x007c
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0057
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0058
        L_0x0057:
            r3 = r1
        L_0x0058:
            if (r3 == 0) goto L_0x0061
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState> r4 = com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0062
        L_0x0061:
            r3 = r1
        L_0x0062:
            com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState r3 = (com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpState) r3
            if (r3 == 0) goto L_0x007c
            androidx.lifecycle.MutableLiveData r0 = r3.getWindow()
            if (r0 == 0) goto L_0x007c
            java.lang.Object r0 = r0.getValue()
            com.baidu.nadcore.business.webpanel.IPanelPopupWindowScroll r0 = (com.baidu.nadcore.business.webpanel.IPanelPopupWindowScroll) r0
            if (r0 == 0) goto L_0x007c
            int r0 = r0.getPanelHeight()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
        L_0x007c:
            return r1
        L_0x007d:
            com.baidu.searchbox.video.feedflow.ad.moveup.PanelType r0 = r7.panelType
            com.baidu.searchbox.video.feedflow.ad.moveup.PanelType r2 = com.baidu.searchbox.video.feedflow.ad.moveup.PanelType.PANEL_COMMENT
            if (r0 != r2) goto L_0x00f1
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x00f1
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0095
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0096
        L_0x0095:
            r3 = r1
        L_0x0096:
            if (r3 == 0) goto L_0x009f
            java.lang.Class<com.baidu.searchbox.video.feedflow.config.AbConfig> r4 = com.baidu.searchbox.video.feedflow.config.AbConfig.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x00a0
        L_0x009f:
            r3 = r1
        L_0x00a0:
            com.baidu.searchbox.video.feedflow.config.AbConfig r3 = (com.baidu.searchbox.video.feedflow.config.AbConfig) r3
            if (r3 == 0) goto L_0x00f1
            java.lang.Float r0 = r3.getCommentPanelCompressRatio()
            if (r0 == 0) goto L_0x00f1
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r2 = 0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r3 = r7.getManager()
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.service.PageContainerService> r5 = com.baidu.searchbox.video.service.PageContainerService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r3 = r3.getService(r5)
            com.baidu.searchbox.video.service.PageContainerService r3 = (com.baidu.searchbox.video.service.PageContainerService) r3
            if (r3 == 0) goto L_0x00ee
            android.view.ViewGroup r3 = r3.getPageContainerPortrait()
            if (r3 == 0) goto L_0x00ee
            r4 = 0
            int r5 = r3.getVisibility()
            if (r5 != 0) goto L_0x00ed
            int r5 = r3.getHeight()
            if (r5 == 0) goto L_0x00ed
            int r5 = r3.getWidth()
            if (r5 != 0) goto L_0x00da
            goto L_0x00ed
        L_0x00da:
            com.baidu.searchbox.video.feedflow.common.PanelSizeConfig r1 = com.baidu.searchbox.video.feedflow.common.PanelSizeConfig.INSTANCE
            android.content.Context r5 = r7.getContext()
            java.lang.Float r6 = java.lang.Float.valueOf(r0)
            int r1 = r1.getPanelHeightVideoMoveUp(r5, r6)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            return r1
        L_0x00ed:
            return r1
        L_0x00ee:
            java.lang.Void r1 = (java.lang.Void) r1
        L_0x00f1:
            java.lang.Integer r0 = r7.calculatePanelHeight()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.moveup.NadMoveUpAnimationPlugin.getPanelHeight():java.lang.Integer");
    }

    public final boolean isPanelShowing() {
        return this.isPanelShowing;
    }

    private final Integer calculatePanelHeight() {
        PageContainerService pageContainerService = (PageContainerService) getManager().getService(PageContainerService.class);
        if (pageContainerService != null) {
            return pageContainerService.getPortraitAvailablePanelHeight();
        }
        return null;
    }

    private final void addInnerListener() {
        ICommentDragService iCommentDragService = (ICommentDragService) getManager().getService(ICommentDragService.class);
        if (iCommentDragService != null) {
            iCommentDragService.addPullListener(getDragListener());
        }
    }

    private final void removeInnerListener() {
        ICommentDragService iCommentDragService = (ICommentDragService) getManager().getService(ICommentDragService.class);
        if (iCommentDragService != null) {
            iCommentDragService.removePullListener(getDragListener());
        }
    }

    /* access modifiers changed from: private */
    public final void onProgressChanged(float showProgress) {
        float progressLimit = NumberUtilsKt.rangeLimit(showProgress, 0.0f, 1.0f);
        float f2 = this.curProgress;
        boolean z = true;
        if (!(f2 == 0.0f)) {
            if (f2 != progressLimit) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        this.curProgress = progressLimit;
        for (PanelMoveUpListener panelMoveUpListener : this.moveUpListenerSet) {
            panelMoveUpListener.onPanelMoveUpProgressChanged(this.curProgress);
        }
    }
}
