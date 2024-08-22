package com.baidu.searchbox.video.channel.flow.detail.payment;

import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.video.feedflow.detail.payment.autoplay.PaymentAutoPlayInterceptPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelPaymentItemComponentRegister.kt */
final class ChannelPaymentItemComponentRegister$collectPlugin$28 extends Lambda implements Function0<IPlugin> {
    public static final ChannelPaymentItemComponentRegister$collectPlugin$28 INSTANCE = new ChannelPaymentItemComponentRegister$collectPlugin$28();

    ChannelPaymentItemComponentRegister$collectPlugin$28() {
        super(0);
    }

    public final IPlugin invoke() {
        return new PaymentAutoPlayInterceptPlugin();
    }
}
