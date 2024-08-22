package com.baidu.searchbox.feed.controller.mutevideo;

import com.baidu.searchbox.feed.controller.mutevideo.BiSerialMuteVideoPlayController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/feed/controller/mutevideo/BiSerialMuteVideoPlayController$ChannelItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialMuteVideoPlayController.kt */
final class BiSerialMuteVideoPlayController$getVideoPlayCount$1 extends Lambda implements Function1<BiSerialMuteVideoPlayController.ChannelItem, Unit> {
    final /* synthetic */ Ref.IntRef $count;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiSerialMuteVideoPlayController$getVideoPlayCount$1(Ref.IntRef intRef) {
        super(1);
        this.$count = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((BiSerialMuteVideoPlayController.ChannelItem) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(BiSerialMuteVideoPlayController.ChannelItem $this$withChannelItem) {
        Intrinsics.checkNotNullParameter($this$withChannelItem, "$this$withChannelItem");
        this.$count.element = $this$withChannelItem.getMuteVideoPlayVids().size();
    }
}
