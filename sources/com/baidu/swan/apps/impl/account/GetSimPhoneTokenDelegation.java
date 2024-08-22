package com.baidu.swan.apps.impl.account;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.impl.account.actions.SwanAppGetSimInfoApi;
import com.baidu.swan.apps.process.delegate.delegation.SwanAppMessengerDelegation;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public class GetSimPhoneTokenDelegation extends SwanAppMessengerDelegation {
    public static final String DELEGATION_RESULT = "delegation_result";

    public void execCall(Bundle params) {
        String scene = params.getString("scene");
        if (TextUtils.isEmpty(scene)) {
            scene = "baidu_mini_programs";
        }
        SwanAppGetSimInfoApi.getSimPhoneTokenMainProcess(scene, new TypedCallback<Bundle>() {
            public void onCallback(Bundle bundle) {
                GetSimPhoneTokenDelegation.this.result.putBundle(GetSimPhoneTokenDelegation.DELEGATION_RESULT, bundle);
                GetSimPhoneTokenDelegation.this.finish();
            }
        });
    }
}
