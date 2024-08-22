package com.baidu.searchbox.video.feedflow.flow.topexpand.expandable;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableAction;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00104\u001a\u0002052\u0006\u00106\u001a\u00020(J\b\u00107\u001a\u000205H\u0016J\b\u00108\u001a\u00020\u0004H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u001cH\u0002J\b\u0010=\u001a\u00020\u0017H\u0016J\b\u0010>\u001a\u000205H\u0016J\b\u0010?\u001a\u000205H\u0016J\b\u0010@\u001a\u00020.H\u0016J\b\u0010A\u001a\u00020.H\u0016J\u0010\u0010B\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010C\u001a\u00020\nH\u0002J\b\u0010D\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020\u0017H&J\u0006\u0010F\u001a\u00020!J\u0010\u0010G\u001a\u00020!2\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010H\u001a\u00020!H\u0016J\u0006\u0010I\u001a\u00020!J\b\u0010J\u001a\u00020!H\u0014J\b\u0010K\u001a\u00020!H\u0016J\u0006\u0010L\u001a\u00020!J\b\u0010M\u001a\u000205H\u0016J\b\u0010N\u001a\u000205H\u0016J\b\u0010O\u001a\u000205H\u0016J\b\u0010P\u001a\u000205H\u0016J\u0010\u0010Q\u001a\u0002052\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020!H&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0014\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00178DX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R+\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8DX\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/topexpand/expandable/TopExpandableComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "animDistance", "", "getAnimDistance", "()F", "setAnimDistance", "(F)V", "collapseAnimator", "Landroid/animation/ValueAnimator;", "getCollapseAnimator", "()Landroid/animation/ValueAnimator;", "collapseAnimator$delegate", "Lkotlin/Lazy;", "downCurTime", "", "downX", "downY", "expandAnimator", "getExpandAnimator", "expandAnimator$delegate", "expandableView", "Landroid/view/View;", "getExpandableView", "()Landroid/view/View;", "expandableView$delegate", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getGlobalLayoutListener", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener$delegate", "isConsumeGesture", "", "isFullExpanded", "()Z", "setFullExpanded", "(Z)V", "listenerSet", "Ljava/util/HashSet;", "Lcom/baidu/searchbox/video/feedflow/flow/topexpand/expandable/ExpandableContainerListener;", "Lkotlin/collections/HashSet;", "getListenerSet", "()Ljava/util/HashSet;", "listenerSet$delegate", "tabViewHeight", "", "getTabViewHeight", "()I", "setTabViewHeight", "(I)V", "touchSlop", "addExpandListener", "", "listener", "collapse", "computeAnimDistance", "consumeEvent", "event", "Landroid/view/MotionEvent;", "createGlobalLayoutListener", "createView", "expand", "fontSizeChanged", "getHeight", "getTopExpandableType", "handleGestureCollapseEvent", "initCollapseAnimator", "initExpandAnimator", "initView", "isAnimating", "isConsumeGestureCollapseEvent", "isExpandAutoPlayEnabled", "isExpend", "isImmersive", "isInterceptPlay", "isVisible", "onAttachToManager", "onCollapseEnd", "onExpendEnd", "onRelease", "requestCollapse", "updateNightMode", "isNightMode", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopExpandableComponent.kt */
public abstract class TopExpandableComponent extends LiveDataComponent {
    private float animDistance;
    private final Lazy collapseAnimator$delegate = BdPlayerUtils.lazyNone(new TopExpandableComponent$collapseAnimator$2(this));
    private long downCurTime;
    private float downX;
    private float downY;
    private final Lazy expandAnimator$delegate = BdPlayerUtils.lazyNone(new TopExpandableComponent$expandAnimator$2(this));
    private final Lazy expandableView$delegate = BdPlayerUtils.lazyNone(new TopExpandableComponent$expandableView$2(this));
    private final Lazy globalLayoutListener$delegate = BdPlayerUtils.lazyNone(new TopExpandableComponent$globalLayoutListener$2(this));
    private boolean isConsumeGesture;
    private boolean isFullExpanded;
    private final Lazy listenerSet$delegate = BdPlayerUtils.lazyNone(TopExpandableComponent$listenerSet$2.INSTANCE);
    private int tabViewHeight;
    private final float touchSlop = ((float) ViewConfiguration.get(DIFactory.INSTANCE.getAppContext()).getScaledTouchSlop());

    public abstract View initView();

    public abstract void updateNightMode(boolean z);

    /* access modifiers changed from: protected */
    public final View getExpandableView() {
        return (View) this.expandableView$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final HashSet<ExpandableContainerListener> getListenerSet() {
        return (HashSet) this.listenerSet$delegate.getValue();
    }

    private final ValueAnimator getExpandAnimator() {
        return (ValueAnimator) this.expandAnimator$delegate.getValue();
    }

    private final ValueAnimator getCollapseAnimator() {
        return (ValueAnimator) this.collapseAnimator$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final float getAnimDistance() {
        return this.animDistance;
    }

    /* access modifiers changed from: protected */
    public final void setAnimDistance(float f2) {
        this.animDistance = f2;
    }

    /* access modifiers changed from: protected */
    public final boolean isFullExpanded() {
        return this.isFullExpanded;
    }

    /* access modifiers changed from: protected */
    public final void setFullExpanded(boolean z) {
        this.isFullExpanded = z;
    }

    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener getGlobalLayoutListener() {
        return (ViewTreeObserver.OnGlobalLayoutListener) this.globalLayoutListener$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final int getTabViewHeight() {
        return this.tabViewHeight;
    }

    /* access modifiers changed from: protected */
    public final void setTabViewHeight(int i2) {
        this.tabViewHeight = i2;
    }

    public View createView() {
        return getExpandableView();
    }

    public void onAttachToManager() {
        TopExpandableState $this$onAttachToManager_u24lambda_u2d5;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d5 = (TopExpandableState) $this$subscribe$iv.subscribe(TopExpandableState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d5.isExpand().observe(this, new TopExpandableComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d5.getUpdateNightMode().observe(this, new TopExpandableComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d5.getFontSizeChange().observe(this, new TopExpandableComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d5.getUpdateListenerAndSelfMargin().observe(this, new TopExpandableComponent$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-0  reason: not valid java name */
    public static final void m6744onAttachToManager$lambda5$lambda0(TopExpandableComponent this$0, Boolean isExpand) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isExpand, "isExpand");
        if (isExpand.booleanValue()) {
            this$0.expand();
        } else {
            this$0.collapse();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-1  reason: not valid java name */
    public static final void m6745onAttachToManager$lambda5$lambda1(TopExpandableComponent this$0, Boolean isNightMode) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isNightMode, "isNightMode");
        this$0.updateNightMode(isNightMode.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-2  reason: not valid java name */
    public static final void m6746onAttachToManager$lambda5$lambda2(TopExpandableComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fontSizeChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-4  reason: not valid java name */
    public static final void m6747onAttachToManager$lambda5$lambda4(TopExpandableComponent this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getExpandableView().getVisibility() == 0 && CommonStateExtKt.isActive(this$0.getStore())) {
            this$0.animDistance = this$0.computeAnimDistance();
            if (!this$0.getCollapseAnimator().isRunning()) {
                for (ExpandableContainerListener listener : this$0.getListenerSet()) {
                    listener.onExpand(this$0.animDistance, this$0.tabViewHeight, 1.0f);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final ValueAnimator initExpandAnimator() {
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f}).setDuration(240);
        animator.addUpdateListener(new TopExpandableComponent$$ExternalSyntheticLambda6(this));
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* access modifiers changed from: private */
    /* renamed from: initExpandAnimator$lambda-8  reason: not valid java name */
    public static final void m6743initExpandAnimator$lambda8(TopExpandableComponent this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f2 != null) {
            float value = f2.floatValue();
            for (ExpandableContainerListener listener : this$0.getListenerSet()) {
                listener.onExpand(value, this$0.tabViewHeight, animation.getAnimatedFraction());
            }
            float animatedFraction = animation.getAnimatedFraction();
            boolean z = false;
            if (animatedFraction == 0.0f) {
                this$0.isFullExpanded = false;
                this$0.getExpandableView().setVisibility(0);
                return;
            }
            if (animatedFraction == 1.0f) {
                z = true;
            }
            if (z) {
                this$0.isFullExpanded = true;
                this$0.onExpendEnd();
            }
        }
    }

    public void onExpendEnd() {
        Store<AbsState> store = getStore();
        if (store != null) {
            StoreExtKt.post(store, new TopExpandableAction.ExpandEnd(getHeight()));
        }
    }

    /* access modifiers changed from: private */
    public final ValueAnimator initCollapseAnimator() {
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f}).setDuration(240);
        animator.addUpdateListener(new TopExpandableComponent$$ExternalSyntheticLambda5(this));
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* access modifiers changed from: private */
    /* renamed from: initCollapseAnimator$lambda-11  reason: not valid java name */
    public static final void m6742initCollapseAnimator$lambda11(TopExpandableComponent this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f2 != null) {
            float value = f2.floatValue();
            for (ExpandableContainerListener listener : this$0.getListenerSet()) {
                listener.onCollapse(value, animation.getAnimatedFraction());
            }
            boolean z = false;
            this$0.isFullExpanded = false;
            if (animation.getAnimatedFraction() == 1.0f) {
                z = true;
            }
            if (z) {
                this$0.getExpandableView().setVisibility(4);
                this$0.onCollapseEnd();
            }
        }
    }

    public void onCollapseEnd() {
        Store<AbsState> store = getStore();
        if (store != null) {
            StoreExtKt.post(store, TopExpandableAction.CollapseEnd.INSTANCE);
        }
    }

    public void expand() {
        getCollapseAnimator().cancel();
        this.animDistance = computeAnimDistance();
        getExpandAnimator().setFloatValues(new float[]{0.0f, this.animDistance});
        getExpandAnimator().start();
    }

    public void collapse() {
        getExpandAnimator().cancel();
        getCollapseAnimator().setFloatValues(new float[]{this.animDistance, 0.0f});
        getCollapseAnimator().start();
    }

    public void requestCollapse(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Store<AbsState> store = getStore();
        if (store != null) {
            StoreExtKt.post(store, TopExpandableAction.CollapseStart.INSTANCE);
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.view.ViewParent] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r5.isSecondTabPanelImmerse() == true) goto L_0x002c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float computeAnimDistance() {
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
            r5 = r2
        L_0x0016:
            if (r5 == 0) goto L_0x001f
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableState> r6 = com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0020
        L_0x001f:
            r5 = r2
        L_0x0020:
            com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableState r5 = (com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableState) r5
            if (r5 == 0) goto L_0x002b
            boolean r0 = r5.isSecondTabPanelImmerse()
            if (r0 != r1) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = r3
        L_0x002c:
            if (r1 == 0) goto L_0x0050
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r7.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.ITabComponentService> r1 = com.baidu.searchbox.video.feedflow.tab.ITabComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r1)
            com.baidu.searchbox.video.feedflow.tab.ITabComponentService r0 = (com.baidu.searchbox.video.feedflow.tab.ITabComponentService) r0
            if (r0 == 0) goto L_0x0041
            int r0 = r0.getTabSecondPanelHeight()
            goto L_0x0042
        L_0x0041:
            r0 = r3
        L_0x0042:
            com.baidu.searchbox.video.feedflow.di.DIFactory r1 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            r4 = 1092616192(0x41200000, float:10.0)
            int r1 = r1.dp2px(r4)
            int r0 = r0 - r1
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast((int) r0, (int) r3)
            goto L_0x0059
        L_0x0050:
            int r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.getTabViewScaledHeight()
            int r1 = com.baidu.searchbox.video.detail.utils.VideoImmersionUtils.getStatusBarHeight()
            int r0 = r0 + r1
        L_0x0059:
            r7.tabViewHeight = r0
            android.view.View r0 = r7.getExpandableView()
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x006a
            r2 = r0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L_0x006a:
            if (r2 == 0) goto L_0x007d
            int r0 = r2.getHeight()
            boolean r1 = r7.isImmersive()
            if (r1 == 0) goto L_0x0078
            float r1 = (float) r0
            return r1
        L_0x0078:
            int r1 = r7.tabViewHeight
            int r1 = r1 + r0
            float r1 = (float) r1
            return r1
        L_0x007d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableComponent.computeAnimDistance():float");
    }

    /* access modifiers changed from: protected */
    public boolean isImmersive() {
        return false;
    }

    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener createGlobalLayoutListener() {
        return new TopExpandableComponent$$ExternalSyntheticLambda4(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: createGlobalLayoutListener$lambda-13  reason: not valid java name */
    public static final void m6741createGlobalLayoutListener$lambda13(TopExpandableComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFullExpanded) {
            float newAnimDistance = this$0.computeAnimDistance();
            if (!(newAnimDistance == this$0.animDistance)) {
                this$0.animDistance = newAnimDistance;
                for (ExpandableContainerListener listener : this$0.getListenerSet()) {
                    listener.onExpand(this$0.animDistance, this$0.tabViewHeight, 1.0f);
                }
            }
        }
    }

    public final void addExpandListener(ExpandableContainerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getListenerSet().add(listener);
    }

    public final boolean isVisible() {
        return getExpandableView().getVisibility() == 0;
    }

    public final boolean isAnimating() {
        return getExpandAnimator().isRunning() || getCollapseAnimator().isRunning();
    }

    public boolean consumeEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ViewParent parent = getExpandableView().getParent();
        ViewGroup parentView = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (parentView == null || !isVisible()) {
            return false;
        }
        int top = parentView.getTop();
        int bottom = parentView.getBottom();
        int y = (int) event.getY();
        if (top <= y && y <= bottom) {
            return true;
        }
        return false;
    }

    public void onRelease() {
        super.onRelease();
        getListenerSet().clear();
        getExpandAnimator().removeAllUpdateListeners();
        getExpandAnimator().cancel();
        getCollapseAnimator().removeAllUpdateListeners();
        getCollapseAnimator().cancel();
        getExpandableView().getViewTreeObserver().removeOnGlobalLayoutListener(getGlobalLayoutListener());
    }

    public void fontSizeChanged() {
        if (this.isFullExpanded) {
            DIFactory.INSTANCE.post(new TopExpandableComponent$fontSizeChanged$1(this));
        }
    }

    public int getHeight() {
        return getExpandableView().getHeight();
    }

    public boolean isInterceptPlay() {
        return false;
    }

    public boolean isExpandAutoPlayEnabled() {
        return false;
    }

    public final boolean isConsumeGestureCollapseEvent(MotionEvent event) {
        if (event == null) {
            return false;
        }
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        Collection dataSource = iFlowComponentService != null ? iFlowComponentService.getDataSource() : null;
        int i2 = 1;
        if (dataSource == null || dataSource.isEmpty()) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                this.isConsumeGesture = isVisible();
                break;
            case 2:
                if (Math.abs(event.getY() - this.downY) > Math.abs(event.getX() - this.downX) && Math.abs(event.getY() - this.downY) >= this.touchSlop && event.getY() > this.downY) {
                    IFlowComponentService iFlowComponentService2 = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
                    if (iFlowComponentService2 != null) {
                        i2 = iFlowComponentService2.getCurItemPosition();
                    }
                    if (i2 == 0) {
                        return false;
                    }
                }
                if (Math.abs(event.getY() - this.downY) < Math.abs(event.getX() - this.downX) && Math.abs(event.getX() - this.downX) >= this.touchSlop) {
                    return false;
                }
        }
        return this.isConsumeGesture;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        if (r2 > 0) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleGestureCollapseEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x00cf
            r0 = r10
            r1 = 0
            boolean r2 = r9.isVisible()
            if (r2 == 0) goto L_0x00cd
            boolean r2 = r9.isAnimating()
            if (r2 != 0) goto L_0x00cd
            int r2 = r10.getAction()
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x00bb;
                case 1: goto L_0x0099;
                case 2: goto L_0x001b;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x00cd
        L_0x001b:
            float r2 = r10.getY()
            float r5 = r9.downY
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            float r5 = r10.getX()
            float r6 = r9.downX
            float r5 = r5 - r6
            float r5 = java.lang.Math.abs(r5)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x006a
            float r2 = r10.getY()
            float r5 = r9.downY
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            float r5 = r9.touchSlop
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x006a
            float r2 = r10.getY()
            float r5 = r9.downY
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x0067
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r9.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r5 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r5)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r2 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r2
            if (r2 == 0) goto L_0x0064
            int r2 = r2.getCurItemPosition()
            goto L_0x0065
        L_0x0064:
            r2 = r4
        L_0x0065:
            if (r2 <= 0) goto L_0x006a
        L_0x0067:
            r9.requestCollapse(r10)
        L_0x006a:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r9.downCurTime
            long r5 = r5 - r7
            r7 = 200(0xc8, double:9.9E-322)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x00cd
            float r2 = r10.getY()
            float r5 = r9.downY
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            float r5 = r10.getX()
            float r6 = r9.downX
            float r5 = r5 - r6
            float r5 = java.lang.Math.abs(r5)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r3 = r4
        L_0x0093:
            if (r3 == 0) goto L_0x00cd
            r9.requestCollapse(r10)
            goto L_0x00cd
        L_0x0099:
            float r2 = r10.getY()
            float r5 = r9.downY
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            float r5 = r10.getX()
            float r6 = r9.downX
            float r5 = r5 - r6
            float r5 = java.lang.Math.abs(r5)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r3 = r4
        L_0x00b5:
            if (r3 == 0) goto L_0x00cd
            r9.requestCollapse(r10)
            goto L_0x00cd
        L_0x00bb:
            float r2 = r10.getY()
            r9.downY = r2
            float r2 = r10.getX()
            r9.downX = r2
            long r2 = java.lang.System.currentTimeMillis()
            r9.downCurTime = r2
        L_0x00cd:
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableComponent.handleGestureCollapseEvent(android.view.MotionEvent):void");
    }

    public final boolean isExpend() {
        MutableLiveData<Boolean> isExpand;
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(TopExpandableState.class);
            }
            TopExpandableState topExpandableState = (TopExpandableState) obj;
            if (!(topExpandableState == null || (isExpand = topExpandableState.isExpand()) == null)) {
                return Intrinsics.areEqual((Object) isExpand.getValue(), (Object) true);
            }
        }
        return false;
    }

    public int getTopExpandableType() {
        return 0;
    }
}
