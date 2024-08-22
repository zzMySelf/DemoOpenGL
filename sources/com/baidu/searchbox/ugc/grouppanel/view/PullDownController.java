package com.baidu.searchbox.ugc.grouppanel.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\u00020\u00112\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/ugc/grouppanel/view/PullDownController;", "", "delegateView", "Landroid/view/View;", "(Landroid/view/View;)V", "closeThreshold", "", "getCloseThreshold", "()I", "closeThreshold$delegate", "Lkotlin/Lazy;", "currentY", "", "isInterceptEvent", "", "onPullDownComplete", "Lkotlin/Function0;", "", "originY", "touchThreshold", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "requestDisallowInterceptTouchEvent", "disallowIntercept", "setPullDownComplete", "listener", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PullDownController.kt */
public final class PullDownController {
    private final Lazy closeThreshold$delegate = LazyKt.lazy(new PullDownController$closeThreshold$2(this));
    private float currentY;
    /* access modifiers changed from: private */
    public View delegateView;
    private boolean isInterceptEvent;
    private Function0<Unit> onPullDownComplete;
    private float originY;
    private final int touchThreshold = 5;

    public PullDownController(View delegateView2) {
        Intrinsics.checkNotNullParameter(delegateView2, "delegateView");
        this.delegateView = delegateView2;
    }

    private final int getCloseThreshold() {
        return ((Number) this.closeThreshold$delegate.getValue()).intValue();
    }

    public final void setPullDownComplete(Function0<Unit> listener) {
        this.onPullDownComplete = listener;
    }

    public final boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            this.currentY = 0.0f;
            this.originY = 0.0f;
            this.isInterceptEvent = false;
            getCloseThreshold();
        }
        return false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() != 2 || !this.isInterceptEvent) {
            return false;
        }
        return true;
    }

    public final boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        switch (ev.getAction()) {
            case 1:
                if (!(this.originY == 0.0f)) {
                    if (ev.getRawY() - this.originY <= ((float) getCloseThreshold())) {
                        View view2 = this.delegateView;
                        view2.layout(view2.getLeft(), 0, this.delegateView.getRight(), this.delegateView.getBottom());
                        break;
                    } else {
                        Function0<Unit> function0 = this.onPullDownComplete;
                        if (function0 != null) {
                            function0.invoke();
                            break;
                        }
                    }
                }
                break;
            case 2:
                if (this.currentY == 0.0f) {
                    this.currentY = ev.getRawY();
                    this.originY = ev.getRawY();
                }
                float distanceY = ev.getRawY() - this.currentY;
                if (Math.abs(distanceY) > ((float) this.touchThreshold)) {
                    int top = RangesKt.coerceAtLeast((int) (((float) this.delegateView.getTop()) + distanceY), 0);
                    this.currentY = ev.getRawY();
                    View view3 = this.delegateView;
                    view3.layout(view3.getLeft(), top, this.delegateView.getRight(), this.delegateView.getBottom());
                    break;
                }
                break;
        }
        return true;
    }

    public final void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        this.isInterceptEvent = !disallowIntercept;
    }
}
