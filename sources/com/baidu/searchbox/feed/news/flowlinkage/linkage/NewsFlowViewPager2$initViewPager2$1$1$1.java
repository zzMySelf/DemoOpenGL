package com.baidu.searchbox.feed.news.flowlinkage.linkage;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/news/flowlinkage/linkage/NewsFlowViewPager2$initViewPager2$1$1$1", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewsFlowViewPager2.kt */
public final class NewsFlowViewPager2$initViewPager2$1$1$1 extends RecyclerView.SimpleOnItemTouchListener {
    final /* synthetic */ NewsFlowViewPager2 this$0;

    NewsFlowViewPager2$initViewPager2$1$1$1(NewsFlowViewPager2 $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e2) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e2, "e");
        this.this$0.onInterceptTouchEvent(e2);
        return super.onInterceptTouchEvent(rv, e2);
    }
}
