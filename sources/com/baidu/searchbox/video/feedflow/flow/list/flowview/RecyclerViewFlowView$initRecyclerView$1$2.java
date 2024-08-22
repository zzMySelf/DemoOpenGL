package com.baidu.searchbox.video.feedflow.flow.list.flowview;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.video.widget.viewpager2.OnScrollChangedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/list/flowview/RecyclerViewFlowView$initRecyclerView$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecyclerViewFlowView.kt */
public final class RecyclerViewFlowView$initRecyclerView$1$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ RecyclerViewFlowView this$0;

    RecyclerViewFlowView$initRecyclerView$1$2(RecyclerViewFlowView $receiver) {
        this.this$0 = $receiver;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerViewFlowView recyclerViewFlowView = this.this$0;
        for (OnScrollChangedListener listener : this.this$0.onScrollChangedListenerList) {
            listener.onScrollStateChanged(newState, recyclerViewFlowView.draggingDirection);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.this$0.onScrolled(recyclerView, dx, dy);
    }
}
