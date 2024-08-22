package com.baidu.searchbox.video.linkageflow.container;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.pinchsummary.interfaces.OnPinchSummaryDataSourceCallback;
import com.baidu.searchbox.pinchsummary.model.PinchSummaryEntity;
import com.baidu.searchbox.video.linkageflow.container.event.LinkageEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H&J\b\u0010)\u001a\u00020\u001fH\u0004J\u0012\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u000fH\u0002J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\bH&J\b\u00101\u001a\u00020\bH&J\u0010\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020\u001dH\u0016J\b\u00105\u001a\u00020\u001dH\u0016J\b\u00106\u001a\u00020\u001dH\u0016J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u001dH\u0017J\b\u0010;\u001a\u00020\u001dH\u0017J\b\u0010<\u001a\u00020\u001dH\u0016J\b\u0010=\u001a\u00020\u001dH\u0016J\u0012\u0010>\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\bH\u0016J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010E\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010F\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\bH\u0016J\b\u0010J\u001a\u00020\u001dH\u0016J\b\u0010K\u001a\u00020\u001dH\u0016J\u0018\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\bH\u0016J\b\u0010T\u001a\u00020\u001dH\u0017J\b\u0010U\u001a\u00020\u001dH\u0017J\u0010\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\bH\u0016J\b\u0010X\u001a\u00020\u001dH\u0017J\b\u0010Y\u001a\u00020\u001dH\u0017J\b\u0010Z\u001a\u00020\u001dH\u0016J\u0010\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020\u001dH\u0016J\u0018\u0010^\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020`H\u0002J\u000e\u0010a\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/baidu/searchbox/video/linkageflow/container/BaseLinkageItemContainer;", "Lcom/baidu/searchbox/video/linkageflow/container/ILifecycle;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "", "isAttachToScreen", "()Z", "isAttachToViewTree", "isDragToNextUpcoming", "isSelected", "lifecycleDispatchHelper", "Lcom/baidu/searchbox/video/linkageflow/container/LifecycleDispatchHelper;", "getLifecycleDispatchHelper", "()Lcom/baidu/searchbox/video/linkageflow/container/LifecycleDispatchHelper;", "lifecycleDispatchHelper$delegate", "Lkotlin/Lazy;", "manager", "Lcom/baidu/searchbox/video/linkageflow/container/LinkageContainerManager;", "getManager", "()Lcom/baidu/searchbox/video/linkageflow/container/LinkageContainerManager;", "setManager", "(Lcom/baidu/searchbox/video/linkageflow/container/LinkageContainerManager;)V", "position", "", "addLifecycleObserver", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "canSlideDefaultFinish", "event", "Landroid/view/MotionEvent;", "canSlideDrawer", "canSlideFinish", "canSupportPinchSummary", "Lcom/baidu/searchbox/pinchsummary/model/PinchSummaryEntity;", "createView", "Lcom/baidu/searchbox/video/linkageflow/container/LinkageItemView;", "getLifeCycle", "getPinchSummaryData", "onPinchSummaryDataSourceCallback", "Lcom/baidu/searchbox/pinchsummary/interfaces/OnPinchSummaryDataSourceCallback;", "initLifecycleDispatchHelper", "injectManager", "injectService", "isCanScrollToNext", "isCanScrollToPrev", "isInterceptScroll", "ev", "onAttachToScreen", "onAttachToViewTree", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onDetachFromScreen", "onDetachFromViewTree", "onDispatchTouchEvent", "onDragScrollToNext", "isDragToNext", "onDrawerClosed", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlideBegin", "onEventNotify", "Lcom/baidu/searchbox/video/linkageflow/container/event/LinkageEvent;", "onFinish", "isSlideFinish", "onFinishDragBegin", "onFinishDragReset", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "Landroid/content/Intent;", "onNightModeChanged", "isNightMode", "onPause", "onResume", "onSelected", "isUpOrLeft", "onStart", "onStop", "onUnSelected", "onWindowFocusChanged", "hasFocus", "slideBackStatistic", "tryDispatchDragToNext", "positionOffset", "", "updatePosition", "linkage-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseLinkageItemContainer.kt */
public abstract class BaseLinkageItemContainer implements ILifecycle {
    private final Context context;
    private boolean isAttachToScreen;
    private boolean isAttachToViewTree;
    private boolean isDragToNextUpcoming;
    private boolean isSelected;
    private final Lazy lifecycleDispatchHelper$delegate = LazyKt.lazy(new BaseLinkageItemContainer$lifecycleDispatchHelper$2(this));
    public LinkageContainerManager manager;
    private int position = -1;

    public abstract LinkageItemView createView();

    public abstract boolean isCanScrollToNext();

    public abstract boolean isCanScrollToPrev();

    public BaseLinkageItemContainer(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LinkageContainerManager getManager() {
        LinkageContainerManager linkageContainerManager = this.manager;
        if (linkageContainerManager != null) {
            return linkageContainerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException(FeedStatisticConstants.UBC_TYPE_PLUS);
        return null;
    }

    public final void setManager(LinkageContainerManager linkageContainerManager) {
        Intrinsics.checkNotNullParameter(linkageContainerManager, "<set-?>");
        this.manager = linkageContainerManager;
    }

    private final LifecycleDispatchHelper getLifecycleDispatchHelper() {
        return (LifecycleDispatchHelper) this.lifecycleDispatchHelper$delegate.getValue();
    }

    public final boolean isAttachToScreen() {
        return this.isAttachToScreen;
    }

    public final boolean isAttachToViewTree() {
        return this.isAttachToViewTree;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    /* access modifiers changed from: private */
    public final LifecycleDispatchHelper initLifecycleDispatchHelper() {
        LifecycleDispatchHelper $this$initLifecycleDispatchHelper_u24lambda_u2d0 = new LifecycleDispatchHelper();
        $this$initLifecycleDispatchHelper_u24lambda_u2d0.getLifecycle().addObserver(this);
        return $this$initLifecycleDispatchHelper_u24lambda_u2d0;
    }

    public final void updatePosition(int position2) {
        this.position = position2;
        getLifecycleDispatchHelper().updatePosition(position2);
    }

    /* access modifiers changed from: protected */
    public final Lifecycle getLifeCycle() {
        return getLifecycleDispatchHelper().getLifecycle();
    }

    public void injectManager(LinkageContainerManager manager2) {
        Intrinsics.checkNotNullParameter(manager2, FeedStatisticConstants.UBC_TYPE_PLUS);
        setManager(manager2);
        manager2.addLinkageContainerListener(new BaseLinkageItemContainer$injectManager$1(this));
    }

    public void injectService() {
    }

    /* access modifiers changed from: private */
    public final void tryDispatchDragToNext(int position2, float positionOffset) {
        if (this.isSelected && getManager().getScrollState() == 1 && getManager().getCurrentItem() == position2 && ((double) positionOffset) > 0.5d && positionOffset < 1.0f && !this.isDragToNextUpcoming) {
            this.isDragToNextUpcoming = true;
            onDragScrollToNext(true);
        } else if (this.isDragToNextUpcoming && ((double) positionOffset) <= 0.5d) {
            this.isDragToNextUpcoming = false;
            onDragScrollToNext(false);
        }
    }

    public void onDragScrollToNext(boolean isDragToNext) {
    }

    public void onAttachToScreen() {
        this.isAttachToScreen = true;
    }

    public void onDetachFromScreen() {
        this.isAttachToScreen = false;
    }

    public void onSelected(boolean isUpOrLeft) {
        this.isSelected = true;
        getLifecycleDispatchHelper().setSelected(true);
    }

    public void onUnSelected() {
        this.isSelected = false;
        this.isDragToNextUpcoming = false;
        getLifecycleDispatchHelper().setSelected(false);
    }

    public void onAttachToViewTree() {
        this.isAttachToViewTree = true;
        getLifecycleDispatchHelper().beginLifecycle();
    }

    public void onDetachFromViewTree() {
        this.isAttachToViewTree = false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    public void onNightModeChanged(boolean isNightMode) {
    }

    public boolean canSlideDefaultFinish(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    public boolean canSlideFinish(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    public boolean canSlideDrawer(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    public void onFinishDragBegin() {
    }

    public void onFinishDragReset() {
    }

    public void onFinish(boolean isSlideFinish) {
    }

    public void onBackPressed() {
    }

    public void slideBackStatistic() {
    }

    public void onWindowFocusChanged(boolean hasFocus) {
    }

    public void onDrawerSlideBegin(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
    }

    public void onDrawerOpened(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
    }

    public void onDrawerClosed(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
    }

    public void onDispatchTouchEvent(MotionEvent ev) {
    }

    public void onEventNotify(LinkageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public boolean isInterceptScroll(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return false;
    }

    public final void addLifecycleObserver(Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        lifecycle.addObserver(getLifecycleDispatchHelper());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

    public PinchSummaryEntity canSupportPinchSummary() {
        return null;
    }

    public void getPinchSummaryData(OnPinchSummaryDataSourceCallback onPinchSummaryDataSourceCallback) {
    }
}
