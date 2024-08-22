package com.baidu.searchbox.video.feedflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0014B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/FlowGestureContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "seekBarCallbackListener", "Lcom/baidu/searchbox/video/feedflow/view/FlowGestureContainer$SeekBarCallbackListener;", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "setSeekBarCallback", "", "callback", "SeekBarCallbackListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowGestureContainer.kt */
public class FlowGestureContainer extends FrameLayout {
    private SeekBarCallbackListener seekBarCallbackListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/FlowGestureContainer$SeekBarCallbackListener;", "", "seekBarNeedConsume", "", "ev", "Landroid/view/MotionEvent;", "seekBarTouchEvent", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowGestureContainer.kt */
    public interface SeekBarCallbackListener {
        boolean seekBarNeedConsume(MotionEvent motionEvent);

        boolean seekBarTouchEvent(MotionEvent motionEvent);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlowGestureContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlowGestureContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowGestureContainer(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowGestureContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 2) {
            SeekBarCallbackListener seekBarCallbackListener2 = this.seekBarCallbackListener;
            boolean z = false;
            if (seekBarCallbackListener2 != null && seekBarCallbackListener2.seekBarNeedConsume(event)) {
                z = true;
            }
            if (z) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SeekBarCallbackListener seekBarCallbackListener2 = this.seekBarCallbackListener;
        return seekBarCallbackListener2 != null && seekBarCallbackListener2.seekBarNeedConsume(event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        SeekBarCallbackListener seekBarCallbackListener2;
        Intrinsics.checkNotNullParameter(event, "event");
        SeekBarCallbackListener seekBarCallbackListener3 = this.seekBarCallbackListener;
        boolean z = true;
        if (seekBarCallbackListener3 == null || !seekBarCallbackListener3.seekBarNeedConsume(event)) {
            z = false;
        }
        if (z && (seekBarCallbackListener2 = this.seekBarCallbackListener) != null) {
            return seekBarCallbackListener2.seekBarTouchEvent(event);
        }
        return false;
    }

    public final void setSeekBarCallback(SeekBarCallbackListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.seekBarCallbackListener = callback;
    }
}
