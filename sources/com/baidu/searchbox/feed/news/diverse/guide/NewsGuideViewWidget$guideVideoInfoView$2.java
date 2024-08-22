package com.baidu.searchbox.feed.news.diverse.guide;

import com.baidu.searchbox.feed.news.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/news/diverse/guide/NewsGuideWithInfoView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewsGuideViewWidget.kt */
final class NewsGuideViewWidget$guideVideoInfoView$2 extends Lambda implements Function0<NewsGuideWithInfoView> {
    final /* synthetic */ NewsGuideViewWidget this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewsGuideViewWidget$guideVideoInfoView$2(NewsGuideViewWidget newsGuideViewWidget) {
        super(0);
        this.this$0 = newsGuideViewWidget;
    }

    public final NewsGuideWithInfoView invoke() {
        return (NewsGuideWithInfoView) this.this$0.findViewById(R.id.feed_push_guide_view_with_info);
    }
}
