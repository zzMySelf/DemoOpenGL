package com.baidu.searchbox.video.feedflow.ad.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.ad.gesture.AdGestureAction;
import com.baidu.searchbox.video.feedflow.ad.gesture.AdGestureComponent$gestureListener$2;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.gesture.DoubleClick;
import com.baidu.searchbox.video.feedflow.detail.gesture.GestureState;
import com.baidu.searchbox.video.feedflow.detail.gesture.LongPressStart;
import com.baidu.searchbox.video.feedflow.detail.gesture.LongPressStop;
import com.baidu.searchbox.video.feedflow.detail.gesture.SingleClick;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.model.NewMoreMenuDataTranUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.service.ILongPressNewMenuService;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.service.ILongPressMenuService;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceAction;
import com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.ITopExpandableService;
import com.baidu.searchbox.video.feedflow.tab.ITabComponentService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/gesture/AdGestureComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "gestureListener", "com/baidu/searchbox/video/feedflow/ad/gesture/AdGestureComponent$gestureListener$2$1", "getGestureListener", "()Lcom/baidu/searchbox/video/feedflow/ad/gesture/AdGestureComponent$gestureListener$2$1;", "gestureListener$delegate", "isLongPressing", "", "longPressDownEvent", "Landroid/view/MotionEvent;", "mGestureTimestamp", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view$delegate", "createView", "dispatchLeftSlideAction", "initPlugin", "", "initView", "onDoubleTap", "event", "onLongPressStart", "onLongPressStop", "onScrollNew", "distanceX", "", "distanceY", "onSingleTapConfirmed", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdGestureComponent.kt */
public final class AdGestureComponent extends LiveDataComponent {
    private final Lazy gestureDetector$delegate = LazyKt.lazy(new AdGestureComponent$gestureDetector$2(this));
    private final Lazy gestureListener$delegate = LazyKt.lazy(new AdGestureComponent$gestureListener$2(this));
    /* access modifiers changed from: private */
    public boolean isLongPressing;
    private MotionEvent longPressDownEvent;
    private long mGestureTimestamp;
    private final Lazy view$delegate = LazyKt.lazy(new AdGestureComponent$view$2(this));

    private final View getView() {
        return (View) this.view$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AdGestureComponent$gestureListener$2.AnonymousClass1 getGestureListener() {
        return (AdGestureComponent$gestureListener$2.AnonymousClass1) this.gestureListener$delegate.getValue();
    }

    public void initPlugin() {
        GestureState $this$initPlugin_u24lambda_u2d1;
        super.initPlugin();
        Store<AbsState> store = getStore();
        if (store != null && ($this$initPlugin_u24lambda_u2d1 = (GestureState) store.subscribe((Class<T>) GestureState.class)) != null) {
            $this$initPlugin_u24lambda_u2d1.isEnable().observe(this, new AdGestureComponent$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initPlugin$lambda-1$lambda-0  reason: not valid java name */
    public static final void m5567initPlugin$lambda1$lambda0(AdGestureComponent this$0, Boolean isEnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.getView();
        Intrinsics.checkNotNullExpressionValue(isEnable, "isEnable");
        view2.setVisibility(isEnable.booleanValue() ? 0 : 8);
    }

    /* access modifiers changed from: private */
    public final View initView() {
        AdGestureComponent$initView$1 adGestureComponent$initView$1 = new AdGestureComponent$initView$1(this, getContext());
        AdGestureComponent$initView$1 $this$initView_u24lambda_u2d2 = adGestureComponent$initView$1;
        $this$initView_u24lambda_u2d2.setClickable(true);
        $this$initView_u24lambda_u2d2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$initView_u24lambda_u2d2.setAlpha(0.0f);
        return adGestureComponent$initView$1;
    }

    public View createView() {
        return getView();
    }

    /* access modifiers changed from: private */
    public final boolean onSingleTapConfirmed(MotionEvent event) {
        Store<AbsState> store = getStore();
        if (store == null) {
            return true;
        }
        store.dispatch(SingleClick.INSTANCE);
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean onDoubleTap(MotionEvent event) {
        Store<AbsState> store = getStore();
        if (store == null) {
            return true;
        }
        store.dispatch(new DoubleClick(event));
        return true;
    }

    private final boolean dispatchLeftSlideAction() {
        long currGestureTimestamp = System.currentTimeMillis();
        long j2 = this.mGestureTimestamp;
        boolean z = false;
        if (j2 != 0 && currGestureTimestamp - j2 < 1000) {
            return false;
        }
        this.mGestureTimestamp = currGestureTimestamp;
        ITabComponentService iTabComponentService = (ITabComponentService) getManager().getService(ITabComponentService.class);
        if (iTabComponentService != null && iTabComponentService.canScrollHorizontally(1)) {
            z = true;
        }
        if (!z) {
            View view2 = getView();
            ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
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

    /* access modifiers changed from: private */
    public final boolean onScrollNew(float distanceX, float distanceY) {
        if (distanceX > Math.abs(distanceY)) {
            return dispatchLeftSlideAction();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void onLongPressStart(MotionEvent event) {
        if (CommonStateExtKt.isActive(getStore())) {
            IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
            boolean z = false;
            if (!(iPlayerComponentService != null && iPlayerComponentService.isAirPlayLayerShowing())) {
                ITopExpandableService iTopExpandableService = (ITopExpandableService) getManager().getService(ITopExpandableService.class);
                if (iTopExpandableService != null && iTopExpandableService.isVisible()) {
                    Store<AbsState> store = getStore();
                    if (store != null) {
                        StoreExtKt.post(store, new TopEntranceAction.Click(false));
                        return;
                    }
                    return;
                }
                if (!NewMoreMenuDataTranUtilsKt.getNewLongMenuSwitch(getStore())) {
                    ILongPressMenuService iLongPressMenuService = (ILongPressMenuService) getManager().getService(ILongPressMenuService.class);
                    if (iLongPressMenuService != null && iLongPressMenuService.onPressStar(event)) {
                        getView().getParent().requestDisallowInterceptTouchEvent(true);
                        return;
                    }
                }
                if (NewMoreMenuDataTranUtilsKt.getNewLongMenuSwitch(getStore())) {
                    ILongPressNewMenuService iLongPressNewMenuService = (ILongPressNewMenuService) getManager().getService(ILongPressNewMenuService.class);
                    if (iLongPressNewMenuService != null && iLongPressNewMenuService.onPress(event)) {
                        z = true;
                    }
                    if (z) {
                        getView().getParent().requestDisallowInterceptTouchEvent(true);
                        return;
                    }
                }
                this.isLongPressing = true;
                this.longPressDownEvent = event;
                ViewParent parent = getView().getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                Store<AbsState> store2 = getStore();
                if (store2 != null) {
                    StoreExtKt.post(store2, new LongPressStart(event, getContext()));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onLongPressStop() {
        MotionEvent event = this.longPressDownEvent;
        if (event != null) {
            this.isLongPressing = false;
            ViewParent parent = getView().getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            Store<AbsState> store = getStore();
            if (store != null) {
                StoreExtKt.post(store, new LongPressStop(event, getContext()));
            }
            this.longPressDownEvent = null;
        }
    }
}
