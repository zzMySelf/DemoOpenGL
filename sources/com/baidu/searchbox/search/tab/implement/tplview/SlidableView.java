package com.baidu.searchbox.search.tab.implement.tplview;

import android.widget.HorizontalScrollView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/tplview/SlidableView;", "", "checkSlidable", "", "toRight", "", "getSlidView", "Landroid/widget/HorizontalScrollView;", "isSlidable", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SlidableView.kt */
public interface SlidableView {
    int checkSlidable(boolean z);

    HorizontalScrollView getSlidView();

    boolean isSlidable();
}
