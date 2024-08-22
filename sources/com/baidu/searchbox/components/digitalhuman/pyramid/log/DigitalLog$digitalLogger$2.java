package com.baidu.searchbox.components.digitalhuman.pyramid.log;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.components.digitalhuman.pyramid.DigitalYalogService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/components/digitalhuman/pyramid/DigitalYalogService$DigitalLogger;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DigitalLog.kt */
final class DigitalLog$digitalLogger$2 extends Lambda implements Function0<DigitalYalogService.DigitalLogger> {
    public static final DigitalLog$digitalLogger$2 INSTANCE = new DigitalLog$digitalLogger$2();

    DigitalLog$digitalLogger$2() {
        super(0);
    }

    public final DigitalYalogService.DigitalLogger invoke() {
        DigitalYalogService digitalYalogService = (DigitalYalogService) ServiceManager.getService(DigitalYalogService.Companion.getSERVICE_REFERENCE());
        if (digitalYalogService != null) {
            return digitalYalogService.getLogger(DigitalLogSpace.DIGITAL_DIGITAL);
        }
        return null;
    }
}
