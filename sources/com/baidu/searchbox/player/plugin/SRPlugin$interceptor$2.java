package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.player.plugin.SRPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/player/plugin/SRPlugin$SRInterceptor;", "Lcom/baidu/searchbox/player/plugin/SRPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SRPlugin.kt */
final class SRPlugin$interceptor$2 extends Lambda implements Function0<SRPlugin.SRInterceptor> {
    final /* synthetic */ SRPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SRPlugin$interceptor$2(SRPlugin sRPlugin) {
        super(0);
        this.this$0 = sRPlugin;
    }

    public final SRPlugin.SRInterceptor invoke() {
        return new SRPlugin.SRInterceptor();
    }
}
