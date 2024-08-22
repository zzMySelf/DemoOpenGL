package com.baidu.searchbox.feed.ui.banner;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/ui/banner/Banner$innerAdapterDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Banner.kt */
public final class Banner$innerAdapterDataObserver$1 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ Banner<T, BA> this$0;

    Banner$innerAdapterDataObserver$1(Banner<T, BA> $receiver) {
        this.this$0 = $receiver;
    }

    public void onChanged() {
        if (this.this$0.getAdapterItemCount() <= 1) {
            this.this$0.stop();
        }
        this.this$0.setIndicatorPageChange();
    }
}
