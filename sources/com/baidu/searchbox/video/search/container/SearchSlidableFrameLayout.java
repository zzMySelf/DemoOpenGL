package com.baidu.searchbox.video.search.container;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.animation.SlidableFrameLayout;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.ITouchEventListenerService;
import com.baidu.searchbox.video.feedflow.flow.list.WindowFocusChanged;
import com.baidu.searchbox.video.search.outeranim.service.IOuterAnimService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020&2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0002J\u0012\u0010'\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020 H\u0016R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u0016¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/video/search/container/SearchSlidableFrameLayout;", "Lcom/baidu/searchbox/browserenhanceengine/container/animation/SlidableFrameLayout;", "context", "Landroid/content/Context;", "contentView", "Landroid/view/View;", "container", "Lcom/baidu/searchbox/browserenhanceengine/container/Container;", "Lcom/baidu/searchbox/video/search/container/SearchFlowContainerModel;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "(Landroid/content/Context;Landroid/view/View;Lcom/baidu/searchbox/browserenhanceengine/container/Container;Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;)V", "lastSlideOffset", "", "getLastSlideOffset", "()Ljava/lang/Float;", "setLastSlideOffset", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "lastX", "", "getLastX", "()I", "setLastX", "(I)V", "getManager", "()Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "touchSlop", "getTouchSlop", "touchSlop$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "", "p0", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "ev", "onPanelSlide", "", "onTouchEvent", "onWindowFocusChanged", "hasWindowFocus", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchSlidableFrameLayout.kt */
public class SearchSlidableFrameLayout extends SlidableFrameLayout {
    private Float lastSlideOffset;
    private int lastX;
    private final ComponentArchManager manager;
    private final Lazy touchSlop$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchSlidableFrameLayout(Context context, View contentView, Container<SearchFlowContainerModel> container, ComponentArchManager manager2) {
        super(context, contentView, container);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(manager2, FeedStatisticConstants.UBC_TYPE_PLUS);
        this.manager = manager2;
        this.touchSlop$delegate = BdPlayerUtils.lazyNone(new SearchSlidableFrameLayout$touchSlop$2(context));
    }

    /* access modifiers changed from: protected */
    public final ComponentArchManager getManager() {
        return this.manager;
    }

    private final int getTouchSlop() {
        return ((Number) this.touchSlop$delegate.getValue()).intValue();
    }

    public final int getLastX() {
        return this.lastX;
    }

    public final void setLastX(int i2) {
        this.lastX = i2;
    }

    public final Float getLastSlideOffset() {
        return this.lastSlideOffset;
    }

    public final void setLastSlideOffset(Float f2) {
        this.lastSlideOffset = f2;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean z = true;
        if (!this.mContainer.isSlidable(ev)) {
            return false;
        }
        IOuterAnimService iOuterAnimService = (IOuterAnimService) this.manager.getService(IOuterAnimService.class);
        if (iOuterAnimService != null && iOuterAnimService.consumeEvent(ev)) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        IOuterAnimService iOuterAnimService2 = (IOuterAnimService) this.manager.getService(IOuterAnimService.class);
        if (iOuterAnimService2 == null || !iOuterAnimService2.interceptBeeAnimation()) {
            z = false;
        }
        if (z) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public boolean dispatchTouchEvent(MotionEvent p0) {
        ITouchEventListenerService iTouchEventListenerService = (ITouchEventListenerService) this.manager.getService(ITouchEventListenerService.class);
        if (iTouchEventListenerService != null) {
            iTouchEventListenerService.dispatch(p0);
        }
        return super.dispatchTouchEvent(p0);
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Store store = this.manager.getStore();
        if (store != null) {
            StoreExtKt.post(store, new WindowFocusChanged(hasWindowFocus, false, 2, (DefaultConstructorMarker) null));
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        onPanelSlide(ev);
        IOuterAnimService iOuterAnimService = (IOuterAnimService) this.manager.getService(IOuterAnimService.class);
        boolean z = true;
        if (iOuterAnimService == null || !iOuterAnimService.consumeEvent(ev)) {
            z = false;
        }
        if (!z) {
            return super.onTouchEvent(ev);
        }
        IOuterAnimService iOuterAnimService2 = (IOuterAnimService) this.manager.getService(IOuterAnimService.class);
        if (iOuterAnimService2 != null) {
            return iOuterAnimService2.onTouchEvent(ev);
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [com.baidu.searchbox.browserenhanceengine.container.Container] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onPanelSlide(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x000d
            float r1 = r8.getX()
            int r1 = (int) r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000e
        L_0x000d:
            r1 = r0
        L_0x000e:
            int r1 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r1)
            int r2 = r7.lastX
            int r2 = r1 - r2
            int r2 = java.lang.Math.abs(r2)
            int r3 = r7.getTouchSlop()
            if (r2 <= r3) goto L_0x006f
            r7.lastX = r1
            com.baidu.searchbox.browserenhanceengine.container.Container r2 = r7.mContainer
            boolean r3 = r2 instanceof com.baidu.searchbox.browserenhanceengine.container.templete.LifecycleContainer
            if (r3 == 0) goto L_0x002b
            r0 = r2
            com.baidu.searchbox.browserenhanceengine.container.templete.LifecycleContainer r0 = (com.baidu.searchbox.browserenhanceengine.container.templete.LifecycleContainer) r0
        L_0x002b:
            if (r0 == 0) goto L_0x006f
            android.view.View r0 = r0.getSlideView()
            if (r0 == 0) goto L_0x006f
            r2 = 0
            int r3 = r0.getWidth()
            if (r3 == 0) goto L_0x006e
            float r3 = r0.getX()
            int r4 = r0.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            float r3 = androidx.core.math.MathUtils.clamp((float) r3, (float) r4, (float) r5)
            java.lang.Float r4 = r7.lastSlideOffset
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r4, (float) r3)
            if (r4 != 0) goto L_0x006e
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r7.manager
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.common.IPageRightSlideListenerService> r6 = com.baidu.searchbox.video.feedflow.common.IPageRightSlideListenerService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r4 = r4.getService(r6)
            com.baidu.searchbox.video.feedflow.common.IPageRightSlideListenerService r4 = (com.baidu.searchbox.video.feedflow.common.IPageRightSlideListenerService) r4
            if (r4 == 0) goto L_0x0068
            r5 = r7
            android.view.View r5 = (android.view.View) r5
            r4.onPanelSlide(r5, r3)
        L_0x0068:
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            r7.lastSlideOffset = r4
        L_0x006e:
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.search.container.SearchSlidableFrameLayout.onPanelSlide(android.view.MotionEvent):void");
    }
}
