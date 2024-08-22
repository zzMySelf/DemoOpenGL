package com.baidu.searchbox.bigimage.sdm;

import com.baidu.searchbox.bigimage.channel.IMessageChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SDMImageContainer.kt */
final class SDMImageContainer$contentView$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SDMImageContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SDMImageContainer$contentView$4(SDMImageContainer sDMImageContainer) {
        super(0);
        this.this$0 = sDMImageContainer;
    }

    public final void invoke() {
        IMessageChannel access$getMessageChannel = this.this$0.getMessageChannel();
        if (access$getMessageChannel != null) {
            IMessageChannel.DefaultImpls.onPageClose$default(access$getMessageChannel, this.this$0.getCurrPos(), (Integer) null, (Map) null, 6, (Object) null);
        }
        this.this$0.closeSelf();
    }
}
