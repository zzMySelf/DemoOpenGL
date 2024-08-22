package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVoteElement.kt */
final class FlowVoteElement$voteContainer$2 extends Lambda implements Function0<FrameLayout> {
    final /* synthetic */ FlowVoteElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowVoteElement$voteContainer$2(FlowVoteElement flowVoteElement) {
        super(0);
        this.this$0 = flowVoteElement;
    }

    public final FrameLayout invoke() {
        return this.this$0.createView();
    }
}
