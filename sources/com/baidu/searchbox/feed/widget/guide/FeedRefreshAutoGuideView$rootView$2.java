package com.baidu.searchbox.feed.widget.guide;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.core.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedRefreshAutoGuideView.kt */
final class FeedRefreshAutoGuideView$rootView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ FeedRefreshAutoGuideView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedRefreshAutoGuideView$rootView$2(FeedRefreshAutoGuideView feedRefreshAutoGuideView) {
        super(0);
        this.this$0 = feedRefreshAutoGuideView;
    }

    public final View invoke() {
        return View.inflate(this.this$0.getContext(), R.layout.feed_refresh_auto_guide_view, (ViewGroup) null);
    }
}
