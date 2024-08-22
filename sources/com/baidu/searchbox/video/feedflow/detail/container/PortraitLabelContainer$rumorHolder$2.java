package com.baidu.searchbox.video.feedflow.detail.container;

import android.view.ViewGroup;
import com.baidu.searchbox.feed.detail.lazy.ComponentHolder;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.VideoItemLayoutManager;
import com.baidu.searchbox.video.feedflow.detail.rumor.RumorState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/lazy/ComponentHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitLabelContainer.kt */
final class PortraitLabelContainer$rumorHolder$2 extends Lambda implements Function0<ComponentHolder> {
    final /* synthetic */ PortraitLabelContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PortraitLabelContainer$rumorHolder$2(PortraitLabelContainer portraitLabelContainer) {
        super(0);
        this.this$0 = portraitLabelContainer;
    }

    public final ComponentHolder invoke() {
        VideoItemLayoutManager this_$iv = this.this$0.getLayoutManager();
        int viewId$iv = R.id.video_flow_cmp_rumor;
        if (this_$iv.isDegradeInflateOptEnable()) {
            return this_$iv.inflateComponentByLazy("video_flow_rumor", viewId$iv, RumorState.class, (ViewGroup.LayoutParams) null);
        }
        this_$iv.inflateComponentView("video_flow_rumor", viewId$iv);
        ComponentHolder componentHolder = null;
        return null;
    }
}
