package com.baidu.searchbox.video.widget.viewpager2;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/video/widget/viewpager2/PrettyViewPager2$initViewPager2$1$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "lib-video-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrettyViewPager2.kt */
public final class PrettyViewPager2$initViewPager2$1$1$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ PrettyViewPager2 this$0;

    PrettyViewPager2$initViewPager2$1$1$2(PrettyViewPager2 $receiver) {
        this.this$0 = $receiver;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.this$0.onPageScrolled(recyclerView.getScrollState(), dx, dy);
    }
}
