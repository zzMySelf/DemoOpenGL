package com.baidu.searchbox.video.feedflow.detail.container;

import android.view.ViewGroup;
import com.baidu.searchbox.feed.detail.lazy.ComponentHolder;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.seekbar.SeekBarState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/lazy/ComponentHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SeekBarPreviewContainer.kt */
final class SeekBarPreviewContainer$previewHolder$2 extends Lambda implements Function0<ComponentHolder> {
    final /* synthetic */ SeekBarPreviewContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekBarPreviewContainer$previewHolder$2(SeekBarPreviewContainer seekBarPreviewContainer) {
        super(0);
        this.this$0 = seekBarPreviewContainer;
    }

    public final ComponentHolder invoke() {
        return this.this$0.getLayoutManager().inflateComponentByLazy("flow_video_preview_component", R.id.video_flow_cmp_preview, SeekBarState.class, (ViewGroup.LayoutParams) null);
    }
}
