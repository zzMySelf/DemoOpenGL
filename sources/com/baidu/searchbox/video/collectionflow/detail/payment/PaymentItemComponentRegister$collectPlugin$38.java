package com.baidu.searchbox.video.collectionflow.detail.payment;

import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentItemComponentRegister.kt */
final class PaymentItemComponentRegister$collectPlugin$38 extends Lambda implements Function0<IPlugin> {
    public static final PaymentItemComponentRegister$collectPlugin$38 INSTANCE = new PaymentItemComponentRegister$collectPlugin$38();

    PaymentItemComponentRegister$collectPlugin$38() {
        super(0);
    }

    public final IPlugin invoke() {
        return SandwichPortraitTimeUnit.INSTANCE.createPlugin();
    }
}
