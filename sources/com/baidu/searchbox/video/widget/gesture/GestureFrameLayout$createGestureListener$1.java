package com.baidu.searchbox.video.widget.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.video.widget.gesture.GestureFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/video/widget/gesture/GestureFrameLayout$createGestureListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "event", "Landroid/view/MotionEvent;", "onLongPress", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapConfirmed", "lib-video-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GestureFrameLayout.kt */
public final class GestureFrameLayout$createGestureListener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ GestureFrameLayout this$0;

    GestureFrameLayout$createGestureListener$1(GestureFrameLayout $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onSingleTapConfirmed(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GestureFrameLayout.GestureListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p == null) {
            return true;
        }
        access$getListener$p.onSingleTapConfirmed(event);
        return true;
    }

    public boolean onDoubleTap(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GestureFrameLayout.GestureListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p == null) {
            return true;
        }
        access$getListener$p.onDoubleTap(event);
        return true;
    }

    public void onLongPress(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GestureFrameLayout.GestureListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onLongPress(event);
        }
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Intrinsics.checkNotNullParameter(e2, Config.SESSTION_TRACK_END_TIME);
        GestureFrameLayout.GestureListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            return access$getListener$p.onScroll(distanceX, distanceY);
        }
        return false;
    }
}
