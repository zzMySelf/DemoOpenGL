package com.baidu.searchbox.hissug.util;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/account/BoxAccountManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginUtils.kt */
final class LoginUtils$boxAccountManager$2 extends Lambda implements Function0<BoxAccountManager> {
    public static final LoginUtils$boxAccountManager$2 INSTANCE = new LoginUtils$boxAccountManager$2();

    LoginUtils$boxAccountManager$2() {
        super(0);
    }

    public final BoxAccountManager invoke() {
        return (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
    }
}
