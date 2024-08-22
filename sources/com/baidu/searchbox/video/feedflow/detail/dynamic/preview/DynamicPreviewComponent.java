package com.baidu.searchbox.video.feedflow.detail.dynamic.preview;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.detail.utils.ViewUtilsKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.CarouselProgressBarView;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.IDynamicSeekBarChangeListener;
import com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewComponent$singleSeekBarListener$2;
import com.baidu.searchbox.video.feedflow.detail.dynamic.preview.service.DynamicPreviewService;
import com.baidu.searchbox.video.feedflow.detail.dynamic.preview.service.IDynamicPreviewService;
import com.baidu.searchbox.video.feedflow.detail.seekbar.ISeekBarService;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import com.baidu.searchbox.video.feedflow.utils.VideoHomeTabUtilsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0015\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u001cH\u0016J\u0010\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\u0010J\b\u0010)\u001a\u00020\u001cH\u0016J(\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010!\u001a\u00020-2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\u0006\u00105\u001a\u00020\u001cJ\b\u00106\u001a\u00020\u001cH\u0002J\u0010\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001eH\u0002J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001eH\u0002J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001eH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/DynamicPreviewComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/dynamic/carouselprogressbar/IDynamicSeekBarChangeListener;", "()V", "maskView", "Landroid/widget/FrameLayout;", "getMaskView", "()Landroid/widget/FrameLayout;", "maskView$delegate", "Lkotlin/Lazy;", "previewContainer", "Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/DynamicPreviewView;", "getPreviewContainer", "()Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/DynamicPreviewView;", "previewContainer$delegate", "rootView", "Landroid/widget/RelativeLayout;", "getRootView", "()Landroid/widget/RelativeLayout;", "rootView$delegate", "singleSeekBarListener", "com/baidu/searchbox/video/feedflow/detail/dynamic/preview/DynamicPreviewComponent$singleSeekBarListener$2$1", "getSingleSeekBarListener", "()Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/DynamicPreviewComponent$singleSeekBarListener$2$1;", "singleSeekBarListener$delegate", "createView", "Landroid/view/View;", "handleClickedMaskView", "", "isShowPreview", "", "handleProgressChanged", "fromUser", "progress", "", "initClickedMaskView", "initContainer", "initRootView", "injectService", "moveView", "viewGroup", "onAttachToManager", "onDragProgressChanged", "seekBar", "Lcom/baidu/searchbox/video/feedflow/detail/dynamic/carouselprogressbar/CarouselProgressBarView;", "", "lastIndex", "event", "Landroid/view/MotionEvent;", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "registerSingleSeekBarListener", "returnView", "unRegisterSingleSeekBarListener", "updateComponentContainerLayoutRule", "isSingle", "updateMaskBackground", "isSingleStyle", "updateSeekBarStyle", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicPreviewComponent.kt */
public final class DynamicPreviewComponent extends LiveDataComponent implements IDynamicSeekBarChangeListener {
    private final Lazy maskView$delegate = BdPlayerUtils.lazyNone(new DynamicPreviewComponent$maskView$2(this));
    private final Lazy previewContainer$delegate = BdPlayerUtils.lazyNone(new DynamicPreviewComponent$previewContainer$2(this));
    private final Lazy rootView$delegate = BdPlayerUtils.lazyNone(new DynamicPreviewComponent$rootView$2(this));
    private final Lazy singleSeekBarListener$delegate = BdPlayerUtils.lazyNone(new DynamicPreviewComponent$singleSeekBarListener$2(this));

    public void onStartTrackingTouch(CarouselProgressBarView seekBar) {
        IDynamicSeekBarChangeListener.DefaultImpls.onStartTrackingTouch(this, seekBar);
    }

    public void onStopTrackingTouch(CarouselProgressBarView seekBar) {
        IDynamicSeekBarChangeListener.DefaultImpls.onStopTrackingTouch(this, seekBar);
    }

    private final DynamicPreviewView getPreviewContainer() {
        return (DynamicPreviewView) this.previewContainer$delegate.getValue();
    }

    private final RelativeLayout getRootView() {
        return (RelativeLayout) this.rootView$delegate.getValue();
    }

    private final FrameLayout getMaskView() {
        return (FrameLayout) this.maskView$delegate.getValue();
    }

    private final DynamicPreviewComponent$singleSeekBarListener$2.AnonymousClass1 getSingleSeekBarListener() {
        return (DynamicPreviewComponent$singleSeekBarListener$2.AnonymousClass1) this.singleSeekBarListener$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DynamicPreviewView initContainer() {
        DynamicPreviewView $this$initContainer_u24lambda_u2d0 = new DynamicPreviewView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$initContainer_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$initContainer_u24lambda_u2d0.setVisibility(8);
        $this$initContainer_u24lambda_u2d0.setIDynamicPreviewListener(new DynamicPreviewComponent$initContainer$1$1(this));
        return $this$initContainer_u24lambda_u2d0;
    }

    public View createView() {
        return getRootView();
    }

    /* access modifiers changed from: private */
    public final RelativeLayout initRootView() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout $this$initRootView_u24lambda_u2d1 = relativeLayout;
        $this$initRootView_u24lambda_u2d1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        ViewUtilsKt.addViewToParent(getPreviewContainer(), $this$initRootView_u24lambda_u2d1);
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public final FrameLayout initClickedMaskView() {
        Window window;
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout $this$initClickedMaskView_u24lambda_u2d3 = frameLayout;
        $this$initClickedMaskView_u24lambda_u2d3.setClickable(true);
        $this$initClickedMaskView_u24lambda_u2d3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Store<AbsState> store = getStore();
        View firstChildView = null;
        if (VideoBizUtilsKt.isFromChannelFlow(UBCManifestKt.getPage(store != null ? store.getState() : null))) {
            View view2 = new View($this$initClickedMaskView_u24lambda_u2d3.getContext());
            View $this$initClickedMaskView_u24lambda_u2d3_u24lambda_u2d2 = view2;
            $this$initClickedMaskView_u24lambda_u2d3_u24lambda_u2d2.setId(R.id.video_flow_dynamic_preview_bottom_mask);
            Context context = $this$initClickedMaskView_u24lambda_u2d3_u24lambda_u2d2.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            ViewGroup decorView2 = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (decorView2 != null) {
                firstChildView = decorView2.getChildAt(0);
            }
            int height = VideoHomeTabUtilsKt.getHomeTabHeight();
            if (firstChildView != null) {
                height += BdPlayerUtils.orZero(Integer.valueOf(decorView2.getHeight())) - BdPlayerUtils.orZero(Integer.valueOf(firstChildView.getBottom()));
            }
            FrameLayout.LayoutParams viewLayoutParams = new FrameLayout.LayoutParams(-1, height);
            viewLayoutParams.gravity = 80;
            $this$initClickedMaskView_u24lambda_u2d3_u24lambda_u2d2.setLayoutParams(viewLayoutParams);
            $this$initClickedMaskView_u24lambda_u2d3_u24lambda_u2d2.setBackgroundColor(ContextCompat.getColor($this$initClickedMaskView_u24lambda_u2d3_u24lambda_u2d2.getContext(), R.color.video_flow_color_black));
            $this$initClickedMaskView_u24lambda_u2d3.addView(view2);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            $this$initClickedMaskView_u24lambda_u2d3.setTranslationZ(1.0f);
        }
        return frameLayout;
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(IDynamicPreviewService.class, new DynamicPreviewService(this));
    }

    public final void moveView(RelativeLayout viewGroup) {
        if (viewGroup != null) {
            ViewUtilsKt.addViewToParent(getPreviewContainer(), viewGroup);
        }
    }

    public final void returnView() {
        if (!Intrinsics.areEqual((Object) getPreviewContainer().getParent(), (Object) getRootView())) {
            ViewUtilsKt.addViewToParent(getPreviewContainer(), getRootView());
        }
    }

    public void onAttachToManager() {
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        DynamicPreviewState $this$onAttachToManager_u24lambda_u2d6;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d6 = (DynamicPreviewState) $this$subscribe$iv.subscribe(DynamicPreviewState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d6.getShow().observe(this, new DynamicPreviewComponent$$ExternalSyntheticLambda0($this$onAttachToManager_u24lambda_u2d6, this));
            $this$onAttachToManager_u24lambda_u2d6.getSingleImageDurationMs().observe(this, new DynamicPreviewComponent$$ExternalSyntheticLambda1(this));
        }
        Store<AbsState> store = getStore();
        if (store != null && (coreState = (CoreState) store.subscribe((Class<T>) CoreState.class)) != null && (nestedAction = coreState.getNestedAction()) != null) {
            nestedAction.observe(this, new DynamicPreviewComponent$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        if ((r0 != null && r0.isInClearScreen()) == false) goto L_0x0046;
     */
    /* renamed from: onAttachToManager$lambda-6$lambda-4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m11300onAttachToManager$lambda6$lambda4(com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewState r10, com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewComponent r11, java.lang.Boolean r12) {
        /*
            java.lang.String r0 = "$this_run"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "isShowPreview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            boolean r0 = r12.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0080
            java.util.List r0 = r10.getModel()
            r2 = 1
            if (r0 == 0) goto L_0x0027
            int r0 = r0.size()
            if (r0 != r2) goto L_0x0027
            r0 = r2
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x0045
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r11.getManager()
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.clearscreen.service.IClearScreenPluginService> r4 = com.baidu.searchbox.video.feedflow.clearscreen.service.IClearScreenPluginService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r4)
            com.baidu.searchbox.video.feedflow.clearscreen.service.IClearScreenPluginService r0 = (com.baidu.searchbox.video.feedflow.clearscreen.service.IClearScreenPluginService) r0
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.isInClearScreen()
            if (r0 != r2) goto L_0x0041
            r0 = r2
            goto L_0x0042
        L_0x0041:
            r0 = r1
        L_0x0042:
            if (r0 != 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r2 = r1
        L_0x0046:
            r0 = r2
            com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewView r2 = r11.getPreviewContainer()
            java.util.List r3 = r10.getModel()
            r2.bindData(r3, r0)
            com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewView r4 = r11.getPreviewContainer()
            float r5 = r10.getInitPositionProgress()
            float r2 = r10.getInitPositionProgress()
            int r6 = (int) r2
            r7 = 0
            r8 = 4
            r9 = 0
            com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewView.setSelectedPositionProgress$default(r4, r5, r6, r7, r8, r9)
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r11.getManager()
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService> r4 = com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r4)
            com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService r2 = (com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService) r2
            if (r2 == 0) goto L_0x007c
            r3 = r11
            com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.IDynamicSeekBarChangeListener r3 = (com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.IDynamicSeekBarChangeListener) r3
            r2.addDynamicSeekBarChangeListener(r3)
        L_0x007c:
            r11.updateSeekBarStyle(r0)
            goto L_0x0097
        L_0x0080:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r11.getManager()
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService> r3 = com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r3)
            com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService r0 = (com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.ICarouselProgressBarService) r0
            if (r0 == 0) goto L_0x0097
            r2 = r11
            com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.IDynamicSeekBarChangeListener r2 = (com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.IDynamicSeekBarChangeListener) r2
            r0.removeDynamicSeekBarChangeListener(r2)
        L_0x0097:
            com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewView r0 = r11.getPreviewContainer()
            boolean r2 = r12.booleanValue()
            if (r2 == 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r1 = 8
        L_0x00a4:
            r0.setVisibility(r1)
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            boolean r0 = r0.isPadStyle()
            if (r0 != 0) goto L_0x00b6
            boolean r0 = r12.booleanValue()
            r11.handleClickedMaskView(r0)
        L_0x00b6:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r11.getStore()
            if (r0 == 0) goto L_0x00ca
            com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewActionManifest$OnDynamicPreviewVisibleChanged r1 = new com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewActionManifest$OnDynamicPreviewVisibleChanged
            boolean r2 = r12.booleanValue()
            r1.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewComponent.m11300onAttachToManager$lambda6$lambda4(com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewState, com.baidu.searchbox.video.feedflow.detail.dynamic.preview.DynamicPreviewComponent, java.lang.Boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-5  reason: not valid java name */
    public static final void m11301onAttachToManager$lambda6$lambda5(DynamicPreviewComponent this$0, Long durationMs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DynamicPreviewView previewContainer = this$0.getPreviewContainer();
        Intrinsics.checkNotNullExpressionValue(durationMs, "durationMs");
        previewContainer.setSingleDuration(durationMs.longValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8  reason: not valid java name */
    public static final void m11302onAttachToManager$lambda8(DynamicPreviewComponent this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nestedAction != null) {
            this$0.onNestedAction(nestedAction);
        }
    }

    private final void handleClickedMaskView(boolean isShowPreview) {
        Window window;
        Context context = getContext();
        ViewGroup viewGroup = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        KeyEvent.Callback decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        if (decorView instanceof ViewGroup) {
            viewGroup = (ViewGroup) decorView;
        }
        ViewGroup decorView2 = viewGroup;
        if (decorView2 == null) {
            return;
        }
        if (isShowPreview) {
            ViewUtilsKt.addViewToParent(getMaskView(), decorView2);
        } else {
            VideoFlowUtilsKt.removeFromParent(getMaskView());
        }
    }

    public void onDragProgressChanged(CarouselProgressBarView seekBar, float progress, int lastIndex, MotionEvent event) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        Intrinsics.checkNotNullParameter(event, "event");
        IDynamicSeekBarChangeListener.DefaultImpls.onDragProgressChanged(this, seekBar, progress, lastIndex, event);
        getPreviewContainer().setSelectedPositionProgress(progress, lastIndex, event);
    }

    private final void onNestedAction(NestedAction nestedAction) {
        if (nestedAction instanceof NestedAction.OnDetachFromScreen) {
            returnView();
            handleClickedMaskView(false);
        }
    }

    private final void registerSingleSeekBarListener() {
        unRegisterSingleSeekBarListener();
        ISeekBarService iSeekBarService = (ISeekBarService) getManager().getService(ISeekBarService.class);
        if (iSeekBarService != null) {
            iSeekBarService.addOnSeekBarChangeListener(getSingleSeekBarListener());
        }
    }

    private final void unRegisterSingleSeekBarListener() {
        ISeekBarService iSeekBarService = (ISeekBarService) getManager().getService(ISeekBarService.class);
        if (iSeekBarService != null) {
            iSeekBarService.removeOnSeekBarChangeListener(getSingleSeekBarListener());
        }
    }

    /* access modifiers changed from: private */
    public final void handleProgressChanged(boolean fromUser, int progress) {
        if (fromUser) {
            getPreviewContainer().setSingleCurrent(progress);
            getPreviewContainer().updateViewBySingleProgress(progress);
        }
    }

    private final void updateSeekBarStyle(boolean isSingleStyle) {
        if (isSingleStyle) {
            registerSingleSeekBarListener();
            updateComponentContainerLayoutRule(true);
        } else {
            updateComponentContainerLayoutRule(false);
        }
        updateMaskBackground(isSingleStyle);
    }

    private final void updateComponentContainerLayoutRule(boolean isSingle) {
        ViewParent parent = getRootView().getParent();
        View referenceView = null;
        View previewContainer = parent instanceof View ? (View) parent : null;
        if (previewContainer != null) {
            ViewGroup.LayoutParams layoutParams = previewContainer.getLayoutParams();
            RelativeLayout.LayoutParams $this$updateComponentContainerLayoutRule_u24lambda_u2d10_u24lambda_u2d9 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if ($this$updateComponentContainerLayoutRule_u24lambda_u2d10_u24lambda_u2d9 != null) {
                ViewParent parent2 = previewContainer.getParent();
                View previewContainerParent = parent2 instanceof View ? (View) parent2 : null;
                if (isSingle) {
                    if (previewContainerParent != null) {
                        referenceView = previewContainerParent.findViewById(R.id.single_seek_bar_container);
                    }
                } else if (previewContainerParent != null) {
                    referenceView = previewContainerParent.findViewById(R.id.bottom_container);
                }
                if (referenceView != null) {
                    $this$updateComponentContainerLayoutRule_u24lambda_u2d10_u24lambda_u2d9.addRule(2, 0);
                    $this$updateComponentContainerLayoutRule_u24lambda_u2d10_u24lambda_u2d9.addRule(2, referenceView.getId());
                    getRootView().setLayoutParams($this$updateComponentContainerLayoutRule_u24lambda_u2d10_u24lambda_u2d9);
                }
            }
        }
    }

    private final void updateMaskBackground(boolean isSingleStyle) {
        View $this$updateMaskBackground_u24lambda_u2d11 = getMaskView().findViewById(R.id.video_flow_dynamic_preview_bottom_mask);
        if ($this$updateMaskBackground_u24lambda_u2d11 == null) {
            return;
        }
        if (isSingleStyle) {
            $this$updateMaskBackground_u24lambda_u2d11.setBackgroundColor(ContextCompat.getColor($this$updateMaskBackground_u24lambda_u2d11.getContext(), R.color.video_flow_color_transparent));
        } else {
            $this$updateMaskBackground_u24lambda_u2d11.setBackgroundColor(ContextCompat.getColor($this$updateMaskBackground_u24lambda_u2d11.getContext(), R.color.video_flow_color_black));
        }
    }
}
