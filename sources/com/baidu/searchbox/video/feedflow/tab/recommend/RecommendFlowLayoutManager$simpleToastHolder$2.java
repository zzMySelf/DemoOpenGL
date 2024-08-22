package com.baidu.searchbox.video.feedflow.tab.recommend;

import android.view.ViewGroup;
import com.baidu.searchbox.feed.detail.lazy.ComponentHolder;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.personaltip.PersonalTipState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/lazy/ComponentHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendFlowLayoutManager.kt */
final class RecommendFlowLayoutManager$simpleToastHolder$2 extends Lambda implements Function0<ComponentHolder> {
    final /* synthetic */ RecommendFlowLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecommendFlowLayoutManager$simpleToastHolder$2(RecommendFlowLayoutManager recommendFlowLayoutManager) {
        super(0);
        this.this$0 = recommendFlowLayoutManager;
    }

    public final ComponentHolder invoke() {
        VideoFlowLayoutManager this_$iv = this.this$0;
        int viewId$iv = R.id.video_flow_simple_toast_cmp;
        if (this_$iv.isDegradeInflateOptEnable()) {
            return this_$iv.inflateComponentByLazy("flow_video_simple_toast_component", viewId$iv, PersonalTipState.class, (ViewGroup.LayoutParams) null);
        }
        this_$iv.inflateComponentView("flow_video_simple_toast_component", viewId$iv);
        ComponentHolder componentHolder = null;
        return null;
    }
}
