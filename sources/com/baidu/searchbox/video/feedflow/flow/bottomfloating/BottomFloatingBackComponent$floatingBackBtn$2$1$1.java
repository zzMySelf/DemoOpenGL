package com.baidu.searchbox.video.feedflow.flow.bottomfloating;

import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.OnBottomBarElementClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/bottomfloating/BottomFloatingBackComponent$floatingBackBtn$2$1$1", "Lcom/baidu/searchbox/unifiedtoolbar/base/OnBottomBarElementClickListener;", "onBottomBarElementClick", "", "context", "Lcom/baidu/searchbox/unifiedtoolbar/base/BarElementClickContext;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomFloatingBackComponent.kt */
public final class BottomFloatingBackComponent$floatingBackBtn$2$1$1 implements OnBottomBarElementClickListener {
    final /* synthetic */ BottomFloatingBackComponent this$0;

    BottomFloatingBackComponent$floatingBackBtn$2$1$1(BottomFloatingBackComponent $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onBottomBarElementClick(BarElementClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.this$0.handleBack();
    }
}
