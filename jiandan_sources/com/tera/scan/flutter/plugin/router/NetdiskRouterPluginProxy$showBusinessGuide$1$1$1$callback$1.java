package com.tera.scan.flutter.plugin.router;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NetdiskRouterPluginProxy$showBusinessGuide$1$1$1$callback$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ String $res;
    public final /* synthetic */ MethodChannel.Result $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetdiskRouterPluginProxy$showBusinessGuide$1$1$1$callback$1(MethodChannel.Result result, String str) {
        super(0);
        this.$result = result;
        this.$res = str;
    }

    public final void invoke() {
        this.$result.success(this.$res);
    }
}
