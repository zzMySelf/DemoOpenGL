package com.tera.scan.flutter.plugin.commerce;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "success", "", "freeCount", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CommerceChannelPluginProxy$consumeOnceUsePrivilege$1$1 extends Lambda implements Function2<Boolean, Integer, Unit> {
    public final /* synthetic */ MethodChannel.Result $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommerceChannelPluginProxy$consumeOnceUsePrivilege$1$1(MethodChannel.Result result) {
        super(2);
        this.$result = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, int i2) {
        this.$result.success(Boolean.valueOf(z));
    }
}
