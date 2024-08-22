package com.baidu.searchbox.lightbrowser.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.lightbrowser.LightBrowserRuntime;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 :2\u00020\u0001:\u0003:;<B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0019H\u0016J\u0010\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0019H\u0017J\u000e\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u0007J\u0010\u00109\u001a\u0002012\u0006\u00108\u001a\u00020\u0007H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'XD¢\u0006\u0002\n\u0000R#\u0010(\u001a\n **\u0004\u0018\u00010)0)8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgContainer", "Lcom/baidu/searchbox/lightbrowser/panel/CornerRelativeLayout;", "getBgContainer", "()Lcom/baidu/searchbox/lightbrowser/panel/CornerRelativeLayout;", "bgContainer$delegate", "Lkotlin/Lazy;", "childNeedIntercept", "", "dragCallback", "Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView$DragCallback;", "getDragCallback", "()Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView$DragCallback;", "setDragCallback", "(Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView$DragCallback;)V", "dragInterceptor", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getDragInterceptor", "()Lkotlin/jvm/functions/Function1;", "setDragInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "fullScreenMargin", "isEnableDrag", "()Z", "setEnableDrag", "(Z)V", "isSlideToRight", "minimumFlingVelocity", "", "tag", "", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "kotlin.jvm.PlatformType", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "viewDragHelper$delegate", "x", "y", "computeScroll", "", "isDragging", "onInterceptTouchEvent", "ev", "onTouchEvent", "event", "setTopMargin", "topMargin", "updateContainerPosition", "Companion", "DragCallback", "ViewDragCallback", "lib-lightbrowser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PopupPanelRootView.kt */
public final class PopupPanelRootView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATE_FULL = 2;
    public static final int STATE_HALF = 1;
    public static final int STATE_HIDE = 0;
    private final Lazy bgContainer$delegate;
    private boolean childNeedIntercept;
    private DragCallback dragCallback;
    private Function1<? super MotionEvent, Boolean> dragInterceptor;
    /* access modifiers changed from: private */
    public int fullScreenMargin;
    private boolean isEnableDrag;
    /* access modifiers changed from: private */
    public boolean isSlideToRight;
    /* access modifiers changed from: private */
    public final float minimumFlingVelocity;
    private final String tag;
    private final Lazy viewDragHelper$delegate;
    private float x;
    private float y;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView$DragCallback;", "", "onDragPositionChanged", "", "top", "", "viewDragState", "state", "onDragToBottom", "onDragToFullScreen", "onDragToHalfScreen", "lib-lightbrowser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PopupPanelRootView.kt */
    public interface DragCallback {
        void onDragPositionChanged(int i2, int i3, int i4);

        void onDragToBottom();

        void onDragToFullScreen();

        void onDragToHalfScreen();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PopupPanelRootView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PopupPanelRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PopupPanelRootView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PopupPanelRootView(Context context, AttributeSet attrs, int def) {
        super(context, attrs, def);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewDragHelper$delegate = LazyKt.lazy(new PopupPanelRootView$viewDragHelper$2(this));
        this.minimumFlingVelocity = (float) DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 800.0f);
        this.tag = "PopupPanelRootView";
        this.bgContainer$delegate = LazyKt.lazy(new PopupPanelRootView$bgContainer$2(this));
    }

    /* access modifiers changed from: private */
    public final ViewDragHelper getViewDragHelper() {
        return (ViewDragHelper) this.viewDragHelper$delegate.getValue();
    }

    public final DragCallback getDragCallback() {
        return this.dragCallback;
    }

    public final void setDragCallback(DragCallback dragCallback2) {
        this.dragCallback = dragCallback2;
    }

    public final Function1<MotionEvent, Boolean> getDragInterceptor() {
        return this.dragInterceptor;
    }

    public final void setDragInterceptor(Function1<? super MotionEvent, Boolean> function1) {
        this.dragInterceptor = function1;
    }

    public final boolean isEnableDrag() {
        return this.isEnableDrag;
    }

    public final void setEnableDrag(boolean z) {
        this.isEnableDrag = z;
    }

    /* access modifiers changed from: private */
    public final CornerRelativeLayout getBgContainer() {
        Object value = this.bgContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bgContainer>(...)");
        return (CornerRelativeLayout) value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView$Companion;", "", "()V", "STATE_FULL", "", "STATE_HALF", "STATE_HIDE", "lib-lightbrowser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PopupPanelRootView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.isEnableDrag) {
            return super.onInterceptTouchEvent(ev);
        }
        if (isDragging()) {
            return true;
        }
        switch (ev.getAction()) {
            case 0:
            case 5:
                this.x = ev.getRawX();
                this.y = ev.getRawY();
                Function1<? super MotionEvent, Boolean> function1 = this.dragInterceptor;
                this.childNeedIntercept = function1 != null ? function1.invoke(ev).booleanValue() : false;
                break;
            case 1:
            case 3:
                this.isSlideToRight = false;
                Function1<? super MotionEvent, Boolean> function12 = this.dragInterceptor;
                if (function12 != null) {
                    Boolean invoke = function12.invoke(ev);
                }
                this.childNeedIntercept = false;
                break;
            case 2:
                if (!this.childNeedIntercept) {
                    Function1<? super MotionEvent, Boolean> function13 = this.dragInterceptor;
                    this.childNeedIntercept = function13 != null ? function13.invoke(ev).booleanValue() : false;
                }
                float moveX = ev.getRawX();
                float moveY = ev.getRawY();
                float deltaX = moveX - this.x;
                float deltaY = moveY - this.y;
                int touchSlop = ViewConfiguration.get(LightBrowserRuntime.getAppContext()).getScaledTouchSlop();
                if (!this.childNeedIntercept && deltaX > 0.0f && Math.abs(deltaX) > ((float) touchSlop) && Math.abs(deltaX) > Math.abs(deltaY)) {
                    this.isSlideToRight = true;
                }
                this.x = moveX;
                this.y = moveY;
                break;
        }
        if (this.childNeedIntercept) {
            return super.onInterceptTouchEvent(ev);
        }
        boolean shouldInterceptTouchEvent = getViewDragHelper().shouldInterceptTouchEvent(ev);
        if (this.isSlideToRight || shouldInterceptTouchEvent) {
            return true;
        }
        return false;
    }

    private final boolean isDragging() {
        return getViewDragHelper().getViewDragState() == 1;
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        switch (event.getAction()) {
            case 1:
            case 3:
                this.isSlideToRight = false;
                break;
        }
        if (!this.isEnableDrag || !isDragging()) {
            return super.onTouchEvent(event);
        }
        getViewDragHelper().processTouchEvent(event);
        return true;
    }

    public void computeScroll() {
        if (getViewDragHelper().continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void setTopMargin(int topMargin) {
        this.fullScreenMargin = topMargin;
        updateContainerPosition(topMargin);
    }

    /* access modifiers changed from: private */
    public final void updateContainerPosition(int topMargin) {
        ViewGroup.LayoutParams layoutParams = getBgContainer().getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            layoutParams2.topMargin = topMargin;
            layoutParams2.bottomMargin = -topMargin;
            getBgContainer().setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J0\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0016¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView$ViewDragCallback;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "(Lcom/baidu/searchbox/lightbrowser/panel/PopupPanelRootView;)V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "getViewHorizontalDragRange", "getViewVerticalDragRange", "moveToFullScreen", "", "moveToHalfScreen", "onViewPositionChanged", "changedView", "onViewReleased", "releasedChild", "xvel", "", "yvel", "tryCaptureView", "", "pointerId", "lib-lightbrowser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PopupPanelRootView.kt */
    public final class ViewDragCallback extends ViewDragHelper.Callback {
        public ViewDragCallback() {
        }

        public boolean tryCaptureView(View child, int pointerId) {
            Intrinsics.checkNotNullParameter(child, "child");
            return PopupPanelRootView.this.isEnableDrag();
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            Intrinsics.checkNotNullParameter(child, "child");
            return Math.max(0, top);
        }

        public int getViewVerticalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            return PopupPanelRootView.this.getHeight();
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (!PopupPanelRootView.this.isSlideToRight) {
                return 0;
            }
            float distance = (float) dx;
            int height = PopupPanelRootView.this.getHeight();
            int width = PopupPanelRootView.this.getWidth();
            if (width > 0 && height > 0) {
                distance *= ((float) height) / (((float) width) * 1.0f);
            }
            if (distance < 0.0f && Math.abs(distance) > ((float) child.getTop())) {
                distance = -((float) child.getTop());
            }
            child.offsetTopAndBottom((int) distance);
            return 0;
        }

        public int getViewHorizontalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (PopupPanelRootView.this.isSlideToRight) {
                return PopupPanelRootView.this.getWidth();
            }
            return 0;
        }

        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            if (yvel > PopupPanelRootView.this.minimumFlingVelocity) {
                DragCallback dragCallback = PopupPanelRootView.this.getDragCallback();
                if (dragCallback != null) {
                    dragCallback.onDragToBottom();
                    return;
                }
                return;
            }
            if (releasedChild.getTop() < PopupPanelRootView.this.fullScreenMargin / 2) {
                moveToFullScreen();
            } else if (releasedChild.getTop() <= PopupPanelRootView.this.fullScreenMargin / 2 || releasedChild.getTop() >= PopupPanelRootView.this.fullScreenMargin + (PopupPanelRootView.this.getHeight() / 4)) {
                DragCallback dragCallback2 = PopupPanelRootView.this.getDragCallback();
                if (dragCallback2 != null) {
                    dragCallback2.onDragToBottom();
                }
            } else {
                moveToHalfScreen();
            }
            PopupPanelRootView.this.invalidate();
        }

        private final void moveToFullScreen() {
            PopupPanelRootView.this.getViewDragHelper().settleCapturedViewAt(0, 0);
            DragCallback dragCallback = PopupPanelRootView.this.getDragCallback();
            if (dragCallback != null) {
                dragCallback.onDragToFullScreen();
            }
            PopupPanelRootView.this.updateContainerPosition(0);
        }

        private final void moveToHalfScreen() {
            PopupPanelRootView popupPanelRootView = PopupPanelRootView.this;
            popupPanelRootView.updateContainerPosition(popupPanelRootView.fullScreenMargin);
            PopupPanelRootView.this.getViewDragHelper().settleCapturedViewAt(0, PopupPanelRootView.this.fullScreenMargin);
            DragCallback dragCallback = PopupPanelRootView.this.getDragCallback();
            if (dragCallback != null) {
                dragCallback.onDragToHalfScreen();
            }
        }

        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            Intrinsics.checkNotNullParameter(changedView, "changedView");
            super.onViewPositionChanged(changedView, left, top, dx, dy);
            if (changedView.getTop() < PopupPanelRootView.this.fullScreenMargin) {
                PopupPanelRootView.this.getBgContainer().updateTopCorner(((float) changedView.getTop()) / ((float) PopupPanelRootView.this.fullScreenMargin));
            } else {
                PopupPanelRootView.this.getBgContainer().updateTopCorner(1.0f);
            }
            int i2 = 2;
            if (changedView.getTop() > PopupPanelRootView.this.fullScreenMargin / 2) {
                if (changedView.getTop() <= PopupPanelRootView.this.fullScreenMargin / 2 || changedView.getTop() > PopupPanelRootView.this.fullScreenMargin + (PopupPanelRootView.this.getHeight() / 4)) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
            }
            int state = i2;
            DragCallback dragCallback = PopupPanelRootView.this.getDragCallback();
            if (dragCallback != null) {
                dragCallback.onDragPositionChanged(top, PopupPanelRootView.this.getViewDragHelper().getViewDragState(), state);
            }
        }
    }
}
