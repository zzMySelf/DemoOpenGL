package com.tera.scan.main.service;

import fe.mmm.qw.ggg.ad.de;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/libanalytics/activation/ActivationService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ServiceManager$mActiveService$2 extends Lambda implements Function0<de> {
    public final /* synthetic */ fe.mmm.qw.a.yj.qw.de $scheduler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceManager$mActiveService$2(fe.mmm.qw.a.yj.qw.de deVar) {
        super(0);
        this.$scheduler = deVar;
    }

    @NotNull
    public final de invoke() {
        return new de(this.$scheduler);
    }
}
