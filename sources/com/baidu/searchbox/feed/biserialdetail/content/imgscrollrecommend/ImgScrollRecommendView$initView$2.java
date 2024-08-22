package com.baidu.searchbox.feed.biserialdetail.content.imgscrollrecommend;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.feed.biserialdetail.content.imgscrollrecommend.ubc.UbcStatHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/content/imgscrollrecommend/ImgScrollRecommendView$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImgScrollRecommendView.kt */
public final class ImgScrollRecommendView$initView$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ImgScrollRecommendView this$0;

    ImgScrollRecommendView$initView$2(ImgScrollRecommendView $receiver) {
        this.this$0 = $receiver;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        this.this$0.handleScrolled(recyclerView.getLayoutManager());
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 1) {
            UbcStatHelper access$getUbcStatHelper = this.this$0.getUbcStatHelper();
            ImgScrollRecommendFlow access$getFlowData$p = this.this$0.flowData;
            access$getUbcStatHelper.onUbcItemSlide(access$getFlowData$p != null ? access$getFlowData$p.getUbcConfig() : null);
        }
    }
}
