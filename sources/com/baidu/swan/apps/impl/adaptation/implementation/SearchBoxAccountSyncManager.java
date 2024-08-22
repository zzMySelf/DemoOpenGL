package com.baidu.swan.apps.impl.adaptation.implementation;

import android.content.Context;
import com.baidu.swan.apps.adaptation.interfaces.IAccountSyncManager;
import com.baidu.swan.apps.impl.account.SwanAppCookieUtils;

public class SearchBoxAccountSyncManager implements IAccountSyncManager {
    public void syncLoginStatus(Context context) {
        SwanAppCookieUtils.syncCookieAnyProcess(context);
    }
}
