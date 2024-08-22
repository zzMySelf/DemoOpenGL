package com.baidu.chatsearch.fusion.sidebar;

import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/baidu/chatsearch/fusion/sidebar/FusionSideBarView$2$1", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "", "lib-chatsearch-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FusionSideBarView.kt */
public final class FusionSideBarView$2$1 extends RecyclerView.SimpleOnItemTouchListener {
    final /* synthetic */ FusionSideBarView this$0;

    FusionSideBarView$2$1(FusionSideBarView $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e2) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e2, "e");
        if (AppConfig.isDebug()) {
            Log.d("FusionSideBarView", "agentList onInterceptTouchEvent event: " + e2);
        }
        this.this$0.handleTouchEvent(e2);
        if (AppConfig.isDebug()) {
            Log.d("FusionSideBarView", "agentList onInterceptTouchEvent needInterceptTouch: " + this.this$0.needInterceptTouch);
        }
        return this.this$0.needInterceptTouch;
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e2) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e2, "e");
        if (AppConfig.isDebug()) {
            Log.d("FusionSideBarView", "agentList onTouchEvent event: " + e2);
        }
        this.this$0.handleTouchEvent(e2);
    }
}
