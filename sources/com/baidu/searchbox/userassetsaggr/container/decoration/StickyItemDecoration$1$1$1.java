package com.baidu.searchbox.userassetsaggr.container.decoration;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/userassetsaggr/container/decoration/StickyItemDecoration$1$1$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StickyItemDecoration.kt */
public final class StickyItemDecoration$1$1$1 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ StickyItemDecoration this$0;

    StickyItemDecoration$1$1$1(StickyItemDecoration $receiver) {
        this.this$0 = $receiver;
    }

    public void onChanged() {
        this.this$0.clearOldData();
    }

    public void onItemRangeChanged(int positionStart, int itemCount) {
        this.this$0.clearOldData();
    }

    public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
        this.this$0.clearOldData();
    }

    public void onItemRangeInserted(int positionStart, int itemCount) {
        this.this$0.clearOldData();
    }

    public void onItemRangeRemoved(int positionStart, int itemCount) {
        this.this$0.clearOldData();
    }

    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        this.this$0.clearOldData();
    }
}
