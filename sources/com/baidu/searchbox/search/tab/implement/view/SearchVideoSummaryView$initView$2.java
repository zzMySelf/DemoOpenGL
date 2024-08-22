package com.baidu.searchbox.search.tab.implement.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.template.FeedTemplateImpl;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonBigImageModel;
import com.baidu.searchbox.search.tab.implement.view.SummaryAdapter;
import com.baidu.searchbox.search.video.business.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/search/tab/implement/view/SearchVideoSummaryView$initView$2", "Lcom/baidu/searchbox/search/tab/implement/view/SummaryAdapter$IAdapterListener;", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "onItemShow", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonSummaryView.kt */
public final class SearchVideoSummaryView$initView$2 implements SummaryAdapter.IAdapterListener {
    final /* synthetic */ SearchVideoSummaryView this$0;

    SearchVideoSummaryView$initView$2(SearchVideoSummaryView $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(View view2, int pos) {
        this.this$0.itemInvoke(view2, pos);
        if (view2 != null) {
            view2.setTag(R.id.summary_click_pos, Integer.valueOf(pos));
        }
        RecyclerView access$getSummaryRV$p = this.this$0.summaryRV;
        if (access$getSummaryRV$p != null) {
            access$getSummaryRV$p.smoothScrollToPosition(pos);
        }
        this.this$0.setMCurrentIndex(pos);
        FeedTemplateImpl access$getMFeedTemplateImplBase$p = this.this$0.mFeedTemplateImplBase;
        if (access$getMFeedTemplateImplBase$p != null) {
            access$getMFeedTemplateImplBase$p.onClick(view2);
        }
        VideoCommonBigImageModel.VideoSummary access$getSummaryData$p = this.this$0.summaryData;
        if (access$getSummaryData$p != null) {
            VideoCommonBigImageModel.VideoSummary access$getSummaryData$p2 = this.this$0.summaryData;
            access$getSummaryData$p.clickNum = (access$getSummaryData$p2 != null ? Integer.valueOf(access$getSummaryData$p2.clickNum + 1) : null).intValue();
        }
    }

    public void onItemShow(View view2, int pos) {
        if (view2 != null) {
            view2.setTag(R.id.summary_show_pos, Integer.valueOf(pos));
        }
        if (view2 != null) {
            View view3 = view2;
            this.this$0.showSummaryTcReport(view2);
        }
    }
}
