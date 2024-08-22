package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.ILivePlayEtnService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayEtnService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: LivePlayUrlServiceImpl.kt */
final class LivePlayUrlServiceImpl$etnService$2 extends Lambda implements Function0<ILivePlayEtnService> {
    public static final LivePlayUrlServiceImpl$etnService$2 INSTANCE = new LivePlayUrlServiceImpl$etnService$2();

    LivePlayUrlServiceImpl$etnService$2() {
        super(0);
    }

    public final ILivePlayEtnService invoke() {
        return (ILivePlayEtnService) ServiceManager.getService(ILivePlayEtnService.Companion.getSERVICE_REFERENCE());
    }
}
