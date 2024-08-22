package com.baidu.searchbox.video.collectionflow.detail.lazy;

import com.baidu.searchbox.video.feedflow.common.downgrade.LazyInflateWrap;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.rumor.RumorState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateWrap;", "Lcom/baidu/searchbox/video/feedflow/detail/rumor/RumorState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondaryPageVideoItemLazyInflateHelper.kt */
final class SecondaryPageVideoItemLazyInflateHelper$rumorHolder$2 extends Lambda implements Function0<LazyInflateWrap<RumorState>> {
    final /* synthetic */ SecondaryPageVideoItemLazyInflateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondaryPageVideoItemLazyInflateHelper$rumorHolder$2(SecondaryPageVideoItemLazyInflateHelper secondaryPageVideoItemLazyInflateHelper) {
        super(0);
        this.this$0 = secondaryPageVideoItemLazyInflateHelper;
    }

    public final LazyInflateWrap<RumorState> invoke() {
        return new LazyInflateWrap<>(this.this$0.inflateHelper, RumorState.class, "video_flow_rumor", R.id.video_flow_cmp_rumor);
    }
}
