package com.baidu.searchbox.video.feedflow.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u00018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010+\u001a\u00020*H\u0014J\u0012\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J(\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020*H\u0014J\b\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u0002002\u0006\u00107\u001a\u00020*H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/ScrollTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allowInterceptTouchEventOnHorizontal", "", "getAllowInterceptTouchEventOnHorizontal", "()Z", "setAllowInterceptTouchEventOnHorizontal", "(Z)V", "allowInterceptTouchEventOnScroll", "getAllowInterceptTouchEventOnScroll", "setAllowInterceptTouchEventOnScroll", "edgeTransparentView", "Lcom/baidu/searchbox/video/feedflow/view/EdgeTransparentView;", "getEdgeTransparentView", "()Lcom/baidu/searchbox/video/feedflow/view/EdgeTransparentView;", "setEdgeTransparentView", "(Lcom/baidu/searchbox/video/feedflow/view/EdgeTransparentView;)V", "gestureDetector", "Landroid/view/GestureDetector;", "handler", "Landroid/os/Handler;", "lastEventX", "", "lastEventY", "responseClick", "getResponseClick", "setResponseClick", "scrollBarVisible", "getScrollBarVisible", "setScrollBarVisible", "singleTapUpListener", "Lcom/baidu/searchbox/video/feedflow/view/ScrollTextView$OnSingleTapUpListener;", "getSingleTapUpListener", "()Lcom/baidu/searchbox/video/feedflow/view/ScrollTextView$OnSingleTapUpListener;", "setSingleTapUpListener", "(Lcom/baidu/searchbox/video/feedflow/view/ScrollTextView$OnSingleTapUpListener;)V", "touchSlop", "", "computeVerticalScrollRange", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onScrollChanged", "", "horiz", "vert", "oldHoriz", "oldVert", "performClick", "setVisibility", "visibility", "OnSingleTapUpListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScrollTextView.kt */
public final class ScrollTextView extends AppCompatTextView {
    private boolean allowInterceptTouchEventOnHorizontal;
    private boolean allowInterceptTouchEventOnScroll;
    private EdgeTransparentView edgeTransparentView;
    private final GestureDetector gestureDetector;
    private final Handler handler;
    private float lastEventX;
    private float lastEventY;
    private boolean responseClick;
    private boolean scrollBarVisible;
    private OnSingleTapUpListener singleTapUpListener;
    /* access modifiers changed from: private */
    public int touchSlop;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/ScrollTextView$OnSingleTapUpListener;", "", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScrollTextView.kt */
    public interface OnSingleTapUpListener {
        void onSingleTapUp(MotionEvent motionEvent);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.responseClick = true;
        this.allowInterceptTouchEventOnScroll = true;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.handler = handler2;
        this.gestureDetector = new GestureDetector(context, new ScrollTextView$gestureDetector$1(this), handler2);
        setOnTouchListener(new ScrollTextView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollTextView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final EdgeTransparentView getEdgeTransparentView() {
        return this.edgeTransparentView;
    }

    public final void setEdgeTransparentView(EdgeTransparentView edgeTransparentView2) {
        this.edgeTransparentView = edgeTransparentView2;
    }

    public final boolean getResponseClick() {
        return this.responseClick;
    }

    public final void setResponseClick(boolean z) {
        this.responseClick = z;
    }

    public final boolean getScrollBarVisible() {
        return this.scrollBarVisible;
    }

    public final void setScrollBarVisible(boolean z) {
        this.scrollBarVisible = z;
    }

    public final boolean getAllowInterceptTouchEventOnScroll() {
        return this.allowInterceptTouchEventOnScroll;
    }

    public final void setAllowInterceptTouchEventOnScroll(boolean z) {
        this.allowInterceptTouchEventOnScroll = z;
    }

    public final boolean getAllowInterceptTouchEventOnHorizontal() {
        return this.allowInterceptTouchEventOnHorizontal;
    }

    public final void setAllowInterceptTouchEventOnHorizontal(boolean z) {
        this.allowInterceptTouchEventOnHorizontal = z;
    }

    public final OnSingleTapUpListener getSingleTapUpListener() {
        return this.singleTapUpListener;
    }

    public final void setSingleTapUpListener(OnSingleTapUpListener onSingleTapUpListener) {
        this.singleTapUpListener = onSingleTapUpListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final boolean m7022_init_$lambda0(ScrollTextView this$0, View view2, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            return this$0.gestureDetector.onTouchEvent(event);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public boolean performClick() {
        if (this.responseClick) {
            return super.performClick();
        }
        this.responseClick = true;
        return false;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        float f2;
        int computeVerticalScrollRange = super.computeVerticalScrollRange();
        EdgeTransparentView edgeTransparentView2 = this.edgeTransparentView;
        if (edgeTransparentView2 != null) {
            f2 = edgeTransparentView2.getBottomOffset();
        } else {
            f2 = 0.0f;
        }
        return computeVerticalScrollRange + ((int) f2);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        EdgeTransparentView edgeTransparentView2 = this.edgeTransparentView;
        boolean z = true;
        if (edgeTransparentView2 != null) {
            edgeTransparentView2.setShowTopShadow(this.scrollBarVisible && vert > 0);
        }
        EdgeTransparentView edgeTransparentView3 = this.edgeTransparentView;
        if (edgeTransparentView3 != null) {
            if (!this.scrollBarVisible || !canScrollVertically(0)) {
                z = false;
            }
            edgeTransparentView3.setShowDownShadow(z);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (this.allowInterceptTouchEventOnHorizontal) {
            Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                this.lastEventX = event.getX();
                this.lastEventY = event.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (valueOf != null && valueOf.intValue() == 2) {
                float dx = event.getX() - this.lastEventX;
                float dy = event.getY() - this.lastEventY;
                if (Math.abs(dx) > ((float) this.touchSlop) || Math.abs(dy) > ((float) this.touchSlop)) {
                    if (Math.abs(dx) > Math.abs(dy)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.lastEventX = event.getX();
                    this.lastEventY = event.getY();
                }
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(event);
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        EdgeTransparentView edgeTransparentView2 = this.edgeTransparentView;
        if (edgeTransparentView2 != null) {
            edgeTransparentView2.setVisibility(visibility);
        }
    }
}
