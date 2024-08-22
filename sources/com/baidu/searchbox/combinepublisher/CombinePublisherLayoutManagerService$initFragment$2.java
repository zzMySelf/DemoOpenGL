package com.baidu.searchbox.combinepublisher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/combinepublisher/CombinePublisherLayoutManagerService$initFragment$2", "Lcom/baidu/searchbox/combinepublisher/OnSingleTouchListener;", "onSingleTouch", "", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CombinePublisherLayoutManagerService.kt */
public final class CombinePublisherLayoutManagerService$initFragment$2 implements OnSingleTouchListener {
    final /* synthetic */ CombinePublisherLayoutManagerService this$0;

    CombinePublisherLayoutManagerService$initFragment$2(CombinePublisherLayoutManagerService $receiver) {
        this.this$0 = $receiver;
    }

    public void onSingleTouch() {
        this.this$0.dismissBubbleView();
        if (Intrinsics.areEqual((Object) "live", (Object) this.this$0.currentFragmentSimpleName)) {
            this.this$0.hideBottomBar();
        }
    }
}
