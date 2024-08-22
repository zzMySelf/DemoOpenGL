package com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.flow.collection.view.collectionpages.CollectionPagesAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/ShortPlayListView$initScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayListView.kt */
public final class ShortPlayListView$initScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ShortPlayListView this$0;

    ShortPlayListView$initScrollListener$1(ShortPlayListView $receiver) {
        this.this$0 = $receiver;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (this.this$0.isForcedHideHeaderLoading && this.this$0.shortPlayAdapter.hasPre()) {
            this.this$0.isForcedHideHeaderLoading = false;
            this.this$0.shortPlayAdapter.setLoading(true);
        }
        ShortPlayListView shortPlayListView = this.this$0;
        shortPlayListView.scrollStateChange(false, shortPlayListView.dy);
        switch (newState) {
            case 0:
                this.this$0.dy = 0;
                OnRecyclerScrollListener onRecyclerScrollListener = this.this$0.getOnRecyclerScrollListener();
                if (onRecyclerScrollListener != null) {
                    onRecyclerScrollListener.onRecyclerScrollEnd();
                    return;
                }
                return;
            case 1:
                OnRecyclerScrollListener onRecyclerScrollListener2 = this.this$0.getOnRecyclerScrollListener();
                if (onRecyclerScrollListener2 != null) {
                    onRecyclerScrollListener2.onRecyclerScrollStart();
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
        recyclerView.setNestedScrollingEnabled(!this.this$0.shortPlayAdapter.hasPre());
        ShortPlayListView shortPlayListView = this.this$0;
        shortPlayListView.dy = shortPlayListView.dy + dy;
        int fPosition = this.this$0.getLinearLayoutManager().findFirstVisibleItemPosition();
        int lPosition = this.this$0.getLinearLayoutManager().findLastVisibleItemPosition();
        int realFirstVideoPos = this.this$0.shortPlayAdapter.hasPre() ? fPosition - 1 : fPosition;
        int realLastVideoPos = this.this$0.shortPlayAdapter.hasPre() ? lPosition - 1 : lPosition;
        int realVideoItemCount = this.this$0.shortPlayAdapter.getVideoListCount();
        OnItemsShowingListener onItemsShowingListener = this.this$0.getOnItemsShowingListener();
        if (onItemsShowingListener != null) {
            onItemsShowingListener.onItemsShowing(realVideoItemCount, RangesKt.coerceAtLeast(realFirstVideoPos, 0), RangesKt.coerceAtLeast(realLastVideoPos, 0));
        }
        int fCompletelyPosition = this.this$0.getLinearLayoutManager().findFirstCompletelyVisibleItemPosition();
        int lCompletelyPosition = this.this$0.getLinearLayoutManager().findLastCompletelyVisibleItemPosition();
        Integer num = null;
        if (this.this$0.shortPlayAdapter.getItemViewsType(fCompletelyPosition) == 3 && this.this$0.shortPlayAdapter.getItemViewsType(lCompletelyPosition) == 2) {
            CollectionPagesAdapter pageAdapter = this.this$0.getPageAdapter();
            if (pageAdapter != null) {
                num = Integer.valueOf(pageAdapter.getItemCount());
            }
            this.this$0.tryScrollPageToPosition(BdPlayerUtils.orZero(num) - 1);
        } else if (this.this$0.shortPlayAdapter.getItemViewsType(fCompletelyPosition) == 1 && this.this$0.shortPlayAdapter.getItemViewsType(lCompletelyPosition) == 2) {
            CollectionPagesAdapter pageAdapter2 = this.this$0.getPageAdapter();
            if (pageAdapter2 != null) {
                num = Integer.valueOf(pageAdapter2.getItemCount());
            }
            this.this$0.tryScrollPageToPosition(BdPlayerUtils.orZero(num) - 2);
        } else {
            ShortPlayListView shortPlayListView2 = this.this$0;
            shortPlayListView2.pageViewLinkageScroll(shortPlayListView2.getRealSets(fCompletelyPosition), this.this$0.getRealSets(lCompletelyPosition));
        }
    }
}
