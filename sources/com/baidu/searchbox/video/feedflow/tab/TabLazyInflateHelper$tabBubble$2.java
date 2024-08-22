package com.baidu.searchbox.video.feedflow.tab;

import com.baidu.searchbox.video.feedflow.common.downgrade.LazyInflateWrap;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.tabguide.TabBubbleState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateWrap;", "Lcom/baidu/searchbox/video/feedflow/detail/tabguide/TabBubbleState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabLazyInflateHelper.kt */
final class TabLazyInflateHelper$tabBubble$2 extends Lambda implements Function0<LazyInflateWrap<TabBubbleState>> {
    final /* synthetic */ TabLazyInflateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabLazyInflateHelper$tabBubble$2(TabLazyInflateHelper tabLazyInflateHelper) {
        super(0);
        this.this$0 = tabLazyInflateHelper;
    }

    public final LazyInflateWrap<TabBubbleState> invoke() {
        return new LazyInflateWrap<>(this.this$0.inflateHelper, TabBubbleState.class, "flow_video_tab_bubble", R.id.video_flow_tab_guide);
    }
}
