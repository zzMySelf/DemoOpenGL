package com.baidu.searchbox.feed.template.biserial.trending;

import android.view.View;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBiserialTrendingAdapter.kt */
final class TrendingDetailVH$detailIcon$2 extends Lambda implements Function0<FeedDraweeView> {
    final /* synthetic */ View $itemView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendingDetailVH$detailIcon$2(View view2) {
        super(0);
        this.$itemView = view2;
    }

    public final FeedDraweeView invoke() {
        return (FeedDraweeView) this.$itemView.findViewById(R.id.feed_biserial_trending_detail_item_icon);
    }
}
