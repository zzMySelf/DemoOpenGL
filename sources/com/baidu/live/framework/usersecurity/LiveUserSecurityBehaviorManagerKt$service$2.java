package com.baidu.live.framework.usersecurity;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityBehaviorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityBehaviorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveUserSecurityBehaviorManager.kt */
final class LiveUserSecurityBehaviorManagerKt$service$2 extends Lambda implements Function0<LiveUserSecurityBehaviorService> {
    public static final LiveUserSecurityBehaviorManagerKt$service$2 INSTANCE = new LiveUserSecurityBehaviorManagerKt$service$2();

    LiveUserSecurityBehaviorManagerKt$service$2() {
        super(0);
    }

    public final LiveUserSecurityBehaviorService invoke() {
        return (LiveUserSecurityBehaviorService) ServiceManager.getService(LiveUserSecurityBehaviorService.Companion.getSERVICE_REFERENCE());
    }
}
