package com.baidu.searchbox.live.imp;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtLiveJumpPageServiceImpl.kt */
final class ExtLiveJumpPageServiceImpl$accountManager$2 extends Lambda implements Function0<AccountManagerService> {
    public static final ExtLiveJumpPageServiceImpl$accountManager$2 INSTANCE = new ExtLiveJumpPageServiceImpl$accountManager$2();

    ExtLiveJumpPageServiceImpl$accountManager$2() {
        super(0);
    }

    public final AccountManagerService invoke() {
        return (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
    }
}
