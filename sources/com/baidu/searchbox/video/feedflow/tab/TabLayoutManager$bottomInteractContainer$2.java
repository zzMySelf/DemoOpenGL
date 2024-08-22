package com.baidu.searchbox.video.feedflow.tab;

import com.baidu.searchbox.video.feedflow.detail.container.BottomInteractAreaContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/container/BottomInteractAreaContainer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabLayoutManager.kt */
final class TabLayoutManager$bottomInteractContainer$2 extends Lambda implements Function0<BottomInteractAreaContainer> {
    final /* synthetic */ TabLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabLayoutManager$bottomInteractContainer$2(TabLayoutManager tabLayoutManager) {
        super(0);
        this.this$0 = tabLayoutManager;
    }

    public final BottomInteractAreaContainer invoke() {
        return new BottomInteractAreaContainer(this.this$0);
    }
}
