package com.baidu.searchbox.video.feedflow.tab.hot.tophotlist;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/video/feedflow/tab/hot/tophotlist/HotTopListView$initScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotTopListView.kt */
public final class HotTopListView$initScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ HotTopListView this$0;

    HotTopListView$initScrollListener$1(HotTopListView $receiver) {
        this.this$0 = $receiver;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        switch (newState) {
            case 0:
                HotTopListView.IRecycleViewListener recyclerViewListener = this.this$0.getRecyclerViewListener();
                if (recyclerViewListener != null) {
                    recyclerViewListener.onRecyclerScrollEnd();
                    return;
                }
                return;
            case 1:
                HotTopListView.IRecycleViewListener recyclerViewListener2 = this.this$0.getRecyclerViewListener();
                if (recyclerViewListener2 != null) {
                    recyclerViewListener2.onRecyclerScrollStart();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        HotTopListView.IRecycleViewListener recyclerViewListener = this.this$0.getRecyclerViewListener();
        if (recyclerViewListener != null) {
            recyclerViewListener.onItemsShowing(this.this$0.findFirstVisibleItemPosition(), this.this$0.findLastVisibleItemPosition());
        }
    }
}
