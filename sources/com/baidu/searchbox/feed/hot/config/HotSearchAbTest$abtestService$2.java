package com.baidu.searchbox.feed.hot.config;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.ioc.AbTestService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/abtest/ioc/AbTestService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotSearchAbTest.kt */
final class HotSearchAbTest$abtestService$2 extends Lambda implements Function0<AbTestService> {
    public static final HotSearchAbTest$abtestService$2 INSTANCE = new HotSearchAbTest$abtestService$2();

    HotSearchAbTest$abtestService$2() {
        super(0);
    }

    public final AbTestService invoke() {
        return (AbTestService) ServiceManager.getService(AbTestService.SERVICE_REFERENCE);
    }
}
