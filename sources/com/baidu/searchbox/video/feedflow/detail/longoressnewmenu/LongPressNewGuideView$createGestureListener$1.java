package com.baidu.searchbox.video.feedflow.detail.longoressnewmenu;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.LongPressNewGuideView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/longoressnewmenu/LongPressNewGuideView$createGestureListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "event", "Landroid/view/MotionEvent;", "onLongPress", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapUp", "e", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressNewGuideView.kt */
public final class LongPressNewGuideView$createGestureListener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ LongPressNewGuideView this$0;

    LongPressNewGuideView$createGestureListener$1(LongPressNewGuideView $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onSingleTapUp(MotionEvent e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        LongPressNewGuideView.ILongPressNewGuideListener iLongPressNewGuideListener = this.this$0.getILongPressNewGuideListener();
        if (iLongPressNewGuideListener == null) {
            return true;
        }
        iLongPressNewGuideListener.singleClick();
        return true;
    }

    public boolean onDoubleTap(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    public void onLongPress(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.this$0.isLongPressing = true;
        this.this$0.longPressDownEvent = event;
        ViewParent parent = this.this$0.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.this$0.deleteLongView();
        this.this$0.deleteMoreView();
        this.this$0.longGuideBgView.setVisibility(8);
        this.this$0.maskView.setVisibility(8);
        LongPressNewGuideView.ILongPressNewGuideListener iLongPressNewGuideListener = this.this$0.getILongPressNewGuideListener();
        if (iLongPressNewGuideListener != null) {
            iLongPressNewGuideListener.longPressStart(event.getRawX(), event.getRawY(), event);
        }
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Intrinsics.checkNotNullParameter(e2, Config.SESSTION_TRACK_END_TIME);
        return false;
    }
}
