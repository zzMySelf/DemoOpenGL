package com.baidu.searchbox.feed.base;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/base/IFeedScrollState;", "", "onScroll", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "onScrollIdleState", "lib-feed-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IFeedScrollState.kt */
public interface IFeedScrollState {
    void onScroll(RecyclerView recyclerView, int i2, int i3);

    void onScrollIdleState(RecyclerView recyclerView);
}
