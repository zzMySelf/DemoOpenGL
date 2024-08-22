package com.baidu.searchbox.video.feedflow.ad.dynamic.carouselpic;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.ad.dynamic.CarouselPicModel;
import com.baidu.searchbox.video.feedflow.ad.dynamic.carouselpic.NadCarouselPicView;
import com.baidu.searchbox.video.feedflow.ad.gesture.AdGestureAction;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.tab.ITabComponentService;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0016J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0012\u0010&\u001a\u00020\u0019*\u00020\u00112\u0006\u0010'\u001a\u00020(J\n\u0010)\u001a\u00020\u0019*\u00020\u0011R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000e¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/dynamic/carouselpic/NadCarouselPicComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "carouselPicView", "Lcom/baidu/searchbox/video/feedflow/ad/dynamic/carouselpic/NadCarouselPicView;", "getCarouselPicView", "()Lcom/baidu/searchbox/video/feedflow/ad/dynamic/carouselpic/NadCarouselPicView;", "carouselPicView$delegate", "Lkotlin/Lazy;", "gestureTimestamp", "", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "rootView$delegate", "createView", "Landroid/view/View;", "dispatchLeftSlideAction", "", "getCurPicModel", "Lcom/baidu/searchbox/video/feedflow/ad/dynamic/CarouselPicModel;", "initCarouselPicView", "initRootView", "injectService", "", "isContainerNeedInterceptEvent", "direction", "", "isNeedInterceptEvent", "onAttachToManager", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "onRelease", "tryDispatchPicSelected", "model", "isUserDrag", "addViewToParent", "targetParentView", "Landroid/view/ViewGroup;", "removeFromParent", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCarouselPicComponent.kt */
public final class NadCarouselPicComponent extends LiveDataComponent {
    private final Lazy carouselPicView$delegate = BdPlayerUtils.lazyNone(new NadCarouselPicComponent$carouselPicView$2(this));
    private long gestureTimestamp;
    private final Lazy rootView$delegate = BdPlayerUtils.lazyNone(new NadCarouselPicComponent$rootView$2(this));

    private final NadCarouselPicView getCarouselPicView() {
        return (NadCarouselPicView) this.carouselPicView$delegate.getValue();
    }

    private final FrameLayout getRootView() {
        return (FrameLayout) this.rootView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FrameLayout initRootView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout $this$initRootView_u24lambda_u2d0 = frameLayout;
        $this$initRootView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        addViewToParent(getCarouselPicView(), $this$initRootView_u24lambda_u2d0);
        return frameLayout;
    }

    public View createView() {
        return getRootView();
    }

    /* access modifiers changed from: private */
    public final NadCarouselPicView initCarouselPicView() {
        NadCarouselPicView $this$initCarouselPicView_u24lambda_u2d1 = new NadCarouselPicView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$initCarouselPicView_u24lambda_u2d1.setOnPicSelected(new NadCarouselPicComponent$initCarouselPicView$1$1(this));
        $this$initCarouselPicView_u24lambda_u2d1.setOnPicScrollStateChanged(new NadCarouselPicComponent$initCarouselPicView$1$2(this));
        $this$initCarouselPicView_u24lambda_u2d1.setOnCarouselPicLoadResult(new NadCarouselPicComponent$initCarouselPicView$1$3(this));
        $this$initCarouselPicView_u24lambda_u2d1.setOnRefreshStateChanged(new NadCarouselPicComponent$initCarouselPicView$1$4(this));
        $this$initCarouselPicView_u24lambda_u2d1.setOnCarouselPicClick(new NadCarouselPicComponent$initCarouselPicView$1$5(this));
        $this$initCarouselPicView_u24lambda_u2d1.setOnCarouselPicDoubleClick(new NadCarouselPicComponent$initCarouselPicView$1$6(this));
        $this$initCarouselPicView_u24lambda_u2d1.setOnCarouselPicLongPress(new NadCarouselPicComponent$initCarouselPicView$1$7(this));
        $this$initCarouselPicView_u24lambda_u2d1.setOnCarouselPicLeftAction(new NadCarouselPicComponent$initCarouselPicView$1$8(this));
        return $this$initCarouselPicView_u24lambda_u2d1;
    }

    public void onAttachToManager() {
        NadCarouselPicState $this$onAttachToManager_u24lambda_u2d8;
        CoreState $this$onAttachToManager_u24lambda_u2d3;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d3 = (CoreState) $this$subscribe$iv.subscribe(CoreState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d3.getNestedAction().observe(this, new NadCarouselPicComponent$$ExternalSyntheticLambda0(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && ($this$onAttachToManager_u24lambda_u2d8 = (NadCarouselPicState) $this$subscribe$iv2.subscribe(NadCarouselPicState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d8.getData().observe(this, new NadCarouselPicComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d8.getRefreshCarouselPic().observe(this, new NadCarouselPicComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d8.getUpdatePosition().observe(this, new NadCarouselPicComponent$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d8.isVisible().observe(this, new NadCarouselPicComponent$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-2  reason: not valid java name */
    public static final void m5517onAttachToManager$lambda3$lambda2(NadCarouselPicComponent this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(nestedAction, "nestedAction");
        this$0.onNestedAction(nestedAction);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-4  reason: not valid java name */
    public static final void m5518onAttachToManager$lambda8$lambda4(NadCarouselPicComponent this$0, List data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NadCarouselPicView carouselPicView = this$0.getCarouselPicView();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        carouselPicView.bindData(data);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-5  reason: not valid java name */
    public static final void m5519onAttachToManager$lambda8$lambda5(NadCarouselPicComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCarouselPicView().refreshCarouselPic();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-6  reason: not valid java name */
    public static final void m5520onAttachToManager$lambda8$lambda6(NadCarouselPicComponent this$0, NadCarouselPicView.UpdatePositionModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NadCarouselPicView carouselPicView = this$0.getCarouselPicView();
        Intrinsics.checkNotNullExpressionValue(model, "model");
        carouselPicView.switchPic(model);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-7  reason: not valid java name */
    public static final void m5521onAttachToManager$lambda8$lambda7(NadCarouselPicComponent this$0, Boolean isVisible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NadCarouselPicView carouselPicView = this$0.getCarouselPicView();
        Intrinsics.checkNotNullExpressionValue(isVisible, "isVisible");
        carouselPicView.setVisibility(isVisible.booleanValue() ? 0 : 8);
    }

    private final void onNestedAction(NestedAction nestedAction) {
        if (nestedAction instanceof NestedAction.OnPageSelected) {
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                Object obj = null;
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(NadCarouselPicState.class);
                }
                NadCarouselPicState nadCarouselPicState = (NadCarouselPicState) obj;
                if (nadCarouselPicState != null) {
                    NadCarouselPicState $this$onNestedAction_u24lambda_u2d10 = nadCarouselPicState;
                    $this$onNestedAction_u24lambda_u2d10.setPicLookNum(0);
                    List<CarouselPicModel> $this$forEach$iv = $this$onNestedAction_u24lambda_u2d10.getData().getValue();
                    if ($this$forEach$iv != null) {
                        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "value");
                        for (CarouselPicModel item : $this$forEach$iv) {
                            item.setSelected(false);
                        }
                    }
                }
            }
            CarouselPicModel model = getCarouselPicView().getCurrentCarouselPicModel();
            if (model != null) {
                tryDispatchPicSelected(model, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void tryDispatchPicSelected(CarouselPicModel model, boolean isUserDrag) {
        if (!model.isSelected()) {
            model.setSelected(true);
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                Object obj = null;
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                if (commonState != null) {
                    obj = commonState.select(NadCarouselPicState.class);
                }
                NadCarouselPicState nadCarouselPicState = (NadCarouselPicState) obj;
                if (nadCarouselPicState != null) {
                    NadCarouselPicState $this$tryDispatchPicSelected_u24lambda_u2d12 = nadCarouselPicState;
                    $this$tryDispatchPicSelected_u24lambda_u2d12.setPicLookNum($this$tryDispatchPicSelected_u24lambda_u2d12.getPicLookNum() + 1);
                }
            }
        }
        Store<AbsState> store = getStore();
        if (store != null) {
            StoreExtKt.post(store, new OnCarouselPicSelected(model, isUserDrag));
        }
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(INadCarouselPicService.class, new NadCarouselPicServiceImpl(this));
    }

    public final boolean isNeedInterceptEvent(int direction) {
        return CommonStateExtKt.isActive(getStore()) && getCarouselPicView().isNeedInterceptEvent(direction);
    }

    public final boolean isContainerNeedInterceptEvent(int direction) {
        return CommonStateExtKt.isActive(getStore()) && getCarouselPicView().isContainerNeedInterceptEvent(direction);
    }

    public final CarouselPicModel getCurPicModel() {
        Store $this$select$iv = getStore();
        if ($this$select$iv == null) {
            return null;
        }
        AbsState state = $this$select$iv.getState();
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        NadCarouselPicState nadCarouselPicState = (NadCarouselPicState) (commonState != null ? commonState.select(NadCarouselPicState.class) : null);
        if (nadCarouselPicState != null) {
            return nadCarouselPicState.getCurSelectedModel();
        }
        return null;
    }

    public void onRelease() {
        super.onRelease();
        getCarouselPicView().release();
    }

    public final void removeFromParent(View $this$removeFromParent) {
        Intrinsics.checkNotNullParameter($this$removeFromParent, "<this>");
        ViewParent parent = $this$removeFromParent.getParent();
        ViewGroup $this$removeFromParent_u24lambda_u2d13 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if ($this$removeFromParent_u24lambda_u2d13 != null) {
            $this$removeFromParent_u24lambda_u2d13.removeView($this$removeFromParent);
        }
    }

    public final void addViewToParent(View $this$addViewToParent, ViewGroup targetParentView) {
        Intrinsics.checkNotNullParameter($this$addViewToParent, "<this>");
        Intrinsics.checkNotNullParameter(targetParentView, "targetParentView");
        removeFromParent($this$addViewToParent);
        targetParentView.addView($this$addViewToParent);
    }

    /* access modifiers changed from: private */
    public final boolean dispatchLeftSlideAction() {
        long currGestureTimestamp = System.currentTimeMillis();
        long j2 = this.gestureTimestamp;
        boolean z = false;
        if (j2 != 0 && currGestureTimestamp - j2 < 1000) {
            return false;
        }
        this.gestureTimestamp = currGestureTimestamp;
        ITabComponentService iTabComponentService = (ITabComponentService) getManager().getService(ITabComponentService.class);
        if (iTabComponentService != null && iTabComponentService.canScrollHorizontally(1)) {
            z = true;
        }
        if (!z) {
            FrameLayout rootView = getRootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? rootView : null;
            if (viewGroup != null) {
                viewGroup.requestDisallowInterceptTouchEvent(true);
            }
            Store<AbsState> store = getStore();
            if (store != null) {
                store.dispatch(AdGestureAction.LeftSlide.INSTANCE);
            }
        }
        return true;
    }
}
