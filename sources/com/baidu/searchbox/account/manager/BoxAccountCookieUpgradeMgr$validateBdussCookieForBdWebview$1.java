package com.baidu.searchbox.account.manager;

import com.baidu.android.app.account.BoxSapiAccountManager;
import com.baidu.android.app.account.IWebKitInstallCallback;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/account/manager/BoxAccountCookieUpgradeMgr$validateBdussCookieForBdWebview$1", "Lcom/baidu/android/app/account/IWebKitInstallCallback;", "onWebKitInstalled", "", "isZeusProvider", "", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxAccountCookieUpgradeMgr.kt */
public final class BoxAccountCookieUpgradeMgr$validateBdussCookieForBdWebview$1 implements IWebKitInstallCallback {
    BoxAccountCookieUpgradeMgr$validateBdussCookieForBdWebview$1() {
    }

    public void onWebKitInstalled(boolean isZeusProvider) {
        if (isZeusProvider) {
            ((BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getCookieSession().clearBdussIfNeedAsync();
        }
    }
}
