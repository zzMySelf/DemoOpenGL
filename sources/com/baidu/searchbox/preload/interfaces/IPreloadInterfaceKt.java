package com.baidu.searchbox.preload.interfaces;

import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"PRELOAD_SERVICE_NAME", "", "PRELOAD_SERVICE_NAMESPACE", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "setSERVICE_REFERENCE", "(Lcom/baidu/pyramid/runtime/service/ServiceReference;)V", "lib-preload-interface_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPreloadInterface.kt */
public final class IPreloadInterfaceKt {
    public static final String PRELOAD_SERVICE_NAME = "interface";
    public static final String PRELOAD_SERVICE_NAMESPACE = "preload";
    private static ServiceReference SERVICE_REFERENCE = new ServiceReference("preload", PRELOAD_SERVICE_NAME);

    public static final ServiceReference getSERVICE_REFERENCE() {
        return SERVICE_REFERENCE;
    }

    public static final void setSERVICE_REFERENCE(ServiceReference serviceReference) {
        Intrinsics.checkNotNullParameter(serviceReference, "<set-?>");
        SERVICE_REFERENCE = serviceReference;
    }
}
