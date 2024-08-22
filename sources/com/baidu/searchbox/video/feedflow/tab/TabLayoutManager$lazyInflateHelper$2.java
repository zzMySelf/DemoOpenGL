package com.baidu.searchbox.video.feedflow.tab;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/tab/TabLazyInflateHelper;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabLayoutManager.kt */
final class TabLayoutManager$lazyInflateHelper$2 extends Lambda implements Function0<TabLazyInflateHelper> {
    final /* synthetic */ TabLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabLayoutManager$lazyInflateHelper$2(TabLayoutManager tabLayoutManager) {
        super(0);
        this.this$0 = tabLayoutManager;
    }

    public final TabLazyInflateHelper invoke() {
        TabLayoutManager tabLayoutManager = this.this$0;
        return new TabLazyInflateHelper(tabLayoutManager, tabLayoutManager.getManager());
    }
}
