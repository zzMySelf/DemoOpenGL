package com.baidu.swan.apps.impl.account;

import com.baidu.searchbox.Router;
import com.baidu.swan.apps.ipc.delegate.SwanActivityDelegation;
import com.baidu.swan.apps.util.SwanAppIntentUtils;

public class DispatchSchemeWithFinishDelegation extends SwanActivityDelegation {
    public static final String PARAM_RESULT = "param_result";
    public static final String PARAM_SCHEME = "param_scheme";

    /* access modifiers changed from: protected */
    public boolean onExec() {
        if (!isLegal()) {
            return true;
        }
        this.mResult.putBoolean(PARAM_RESULT, Router.invoke(getAgent(), SwanAppIntentUtils.safeGetString(this.mParams, PARAM_SCHEME)));
        finish();
        return false;
    }
}
