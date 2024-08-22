package com.baidu.searchbox.video.channel.flow.detail.video;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.video.feedflow.view.SlotFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/view/SlotFrameLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowVideoItemLayoutManager.kt */
final class ChannelFlowVideoItemLayoutManager$landscapePraiseContainer$2 extends Lambda implements Function0<SlotFrameLayout> {
    final /* synthetic */ ChannelFlowVideoItemLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowVideoItemLayoutManager$landscapePraiseContainer$2(ChannelFlowVideoItemLayoutManager channelFlowVideoItemLayoutManager) {
        super(0);
        this.this$0 = channelFlowVideoItemLayoutManager;
    }

    public final SlotFrameLayout invoke() {
        Context context = ChannelFlowVideoItemLayoutManager.access$getContainer(this.this$0).getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        return new SlotFrameLayout(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }
}
