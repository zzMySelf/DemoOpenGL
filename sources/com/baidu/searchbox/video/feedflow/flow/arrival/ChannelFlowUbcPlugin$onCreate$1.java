package com.baidu.searchbox.video.feedflow.flow.arrival;

import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "item", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowUbcPlugin.kt */
final class ChannelFlowUbcPlugin$onCreate$1 extends Lambda implements Function3<Boolean, String, ItemModel<?>, Unit> {
    final /* synthetic */ ChannelFlowUbcPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowUbcPlugin$onCreate$1(ChannelFlowUbcPlugin channelFlowUbcPlugin) {
        super(3);
        this.this$0 = channelFlowUbcPlugin;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke(((Boolean) p1).booleanValue(), (String) p2, (ItemModel<?>) (ItemModel) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, String str, ItemModel<?> item) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        if (item != null) {
            ChannelFlowUbcPlugin channelFlowUbcPlugin = this.this$0;
            ItemModel $this$invoke_u24lambda_u2d0 = item;
            if (!$this$invoke_u24lambda_u2d0.getRunTimeStatus().isReportChannelShow()) {
                $this$invoke_u24lambda_u2d0.getRunTimeStatus().setReportChannelShow(true);
                channelFlowUbcPlugin.uploadSimple5880Statistic($this$invoke_u24lambda_u2d0.getRunTimeStatus().getPosition());
            }
        }
    }
}
