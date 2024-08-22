package com.baidu.searchbox.personal.sidebar;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/personal/sidebar/SidebarWindowLayout$showView$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SidebarWindowLayout.kt */
public final class SidebarWindowLayout$showView$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SidebarWindowLayout this$0;

    SidebarWindowLayout$showView$1(SidebarWindowLayout $receiver) {
        this.this$0 = $receiver;
    }

    public void onGlobalLayout() {
        this.this$0.showAnimation();
        this.this$0.mMainMenuView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
