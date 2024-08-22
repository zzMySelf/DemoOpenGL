package com.baidu.searchbox.feed.template.view.divinecomment;

import com.baidu.searchbox.feed.template.R;
import com.baidu.searchbox.ui.span.BdSpanTouchFixTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ui/span/BdSpanTouchFixTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedDivineCommentView.kt */
final class FeedDivineCommentView$divineCommentContent$2 extends Lambda implements Function0<BdSpanTouchFixTextView> {
    final /* synthetic */ FeedDivineCommentView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDivineCommentView$divineCommentContent$2(FeedDivineCommentView feedDivineCommentView) {
        super(0);
        this.this$0 = feedDivineCommentView;
    }

    public final BdSpanTouchFixTextView invoke() {
        return (BdSpanTouchFixTextView) this.this$0.findViewById(R.id.feed_divine_comment_content);
    }
}
