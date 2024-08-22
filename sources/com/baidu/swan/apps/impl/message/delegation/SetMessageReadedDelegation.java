package com.baidu.swan.apps.impl.message.delegation;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.newtips.MsgUnReadCountManager;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.impl.message.SwanAppMessageUtils;

public class SetMessageReadedDelegation extends ProviderDelegation {
    public Bundle execCall(Bundle params) {
        if (params == null) {
            return null;
        }
        String data = params.getString(SwanAppMessageUtils.KEY_UNREAD_MESSAGE_PARAMS);
        if (TextUtils.isEmpty(data)) {
            return null;
        }
        MsgUnReadCountManager.setAllReadAndRefreshUnRead(data);
        return null;
    }
}
