package com.baidu.browser.explore.tab.na;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.browser.tabna.SearchTabItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/browser/explore/tab/na/BaseTalosTabContainer$rootView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseTalosTabContainer.kt */
public final class BaseTalosTabContainer$rootView$scrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ BaseTalosTabContainer this$0;

    BaseTalosTabContainer$rootView$scrollListener$1(BaseTalosTabContainer $receiver) {
        this.this$0 = $receiver;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        BaseTalosTabContainer baseTalosTabContainer = this.this$0;
        baseTalosTabContainer.scrollY = baseTalosTabContainer.scrollY + dy;
        IResultPageForTalosDelegate resultPageDelegate = this.this$0.getResultPageDelegate();
        int access$getScrollY$p = this.this$0.scrollY;
        SearchTabItem searchTabItem = this.this$0.mTabItem;
        resultPageDelegate.updateGroupCardWithScrollYChanged(access$getScrollY$p, searchTabItem != null ? searchTabItem.pd : null);
    }
}
