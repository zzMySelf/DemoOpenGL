package com.baidu.searchbox.feed.template;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.controller.report.BaseReportInfoProcessor;
import com.baidu.searchbox.feed.controller.report.FeedReportInfoProcessor;
import com.baidu.searchbox.feed.controller.report.ReportInfoProcessorFactory;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.model.FeedTplFloatData;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.feed.template.FeedTplVideoFloatView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/template/FeedTplVideoFloatView$VideoListAdapter$onBindViewHolder$1$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTplVideoFloatView.kt */
public final class FeedTplVideoFloatView$VideoListAdapter$onBindViewHolder$1$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    final /* synthetic */ FeedTplFloatData.FloatItemData $itemData;
    final /* synthetic */ FeedTplVideoFloatView.VideoListAdapter.ViewHolder $this_run;
    final /* synthetic */ FeedTplVideoFloatView this$0;

    FeedTplVideoFloatView$VideoListAdapter$onBindViewHolder$1$1(FeedTplVideoFloatView.VideoListAdapter.ViewHolder $receiver, FeedTplFloatData.FloatItemData $itemData2, FeedTplVideoFloatView $receiver2, RecyclerView.ViewHolder $holder2) {
        this.$this_run = $receiver;
        this.$itemData = $itemData2;
        this.this$0 = $receiver2;
        this.$holder = $holder2;
    }

    public boolean onPreDraw() {
        FeedRuntimeStatus feedRuntimeStatus;
        FeedRuntimeStatus feedRuntimeStatus2;
        if (this.$this_run.itemView.getLocalVisibleRect(new Rect())) {
            this.$itemData.hasDisplayed = true;
            this.$itemData.displayTimeMillis = System.currentTimeMillis();
            FeedBaseModel it = this.this$0.feedBaseModel;
            String str = null;
            if (it != null) {
                FeedTplFloatData.FloatItemData floatItemData = this.$itemData;
                FeedTplFloatData $this$onPreDraw_u24lambda_u2d1_u24lambda_u2d0 = it.data.tplFloatData;
                if (!($this$onPreDraw_u24lambda_u2d1_u24lambda_u2d0 instanceof FeedTplFloatData)) {
                    $this$onPreDraw_u24lambda_u2d1_u24lambda_u2d0 = null;
                }
                if ($this$onPreDraw_u24lambda_u2d1_u24lambda_u2d0 != null && !$this$onPreDraw_u24lambda_u2d1_u24lambda_u2d0.getHasDisplayed()) {
                    $this$onPreDraw_u24lambda_u2d1_u24lambda_u2d0.setHasDisplayed(true);
                    $this$onPreDraw_u24lambda_u2d1_u24lambda_u2d0.setDisplayTimeMillis(floatItemData.displayTimeMillis);
                }
                BaseReportInfoProcessor processor = ReportInfoProcessorFactory.getProcessor(it.runtimeStatus.channelId);
                FeedReportInfoProcessor feedReportInfoProcessor = processor instanceof FeedReportInfoProcessor ? (FeedReportInfoProcessor) processor : null;
                if (feedReportInfoProcessor != null) {
                    feedReportInfoProcessor.addTplFloatData(it.data.tplFloatData);
                }
                it.runtimeStatus.isDirty = true;
            }
            FeedBaseModel access$getFeedBaseModel$p = this.this$0.feedBaseModel;
            String str2 = access$getFeedBaseModel$p != null ? access$getFeedBaseModel$p.id : null;
            FeedBaseModel access$getFeedBaseModel$p2 = this.this$0.feedBaseModel;
            String str3 = (access$getFeedBaseModel$p2 == null || (feedRuntimeStatus2 = access$getFeedBaseModel$p2.runtimeStatus) == null) ? null : feedRuntimeStatus2.channelId;
            FeedBaseModel access$getFeedBaseModel$p3 = this.this$0.feedBaseModel;
            if (!(access$getFeedBaseModel$p3 == null || (feedRuntimeStatus = access$getFeedBaseModel$p3.runtimeStatus) == null)) {
                str = Integer.valueOf(feedRuntimeStatus.viewPosition).toString();
            }
            FeedStatisticCenter.ubcVideoSlideInsertChildItemShow(str2, str3, str, FeedStatisticConstants.UBC_POS_ABOVE_AUTOVIDEO, this.$itemData.id, String.valueOf(((FeedTplVideoFloatView.VideoListAdapter.ViewHolder) this.$holder).getAdapterPosition()));
            this.$this_run.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        return true;
    }
}
