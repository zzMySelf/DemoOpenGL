package com.baidu.swan.apps.impl.account;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.process.delegate.delegation.SwanAppMessengerDelegation;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public class GetStokenMessengerDelegation extends SwanAppMessengerDelegation {
    public static final String KEY_PARAM_TPL_LIST = "key_param_tpl_list";
    public static final String KEY_RESULT_STOKENT = "key_result_stokent";

    public void execCall(Bundle params) {
        String[] tpl = params.getStringArray("key_param_tpl_list");
        if (tpl == null || tpl.length < 1) {
            finish();
        } else {
            AccountUtils.getTplStokenInMainProcess(AppRuntime.getAppContext(), new TypedCallback<Bundle>() {
                public void onCallback(Bundle stoken) {
                    GetStokenMessengerDelegation.this.result.putBundle("key_result_stokent", stoken);
                    GetStokenMessengerDelegation.this.finish();
                }
            }, tpl);
        }
    }
}
