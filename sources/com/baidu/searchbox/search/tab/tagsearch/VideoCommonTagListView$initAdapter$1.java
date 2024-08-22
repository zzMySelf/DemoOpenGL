package com.baidu.searchbox.search.tab.tagsearch;

import com.baidu.searchbox.search.tab.tagsearch.VideoCommonTagViewAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/search/tab/tagsearch/VideoCommonTagListView$initAdapter$1", "Lcom/baidu/searchbox/search/tab/tagsearch/VideoCommonTagViewAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonTagListView.kt */
public final class VideoCommonTagListView$initAdapter$1 implements VideoCommonTagViewAdapter.OnItemClickListener {
    final /* synthetic */ VideoCommonTagListView this$0;

    VideoCommonTagListView$initAdapter$1(VideoCommonTagListView $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(int position) {
        this.this$0.tagItemClick(position);
    }
}
