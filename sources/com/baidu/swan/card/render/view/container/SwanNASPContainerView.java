package com.baidu.swan.card.render.view.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.swan.apps.pullrefresh.PullToRefreshBase;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.render.events.ITalosTouchEventRegister;
import com.baidu.talos.core.render.events.TalosEventProcessor;
import com.baidu.talos.core.render.events.TalosTouchEventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00112\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0012\u0010\u001e\u001a\u00020\u00112\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/baidu/swan/card/render/view/container/SwanNASPContainerView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/talos/core/render/events/ITalosTouchEventRegister;", "context", "Lcom/baidu/talos/core/context/TalosPageContext;", "(Lcom/baidu/talos/core/context/TalosPageContext;)V", "mTalosEventProcessor", "Lcom/baidu/talos/core/render/events/TalosEventProcessor;", "measureAndLayout", "Ljava/lang/Runnable;", "touchIntercept", "", "getTouchIntercept", "()Z", "setTouchIntercept", "(Z)V", "checkPullToRefreshViewTouchConflict", "", "disallow", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getTalosEventProcessor", "internalOnInterceptTouchEvent", "onInterceptTouchEvent", "onTouchEvent", "registeEventType", "type", "", "requestLayout", "unregisteEventType", "lib-swan-card_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanNASPContainerView.kt */
public final class SwanNASPContainerView extends FrameLayout implements ITalosTouchEventRegister {
    private TalosEventProcessor mTalosEventProcessor;
    private final Runnable measureAndLayout = new SwanNASPContainerView$$ExternalSyntheticLambda0(this);
    private boolean touchIntercept;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwanNASPContainerView(TalosPageContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean getTouchIntercept() {
        return this.touchIntercept;
    }

    public final void setTouchIntercept(boolean z) {
        this.touchIntercept = z;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.touchIntercept) {
            switch (ev.getAction()) {
                case 0:
                    requestDisallowInterceptTouchEvent(true);
                    checkPullToRefreshViewTouchConflict(true);
                    break;
                case 1:
                case 3:
                    requestDisallowInterceptTouchEvent(false);
                    checkPullToRefreshViewTouchConflict(false);
                    break;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private final void checkPullToRefreshViewTouchConflict(boolean disallow) {
        for (ViewParent root = getParent(); root instanceof ViewGroup; root = root.getParent()) {
            if (root instanceof PullToRefreshBase) {
                ((PullToRefreshBase) root).superRequestDisallowInterceptTouchEvent(disallow);
                return;
            }
        }
    }

    public void registeEventType(@TalosTouchEventType.TouchEventType int type) {
        getTalosEventProcessor().addEventType(type);
    }

    public void unregisteEventType(@TalosTouchEventType.TouchEventType int type) {
        getTalosEventProcessor().removeEventType(type);
    }

    private final TalosEventProcessor getTalosEventProcessor() {
        if (this.mTalosEventProcessor == null) {
            this.mTalosEventProcessor = new TalosEventProcessor();
        }
        TalosEventProcessor talosEventProcessor = this.mTalosEventProcessor;
        if (talosEventProcessor != null) {
            return talosEventProcessor;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.talos.core.render.events.TalosEventProcessor");
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        boolean result = internalOnInterceptTouchEvent(ev);
        TalosEventProcessor it = this.mTalosEventProcessor;
        if (it != null) {
            return result | it.handleOnInterceptEvent(this, ev);
        }
        return result;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = super.onTouchEvent(ev);
        TalosEventProcessor it = this.mTalosEventProcessor;
        if (it != null) {
            return result | it.handleTouchEvent(this, ev);
        }
        return result;
    }

    private final boolean internalOnInterceptTouchEvent(MotionEvent ev) {
        if (super.onInterceptTouchEvent(ev)) {
            return true;
        }
        return false;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* access modifiers changed from: private */
    /* renamed from: measureAndLayout$lambda-2  reason: not valid java name */
    public static final void m8076measureAndLayout$lambda2(SwanNASPContainerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.measure(View.MeasureSpec.makeMeasureSpec(this$0.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this$0.getHeight(), 1073741824));
        this$0.layout(this$0.getLeft(), this$0.getTop(), this$0.getRight(), this$0.getBottom());
    }
}
