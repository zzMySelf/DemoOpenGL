package com.baidu.searchbox.paywall.net;

import com.baidu.searchbox.paywall.net.PaywallWebApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallWebApi.kt */
final class PaywallWebApi$Companion$isInShelf$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ PaywallWebApi.Callback<Boolean> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaywallWebApi$Companion$isInShelf$1(PaywallWebApi.Callback<Boolean> callback) {
        super(1);
        this.$callback = callback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean it) {
        PaywallWebApi.Callback<Boolean> callback = this.$callback;
        if (callback != null) {
            callback.onSuccess(Boolean.valueOf(it));
        }
    }
}
