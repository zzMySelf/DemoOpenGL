package com.baidu.searchbox.player.preboot;

import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.message.IMessenger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "messenger", "Lcom/baidu/searchbox/player/message/IMessenger;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelPrepareTask.kt */
final class ChannelPrepareTask$tryGetKernelCache$1 extends Lambda implements Function1<IMessenger, IKernelPlayer> {
    final /* synthetic */ ChannelPrepareTask this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelPrepareTask$tryGetKernelCache$1(ChannelPrepareTask channelPrepareTask) {
        super(1);
        this.this$0 = channelPrepareTask;
    }

    public final IKernelPlayer invoke(IMessenger messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        return new DumediaCallback(this.this$0.getPrebootInfo(), messenger);
    }
}
