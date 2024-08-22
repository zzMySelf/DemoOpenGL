package com.baidu.searchbox.servicecenter.container;

import com.baidu.searchbox.servicecenter.talos.ServiceCenterTLSPageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ServiceCenterContainer.kt */
final class ServiceCenterContainer$onCreateView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ServiceCenterContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceCenterContainer$onCreateView$1(ServiceCenterContainer serviceCenterContainer) {
        super(0);
        this.this$0 = serviceCenterContainer;
    }

    public final void invoke() {
        ServiceCenterTLSPageView access$getTalosView$p = this.this$0.talosView;
        if (access$getTalosView$p != null) {
            access$getTalosView$p.dismissLoading();
        }
    }
}
