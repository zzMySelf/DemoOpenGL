package com.baidu.searchbox.video.feedflow.detail.ocrsummary.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001 B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u0006\u0010\u001f\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/listview/OcrSummaryScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "downY", "iSingleSlideListener", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/listview/OcrSummaryScrollView$ISingleSlideListener;", "getISingleSlideListener", "()Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/listview/OcrSummaryScrollView$ISingleSlideListener;", "setISingleSlideListener", "(Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/listview/OcrSummaryScrollView$ISingleSlideListener;)V", "isScrollUserVisible", "", "isSingleSlide", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onScrollChanged", "", "l", "t", "oldl", "oldt", "resetScrollUserVisible", "ISingleSlideListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrSummaryScrollView.kt */
public final class OcrSummaryScrollView extends NestedScrollView {
    private float downX;
    private float downY;
    private ISingleSlideListener iSingleSlideListener;
    private boolean isScrollUserVisible;
    private boolean isSingleSlide;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/listview/OcrSummaryScrollView$ISingleSlideListener;", "", "onScroll", "", "singleSlide", "slide", "slideByUser", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OcrSummaryScrollView.kt */
    public interface ISingleSlideListener {
        void onScroll();

        void singleSlide();

        void slide();

        void slideByUser();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OcrSummaryScrollView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OcrSummaryScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OcrSummaryScrollView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OcrSummaryScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final ISingleSlideListener getISingleSlideListener() {
        return this.iSingleSlideListener;
    }

    public final void setISingleSlideListener(ISingleSlideListener iSingleSlideListener2) {
        this.iSingleSlideListener = iSingleSlideListener2;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev != null) {
            MotionEvent motionEvent = ev;
            if (ev.getAction() == 0) {
                this.downX = ev.getRawX();
                this.downY = ev.getRawY();
                this.isSingleSlide = false;
                this.isScrollUserVisible = true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev != null) {
            MotionEvent motionEvent = ev;
            if (ev.getAction() == 2) {
                ISingleSlideListener iSingleSlideListener2 = this.iSingleSlideListener;
                if (iSingleSlideListener2 != null) {
                    iSingleSlideListener2.slideByUser();
                }
                float moveX = ev.getRawX();
                float deltaY = ev.getRawY() - this.downY;
                if (Math.abs(deltaY) > Math.abs(moveX - this.downX) && deltaY < 0.0f && !canScrollVertically(1)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        ISingleSlideListener iSingleSlideListener2;
        super.onScrollChanged(l, t, oldl, oldt);
        if (!this.isSingleSlide && canScrollVertically(-1) && canScrollVertically(1)) {
            ISingleSlideListener iSingleSlideListener3 = this.iSingleSlideListener;
            if (iSingleSlideListener3 != null) {
                iSingleSlideListener3.singleSlide();
            }
            this.isSingleSlide = true;
        }
        ISingleSlideListener iSingleSlideListener4 = this.iSingleSlideListener;
        if (iSingleSlideListener4 != null) {
            iSingleSlideListener4.slide();
        }
        if (this.isScrollUserVisible && (iSingleSlideListener2 = this.iSingleSlideListener) != null) {
            iSingleSlideListener2.onScroll();
        }
    }

    public final void resetScrollUserVisible() {
        this.isScrollUserVisible = false;
    }
}
