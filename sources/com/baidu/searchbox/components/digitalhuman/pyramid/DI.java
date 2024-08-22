package com.baidu.searchbox.components.digitalhuman.pyramid;

import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/components/digitalhuman/pyramid/DI;", "", "()V", "APP_INFO_NAME", "", "MODULE_NAME", "NET_NAME", "YALOG_NAME", "getServiceRef", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "name", "digital-human-service-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DI.kt */
public final class DI {
    public static final String APP_INFO_NAME = "appInfo";
    public static final DI INSTANCE = new DI();
    public static final String MODULE_NAME = "digital_human";
    public static final String NET_NAME = "net";
    public static final String YALOG_NAME = "yalog";

    private DI() {
    }

    public final ServiceReference getServiceRef(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ServiceReference(MODULE_NAME, name);
    }
}
