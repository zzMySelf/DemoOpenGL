package com.baidu.searchbox.live.imp;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/account/BoxAccountManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountManagerServiceImpl.kt */
final class AccountManagerServiceImpl$accountManager$2 extends Lambda implements Function0<BoxAccountManager> {
    public static final AccountManagerServiceImpl$accountManager$2 INSTANCE = new AccountManagerServiceImpl$accountManager$2();

    AccountManagerServiceImpl$accountManager$2() {
        super(0);
    }

    public final BoxAccountManager invoke() {
        Object service = ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (service != null) {
            return (BoxAccountManager) service;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.account.BoxAccountManager");
    }
}
