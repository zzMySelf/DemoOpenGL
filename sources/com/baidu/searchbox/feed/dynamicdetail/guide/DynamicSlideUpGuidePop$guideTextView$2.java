package com.baidu.searchbox.feed.dynamicdetail.guide;

import com.baidu.searchbox.feed.dynamicdetail.R;
import com.baidu.searchbox.feed.flow.util.AdjustableTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/flow/util/AdjustableTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicSlideUpGuidePop.kt */
final class DynamicSlideUpGuidePop$guideTextView$2 extends Lambda implements Function0<AdjustableTextView> {
    final /* synthetic */ DynamicSlideUpGuidePop this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DynamicSlideUpGuidePop$guideTextView$2(DynamicSlideUpGuidePop dynamicSlideUpGuidePop) {
        super(0);
        this.this$0 = dynamicSlideUpGuidePop;
    }

    public final AdjustableTextView invoke() {
        return (AdjustableTextView) this.this$0.getRootView().findViewById(R.id.guide_text);
    }
}
