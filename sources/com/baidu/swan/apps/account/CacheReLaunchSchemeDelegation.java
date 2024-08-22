package com.baidu.swan.apps.account;

import android.os.Bundle;
import com.baidu.swan.apps.process.delegate.delegation.SwanAppMessengerDelegation;

public class CacheReLaunchSchemeDelegation extends SwanAppMessengerDelegation {
    public static final String KEY_SCHEME = "key_scheme";

    public void execCall(Bundle params) {
        SwanAppAccount.cacheReLaunchScheme(params.getString(KEY_SCHEME));
        finish();
    }
}
